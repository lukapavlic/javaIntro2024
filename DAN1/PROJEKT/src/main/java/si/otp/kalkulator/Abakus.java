package si.otp.kalkulator;

public class Abakus implements VmesnikaKalkulatorja {

    @Override
    public int sestej(int a, int b) {
        return a+b;
    }

    @Override
    public int deli(int a, int b) {
        return a/b;
    }

    @Override
    public int mnozi(int a, int b) {
        return a*b;
    }

}
