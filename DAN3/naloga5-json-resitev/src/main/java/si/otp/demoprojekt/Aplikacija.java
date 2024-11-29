package si.otp.demoprojekt;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import si.otp.demoprojekt.dao.Banka;
import si.otp.demoprojekt.dao.BankaJsonImpl;
import si.otp.demoprojekt.dao.BankaMapImpl;
import si.otp.demoprojekt.vao.BancniRacun;
import si.otp.demoprojekt.vao.Komitent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Aplikacija {

    public static void main(String[] args) throws IOException {

        Banka otp=new BankaMapImpl();

        otp.dodajRacun(new BancniRacun("111-1111-1111-1111",new Komitent("Janez","Krajnski")));
        otp.dodajRacun(new BancniRacun("222-222-222-222",new Komitent("Peter","Klepec")));

        Jsonb jsonb = JsonbBuilder.create();
        for(BancniRacun b:otp.getRacuni())
            System.out.println(jsonb.toJson(b));

        //izvoz vseh računov v JSON - brez transakcij
        String json = jsonb.toJson(otp.getRacuni());
        Files.write(Paths.get("/Users/luka/Desktop/racuni.json"), json.getBytes());

        //DAO, ki dela z JSON datoteko
        Banka nlb=new BankaJsonImpl("/Users/luka/Desktop/nlb.json");

        nlb.dodajRacun(new BancniRacun("111-1111-1111-1111",new Komitent("Janez","Krajnski")));
        nlb.dodajRacun(new BancniRacun("222-222-222-222",new Komitent("Peter","Klepec")));

        for(BancniRacun b:nlb.getRacuni())
            System.out.println(b);
    }

}
