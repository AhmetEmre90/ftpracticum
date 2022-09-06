package com.ahmetemre90.ftpracticum.urunyorum;

import com.ahmetemre90.ftpracticum.FtpracticumApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UrunYorumAppRunner implements CommandLineRunner {

    @Autowired
    UrunYorumRepository urunYorumRepository;

    private static final Logger log = LoggerFactory.getLogger(FtpracticumApplication.class);

    @Override
    public void run(String... args) throws Exception {

        log.info("");
        log.info("-*-*-*- UrunYorum Repository -*-*-*-");
        log.info("");
        log.info("findAll()");
        for (UrunYorum urunYorum : urunYorumRepository.findAll()) {
            log.info(urunYorum.toString());
        }

    }
}
