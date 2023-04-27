package DAO;

import Database.UserDatabase;
import Model.User;

import java.sql.*;

public class EmployeeDAO implements EmployeeInterface<User> {
    public static EmployeeDAO getInstance() {
        return new EmployeeDAO();
    }
    @Override
    public User selectById(String t) {
        User ketQua = null;
        try {
            // Tạo kết nối đến CSDL
            Connection con = UserDatabase.getConnection();

            // Tạo ra đối tượng PreparedStatement
            String sql = "SELECT * FROM mctmsys.employee WHERE EMP_USERNAME = ?";
            PreparedStatement st = con.prepareCall(sql);
            st.setString(1, t);
            // Thực thi câu lệnh SQL

            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Tìm kiếm trong database
            while(rs.next()) {
                String username = rs.getString("EMP_USERNAME");
                String password = rs.getString("EMP_PASSWORD");

                ketQua = new User(username, password);

            }
            // Đóng kết nối đến CSDL
            st.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }


}