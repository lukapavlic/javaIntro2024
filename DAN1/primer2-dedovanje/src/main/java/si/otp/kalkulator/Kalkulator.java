package si.otp.kalkulator;

public abstract class Kalkulator {

    private String nazivKalkulatorja="neznan";

    public String getNazivKalkulatorja() {
        return nazivKalkulatorja;
    }

    public void setNazivKalkulatorja(String nazivKalkulatorja) {
        this.nazivKalkulatorja = nazivKalkulatorja;
    }

    protected int zadnjiRezultat;

    public int sestej(int a, int b) {
        return a + b;
    }

    public int mnozi(int a, int b) {
        return a * b;
    }

    public abstract int deli(int a, int b);

    public String toString() {
        return "Jaz sem kalkulator "+nazivKalkulatorja;
    }

}
