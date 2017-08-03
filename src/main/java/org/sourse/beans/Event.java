package org.sourse.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

@Component
@Scope("prototype")
public class Event {

    private int id;
    private String msg;

    //@Resource(name = "dateFormat")
    @Resource(name = "newDate")
    private Date date;
    @Resource(name = "dateFormat")
    private DateFormat dateFormat;

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
