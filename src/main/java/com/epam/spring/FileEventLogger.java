package com.epam.spring;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileEventLogger implements EventLogger{

    String filename;
    File file;

    protected FileEventLogger(String filename){
        this.filename = filename;
        this.file = new File(this.getClass().getResource("/").getPath() + filename);
        createEventLogFile(file);
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file,event.toString(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException {
        // check file write access
        if(!file.canWrite()){
            throw new IOException("File : " + filename + " Cannot be WRITTEN!!!");
        }
    }

    private void createEventLogFile(File file){
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
