import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    static final String DB_URL = "jdbc:mysql://localhost/WAREHOUSE";
    static final String USER = "root";
    static final String PASS = "qismet20";
    private static Connection connection;

    static Connection getConnection() {
        if (connection == null) {

            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return connection;

    }
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
