package org.logger;

import org.beans.Event;


import java.util.Collection;

public class CombinedEventLogger implements EventLogger {

    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection c) {
        this.loggers = c;
    }


    @Override
    public void logEvent(Event event) {

        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
