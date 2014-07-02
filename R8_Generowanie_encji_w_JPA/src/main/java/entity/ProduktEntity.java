package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "produkt", schema = "", catalog = "szkolenie")
public class ProduktEntity {
    private int id;
    private String nazwa;
    private BigDecimal cena;
    private Collection<SkladnikEntity> skladniksById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nazwa")
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "cena")
    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProduktEntity that = (ProduktEntity) o;

        if (id != that.id) return false;
        if (cena != null ? !cena.equals(that.cena) : that.cena != null) return false;
        if (nazwa != null ? !nazwa.equals(that.nazwa) : that.nazwa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (cena != null ? cena.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "produktByProduktId")
    public Collection<SkladnikEntity> getSkladniksById() {
        return skladniksById;
    }

    public void setSkladniksById(Collection<SkladnikEntity> skladniksById) {
        this.skladniksById = skladniksById;
    }
}
