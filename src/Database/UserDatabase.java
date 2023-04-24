package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDatabase {
    public static Connection getConnection() {
        Connection c = null;
        try {
            // Đăng ký MySQL Driver với DriverManager
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // Các thông số
            String url = "jdbc:mySQL://localhost:3306/fantasicfour";
            String username = "root";
            String password = "userpass";

            // Tạo kết nối
            c = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if(c!=null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
