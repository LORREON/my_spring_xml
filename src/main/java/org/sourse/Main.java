package org.sourse;

import org.sourse.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        MyBean bean = (MyBean) ctx.getBean("myBean");
        bean.printMsg();

        Client client = ctx.getBean(Client.class);
        System.out.println("Client says: " + client.getGreeting());

        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "User: 1 - Event_first");

        event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "User: 1 - Event_second");

        event = ctx.getBean(Event.class);
        app.logEvent(null, event, "User: 1 - Event_third");



    }
}
