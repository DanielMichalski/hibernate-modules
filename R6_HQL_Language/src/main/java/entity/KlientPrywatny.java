package entity;

import java.util.Date;

/**
 * Author: Daniel
 */
public class KlientPrywatny extends Klient {
    private Date dataUrodzenia;

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KlientPrywatny{");
        sb.append("dataUrodzenia=").append(dataUrodzenia);
        sb.append('}').append(super.toString());
        return sb.toString();
    }
}
