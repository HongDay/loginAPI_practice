package com.demo.comentoStatistic.dto;

public class MonthCountDto {
    private String loginMonth;
    private int userCnt;

    public MonthCountDto() {}

    public String getLoginMonth() {
        return loginMonth;
    }

    public void setLoginMonth(String loginMonth) {
        this.loginMonth = loginMonth;
    }

    public int getUserCnt() {
        return userCnt;
    }

    public void setUserCnt(int userCnt) {
        this.userCnt = userCnt;
    }
}
