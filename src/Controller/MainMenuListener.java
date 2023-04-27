package Controller;

import View.CustomersListPage.CustomersListPanel;
import View.Home.HomePanel;

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
            CustomersListPanel customerListPanel = new CustomersListPanel();
        }
    }
}
