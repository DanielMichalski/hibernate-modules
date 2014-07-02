package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Author: Daniel
 */
@Entity
@Table(name = "zamowienie")
public class Zamowienie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column (name = "adres", nullable = false)
    private String adres;

    @ManyToOne
    @JoinColumn(name = "klient", nullable = false)
    private Klient klient;

    @OneToMany(mappedBy = "zamowienie")
    private List<Skladnik> skladniki;

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

    public List<Skladnik> getSkladniki() {
        return skladniki;
    }

    public void setSkladniki(List<Skladnik> skladniki) {
        this.skladniki = skladniki;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Zamowienie{");
        sb.append("id=").append(id);
        sb.append(", data=").append(data);
        sb.append(", adres='").append(adres).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
