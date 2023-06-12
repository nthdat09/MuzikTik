package Controller.LoginPage.RegisterAccount;

import View.LoginPage.RegisterAccountPage.RegisterAccountPage_1;
import View.LoginPage.RegisterAccountPage.RegisterAccountPage_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterAccountPageListener_2 implements ActionListener {
    private RegisterAccountPage_2 registerAccountPage_2;

    public RegisterAccountPageListener_2(RegisterAccountPage_2 registerAccountPage_2) {
        this.registerAccountPage_2 = registerAccountPage_2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("VERIFY")) {
            this.registerAccountPage_2.goToNextPage();
        }
        else if (src.equals("BACK")) {
            this.registerAccountPage_2.backToPreviousPage();
        }

        else if (src.equals("Resend code")){
            try {
                this.registerAccountPage_2.resendCode();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
