package org.logger;

import java.io.File;
import java.io.IOException;

import org.beans.Event;
import org.apache.commons.io.FileUtils;



public class FileEventLogger implements EventLogger {

    private File file;
    private String filename;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

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

}
