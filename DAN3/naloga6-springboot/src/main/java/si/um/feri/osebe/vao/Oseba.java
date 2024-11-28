package si.um.feri.osebe.vao;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Oseba {

    private String ime;

    private String priimek;

    @Id
    @GeneratedValue
    private int id;

}
