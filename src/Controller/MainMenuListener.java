package Controller;

import View.CustomerListPanel.CustomerListPanel;
import View.LoginPage.LoginPage;
import View.MainMenu.MainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuListener implements ActionListener {

    private MainMenu mainMenu;

    public MainMenuListener (MainMenu view) {
        this.mainMenu = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);
        if (src.equals("CUSTOMER")) {
            CustomerListPanel customerListPanel = new CustomerListPanel();
            mainMenu.setContentPane(customerListPanel);
            mainMenu.revalidate();
        }
    }
}
