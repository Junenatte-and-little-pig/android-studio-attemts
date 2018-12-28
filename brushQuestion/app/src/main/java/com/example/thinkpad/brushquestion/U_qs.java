package com.example.thinkpad.brushquestion;

import org.litepal.crud.LitePalSupport;

public class U_qs extends LitePalSupport {
    private String username;
    private String wrongs="";

    public String getUsername() {
        return username;
    }

    public String[] getWrongs() {
        return wrongs.split("|");
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setWrongs(String wrongs) {
        this.wrongs +="|"+wrongs;
    }
}
