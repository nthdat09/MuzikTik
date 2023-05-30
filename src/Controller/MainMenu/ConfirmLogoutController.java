package Controller.MainMenu;

import View.MainPage.ConfirmLogoutJPopupMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmLogoutController implements ActionListener {
    private ConfirmLogoutJPopupMenu confirmLogoutJPopupMenu;

    public ConfirmLogoutController(ConfirmLogoutJPopupMenu confirmLogoutJPopupMenu) {
        this.confirmLogoutJPopupMenu = confirmLogoutJPopupMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("YES")){
            this.confirmLogoutJPopupMenu.Logout();
        } else if (src.equals("NO")){
            this.confirmLogoutJPopupMenu.cancelLogout();
        }

    }
}
