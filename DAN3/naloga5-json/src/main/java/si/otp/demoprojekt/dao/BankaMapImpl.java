package si.otp.demoprojekt.dao;

import si.otp.demoprojekt.vao.BancniRacun;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BankaMapImpl implements Banka {

    private Map<String,BancniRacun> racuni=new HashMap<>();

    @Override
    public BancniRacun getRacun(String iban) {
        return racuni.get(iban);
    }

    @Override
    public Collection<BancniRacun> getRacuni() {
        return Collections.unmodifiableCollection(racuni.values());
    }

    @Override
    public void dodajRacun(BancniRacun brRacun) {
        racuni.put(brRacun.getIban(),brRacun);
    }

}
