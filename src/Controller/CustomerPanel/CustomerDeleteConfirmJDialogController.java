package Controller.CustomerPanel;

import View.CustomersListPage.ComfirmCustomerDeleteJPopupMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CustomerDeleteConfirmJDialogController implements ActionListener {
    private ComfirmCustomerDeleteJPopupMenu comfirmDeleteJPopupMenu;

    public CustomerDeleteConfirmJDialogController(ComfirmCustomerDeleteJPopupMenu view) {
        this.comfirmDeleteJPopupMenu = view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);
        if (src.equals("YES")){
            try {
                comfirmDeleteJPopupMenu.deleteCustomer();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (src.equals("NO")){
            comfirmDeleteJPopupMenu.cancelDeleteCustomer();
        }
    }
}
