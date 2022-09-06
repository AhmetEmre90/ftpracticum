package com.ahmetemre90.ftpracticum.kullanici;

import com.ahmetemre90.ftpracticum.FtpracticumApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class KullaniciAppRunner implements CommandLineRunner {

    @Autowired
    KullaniciRepository kullaniciRepository;

    private static final Logger log = LoggerFactory.getLogger(FtpracticumApplication.class);

    @Override
    public void run(String... args) throws Exception {

        log.info("");
        log.info("-*-*-*- Kullanici Repository -*-*-*-");
        log.info("");
        log.info("findAll()");
        for (Kullanici kullanici : kullaniciRepository.findAll()) {
            log.info(kullanici.toString());
        }

    }
}
