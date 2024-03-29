package com.bridzelabz.greetingapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GREETINGMESSAGE")
public class MessageGreet {

    @Id
    private  long id;

    public void setId(long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private  String message;

    public MessageGreet() {
        id=0;
        message="";
    }

    public MessageGreet(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
