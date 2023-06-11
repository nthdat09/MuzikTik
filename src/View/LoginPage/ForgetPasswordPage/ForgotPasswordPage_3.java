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

    public JButton getOKJbt() {
        return OKJbt;
    }

    public JButton getBackJbt() {
        return BackJbt;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
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
            label2.setFont(new Font("Lato Black", Font.PLAIN, 24));
            label2.setForeground(new Color(0x61b884));
            label2.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label4 ----
            label4.setText("New password:");
            label4.setFont(new Font("Lato Black", Font.PLAIN, 14));
            label4.setForeground(new Color(0x61b884));

            //---- NewPasswordField ----
            NewPasswordField.setFont(new Font("Lato Black", Font.PLAIN, 14));

            //---- label5 ----
            label5.setText("Verify success, enter your new password below");
            label5.setFont(new Font("Lato Black", Font.PLAIN, 14));

            //---- OKJbt ----
            OKJbt.setText("OK");
            OKJbt.setFont(new Font("Lato Black", Font.PLAIN, 14));
            OKJbt.setBackground(new Color(0x61b884));
            OKJbt.setForeground(Color.white);

            //---- ShowPasswordJbt ----
            ShowPasswordJbt.setText("SHOW");
            ShowPasswordJbt.setFont(new Font("Lato Black", Font.PLAIN, 14));
            ShowPasswordJbt.setBackground(new Color(0x61b884));
            ShowPasswordJbt.setForeground(Color.white);

            //---- ErrorText ----
            ErrorText.setFont(new Font("Lato Black", Font.PLAIN, 14));
            ErrorText.setForeground(new Color(0xd45c5c));

            //---- label6 ----
            label6.setText("Re-type new password:");
            label6.setFont(new Font("Lato Black", Font.PLAIN, 14));
            label6.setForeground(new Color(0x61b884));

            //---- ReTypeNewPasswordField ----
            ReTypeNewPasswordField.setFont(new Font("Lato Black", Font.PLAIN, 14));

            //---- BackJbt ----
            BackJbt.setText("BACK");
            BackJbt.setFont(new Font("Lato Black", Font.PLAIN, 14));
            BackJbt.setBackground(new Color(0x61b884));
            BackJbt.setForeground(Color.white);

            GroupLayout ForgotPasswordPage_3JDialogContentPaneLayout = new GroupLayout(ForgotPasswordPage_3JDialogContentPane);
            ForgotPasswordPage_3JDialogContentPane.setLayout(ForgotPasswordPage_3JDialogContentPaneLayout);
            ForgotPasswordPage_3JDialogContentPaneLayout.setHorizontalGroup(
                ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup()
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
                            .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                                .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup()
                                    .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                                        .addComponent(label6)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(NewPasswordField, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                            .addComponent(ErrorText, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                            .addComponent(ReTypeNewPasswordField, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
                                    .addComponent(label4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ShowPasswordJbt))
                            .addGroup(GroupLayout.Alignment.TRAILING, ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                                .addComponent(BackJbt)
                                .addGap(18, 18, 18)
                                .addComponent(OKJbt, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
            );
            ForgotPasswordPage_3JDialogContentPaneLayout.setVerticalGroup(
                ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(NewPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ShowPasswordJbt))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReTypeNewPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ErrorText, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ForgotPasswordPage_3JDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(OKJbt)
                            .addComponent(BackJbt))
                        .addGap(131, 131, 131))
            );
            ForgotPasswordPage_3JDialog.pack();
            ForgotPasswordPage_3JDialog.setLocationRelativeTo(ForgotPasswordPage_3JDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
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
