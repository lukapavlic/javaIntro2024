package si.otp.demoprojekt.dao;

import si.otp.demoprojekt.Consts;
import si.otp.demoprojekt.vao.Komitent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KomitentDao {

    Logger logger = Logger.getLogger(KomitentDao.class.getName());

    public Komitent dodajKomitenta(Komitent komitent) throws Exception {
        logger.info("Dodal bom "+komitent);
        try (Connection connection = DriverManager.getConnection(Consts.DB_URL, Consts.DB_USER, Consts.DB_PASSWORD)) {
            System.out.println("SQL: INSERT INTO komitent(ime,priimek) VALUES (?, ?)");
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
        logger.log(Level.FINE, "Dodal sem "+komitent);
        return komitent;
    }

    private Komitent komitentIzResultSet(ResultSet resultSet) throws SQLException {
        return new Komitent(
                resultSet.getInt("id"),
                resultSet.getString("ime"),
                resultSet.getString("priimek"));
    }

    public List<Komitent> vsiKomitenti() {
        System.out.println("vsiKomitenti");
        List<Komitent> ret = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(Consts.DB_URL, Consts.DB_USER, Consts.DB_PASSWORD)) {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM komitent");
            while (resultSet.next())
                ret.add(komitentIzResultSet(resultSet));
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public Komitent getKomitent(int id) {
        Komitent ret = null;
        try (Connection connection = DriverManager.getConnection(Consts.DB_URL, Consts.DB_USER, Consts.DB_PASSWORD)) {
            ResultSet resultSet = connection.createStatement().executeQuery(
                    "SELECT * FROM komitent WHERE id = " + id);
            while (resultSet.next())
                ret=komitentIzResultSet(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

}