package Controller;

import View.CustomersListPage.CustomersListPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerListListener implements ActionListener {
    private CustomersListPanel customersListPanel;

    public CustomerListListener(CustomersListPanel customersListPanel) {
        this.customersListPanel = customersListPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();

            this.customersListPanel.addCustomer();

    }
}
