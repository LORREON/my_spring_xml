package org.beans;


import java.text.DateFormat;
import java.util.Date;


public class Event {

    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat df ) {
        this.id = 0 + (int) (Math.random() * 1000);
        this.date = date;
        this.dateFormat = df;
    }

    public Event() {
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
