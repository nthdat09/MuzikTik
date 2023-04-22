package DAO;

import Database.UserDatabase;
import Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO implements DAOInterface<User>{
    public static UserDAO getInstance() {
        return new UserDAO();
    }
    @Override
    public User selectById(String t) {
        User ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = UserDatabase.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL

            String sql = "SELECT * FROM User where username='"+t+"'";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);

            // Bước 4:
            while(rs.next()) {
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");

                ketQua = new User(username, password);

            }
            // Bước 5:
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }


}
