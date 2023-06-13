/*
 * Created by JFormDesigner on Wed Jun 14 01:41:08 ICT 2023
 */

package View.EventPage;

import Model.BEAN.Customer;
import Model.Database.UserDatabase;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author giama
 */
public class NewCustomerEvent extends JPanel {

    static int selectedID = -1;
    public NewCustomerEvent() {
        initComponents();
    }

    public NewCustomerEvent(int newID) {
        initComponents();
        this.IDField.setText(String.valueOf(newID));
    }
    public void initMoreSetting(Customer customer) {
        this.NameField.setText(customer.getName());
        this.AddressField.setText(customer.getAddress());
        this.PhoneNumberFiled.setText(customer.getPhoneNumber());
        this.TotalPointVal.setText(String.valueOf(customer.getTotalPoint()));
        this.EmailField.setText(customer.getEmail());
        this.TypeField.setText(customer.getType());
        this.UserNameField.setText(customer.getUsername());
        this.PasswordField.setText(customer.getPassword());
        this.selectedID = customer.getId();
        this.IDField.setText(String.valueOf(customer.getId()));
        System.out.println("selected id = " + this.selectedID);
    }
    public static void settingForNewCustomer(String name, String phone, String email) {
        NameField.setText(name);
        PhoneNumberFiled.setText(phone);
        EmailField.setText(email);
    }
    private void SAVEMouseClicked(MouseEvent e) {
        if (this.NameField.equals("") || this.EmailField.equals("") || this.AddressField.equals("")
                || this.PhoneNumberFiled.equals("") || this.TotalPointVal.equals("") || this.TypeField.equals("")
                || this.IDField.equals("") || this.UserNameField.equals("") || this.PasswordField.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        } else {
            try {
                Connection connection = UserDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?,?,?)");
                preparedStatement.setInt(1, Integer.parseInt(this.IDField.getText()));
                preparedStatement.setString(2, this.NameField.getText());
                preparedStatement.setString(3, this.PhoneNumberFiled.getText());
                preparedStatement.setString(4, this.EmailField.getText());
                preparedStatement.setString(5, this.AddressField.getText());
                preparedStatement.setString(6, this.TypeField.getText());
                preparedStatement.setInt(7, Integer.parseInt(this.TotalPointVal.getText()));
                preparedStatement.setString(8, null);
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Add new customer successfully");
                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - man
        label3 = new JLabel();
        PasswordField = new JTextField();
        UserNameField = new JTextField();
        UserName = new JLabel();
        label1 = new JLabel();
        TypeField = new JTextField();
        Type = new JLabel();
        IDField = new JTextField();
        ID = new JLabel();
        TotalPointVal = new JTextField();
        AddressField = new JTextField();
        EmailField = new JTextField();
        PhoneNumberFiled = new JTextField();
        NameField = new JTextField();
        TotalPoint = new JLabel();
        SAVE = new JButton();
        PhoneNumber = new JLabel();
        Address = new JLabel();
        Email = new JLabel();
        Name = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- label3 ----
        label3.setText("Password:");
        label3.setFont(new Font("Lato Black", Font.BOLD, 16));
        label3.setForeground(new Color(0x61b884));

        //---- PasswordField ----
        PasswordField.setFont(new Font("Lato", Font.PLAIN, 16));
        PasswordField.setBackground(Color.white);

        //---- UserNameField ----
        UserNameField.setFont(new Font("Lato", Font.PLAIN, 16));
        UserNameField.setBackground(Color.white);

        //---- UserName ----
        UserName.setText("Username:");
        UserName.setFont(new Font("Lato Black", Font.BOLD, 16));
        UserName.setForeground(new Color(0x61b884));

        //---- label1 ----
        label1.setText("CUSTOMER INFORMATION");
        label1.setFont(new Font("Lato Black", Font.BOLD, 25));
        label1.setForeground(new Color(0x61b884));

        //---- TypeField ----
        TypeField.setBackground(Color.white);
        TypeField.setName("TotalPointVal");
        TypeField.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- Type ----
        Type.setFont(new Font("Lato Black", Font.BOLD, 16));
        Type.setText("Type:");
        Type.setForeground(new Color(0x61b884));

        //---- IDField ----
        IDField.setName("NameVal");
        IDField.setEditable(false);
        IDField.setFont(new Font("Lato", Font.PLAIN, 16));
        IDField.setEnabled(false);

        //---- ID ----
        ID.setText("ID:");
        ID.setFont(new Font("Lato Black", Font.BOLD, 16));
        ID.setForeground(new Color(0x61b884));

        //---- TotalPointVal ----
        TotalPointVal.setBackground(Color.white);
        TotalPointVal.setName("TotalPointVal");
        TotalPointVal.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- AddressField ----
        AddressField.setBackground(Color.white);
        AddressField.setName("PhoneNumberVal");
        AddressField.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- EmailField ----
        EmailField.setBackground(Color.white);
        EmailField.setName("AddressVal");
        EmailField.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- PhoneNumberFiled ----
        PhoneNumberFiled.setBackground(Color.white);
        PhoneNumberFiled.setName("EmailVal");
        PhoneNumberFiled.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- NameField ----
        NameField.setBackground(Color.white);
        NameField.setName("NameVal");
        NameField.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- TotalPoint ----
        TotalPoint.setFont(new Font("Lato Black", Font.BOLD, 16));
        TotalPoint.setText("Total Point:");
        TotalPoint.setForeground(new Color(0x61b884));
        TotalPoint.setBackground(Color.white);

        //---- SAVE ----
        SAVE.setText("SAVE");
        SAVE.setPreferredSize(new Dimension(80, 30));
        SAVE.setFont(new Font("Lato Black", Font.BOLD, 16));
        SAVE.setBackground(new Color(0x61b884));
        SAVE.setForeground(Color.white);
        SAVE.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SAVEMouseClicked(e);
            }
        });

        //---- PhoneNumber ----
        PhoneNumber.setText("Phone Number:");
        PhoneNumber.setFont(new Font("Lato Black", Font.BOLD, 16));
        PhoneNumber.setForeground(new Color(0x61b884));

        //---- Address ----
        Address.setText("Address:");
        Address.setFont(new Font("Lato Black", Font.BOLD, 16));
        Address.setForeground(new Color(0x61b884));

        //---- Email ----
        Email.setText("Email:");
        Email.setFont(new Font("Lato Black", Font.BOLD, 16));
        Email.setForeground(new Color(0x61b884));

        //---- Name ----
        Name.setText("Name:");
        Name.setFont(new Font("Lato Black", Font.BOLD, 16));
        Name.setForeground(new Color(0x61b884));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createParallelGroup()
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup()
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ID, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(IDField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addGap(211, 211, 211)
                                .addComponent(PhoneNumber, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(PhoneNumberFiled, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Name, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(NameField, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
                                .addGap(209, 209, 209)
                                .addComponent(Address, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(AddressField, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Email, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(EmailField, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
                                .addGap(209, 209, 209)
                                .addComponent(Type, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(TypeField, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(UserName)
                                .addGap(56, 56, 56)
                                .addComponent(UserNameField, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
                                .addGap(209, 209, 209)
                                .addComponent(TotalPoint, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(TotalPointVal, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label3)
                                .addGap(58, 58, 58)
                                .addComponent(PasswordField, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 91, Short.MAX_VALUE)))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(864, Short.MAX_VALUE)
                    .addComponent(SAVE, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(99, 99, 99))
                .addGroup(layout.createSequentialGroup()
                    .addGap(327, 327, 327)
                    .addComponent(label1)
                    .addContainerGap(430, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createParallelGroup()
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 103, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                    .addComponent(PhoneNumberFiled, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup()
                                            .addComponent(ID)
                                            .addComponent(PhoneNumber))))
                                .addGap(12, 12, 12))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(IDField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup()
                            .addComponent(NameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup()
                                    .addComponent(Name)
                                    .addComponent(Address))))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup()
                            .addComponent(EmailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(TypeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup()
                                    .addComponent(Email)
                                    .addComponent(Type))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup()
                            .addComponent(UserNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(TotalPointVal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup()
                                    .addComponent(UserName)
                                    .addComponent(TotalPoint))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup()
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(label3))
                            .addComponent(PasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 389, Short.MAX_VALUE)))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addGap(272, 272, 272)
                    .addComponent(SAVE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(370, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - man
    private JLabel label3;
    private JTextField PasswordField;
    private JTextField UserNameField;
    private JLabel UserName;
    private JLabel label1;
    private JTextField TypeField;
    private JLabel Type;
    private JTextField IDField;
    private JLabel ID;
    private JTextField TotalPointVal;
    private JTextField AddressField;
    private static JTextField EmailField;
    private static JTextField PhoneNumberFiled;
    private static JTextField NameField;
    private JLabel TotalPoint;
    private JButton SAVE;
    private JLabel PhoneNumber;
    private JLabel Address;
    private JLabel Email;
    private JLabel Name;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
