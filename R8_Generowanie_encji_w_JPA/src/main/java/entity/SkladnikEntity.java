package entity;

import javax.persistence.*;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "skladnik", schema = "", catalog = "szkolenie")
@IdClass(SkladnikEntityPK.class)
public class SkladnikEntity {
    private int produktId;
    private int zamowienieId;
    private int ilosc;
    private ProduktEntity produktByProduktId;
    private ZamowienieEntity zamowienieByZamowienieId;

    @Id
    @Column(name = "produkt_id", insertable = false, updatable = false)
    public int getProduktId() {
        return produktId;
    }

    public void setProduktId(int produktId) {
        this.produktId = produktId;
    }

    @Id
    @Column(name = "zamowienie_id")
    public int getZamowienieId() {
        return zamowienieId;
    }

    public void setZamowienieId(int zamowienieId) {
        this.zamowienieId = zamowienieId;
    }

    @Basic
    @Column(name = "ilosc")
    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SkladnikEntity that = (SkladnikEntity) o;

        if (ilosc != that.ilosc) return false;
        if (produktId != that.produktId) return false;
        if (zamowienieId != that.zamowienieId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = produktId;
        result = 31 * result + zamowienieId;
        result = 31 * result + ilosc;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "produkt_id", referencedColumnName = "id", nullable = false)
    public ProduktEntity getProduktByProduktId() {
        return produktByProduktId;
    }

    public void setProduktByProduktId(ProduktEntity produktByProduktId) {
        this.produktByProduktId = produktByProduktId;
    }

    @ManyToOne
    @JoinColumn(name = "zamowienie_id", referencedColumnName = "id", nullable = false)
    public ZamowienieEntity getZamowienieByZamowienieId() {
        return zamowienieByZamowienieId;
    }

    public void setZamowienieByZamowienieId(ZamowienieEntity zamowienieByZamowienieId) {
        this.zamowienieByZamowienieId = zamowienieByZamowienieId;
    }
}
