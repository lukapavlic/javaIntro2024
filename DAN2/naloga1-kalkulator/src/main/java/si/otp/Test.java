package si.otp;

import si.otp.delavnica.*;

public class Test {

    public static void main(String[] args){
        Kalkulator hp=new Kalkulator();
        System.out.println(hp.sestej(5,6));
        System.out.println(hp.mnozi(5,6));

        //TODO dodajte operacijo odštevanja

        //TODO izpišite vse operacije, ki so bile izvedene v kalkulatorju

    }

}
