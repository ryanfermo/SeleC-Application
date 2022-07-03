package com.ryanfermo.voterregistrationapp;

public class User {

    public String fullname, number, email, password, course;
    public User(){

    }


    public User (String fullname, String number, String email, String password, String course){
        this.fullname = fullname;
        this.number = number;
        this.email = email;
        this.course =course;
        this.password=password;
    }
}
