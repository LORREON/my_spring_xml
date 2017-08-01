package org.beans;

import org.logger.EventLogger;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger logger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = logger;
        this.loggers = loggers;
    }

    public void logEvent(EventType type, Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getName());
        event.setMsg(message);

        EventLogger logger = loggers.get(type);
        if(logger == null){
            logger = this.defaultLogger;
        }
        logger.logEvent(event);
    }

}
