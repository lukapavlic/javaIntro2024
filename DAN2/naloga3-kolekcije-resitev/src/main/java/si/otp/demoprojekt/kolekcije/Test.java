package si.otp.demoprojekt.kolekcije;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        Set<Oseba> osebe=new TreeSet<>();
        Set<Oseba> pocasnaKolekcija=Collections.synchronizedSet(osebe);
        Set<Oseba> pocasnaNespremenljivaKolekcija=Collections.unmodifiableSet(pocasnaKolekcija);

        osebe.add(new Oseba("Peter","Klepec"));
        osebe.add(new Oseba("Martin","Krpan"));
        osebe.add(new Oseba("Mojca","Pokrajculja"));
//        pocasnaNespremenljivaKolekcija.add(new Oseba("Mojca","Pokrajculja"));
        pocasnaKolekcija.add(new Oseba("Mojca","APokrajculja"));

        for (Oseba oseba:osebe){
            System.out.println(oseba.toString()+" "+oseba.getPriimek()+" "+oseba.getIme());
        }

    }


}
