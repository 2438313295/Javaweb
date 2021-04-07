package com.ml.entity;
//实体类 是对数据表的一种映射
public class Signon {
    String username;
    String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username +"\t"+ password;
    }

    public Signon(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Signon() {
        super();
    }
}
