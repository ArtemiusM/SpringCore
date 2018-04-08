package com.epam.spring;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    int cacheSize;
    List<Event> cache = new ArrayList<>();

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
    }

    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    public void writeEventsFromCache(){
        for (Event e: cache){
            try {
                FileUtils.writeStringToFile(file,e.toString(),true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void destroy() {
        if ( !cache.isEmpty() )
            writeEventsFromCache();
    }
}