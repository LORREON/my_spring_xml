package org.sourse.logger;

import org.sourse.beans.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
public class CacheFileLogger extends FileEventLogger {

    @Value("${countLog}")
    private int cacheSize;
    @Value("${pathLoggerF}")
    private String fileName;

    private List<Event> cache;

    public CacheFileLogger() {
        super.setFilename(fileName);
        this.cache = new ArrayList<Event>(cacheSize);
    }

    @PreDestroy
    public void destroy() {
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
