package si.otp.json;

import jakarta.json.bind.annotation.JsonbProperty;

public class Oseba {

    public Oseba() {
    }

    public Oseba(String ime, String priimek) {
        this.ime = ime;
        this.priimek = priimek;
    }

    @JsonbProperty("ime")
    private String ime;

    @JsonbProperty("priimek")
    private String priimek;

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

    @Override
    public String toString() {
        return "Oseba{" +
                "ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                '}';
    }
}
