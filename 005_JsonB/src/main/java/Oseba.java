public class Oseba {

    private String email;
    private String ime;
    private String priimek;
    private int starost;

    public Oseba(){}

    public Oseba(String email, String ime, String priimek, int starost) {
        this.email = email;
        this.ime = ime;
        this.priimek = priimek;
        this.starost = starost;
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
