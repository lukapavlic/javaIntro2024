package si.otp.demoprojekt.vao;

import si.otp.demoprojekt.exceptions.NiDovoljSredstevException;

public class ZlatiRacun extends BancniRacun {

    public ZlatiRacun(String iban, Komitent lastnik) {
        super(iban, lastnik);
    }

    @Override
    public void dvigni(double znesek, String namen) throws NiDovoljSredstevException {
        Transakcija t=new Transakcija(
                this,
                null,
                znesek * -1.0,
                namen);
        super.getTransakcije().add(t);
    }

}
