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
        if (src.equals("SAVE")) {
            try {
                accountPanel.save();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (src.equals("CANCEL"))
            accountPanel.cancel();
        else if (src.equals("Upload new avatar")){
            accountPanel.uploadNewAvatar();
        }

    }
}
