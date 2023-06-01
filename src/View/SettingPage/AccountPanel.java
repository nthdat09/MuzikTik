/*
 * Created by JFormDesigner on Wed Apr 26 21:29:50 ICT 2023
 */

package View.SettingPage;

import Application.Main;
import Controller.AccountPanel.AccountPanelController;
import Model.BEAN.Employee;
import Model.DAO.Employee.EmployeeDAO;
import View.MainPage.MainPage;
import com.github.lgooddatepicker.components.DatePicker;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Admin
 */
public class AccountPanel extends JPanel {
    ActionListener ac = new AccountPanelController(this);

    byte[] photo = null;
    String filename = null;

    int newPhotoUploaded;

    public AccountPanel() {
        initComponents();
        initMoreSetting();
    }

    private void initMoreSetting() {
        setDataForComponents();

        getJbtCancel().addActionListener(ac);
        getJbtSave().addActionListener(ac);
        getUploadJbt().addActionListener(ac);
        getChangePasswordJbt().addActionListener(ac);

        newPhotoUploaded = 0;
    }

    private void setDataForComponents() {
        Employee employee = EmployeeDAO.getUserByUsername(MainPage.getUsername());

        getUsernameJtf().setText(employee.getUsername());
        getEmailJtf().setText(employee.getEmail());
        getAddressJtf().setText(employee.getAddress());
        getPhoneJtf().setText(String.valueOf(employee.getPhoneNumber()));
        

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate localDate = LocalDate.parse(employee.getDOB().toString(), formatter);
        getDobJpn().setDate(localDate);

        ImageIcon imageIcon = new ImageIcon(employee.getAvatar());
        Image image = imageIcon.getImage().getScaledInstance(avatarJlb.getWidth(), avatarJlb.getHeight(), Image.SCALE_SMOOTH);
        avatarJlb.setIcon(new ImageIcon(image));

    }

    public void uploadNewAvatar() {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(this);
            File file = fileChooser.getSelectedFile();
            filename = file.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(file.toString());
            Image image = imageIcon.getImage().getScaledInstance(avatarJlb.getWidth(), avatarJlb.getHeight(), Image.SCALE_SMOOTH);
            avatarJlb.setIcon(new ImageIcon(image));

            newPhotoUploaded = 1;
    }

    public void changePassword() {
        System.out.println("Change password");
        ChangPasswordJDialog changPasswordJDialog = new ChangPasswordJDialog();


    }

    public void save() throws IOException {
        if (getUsernameJtf().getText().equals("") || getEmailJtf().getText().equals("") || getAddressJtf().getText().equals("")
                || getPhoneJtf().getText().equals("") || getDobJpn().getDate().toString().equals("")){
            JOptionPane.showMessageDialog(this, "Please fill all the fields");
        }
        else {
            Employee employee = new Employee();
            employee.setUsername(getUsernameJtf().getText());
            employee.setEmail(getEmailJtf().getText());
            employee.setAddress(getAddressJtf().getText());
            employee.setPhoneNumber(getPhoneJtf().getText());
            employee.setDOB(java.sql.Date.valueOf(getDobJpn().getDate()));

            int rowChanged = EmployeeDAO.updateEmployeeWithoutAvatar(employee);
            System.out.println(rowChanged);

            int avatarUploadSuscessfully = 0;
            if (newPhotoUploaded == 1) {
                File image = new File(filename);
                FileInputStream fis = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = fis.read(buf)) != -1; ) {
                    bos.write(buf, 0, readNum);
                }
                photo = bos.toByteArray();
                employee.setAvatar(photo);

                avatarUploadSuscessfully = EmployeeDAO.updateAvatar(employee);
                System.out.println("avatarUploadSuscessfully: " + avatarUploadSuscessfully);

                if (rowChanged > 0 && avatarUploadSuscessfully > 0) {
                    JOptionPane.showMessageDialog(this, "Update successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Update failed");
                }

            }
            else {
                if (rowChanged > 0) {
                    JOptionPane.showMessageDialog(this, "Update successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Update failed");
                }
            }

            MainPage.changeView(new AccountPanel(), MainPage.getJlbSettings(), "AccountPanel");
        }
    }
    public void cancel() {
        setDataForComponents();
    }

    public JButton getJbtCancel() {
        return jbtCancel;
    }

    public JButton getJbtSave() {
        return jbtSave;
    }

    public JTextField getUsernameJtf() {
        return usernameJtf;
    }

    public JTextField getEmailJtf() {
        return emailJtf;
    }

    public JTextField getPhoneJtf() {
        return phoneJtf;
    }

    public JTextField getAddressJtf() {
        return addressJtf;
    }

    public DatePicker getDobJpn() {
        return dobJpn;
    }

    public JLabel getAvatarJlb() {
        return avatarJlb;
    }

    public JButton getUploadJbt() {
        return UploadJbt;
    }

    public JButton getChangePasswordJbt() {
        return changePasswordJbt;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        jbtCancel = new JButton();
        jbtSave = new JButton();
        jlbMyAccount = new JLabel();
        jlbUsername = new JLabel();
        jlbEmail = new JLabel();
        jlbPhoneNumber = new JLabel();
        jlbDOB = new JLabel();
        jlbDOB2 = new JLabel();
        jlbAvatar = new JLabel();
        usernameJtf = new JTextField();
        emailJtf = new JTextField();
        phoneJtf = new JTextField();
        addressJtf = new JTextField();
        dobJpn = new DatePicker();
        UploadJbt = new JButton();
        desktopPane1 = new JDesktopPane();
        avatarJlb = new JLabel();
        changePasswordJbt = new JButton();

        //======== this ========
        setBackground(Color.white);
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
        ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
        .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
        propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
        ;} } );

        //---- jbtCancel ----
        jbtCancel.setText("CANCEL");
        jbtCancel.setPreferredSize(new Dimension(80, 30));
        jbtCancel.setFont(new Font("Lato Black", Font.BOLD, 18));
        jbtCancel.setBackground(new Color(0x61b884));
        jbtCancel.setForeground(Color.white);

        //---- jbtSave ----
        jbtSave.setText("SAVE");
        jbtSave.setPreferredSize(new Dimension(80, 30));
        jbtSave.setFont(new Font("Lato Black", Font.BOLD, 18));
        jbtSave.setBackground(new Color(0x61b884));
        jbtSave.setForeground(Color.white);

        //---- jlbMyAccount ----
        jlbMyAccount.setText("MY ACCOUNT");
        jlbMyAccount.setBackground(new Color(0x61b884));
        jlbMyAccount.setFont(new Font("Lato Black", Font.BOLD, 24));
        jlbMyAccount.setForeground(new Color(0x61b884));

        //---- jlbUsername ----
        jlbUsername.setText("Username");
        jlbUsername.setFont(new Font("Lato Black", Font.BOLD, 20));
        jlbUsername.setForeground(new Color(0x626262));

        //---- jlbEmail ----
        jlbEmail.setText("Email");
        jlbEmail.setFont(new Font("Lato Black", Font.BOLD, 20));
        jlbEmail.setForeground(new Color(0x626262));

        //---- jlbPhoneNumber ----
        jlbPhoneNumber.setText("Phone Number");
        jlbPhoneNumber.setFont(new Font("Lato Black", Font.BOLD, 20));
        jlbPhoneNumber.setForeground(new Color(0x626262));

        //---- jlbDOB ----
        jlbDOB.setText("Date of Birth");
        jlbDOB.setFont(new Font("Lato Black", Font.BOLD, 20));
        jlbDOB.setForeground(new Color(0x626262));

        //---- jlbDOB2 ----
        jlbDOB2.setText("Address");
        jlbDOB2.setFont(new Font("Lato Black", Font.BOLD, 20));
        jlbDOB2.setForeground(new Color(0x626262));

        //---- jlbAvatar ----
        jlbAvatar.setText("Avatar");
        jlbAvatar.setFont(new Font("Lato Black", Font.BOLD, 20));
        jlbAvatar.setForeground(new Color(0x626262));

        //---- usernameJtf ----
        usernameJtf.setFont(new Font("Lato", Font.PLAIN, 16));
        usernameJtf.setForeground(new Color(0x61b884));
        usernameJtf.setEditable(false);
        usernameJtf.setBackground(Color.lightGray);

        //---- emailJtf ----
        emailJtf.setFont(new Font("Lato", Font.PLAIN, 16));
        emailJtf.setForeground(new Color(0x61b884));

        //---- phoneJtf ----
        phoneJtf.setFont(new Font("Lato", Font.PLAIN, 16));
        phoneJtf.setForeground(new Color(0x61b884));

        //---- addressJtf ----
        addressJtf.setFont(new Font("Lato", Font.PLAIN, 16));
        addressJtf.setForeground(new Color(0x61b884));

        //---- UploadJbt ----
        UploadJbt.setText("Upload new avatar");

        //======== desktopPane1 ========
        {
            desktopPane1.setBackground(Color.white);
            desktopPane1.setMaximumSize(new Dimension(208, 212));
            desktopPane1.setMinimumSize(new Dimension(208, 212));
            desktopPane1.setPreferredSize(new Dimension(208, 212));

            //---- avatarJlb ----
            avatarJlb.setBackground(Color.white);
            avatarJlb.setBorder(LineBorder.createBlackLineBorder());
            avatarJlb.setMaximumSize(new Dimension(208, 212));
            avatarJlb.setMinimumSize(new Dimension(208, 212));
            avatarJlb.setPreferredSize(new Dimension(208, 212));
            desktopPane1.add(avatarJlb, JLayeredPane.DEFAULT_LAYER);
            avatarJlb.setBounds(0, 0, 265, 270);
        }

        //---- changePasswordJbt ----
        changePasswordJbt.setText("Change Password");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(404, 404, 404)
                    .addComponent(jlbMyAccount)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(380, 380, 380)
                    .addComponent(jbtSave, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(42, 42, 42)
                    .addComponent(jbtCancel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(374, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(jlbUsername)
                                .addComponent(jlbEmail)
                                .addComponent(jlbDOB2)
                                .addComponent(jlbPhoneNumber)
                                .addComponent(jlbDOB))
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(usernameJtf, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                    .addComponent(emailJtf, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                                .addComponent(addressJtf, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneJtf, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
                                .addComponent(dobJpn, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(changePasswordJbt))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jlbAvatar)
                            .addGap(107, 107, 107))
                        .addComponent(desktopPane1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
                    .addGap(117, 117, 117))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(695, Short.MAX_VALUE)
                    .addComponent(UploadJbt)
                    .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jlbMyAccount)
                            .addGap(8, 8, 8)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jlbUsername)
                                .addComponent(usernameJtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jlbEmail)
                                .addComponent(emailJtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jlbDOB2)
                                .addComponent(addressJtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jlbPhoneNumber)
                                .addComponent(phoneJtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jlbDOB, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(dobJpn, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                            .addGap(42, 42, 42)
                            .addComponent(changePasswordJbt))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addComponent(jlbAvatar)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                            .addComponent(desktopPane1, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(UploadJbt)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtSave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtCancel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 66, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
    private JButton jbtCancel;
    private JButton jbtSave;
    private JLabel jlbMyAccount;
    private JLabel jlbUsername;
    private JLabel jlbEmail;
    private JLabel jlbPhoneNumber;
    private JLabel jlbDOB;
    private JLabel jlbDOB2;
    private JLabel jlbAvatar;
    private JTextField usernameJtf;
    private JTextField emailJtf;
    private JTextField phoneJtf;
    private JTextField addressJtf;
    private DatePicker dobJpn;
    private JButton UploadJbt;
    private JDesktopPane desktopPane1;
    private JLabel avatarJlb;
    private static JButton changePasswordJbt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
