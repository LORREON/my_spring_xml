package org.sourse.logger;

import java.io.File;
import java.io.IOException;

import org.sourse.beans.Event;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component("fileLogger")
public class FileEventLogger implements EventLogger {

    private File file;

    @Value("${pathLoggerC}")
    private String filename;

    public FileEventLogger() {
    }

    @PostConstruct
    public void init() {
        file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (Exception e) {
                System.out.println(file.getAbsolutePath());
                throw new IllegalArgumentException("Can't create file", e);
            }
        } else if (!file.canWrite()) {
            throw new IllegalArgumentException("Can't write to file " + filename);
        }
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString()+"\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}