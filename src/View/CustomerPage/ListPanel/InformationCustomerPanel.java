/*
 * Created by JFormDesigner on Mon Apr 24 09:08:31 ICT 2023
 */

package View.CustomerPage.ListPanel;

import Controller.InformationCustomerController;
import Model.BEAN.CustomerList;
import Model.BEAN.CustomerListP;
import Model.DAO.CustomerDAO;
import View.CustomerPage.CustomerPanel;
import View.CustomersListPage.CustomersListPanel;
import View.MainPage.MainPage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author ADMIN
 */
public class InformationCustomerPanel extends JPanel {
    static int selectedID = -1;

    ActionListener ac = new InformationCustomerController(this);
    public InformationCustomerPanel() {
        initComponents();
        getSAVE().addActionListener(ac);
        getCancel().addActionListener(ac);
    }

    public InformationCustomerPanel(CustomerListP customerListP){
        initComponents();
        initMoreSetting(customerListP);
        getSAVE().addActionListener(ac);
        getCancel().addActionListener(ac);
    }

    public void initMoreSetting(CustomerListP customerListP) {
        this.NameVal.setText(customerListP.getName());
        this.AddressVal.setText(customerListP.getAddress());
        this.PhoneNumberVal.setText(customerListP.getPhoneNumber());
        this.TotalPointVal.setText(String.valueOf(customerListP.getTotalPoint()));
        this.EmailVal.setText(customerListP.getEmail());
        this.selectedID = customerListP.getId();
        System.out.println("selected id = " + this.selectedID);
    }

    public String getName() {
        return this.Name.getText();
    }

    public static int getSelectedID() {
        return selectedID;
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

    public JButton getSAVE() {
        return this.SAVE;
    }

    public JLabel getWalletBalance() {
        return this.WalletBalance;
    }

    public JPanel getInformationCustomerPanel() {
        return this.InformationCustomerPanel;
    }

    public JTextField getNameVal() {
        return this.NameVal;
    }

    public JTextField getEmailVal() {
        return this.EmailVal;
    }

    public JTextField getAddressVal() {
        return this.AddressVal;
    }

    public JTextField getPhoneNumberVal() {
        return this.PhoneNumberVal;
    }

    public JTextField getTotalPointVal() {
        return this.TotalPointVal;
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
        this.SAVE = new JButton();
        this.WalletBalance = new JLabel();
        this.NameVal = new JTextField();
        this.EmailVal = new JTextField();
        this.AddressVal = new JTextField();
        this.PhoneNumberVal = new JTextField();
        this.TotalPointVal = new JTextField();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );

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
        this.PhoneNumber.setText("Phone Number");
        this.PhoneNumber.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- Cancel ----
        this.Cancel.setText("CANCEL");
        this.Cancel.setPreferredSize(new Dimension(80, 30));
        this.Cancel.setFont(new Font("Lato Black", Font.BOLD, 18));
        this.Cancel.setBackground(new Color(0x61b884));
        this.Cancel.setForeground(Color.white);

        //---- SAVE ----
        this.SAVE.setText("SAVE");
        this.SAVE.setPreferredSize(new Dimension(80, 30));
        this.SAVE.setFont(new Font("Lato Black", Font.BOLD, 18));
        this.SAVE.setBackground(new Color(0x61b884));
        this.SAVE.setForeground(Color.white);

        //---- WalletBalance ----
        this.WalletBalance.setFont(new Font("Lato Black", Font.BOLD, 20));
        this.WalletBalance.setText("Total Point");

        //---- NameVal ----
        this.NameVal.setBackground(Color.white);
        this.NameVal.setName("NameVal");

        //---- EmailVal ----
        this.EmailVal.setBackground(Color.white);
        this.EmailVal.setName("EmailVal");

        //---- AddressVal ----
        this.AddressVal.setBackground(Color.white);
        this.AddressVal.setName("AddressVal");

        //---- PhoneNumberVal ----
        this.PhoneNumberVal.setBackground(Color.white);
        this.PhoneNumberVal.setName("PhoneNumberVal");

        //---- TotalPointVal ----
        this.TotalPointVal.setBackground(Color.white);
        this.TotalPointVal.setName("TotalPointVal");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(67, 67, 67)
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(this.Name, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                            .addComponent(this.Email, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(this.PhoneNumber, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(this.WalletBalance, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(64, 64, 64)
                                    .addComponent(this.Address, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
                            .addGap(65, 65, 65)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(this.EmailVal, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(this.AddressVal, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(this.PhoneNumberVal, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(this.TotalPointVal, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(this.NameVal, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(298, 298, 298)
                            .addComponent(this.SAVE, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(this.Cancel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(330, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.Name, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.NameVal, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.Email, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.EmailVal, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.Address, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.AddressVal, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(this.PhoneNumber, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.PhoneNumberVal, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(this.WalletBalance, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.TotalPointVal, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.Cancel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.SAVE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(31, Short.MAX_VALUE))
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
    JButton SAVE;
    JLabel WalletBalance;
    JTextField NameVal;
    JTextField EmailVal;
    JTextField AddressVal;
    JTextField PhoneNumberVal;
    JTextField TotalPointVal;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void saveCustomer() throws SQLException {

        if (this.NameVal.equals("") || this.EmailVal.equals("") || this.AddressVal.equals("") || this.PhoneNumberVal.equals("") ) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        } else {
            CustomerListP customer = null;
            if (selectedID == -1 ) {
                customer = new CustomerListP();
            }
            else {
                customer = CustomerDAO.getInstance().selectByID(selectedID);
            }
            customer.setId(selectedID);
            customer.setName(this.NameVal.getText());
            customer.setEmail(this.EmailVal.getText());
            customer.setAddress(this.AddressVal.getText());
            customer.setPhoneNumber(this.PhoneNumberVal.getText());
            customer.setTotalPoint(Integer.parseInt(this.TotalPointVal.getText()));

            if (selectedID != -1) {
                CustomerDAO.getInstance().updateCustomer(customer);
            }
            else {
                CustomerDAO.getInstance().insertCustomer(customer);
            }
            MainPage.changeView(new CustomersListPanel().getCustomersListPage(), MainPage.getJlbCustomer(), "CustomerListPanel");
        }
    }
    public void cancelCustomer() {
        MainPage.changeView(new CustomersListPanel().getCustomersListPage(), MainPage.getJlbCustomer(), "CustomerListPanel");
    }
}
