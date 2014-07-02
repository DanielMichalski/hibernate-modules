package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "klient", schema = "", catalog = "szkolenie")
public class KlientEntity {
    private int id;
    private String imie;
    private String nazwisko;
    private KlientFirmowyEntity klientFirmowyById;
    private KlientPrywatnyEntity klientPrywatnyById;
    private Collection<ZamowienieEntity> zamowieniesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "imie")
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "nazwisko")
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KlientEntity that = (KlientEntity) o;

        if (id != that.id) return false;
        if (imie != null ? !imie.equals(that.imie) : that.imie != null) return false;
        if (nazwisko != null ? !nazwisko.equals(that.nazwisko) : that.nazwisko != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (imie != null ? imie.hashCode() : 0);
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "klientByKlientId")
    public KlientFirmowyEntity getKlientFirmowyById() {
        return klientFirmowyById;
    }

    public void setKlientFirmowyById(KlientFirmowyEntity klientFirmowyById) {
        this.klientFirmowyById = klientFirmowyById;
    }

    @OneToOne(mappedBy = "klientByKlientId")
    public KlientPrywatnyEntity getKlientPrywatnyById() {
        return klientPrywatnyById;
    }

    public void setKlientPrywatnyById(KlientPrywatnyEntity klientPrywatnyById) {
        this.klientPrywatnyById = klientPrywatnyById;
    }

    @OneToMany(mappedBy = "klientByKlient")
    public Collection<ZamowienieEntity> getZamowieniesById() {
        return zamowieniesById;
    }

    public void setZamowieniesById(Collection<ZamowienieEntity> zamowieniesById) {
        this.zamowieniesById = zamowieniesById;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KlientEntity{");
        sb.append("imie='").append(imie).append('\'');
        sb.append(", nazwisko='").append(nazwisko).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
