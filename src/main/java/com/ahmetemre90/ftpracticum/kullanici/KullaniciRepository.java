package com.ahmetemre90.ftpracticum.kullanici;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KullaniciRepository extends CrudRepository<Kullanici, Long> {
    List<Kullanici> findBySoyadi(String soyadi);

}
