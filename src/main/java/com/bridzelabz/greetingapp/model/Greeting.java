package com.bridzelabz.greetingapp.model;

public class Greeting {
    final long id;
    final String format;

    public long getId() {
        return id;
    }

    public String getFormat() {
        return format;
    }

    public Greeting(long id, String format) {
        this.id=id;
        this.format=format;
    }
}
