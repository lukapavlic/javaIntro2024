package si.otp.demoprojekt.kolekcije;

import java.util.Objects;

//Demonstracija kolekcij
public class Oseba implements Comparable<Oseba> {

    public Oseba(String ime, String priimek) {
        this.ime = ime;
        this.priimek = priimek;
    }

    private String ime;

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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Oseba oseba = (Oseba) o;
        return Objects.equals(ime, oseba.ime) && Objects.equals(priimek, oseba.priimek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, priimek);
    }

    @Override
    public int compareTo(Oseba o) {
        int ret=this.priimek.compareTo(o.priimek);
        if (ret==0) ret=this.ime.compareTo(o.ime);
        return ret;
    }

}
