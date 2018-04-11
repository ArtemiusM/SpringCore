package com.epam.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component("app")
public class App {

    @Autowired @Qualifier("client")
    Client client;
    @Autowired @Qualifier("cacheFileEventLogger")
    EventLogger eventLogger;
    EventLogger defaultLogger;
    @Resource(name="loggerMap")
    Map<EventType, EventLogger> loggers;

    public  App(){
    }

    public App( Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers){
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
        App app = (App) ctx.getBean("app");
        Event event = (Event) ctx.getBean("event");
        event.setMsg("Event 1 Created!");
        app.logEvent(event,EventType.ERROR);

        event = (Event) ctx.getBean("event");
        event.setMsg("Event 2 Created!");
        app.logEvent(event,EventType.INFO);

        event = (Event) ctx.getBean("event");
        event.setMsg("Event 3 Created!");
        app.logEvent(event,EventType.INFO);

        event = (Event) ctx.getBean("event");
        event.setMsg("Event 4 Created!");
        app.logEvent(event,EventType.ERROR);

        ctx.close();
    }

    private void logEvent(Event event, EventType type) {
//        String message = msg.replaceAll(client.getId(), client.getFullname());
//        eventLogger.logEvent(message);
        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = defaultLogger=eventLogger;
        }
        logger.logEvent(event);

    }
}

