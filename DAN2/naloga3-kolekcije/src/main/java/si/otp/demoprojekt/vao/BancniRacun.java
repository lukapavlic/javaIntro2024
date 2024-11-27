package si.otp.demoprojekt.vao;

import si.otp.demoprojekt.exceptions.NiDovoljSredstevException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BancniRacun {

    public BancniRacun(String iban, Komitent lastnik) {
        this.iban = iban;
        this.lastnik = lastnik;
    }

    private String iban;

    private Komitent lastnik;

    private LocalDate datumOdprtja=LocalDate.now();

    private double limit=1000.0d;

    private List<Transakcija> transakcije=new ArrayList<>();

    public void polozi(double znesek, String namen) {
        Transakcija t=new Transakcija(null,this,znesek,namen);
        transakcije.add(t);
    }

    public void dvigni(double znesek, String namen) throws NiDovoljSredstevException {
        double dovoljenDvig=stanje()+limit;

        if (dovoljenDvig<znesek) throw new NiDovoljSredstevException("Premalo sredstev na računu");

        Transakcija t=new Transakcija(this,null,znesek * -1.0,namen);
        transakcije.add(t);
    }

    public double stanje() {
        double znesek=0.0;
        for(Transakcija transakcija : transakcije)
            znesek+=transakcija.getVrednost();
        return znesek;
    }

    public String getIban() {
        return iban;
    }

    public List<Transakcija> getTransakcije() {
        return transakcije;
    }

}
