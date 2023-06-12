package View.LoginPage;

import Controller.LoginPage.LoginPageListener;
import Model.BEAN.Employee;
import Model.DAO.Employee.EmployeeDAO;
import View.LoginPage.ForgetPasswordPage.ForgotPasswordPage_1;
import View.LoginPage.RegisterAccountPage.RegisterAccountPage_1;
import View.MainPage.MainPage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPage extends JPanel {
    ActionListener ac = new LoginPageListener(this);

    private static int loginAttempt = 0;

    String loginStatus = "Login Failed";
    public LoginPage() {
        initComponents();
        initMoreComponents();
    }

    public void initMoreComponents() {
        this.getLoginButton().addActionListener(ac);
        getLoginButton().addKeyListener(new LoginPageListener(this));
        getUsernameField().addKeyListener(new LoginPageListener(this));
        getPasswordField().addKeyListener(new LoginPageListener(this));
        getForgetPasswordJbt().addActionListener(ac);
        getRegisterAccountJbt().addActionListener(ac);
    }

    public void DoLogin(){
        String username = this.UsernameField.getText();
        String password = this.PasswordField.getText();

        Employee realuser = EmployeeDAO.getInstance().selectUserandPassByID(username);

        if (loginAttempt >= 3) {
            loginStatus = "Forgot your password? Click Forgot Password to reset the password";
        }

        if (realuser == null) {
            this.LoginStatus.setText(loginStatus);
            this.LoginStatus.setForeground(Color.decode("EB1212"));
            loginAttempt++;
        }
        else {
            String realUsername = realuser.getUsername();
            String realPassword = realuser.getPassword();

            if (username.equals(realUsername) && password.equals(realPassword)) {
                this.LoginStatus.setText("");
                this.LoginPageDialog.dispose();
                MainPage mainMenu = new MainPage(username);
                mainMenu.setVisible(true);
            }
            else {
                this.LoginStatus.setText(loginStatus);
                this.LoginStatus.setForeground(Color.decode("EB1212"));
                loginAttempt++;
            }

        }
    }

    public void SwitchToForgotPasswordPage() {
        System.out.println("Switching to Forgot Password Page");
        ForgotPasswordPage_1 forgotPasswordPage1 = new ForgotPasswordPage_1();
        forgotPasswordPage1.getForgotPasswordPage_1JDialog().setVisible(true);
        this.LoginPageDialog.dispose();
    }

    public void SwitchToRegisterAccountPage() {
        System.out.println("Switching to Register Account Page");
        RegisterAccountPage_1 registerAccountPage1 = new RegisterAccountPage_1();
        registerAccountPage1.getRegisterAccountJDialog_1().setVisible(true);
        this.LoginPageDialog.dispose();
    }

    public JButton getLoginButton() {
        return LoginButton;
    }

    public JTextField getUsernameField() {
        return UsernameField;
    }

    public JPasswordField getPasswordField() {
        return PasswordField;
    }

    public JButton getForgetPasswordJbt() {
        return ForgetPasswordJbt;
    }

    public static JDialog getLoginPageDialog() {
        return LoginPageDialog;
    }

    public JButton getRegisterAccountJbt() {
        return RegisterAccountJbt;
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        LoginPageDialog = new JDialog();
        LoginPagePanel = new JPanel();
        PasswordField = new JPasswordField();
        UsernameField = new JTextField();
        LoginButton = new JButton();
        Password = new JLabel();
        Username = new JLabel();
        LoginStatus = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        ForgetPasswordJbt = new JButton();
        RegisterAccountJbt = new JButton();

        //======== LoginPageDialog ========
        {
            LoginPageDialog.setTitle("MuzikTic - Concert Music Ticketing");
            LoginPageDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            LoginPageDialog.setVisible(true);
            var LoginPageDialogContentPane = LoginPageDialog.getContentPane();

            //======== LoginPagePanel ========
            {
                LoginPagePanel.setBackground(Color.white);
                LoginPagePanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
                swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border
                . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
                ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,LoginPagePanel. getBorder
                ( )) ); LoginPagePanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
                .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
                ( ); }} );

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
                label1.setIcon(new ImageIcon(getClass().getResource("/Asset/Icon/music logo design - no name.png")));
                label1.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label2 ----
                label2.setText("MUZIKTIC");
                label2.setFont(new Font("Fredoka One", Font.BOLD, 24));
                label2.setForeground(new Color(0xa8cf45));

                //---- label3 ----
                label3.setText("MUSIC CONCERT TICKETING");
                label3.setFont(new Font("Fredoka One", Font.BOLD, 18));
                label3.setForeground(new Color(0x0098da));

                //---- ForgetPasswordJbt ----
                ForgetPasswordJbt.setText("Forgot Password?");
                ForgetPasswordJbt.setForeground(new Color(0xd45c5c));
                ForgetPasswordJbt.setBorder(null);
                ForgetPasswordJbt.setBackground(Color.white);
                ForgetPasswordJbt.setFont(new Font("Lato Black", Font.BOLD, 14));

                //---- RegisterAccountJbt ----
                RegisterAccountJbt.setText("Register Account");
                RegisterAccountJbt.setForeground(Color.green);
                RegisterAccountJbt.setBorder(null);
                RegisterAccountJbt.setBackground(Color.white);
                RegisterAccountJbt.setFont(new Font("Lato Black", Font.BOLD, 14));

                GroupLayout LoginPagePanelLayout = new GroupLayout(LoginPagePanel);
                LoginPagePanel.setLayout(LoginPagePanelLayout);
                LoginPagePanelLayout.setHorizontalGroup(
                    LoginPagePanelLayout.createParallelGroup()
                        .addGroup(LoginPagePanelLayout.createSequentialGroup()
                            .addContainerGap(64, Short.MAX_VALUE)
                            .addGroup(LoginPagePanelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, LoginPagePanelLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, LoginPagePanelLayout.createSequentialGroup()
                                        .addGroup(LoginPagePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(LoginPagePanelLayout.createSequentialGroup()
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                                                .addGap(50, 50, 50))
                                            .addGroup(LoginPagePanelLayout.createSequentialGroup()
                                                .addComponent(label2)
                                                .addGap(71, 71, 71))
                                            .addComponent(label3)
                                            .addGroup(LoginPagePanelLayout.createSequentialGroup()
                                                .addGroup(LoginPagePanelLayout.createParallelGroup()
                                                    .addComponent(Password, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Username, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                                .addGap(223, 223, 223)))
                                        .addGap(150, 150, 150))
                                    .addGroup(LoginPagePanelLayout.createSequentialGroup()
                                        .addGroup(LoginPagePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(UsernameField, GroupLayout.Alignment.LEADING)
                                            .addComponent(PasswordField, GroupLayout.Alignment.LEADING)
                                            .addGroup(GroupLayout.Alignment.LEADING, LoginPagePanelLayout.createSequentialGroup()
                                                .addComponent(LoginStatus, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46)
                                                .addComponent(ForgetPasswordJbt)))
                                        .addContainerGap()))
                                .addGroup(GroupLayout.Alignment.TRAILING, LoginPagePanelLayout.createSequentialGroup()
                                    .addComponent(RegisterAccountJbt)
                                    .addGap(39, 39, 39)
                                    .addComponent(LoginButton)
                                    .addGap(244, 244, 244))))
                );
                LoginPagePanelLayout.setVerticalGroup(
                    LoginPagePanelLayout.createParallelGroup()
                        .addGroup(LoginPagePanelLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label3)
                            .addGap(26, 26, 26)
                            .addComponent(Username, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(UsernameField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Password)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PasswordField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(LoginPagePanelLayout.createParallelGroup()
                                .addGroup(LoginPagePanelLayout.createSequentialGroup()
                                    .addComponent(LoginStatus, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(LoginPagePanelLayout.createParallelGroup()
                                        .addComponent(LoginButton)
                                        .addComponent(RegisterAccountJbt)))
                                .addComponent(ForgetPasswordJbt))
                            .addGap(16, 16, 16))
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
    // Generated using JFormDesigner Evaluation license - Dat
    public static JDialog LoginPageDialog;
    public JPanel LoginPagePanel;
    public JPasswordField PasswordField;
    public JTextField UsernameField;
    public JButton LoginButton;
    public JLabel Password;
    public JLabel Username;
    public JLabel LoginStatus;
    public JLabel label1;
    public JLabel label2;
    public JLabel label3;
    public JButton ForgetPasswordJbt;
    public JButton RegisterAccountJbt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
