package si.otp.demoprojekt;

import si.otp.demoprojekt.dao.Banka;
import si.otp.demoprojekt.vao.BancniRacun;
import si.otp.demoprojekt.vao.Komitent;
import si.otp.demoprojekt.vao.Transakcija;

import java.math.BigDecimal;
import java.util.List;

public class Aplikacija {

    public static void main(String[] args) {

        BancniRacun brJanko=new BancniRacun("000-0000-0000",new Komitent("Janko", "Komitent"));
        BancniRacun brMetka=new BancniRacun("000-0000-1111",new Komitent("Metka", "Komitentka"));

        System.out.println("Prej:");
        System.out.println("Janko: "+brJanko.stanje());
        System.out.println("Metka: "+brMetka.stanje());

        brJanko.dvigni(BigDecimal.valueOf(1000),"Dvig");
        brMetka.polozi(BigDecimal.valueOf(1000),"Polog");

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
