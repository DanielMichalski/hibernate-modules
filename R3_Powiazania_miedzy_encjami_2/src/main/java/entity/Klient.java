package entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: Daniel
 */
public class Klient {
    private int id;
    private String imie;
    private String nazwisko;
    private Set<Telefon> telefony = new HashSet<Telefon>();
    private Map<String, String> numeryModele = new HashMap<String, String>();

    public Klient() {}

    public Klient(int id, String imie, String nazwisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Set<Telefon> getTelefony() {
        return telefony;
    }

    public void setTelefony(Set<Telefon> telefony) {
        this.telefony = telefony;
    }

    public Map<String, String> getNumeryModele() {
        return numeryModele;
    }

    public void setNumeryModele(Map<String, String> numeryModele) {
        this.numeryModele = numeryModele;
    }
}