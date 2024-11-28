package si.otp.demoprojekt;

import si.otp.demoprojekt.dao.BankaListImpl;
import si.otp.demoprojekt.exceptions.NiDovoljSredstevException;
import si.otp.demoprojekt.vao.BancniRacun;
import si.otp.demoprojekt.vao.Transakcija;

public class Aplikacija {

    public static void main(String[] args) {

        BankaListImpl otp=new BankaListImpl();

        BancniRacun brJanko=otp.getRacun("000-0000-0000");
        BancniRacun brMetka=otp.getRacun("000-0000-1111");

        System.out.println("Prej:");
        System.out.println("Janko: "+brJanko.stanje());
        System.out.println("Metka: "+brMetka.stanje());

        try {
            brJanko.dvigni(900,"Dvig");
            brMetka.polozi(900,"Polog");
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
