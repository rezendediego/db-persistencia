package br.infnet.diegorezende.jdbc.datasource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceManager {
    private static final String DB_PROPERTIES_FILE = "src/main/resources/db.properties";
    private static Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream(DB_PROPERTIES_FILE)) {
            properties.load(fis);
            Class.forName(properties.getProperty("MYSQL_DB_DRIVER_CLASS"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                properties.getProperty("MYSQL_DB_URL"),
                properties.getProperty("MYSQL_DB_USERNAME"),
                properties.getProperty("MYSQL_DB_PASSWORD")
        );
    }
}

