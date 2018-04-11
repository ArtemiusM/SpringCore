package com.epam.spring;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("cacheFileEventLogger")
public class CacheFileEventLogger extends FileEventLogger {

    int cacheSize;
    List<Event> cache = new ArrayList<>();

    @Autowired
    public CacheFileEventLogger(@Value("EventLog.txt") String filename, @Value("3") int cacheSize) {
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

    @PreDestroy
    public void destroy() {
        if ( !cache.isEmpty() )
            writeEventsFromCache();
    }
}