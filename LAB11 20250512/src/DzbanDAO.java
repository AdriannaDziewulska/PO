import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DzbanDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/dzbanydb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public void add(Dzban dzban) {
        String sql = "INSERT INTO dzbany (nazwa, opis, pojemnosc, wysokosc) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dzban.getNazwa());
            stmt.setString(2, dzban.getOpis());
            stmt.setInt(3, dzban.getPojemnosc());
            stmt.setInt(4, dzban.getWysokosc());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Dzban> getAll() {
        List<Dzban> dzbany = new ArrayList<>();
        String sql = "SELECT * FROM dzbany";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dzban dzban = new Dzban(
                        rs.getInt("id"),
                        rs.getString("nazwa"),
                        rs.getString("opis"),
                        rs.getInt("pojemnosc"),
                        rs.getInt("wysokosc")
                );
                dzbany.add(dzban);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dzbany;
    }

    public Dzban getById(int id) {
        String sql = "SELECT * FROM dzbany WHERE id = ?";
        Dzban dzban = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    dzban = new Dzban(
                            rs.getInt("id"),
                            rs.getString("nazwa"),
                            rs.getString("opis"),
                            rs.getInt("pojemnosc"),
                            rs.getInt("wysokosc")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dzban;
    }

    public void update(Dzban dzban) {
        String sql = "UPDATE dzbany SET nazwa = ?, opis = ?, pojemnosc = ?, wysokosc = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dzban.getNazwa());
            stmt.setString(2, dzban.getOpis());
            stmt.setInt(3, dzban.getPojemnosc());
            stmt.setInt(4, dzban.getWysokosc());
            stmt.setInt(5, dzban.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM dzbany WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
