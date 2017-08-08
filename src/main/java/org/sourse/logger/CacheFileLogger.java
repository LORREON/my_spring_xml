package org.sourse.logger;

import org.sourse.beans.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
public class CacheFileLogger extends FileEventLogger {

    @Value("${countLog}")
    private int cacheSize;
    private List<Event> cache;


    @PostConstruct
    public void initCache() {
        this.cache = new ArrayList<Event>(cacheSize);
    }


    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }

    }

    private void writeEventsFromCache() {
        cache.stream().forEach(super::logEvent);
    }


    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void setCache(List<Event> cache) {
        this.cache = cache;
    }
}
