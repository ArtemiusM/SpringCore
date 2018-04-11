package com.epam.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

@Component("combinedEventLogger")
public class CombinedEventLogger implements EventLogger {

    ArrayList<EventLogger> loggers;

    @Autowired
    public CombinedEventLogger( @Qualifier("loggersList") ArrayList<EventLogger> loggers){
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger l: loggers){
            l.logEvent(event);
        }
    }
}

