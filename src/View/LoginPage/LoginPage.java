package View.LoginPage;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

import Controller.LoginPageListener;
import DAO.DAOHoiVien;
import Model.User;
import View.MenuPage.MenuPanel;

public class LoginPage extends JPanel {
    ActionListener ac = new LoginPageListener(this);
    User user = new User();
    public LoginPage() {
        initComponents();
    }

    private void Login(ActionEvent e) {
        LoginButton.addActionListener(ac);
    }

    

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
        LoginPageDialog = new JDialog();
        LoginPagePanel = new JPanel();
        PasswordField = new JPasswordField();
        UsernameField = new JTextField();
        LoginButton = new JButton();
        Password = new JLabel();
        Username = new JLabel();
        LoginStatus = new JLabel();
        label1 = new JLabel();

        //======== LoginPageDialog ========
        {
            LoginPageDialog.setTitle("MuzikTic - Concert Music Ticketing");
            var LoginPageDialogContentPane = LoginPageDialog.getContentPane();

            //======== LoginPagePanel ========
            {
                LoginPagePanel.setBackground(Color.white);
                LoginPagePanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
                EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing
                . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
                java. awt. Color. red) ,LoginPagePanel. getBorder( )) ); LoginPagePanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
                { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () ))
                throw new RuntimeException( ); }} );

                //---- PasswordField ----
                PasswordField.setBorder(new LineBorder(new Color(0x61b884)));

                //---- UsernameField ----
                UsernameField.setCaretColor(new Color(0x61b884));
                UsernameField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                UsernameField.setFont(new Font("Lato Black", Font.PLAIN, 14));
                UsernameField.setForeground(new Color(0x003333));
                UsernameField.setDisabledTextColor(new Color(0xccffcc));
                UsernameField.setBackground(Color.white);
                UsernameField.setBorder(new LineBorder(new Color(0x61b884)));

                //---- LoginButton ----
                LoginButton.setText("LOGIN");
                LoginButton.setFont(new Font("Lato Black", Font.BOLD, 14));
                LoginButton.setForeground(Color.white);
                LoginButton.setBackground(new Color(0x61b884));
                LoginButton.addActionListener(e -> {
			Login(e);
			Login(e);
		});

                //---- Password ----
                Password.setText(" Password");
                Password.setFont(new Font("Lato Black", Font.BOLD, 15));
                Password.setForeground(new Color(0x61b884));

                //---- Username ----
                Username.setText(" Username");
                Username.setFont(new Font("Lato Black", Font.BOLD, 15));
                Username.setForeground(new Color(0x61b884));

                //---- LoginStatus ----
                LoginStatus.setFont(new Font("Lato Black", Font.BOLD, 14));
                LoginStatus.setForeground(new Color(0xd45c5c));

                //---- label1 ----
                label1.setIcon(new ImageIcon(getClass().getResource("/Asset/1.png")));
                label1.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout LoginPagePanelLayout = new GroupLayout(LoginPagePanel);
                LoginPagePanel.setLayout(LoginPagePanelLayout);
                LoginPagePanelLayout.setHorizontalGroup(
                    LoginPagePanelLayout.createParallelGroup()
                        .addGroup(LoginPagePanelLayout.createSequentialGroup()
                            .addContainerGap(161, Short.MAX_VALUE)
                            .addGroup(LoginPagePanelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, LoginPagePanelLayout.createSequentialGroup()
                                    .addGroup(LoginPagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(LoginStatus, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PasswordField, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                        .addComponent(Password, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(UsernameField, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                        .addComponent(Username, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                                    .addGap(150, 150, 150))
                                .addGroup(GroupLayout.Alignment.TRAILING, LoginPagePanelLayout.createSequentialGroup()
                                    .addComponent(LoginButton)
                                    .addGap(244, 244, 244))))
                );
                LoginPagePanelLayout.setVerticalGroup(
                    LoginPagePanelLayout.createParallelGroup()
                        .addGroup(LoginPagePanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Username, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(UsernameField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Password)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PasswordField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LoginStatus, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LoginButton)
                            .addGap(32, 32, 32))
                );
            }

            GroupLayout LoginPageDialogContentPaneLayout = new GroupLayout(LoginPageDialogContentPane);
            LoginPageDialogContentPane.setLayout(LoginPageDialogContentPaneLayout);
            LoginPageDialogContentPaneLayout.setHorizontalGroup(
                LoginPageDialogContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, LoginPageDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LoginPagePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
            LoginPageDialogContentPaneLayout.setVerticalGroup(
                LoginPageDialogContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, LoginPageDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LoginPagePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
            LoginPageDialog.pack();
            LoginPageDialog.setLocationRelativeTo(LoginPageDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
    public JDialog LoginPageDialog;
    public JPanel LoginPagePanel;
    public JPasswordField PasswordField;
    public JTextField UsernameField;
    public JButton LoginButton;
    public JLabel Password;
    public JLabel Username;
    public JLabel LoginStatus;
    public JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    //Logo

    public void DoLogin(){
        String username = this.UsernameField.getText();
        String password = this.PasswordField.getText();

        User realuser = DAOHoiVien.getInstance().selectById(username);

        if (realuser == null) {
            this.LoginStatus.setText("Login Failed");
            this.LoginStatus.setForeground(Color.decode("EB1212"));
            return;
        }
        else {
            String realUsername = realuser.getUsername();
            String realPassword = realuser.getPassword();

            if (username.equals(realUsername) && password.equals(realPassword)) {
                this.LoginStatus.setForeground(Color.GREEN);
                //this.LoginPage.dispose();
                MenuPanel mainMenu = new MenuPanel();
                mainMenu.setVisible(true);
            } else {
                this.LoginStatus.setText("Login Failed");
                this.LoginStatus.setForeground(Color.decode("EB1212"));
            }
        }
    }
}
