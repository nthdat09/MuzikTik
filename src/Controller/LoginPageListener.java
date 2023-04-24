package Controller;

import View.CustomerPanel.CustomerPanel;
import View.LoginPage.LoginPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPageListener implements ActionListener {
private LoginPage loginPage;

    public LoginPageListener (LoginPage view) {
        this.loginPage = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("LOGIN")) {
            this.loginPage.DoLogin();
        }

    }
}
