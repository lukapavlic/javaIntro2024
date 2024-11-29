package si.otp.demoprojekt.vao;

import jakarta.json.bind.annotation.JsonbTransient;
import si.otp.demoprojekt.exceptions.NiDovoljSredstevException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BancniRacun {

    public BancniRacun() {
    }

    public BancniRacun(String iban, Komitent lastnik) {
        this.iban = iban;
        this.lastnik = lastnik;
    }

    private String iban;

    private Komitent lastnik;

    private LocalDate datumOdprtja=LocalDate.now();

    private double limit=1000.0d;

    private List<Transakcija> transakcije=new ArrayList<>();

    public void polozi(double znesek, String namen) {
        Transakcija t=new Transakcija(null,this,znesek,namen);
        transakcije.add(t);
    }

    public void dvigni(double znesek, String namen) throws NiDovoljSredstevException {
        double dovoljenDvig=stanje()+limit;

        if (dovoljenDvig<znesek) throw new NiDovoljSredstevException("Premalo sredstev na računu");

        Transakcija t=new Transakcija(this,null,znesek * -1.0,namen);
        transakcije.add(t);
    }

    public double stanje() {
        double znesek=0.0;
        for(Transakcija transakcija : transakcije)
            znesek+=transakcija.getVrednost();
        return znesek;
    }

    @Override
    public String toString() {
        return "BancniRacun{" +
                "iban='" + iban + '\'' +
                ", lastnik=" + lastnik +
                ", datumOdprtja=" + datumOdprtja +
                ", limit=" + limit +
                ", transakcije=" + transakcije +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BancniRacun that = (BancniRacun) o;
        return Objects.equals(iban, that.iban);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(iban);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Komitent getLastnik() {
        return lastnik;
    }

    public void setLastnik(Komitent lastnik) {
        this.lastnik = lastnik;
    }

    public LocalDate getDatumOdprtja() {
        return datumOdprtja;
    }

    public void setDatumOdprtja(LocalDate datumOdprtja) {
        this.datumOdprtja = datumOdprtja;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @JsonbTransient
    public List<Transakcija> getTransakcije() {
        return transakcije;
    }

    public void setTransakcije(List<Transakcija> transakcije) {
        this.transakcije = transakcije;
    }
}
