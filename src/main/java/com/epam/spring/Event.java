package com.epam.spring;

import java.text.DateFormat;
import java.util.Date;

public class Event {

    int id;
    String msg;
    Date date;
    DateFormat df;

    public Event(Date date,DateFormat df){
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
