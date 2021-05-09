package com.bridzelabz.greetingapp.model;

public class User {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        String str =(firstName != null) ? firstName + " ": " ";
        str += (lastName != null) ? lastName : " ";
        return str.trim();

    }
}
