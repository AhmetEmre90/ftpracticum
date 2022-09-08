package com.ahmetemre90.ftpracticum.urun;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrunRepository extends CrudRepository<Urun, Long> {

    @Query("select u from Urun u where u.sonKullanmaTarihi < current_date ")
    List<Urun> getSonKullanmaTarihiGecmisUruns();

    @Query("select u from Urun u where u.sonKullanmaTarihi >= current_date or u.sonKullanmaTarihi is null ")
    List<Urun> getSonKullanmaTarihiGecmemisUruns();

}
