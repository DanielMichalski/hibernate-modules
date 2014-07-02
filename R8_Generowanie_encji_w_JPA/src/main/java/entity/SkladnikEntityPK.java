package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Author: Daniel
 */
public class SkladnikEntityPK implements Serializable {
    private int produktId;
    private int zamowienieId;

    @Column(name = "produkt_id", updatable = false, insertable = false)
    @Id
    public int getProduktId() {
        return produktId;
    }

    public void setProduktId(int produktId) {
        this.produktId = produktId;
    }

    @Column(name = "zamowienie_id", updatable = false, insertable = false)
    @Id
    public int getZamowienieId() {
        return zamowienieId;
    }

    public void setZamowienieId(int zamowienieId) {
        this.zamowienieId = zamowienieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SkladnikEntityPK that = (SkladnikEntityPK) o;

        if (produktId != that.produktId) return false;
        if (zamowienieId != that.zamowienieId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = produktId;
        result = 31 * result + zamowienieId;
        return result;
    }
}
