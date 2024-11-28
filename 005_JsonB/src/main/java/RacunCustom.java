import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbProperty;
import java.util.Calendar;

@JsonbNillable
public class RacunCustom {
    private String iBan;
    private Calendar datumOdpiranja;
    @JsonbProperty(nillable = true)
    private Calendar datumZapiranja;
    /*@JsonbDateFormat("dd.MM.yyyy")
    private Date datumZadnjeTransakcije;*/

    @JsonbCreator
    public RacunCustom(@JsonbProperty("iBan") String iBan, Calendar datumOdpiranja) {
        this.iBan = iBan;
        this.datumOdpiranja = datumOdpiranja;
    }

    public RacunCustom(String iBan, Calendar datumOdpiranja, Calendar datumZapiranja) {
        this.iBan = iBan;
        this.datumOdpiranja = datumOdpiranja;
        this.datumZapiranja = datumZapiranja;
    }

    public String getiBan() {
        return iBan;
    }

    public void setiBan(String iBan) {
        this.iBan = iBan;
    }

    public Calendar getDatumOdpiranja() {
        return datumOdpiranja;
    }

    public void setDatumOdpiranja(Calendar datumOdpiranja) {
        this.datumOdpiranja = datumOdpiranja;
    }

    public Calendar getDatumZapiranja() {
        return datumZapiranja;
    }

    public void setDatumZapiranja(Calendar datumZapiranja) {
        this.datumZapiranja = datumZapiranja;
    }

    @Override
    public String toString() {
        return "RacunCustom{" +
                "iBan='" + iBan + '\'' +
                ", datumOdpiranja=" + datumOdpiranja +
                ", datumZapiranja=" + datumZapiranja +
                '}';
    }
}
