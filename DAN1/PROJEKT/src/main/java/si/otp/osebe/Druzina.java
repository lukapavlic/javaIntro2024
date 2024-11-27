package si.otp.osebe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Druzina {

    public static void main(String[] args) {

        Oseba janko=new Oseba("Janko", "Priimkovič", LocalDate.of(1980,11,12));
        Oseba metka=new Oseba("Metka", "Novak", LocalDate.of(1980,11,12));

        List<Oseba> druzina=new ArrayList<>();
        druzina.add(metka);
        druzina.add(janko);

        for (Oseba o : druzina) {
            System.out.println(o);
        }

    }



}
