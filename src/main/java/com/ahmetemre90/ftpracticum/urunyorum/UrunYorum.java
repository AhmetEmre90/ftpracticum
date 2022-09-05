package com.ahmetemre90.ftpracticum.urunyorum;

import com.ahmetemre90.ftpracticum.kullanici.Kullanici;
import com.ahmetemre90.ftpracticum.urun.Urun;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "UrunYorum")
public class UrunYorum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false, length = 500)
    private String yorum;

    @Column(nullable = false)
    private LocalDate yorumTarihi;

    @ManyToOne
    @JoinColumn(name = "kullaniciId")
    private Kullanici kullanici;

    @ManyToOne
    @JoinColumn(name = "urunId")
    private Urun urun;

    public UrunYorum() {
    }

    public UrunYorum(String yorum, LocalDate yorumTarihi, Kullanici kullanici, Urun urun) {
        this.yorum = yorum;
        this.yorumTarihi = yorumTarihi;
        this.kullanici = kullanici;
        this.urun = urun;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    public LocalDate getYorumTarihi() {
        return yorumTarihi;
    }

    public void setYorumTarihi(LocalDate yorumTarihi) {
        this.yorumTarihi = yorumTarihi;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }
}
