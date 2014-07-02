package entity;

/**
 * Author: Daniel
 */
public class KlientFirmowy extends Klient {
    private String nazwaFirmy;
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
