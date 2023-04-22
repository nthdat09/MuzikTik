package Controller;

import View.LoginPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPageListener implements ActionListener {
private LoginPage view;

    public LoginPageListener (LoginPage view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();

            if(src.equals("LOGIN")){
                this.view.DoLogin();
            }

    }
}
