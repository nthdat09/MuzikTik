/*
 * Created by JFormDesigner on Mon Apr 24 09:08:31 ICT 2023
 */

package View.CustomerPage.ListPanel;

import Model.BEAN.CustomerListP;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author ADMIN
 */
public class InformationCustomerPanel extends JPanel {
    public InformationCustomerPanel() {
        initComponents();
    }

    public InformationCustomerPanel(CustomerListP customerListP){
        initComponents();
        initMoreSetting(customerListP);
    }

    public void initMoreSetting(CustomerListP customerListP) {
        this.NameVal.setText(customerListP.getName());
        this.AddressVal.setText(customerListP.getAddress());
        this.PhoneNumberVal.setText(customerListP.getPhoneNumber());
        this.WalletBalanceVal.setText(String.valueOf(customerListP.getTotalPoint()));
        this.EmailVal.setText(customerListP.getEmail());
    }

    public String getName() {
        return this.Name.getText();
    }

    public JLabel getEmail() {
        return this.Email;
    }

    public JLabel getAddress() {
        return this.Address;
    }

    public JLabel getPhoneNumber() {
        return this.PhoneNumber;
    }

    public JButton getCancel() {
        return this.Cancel;
    }

    public JLabel getNameVal() {
        return this.NameVal;
    }

    public JLabel getEmailVal() {
        return this.EmailVal;
    }

    public JLabel getAddressVal() {
        return this.AddressVal;
    }

    public JLabel getPhoneNumberVal() {
        return this.PhoneNumberVal;
    }

    public JButton getButton8() {
        return this.button8;
    }

    public JLabel getWalletBalance() {
        return this.WalletBalance;
    }

    public JLabel getWalletBalanceVal() {
        return this.WalletBalanceVal;
    }

    public JPanel getInformationCustomerPanel() {
        return this.InformationCustomerPanel;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
        this.InformationCustomerPanel = new JPanel();
        this.Name = new JLabel();
        this.Email = new JLabel();
        this.Address = new JLabel();
        this.PhoneNumber = new JLabel();
        this.Cancel = new JButton();
        this.NameVal = new JLabel();
        this.EmailVal = new JLabel();
        this.AddressVal = new JLabel();
        this.PhoneNumberVal = new JLabel();
        this.button8 = new JButton();
        this.WalletBalance = new JLabel();
        this.WalletBalanceVal = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
        EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax.swing
        .border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),
        java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))
        throw new RuntimeException();}});

        //---- Name ----
        this.Name.setText("Name:");
        this.Name.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- Email ----
        this.Email.setText("Email:");
        this.Email.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- Address ----
        this.Address.setText("Address:");
        this.Address.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- PhoneNumber ----
        this.PhoneNumber.setText("Number Phone:");
        this.PhoneNumber.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- Cancel ----
        this.Cancel.setText("CANCEL");
        this.Cancel.setPreferredSize(new Dimension(80, 30));
        this.Cancel.setFont(new Font("Lato Black", Font.BOLD, 18));
        this.Cancel.setBackground(new Color(0x61b884));
        this.Cancel.setForeground(Color.white);

        //---- NameVal ----
        this.NameVal.setText("text");
        this.NameVal.setFont(new Font("Lato", Font.PLAIN, 20));
        this.NameVal.setForeground(new Color(0x61b884));

        //---- EmailVal ----
        this.EmailVal.setText("text");
        this.EmailVal.setFont(new Font("Lato", Font.PLAIN, 20));
        this.EmailVal.setForeground(new Color(0x61b884));

        //---- AddressVal ----
        this.AddressVal.setText("text");
        this.AddressVal.setFont(new Font("Lato", Font.PLAIN, 20));
        this.AddressVal.setForeground(new Color(0x61b884));

        //---- PhoneNumberVal ----
        this.PhoneNumberVal.setText("text");
        this.PhoneNumberVal.setFont(new Font("Lato", Font.PLAIN, 20));
        this.PhoneNumberVal.setForeground(new Color(0x61b884));

        //---- button8 ----
        this.button8.setText("SAVE");
        this.button8.setPreferredSize(new Dimension(80, 30));
        this.button8.setFont(new Font("Lato Black", Font.BOLD, 18));
        this.button8.setBackground(new Color(0x61b884));
        this.button8.setForeground(Color.white);

        //---- WalletBalance ----
        this.WalletBalance.setFont(new Font("Lato Black", Font.BOLD, 20));
        this.WalletBalance.setText("Wallet Balance");

        //---- WalletBalanceVal ----
        this.WalletBalanceVal.setText("text");
        this.WalletBalanceVal.setFont(new Font("Lato", Font.PLAIN, 20));
        this.WalletBalanceVal.setForeground(new Color(0x61b884));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(414, Short.MAX_VALUE)
                    .addComponent(this.button8, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(this.Cancel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(214, 214, 214))
                .addGroup(layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(this.WalletBalance, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(this.WalletBalanceVal, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(this.Name, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(this.Email, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(this.Address, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(this.AddressVal, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 3, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(this.PhoneNumber, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(this.PhoneNumberVal, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addComponent(this.EmailVal, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.NameVal, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(464, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.NameVal)
                        .addComponent(this.Name, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.EmailVal)
                        .addComponent(this.Email, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(11, 11, 11)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.Address, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.AddressVal))
                    .addGap(25, 25, 25)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.PhoneNumber, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.PhoneNumberVal))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(this.WalletBalance, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(this.WalletBalanceVal)))
                    .addGap(45, 45, 45)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.Cancel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.button8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
    JPanel InformationCustomerPanel;
    JLabel Name;
    JLabel Email;
    JLabel Address;
    JLabel PhoneNumber;
    JButton Cancel;
    JLabel NameVal;
    JLabel EmailVal;
    JLabel AddressVal;
    JLabel PhoneNumberVal;
    JButton button8;
    JLabel WalletBalance;
    JLabel WalletBalanceVal;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
