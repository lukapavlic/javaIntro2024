package si.otp.kalkulator;

public class NapredniKalkulator extends Kalkulator {

    public NapredniKalkulator() {
    }

    public int deli(int a, int b) {
        return a / b;
    }

    public int sestej(int a, int b) {
        zadnjiRezultat=a+b+1;
        return a + b + 1;
    }

}
