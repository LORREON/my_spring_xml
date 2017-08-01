package org.logger;

import org.beans.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache;

    public CacheFileLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>(cacheSize);
    }


    public CacheFileLogger(String filename) {
        super(filename);
    }

    public void destroy(){
        if(!cache.isEmpty()){
            writeEventsFromCache();
        }
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }

    }

    private void writeEventsFromCache() {
        cache.stream().forEach(super::logEvent);
    }
}
