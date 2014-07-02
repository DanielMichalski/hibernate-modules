package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "klient_prywatny")
@PrimaryKeyJoinColumn(name = "klient_id", referencedColumnName = "id")
public class KlientPrywatny extends Klient {

    @Column(name = "data_urodzenia", nullable = false)
    @Temporal(TemporalType.DATE)
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
