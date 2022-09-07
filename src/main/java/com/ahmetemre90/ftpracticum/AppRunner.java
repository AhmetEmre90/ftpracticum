package com.ahmetemre90.ftpracticum;

import com.ahmetemre90.ftpracticum.kullanici.Kullanici;
import com.ahmetemre90.ftpracticum.kullanici.KullaniciRepository;
import com.ahmetemre90.ftpracticum.urun.Urun;
import com.ahmetemre90.ftpracticum.urun.UrunRepository;
import com.ahmetemre90.ftpracticum.urunyorum.UrunYorum;
import com.ahmetemre90.ftpracticum.urunyorum.UrunYorumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    KullaniciRepository kullaniciRepository;

    @Autowired
    UrunRepository urunRepository;

    @Autowired
    UrunYorumRepository urunYorumRepository;

    private static final Logger log = LoggerFactory.getLogger(FtpracticumApplication.class);

    @Override
    public void run(String... args) throws Exception {

        log.info("");
        log.info("1. Bir ürüne ait yorumları listeleyen bir metot yazınız.");

        Urun urun1a = urunRepository.findById(1L).get();
        log.info(urun1a.getAdi() + " ürününe ait yorumlar.");

        for (UrunYorum urunYorum : urunYorumRepository.getUrunYorumsByUrun(urun1a)) {
            log.info(urunYorum.getKullanici().getAdi() + " "
                    + urunYorum.getKullanici().getSoyadi() + " - "
                    + urunYorum.getYorumTarihi().format(DateTimeFormatter.ofPattern("dd.MM.uuuu")) + " -> "
                    + urunYorum.getYorum());
        }


        log.info("");
        log.info("2. Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız.");

        Urun urun1b = urunRepository.findById(1L).get();
        LocalDate baslangicTarihi = LocalDate.of(2022, 1, 1);
        LocalDate bitisTarihi = LocalDate.of(2022, 3, 3);
        log.info(urun1b.getAdi() + " ürününe ait "
                + baslangicTarihi.format(DateTimeFormatter.ofPattern("dd.MM.uuuu")) + " - "
                + bitisTarihi.format(DateTimeFormatter.ofPattern("dd.MM.uuuu")) + " tarihleri arasındaki yorumlar.");

        for (UrunYorum urunYorum : urunYorumRepository.getUrunYorumsByUrunAndYorumTarihiBetween(urun1b, baslangicTarihi, bitisTarihi)) {
            log.info(urunYorum.getKullanici().getAdi() + " "
                    + urunYorum.getKullanici().getSoyadi() + " - "
                    + urunYorum.getYorumTarihi().format(DateTimeFormatter.ofPattern("dd.MM.uuuu")) + " -> "
                    + urunYorum.getYorum());
        }


        log.info("");
        log.info("3. Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.");

        Kullanici kullanici1 = kullaniciRepository.findById(1L).get();
        log.info(kullanici1.getAdi() + " " + kullanici1.getSoyadi() + " kullanıcısının yaptığı yorumlar.");

        for (UrunYorum urunYorum : urunYorumRepository.getUrunYorumsByKullanici(kullanici1)) {
            log.info(urunYorum.getUrun().getAdi() + " "
                    + urunYorum.getYorumTarihi().format(DateTimeFormatter.ofPattern("dd.MM.uuuu")) + " "
                    + urunYorum.getYorum());
        }
    }
}
