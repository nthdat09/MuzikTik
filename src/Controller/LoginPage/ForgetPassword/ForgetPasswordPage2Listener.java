package Controller.LoginPage.ForgetPassword;

import View.LoginPage.ForgetPasswordPage.ForgotPasswordPage_2;
import org.apache.commons.mail.EmailException;

import javax.mail.MessagingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgetPasswordPage2Listener implements ActionListener {
    private ForgotPasswordPage_2 forgotPasswordPage_2;

    public ForgetPasswordPage2Listener(ForgotPasswordPage_2 forgotPasswordPage_2) {
        this.forgotPasswordPage_2 = forgotPasswordPage_2;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();

        switch (src) {
            case "VERIFY" -> this.forgotPasswordPage_2.goToNextPage();
            case "BACK" -> this.forgotPasswordPage_2.backToPreviousPage();
            case "RESEND CODE" -> {
                try {
                    this.forgotPasswordPage_2.resendCode();
                } catch (MessagingException | EmailException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

    }
}
