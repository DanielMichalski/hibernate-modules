package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "zamowienie", schema = "", catalog = "szkolenie")
public class ZamowienieEntity {
    private int id;
    private Timestamp data;
    private String adres;
    private Integer klient;
    private Collection<SkladnikEntity> skladniksById;
    private KlientEntity klientByKlient;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "data")
    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    @Basic
    @Column(name = "adres")
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Basic
    @Column(name = "klient", insertable = false, updatable = false)
    public Integer getKlient() {
        return klient;
    }

    public void setKlient(Integer klient) {
        this.klient = klient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZamowienieEntity that = (ZamowienieEntity) o;

        if (id != that.id) return false;
        if (adres != null ? !adres.equals(that.adres) : that.adres != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (klient != null ? !klient.equals(that.klient) : that.klient != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (adres != null ? adres.hashCode() : 0);
        result = 31 * result + (klient != null ? klient.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "zamowienieByZamowienieId")
    public Collection<SkladnikEntity> getSkladniksById() {
        return skladniksById;
    }

    public void setSkladniksById(Collection<SkladnikEntity> skladniksById) {
        this.skladniksById = skladniksById;
    }

    @ManyToOne
    @JoinColumn(name = "klient", referencedColumnName = "id")
    public KlientEntity getKlientByKlient() {
        return klientByKlient;
    }

    public void setKlientByKlient(KlientEntity klientByKlient) {
        this.klientByKlient = klientByKlient;
    }
}
