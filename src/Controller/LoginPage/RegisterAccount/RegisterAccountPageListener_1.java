package Controller.LoginPage.RegisterAccount;

import View.LoginPage.RegisterAccountPage.RegisterAccountPage_1;
import org.apache.commons.mail.EmailException;

import javax.mail.MessagingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterAccountPageListener_1 implements ActionListener {
    private RegisterAccountPage_1 registerAccountPage_1;

    public RegisterAccountPageListener_1(RegisterAccountPage_1 registerAccountPage_1) {
        this.registerAccountPage_1 = registerAccountPage_1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();

        if (src.equals("NEXT")) {
            try {
                this.registerAccountPage_1.goToNextPage();
            } catch (MessagingException ex) {
                throw new RuntimeException(ex);
            } catch (EmailException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (src.equals("BACK")) {
            this.registerAccountPage_1.backToPreviousPage();
        }


    }
}
