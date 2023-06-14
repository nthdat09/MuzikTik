package View.LoginPage.RegisterAccountPage;

import Controller.LoginPage.RegisterAccount.RegisterAccountPageListener_3;
import Model.BEAN.Customer.Customer;
import Model.DAO.Customer.CustomerDAO;
import View.LoginPage.LoginPage;
import org.apache.commons.mail.EmailException;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterAccountPage_3 extends JPanel {
    Customer customer;
    String email;
    ActionListener ac = new RegisterAccountPageListener_3(this);

    public RegisterAccountPage_3(Customer customer, String email) {
        initComponents();
        this.customer = customer;
        this.email = email;
        OKJbt.addActionListener(ac);
        BackJbt.addActionListener(ac);
        ShowPasswordJbt.addActionListener(ac);
    }

    public void goToNextPage() {
        if (getNewPasswordField().getText().equals("") || getReTypeNewPasswordField().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields!");
        }
        else {
            if (getNewPasswordField().getText().equals(getReTypeNewPasswordField().getText())) {
                customer.setPassword(getNewPasswordField().getText());
                System.out.println(customer.toString());

                int rowChanged = CustomerDAO.getInstance().addNewCustomer(customer);
                if (rowChanged == 0) {
                    JOptionPane.showMessageDialog(null, "Register account failed!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Register account successfully!");
                    LoginPage loginPage = new LoginPage();
                    loginPage.getLoginPageDialog().setVisible(true);
                    getRegisterAccountJDialog_3().setVisible(false);
                }
            } else {
                getErrorText().setText("Password is not match!");
            }
        }
    }
    public void backToPreviousPage() throws MessagingException, EmailException {
        RegisterAccountPage_2 registerAccountPage_2 = new RegisterAccountPage_2(customer.getEmail());
        registerAccountPage_2.getRegisterAccountJDialog_2().setVisible(true);
        RegisterAccountJDialog_3.dispose();
    }
    public void showPassword() {
        getNewPasswordField().setEchoChar((char) 0);
        getReTypeNewPasswordField().setEchoChar((char) 0);
        getShowPasswordJbt().setText("HIDE");
    }

    public void hidePassword() {
        getNewPasswordField().setEchoChar('*');
        getReTypeNewPasswordField().setEchoChar('*');
        getShowPasswordJbt().setText("SHOW");
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

    public JDialog getRegisterAccountJDialog_3() {
        return RegisterAccountJDialog_3;
    }

    public JButton getOKJbt() {
        return OKJbt;
    }

    public JButton getBackJbt() {
        return BackJbt;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        RegisterAccountJDialog_3 = new JDialog();
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

        //======== RegisterAccountJDialog_3 ========
        {
            RegisterAccountJDialog_3.setTitle("MuzikTic - Concert Music Ticketing");
            RegisterAccountJDialog_3.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var RegisterAccountJDialog_3ContentPane = RegisterAccountJDialog_3.getContentPane();

            //---- label2 ----
            label2.setText("REGISTER ACCOUNT");
            label2.setFont(new Font("Lato Black", Font.PLAIN, 24));
            label2.setForeground(new Color(0x61b884));
            label2.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label4 ----
            label4.setText("Password");
            label4.setFont(new Font("Lato Black", Font.PLAIN, 14));
            label4.setForeground(new Color(0x61b884));

            //---- NewPasswordField ----
            NewPasswordField.setFont(new Font("Lato Black", Font.PLAIN, 14));

            //---- label5 ----
            label5.setText("Verify success, enter your password below");
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
            label6.setText("Re-type password:");
            label6.setFont(new Font("Lato Black", Font.PLAIN, 14));
            label6.setForeground(new Color(0x61b884));

            //---- ReTypeNewPasswordField ----
            ReTypeNewPasswordField.setFont(new Font("Lato Black", Font.PLAIN, 14));

            //---- BackJbt ----
            BackJbt.setText("BACK");
            BackJbt.setFont(new Font("Lato Black", Font.PLAIN, 14));
            BackJbt.setBackground(new Color(0x61b884));
            BackJbt.setForeground(Color.white);

            GroupLayout RegisterAccountJDialog_3ContentPaneLayout = new GroupLayout(RegisterAccountJDialog_3ContentPane);
            RegisterAccountJDialog_3ContentPane.setLayout(RegisterAccountJDialog_3ContentPaneLayout);
            RegisterAccountJDialog_3ContentPaneLayout.setHorizontalGroup(
                RegisterAccountJDialog_3ContentPaneLayout.createParallelGroup()
                    .addGroup(RegisterAccountJDialog_3ContentPaneLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(RegisterAccountJDialog_3ContentPaneLayout.createParallelGroup()
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
                            .addGroup(RegisterAccountJDialog_3ContentPaneLayout.createSequentialGroup()
                                .addGroup(RegisterAccountJDialog_3ContentPaneLayout.createParallelGroup()
                                    .addGroup(RegisterAccountJDialog_3ContentPaneLayout.createSequentialGroup()
                                        .addComponent(label6)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(RegisterAccountJDialog_3ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(NewPasswordField, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                            .addComponent(ErrorText, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                            .addComponent(ReTypeNewPasswordField, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
                                    .addComponent(label4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ShowPasswordJbt))
                            .addGroup(GroupLayout.Alignment.TRAILING, RegisterAccountJDialog_3ContentPaneLayout.createSequentialGroup()
                                .addComponent(BackJbt)
                                .addGap(18, 18, 18)
                                .addComponent(OKJbt, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
            );
            RegisterAccountJDialog_3ContentPaneLayout.setVerticalGroup(
                RegisterAccountJDialog_3ContentPaneLayout.createParallelGroup()
                    .addGroup(RegisterAccountJDialog_3ContentPaneLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RegisterAccountJDialog_3ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(NewPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ShowPasswordJbt))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RegisterAccountJDialog_3ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReTypeNewPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ErrorText, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(RegisterAccountJDialog_3ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(OKJbt)
                            .addComponent(BackJbt))
                        .addGap(131, 131, 131))
            );
            RegisterAccountJDialog_3.pack();
            RegisterAccountJDialog_3.setLocationRelativeTo(RegisterAccountJDialog_3.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
    private JDialog RegisterAccountJDialog_3;
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
