package si.otp.demoprojekt.dao;

import si.otp.demoprojekt.vao.BancniRacun;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BankaSetImpl implements Banka {

    private Set<BancniRacun> racuni=new HashSet<>();

    @Override
    public BancniRacun getRacun(String iban) {
        for (BancniRacun racun : racuni) {
            if (racun.getIban().equals(iban))
                return racun;
        }
        return null;
    }

    @Override
    public Set<BancniRacun> getRacuni() {
        return Collections.unmodifiableSet(racuni);
    }

    @Override
    public void dodajRacun(BancniRacun brRacun) {
        racuni.add(brRacun);
    }

}
