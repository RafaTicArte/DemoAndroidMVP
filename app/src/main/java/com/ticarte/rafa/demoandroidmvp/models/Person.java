package com.ticarte.rafa.demoandroidmvp.models;

public class Person {

    private String user;
    private String pass;
    private String fullname;

    public Person (String user, String pass, String fullname) {
        this.user = user;
        this.pass = pass;
        this.fullname = fullname;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getFullname() {
        return fullname;
    }
}
