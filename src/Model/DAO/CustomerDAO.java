package Model.DAO;

import Model.Database.UserDatabase;
import Model.BEAN.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements CustomerInterface {
    @Override
    public List<Customer> getList() {
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Select CUS_NAME, CUS_PHONE_NUMBER, CUS_EMAIL, CUS_ADDRESS from mctmsys.customer";
            List<Customer> list = new ArrayList<>();
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setUserName(rs.getString("HV_USERNAME"));
                customer.setPhoneNumber(rs.getString("HV_SDT"));
                customer.setEmail(rs.getString("HV_EMAIL"));
                customer.setAddress(rs.getString("HV_DIACHI"));
                list.add(customer);
            }
            ps.close();
            rs.close();
            con.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
