package entity;

/**
 * Author: Daniel
 */
public class Telefon {
    private String numer;
    private String model;
    private Klient klient;

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Telefon telefon = (Telefon) o;

        if (numer != null ? !numer.equals(telefon.numer) : telefon.numer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return numer != null ? numer.hashCode() : 0;
    }
}
