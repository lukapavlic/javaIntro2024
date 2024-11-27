package si.otp.demoprojekt;

import si.otp.demoprojekt.dao.Banka;
import si.otp.demoprojekt.exceptions.NiDovoljSredstevException;
import si.otp.demoprojekt.vao.BancniRacun;
import si.otp.demoprojekt.vao.Transakcija;

public class Aplikacija2 {

    public static void main(String[] args) {

        Banka otp=new Banka();

        BancniRacun brJanko=otp.getRacun("000-0000-0000");
        BancniRacun brMetka=otp.getRacun("000-0000-1111");

        //TODO uvedimo metodo dodajRacun v Banko

        //TODO spremenimo shranjevanje računov v Banko s Set (ni podvajanja računov)


    }

}
