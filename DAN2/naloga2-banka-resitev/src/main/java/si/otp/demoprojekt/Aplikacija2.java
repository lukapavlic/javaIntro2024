package si.otp.demoprojekt;

import si.otp.demoprojekt.dao.Banka;
import si.otp.demoprojekt.exceptions.NiDovoljSredstevException;
import si.otp.demoprojekt.vao.BancniRacun;
import si.otp.demoprojekt.vao.Transakcija;

public class Aplikacija2 {

    public static void main(String[] args) throws NiDovoljSredstevException {

        Banka otp=new Banka();

        BancniRacun brJanko=otp.getRacun("000-0000-0000");
        BancniRacun brMetka=otp.getRacun("000-0000-1111");

        brJanko.polozi(14900,"Podal sem avtomobil");
        brJanko.polozi(10000,"Bil sem priden");

        //metoda za prenos sredstev v Bančni Račun
        brJanko.prenesi(brMetka, 500);

        //lep izpis vseh računov (ime, priimek, znesek) in njihovih transakcij
        System.out.println("Ime \t\tPriimek \t\tStanje");
        System.out.println("----------------------------------");
        for (BancniRacun br : otp.getRacuni()) {
            System.out.println(br.getLastnik().getIme() +"\t\t"+ br.getLastnik().getPriimek() +"\t\t"+ br.stanje());
            for (Transakcija t: br.getTransakcije())
                System.out.println("\t\t - "+ t);
        }
    }

}
