package com.demo.comentoStatistic.dto;

public class DayCountDto {
    private String loginDate;
    private int userCnt;

    public DayCountDto() {}

    public String getLoginDate() {return loginDate;}

    public void setLoginDate(String loginDate) {this.loginDate = loginDate;}

    public int getUserCnt() {return userCnt;}

    public void setUserCnt(int userCnt) {this.userCnt = userCnt;}
}
