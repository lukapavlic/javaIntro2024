package si.otp.demoprojekt.vao;

import lombok.Data;

@Data
public class BancniRacun {

    public BancniRacun(String iban, Komitent lastnik, double limit) {
        this.iban = iban;
        this.lastnik = lastnik;
        this.limit = limit;
    }

    private String iban;

    private Komitent lastnik;

    private double limit=1000.0d;

}
