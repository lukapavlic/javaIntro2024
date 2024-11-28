package si.otp.demoprojekt;

import si.otp.demoprojekt.dao.Banka;
import si.otp.demoprojekt.dao.BankaMapImpl;
import si.otp.demoprojekt.vao.BancniRacun;
import si.otp.demoprojekt.vao.Komitent;

public class Aplikacija3 {

    public static void main(String[] args) {

        Banka otp=new BankaMapImpl();

        otp.dodajRacun(new BancniRacun("1-1-1-1",new Komitent("Janez","Krajnski")));

        //spremenimo shranjevanje računov v Banko z Map (ključ = iban)
        for(BancniRacun b:otp.getRacuni()) {
            System.out.println(b);
        }

    }

}
