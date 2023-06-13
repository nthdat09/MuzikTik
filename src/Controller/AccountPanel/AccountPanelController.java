package Controller.AccountPanel;

import View.SettingPage.AccountPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AccountPanelController implements ActionListener {
    private AccountPanel accountPanel;

    public AccountPanelController(AccountPanel accountPanel) {
        this.accountPanel = accountPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        switch (src) {
            case "SAVE" -> {
                try {
                    accountPanel.save();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            case "CANCEL" -> accountPanel.cancel();
            case "UPLOAD NEW AVATAR" -> accountPanel.uploadNewAvatar();
            case "CHANGE PASSWORD" -> {
                System.out.println("Change password");
                accountPanel.changePassword();
            }
        }

    }
}
