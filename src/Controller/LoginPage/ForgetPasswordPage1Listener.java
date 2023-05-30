package Controller.LoginPage;

import View.LoginPage.ForgetPasswordPage.ForgotPasswordPage_1;
import org.apache.commons.mail.EmailException;

import javax.mail.MessagingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgetPasswordPage1Listener implements ActionListener{
    private ForgotPasswordPage_1 forgotPasswordPage_1;

    public ForgetPasswordPage1Listener(ForgotPasswordPage_1 forgotPasswordPage_1) {
        this.forgotPasswordPage_1 = forgotPasswordPage_1;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();

        if (src.equals("NEXT")) {
            try {
                this.forgotPasswordPage_1.goToNextPage();
            } catch (MessagingException ex) {
                throw new RuntimeException(ex);
            } catch (EmailException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (src.equals("BACK")) {
            this.forgotPasswordPage_1.backToPreviousPage();
        }

    }
}
