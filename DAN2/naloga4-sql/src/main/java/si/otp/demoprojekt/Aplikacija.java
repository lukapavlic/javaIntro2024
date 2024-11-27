package si.otp.demoprojekt;

import si.otp.demoprojekt.dao.DDL;
import si.otp.demoprojekt.dao.KomitentDao;
import si.otp.demoprojekt.vao.Komitent;

public class Aplikacija {

    public static void main(String[] args) throws Exception {

        DDL.kreirajTabele();

        KomitentDao komitentDao = new KomitentDao();
        System.out.println(
                komitentDao.dodajKomitenta(new Komitent("Peter","Klepec"))
        );

        System.out.println("------");

        for (Komitent k :komitentDao.vsiKomitenti())
            System.out.println(k);

        //TODO iskanje komitenta s podanim IDjem

        //TODO hranjevanje in izpis bančnih računov

        //TODO Logiranje v DAO razredih

    }

}
