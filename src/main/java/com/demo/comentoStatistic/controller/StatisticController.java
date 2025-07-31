package com.demo.comentoStatistic.controller;

import com.demo.comentoStatistic.dto.*;
import com.demo.comentoStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StatisticController {

    @Autowired
    StatisticService statisticService;


    @RequestMapping(value="/api/v1/logins/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearCountDto> getYearLoginCount(@PathVariable("year") String year){

        return ResponseEntity.ok(statisticService.getYearLogins(year));
    }

    @RequestMapping(value="/api/v1/logins/{year}/{month}", produces = "application/json")
    @ResponseBody
    public Object getYearMonthLoginCount(@PathVariable("year") String year, @PathVariable("month") String month){

        return ResponseEntity.ok(statisticService.getYearMonthLogins(year, month));
    }

    @RequestMapping(value="/api/v1/logins/months", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<MonthCountDto>> getMonthLoginCount(){
        return ResponseEntity.ok(statisticService.getMonthLogins());
    }

    @RequestMapping(value="/api/v1/logins/days", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<DayCountDto>> getDayLoginCount(){
        return ResponseEntity.ok(statisticService.getDayLogins());
    }

    @RequestMapping(value="/api/v1/logins/days/avg", produces = "application/json")
    @ResponseBody
    public ResponseEntity<AvgDayDto> getAvgDayLoginCount(){
        return ResponseEntity.ok(statisticService.getAvgDayLogins());
    }

    @RequestMapping(value="api/v1/logins/months/dep", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<DepMonthDto>> getDepMonthCount(){
        return ResponseEntity.ok(statisticService.getDepMonthLogins());
    }

}