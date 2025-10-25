import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/virtual_attendance_logger";
    private static final String USER = "root";
    private static final String PASSWORD = "Shreya@123";
    private static Connection con = null; // Singleton connection

    // Private constructor to prevent instantiation
    private DatabaseConnection() { }

    public static Connection getConnection() {
        if (con != null) {
            return con; // return existing connection if already created
        }

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }

        return con;
    }
}
