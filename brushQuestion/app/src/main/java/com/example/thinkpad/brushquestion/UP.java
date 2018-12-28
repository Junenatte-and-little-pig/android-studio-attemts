package com.example.thinkpad.brushquestion;

import org.litepal.crud.LitePalSupport;

public class UP extends LitePalSupport {
    private String username="";
    private String password="";

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
