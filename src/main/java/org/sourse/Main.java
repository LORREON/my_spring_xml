package org.sourse;

import org.sourse.annotationConfig.AppConfig;
import org.sourse.beans.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.scan("org.sourse");
        ctx.refresh();

        App app = (App) ctx.getBean("app");


        Client client = ctx.getBean(Client.class);
        System.out.println("Client says: " + client.getGreeting());

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "User: 1 - Event_1");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "User: 1 - Event_2");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "User: 1 - Event_3");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "User: 1 - Event_4");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "User: 1 - Event_5");


        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "User: 1 - Event_combine");

        event = ctx.getBean(Event.class);
        app.logEvent(null, event, "User: 1 - Event_console");

        ctx.close();
    }
}
