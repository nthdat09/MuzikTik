package DAO;

import Model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface customerInterface {
    public List<Customer> getList() throws SQLException;
}
