package si.otp.osebe;

import java.time.LocalDate;

public class Oseba {

    public Oseba(String ime, String priimek, LocalDate datumRojstva) {
        this.ime = ime;
        this.priimek = priimek;
        this.datumRojstva = datumRojstva;
    }

    private String ime;

    private String priimek;

    private LocalDate datumRojstva;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public LocalDate getDatumRojstva() {
        return datumRojstva;
    }

    public void setDatumRojstva(LocalDate datumRojstva) {
        this.datumRojstva = datumRojstva;
    }

    @Override
    public String toString() {
        return "Oseba{" +
                "ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                ", datumRojstva=" + datumRojstva +
                '}';
    }
}
