package si.otp.demoprojekt.dao;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import si.otp.demoprojekt.vao.BancniRacun;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BankaJsonImpl implements Banka {

    public BankaJsonImpl(String datoteka) {
        this.datoteka = datoteka;
    }

    private String datoteka;

    @Override
    public Collection<BancniRacun> getRacuni() {
        List<BancniRacun> prebraniRacuni = new ArrayList<>();
        try {
            Jsonb jsonb = JsonbBuilder.create();
            String prebrano = new String(Files.readAllBytes(Paths.get(datoteka)));
            prebraniRacuni=jsonb.fromJson(prebrano, new ArrayList<BancniRacun>() {}.getClass().getGenericSuperclass());
        } catch (IOException e) {
            System.out.println("Datoteke ni bilo mogoče prebrati: " + datoteka);
        }
        return prebraniRacuni;
    }

    @Override
    public BancniRacun getRacun(String iban) {
        for (BancniRacun br : getRacuni())
            if (br.getIban().equals(iban))
                return br;
        return null;
    }

    @Override
    public void dodajRacun(BancniRacun brRacun) {
        Jsonb jsonb = JsonbBuilder.create();
        Collection<BancniRacun> prebraniRacuni = getRacuni();
        prebraniRacuni.add(brRacun);
        String json = jsonb.toJson(prebraniRacuni);
        try {
            Files.write(Paths.get(datoteka), json.getBytes());
        } catch (IOException e) {
            System.out.println("Datoteke ni bilo mogoče pisati: " + datoteka);
        }
    }

}
