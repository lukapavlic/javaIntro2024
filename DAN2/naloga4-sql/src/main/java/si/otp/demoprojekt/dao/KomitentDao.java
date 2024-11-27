package si.otp.demoprojekt.dao;

import si.otp.demoprojekt.Consts;
import si.otp.demoprojekt.vao.Komitent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KomitentDao {

    public Komitent dodajKomitenta(Komitent komitent) throws Exception {
        try (Connection connection = DriverManager.getConnection(Consts.DB_URL, Consts.DB_USER, Consts.DB_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO komitent(ime,priimek) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,komitent.getIme());
            preparedStatement.setString(2,komitent.getPriimek());
            preparedStatement.executeUpdate();

            //pridobivanje generiranega ključa
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            komitent.setId(generatedKeys.getInt(1)); // Pridobi prvi stolpec (ID)
            generatedKeys.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return komitent;
    }

    public List<Komitent> vsiKomitenti() {
        List<Komitent> ret = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(Consts.DB_URL, Consts.DB_USER, Consts.DB_PASSWORD)) {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM komitent");
            while (resultSet.next())
                ret.add(new Komitent(resultSet.getInt("id"),resultSet.getString("ime"),resultSet.getString("priimek")));
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

}
