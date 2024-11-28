package si.otp;

import si.otp.delavnica.*;

public class Test {

    public static void main(String[] args){
        Kalkulator hp=new Kalkulator();
        System.out.println(hp.sestej(5,6));
        System.out.println(hp.mnozi(5,6));
        System.out.println(hp.odstej(5,6));

//        for (Operacija o:hp.getZgodovina())
        for (OperacijaRecord o:hp.getZgodovina())
            System.out.println(o);

    }

}
