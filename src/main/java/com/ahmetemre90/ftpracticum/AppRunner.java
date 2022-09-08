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

        Urun urun1 = urunRepository.findById(1L).get();
        log.info(urun1.getAdi() + " ürününe ait yorumlar.");

        for (UrunYorum urunYorum : urunYorumRepository.getUrunYorumsByUrun(urun1)) {
            log.info(urunYorum.getKullanici().getAdi() + " "
                    + urunYorum.getKullanici().getSoyadi() + " - "
                    + urunYorum.getYorumTarihi().format(DateTimeFormatter.ofPattern("dd.MM.uuuu")) + " -> "
                    + urunYorum.getYorum());
        }


        log.info("");
        log.info("2. Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız.");

        Urun urun2 = urunRepository.findById(1L).get();
        LocalDate baslangicTarihi2 = LocalDate.of(2022, 1, 1);
        LocalDate bitisTarihi2 = LocalDate.of(2022, 3, 3);
        log.info(urun2.getAdi() + " ürününe ait "
                + baslangicTarihi2.format(DateTimeFormatter.ofPattern("dd.MM.uuuu")) + " - "
                + bitisTarihi2.format(DateTimeFormatter.ofPattern("dd.MM.uuuu")) + " tarihleri arasındaki yorumlar.");

        for (UrunYorum urunYorum : urunYorumRepository.getUrunYorumsByUrunAndYorumTarihiBetween(urun2, baslangicTarihi2, bitisTarihi2)) {
            log.info(urunYorum.getKullanici().getAdi() + " "
                    + urunYorum.getKullanici().getSoyadi() + " - "
                    + urunYorum.getYorumTarihi().format(DateTimeFormatter.ofPattern("dd.MM.uuuu")) + " -> "
                    + urunYorum.getYorum());
        }


        log.info("");
        log.info("3. Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.");

        Kullanici kullanici3 = kullaniciRepository.findById(1L).get();
        log.info(kullanici3.getAdi() + " " + kullanici3.getSoyadi() + " kullanıcısının yaptığı yorumlar.");

        for (UrunYorum urunYorum : urunYorumRepository.getUrunYorumsByKullanici(kullanici3)) {
            log.info(urunYorum.getUrun().getAdi() + " "
                    + urunYorum.getYorumTarihi().format(DateTimeFormatter.ofPattern("dd.MM.uuuu")) + " "
                    + urunYorum.getYorum());
        }


        log.info("");
        log.info("4. Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız.");

        Kullanici kullanici4 = kullaniciRepository.findById(1L).get();
        LocalDate baslangicTarihi4 = LocalDate.of(2022, 1, 1);
        LocalDate bitisTarihi4 = LocalDate.of(2022, 1, 4);
        log.info(kullanici4.getAdi() + " " + kullanici4.getSoyadi() + " kullanıcısının "
                + baslangicTarihi4.format(DateTimeFormatter.ofPattern("dd.MM.uuuu")) + " - "
                + bitisTarihi4.format(DateTimeFormatter.ofPattern("dd.MM.uuuu")) + " tarihleri arasında yaptığı yorumlar.");

        for (UrunYorum urunYorum : urunYorumRepository.getUrunYorumsByKullaniciAndYorumTarihiBetween(kullanici4, baslangicTarihi4, bitisTarihi4)) {
            log.info(urunYorum.getUrun().getAdi() + " "
                    + urunYorum.getYorumTarihi().format(DateTimeFormatter.ofPattern("dd.MM.uuuu")) + " -> "
                    + urunYorum.getYorum());
        }


        log.info("");
        log.info("5. Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazınız.");

        for (Urun urun : urunRepository.getSonKullanmaTarihiGecmisUruns()) {
            log.info(urun.getAdi() + " - " + urun.getSonKullanmaTarihi().format(DateTimeFormatter.ofPattern("dd.MM.uuuu")));
        }


        log.info("");
        log.info("6. Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazınız. (Son kullanma tarihi boş olanlar da gelmeli.)");

        for (Urun urun : urunRepository.getSonKullanmaTarihiGecmemisUruns()) {
            if (urun.getSonKullanmaTarihi() != null) {
                log.info(urun.getAdi() + " - " + urun.getSonKullanmaTarihi().format(DateTimeFormatter.ofPattern("dd.MM.uuuu")));
            } else {
                log.info(urun.getAdi() + " - ");
            }
        }
    }
}
