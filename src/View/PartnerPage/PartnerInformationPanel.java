/*
 * Created by JFormDesigner on Wed Apr 26 21:22:42 ICT 2023
 */

package View.PartnerPage;

import Controller.PartnerPage.PartnerInformationController;
import Model.BEAN.Partner;
import Model.DAO.Partner.PartnerDAO;
import View.MainPage.MainPage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Admin
 */
public class PartnerInformationPanel extends JPanel {
    static int selectedID = -1;
    ActionListener ac = new PartnerInformationController(this);
    public PartnerInformationPanel() {
        initComponents();
        getSaveBtn().addActionListener(ac);
        getCancelBtn().addActionListener(ac);
    }

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
        this.LogoField.setText(partner.getLogo());
        this.AccountNumberField.setText(partner.getAccNumber());
        this.BankField.setText(partner.getBank());
        

        this.selectedID = partner.getId();
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

    public JTextField getLogoField() {
        return LogoField;
    }

    public JTextField getAccountNumberField() {
        return AccountNumberField;
    }

    public JTextField getBankField() {
        return BankField;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        CancelBtn = new JButton();
        SaveBtn = new JButton();
        label9 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        IDField = new JTextField();
        NameField = new JTextField();
        PhoneNumberField = new JTextField();
        EmailField = new JTextField();
        AddressField = new JTextField();
        LogoField = new JTextField();
        AccountNumberField = new JTextField();
        BankField = new JTextField();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );

        //---- label5 ----
        label5.setText("ID");
        label5.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- label6 ----
        label6.setText("Name");
        label6.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- label7 ----
        label7.setText("Phone Number");
        label7.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- label8 ----
        label8.setText("Email");
        label8.setFont(new Font("Lato Black", Font.BOLD, 20));

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
        label9.setFont(new Font("Lato Black", Font.BOLD, 20));
        label9.setText("Address");

        //---- label11 ----
        label11.setText("PARTNER INFORMATION");
        label11.setFont(new Font("Lato Black", Font.BOLD, 24));
        label11.setForeground(new Color(0x61b884));

        //---- label12 ----
        label12.setFont(new Font("Lato Black", Font.BOLD, 20));
        label12.setText("Logo");

        //---- label14 ----
        label14.setFont(new Font("Lato Black", Font.BOLD, 20));
        label14.setText("Account Number");

        //---- label15 ----
        label15.setFont(new Font("Lato Black", Font.BOLD, 20));
        label15.setText("Bank");

        //---- IDField ----
        IDField.setEditable(false);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(219, 219, 219)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label14, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup()
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label12, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
                        .addComponent(label15, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(298, Short.MAX_VALUE)
                    .addComponent(SaveBtn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(IDField)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(NameField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                .addComponent(CancelBtn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                .addComponent(PhoneNumberField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                .addComponent(EmailField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                .addComponent(AddressField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                .addComponent(LogoField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                .addComponent(AccountNumberField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                .addComponent(BankField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(192, 192, 192))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(268, Short.MAX_VALUE)
                    .addComponent(label11, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
                    .addGap(216, 216, 216))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(label11, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(IDField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(NameField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                            .addGap(9, 9, 9)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(PhoneNumberField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                            .addGap(19, 19, 19)
                            .addComponent(label8))
                        .addComponent(EmailField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(AddressField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label12, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(LogoField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label14, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(AccountNumberField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label15, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(BankField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SaveBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(CancelBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JButton CancelBtn;
    private JButton SaveBtn;
    private JLabel label9;
    private JLabel label11;
    private JLabel label12;
    private JLabel label14;
    private JLabel label15;
    private JTextField IDField;
    private JTextField NameField;
    private JTextField PhoneNumberField;
    private JTextField EmailField;
    private JTextField AddressField;
    private JTextField LogoField;
    private JTextField AccountNumberField;
    private JTextField BankField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void savePartner() {
        System.out.println("Save Partner");
        if (this.IDField.getText().equals("") || this.NameField.getText().equals("") || this.PhoneNumberField.getText().equals("")
                || this.EmailField.getText().equals("") || this.AddressField.getText().equals("") || this.LogoField.getText().equals("")
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
                partner.setLogo(this.LogoField.getText());
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
                    partner.setLogo(this.LogoField.getText());
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
}
