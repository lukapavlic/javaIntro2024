package si.otp.demoprojekt.dao;

import si.otp.demoprojekt.vao.BancniRacun;
import si.otp.demoprojekt.vao.Komitent;

import java.util.ArrayList;
import java.util.List;

public class Banka {

    private List<BancniRacun> racuni=new ArrayList<>();

    public Banka() {
        BancniRacun brJanko=new BancniRacun("000-0000-0000",new Komitent("Janko", "Komitent"));
        BancniRacun brMetka=new BancniRacun("000-0000-1111",new Komitent("Metka", "Komitentka"));
        racuni.add(brJanko);
        racuni.add(brMetka);
    }

    public List<BancniRacun> getRacuni() {
        return racuni;
    }
}
