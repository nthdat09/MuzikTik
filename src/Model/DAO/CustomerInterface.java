package Model.DAO;

import Model.BEAN.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerInterface {
    public List<Customer> getList() throws SQLException;
}
