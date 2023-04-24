package Controller;

import View.LoginPage.LoginPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuListener implements ActionListener {

    private LoginPage view;

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();

    }
}
