package si.otp.demoprojekt;

import si.otp.demoprojekt.dao.Banka;
import si.otp.demoprojekt.vao.BancniRacun;

public class Aplikacija2 {

    public static void main(String[] args) {

        Banka otp=new Banka();

        BancniRacun brJanko=otp.getRacun("000-0000-0000");
        BancniRacun brMetka=otp.getRacun("000-0000-1111");

        //TODO metoda za prenos sredstev v Bančni Račun
        //brJanko.prenesi(brMetka, 500);

        //TODO lep izpis vseh računov (ime, priimek, znesek) in njihovih transakcij

    }

}
