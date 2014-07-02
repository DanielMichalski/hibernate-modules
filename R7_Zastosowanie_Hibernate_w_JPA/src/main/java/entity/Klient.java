package entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "klient")
@Inheritance(strategy = InheritanceType.JOINED)
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "imie", length = 50, nullable = false)
    private String imie;

    @Column(name = "nazwisko", length = 50, nullable = false)
    private String nazwisko;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "klient")
    private Set<Zamowienie> zamowienia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Set<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(Set<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Klient{");
        sb.append("id=").append(id);
        sb.append(", imie='").append(imie).append('\'');
        sb.append(", nazwisko='").append(nazwisko).append('\'');
        sb.append(", zamowienia=").append(zamowienia);
        sb.append('}');
        return sb.toString();
    }
}
