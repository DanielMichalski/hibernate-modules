package entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "klient_prywatny", schema = "", catalog = "szkolenie")
public class KlientPrywatnyEntity {
    private int klientId;
    private Date dataUrodzenia;
    private KlientEntity klientByKlientId;

    @Id
    @Column(name = "klient_id")
    public int getKlientId() {
        return klientId;
    }

    public void setKlientId(int klientId) {
        this.klientId = klientId;
    }

    @Basic
    @Column(name = "data_urodzenia")
    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KlientPrywatnyEntity that = (KlientPrywatnyEntity) o;

        if (klientId != that.klientId) return false;
        if (dataUrodzenia != null ? !dataUrodzenia.equals(that.dataUrodzenia) : that.dataUrodzenia != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = klientId;
        result = 31 * result + (dataUrodzenia != null ? dataUrodzenia.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "klient_id", referencedColumnName = "id", nullable = false)
    public KlientEntity getKlientByKlientId() {
        return klientByKlientId;
    }

    public void setKlientByKlientId(KlientEntity klientByKlientId) {
        this.klientByKlientId = klientByKlientId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KlientPrywatnyEntity{");
        sb.append("klientId=").append(klientId);
        sb.append(", dataUrodzenia=").append(dataUrodzenia);
        sb.append('}');
        return sb.toString();
    }
}
