package pl.kotzur.zadrek;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Zamowienie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;
    private double kwota;

    @ManyToMany
    @JoinTable(
            name = "l_zamowienie_produkt",
            joinColumns = @JoinColumn(name = "id_zamowienie"),
            inverseJoinColumns = @JoinColumn(name = "id_produkt")
    )
    private Set<Produkt> produkty;

    public Zamowienie() {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new Date(utilDate.getTime());
        this.data = sqlDate;
        this.kwota = 0.0;
    }

    public Zamowienie(Date data, double kwota, Set<Produkt> produkty) {
        this.data = data;
        this.kwota = kwota;
        this.produkty = produkty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getKwota() {
        return kwota;
    }

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public Set<Produkt> getProdukty() {
        return produkty;
    }

    public void setProdukty(Set<Produkt> produkty) {
        this.produkty = produkty;
    }

    public double obliczKwote() {
        Set<Produkt> produkty = this.getProdukty();
        double nowaKwota = 0.0;
        for (Produkt pr: produkty) {
            nowaKwota += pr.getCena();
        }
        nowaKwota = Math.round(nowaKwota * 100.0) / 100.0;
        return nowaKwota;
    }

    @Override
    public String toString() {

        String wynik = "Zamowienie{" +
                "id=" + id +
                ", data=" + data +
                ", kwota=" + kwota +
                ", produkty=";

        String dod = "";
        for (Produkt pr: produkty) {
            dod += pr.toString();
        }

        return wynik + dod;
    }
}
