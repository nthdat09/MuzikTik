package Controller.CustomerPanel;

import View.CustomersListPage.InformationCustomerForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InformationCustomerController implements ActionListener {
    private InformationCustomerForm informationCustomerForm;
    public InformationCustomerController(InformationCustomerForm view ) {
        this.informationCustomerForm = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);

        if (src.equals("SAVE")){
            try {
                informationCustomerForm.saveCustomer();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (src.equals("CANCEL")){
            informationCustomerForm.cancelCustomer();
        }
    }
}
