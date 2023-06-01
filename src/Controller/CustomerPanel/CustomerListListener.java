package Controller.CustomerPanel;

import View.CustomersListPage.CustomersListPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CustomerListListener implements ActionListener {
    private final CustomersListPanel customersListPanel;

    public CustomerListListener(CustomersListPanel view) {
        this.customersListPanel = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);

        switch (src) {
            case "ADD" -> this.customersListPanel.addCustomer();
            case "EDIT" -> customersListPanel.editCustomer();
            case "DELETE" -> customersListPanel.deleteCustomer();
            case "SEARCH" -> {
                try {
                    customersListPanel.searchCustomer();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

    }
}
