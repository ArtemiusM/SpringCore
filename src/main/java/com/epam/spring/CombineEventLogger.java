package com.epam.spring;

import java.util.ArrayList;

public class CombineEventLogger implements EventLogger {

    ArrayList<EventLogger> loggers;

    public CombineEventLogger (ArrayList<EventLogger> loggers){
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger l: loggers){
            l.logEvent(event);
        }
    }
}

