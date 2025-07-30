package com.demo.comentoStatistic.dto;

public class YearCountDto {
    private String year;      // concat('20', #{year}) 결과
    private int totCnt;       // count(*) 결과

    // 기본 생성자 (MyBatis는 기본 생성자 필요)
    public YearCountDto() {}

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getTotCnt() {
        return totCnt;
    }

    public void setTotCnt(int totCnt) {
        this.totCnt = totCnt;
    }
}
