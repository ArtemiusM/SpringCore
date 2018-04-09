package com.epam.spring;

import java.util.ArrayList;

public class CombinedEventLogger implements EventLogger {

    ArrayList<EventLogger> loggers;

    public CombinedEventLogger(ArrayList<EventLogger> loggers){
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger l: loggers){
            l.logEvent(event);
        }
    }
}

