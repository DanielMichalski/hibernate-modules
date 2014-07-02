package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Author: Daniel
 */
@Entity
public class Klient {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "imie")
    private String imie;

    @Column (name = "nazwisko")
    private String nazwisko;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Klient{");
        sb.append("id=").append(id);
        sb.append(", imie='").append(imie).append('\'');
        sb.append(", nazwisko='").append(nazwisko).append('\'');
        sb.append('}');
        return sb.toString();
    }
}