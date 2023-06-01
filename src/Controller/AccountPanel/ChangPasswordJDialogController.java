package Controller.AccountPanel;

import View.SettingPage.ChangPasswordJDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangPasswordJDialogController implements ActionListener {
    private ChangPasswordJDialog changPasswordJDialog;

    public ChangPasswordJDialogController(ChangPasswordJDialog changPasswordJDialog) {
        this.changPasswordJDialog = changPasswordJDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        switch (src) {
            case "OK" -> changPasswordJDialog.save();
            case "Cancel" -> changPasswordJDialog.cancel();
            case "Show Password" -> changPasswordJDialog.showPassword();
            case "Hide Password" -> changPasswordJDialog.hidePassword();
        }


    }
}
