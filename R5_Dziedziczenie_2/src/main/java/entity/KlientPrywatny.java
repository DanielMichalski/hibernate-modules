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
}
