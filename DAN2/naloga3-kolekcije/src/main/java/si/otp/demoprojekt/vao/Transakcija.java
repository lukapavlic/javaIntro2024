package si.otp.demoprojekt.vao;

public class Transakcija {

    public Transakcija(BancniRacun izvor, BancniRacun ponor, double vrednost, String namen) {
        this.izvor = izvor;
        this.ponor = ponor;
        this.vrednost = vrednost;
        this.namen = namen;
    }

    private BancniRacun izvor;

    private BancniRacun ponor;

    private double vrednost;

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

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
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
                ((ponor!=null)?ponor.getIban():"?") + " : " + vrednost + " ("+ namen+")");
    }

}
