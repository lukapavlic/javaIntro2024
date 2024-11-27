import si.otp.kalkulator.Abakus;
import si.otp.kalkulator.Kalkulator;
import si.otp.kalkulator.NapredniKalkulator;
import si.otp.kalkulator.VmesnikaKalkulatorja;

public class Test {

    public static void main(String[] args) {

        VmesnikaKalkulatorja abak=new Abakus();
        System.out.println(abak.sestej(5,5));



        NapredniKalkulator cisco=new NapredniKalkulator();
        System.out.println(cisco.sestej(3,4));

        System.out.println(cisco.getNazivKalkulatorja());
        cisco.setNazivKalkulatorja("Cisco");
        System.out.println(cisco.getNazivKalkulatorja());

        Kalkulator seEnKalkulator=new NapredniKalkulator();
        System.out.println(seEnKalkulator.sestej(5,6));

    }

}
