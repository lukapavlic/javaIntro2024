package si.otp.demoprojekt.dao;

import si.otp.demoprojekt.vao.BancniRacun;
import java.util.Collection;

public interface Banka {

    Collection<BancniRacun> getRacuni();

    BancniRacun getRacun(String iban);

    void dodajRacun(BancniRacun brRacun);

}
