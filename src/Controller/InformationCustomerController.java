package Controller;

import View.CustomerPage.ListPanel.InformationCustomerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InformationCustomerController implements ActionListener {
    private InformationCustomerPanel informationCustomerPanel;
    private int ID;
    public InformationCustomerController(InformationCustomerPanel view ) {
        this.informationCustomerPanel = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);

        if (src.equals("SAVE")){
            try {
                informationCustomerPanel.saveCustomer();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (src.equals("CANCEL")){
            informationCustomerPanel.cancelCustomer();
        }
    }
}
