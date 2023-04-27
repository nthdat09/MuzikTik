package Model.DAO;

import Model.Database.UserDatabase;
import Model.BEAN.CustomerListP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerListDAO{

    public static CustomerListDAO getInstance() {
        return new CustomerListDAO();
    }

    public static List<CustomerListP> getCustomerList() {
        List<CustomerListP> result = new ArrayList<>();
        CustomerListP customerList = null;
        try {
            // Tạo kết nối đến CSDL
            Connection con = UserDatabase.getConnection();

            // Tạo ra đối tượng PreparedStatement
            String sql = "SELECT * FROM mctmsys.customer";
            PreparedStatement st = con.prepareCall(sql);

            // Thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Tìm kiếm trong database
            while(rs.next()) {
                String cusName = rs.getString("CUS_NAME");
                String cusPhoneNumber = rs.getString("CUS_PHONE_NUMBER");
                String cusEmail = rs.getString("CUS_EMAIL");
                String cusAddress = rs.getString("CUS_ADDRESS");
                int cusId = rs.getInt("CUS_ID");
                String cusType = rs.getString("CUS_TYPE");
                int cusTotalPoint = rs.getInt("CUS_TOTAL_POINT");
                customerList = new CustomerListP(cusId, cusName, cusPhoneNumber, cusEmail, cusAddress, cusType, cusTotalPoint);
                result.add(customerList);
            }

            // Đóng kết nối đến CSDL
            st.close();
            rs.close();
            UserDatabase.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
