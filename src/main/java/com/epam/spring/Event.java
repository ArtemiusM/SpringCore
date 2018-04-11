package com.epam.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

@Component("event")
@Scope("prototype")

public class Event {

    int id;
    String msg;
    Date date;
    DateFormat df;

    @Autowired
    public Event(@Value("#{new java.util.Date()}")Date date, @Qualifier("dateFormat") DateFormat df){
        this.date = date;
        this.df = df;
        this.id = (int) (Math.random()*1000000);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return (id + " " + msg + " " + df.format(date) +"\n");
    }

}
