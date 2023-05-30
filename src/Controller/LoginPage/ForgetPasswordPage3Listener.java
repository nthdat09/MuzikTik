package Controller.LoginPage;

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

        if (src.equals("OK")){
            this.forgotPasswordPage_3.goToNextPage();
        }
        else if (src.equals("BACK")){
            try {
                this.forgotPasswordPage_3.backToPreviousPage();
            } catch (MessagingException ex) {
                throw new RuntimeException(ex);
            } catch (EmailException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (src.equals("Show Password")){
            this.forgotPasswordPage_3.showPassword();
        }
        else if (src.equals("Hide Password")){
            this.forgotPasswordPage_3.hidePassword();
        }

    }
}
