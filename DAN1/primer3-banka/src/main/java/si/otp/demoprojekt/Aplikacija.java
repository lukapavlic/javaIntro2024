package si.otp.demoprojekt;

import si.otp.demoprojekt.dao.Banka;
import si.otp.demoprojekt.exceptions.NiDovoljSredstevException;
import si.otp.demoprojekt.vao.BancniRacun;
import si.otp.demoprojekt.vao.Transakcija;
import java.math.BigDecimal;

public class Aplikacija {

    public static void main(String[] args) {

        Banka otp=new Banka();

        BancniRacun brJanko=otp.getRacun("000-0000-0000");
        BancniRacun brMetka=otp.getRacun("000-0000-1111");

        System.out.println("Prej:");
        System.out.println("Janko: "+brJanko.stanje());
        System.out.println("Metka: "+brMetka.stanje());

        try {
            brJanko.dvigni(BigDecimal.valueOf(10000),"Dvig");
            brMetka.polozi(BigDecimal.valueOf(10000),"Polog");
        } catch (NiDovoljSredstevException e) {
            System.out.println("Žal...");
        }

        System.out.println("Potem:");
        System.out.println("Janko: "+brJanko.stanje());
        System.out.println("Metka: "+brMetka.stanje());

        System.out.println("Transakcije Janko:");
        for (Transakcija t: brJanko.getTransakcije())
            System.out.println(t);

        System.out.println("Transakcije Metka:");
        for (Transakcija t: brMetka.getTransakcije())
            System.out.println(t);

    }

}