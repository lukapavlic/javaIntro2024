package si.otp.delavnica;

import java.util.ArrayList;
import java.util.List;

public class Kalkulator {

    private int zadniRezultat;

    private List<OperacijaRecord> zgodovina = new ArrayList<>();
//    private List<Operacija> zgodovina = new ArrayList<>();

    public int getZadniRezultat() {
        return zadniRezultat;
    }

    public void setZadniRezultat(int zadniRezultat) {
        this.zadniRezultat = zadniRezultat;
    }

//    public List<Operacija> getZgodovina() {
    public List<OperacijaRecord> getZgodovina() {
        return zgodovina;
    }

    public int sestej(int a, int b) {
        zadniRezultat=a+b;
        zgodovina.add(new OperacijaRecord(a + " + " + b,zadniRezultat));
//        zgodovina.add(new Operacija(a + " + " + b,zadniRezultat));
        return zadniRezultat;
    }

    public int mnozi(int a, int b) {
        zadniRezultat=a*b;
        zgodovina.add(new OperacijaRecord(a + " * " + b,zadniRezultat));
//        zgodovina.add(new Operacija(a + " * " + b,zadniRezultat));
        return zadniRezultat;
    }

    public int odstej(int a, int b) {
        zadniRezultat=a-b;
        zgodovina.add(new OperacijaRecord(a + " - " + b,zadniRezultat));
//        zgodovina.add(new Operacija(a + " - " + b,zadniRezultat));
        return zadniRezultat;
    }

}

