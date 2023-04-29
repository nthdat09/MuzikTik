package Model.DAO;

import Model.BEAN.Customer;
import Model.BEAN.CustomerListP;

import java.sql.SQLException;
import java.util.List;

public interface CustomerInterface {
    public List<CustomerListP> getList() throws SQLException;

    public CustomerListP selectByID(int ID) throws SQLException;

    public void updateCustomer(CustomerListP customer) throws SQLException;

    public void insertCustomer(CustomerListP oldCustomer) throws SQLException;

    public void deleteCustomer(int ID) throws SQLException;

}
