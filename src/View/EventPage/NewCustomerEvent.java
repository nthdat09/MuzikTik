/*
 * Created by JFormDesigner on Wed Jun 14 01:41:08 ICT 2023
 */

package View.EventPage;

import Model.BEAN.Customer.Customer;
import Model.Database.UserDatabase;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

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
        this.TotalPointVal.setText("0");
        this.TypeField.setText("MEMBER");
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
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?,?)");
                preparedStatement.setInt(1, Integer.parseInt(this.IDField.getText()));
                preparedStatement.setString(2, this.NameField.getText());
                preparedStatement.setString(3, this.PhoneNumberFiled.getText());
                preparedStatement.setString(4, this.EmailField.getText());
                preparedStatement.setString(5, this.AddressField.getText());
                preparedStatement.setString(6, this.TypeField.getText());
                preparedStatement.setInt(7, Integer.parseInt(this.TotalPointVal.getText()));
                preparedStatement.setString(8, null);
                preparedStatement.setString(9, this.UserNameField.getText().toString());
                preparedStatement.setString(10,this.PasswordField.getText().toString());
                preparedStatement.execute();

                JOptionPane.showMessageDialog(null,"Register for new customer successfully!");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
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
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border
        .EmptyBorder ( 0, 0 ,0 , 0) ,  "" , javax. swing .border . TitledBorder. CENTER ,javax
        . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,
        12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans
        .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e.
        getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(null);

        //---- label3 ----
        label3.setText("Password:");
        label3.setFont(new Font("Lato Black", Font.BOLD, 16));
        label3.setForeground(new Color(0x61b884));
        add(label3);
        label3.setBounds(new Rectangle(new Point(5, 395), label3.getPreferredSize()));

        //---- PasswordField ----
        PasswordField.setFont(new Font("Lato", Font.PLAIN, 16));
        PasswordField.setBackground(Color.white);
        add(PasswordField);
        PasswordField.setBounds(145, 390, 252, PasswordField.getPreferredSize().height);

        //---- UserNameField ----
        UserNameField.setFont(new Font("Lato", Font.PLAIN, 16));
        UserNameField.setBackground(Color.white);
        add(UserNameField);
        UserNameField.setBounds(145, 340, 252, UserNameField.getPreferredSize().height);

        //---- UserName ----
        UserName.setText("Username:");
        UserName.setFont(new Font("Lato Black", Font.BOLD, 16));
        UserName.setForeground(new Color(0x61b884));
        add(UserName);
        UserName.setBounds(new Rectangle(new Point(5, 345), UserName.getPreferredSize()));

        //---- label1 ----
        label1.setText("CUSTOMER INFORMATION");
        label1.setFont(new Font("Lato Black", Font.BOLD, 25));
        label1.setForeground(new Color(0x61b884));
        add(label1);
        label1.setBounds(new Rectangle(new Point(270, 60), label1.getPreferredSize()));

        //---- TypeField ----
        TypeField.setBackground(Color.white);
        TypeField.setName("TotalPointVal");
        TypeField.setFont(new Font("Lato", Font.PLAIN, 16));
        add(TypeField);
        TypeField.setBounds(740, 290, 247, TypeField.getPreferredSize().height);

        //---- Type ----
        Type.setFont(new Font("Lato Black", Font.BOLD, 16));
        Type.setText("Type:");
        Type.setForeground(new Color(0x61b884));
        add(Type);
        Type.setBounds(605, 295, 77, Type.getPreferredSize().height);

        //---- IDField ----
        IDField.setName("NameVal");
        IDField.setEditable(false);
        IDField.setFont(new Font("Lato", Font.PLAIN, 16));
        IDField.setEnabled(false);
        add(IDField);
        IDField.setBounds(145, 205, 250, 28);

        //---- ID ----
        ID.setText("ID:");
        ID.setFont(new Font("Lato Black", Font.BOLD, 16));
        ID.setForeground(new Color(0x61b884));
        add(ID);
        ID.setBounds(5, 210, 57, ID.getPreferredSize().height);

        //---- TotalPointVal ----
        TotalPointVal.setBackground(Color.white);
        TotalPointVal.setName("TotalPointVal");
        TotalPointVal.setFont(new Font("Lato", Font.PLAIN, 16));
        add(TotalPointVal);
        TotalPointVal.setBounds(740, 340, 250, TotalPointVal.getPreferredSize().height);

        //---- AddressField ----
        AddressField.setBackground(Color.white);
        AddressField.setName("PhoneNumberVal");
        AddressField.setFont(new Font("Lato", Font.PLAIN, 16));
        add(AddressField);
        AddressField.setBounds(740, 245, 247, AddressField.getPreferredSize().height);

        //---- EmailField ----
        EmailField.setBackground(Color.white);
        EmailField.setName("AddressVal");
        EmailField.setFont(new Font("Lato", Font.PLAIN, 16));
        add(EmailField);
        EmailField.setBounds(145, 290, 252, EmailField.getPreferredSize().height);

        //---- PhoneNumberFiled ----
        PhoneNumberFiled.setBackground(Color.white);
        PhoneNumberFiled.setName("EmailVal");
        PhoneNumberFiled.setFont(new Font("Lato", Font.PLAIN, 16));
        add(PhoneNumberFiled);
        PhoneNumberFiled.setBounds(740, 205, 250, PhoneNumberFiled.getPreferredSize().height);

        //---- NameField ----
        NameField.setBackground(Color.white);
        NameField.setName("NameVal");
        NameField.setFont(new Font("Lato", Font.PLAIN, 16));
        add(NameField);
        NameField.setBounds(145, 245, 252, NameField.getPreferredSize().height);

        //---- TotalPoint ----
        TotalPoint.setFont(new Font("Lato Black", Font.BOLD, 16));
        TotalPoint.setText("Total Point:");
        TotalPoint.setForeground(new Color(0x61b884));
        TotalPoint.setBackground(Color.white);
        add(TotalPoint);
        TotalPoint.setBounds(605, 345, 99, TotalPoint.getPreferredSize().height);

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
        add(SAVE);
        SAVE.setBounds(870, 410, 112, SAVE.getPreferredSize().height);

        //---- PhoneNumber ----
        PhoneNumber.setText("Phone Number:");
        PhoneNumber.setFont(new Font("Lato Black", Font.BOLD, 16));
        PhoneNumber.setForeground(new Color(0x61b884));
        add(PhoneNumber);
        PhoneNumber.setBounds(605, 210, 126, PhoneNumber.getPreferredSize().height);

        //---- Address ----
        Address.setText("Address:");
        Address.setFont(new Font("Lato Black", Font.BOLD, 16));
        Address.setForeground(new Color(0x61b884));
        add(Address);
        Address.setBounds(605, 250, 87, Address.getPreferredSize().height);

        //---- Email ----
        Email.setText("Email:");
        Email.setFont(new Font("Lato Black", Font.BOLD, 16));
        Email.setForeground(new Color(0x61b884));
        add(Email);
        Email.setBounds(5, 295, 87, Email.getPreferredSize().height);

        //---- Name ----
        Name.setText("Name:");
        Name.setFont(new Font("Lato Black", Font.BOLD, 16));
        Name.setForeground(new Color(0x61b884));
        add(Name);
        Name.setBounds(5, 250, 71, Name.getPreferredSize().height);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
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
