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
        if (src.equals("OK")) {
            changPasswordJDialog.save();
        }
        else if (src.equals("Cancel")) {
            changPasswordJDialog.cancel();
        }
        else if (src.equals("Show Password")) {
            changPasswordJDialog.showPassword();
        }

        else if (src.equals("Hide Password")){
            changPasswordJDialog.hidePassword();
        }


    }
}
