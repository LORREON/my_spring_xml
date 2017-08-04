package org.sourse.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("myBean")
public class MyBean {

    @Value("Hello World!")
    private String str;

    public void printMsg() {
        System.out.println(str);
    }

    @PostConstruct
    public void init() {
        System.out.println("Hello World!");
    }

    @PreDestroy

    public void destroy() {
        System.out.println("Goodbye!");
    }

    public void setStr(String str) {
        this.str = str;
    }
}
