package com.ahmetemre90.ftpracticum;

import com.ahmetemre90.ftpracticum.kullanici.Kullanici;
import com.ahmetemre90.ftpracticum.kullanici.KullaniciRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FtpracticumApplication {

    private static final Logger log = LoggerFactory.getLogger(FtpracticumApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FtpracticumApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(KullaniciRepository repository) {
        return args -> {
            var k1 = repository.save(new Kullanici("ali", "kaya", "ali@mail.com", "3121112201"));
            var k2 = repository.save(new Kullanici("mehmet", "uzun", "mehmet@mail.com", "3121112202"));
            var k3 = repository.save(new Kullanici("ayşe", "demir", "ayse@mail.com", "3121112203"));
            var k4 = repository.save(new Kullanici("fatma", "çelik", "fatma@mail.com", "3121112204"));
            var k5 = repository.save(new Kullanici("ali", "demir", "alidemir@mail.com", "3121112205"));


            log.info("-----" + k1.getId().toString());


            log.info("findAll()");
            for (Kullanici kullanici : repository.findAll()) {
                log.info(kullanici.toString());
            }
            log.info("");

            log.info("findById()");
            Kullanici kullanici = repository.findById(1L).get();
            log.info(kullanici.toString());
            log.info("");

            log.info("findBySoyadi");
            repository.findBySoyadi("demir").forEach(item -> {
                log.info(item.toString());
            });
            log.info("");
        };
    }
}
