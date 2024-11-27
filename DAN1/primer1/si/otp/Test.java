package si.otp;

import si.otp.delavnica.*;

public class Test {

    public static void main(String[] args){
        Kalkulator hp=new Kalkulator("HP");
        Kalkulator cisco=new Kalkulator();
        Kalkulator superKalkulator=hp;

        System.out.println(hp);
        System.out.println(cisco);
        System.out.println(superKalkulator);

        int prvo=Integer.parseInt(args[1]);
        int drugo=Integer.parseInt(args[2]);

        if (args[0].equals("x")) {
            System.out.println("Množim: "+args[1]+" in "+args[2]+"="+hp.mnozi(prvo, drugo));
        } 

        if (args[0].equals("+"))
            System.out.println("Seštevam: "+args[1]+" in "+args[2]+"="+hp.sestej(prvo, drugo));

        System.out.println("To dela!!!");
    }

}
