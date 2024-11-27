package si.otp.delavnica;

public class Kalkulator {

    public Kalkulator() {
        System.out.println("Kalkulator se je rodil.");
    }

   public Kalkulator(String imeKalkulatorja) {
        System.out.println("Kalkulator se je rodil. Ime mi je"+imeKalkulatorja);
    }

    public int sestej(int a, int b) {
        System.out.println("Jaz sem kalkulator in seštevam.");
        return a+b;
    }

    public int mnozi(int a, int b) {
        System.out.println("Jaz sem kalkulator in množim.");
        return a*b;
    }

}

