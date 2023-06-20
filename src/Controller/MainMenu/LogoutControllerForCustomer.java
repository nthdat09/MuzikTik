package Controller.MainMenu;

import View.MainPage.MainPage;
import View.MainPage.MainPageCustomer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutControllerForCustomer implements ActionListener {
    private MainPageCustomer mainPageCustomer;

    public LogoutControllerForCustomer(MainPageCustomer mainPageCustomer) {
        this.mainPageCustomer = mainPageCustomer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("LOGOUT")){
            mainPageCustomer.logout();
        }

    }
}
