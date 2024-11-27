package si.otp.demoprojekt.vao;

import java.math.BigDecimal;

public class Transakcija {

    public Transakcija(BancniRacun izvor, BancniRacun ponor, BigDecimal vrednost, String namen) {
        this.izvor = izvor;
        this.ponor = ponor;
        this.vrednost = vrednost;
        this.namen = namen;
    }

    private BancniRacun izvor;

    private BancniRacun ponor;

    private BigDecimal vrednost;

    private String namen;

    public BancniRacun getIzvor() {
        return izvor;
    }

    public void setIzvor(BancniRacun izvor) {
        this.izvor = izvor;
    }

    public BancniRacun getPonor() {
        return ponor;
    }

    public void setPonor(BancniRacun ponor) {
        this.ponor = ponor;
    }

    public BigDecimal getVrednost() {
        return vrednost;
    }

    public void setVrednost(BigDecimal vrednost) {
        this.vrednost = vrednost;
    }

    public String getNamen() {
        return namen;
    }

    public void setNamen(String namen) {
        this.namen = namen;
    }

    @Override
    public String toString() {
        return (
                ((izvor!=null)?izvor.getIban():"?") + " -> " +
                ((ponor!=null)?ponor.getIban():"?") + " : " + vrednost.toString() + " ("+ namen+")");
    }

}
