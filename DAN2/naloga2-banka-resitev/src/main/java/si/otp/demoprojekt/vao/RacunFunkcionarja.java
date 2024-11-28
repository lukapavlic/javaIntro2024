package si.otp.demoprojekt.vao;

import si.otp.demoprojekt.Constants;

public class RacunFunkcionarja extends BancniRacun {

    public RacunFunkcionarja(String iban, Komitent lastnik) {
        super(iban, lastnik);
    }

    @Override
    public void polozi(double znesek, String namen) {
        super.polozi(znesek, namen);
        if (znesek >= Constants.MEJA_POLOGA_FUNKCIONARJA)
            System.out.println("OPALA! To pa je malo veliko... :/");
    }

}
