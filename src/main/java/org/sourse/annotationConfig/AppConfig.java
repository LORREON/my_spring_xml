package org.sourse.annotationConfig;

import org.sourse.beans.Client;
import org.sourse.beans.EventType;
import org.sourse.logger.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.util.*;

@Configuration
@PropertySource("classpath:client.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public Date nowDate() {
        return new java.util.Date();
    }


    @Resource(name = "logger")
    private ConsoleEventLogger consoleEventLogger;


    @Resource(name = "fileLogger")
    private EventLogger fileEventLogger;

    @Resource(name = "combinedEventLogger")
    private EventLogger combinedEventLogger;

    @Resource(name = "cacheFileLogger")
    private EventLogger cacheFileLogger;


    @Bean
    public Map<EventType, EventLogger> loggerMap() {
        EnumMap<EventType, EventLogger> map = new EnumMap<EventType, EventLogger>(EventType.class);
        map.put(EventType.ERROR, combinedEventLogger);
        map.put(EventType.INFO, cacheFileLogger);
        return map;
    }

    @Bean
    public Collection<EventLogger> eventLoggerCollection() {
        Collection<EventLogger> list = new ArrayList<>();
        list.add(fileEventLogger);
        list.add(consoleEventLogger);
        return list;
    }

    @Bean
    public Client client() {
        Client client = new Client();
        client.setId(environment.getRequiredProperty("id"));
        client.setName(environment.getRequiredProperty("name"));

        return client;
    }
}
