package com.bridzelabz.greetingapp.model;

public class Greeting {
     long id;
     String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Greeting(long id, String name) {
        this.id=id;
        this.name=name;
    }
}
