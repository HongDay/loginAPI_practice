package com.demo.comentoStatistic.dto;

public class DepMonthDto {
    private String dep;
    private String loginMonth;
    private int totCnt;

    public DepMonthDto() {}

    public String getDep() {return dep;}
    public void setDep(String dep) {this.dep = dep;}

    public String getLoginMonth() {return loginMonth;}
    public void setLoginMonth(String loginMonth) {this.loginMonth = loginMonth;}

    public int getTotCnt() {return totCnt;}
    public void setTotCnt(int totCnt) {this.totCnt = totCnt;}
}
