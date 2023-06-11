/*
 * Created by JFormDesigner on Wed Apr 26 21:22:42 ICT 2023
 */

package View.PartnerPage;

import Controller.PartnerPage.PartnerInformationController;
import Model.BEAN.Partner;
import Model.DAO.Partner.PartnerDAO;
import View.MainPage.MainPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author Admin
 */
public class PartnerInformationPanel extends JPanel {
    static int selectedID = -1;
    ActionListener ac = new PartnerInformationController(this);

    public PartnerInformationPanel(Partner partner) {
        initComponents();
        getSaveBtn().addActionListener(ac);
        getCancelBtn().addActionListener(ac);
        initSomeComponents(partner);
    }

    public PartnerInformationPanel(int newID){
        initComponents();
        getSaveBtn().addActionListener(ac);
        getCancelBtn().addActionListener(ac);
        this.IDField.setText(String.valueOf(newID));
    }

    private void initSomeComponents(Partner partner) {
        this.IDField.setText(String.valueOf(partner.getId()));
        this.NameField.setText(partner.getName());
        this.AddressField.setText(partner.getAddress());
        this.EmailField.setText(partner.getEmail());
        this.PhoneNumberField.setText(partner.getPhoneNumber());
        this.AccountNumberField.setText(partner.getAccNumber());
        this.BankField.setText(partner.getBank());
        

        this.selectedID = partner.getId();
    }

    public void savePartner() {
        System.out.println("Save Partner");
        if (this.IDField.getText().equals("") || this.NameField.getText().equals("") || this.PhoneNumberField.getText().equals("")
                || this.EmailField.getText().equals("") || this.AddressField.getText().equals("")
                || this.AccountNumberField.getText().equals("") || this.BankField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
        else {
            Partner partner = null;
            if (selectedID == -1 ) { // insert
                partner = new Partner();
                partner.setId(Integer.parseInt(this.IDField.getText()));
                partner.setName(this.NameField.getText());
                partner.setPhoneNumber(this.PhoneNumberField.getText());
                partner.setEmail(this.EmailField.getText());
                partner.setAddress(this.AddressField.getText());
                partner.setAccNumber(this.AccountNumberField.getText());
                partner.setBank(this.BankField.getText());
            }
            else { // update
                try {
                    partner = PartnerDAO.getInstance().selectByID(selectedID);
                    partner.setId(Integer.parseInt(this.IDField.getText()));
                    partner.setName(this.NameField.getText());
                    partner.setPhoneNumber(this.PhoneNumberField.getText());
                    partner.setEmail(this.EmailField.getText());
                    partner.setAddress(this.AddressField.getText());
                    partner.setAccNumber(this.AccountNumberField.getText());
                    partner.setBank(this.BankField.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (selectedID != -1) {
                System.out.println("Update Partner");
                int rowChanged = PartnerDAO.getInstance().updatePartner(partner);
                if (rowChanged > 0){
                    JOptionPane.showMessageDialog(null, "Update successfully");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Update failed");
                }
            }
            else {
                System.out.println("Add Partner");
                int rowChanged = PartnerDAO.getInstance().addPartner(partner);
                if (rowChanged > 0){
                    JOptionPane.showMessageDialog(null, "Add successfully");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Add failed");
                }
            }
            MainPage.changeView(new PartnerListPanel(), MainPage.getJlbPartners() , "Partner List Panel");
        }

    }

    public void cancelPartner() {
        MainPage.changeView(new PartnerListPanel(), MainPage.getJlbPartners() , "Partner List Panel");
    }

    public JButton getCancelBtn() {
        return CancelBtn;
    }

    public JButton getSaveBtn() {
        return SaveBtn;
    }

    public JTextField getIDField() {
        return IDField;
    }

    public JTextField getNameField() {
        return NameField;
    }

    public JTextField getPhoneNumberField() {
        return PhoneNumberField;
    }

    public JTextField getEmailField() {
        return EmailField;
    }

    public JTextField getAddressField() {
        return AddressField;
    }

    public JTextField getAccountNumberField() {
        return AccountNumberField;
    }

    public JTextField getBankField() {
        return BankField;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        CancelBtn = new JButton();
        SaveBtn = new JButton();
        label9 = new JLabel();
        label11 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        IDField = new JTextField();
        NameField = new JTextField();
        PhoneNumberField = new JTextField();
        EmailField = new JTextField();
        AddressField = new JTextField();
        AccountNumberField = new JTextField();
        BankField = new JTextField();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
        . EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax
        . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
        12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans
        . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .
        getPropertyName () )) throw new RuntimeException( ); }} );

        //---- label5 ----
        label5.setText("ID:");
        label5.setFont(new Font("Lato Black", Font.BOLD, 16));
        label5.setForeground(new Color(0x61b884));

        //---- label6 ----
        label6.setText("Name:");
        label6.setFont(new Font("Lato Black", Font.BOLD, 16));
        label6.setForeground(new Color(0x61b884));

        //---- label7 ----
        label7.setText("Phone Number:");
        label7.setFont(new Font("Lato Black", Font.BOLD, 16));
        label7.setForeground(new Color(0x61b884));

        //---- label8 ----
        label8.setText("Email:");
        label8.setFont(new Font("Lato Black", Font.BOLD, 16));
        label8.setForeground(new Color(0x61b884));

        //---- CancelBtn ----
        CancelBtn.setText("CANCEL");
        CancelBtn.setPreferredSize(new Dimension(80, 30));
        CancelBtn.setFont(new Font("Lato Black", Font.BOLD, 18));
        CancelBtn.setBackground(new Color(0x61b884));
        CancelBtn.setForeground(Color.white);

        //---- SaveBtn ----
        SaveBtn.setText("SAVE");
        SaveBtn.setPreferredSize(new Dimension(80, 30));
        SaveBtn.setFont(new Font("Lato Black", Font.BOLD, 18));
        SaveBtn.setBackground(new Color(0x61b884));
        SaveBtn.setForeground(Color.white);

        //---- label9 ----
        label9.setFont(new Font("Lato Black", Font.BOLD, 16));
        label9.setText("Address:");
        label9.setForeground(new Color(0x61b884));

        //---- label11 ----
        label11.setText("PARTNER INFORMATION");
        label11.setFont(new Font("Lato Black", Font.BOLD, 25));
        label11.setForeground(new Color(0x61b884));

        //---- label14 ----
        label14.setFont(new Font("Lato Black", Font.BOLD, 16));
        label14.setText("Account Number:");
        label14.setForeground(new Color(0x61b884));

        //---- label15 ----
        label15.setFont(new Font("Lato Black", Font.BOLD, 16));
        label15.setText("Bank:");
        label15.setForeground(new Color(0x61b884));

        //---- IDField ----
        IDField.setEditable(false);
        IDField.setFont(new Font("Lato Black", Font.BOLD, 16));

        //---- NameField ----
        NameField.setFont(new Font("Lato Black", Font.BOLD, 16));

        //---- PhoneNumberField ----
        PhoneNumberField.setFont(new Font("Lato Black", Font.BOLD, 16));

        //---- EmailField ----
        EmailField.setFont(new Font("Lato Black", Font.BOLD, 16));

        //---- AddressField ----
        AddressField.setFont(new Font("Lato Black", Font.BOLD, 16));

        //---- AccountNumberField ----
        AccountNumberField.setFont(new Font("Lato Black", Font.BOLD, 16));

        //---- BankField ----
        BankField.setFont(new Font("Lato Black", Font.BOLD, 16));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                            .addGap(62, 62, 62)
                            .addComponent(NameField))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PhoneNumberField))
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53)
                            .addComponent(EmailField, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)
                            .addComponent(IDField, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)))
                    .addGap(160, 160, 160)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label14, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label15, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(AddressField)
                        .addComponent(AccountNumberField)
                        .addComponent(BankField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                    .addGap(80, 80, 80))
                .addGroup(layout.createSequentialGroup()
                    .addGap(372, 372, 372)
                    .addComponent(label11, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(397, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(816, Short.MAX_VALUE)
                    .addComponent(SaveBtn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)
                    .addComponent(CancelBtn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(label11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label9)
                                .addComponent(AddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label14)
                                .addComponent(AccountNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label15)
                                .addComponent(BankField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(IDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(NameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label7)
                                .addComponent(PhoneNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label8)
                                .addComponent(EmailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addGap(34, 34, 34)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(CancelBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(SaveBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(253, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JButton CancelBtn;
    private JButton SaveBtn;
    private JLabel label9;
    private JLabel label11;
    private JLabel label14;
    private JLabel label15;
    private JTextField IDField;
    private JTextField NameField;
    private JTextField PhoneNumberField;
    private JTextField EmailField;
    private JTextField AddressField;
    private JTextField AccountNumberField;
    private JTextField BankField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
