package Controller.LoginPage;

import View.LoginPage.LoginPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginPageListener implements ActionListener, KeyListener {
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
        else if (src.equals("Forgot Password?")) {
            this.loginPage.SwitchToForgotPasswordPage();
        }
        else if (src.equals("Register Account")) {
            this.loginPage.SwitchToRegisterAccountPage();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.loginPage.DoLogin();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
