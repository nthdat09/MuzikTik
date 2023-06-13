package View.LoginPage.ForgetPasswordPage;

import Controller.LoginPage.ForgetPassword.ForgetPasswordPage2Listener;
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

    public ForgotPasswordPage_2() {
        initComponents();
    }

    public ForgotPasswordPage_2(int code, String userName, String email) throws EmailException {
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

    public ForgotPasswordPage_2(String email) throws MessagingException,  EmailException  {
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

    private void setResendTimeLeft() throws EmailException {
        ResendCodeJbt.setEnabled(false);
        new Thread(() -> {
            while (timeLeft > 0) {
                try {
                    Thread.sleep(1000);
                    timeLeft--;
                    ResendTimeLeft.setText(timeLeft + "s");
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
        // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
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
            EmailField.setForeground(new Color(0x61b884));

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
            ResendTimeLeft.setFont(new Font("Lato", Font.BOLD, 14));

            //---- BackJbt ----
            BackJbt.setText("BACK");
            BackJbt.setFont(new Font("Lato Black", Font.BOLD, 14));
            BackJbt.setBackground(new Color(0x61b884));
            BackJbt.setForeground(Color.white);

            GroupLayout ForgotPasswordPage_2JDialogContentPaneLayout = new GroupLayout(ForgotPasswordPage_2JDialogContentPane);
            ForgotPasswordPage_2JDialogContentPane.setLayout(ForgotPasswordPage_2JDialogContentPaneLayout);
            ForgotPasswordPage_2JDialogContentPaneLayout.setHorizontalGroup(
                ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup()
                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup()
                            .addComponent(label4)
                            .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createSequentialGroup()
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EmailField, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, ForgotPasswordPage_2JDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, ForgotPasswordPage_2JDialogContentPaneLayout.createSequentialGroup()
                                .addComponent(BackJbt, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(NextJbt)
                                .addGap(27, 27, 27))
                            .addGroup(GroupLayout.Alignment.TRAILING, ForgotPasswordPage_2JDialogContentPaneLayout.createSequentialGroup()
                                .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(ErrorText, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(VerifyCodeField, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ResendTimeLeft, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ResendCodeJbt)
                                .addGap(216, 216, 216))))
            );
            ForgotPasswordPage_2JDialogContentPaneLayout.setVerticalGroup(
                ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(label2)
                        .addGap(18, 18, 18)
                        .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup()
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(label4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createSequentialGroup()
                                .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup()
                                    .addComponent(VerifyCodeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ResendTimeLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ErrorText, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(84, Short.MAX_VALUE))
                            .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createSequentialGroup()
                                .addComponent(ResendCodeJbt, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addGroup(ForgotPasswordPage_2JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(BackJbt)
                                    .addComponent(NextJbt))
                                .addGap(23, 23, 23))))
            );
            ForgotPasswordPage_2JDialog.pack();
            ForgotPasswordPage_2JDialog.setLocationRelativeTo(ForgotPasswordPage_2JDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
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
