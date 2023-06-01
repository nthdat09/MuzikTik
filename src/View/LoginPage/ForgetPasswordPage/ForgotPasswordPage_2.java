package View.LoginPage.ForgetPasswordPage;

import Controller.LoginPage.ForgetPasswordPage2Listener;
import Model.DAO.Employee.SendEmail;
import Model.DAO.Employee.VerificationCode;
import org.apache.commons.mail.EmailException;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.mail.MessagingException;
import javax.swing.*;

public class ForgotPasswordPage_2 extends JPanel {
    private int verificationCode;
    private String userName;
    private String email;
    private int timeLeft = 30;
    ActionListener ac = new ForgetPasswordPage2Listener(this);

    public ForgotPasswordPage_2(int code, String userName, String email) {
        initComponents();
        EmailField.setText(email);
        this.verificationCode = code;
        this.userName = userName;
        this.email = email;

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

    public ForgotPasswordPage_2(String email) throws MessagingException {
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
                ForgotPasswordPage_3 forgotPasswordPage_3 = new ForgotPasswordPage_3(userName, email);
                forgotPasswordPage_3.getForgotPasswordPage_3JDialog().setVisible(true);
                ForgotPasswordPage_2JDialog.dispose();
            } else {
                ErrorText.setText("Wrong verification code");
                ErrorText.setVisible(true);
            }
        }
    }
    public void backToPreviousPage() {
        ForgotPasswordPage_1 forgotPasswordPage_1 = new ForgotPasswordPage_1(userName);
        forgotPasswordPage_1.getForgotPasswordPage_1JDialog().setVisible(true);
        ForgotPasswordPage_2JDialog.dispose();
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

    public JDialog getForgotPasswordPage_2JDialog() {
        return ForgotPasswordPage_2JDialog;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        ForgotPasswordPage_2JDialog = new JDialog();
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

        //======== ForgotPasswordPage_2JDialog ========
        {
            ForgotPasswordPage_2JDialog.setTitle("MuzikTic - Concert Music Ticketing");
            ForgotPasswordPage_2JDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var ForgotPasswordPage_2JDialogContentPane = ForgotPasswordPage_2JDialog.getContentPane();

            //---- label2 ----
            label2.setText("FORGOT PASSWORD");
            label2.setFont(new Font("Fredoka One", Font.BOLD, 24));
            label2.setForeground(new Color(0xa8cf45));

            //---- label4 ----
            label4.setText("Enter verification code here");
            label4.setFont(new Font("Segoe UI", Font.BOLD, 16));

            //---- label5 ----
            label5.setText("Your verification code will be sent to email:");
            label5.setFont(new Font("Segoe UI", Font.PLAIN, 14));

            //---- NextJbt ----
            NextJbt.setText("VERIFY");

            //---- EmailField ----
            EmailField.setBorder(null);
            EmailField.setFont(new Font("Segoe UI", Font.BOLD, 14));

            //---- ResendCodeJbt ----
            ResendCodeJbt.setText("Resend code");

            //---- ErrorText ----
            ErrorText.setForeground(Color.red);
            ErrorText.setBackground(Color.white);

            //---- BackJbt ----
            BackJbt.setText("BACK");

            GroupLayout ForgotPasswordPage_2JDialogContentPaneLayout = new GroupLayout(ForgotPasswordPage_2JDialogContentPane);
            ForgotPasswordPage_2JDialogContentPane.setLayout(ForgotPasswordPage_2JDialogContentPaneLayout);
            ForgotPasswordPage_2JDialogContentPaneLayout.setHorizontalGroup(
                ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, ForgotPasswordPage_2JDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap(218, Short.MAX_VALUE)
                        .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(NextJbt)
                            .addComponent(label2))
                        .addGap(216, 216, 216))
                    .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createSequentialGroup()
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EmailField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
                            .addComponent(label4)
                            .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createSequentialGroup()
                                .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(BackJbt)
                                    .addComponent(VerifyCodeField, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(ResendCodeJbt)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ResendTimeLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(ErrorText, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(134, Short.MAX_VALUE))
            );
            ForgotPasswordPage_2JDialogContentPaneLayout.setVerticalGroup(
                ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(label2)
                        .addGap(18, 18, 18)
                        .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailField))
                        .addGap(57, 57, 57)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(ResendCodeJbt, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(VerifyCodeField, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(ResendTimeLeft, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(ErrorText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(NextJbt)
                            .addComponent(BackJbt))
                        .addGap(55, 55, 55))
            );
            ForgotPasswordPage_2JDialog.pack();
            ForgotPasswordPage_2JDialog.setLocationRelativeTo(ForgotPasswordPage_2JDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
    private JDialog ForgotPasswordPage_2JDialog;
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
