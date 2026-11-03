package schoolreports;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * Central MySQL connection helper.
 *
 * Configure SCHOOLREPORTS_DB_URL, SCHOOLREPORTS_DB_USER and
 * SCHOOLREPORTS_DB_PASSWORD in the environment before starting the app.
 */
public class mysqlconnection {

    public static Connection ConnectDb() {
        String url = System.getenv("SCHOOLREPORTS_DB_URL");
        String username = System.getenv("SCHOOLREPORTS_DB_USER");
        String password = System.getenv("SCHOOLREPORTS_DB_PASSWORD");

        if (url == null || url.trim().isEmpty()
                || username == null || username.trim().isEmpty()
                || password == null) {
            JOptionPane.showMessageDialog(null,
                    "Database configuration is missing. Set "
                    + "SCHOOLREPORTS_DB_URL, SCHOOLREPORTS_DB_USER and "
                    + "SCHOOLREPORTS_DB_PASSWORD.");
            return null;
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Database connection failed: " + e.getMessage());
            return null;
        }
    }
}
