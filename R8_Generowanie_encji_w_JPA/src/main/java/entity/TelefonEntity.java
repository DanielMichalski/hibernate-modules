package entity;

import javax.persistence.*;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "telefon", schema = "", catalog = "szkolenie")
public class TelefonEntity {
    private String numer;
    private String model;
    private int klient;

    @Id
    @Column(name = "numer")
    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "klient")
    public int getKlient() {
        return klient;
    }

    public void setKlient(int klient) {
        this.klient = klient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TelefonEntity that = (TelefonEntity) o;

        if (klient != that.klient) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (numer != null ? !numer.equals(that.numer) : that.numer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numer != null ? numer.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + klient;
        return result;
    }
}
