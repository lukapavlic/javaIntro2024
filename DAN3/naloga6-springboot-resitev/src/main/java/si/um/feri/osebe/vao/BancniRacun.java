package si.um.feri.osebe.vao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class BancniRacun {

    public BancniRacun(String iban, Komitent lastnik) {
        this.iban = iban;
        this.lastnik = lastnik;
    }

    @Id
    private String iban;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Komitent lastnik;

    private LocalDate datumOdprtja=LocalDate.now();

    @Column(name = "limit_racuna")
    private double limit=1000.0d;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Transakcija> transakcije=new ArrayList<>();

    public void polozi(double znesek, String namen) {
        Transakcija t=new Transakcija(null,this,znesek,namen);
        transakcije.add(t);
    }

    public void dvigni(double znesek, String namen) throws Exception {
        double dovoljenDvig=stanje()+limit;

        if (dovoljenDvig<znesek) throw new Exception("Premalo sredstev na računu");

        Transakcija t=new Transakcija(this,null,znesek * -1.0,namen);
        transakcije.add(t);
    }

    public double stanje() {
        double znesek=0.0;
        for(Transakcija transakcija : transakcije)
            znesek+=transakcija.getVrednost();
        return znesek;
    }

}
