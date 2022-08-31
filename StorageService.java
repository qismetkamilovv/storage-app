import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StorageService {
    private Connection connection;

    public StorageService() {
        connection = DatabaseConfig.getConnection();
    }

    public void save(int id, String brand, int price) {

        String SQL_INSERT = "INSERT INTO shoes(id, Brand, Price) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, brand);
            preparedStatement.setInt(3, price);

            int row = preparedStatement.executeUpdate();

            System.out.println(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s, %s/n%s", e.getSQLState(), e.getMessage());
        }
    }

    public void delete(int id) {

        String sql = "DELETE FROM shoes WHERE id = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void seeAllProducts() {

        final String QUERY = "SELECT id, Brand, Price FROM shoes";

        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);) {
            while (rs.next()) {
                System.out.print("id: " + rs.getInt("id"));
                System.out.print(", Brand: " + rs.getString("Brand"));
                System.out.print(", Price: " + rs.getInt("Price"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
