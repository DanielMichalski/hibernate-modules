package entity;

import java.util.Date;

/**
 * Author: Daniel
 */
public class Zamowienie {
    private int id;
    private Date data;
    private String adres;
    private Klient klient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Zamowienie{");
        sb.append("id=").append(id);
        sb.append(", data=").append(data);
        sb.append(", adres='").append(adres).append('\'');
        sb.append(", klient=").append(klient.getImie());
        sb.append('}');
        return sb.toString();
    }
}
