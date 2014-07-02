package entity;

import javax.persistence.*;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "klient_firmowy", schema = "", catalog = "szkolenie")
public class KlientFirmowyEntity {
    private int klientId;
    private String nazwaFirmy;
    private String nip;
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
    @Column(name = "nazwa_firmy")
    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    @Basic
    @Column(name = "nip")
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KlientFirmowyEntity that = (KlientFirmowyEntity) o;

        if (klientId != that.klientId) return false;
        if (nazwaFirmy != null ? !nazwaFirmy.equals(that.nazwaFirmy) : that.nazwaFirmy != null) return false;
        if (nip != null ? !nip.equals(that.nip) : that.nip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = klientId;
        result = 31 * result + (nazwaFirmy != null ? nazwaFirmy.hashCode() : 0);
        result = 31 * result + (nip != null ? nip.hashCode() : 0);
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
        final StringBuilder sb = new StringBuilder("KlientFirmowyEntity{");
        sb.append("nip='").append(nip).append('\'');
        sb.append(", nazwaFirmy='").append(nazwaFirmy).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
