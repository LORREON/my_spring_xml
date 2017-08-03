package org.sourse.logger;

import org.sourse.beans.Event;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.Collection;

@Component
public class CombinedEventLogger implements EventLogger {

    @Resource(name = "eventLoggerCollection")
    private Collection<EventLogger> loggers;


    @Override
    public void logEvent(Event event) {

        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
