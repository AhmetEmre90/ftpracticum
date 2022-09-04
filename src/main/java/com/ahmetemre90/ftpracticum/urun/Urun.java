package com.ahmetemre90.ftpracticum.urun;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "Urun")
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String adi;
    @Column(nullable = false)
    private BigDecimal fiyat;
    private Date sonKullanmaTarihi;

    public Urun() {
    }

    public Urun(String adi, BigDecimal fiyat, Date sonKullanmaTarihi) {
        this.adi = adi;
        this.fiyat = fiyat;
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public BigDecimal getFiyat() {
        return fiyat;
    }

    public void setFiyat(BigDecimal fiyat) {
        this.fiyat = fiyat;
    }

    public Date getSonKullanmaTarihi() {
        return sonKullanmaTarihi;
    }

    public void setSonKullanmaTarihi(Date sonKullanmaTarihi) {
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }
}
