package com.ahmetemre90.ftpracticum.urun;

import com.ahmetemre90.ftpracticum.FtpracticumApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UrunAppRunner implements CommandLineRunner {

    @Autowired
    UrunRepository urunRepository;

    private static final Logger log = LoggerFactory.getLogger(FtpracticumApplication.class);

    @Override
    public void run(String... args) throws Exception {

        log.info("");
        log.info("-*-*-*- Urun Repository -*-*-*-");
        log.info("");
        log.info("findAll()");
        for (Urun urun : urunRepository.findAll()) {
            log.info(urun.toString());
        }

    }
}
