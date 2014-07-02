package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "produkt")
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nazwa", length = 50)
    private String nazwa;

    @Column(name = "cena")
    private BigDecimal cena;

    @OneToMany(mappedBy = "produkt")
    List<Skladnik> skladniki;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public List<Skladnik> getSkladniki() {
        return skladniki;
    }

    public void setSkladniki(List<Skladnik> skladniki) {
        this.skladniki = skladniki;
    }
}
