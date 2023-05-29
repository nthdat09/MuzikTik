package Controller.PartnerPage;

import View.PartnerPage.ConfirmPartnerDeleteJPopupMenu;
import View.StagesPage.ConfirmStageDeleteJPopupMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PartnerDeleteConfirmJDialogController implements ActionListener {
    private ConfirmPartnerDeleteJPopupMenu confirmPartnerDeleteJPopupMenu;

    public PartnerDeleteConfirmJDialogController(ConfirmPartnerDeleteJPopupMenu confirmPartnerDeleteJPopupMenu) {
        this.confirmPartnerDeleteJPopupMenu = confirmPartnerDeleteJPopupMenu;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);
        if (src.equals("YES")) {
            try {
                confirmPartnerDeleteJPopupMenu.deletePartner();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } else if (src.equals("NO")) {
            confirmPartnerDeleteJPopupMenu.cancelDeletePartner();
        }
    }
}
