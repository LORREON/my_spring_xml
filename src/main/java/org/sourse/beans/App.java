package org.sourse.beans;

import org.sourse.logger.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class App {

    @Autowired
    private Client client;
    @Resource(name = "logger")
    private EventLogger defaultLogger;
    @Resource(name = "loggerMap")
    private Map<EventType, EventLogger> loggers;


    public void logEvent(EventType type, Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getName());
        event.setMsg(message);

        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = this.defaultLogger;
        }
        logger.logEvent(event);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDefaultLogger(EventLogger defaultLogger) {
        this.defaultLogger = defaultLogger;
    }

    public void setLoggers(Map<EventType, EventLogger> loggers) {
        this.loggers = loggers;
    }
}
