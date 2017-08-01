package org;

import org.beans.App;
import org.beans.Client;
import org.beans.Event;
import org.beans.EventType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        Client client = ctx.getBean(Client.class);
        System.out.println("Client says: " + client.getGreeting());

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "User: 1 - Event_first");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "User: 1 - Event_second");

        event = ctx.getBean(Event.class);
        app.logEvent(null, event, "User: 1 - Event_third");

        ctx.close();

    }
}
