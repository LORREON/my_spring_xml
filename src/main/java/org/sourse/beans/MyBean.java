package org.sourse.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {

    @Value("Hello World!")
    private String str;

    public void printMsg(){
        System.out.println(str);
    }

    public void setStr(String str) {
        this.str = str;
    }
}
