package com.demo.comentoStatistic.service;

import com.demo.comentoStatistic.dao.StatisticMapper;
import com.demo.comentoStatistic.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {


    @Autowired
    StatisticMapper statisticMapper;

    public YearCountDto getYearLogins(String year){

        return statisticMapper.selectYearLogin(year);
    }

    public YearMonthCountDto getYearMonthLogins(String year, String month){

        return statisticMapper.selectYearMonthLogin("20"+year+"-"+month);
    }

    public List<MonthCountDto> getMonthLogins(){
        return statisticMapper.selectMonthLogin();
    }

    public List<DayCountDto> getDayLogins(){
        return statisticMapper.selectDayLogin();
    }

    public AvgDayDto getAvgDayLogins(){
        return statisticMapper.selectAvgDayLogin();
    }

    public List<DepMonthDto> getDepMonthLogins(){
        return statisticMapper.selectDepMonthLogin();
    }

}