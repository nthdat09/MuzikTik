package Controller.MainMenu;

import View.MainPage.ConfirmLogoutJPopupMenu;
import View.MainPage.MainPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutController implements ActionListener {
    private MainPage mainPage;

    public LogoutController(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("LOGOUT")){
            mainPage.logout();
        }

    }

}
