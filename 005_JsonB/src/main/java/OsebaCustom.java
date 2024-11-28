import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class OsebaCustom {

    // ignoriranje atributa za
    // serializacio in deserializacio
    @JsonbTransient
    private int id;
    private String email;
    private String ime;
    // vpliva na serializacijo in deserializacijo
    @JsonbProperty("priimek-osebe")
    private String priimek;
    private int starost;

    public OsebaCustom(){}

    public OsebaCustom(String email, String ime, String priimek, int starost) {
        this.email = email;
        this.ime = ime;
        this.priimek = priimek;
        this.starost = starost;
    }

    // ignoriranje atributa za serializacijo
    @JsonbTransient
    public int getId() {
        return id;
    }

    // ignoriranje atributa za deserializacijo
    @JsonbTransient
    public void setId(int id) {
        this.id = id;
    }

    public int getStarost() {
        return starost;
    }

    public void setStarost(int starost) {
        this.starost = starost;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // vpliva na serializacijo
    @JsonbProperty("ime-osebe-write")
    public String getIme() {
        return ime;
    }

    // vpliva na deserializacijo
    @JsonbProperty("ime-osebe-read")
    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    @Override
    public String toString() {
        return "Oseba{" +
                "email='" + email + '\'' +
                ", ime='" + ime + '\'' +
                ", priimek='" + priimek + '\'' +
                ", starost=" + starost +
                '}';
    }
}
