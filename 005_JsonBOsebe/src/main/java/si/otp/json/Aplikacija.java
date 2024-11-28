package si.otp.json;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Aplikacija {

    public static void main(String[] args) throws IOException {

        List<Oseba> osebe=new ArrayList<>();
        osebe.add(new Oseba("Peter","Klepec"));
        osebe.add(new Oseba("Mojca","Pokrajculja"));
        osebe.add(new Oseba("Martin","Krpan"));

        Jsonb jsonb = JsonbBuilder.create();

        //zapis JSON datoteke
        String json = jsonb.toJson(osebe);
        Files.write(Paths.get("/Users/luka/Desktop/osebe.json"), json.getBytes());

        //branje JSON datoteke
        String prebrano = new String(Files.readAllBytes(Paths.get("/Users/luka/Desktop/osebe.json")));
        List<Oseba> prebraneOsebe = jsonb.fromJson(prebrano, new ArrayList<Oseba>() {}.getClass().getGenericSuperclass());

        for (Oseba p : prebraneOsebe){
            System.out.println(p);
        }

    }

}
