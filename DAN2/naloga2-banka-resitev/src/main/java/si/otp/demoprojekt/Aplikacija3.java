package si.otp.demoprojekt;

import si.otp.demoprojekt.dao.Banka;
import si.otp.demoprojekt.exceptions.NiDovoljSredstevException;
import si.otp.demoprojekt.vao.BancniRacun;
import si.otp.demoprojekt.vao.Komitent;
import si.otp.demoprojekt.vao.RacunFunkcionarja;
import si.otp.demoprojekt.vao.ZlatiRacun;

public class Aplikacija3 {

    public static void main(String[] args) {

        Banka otp=new Banka();

        //uvedimo ZlatiRacun -> je brez limita
        BancniRacun petrovRacun=new BancniRacun("1-2-3",new Komitent("Peter","Klepec"));
        ZlatiRacun francovRacun=new ZlatiRacun("1-2-3-4",new Komitent("Franc","Priimkovič"));

        try {
            petrovRacun.dvigni(10_000d,"Rad bi dvignil, pa ne bo šlo");
        } catch (NiDovoljSredstevException e) {
            System.out.println("Saj sem vedel...");
        }

        try {
            francovRacun.dvigni(10_000d,"Jaz pa dvigujem brez omejitev");
            System.out.println("Saj sem rekel!");
        } catch (NiDovoljSredstevException e) {
            System.out.println("Nemogoče!");
        }

        //uvedimo RacunFunkcionarja -> ob večjih pologih (konstanta) alarm
        RacunFunkcionarja martinovRacun=new RacunFunkcionarja("????",new Komitent("Martin","Krpan"));
        martinovRacun.polozi(10_000,"nekaj 'za sproti'");
        martinovRacun.polozi(200_000,"Nuklearka BO!");

    }

}
