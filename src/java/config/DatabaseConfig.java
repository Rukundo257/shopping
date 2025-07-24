package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/shopping";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // Charger le driver MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Créer et retourner la connexion
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

