package Controller.TicketPage;

import View.TicketPage.ComfirmTicketDeleteJPopupMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TicketDeleteConfirmJDialogController implements ActionListener {
    private ComfirmTicketDeleteJPopupMenu comfirmDeleteJPopupMenu;

    public TicketDeleteConfirmJDialogController(ComfirmTicketDeleteJPopupMenu comfirmDeleteJPopupMenu) {
        this.comfirmDeleteJPopupMenu = comfirmDeleteJPopupMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);
        if (src.equals("YES")){
            try {
                comfirmDeleteJPopupMenu.deleteTicket();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (src.equals("NO")){
            comfirmDeleteJPopupMenu.cancelDeleteTicket();
        }

    }
}
