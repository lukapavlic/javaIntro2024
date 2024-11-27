package si.otp.delavnica;

public class Kalkulator {

    private int zadniRezultat;

    public int getZadniRezultat() {
        return zadniRezultat;
    }

    public void setZadniRezultat(int zadniRezultat) {
        this.zadniRezultat = zadniRezultat;
    }

    public int sestej(int a, int b) {
        zadniRezultat=a+b;
        return zadniRezultat;
    }

    public int mnozi(int a, int b) {
        zadniRezultat=a*b;
        return zadniRezultat;
    }

}

