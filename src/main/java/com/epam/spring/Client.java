package com.epam.spring;

public class Client {
    String id;
    String fullname;

    public Client(){
    }

    public Client(String id, String fullname){
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
}