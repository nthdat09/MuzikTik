package View.LoginPage.RegisterAccountPage;

import Controller.LoginPage.ForgetPassword.ForgetPasswordPage2Listener;
import Controller.LoginPage.RegisterAccount.RegisterAccountPageListener_2;
import Model.BEAN.Customer;
import Model.DAO.Employee.SendEmail;
import Model.DAO.Employee.VerificationCode;
import View.LoginPage.ForgetPasswordPage.ForgotPasswordPage_1;
import View.LoginPage.ForgetPasswordPage.ForgotPasswordPage_2;
import View.LoginPage.ForgetPasswordPage.ForgotPasswordPage_3;
import org.apache.commons.mail.EmailException;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterAccountPage_2 {
    private int verificationCode;
    private Customer customer;
    private String email;
    private int timeLeft = 30;
    ActionListener ac = new RegisterAccountPageListener_2(this);

    public RegisterAccountPage_2(Customer customer, int code) {
        initComponents();
        this.customer = customer;
        this.email = customer.getEmail();
        EmailField.setText(email);
        this.verificationCode = code;
        System.out.println(verificationCode);

        this.ResendCodeJbt.addActionListener(ac);
        this.NextJbt.addActionListener(ac);
        this.BackJbt.addActionListener(ac);

        setResendTimeLeft();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                SendEmail.sendCodeToEmail(verificationCode, email);
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }

    public RegisterAccountPage_2(String email) throws MessagingException {
        initComponents();
        EmailField.setText(email);

        this.email = email;
        this.ResendCodeJbt.addActionListener(ac);
        this.NextJbt.addActionListener(ac);
        this.BackJbt.addActionListener(ac);

        setResendTimeLeft();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                this.verificationCode = VerificationCode.createVerificationCode();
                SendEmail.sendCodeToEmail(verificationCode, email);
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }

    private void setResendTimeLeft() {
        ResendCodeJbt.setEnabled(false);
        new Thread(() -> {
            while (timeLeft > 0) {
                try {
                    Thread.sleep(1000);
                    timeLeft--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ResendCodeJbt.setEnabled(true);
            ResendTimeLeft.setText("");
        }).start();

        this.timeLeft = 30;
    }

    public void goToNextPage() {
        if (VerifyCodeField.getText().equals("")) {
            ErrorText.setText("Please enter verification code");
            ErrorText.setVisible(true);
        }
        else {
            int code = Integer.parseInt(VerifyCodeField.getText());
            if (code == verificationCode) {
                RegisterAccountPage_3 registerAccountPage_3 = new RegisterAccountPage_3(customer, email);
                registerAccountPage_3.getRegisterAccountJDialog_3().setVisible(true);
                getRegisterAccountJDialog_2().setVisible(false);
            } else {
                ErrorText.setText("Wrong verification code");
                ErrorText.setVisible(true);
            }
        }
    }
    public void backToPreviousPage() {
        RegisterAccountPage_1 registerAccountPage_1 = new RegisterAccountPage_1(customer);
        registerAccountPage_1.getRegisterAccountJDialog_1().setVisible(true);
        getRegisterAccountJDialog_2().setVisible(false);
    }
    public void resendCode() throws MessagingException, EmailException {
        setResendTimeLeft();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                this.verificationCode = VerificationCode.createVerificationCode();
                System.out.println("Re-send code to email");
                SendEmail.sendCodeToEmail(verificationCode, email);
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }

    public JDialog getRegisterAccountJDialog_2() {
        return RegisterAccountJDialog_2;
    }

    public JTextField getVerifyCodeField() {
        return VerifyCodeField;
    }

    public JButton getNextJbt() {
        return NextJbt;
    }

    public JLabel getEmailField() {
        return EmailField;
    }

    public JButton getResendCodeJbt() {
        return ResendCodeJbt;
    }

    public JLabel getErrorText() {
        return ErrorText;
    }

    public JLabel getResendTimeLeft() {
        return ResendTimeLeft;
    }

    public JButton getBackJbt() {
        return BackJbt;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        RegisterAccountJDialog_2 = new JDialog();
        label2 = new JLabel();
        label4 = new JLabel();
        VerifyCodeField = new JTextField();
        label5 = new JLabel();
        NextJbt = new JButton();
        EmailField = new JLabel();
        ResendCodeJbt = new JButton();
        ErrorText = new JLabel();
        ResendTimeLeft = new JLabel();
        BackJbt = new JButton();

        //======== RegisterAccountJDialog_2 ========
        {
            RegisterAccountJDialog_2.setTitle("MuzikTic - Concert Music Ticketing");
            RegisterAccountJDialog_2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var RegisterAccountJDialog_2ContentPane = RegisterAccountJDialog_2.getContentPane();

            //---- label2 ----
            label2.setText("REGISTER ACCOUNT");
            label2.setFont(new Font("Lato Black", Font.BOLD, 24));
            label2.setForeground(new Color(0x61b884));
            label2.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label4 ----
            label4.setText("Enter verification code here");
            label4.setFont(new Font("Lato", Font.PLAIN, 14));

            //---- VerifyCodeField ----
            VerifyCodeField.setFont(new Font("Lato", Font.PLAIN, 14));

            //---- label5 ----
            label5.setText("Your verification code will be sent to email:");
            label5.setFont(new Font("Lato Black", Font.PLAIN, 14));

            //---- NextJbt ----
            NextJbt.setText("VERIFY");
            NextJbt.setFont(new Font("Lato Black", Font.BOLD, 14));
            NextJbt.setBackground(new Color(0x61b884));
            NextJbt.setForeground(Color.white);

            //---- EmailField ----
            EmailField.setBorder(null);
            EmailField.setFont(new Font("Lato Black", Font.BOLD | Font.ITALIC, 14));

            //---- ResendCodeJbt ----
            ResendCodeJbt.setText("RESEND CODE");
            ResendCodeJbt.setFont(new Font("Lato Black", Font.BOLD, 14));
            ResendCodeJbt.setBackground(new Color(0x61b884));
            ResendCodeJbt.setForeground(Color.white);

            //---- ErrorText ----
            ErrorText.setForeground(new Color(0xd45c5c));
            ErrorText.setBackground(Color.white);
            ErrorText.setFont(new Font("Lato Black", Font.PLAIN, 14));

            //---- ResendTimeLeft ----
            ResendTimeLeft.setFont(new Font("Lato", Font.PLAIN, 14));

            //---- BackJbt ----
            BackJbt.setText("BACK");
            BackJbt.setFont(new Font("Lato Black", Font.BOLD, 14));
            BackJbt.setBackground(new Color(0x61b884));
            BackJbt.setForeground(Color.white);

            GroupLayout RegisterAccountJDialog_2ContentPaneLayout = new GroupLayout(RegisterAccountJDialog_2ContentPane);
            RegisterAccountJDialog_2ContentPane.setLayout(RegisterAccountJDialog_2ContentPaneLayout);
            RegisterAccountJDialog_2ContentPaneLayout.setHorizontalGroup(
                RegisterAccountJDialog_2ContentPaneLayout.createParallelGroup()
                    .addGroup(RegisterAccountJDialog_2ContentPaneLayout.createSequentialGroup()
                        .addGroup(RegisterAccountJDialog_2ContentPaneLayout.createParallelGroup()
                            .addGroup(RegisterAccountJDialog_2ContentPaneLayout.createSequentialGroup()
                                .addGap(319, 319, 319)
                                .addComponent(EmailField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
                            .addGroup(RegisterAccountJDialog_2ContentPaneLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(RegisterAccountJDialog_2ContentPaneLayout.createParallelGroup()
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(RegisterAccountJDialog_2ContentPaneLayout.createSequentialGroup()
                                        .addComponent(ResendCodeJbt)
                                        .addGap(18, 18, 18)
                                        .addComponent(ResendTimeLeft, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(ErrorText, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label4)
                                    .addComponent(VerifyCodeField, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(178, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, RegisterAccountJDialog_2ContentPaneLayout.createSequentialGroup()
                        .addGap(0, 456, Short.MAX_VALUE)
                        .addComponent(BackJbt)
                        .addGap(18, 18, 18)
                        .addComponent(NextJbt)
                        .addGap(31, 31, 31))
                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
            );
            RegisterAccountJDialog_2ContentPaneLayout.setVerticalGroup(
                RegisterAccountJDialog_2ContentPaneLayout.createParallelGroup()
                    .addGroup(RegisterAccountJDialog_2ContentPaneLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(label2)
                        .addGap(18, 18, 18)
                        .addGroup(RegisterAccountJDialog_2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailField))
                        .addGap(18, 18, 18)
                        .addComponent(label4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VerifyCodeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RegisterAccountJDialog_2ContentPaneLayout.createParallelGroup()
                            .addComponent(ErrorText, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ResendCodeJbt, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ResendTimeLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(RegisterAccountJDialog_2ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(NextJbt)
                            .addComponent(BackJbt))
                        .addGap(19, 19, 19))
            );
            RegisterAccountJDialog_2.pack();
            RegisterAccountJDialog_2.setLocationRelativeTo(RegisterAccountJDialog_2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
    private JDialog RegisterAccountJDialog_2;
    private JLabel label2;
    private JLabel label4;
    private JTextField VerifyCodeField;
    private JLabel label5;
    private JButton NextJbt;
    private JLabel EmailField;
    private JButton ResendCodeJbt;
    private JLabel ErrorText;
    private JLabel ResendTimeLeft;
    private JButton BackJbt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
