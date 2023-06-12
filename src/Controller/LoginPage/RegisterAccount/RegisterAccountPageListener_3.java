package Controller.LoginPage.RegisterAccount;

import View.LoginPage.RegisterAccountPage.RegisterAccountPage_3;
import org.apache.commons.mail.EmailException;

import javax.mail.MessagingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterAccountPageListener_3 implements ActionListener {
    private RegisterAccountPage_3 registerAccountPage_3;

    public RegisterAccountPageListener_3(RegisterAccountPage_3 registerAccountPage_3) {
        this.registerAccountPage_3 = registerAccountPage_3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("OK")) {
            this.registerAccountPage_3.goToNextPage();
        }
        else if (src.equals("BACK")) {
            try {
                this.registerAccountPage_3.backToPreviousPage();
            } catch (MessagingException ex) {
                throw new RuntimeException(ex);
            } catch (EmailException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (src.equals("SHOW")){
            this.registerAccountPage_3.showPassword();
        }

        else if (src.equals("HIDE")){
            this.registerAccountPage_3.hidePassword();
        }

    }
}
