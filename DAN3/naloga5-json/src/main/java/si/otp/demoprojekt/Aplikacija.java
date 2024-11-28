package si.otp.demoprojekt;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import si.otp.demoprojekt.dao.Banka;
import si.otp.demoprojekt.dao.BankaMapImpl;
import si.otp.demoprojekt.vao.BancniRacun;
import si.otp.demoprojekt.vao.Komitent;

public class Aplikacija {

    public static void main(String[] args) {

        Banka otp=new BankaMapImpl();

        otp.dodajRacun(new BancniRacun("1-1-1-1",new Komitent("Janez","Krajnski")));

        Jsonb jsonb = JsonbBuilder.create();
        for(BancniRacun b:otp.getRacuni()) {
            System.out.println(jsonb.toJson(b));
        }

        //TODO izvoz vseh računov v JSON - brez transakcij

        //TODO DAO, ki dela z JSON datoteko

    }

}
