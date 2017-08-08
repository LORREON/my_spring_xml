package org.sourse.beans;

import org.springframework.beans.factory.annotation.Value;

public class Client {

    private String id;
    private String name;
    @Value("Hi #{systemProperties['user.name']}")
    private String greeting;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
