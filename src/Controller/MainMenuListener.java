package Controller;

import View.CustomerListPanel.*;
import View.HomePage.HomePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuListener implements ActionListener {

    private HomePanel mainMenu;

    public MainMenuListener (HomePanel view) {
        this.mainMenu = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);
        if (src.equals("CUSTOMER")) {
            CustomerListPanel customerListPanel = new CustomerListPanel();
        }
    }
}
