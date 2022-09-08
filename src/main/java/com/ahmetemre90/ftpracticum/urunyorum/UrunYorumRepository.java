package com.ahmetemre90.ftpracticum.urunyorum;

import com.ahmetemre90.ftpracticum.kullanici.Kullanici;
import com.ahmetemre90.ftpracticum.urun.Urun;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UrunYorumRepository extends CrudRepository<UrunYorum, Long> {

    List<UrunYorum> getUrunYorumsByUrun(Urun urun);

    List<UrunYorum> getUrunYorumsByUrunAndYorumTarihiBetween(Urun urun, LocalDate baslangicTarihi, LocalDate bitisTarihi);

    List<UrunYorum> getUrunYorumsByKullanici(Kullanici kullanici);

    List<UrunYorum> getUrunYorumsByKullaniciAndYorumTarihiBetween(Kullanici kullanici, LocalDate baslangicTarihi, LocalDate bitisTarihi);

}
