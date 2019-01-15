package com.example.sam.ejemplologin;

public class User {

    private String username, password, mail;

    public User() {}

    public User(String user, String pass, String mail) {
        this.username = user;
        this.password = pass;
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
