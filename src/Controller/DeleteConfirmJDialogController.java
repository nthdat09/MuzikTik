package Controller;

import View.CustomerPage.ListPanel.ComfirmDeleteJPopupMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteConfirmJDialogController implements ActionListener {
    private ComfirmDeleteJPopupMenu comfirmDeleteJPopupMenu;

    public  DeleteConfirmJDialogController(ComfirmDeleteJPopupMenu view) {
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
