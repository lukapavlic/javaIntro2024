package si.otp.demoprojekt;

import si.otp.demoprojekt.dao.Banka;
import si.otp.demoprojekt.dao.BankaListImpl;
import si.otp.demoprojekt.dao.BankaSetImpl;
import si.otp.demoprojekt.vao.BancniRacun;
import si.otp.demoprojekt.vao.Komitent;

public class Aplikacija2 {

    public static void main(String[] args) {

        Banka otp=new BankaListImpl();
        BancniRacun brJanko=otp.getRacun("000-0000-0000");
        BancniRacun brMetka=otp.getRacun("000-0000-1111");

        //uvedimo metodo dodajRacun v Banko
        otp.dodajRacun(new BancniRacun("1-1-1-1-1",new Komitent("Palček","Smuk")));

        for (BancniRacun br : otp.getRacuni())
            System.out.println(br);

        System.out.println("-----------------------");

        //spremenimo shranjevanje računov v Banko s Set (ni podvajanja računov)
        Banka nlb=new BankaSetImpl();
        nlb.dodajRacun(new BancniRacun("1-1-1-1",new Komitent("Janez","Krajnski")));
        nlb.dodajRacun(new BancniRacun("1-1-1-2",new Komitent("Muca","Copatarica")));
        nlb.dodajRacun(new BancniRacun("1-1-1-1",new Komitent("Janez","Krajnski")));

        for (BancniRacun br : nlb.getRacuni())
            System.out.println(br);

    }

}
