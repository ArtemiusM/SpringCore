package com.epam.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("client")

public class Client {

    String id;
    String fullname;
    String greeting;

    @Autowired
    public Client( @Value("${id}") String id, @Value("${name}") String fullname){
        this.id = id;
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public String getId() {
        return id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Value("${greeting}")
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}