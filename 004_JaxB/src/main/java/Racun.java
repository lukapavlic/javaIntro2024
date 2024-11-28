import java.util.Calendar;

public class Racun {
    private String iBan;
    private Calendar datumOdpiranja;
    private Calendar datumZapiranja;

    public Racun(String iBan, Calendar datumOdpiranja, Calendar datumZapiranja) {
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
