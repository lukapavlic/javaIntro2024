package si.otp.demoprojekt.vao;

import lombok.Data;

import java.util.List;

@Data
public class Komitent {

    public Komitent(String ime, String priimek) {
        this.ime = ime;
        this.priimek = priimek;
    }

    private String ime;

    private String priimek;

}
