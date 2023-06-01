package View.LoginPage.ForgetPasswordPage;

import Controller.LoginPage.ForgetPasswordPage3Listener;
import Model.DAO.Employee.EmployeeDAO;
import View.LoginPage.LoginPage;
import org.apache.commons.mail.EmailException;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.mail.MessagingException;
import javax.swing.*;

public class ForgotPasswordPage_3 extends JPanel {
    String userName;
    String email;
    ActionListener ac = new ForgetPasswordPage3Listener(this);

    public ForgotPasswordPage_3(String userName, String email) {
        initComponents();
        this.userName = userName;
        this.email = email;
        this.BackJbt.addActionListener(ac);
        this.OKJbt.addActionListener(ac);
        this.ShowPasswordJbt.addActionListener(ac);
    }

    public void goToNextPage() {
        if (getNewPasswordField().getText().equals("") || getReTypeNewPasswordField().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields!");
        }
        else {
            if (getNewPasswordField().getText().equals(getReTypeNewPasswordField().getText())) {
                JOptionPane.showMessageDialog(null, "Change password successfully!");
                EmployeeDAO.updatePasswordByUsername(userName, getNewPasswordField().getText());
                LoginPage loginPage = new LoginPage();
                loginPage.getLoginPageDialog().setVisible(true);
                ForgotPasswordPage_3JDialog.dispose();
            } else {
                getErrorText().setText("Password is not match!");
            }
        }
    }
    public void backToPreviousPage() throws MessagingException, EmailException {
        ForgotPasswordPage_2 forgotPasswordPage_2 = new ForgotPasswordPage_2(email);
        forgotPasswordPage_2.getForgotPasswordPage_2JDialog().setVisible(true);

        ForgotPasswordPage_3JDialog.dispose();
    }
    public void showPassword() {
        getNewPasswordField().setEchoChar((char) 0);
        getReTypeNewPasswordField().setEchoChar((char) 0);
        getShowPasswordJbt().setText("Hide Password");
    }

    public void hidePassword() {
        getNewPasswordField().setEchoChar('*');
        getReTypeNewPasswordField().setEchoChar('*');
        getShowPasswordJbt().setText("Show Password");
    }

    public JPasswordField getNewPasswordField() {
        return NewPasswordField;
    }

    public JButton getShowPasswordJbt() {
        return ShowPasswordJbt;
    }

    public JLabel getErrorText() {
        return ErrorText;
    }

    public JPasswordField getReTypeNewPasswordField() {
        return ReTypeNewPasswordField;
    }

    public JDialog getForgotPasswordPage_3JDialog() {
        return ForgotPasswordPage_3JDialog;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        ForgotPasswordPage_3JDialog = new JDialog();
        label2 = new JLabel();
        label4 = new JLabel();
        NewPasswordField = new JPasswordField();
        label5 = new JLabel();
        OKJbt = new JButton();
        ShowPasswordJbt = new JButton();
        ErrorText = new JLabel();
        label6 = new JLabel();
        ReTypeNewPasswordField = new JPasswordField();
        BackJbt = new JButton();

        //======== ForgotPasswordPage_3JDialog ========
        {
            ForgotPasswordPage_3JDialog.setTitle("MuzikTic - Concert Music Ticketing");
            ForgotPasswordPage_3JDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var ForgotPasswordPage_3JDialogContentPane = ForgotPasswordPage_3JDialog.getContentPane();

            //---- label2 ----
            label2.setText("FORGOT PASSWORD");
            label2.setFont(new Font("Fredoka One", Font.BOLD, 24));
            label2.setForeground(new Color(0xa8cf45));

            //---- label4 ----
            label4.setText("New Password");
            label4.setFont(new Font("Segoe UI", Font.BOLD, 16));

            //---- label5 ----
            label5.setText("Verify success, enter your new password below");
            label5.setFont(new Font("Segoe UI", Font.PLAIN, 14));

            //---- OKJbt ----
            OKJbt.setText("OK");

            //---- ShowPasswordJbt ----
            ShowPasswordJbt.setText("Show Password");

            //---- label6 ----
            label6.setText("Re-type New Password");
            label6.setFont(new Font("Segoe UI", Font.BOLD, 16));

            //---- BackJbt ----
            BackJbt.setText("BACK");

            GroupLayout ForgotPasswordPage_3JDialogContentPaneLayout = new GroupLayout(ForgotPasswordPage_3JDialogContentPane);
            ForgotPasswordPage_3JDialogContentPane.setLayout(ForgotPasswordPage_3JDialogContentPaneLayout);
            ForgotPasswordPage_3JDialogContentPaneLayout.setHorizontalGroup(
                ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup()
                            .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                                .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup()
                                    .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                        .addComponent(label2))
                                    .addGroup(GroupLayout.Alignment.TRAILING, ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(OKJbt)))
                                .addGap(216, 216, 216))
                            .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                                .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup()
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label6)
                                    .addComponent(label4)
                                    .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                                        .addComponent(NewPasswordField, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ShowPasswordJbt)))
                                .addContainerGap(174, Short.MAX_VALUE))
                            .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                                .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(BackJbt)
                                    .addComponent(ReTypeNewPasswordField, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ErrorText, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 326, Short.MAX_VALUE))))
            );
            ForgotPasswordPage_3JDialogContentPaneLayout.setVerticalGroup(
                ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(label2)
                        .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup()
                            .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(NewPasswordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ShowPasswordJbt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(54, 54, 54))
                            .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ReTypeNewPasswordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ErrorText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(OKJbt)
                            .addComponent(BackJbt))
                        .addGap(55, 55, 55))
            );
            ForgotPasswordPage_3JDialog.pack();
            ForgotPasswordPage_3JDialog.setLocationRelativeTo(ForgotPasswordPage_3JDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
    private JDialog ForgotPasswordPage_3JDialog;
    private JLabel label2;
    private JLabel label4;
    private JPasswordField NewPasswordField;
    private JLabel label5;
    private JButton OKJbt;
    private JButton ShowPasswordJbt;
    private JLabel ErrorText;
    private JLabel label6;
    private JPasswordField ReTypeNewPasswordField;
    private JButton BackJbt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
