package com.ahmetemre90.ftpracticum.urunyorum;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "UrunYorum")
public class UrunYorum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, length = 500)
    private String yorum;
    @Column(nullable = false)
    private Date yorumTarihi;
    @Column(nullable = false)
    private Long urunId;
    @Column(nullable = false)
    private Long kullaniciId;

    public UrunYorum() {
    }

    public UrunYorum(String yorum, Date yorumTarihi, Long urunId, Long kullaniciId) {
        this.yorum = yorum;
        this.yorumTarihi = yorumTarihi;
        this.urunId = urunId;
        this.kullaniciId = kullaniciId;
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

    public Date getYorumTarihi() {
        return yorumTarihi;
    }

    public void setYorumTarihi(Date yorumTarihi) {
        this.yorumTarihi = yorumTarihi;
    }

    public Long getUrunId() {
        return urunId;
    }

    public void setUrunId(Long urunId) {
        this.urunId = urunId;
    }

    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }
}
