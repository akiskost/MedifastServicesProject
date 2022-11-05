package com.test.medifastservices.model;

public class User {

    private int uid;
    private String email;
    private String password;
    private String userFirstName;
    private String userLastName;

    public User(){};

    public User(int uid, String email, String password, String userFirstName, String userLastName) {
        this.uid = uid;
        this.email = email;
        this.password = password;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }
}
