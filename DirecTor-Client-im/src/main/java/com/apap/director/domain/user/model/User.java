package com.apap.director.domain.user.model;


public class User {
    private String id;
    private String host;
    private String password;

    public User(String id, String host, String password) {
        this.id = id;
        this.host = host;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getHost() {
        return host;
    }

    public String getPassword() {
        return password;
    }

}

