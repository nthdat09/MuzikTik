package DAO;

import Database.UserDatabase;
import Model.User;

import java.sql.*;

public class DAOHoiVien implements DAOInterface<User>{
    public static DAOHoiVien getInstance() {
        return new DAOHoiVien();
    }
    @Override
    public User selectById(String t) {
        User ketQua = null;
        try {
            // Tạo kết nối đến CSDL
            Connection con = UserDatabase.getConnection();

            // Tạo ra đối tượng PreparedStatement
            String sql = "SELECT * FROM hoivien where HV_USERNAME=?";
            PreparedStatement st = con.prepareCall(sql);
            st.setString(1, t);
            // Thực thi câu lệnh SQL

            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Tìm kiếm trong database
            while(rs.next()) {
                String username = rs.getString("HV_USERNAME");
                String password = rs.getString("HV_PASSWORD");

                ketQua = new User(username, password);

            }
            // Đóng kết nối đến CSDL
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }


}