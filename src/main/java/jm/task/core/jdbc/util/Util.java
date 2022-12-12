package jm.task.core.jdbc.util;


import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private static Connection conn = null;
    private static String url = "jdbc:mysql://localhost:3306/task1.4";
    private static String username = "admin";
    private static String password = "admin";
    public static Connection getConnection() throws SQLException {
        try {
            if (null == conn || conn.isClosed()) {
                conn = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection() {
        try {
            if (null != conn || !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
