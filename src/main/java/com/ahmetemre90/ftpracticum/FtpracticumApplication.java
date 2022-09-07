package com.ahmetemre90.ftpracticum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FtpracticumApplication {

    private static final Logger log = LoggerFactory.getLogger(FtpracticumApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FtpracticumApplication.class, args);
    }

}
