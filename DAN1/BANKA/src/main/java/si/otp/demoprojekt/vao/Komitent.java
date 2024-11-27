package si.otp.demoprojekt.vao;

public class Komitent {

    public Komitent(String ime, String priimek) {
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
    public String toString() {
        return "Komitent{" +
                "ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                '}';
    }

}
