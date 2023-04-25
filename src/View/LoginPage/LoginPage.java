package View.LoginPage;

import Controller.LoginPageListener;
import DAO.DAOHoiVien;
import Model.User;
import View.MainMenu.MainMenu;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        LoginPage = new JDialog();
        UsernameField = new JTextField();
        PasswordField = new JPasswordField();
        LoginButton = new JButton();
        Username = new JLabel();
        Password = new JLabel();
        LoginStatus = new JLabel();

        //======== LoginPage ========
        {
            LoginPage.setTitle("Concert Go");
            LoginPage.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            LoginPage.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
            LoginPage.setName("LoginPage");
            LoginPage.setVisible(true);
            LoginPage.setBackground(Color.white);
            LoginPage.setForeground(SystemColor.control);
            var LoginPageContentPane = LoginPage.getContentPane();
            LoginPageContentPane.setLayout(null);

            //---- UsernameField ----
            UsernameField.setCaretColor(new Color(0x61b884));
            UsernameField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
            UsernameField.setFont(new Font("Lato Black", Font.PLAIN, 14));
            UsernameField.setForeground(new Color(0x003333));
            UsernameField.setDisabledTextColor(new Color(0xccffcc));
            UsernameField.setBackground(Color.white);
            UsernameField.setBorder(new LineBorder(new Color(0x61b884)));
            LoginPageContentPane.add(UsernameField);
            UsernameField.setBounds(230, 170, 270, 45);

            //---- PasswordField ----
            PasswordField.setBorder(new LineBorder(new Color(0x61b884)));
            LoginPageContentPane.add(PasswordField);
            PasswordField.setBounds(230, 255, 270, 45);

            //---- LoginButton ----
            LoginButton.setText("LOGIN");
            LoginButton.setFont(new Font("Lato Black", Font.BOLD, 14));
            LoginButton.setForeground(Color.white);
            LoginButton.setBackground(new Color(0x61b884));
            LoginButton.addActionListener(e -> {
			Login(e);
			Login(e);
		});
            LoginPageContentPane.add(LoginButton);
            LoginButton.setBounds(new Rectangle(new Point(325, 350), LoginButton.getPreferredSize()));

            //---- Username ----
            Username.setText(" Username");
            Username.setFont(new Font("Lato Black", Font.BOLD, 15));
            Username.setForeground(new Color(0x61b884));
            LoginPageContentPane.add(Username);
            Username.setBounds(230, 145, 90, 28);

            //---- Password ----
            Password.setText(" Password");
            Password.setFont(new Font("Lato Black", Font.BOLD, 15));
            Password.setForeground(new Color(0x61b884));
            LoginPageContentPane.add(Password);
            Password.setBounds(230, 235, 80, Password.getPreferredSize().height);

            //---- LoginStatus ----
            LoginStatus.setFont(new Font("Lato Black", Font.BOLD, 14));
            LoginStatus.setForeground(new Color(0xd45c5c));
            LoginPageContentPane.add(LoginStatus);
            LoginStatus.setBounds(235, 305, 185, 25);

            LoginPageContentPane.setPreferredSize(new Dimension(705, 465));
            LoginPage.pack();
            LoginPage.setLocationRelativeTo(LoginPage.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
    public JDialog LoginPage;
    public JTextField UsernameField;
    public JPasswordField PasswordField;
    public JButton LoginButton;
    public JLabel Username;
    public JLabel Password;
    public JLabel LoginStatus;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void initComponentsLogin() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Asset/icons8-login-64.png"));
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(24,24 , Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);
        JLabel Logo = new JLabel("Text", scaledIcon, JLabel.LEFT);
        Logo.setText("");
        LoginPage.add(Logo);
        Logo.setBounds(275, 60, 175, 70);
    }
    public void DoLogin(){
        String username = this.UsernameField.getText();
        String password = this.PasswordField.getText();

        User realuser = DAOHoiVien.getInstance().selectById(username);

        if (realuser == null) {
            this.LoginStatus.setText("Login Failed");
            this.LoginStatus.setForeground(Color.decode("D45C5C"));
            return;
        }
        else {
            String realUsername = realuser.getUsername();
            String realPassword = realuser.getPassword();

            if (username.equals(realUsername) && password.equals(realPassword)) {
                this.LoginStatus.setForeground(Color.GREEN);
                this.LoginPage.dispose();
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
            } else {
                this.LoginStatus.setText("Login Failed");
                this.LoginStatus.setForeground(Color.decode("D45C5C"));
            }
        }
    }
}
