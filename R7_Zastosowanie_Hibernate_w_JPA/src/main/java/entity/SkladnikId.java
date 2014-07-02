package entity;

import java.io.Serializable;

/**
 * Author: Daniel
 */
public class SkladnikId implements Serializable {
    private int produktId;
    private int zamowienieId;

    @Override
    public int hashCode() {
        return produktId + zamowienieId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SkladnikId) {
            SkladnikId other = (SkladnikId) obj;
            return produktId == other.produktId
                    && zamowienieId == other.zamowienieId;
        }
        return false;
    }
}
