package si.otp.demoprojekt.vao;

import lombok.Data;

@Data
public class Komitent {

    public Komitent(String ime, String priimek) {
        this.ime = ime;
        this.priimek = priimek;
    }

    public Komitent(int id, String ime, String priimek) {
        this.id = id;
        this.ime = ime;
        this.priimek = priimek;
    }

    private int id;

    private String ime;

    private String priimek;

}
