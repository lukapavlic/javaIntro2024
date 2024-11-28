package si.otp.demoprojekt.dao;

import si.otp.demoprojekt.Consts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DDL {

    private static final String KOMITENT_DDL = "create table if not exists komitent(id int auto_increment, ime varchar(50), priimek varchar(50), primary key(id))";
    private static final String RACUN_DDL = "create table if not exists racun(iban varchar(50), lastnik int, limitzneska decimal)";

    public static void kreirajTabele() {
        try (Connection connection = DriverManager.getConnection(
                Consts.DB_URL,
                Consts.DB_USER,
                Consts.DB_PASSWORD)) {
            connection.createStatement().execute(KOMITENT_DDL);
            connection.createStatement().execute(RACUN_DDL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
