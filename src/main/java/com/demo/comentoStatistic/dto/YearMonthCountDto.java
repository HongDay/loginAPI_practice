package com.demo.comentoStatistic.dto;

public class YearMonthCountDto {
    private String yearMonth;
    private int totCnt;

    // 기본 생성자 (MyBatis는 기본 생성자 필요)
    public YearMonthCountDto() {}

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public int getTotCnt() {
        return totCnt;
    }

    public void setTotCnt(int totCnt) {
        this.totCnt = totCnt;
    }
}
