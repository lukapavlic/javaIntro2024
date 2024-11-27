package si.otp.demoprojekt.vao;

import java.math.BigDecimal;
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

    private BigDecimal limit=BigDecimal.valueOf(0);

    private List<Transakcija> transakcije=new ArrayList<>();

    public void polozi(BigDecimal znesek, String namen) {
        Transakcija t=new Transakcija(null,this,znesek,namen);
        transakcije.add(t);
    }

    public void dvigni(BigDecimal znesek, String namen) {
        Transakcija t=new Transakcija(this,null,znesek.multiply(BigDecimal.valueOf(-1)),namen);
        transakcije.add(t);
    }

    public BigDecimal stanje() {
        BigDecimal znesek=BigDecimal.ZERO;
        for(Transakcija transakcija : transakcije) {
            znesek=znesek.add(transakcija.getVrednost());
        }
        return znesek;
    }

    public String getIban() {
        return iban;
    }

    public List<Transakcija> getTransakcije() {
        return transakcije;
    }
}
