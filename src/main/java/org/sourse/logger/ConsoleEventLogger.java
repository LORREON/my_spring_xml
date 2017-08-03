package org.sourse.logger;

import org.sourse.beans.Event;
import org.springframework.stereotype.Component;

@Component("logger")
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event){
        System.out.println(event.toString());
    }
}
