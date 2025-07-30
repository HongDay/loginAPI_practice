package com.demo.comentoStatistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComentoStatisticApplication {

    public static void main(String[] args) throws ClassNotFoundException {
        //Class.forName("org.mariadb.jdbc.Driver");
        SpringApplication.run(ComentoStatisticApplication.class, args);
    }

}
