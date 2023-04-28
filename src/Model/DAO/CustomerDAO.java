package Model.DAO;

import Model.BEAN.CustomerList;
import Model.BEAN.CustomerListP;
import Model.Database.UserDatabase;
import Model.BEAN.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements CustomerInterface {
    public static CustomerDAO getInstance() {
        return new CustomerDAO();
    }
    @Override
    public List<CustomerListP> getList() {
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Select * from mctmsys.customer";
            List<CustomerListP> list = new ArrayList<>();
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CustomerListP customer = new CustomerListP();
                customer.setId(rs.getInt("CUS_ID"));
                customer.setName(rs.getString("CUS_NAME"));
                customer.setPhoneNumber(rs.getString("CUS_PHONE_NUMBER"));
                customer.setEmail(rs.getString("CUS_EMAIL"));
                customer.setAddress(rs.getString("CUS_ADDRESS"));
                customer.setType(rs.getString("CUS_TYPE"));
                customer.setTotalPoint(rs.getInt("CUS_TOTAL_POINT"));
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

    @Override
    public CustomerListP selectByID(int ID) throws SQLException {
        CustomerListP customer = null;
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Select * from mctmsys.customer where CUS_ID = " + ID + ";";
            System.out.println(sql);
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer = new CustomerListP();
                customer.setId(rs.getInt("CUS_ID"));
                customer.setName(rs.getString("CUS_NAME"));
                customer.setPhoneNumber(rs.getString("CUS_PHONE_NUMBER"));
                customer.setEmail(rs.getString("CUS_EMAIL"));
                customer.setAddress(rs.getString("CUS_ADDRESS"));
                customer.setType(rs.getString("CUS_TYPE"));
                customer.setTotalPoint(rs.getInt("CUS_TOTAL_POINT"));
            }

            ps.close();
            rs.close();
            con.close();
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCustomer(CustomerListP cus) throws SQLException {
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "UPDATE mctmsys.customer SET CUS_NAME = '" + cus.getName() + "' , CUS_PHONE_NUMBER = '" + cus.getPhoneNumber() +
                    "', CUS_EMAIL = '" + cus.getEmail() +"', CUS_ADDRESS = '" + cus.getAddress() + "', CUS_TOTAL_POINT = " + cus.getTotalPoint() + " WHERE CUS_ID = " +cus.getId() + "";
            System.out.println(sql);

            PreparedStatement ps = con.prepareCall(sql);

            int rowChanged = ps.executeUpdate();
            System.out.println("Row changed: " + rowChanged);
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertCustomer(CustomerListP oldCustomer) throws SQLException {
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "INSERT INTO mctmsys.customer (CUS_ID, CUS_NAME, CUS_PHONE_NUMBER, CUS_EMAIL, CUS_ADDRESS, CUS_TYPE, CUS_TOTAL_POINT) VALUES (10, '" + oldCustomer.getName() + "', '" + oldCustomer.getPhoneNumber() + "', '" + oldCustomer.getEmail() + "', '" + oldCustomer.getAddress() + "', '1', " + oldCustomer.getTotalPoint() + ")";
            System.out.println(sql);

            PreparedStatement ps = con.prepareCall(sql);

            int rowChanged = ps.executeUpdate();
            System.out.println("Row changed: " + rowChanged);
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int ID) throws SQLException {
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "DELETE from mctmsys.customer where CUS_ID = " + ID + ";";
            System.out.println(sql);
            PreparedStatement ps = con.prepareCall(sql);
            int rs = ps.executeUpdate();
            System.out.println("Row changed: " + rs);

            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
