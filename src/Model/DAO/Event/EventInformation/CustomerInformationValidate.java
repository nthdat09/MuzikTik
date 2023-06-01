package Model.DAO.Event.EventInformation;

import Model.BEAN.CustomerBuyTicket;
import Model.Database.UserDatabase;
import View.EventPage.EventPanel;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CustomerInformationValidate {
    private static String name;
    private static String phoneNumber;
    private static String email;
    public static List<CustomerBuyTicket> validateCustomer() {
        name = EventPanel.getNameTextField().getText();
        phoneNumber = EventPanel.getPhoneTextField().getText();
        email = EventPanel.getEmailTextField().getText();
        List<CustomerBuyTicket> result = new ArrayList<>();
        CustomerBuyTicket customerBuyTicket = null;
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "select * from mctmsys.customer where CUS_NAME = '" + name + "' and CUS_PHONE_NUMBER = '" + phoneNumber + "' and CUS_EMAIL = '" + email + "'";
            java.sql.PreparedStatement st = con.prepareCall(sql);
            java.sql.ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Integer customerID = rs.getInt("CUS_ID");
                Integer balance = rs.getInt("CUS_BALANCE");
                String customerName = rs.getString("CUS_NAME");
                String customerPhoneNumber = rs.getString("CUS_PHONE_NUMBER");
                String customerEmail = rs.getString("CUS_EMAIL");
                customerBuyTicket = new CustomerBuyTicket(customerID,customerName, customerPhoneNumber, customerEmail, balance);
                result.add(customerBuyTicket);
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
