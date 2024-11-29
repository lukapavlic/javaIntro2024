package si.um.feri.osebe.vao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Transakcija {

    public Transakcija(BancniRacun izvor, BancniRacun ponor, double vrednost, String namen) {
        this.izvor = izvor;
        this.ponor = ponor;
        this.vrednost = vrednost;
        this.namen = namen;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private BancniRacun izvor;

    @ManyToOne
    private BancniRacun ponor;

    private double vrednost;

    private String namen;

    @Override
    public String toString() {
        return (
                ((izvor!=null)?izvor.getIban():"?") + " -> " +
                ((ponor!=null)?ponor.getIban():"?") + " : " + vrednost + " ("+ namen+")");
    }

}
