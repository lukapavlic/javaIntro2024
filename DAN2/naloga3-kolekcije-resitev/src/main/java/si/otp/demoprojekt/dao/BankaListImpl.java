package si.otp.demoprojekt.dao;

import si.otp.demoprojekt.vao.BancniRacun;
import si.otp.demoprojekt.vao.Komitent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankaListImpl implements Banka {

    private List<BancniRacun> racuni=new ArrayList<>();

    public BankaListImpl() {
        BancniRacun brJanko=new BancniRacun("000-0000-0000",new Komitent("Janko", "Komitent"));
        BancniRacun brMetka=new BancniRacun("000-0000-1111",new Komitent("Metka", "Komitentka"));
        racuni.add(brJanko);
        racuni.add(brMetka);
    }

    @Override
    public List<BancniRacun> getRacuni() {
        return Collections.unmodifiableList(racuni);
    }

    @Override
    public BancniRacun getRacun(String iban) {
        for (BancniRacun brRacun : racuni)
            if (brRacun.getIban().equals(iban))
                return brRacun;
        return null;
    }

    @Override
    public void dodajRacun(BancniRacun brRacun) {
        racuni.add(brRacun);
    }

}
