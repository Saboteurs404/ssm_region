package com.xlh.entity;

public class Userinfo {
    private Integer id;

    private byte[] username;

    private byte[] password;

    private byte[] userinfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getUsername() {
        return username;
    }

    public void setUsername(byte[] username) {
        this.username = username;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public byte[] getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(byte[] userinfo) {
        this.userinfo = userinfo;
    }
}