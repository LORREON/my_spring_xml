package org.sourse.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;

@Component
@Scope("prototype")
public class Event {

    private int id;
    private String msg;

    @Autowired
    @Qualifier("nowDate")
    private Date date;

    @Value("#{T(java.text.DateFormat).getDateInstance()}")
    private DateFormat dateFormat;

    public static boolean isDay(int h1, int h2) {
        LocalTime time = LocalTime.now();
        return time.getHour() > h1 && time.getHour() < h2;
    }

    public Event() {
        this.id = 0 + (int) (Math.random() * 1000);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }

}
