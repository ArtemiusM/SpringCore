package com.epam.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    Client client;
    EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger){
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
        App app = (App) ctx.getBean("app");
        Event event = (Event) ctx.getBean("event");
        event.setMsg("Event 1 Created!");
        app.logEvent(event);
        ctx.close();

    }

    private void logEvent(Event event) {
//        String message = msg.replaceAll(client.getId(), client.getFullname());
//        eventLogger.logEvent(message);
        eventLogger.logEvent(event);
    }
}

