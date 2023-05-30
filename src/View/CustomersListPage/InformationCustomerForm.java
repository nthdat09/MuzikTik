/*
 * Created by JFormDesigner on Mon Apr 24 09:08:31 ICT 2023
 */

package View.CustomersListPage;

import Controller.CustomerPanel.InformationCustomerController;
import Model.BEAN.CustomerListP;
import Model.DAO.Customer.CustomerDAO;
import View.MainPage.MainPage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author ADMIN
 */
public class InformationCustomerForm extends JPanel {
    static int selectedID = -1;

    ActionListener ac = new InformationCustomerController(this);
    public InformationCustomerForm() {
        initComponents();
        getSAVE().addActionListener(ac);
        getCancel().addActionListener(ac);
    }

    public InformationCustomerForm(int newID) {
        initComponents();
        getSAVE().addActionListener(ac);
        getCancel().addActionListener(ac);
        this.IDField.setText(String.valueOf(newID));
    }

    public InformationCustomerForm(CustomerListP customerListP){
        initComponents();
        initMoreSetting(customerListP);
        getSAVE().addActionListener(ac);
        getCancel().addActionListener(ac);
    }

    public void initMoreSetting(CustomerListP customerListP) {
        this.NameField.setText(customerListP.getName());
        this.AddressField.setText(customerListP.getAddress());
        this.PhoneNumberFiled.setText(customerListP.getPhoneNumber());
        this.TotalPointVal.setText(String.valueOf(customerListP.getTotalPoint()));
        this.EmailField.setText(customerListP.getEmail());
        this.TypeField.setText(customerListP.getType());
        this.selectedID = customerListP.getId();
        this.IDField.setText(String.valueOf(customerListP.getId()));
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

    public JLabel getTotalPoint() {
        return this.TotalPoint;
    }

    public JPanel getInformationCustomerPanel() {
        return this.InformationCustomerPanel;
    }

    public JTextField getNameField() {
        return this.NameField;
    }

    public JTextField getPhoneNumberFiled() {
        return this.PhoneNumberFiled;
    }

    public JTextField getEmailField() {
        return this.EmailField;
    }

    public JTextField getAddressField() {
        return this.AddressField;
    }

    public JTextField getTotalPointVal() {
        return this.TotalPointVal;
    }

    public JLabel getID() {
        return this.ID;
    }

    public JTextField getIDField() {
        return this.IDField;
    }

    public JLabel getType() {
        return this.Type;
    }

    public JTextField getTypeField() {
        return this.TypeField;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        this.InformationCustomerPanel = new JPanel();
        this.Name = new JLabel();
        this.Email = new JLabel();
        this.Address = new JLabel();
        this.PhoneNumber = new JLabel();
        this.Cancel = new JButton();
        this.SAVE = new JButton();
        this.TotalPoint = new JLabel();
        this.NameField = new JTextField();
        this.PhoneNumberFiled = new JTextField();
        this.EmailField = new JTextField();
        this.AddressField = new JTextField();
        this.TotalPointVal = new JTextField();
        this.ID = new JLabel();
        this.IDField = new JTextField();
        this.Type = new JLabel();
        this.TypeField = new JTextField();

        //======== this ========
        setBackground(Color.white);
        setMinimumSize(new Dimension(735, 548));
        setMaximumSize(new Dimension(735, 548));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;

        //---- Name ----
        this.Name.setText("Name:");
        this.Name.setFont(new Font("Lato Black", Font.BOLD | Font.ITALIC, 20));

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

        //---- TotalPoint ----
        this.TotalPoint.setFont(new Font("Lato Black", Font.BOLD, 20));
        this.TotalPoint.setText("Total Point");

        //---- NameField ----
        this.NameField.setBackground(Color.white);
        this.NameField.setName("NameVal");

        //---- PhoneNumberFiled ----
        this.PhoneNumberFiled.setBackground(Color.white);
        this.PhoneNumberFiled.setName("EmailVal");

        //---- EmailField ----
        this.EmailField.setBackground(Color.white);
        this.EmailField.setName("AddressVal");

        //---- AddressField ----
        this.AddressField.setBackground(Color.white);
        this.AddressField.setName("PhoneNumberVal");

        //---- TotalPointVal ----
        this.TotalPointVal.setBackground(Color.white);
        this.TotalPointVal.setName("TotalPointVal");

        //---- ID ----
        this.ID.setText("ID:");
        this.ID.setFont(new Font("Lato Black", Font.BOLD | Font.ITALIC, 20));

        //---- IDField ----
        this.IDField.setBackground(Color.lightGray);
        this.IDField.setName("NameVal");
        this.IDField.setEditable(false);

        //---- Type ----
        this.Type.setFont(new Font("Lato Black", Font.BOLD, 20));
        this.Type.setText("Type");

        //---- TypeField ----
        this.TypeField.setBackground(Color.white);
        this.TypeField.setName("TotalPointVal");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(181, 181, 181)
                            .addComponent(this.SAVE, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                            .addGap(75, 75, 75)
                            .addComponent(this.Cancel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(102, 102, 102)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(this.PhoneNumber, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup()
                                                .addComponent(this.ID, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(this.Name, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(this.Email, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
                                    .addGap(76, 76, 76)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(this.EmailField, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(this.NameField, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(this.IDField, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(this.PhoneNumberFiled, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(this.Address, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(this.TotalPoint, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(this.Type, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
                                    .addGap(76, 76, 76)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(this.AddressField, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(this.TotalPointVal, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(this.TypeField, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))))))
                    .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.ID, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.IDField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.NameField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.Name, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.PhoneNumber, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.PhoneNumberFiled, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.Email, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.EmailField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.Address, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.AddressField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.Type, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.TypeField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.TotalPoint, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.TotalPointVal, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.SAVE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.Cancel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
    private JPanel InformationCustomerPanel;
    JLabel Name;
    JLabel Email;
    JLabel Address;
    JLabel PhoneNumber;
    JButton Cancel;
    JButton SAVE;
    JLabel TotalPoint;
    JTextField NameField;
    JTextField PhoneNumberFiled;
    JTextField EmailField;
    JTextField AddressField;
    JTextField TotalPointVal;
    JLabel ID;
    JTextField IDField;
    JLabel Type;
    JTextField TypeField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void saveCustomer() throws SQLException {
        if (this.NameField.equals("") || this.EmailField.equals("") || this.AddressField.equals("")
                || this.PhoneNumberFiled.equals("") || this.TotalPointVal.equals("") || this.TypeField.equals("")
            || this.IDField.equals("") || this.TypeField.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        } else {
            CustomerListP customer = null;
            if (selectedID == -1 ) { // add new customer
                System.out.println("add new customer");
                customer = new CustomerListP();
                customer.setId(Integer.parseInt(this.IDField.getText()));
                customer.setName(this.NameField.getText());
                customer.setEmail(this.EmailField.getText());
                customer.setAddress(this.AddressField.getText());
                customer.setPhoneNumber(this.PhoneNumberFiled.getText());
                customer.setTotalPoint(Integer.parseInt(this.TotalPointVal.getText()));
                customer.setType(this.TypeField.getText());
                customer.setId(Integer.parseInt(this.IDField.getText()));
            }
            else { // update customer
                System.out.println("update customer");
                customer = CustomerDAO.getInstance().selectByID(selectedID);
                customer.setId(selectedID);
                customer.setName(this.NameField.getText());
                customer.setEmail(this.EmailField.getText());
                customer.setAddress(this.AddressField.getText());
                customer.setPhoneNumber(this.PhoneNumberFiled.getText());
                customer.setTotalPoint(Integer.parseInt(this.TotalPointVal.getText()));
                customer.setType(this.TypeField.getText());
                customer.setId(Integer.parseInt(this.IDField.getText()));
            }

            if (selectedID != -1) {
                CustomerDAO.getInstance().updateCustomer(customer);
            }
            else {
                CustomerDAO.getInstance().addCustomer(customer);
            }
            MainPage.changeView(new CustomersListPanel(), MainPage.getJlbCustomer(), "CustomerListPanel");
        }
    }
    public void cancelCustomer() {
        MainPage.changeView(new CustomersListPanel(), MainPage.getJlbCustomer(), "CustomerListPanel");
    }
}
