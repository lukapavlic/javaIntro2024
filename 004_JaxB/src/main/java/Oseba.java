import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Razred, ki ga uporabljamo za serializacijo in deserializacijo
 * @author Viktor
 *
 */
@XmlRootElement(name = "oseba")
@XmlAccessorType(XmlAccessType.FIELD)
public class Oseba implements Serializable {

    private String ime;
    private String priimek;
    private String naslov;
    private int starost;
    private boolean komitent;

    public Oseba() {

    }

    /**
     * Notacija se uporablja za prikaz XML elementa <IzposojeneKnjige>
     * Znotraj tega elementa bodo prikazane vse knjige v obliki posameznih XML elementov
     * <IzposojeneKnjige>
     *   <knjige>Palček</knjige>
     *   <knjige>Božanska komedija</knjige>
     *   <knjige>1984</knjige>
     * </IzposojeneKnjige>
     */
    @XmlElementWrapper(name="OdprtiRacuni")
    private List<String> iBan = new ArrayList<String>();

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public boolean isKomitent() {
        return komitent;
    }

    public void setKomitent(boolean komitent) {
        this.komitent = komitent;
    }

    public int getStarost() {
        return starost;
    }

    public void setStarost(int starost) {
        this.starost = starost;
    }

    private String isKomitentToString() {
        return this.komitent ? "Da" : "Ne";
    }

    public List<String> getiBan() {
        return iBan;
    }

    public void setiBan(List<String> iBan) {
        this.iBan = iBan;
    }

    @Override
    public String toString() {
        String izpRacune = "";

        for (String racun : iBan) {
            izpRacune += "\t" + racun + " \n";
        }
        return "Ime in priimek: " + this.ime + " " + this.priimek + " \n" +
                "Naslov: " + this.naslov + " \n" +
                "Starost: " + this.starost + " \n" +
                "Je komitent: " + isKomitentToString() + " \n" +
                "Odprti računi: \n" + izpRacune;
    }
}
