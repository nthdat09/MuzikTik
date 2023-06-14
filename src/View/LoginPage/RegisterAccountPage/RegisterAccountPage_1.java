/*
 * Created by JFormDesigner on Mon Jun 12 10:55:08 ICT 2023
 */

package View.LoginPage.RegisterAccountPage;

import Controller.LoginPage.RegisterAccount.RegisterAccountPageListener_1;
import Model.BEAN.Customer.Customer;
import Model.DAO.Customer.CustomerDAO;
import Model.DAO.Employee.VerificationCode;
import View.LoginPage.LoginPage;
import org.apache.commons.mail.EmailException;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.mail.MessagingException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Dat2
 */
public class RegisterAccountPage_1 {
    Customer customer;
    ActionListener actionListener = new RegisterAccountPageListener_1(this);
    String userName;
    public RegisterAccountPage_1() {
        initComponents();
        initMoreSetting();
    }

    public RegisterAccountPage_1(Customer customer){
        initComponents();
        initMoreSetting();
        this.customer = customer;
        getUserNameField().setText(customer.getUsername());
        getNameField().setText(customer.getName());
        getEmailField().setText(customer.getEmail());
        getPhoneNumberField().setText(customer.getPhoneNumber());
        getAddressField().setText(customer.getAddress());

    }

    public void initMoreSetting(){
        this.BackJbt.addActionListener(actionListener);
        this.NextJbt.addActionListener(actionListener);
    }

    public void goToNextPage() throws MessagingException, EmailException {
        if (userNameField.getText().equals("") || nameField.getText().equals("") || emailField.getText().equals("")
            || phoneNumberField.getText().equals("") || addressField.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
        else {
            userName = userNameField.getText();
            Customer customerCheck = CustomerDAO.getInstance().getCustomerByUsername(userName);

            if (customerCheck != null) {
                JOptionPane.showMessageDialog(null, "Username is exist");
            } else {
                int id = CustomerDAO.getInstance().getLastID() + 1;
                String name = nameField.getText();
                String email = emailField.getText();
                String phoneNumber = phoneNumberField.getText();
                String address = addressField.getText();

                Customer customer = new Customer(id, name, userName, "", phoneNumber, email, address, "BRONZE", 0, 0);

                int code = VerificationCode.createVerificationCode();

                RegisterAccountPage_2 registerAccountPage_2 = new RegisterAccountPage_2(customer, code);
                registerAccountPage_2.getRegisterAccountJDialog_2().setVisible(true);
                RegisterAccountJDialog_1.setVisible(false);
            }
        }

    }

    public void backToPreviousPage() {
        RegisterAccountJDialog_1.dispose();
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }
    public JTextField getUserNameField() {
        return userNameField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getPhoneNumberField() {
        return phoneNumberField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public JButton getBackJbt() {
        return BackJbt;
    }

    public JButton getNextJbt() {
        return NextJbt;
    }

    public JDialog getRegisterAccountJDialog_1() {
        return RegisterAccountJDialog_1;
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        RegisterAccountJDialog_1 = new JDialog();
        label2 = new JLabel();
        label4 = new JLabel();
        userNameField = new JTextField();
        nameField = new JTextField();
        phoneNumberField = new JTextField();
        emailField = new JTextField();
        addressField = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        BackJbt = new JButton();
        NextJbt = new JButton();

        //======== RegisterAccountJDialog_1 ========
        {
            RegisterAccountJDialog_1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var RegisterAccountJDialog_1ContentPane = RegisterAccountJDialog_1.getContentPane();

            //---- label2 ----
            label2.setText("REGISTER ACCOUNT");
            label2.setFont(new Font("Lato Black", Font.PLAIN, 24));
            label2.setForeground(new Color(0x61b884));
            label2.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label4 ----
            label4.setText("Username:");
            label4.setFont(new Font("Lato Black", Font.PLAIN, 14));
            label4.setForeground(new Color(0x61b884));

            //---- userNameField ----
            userNameField.setFont(new Font("Lato", Font.PLAIN, 14));

            //---- nameField ----
            nameField.setFont(new Font("Lato", Font.PLAIN, 14));

            //---- phoneNumberField ----
            phoneNumberField.setFont(new Font("Lato", Font.PLAIN, 14));

            //---- emailField ----
            emailField.setFont(new Font("Lato", Font.PLAIN, 14));

            //---- addressField ----
            addressField.setFont(new Font("Lato", Font.PLAIN, 14));

            //---- label5 ----
            label5.setText("Name:");
            label5.setFont(new Font("Lato Black", Font.PLAIN, 14));
            label5.setForeground(new Color(0x61b884));

            //---- label6 ----
            label6.setText("Phone Number:");
            label6.setFont(new Font("Lato Black", Font.PLAIN, 14));
            label6.setForeground(new Color(0x61b884));

            //---- label7 ----
            label7.setText("Email:");
            label7.setFont(new Font("Lato Black", Font.PLAIN, 14));
            label7.setForeground(new Color(0x61b884));

            //---- label8 ----
            label8.setText("Address:");
            label8.setFont(new Font("Lato Black", Font.PLAIN, 14));
            label8.setForeground(new Color(0x61b884));

            //---- BackJbt ----
            BackJbt.setText("BACK");
            BackJbt.setFont(new Font("Lato Black", Font.BOLD, 14));
            BackJbt.setBackground(new Color(0x61b884));
            BackJbt.setForeground(Color.white);

            //---- NextJbt ----
            NextJbt.setText("NEXT");
            NextJbt.setFont(new Font("Lato Black", Font.BOLD, 14));
            NextJbt.setBackground(new Color(0x61b884));
            NextJbt.setForeground(Color.white);

            GroupLayout RegisterAccountJDialog_1ContentPaneLayout = new GroupLayout(RegisterAccountJDialog_1ContentPane);
            RegisterAccountJDialog_1ContentPane.setLayout(RegisterAccountJDialog_1ContentPaneLayout);
            RegisterAccountJDialog_1ContentPaneLayout.setHorizontalGroup(
                RegisterAccountJDialog_1ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, RegisterAccountJDialog_1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(280, Short.MAX_VALUE)
                        .addComponent(BackJbt)
                        .addGap(26, 26, 26)
                        .addComponent(NextJbt)
                        .addGap(16, 16, 16))
                    .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createParallelGroup()
                            .addComponent(label8)
                            .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createSequentialGroup()
                                .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createParallelGroup()
                                    .addComponent(label4)
                                    .addComponent(label5))
                                .addGap(49, 49, 49)
                                .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createSequentialGroup()
                                .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createParallelGroup()
                                    .addComponent(label6)
                                    .addComponent(label7))
                                .addGap(18, 18, 18)
                                .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createParallelGroup()
                                    .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneNumberField, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addressField, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                        .addContainerGap())
            );
            RegisterAccountJDialog_1ContentPaneLayout.setVerticalGroup(
                RegisterAccountJDialog_1ContentPaneLayout.createParallelGroup()
                    .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(label2)
                        .addGap(18, 18, 18)
                        .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                            .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6))
                        .addGap(18, 18, 18)
                        .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(RegisterAccountJDialog_1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(NextJbt)
                            .addComponent(BackJbt))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            RegisterAccountJDialog_1.pack();
            RegisterAccountJDialog_1.setLocationRelativeTo(RegisterAccountJDialog_1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
    private JDialog RegisterAccountJDialog_1;
    private JLabel label2;
    private JLabel label4;
    private JTextField userNameField;
    private JTextField nameField;
    private JTextField phoneNumberField;
    private JTextField emailField;
    private JTextField addressField;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JButton BackJbt;
    private JButton NextJbt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
