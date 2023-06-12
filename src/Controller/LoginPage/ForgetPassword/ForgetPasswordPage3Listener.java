package Controller.LoginPage.ForgetPassword;

import View.LoginPage.ForgetPasswordPage.ForgotPasswordPage_3;
import org.apache.commons.mail.EmailException;

import javax.mail.MessagingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgetPasswordPage3Listener implements ActionListener {
    private ForgotPasswordPage_3 forgotPasswordPage_3;

    public ForgetPasswordPage3Listener(ForgotPasswordPage_3 forgotPasswordPage_3) {
        this.forgotPasswordPage_3 = forgotPasswordPage_3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();

        switch (src) {
            case "OK" -> this.forgotPasswordPage_3.goToNextPage();
            case "BACK" -> {
                try {
                    this.forgotPasswordPage_3.backToPreviousPage();
                } catch (MessagingException | EmailException ex) {
                    throw new RuntimeException(ex);
                }
            }
            case "SHOW" -> this.forgotPasswordPage_3.showPassword();
            case "HIDE" -> this.forgotPasswordPage_3.hidePassword();
        }

    }
}
