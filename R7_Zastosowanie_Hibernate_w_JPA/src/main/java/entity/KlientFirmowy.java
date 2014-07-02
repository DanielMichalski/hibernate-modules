package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "klient_firmowy")
@PrimaryKeyJoinColumn(name = "klient_id", referencedColumnName = "id")
public class KlientFirmowy extends Klient {

    @Column(name = "nazwa_firmy", length = 100)
    private String nazwaFirmy;

    @Column(name = "nip", length = 20)
    private String NIP;

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KlientFirmowy{");
        sb.append("nazwaFirmy='").append(nazwaFirmy).append('\'');
        sb.append(", NIP='").append(NIP).append('\'');
        sb.append('}').append(super.toString());
        return sb.toString();
    }
}
