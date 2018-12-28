package com.example.thinkpad.brushquestion;

import org.litepal.crud.LitePalSupport;

public class U_info extends LitePalSupport {
    private String username;
    private String nickname;
    private int sex;
    private String year;
    private String month;
    private String day;

    String getUsername() {
        return username;
    }

    String getNickname() {
        return nickname;
    }

    String getSex() {
        if(sex==1)
            return "男";
        else if(sex==0)
            return "女";
        return "秘密~";
    }

    public String getYear() {
        return year;
    }

    String getMonth() {
        return month;
    }

    String getDay() {
        return day;
    }

    void setUsername(String username) {
        this.username = username;
    }

    void setNickname(String nickname) {
        this.nickname = nickname;
    }

    void setSex(int sex) {
        this.sex =sex;
    }

    void setYear(String year) {
        this.year = year;
    }

    void setMonth(String month) {
        this.month = month;
    }

    void setDay(String day) {
        this.day = day;
    }
}
