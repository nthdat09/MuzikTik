package DAO;

import Database.UserDatabase;
import Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class customerDAO implements customerInterface {
    @Override
    public List<Customer> getList() {
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Select HV_USERNAME, HV_SDT, HV_EMAIL, HV_DIACHI from hoivien";
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
    public static void main (String[] args) throws SQLException {
        customerInterface customerDao = new customerDAO();
        System.out.println(customerDao.getList());
    }
}
