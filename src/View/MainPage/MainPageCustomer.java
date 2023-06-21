/*
 * Created by JFormDesigner on Sun Jun 18 09:57:51 ICT 2023
 */

package View.MainPage;

import Controller.MainMenu.LogoutController;
import Controller.MainMenu.LogoutControllerForCustomer;
import Controller.Menu.SwitchMenuController;
import Model.BEAN.Employee.Employee;
import Model.BEAN.Menu.MenuList;
import Model.DAO.Employee.EmployeeDAO;
import Model.Database.UserDatabase;

import java.awt.*;
import java.awt.event.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import static View.MainPage.MainPage.getAbsolutePath;
import static View.MainPage.MainPage.setImageForLogoUser;

/**
 * @author giama
 */
public class MainPageCustomer extends JFrame {

    static String username;
    public MainPageCustomer() {
        initComponents();
    }

    ActionListener ac = new LogoutControllerForCustomer(this);

    public MainPageCustomer(String username) {
        initComponents();
        initSetting(username);
    }

    private void initSetting(String username) {
        SwitchMenuController controller = new SwitchMenuController(jpnView);
        controller.setUserName(username);
        controller.setView(jpnHome,jlbHome);

        this.username = username;

        List<MenuList> listItem = new ArrayList<MenuList>();
        listItem.add(new MenuList("HomePanel", jpnHome, jlbHome));
        listItem.add(new MenuList("AccountPanel", jpnSettings,jlbSettings));
        controller.setEvent(listItem);

        this.getLogOutJMenuItem().addActionListener(ac);
        // Set username
        this.getNameJMenuItem().setText("Hello, " + username);

        // Set avatar
        setImageForLogoUser();
    }

    public static void setImageForLogoUser() {
        // Set avatar
        Connection connection = UserDatabase.getConnection();
        String sql = "SELECT CUS_AVATAR FROM customer WHERE cus_username = '" + username + "'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                byte[] img = resultSet.getBytes("CUS_AVATAR");
                if(img == null) {
                    Path workingDir = getAbsolutePath();
                    // Set default avatar
                    Path filePath = Paths.get(workingDir.toString(), "src", "Asset", "Avatar", "DefaultAvatar.png");
                    File file = new File(filePath.toString());

                    // Convert file to byte[]
                    FileInputStream fis = null;
                    try {
                        fis = new FileInputStream(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] buf = new byte[1024];
                    try {
                        for (int readNum; (readNum = fis.read(buf)) != -1; ) {
                            bos.write(buf, 0, readNum); //no doubt here is 0
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    byte[] bytes = bos.toByteArray();
                    try{
                        Connection con = UserDatabase.getConnection();

                        String sqlUpdate = "UPDATE mctmsys.customer SET CUS_AVATAR = ? WHERE CUS_USERNAME = ?";

                        PreparedStatement st = con.prepareCall(sqlUpdate);
                        st.setBytes(1, bytes);
                        st.setString(2, username);
                        st.executeUpdate();
                        st.close();
                        UserDatabase.closeConnection(con);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    ImageIcon imageIcon = new ImageIcon(bytes);
                    Image image = imageIcon.getImage();
                    Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(newimg);
                    getAvatarJMenu().setIcon(imageIcon);
                } else {
                    ImageIcon imageIcon = new ImageIcon(img);
                    Image image = imageIcon.getImage();
                    Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(newimg);
                    getAvatarJMenu().setIcon(imageIcon);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void jpnBufferMouseEntered(MouseEvent e) {
        // TODO add your code here
    }

    private void jpnBufferMouseExited(MouseEvent e) {
        // TODO add your code here
    }

    public static void changeView(JPanel jpnItem, JLabel jlbItem, String Kind){  // Change view
        SwitchMenuController controller = new SwitchMenuController(getJpnView());
        controller.changeViewController(jpnItem, jlbItem, Kind);
    }

    public void logout() { // Logout
        ConfirmLogoutJPopupMenu confirmLogoutJPopupMenu = new ConfirmLogoutJPopupMenu(this);
    }


    public void Destroy() { // Destroy this frame
        this.setVisible(false);
        this.dispose();
    }

    public static JMenu getAvatarJMenu() {
        return avatarJMenu;
    }

    public JMenuItem getNameJMenuItem() {
        return nameJMenuItem;
    }

    public JMenuItem getLogOutJMenuItem() {
        return logOutJMenuItem;
    }

    public JLabel getJlbHome() {
        return jlbHome;
    }

    public JLabel getJlbSettings() {
        return jlbSettings;
    }

    public static JPanel getJpnView() {
        return jpnView;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - man
        headerPanel = new JPanel();
        nameAppLabell = new JLabel();
        jpnBuffer = new JPanel();
        Logo1 = new JLabel();
        Logo2 = new JLabel();
        menuBar1 = new JMenuBar();
        avatarJMenu = new JMenu();
        nameJMenuItem = new JMenuItem();
        logOutJMenuItem = new JMenuItem();
        navigationPanel = new JPanel();
        jpnHome = new JPanel();
        jlbHome = new JLabel();
        jpnSettings = new JPanel();
        jlbSettings = new JLabel();
        jpnMainMenu = new JPanel();
        jpnView = new JPanel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== headerPanel ========
        {
            headerPanel.setBorder(null);
            headerPanel.setBackground(Color.white);
            headerPanel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
            ( 0, 0 ,0 , 0) ,  "" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
            .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt
            . Color .red ) ,headerPanel. getBorder () ) ); headerPanel. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
            propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
            ;} } );
            headerPanel.setLayout(null);

            //---- nameAppLabell ----
            nameAppLabell.setFont(new Font("Fredoka One", Font.BOLD, 20));
            nameAppLabell.setIcon(new ImageIcon(getClass().getResource("/Asset/Icon/music logo design - no name.png")));
            headerPanel.add(nameAppLabell);
            nameAppLabell.setBounds(0, 5, 80, 65);

            //======== jpnBuffer ========
            {
                jpnBuffer.setBackground(Color.white);
                jpnBuffer.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jpnBufferMouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        jpnBufferMouseExited(e);
                    }
                });

                GroupLayout jpnBufferLayout = new GroupLayout(jpnBuffer);
                jpnBuffer.setLayout(jpnBufferLayout);
                jpnBufferLayout.setHorizontalGroup(
                    jpnBufferLayout.createParallelGroup()
                        .addGap(0, 220, Short.MAX_VALUE)
                );
                jpnBufferLayout.setVerticalGroup(
                    jpnBufferLayout.createParallelGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                );
            }
            headerPanel.add(jpnBuffer);
            jpnBuffer.setBounds(1180, 55, 220, 0);

            //---- Logo1 ----
            Logo1.setText("MUZIKTIC");
            Logo1.setFont(new Font("Fredoka One", Font.BOLD, 22));
            Logo1.setForeground(new Color(0xa8cf45));
            headerPanel.add(Logo1);
            Logo1.setBounds(85, 15, 215, Logo1.getPreferredSize().height);

            //---- Logo2 ----
            Logo2.setText("CONCERT MUSIC TICKETING");
            Logo2.setForeground(new Color(0x0098da));
            Logo2.setFont(new Font("Fredoka One", Font.BOLD, 15));
            headerPanel.add(Logo2);
            Logo2.setBounds(85, 45, 325, Logo2.getPreferredSize().height);

            //======== menuBar1 ========
            {
                menuBar1.setBorderPainted(false);
                menuBar1.setBackground(Color.white);

                //======== avatarJMenu ========
                {
                    avatarJMenu.setIcon(new ImageIcon(getClass().getResource("/Asset/Avatar/DefaultAvatar.png")));

                    //---- nameJMenuItem ----
                    nameJMenuItem.setText("Name");
                    nameJMenuItem.setFont(new Font("Lato Black", Font.BOLD, 14));
                    nameJMenuItem.setForeground(new Color(0x61b884));
                    nameJMenuItem.setBackground(Color.white);
                    avatarJMenu.add(nameJMenuItem);
                    avatarJMenu.addSeparator();

                    //---- logOutJMenuItem ----
                    logOutJMenuItem.setText("LOGOUT");
                    logOutJMenuItem.setFont(new Font("Lato Black", Font.BOLD, 14));
                    logOutJMenuItem.setForeground(new Color(0x61b884));
                    logOutJMenuItem.setBackground(Color.white);
                    avatarJMenu.add(logOutJMenuItem);
                }
                menuBar1.add(avatarJMenu);
            }
            headerPanel.add(menuBar1);
            menuBar1.setBounds(1260, 20, 65, 55);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < headerPanel.getComponentCount(); i++) {
                    Rectangle bounds = headerPanel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = headerPanel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                headerPanel.setMinimumSize(preferredSize);
                headerPanel.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(headerPanel);
        headerPanel.setBounds(0, 10, 1401, 85);

        //======== navigationPanel ========
        {
            navigationPanel.setBorder(null);

            //======== jpnHome ========
            {
                jpnHome.setPreferredSize(new Dimension(225, 65));
                jpnHome.setBackground(Color.white);

                //---- jlbHome ----
                jlbHome.setText("HOME");
                jlbHome.setHorizontalAlignment(SwingConstants.CENTER);
                jlbHome.setBorder(null);
                jlbHome.setPreferredSize(new Dimension(225, 65));
                jlbHome.setBackground(new Color(0x61b884));
                jlbHome.setFont(new Font("Lato Black", Font.BOLD, 20));
                jlbHome.setForeground(new Color(0x61b884));
                jlbHome.setIcon(null);

                GroupLayout jpnHomeLayout = new GroupLayout(jpnHome);
                jpnHome.setLayout(jpnHomeLayout);
                jpnHomeLayout.setHorizontalGroup(
                    jpnHomeLayout.createParallelGroup()
                        .addGroup(jpnHomeLayout.createSequentialGroup()
                            .addComponent(jlbHome, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                );
                jpnHomeLayout.setVerticalGroup(
                    jpnHomeLayout.createParallelGroup()
                        .addComponent(jlbHome, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                );
            }

            //======== jpnSettings ========
            {
                jpnSettings.setPreferredSize(new Dimension(225, 65));
                jpnSettings.setBackground(Color.white);

                //---- jlbSettings ----
                jlbSettings.setText("SETTINGS");
                jlbSettings.setHorizontalAlignment(SwingConstants.CENTER);
                jlbSettings.setBorder(null);
                jlbSettings.setPreferredSize(new Dimension(225, 65));
                jlbSettings.setForeground(new Color(0x61b884));
                jlbSettings.setFont(new Font("Lato Black", Font.BOLD, 20));

                GroupLayout jpnSettingsLayout = new GroupLayout(jpnSettings);
                jpnSettings.setLayout(jpnSettingsLayout);
                jpnSettingsLayout.setHorizontalGroup(
                    jpnSettingsLayout.createParallelGroup()
                        .addGroup(jpnSettingsLayout.createSequentialGroup()
                            .addComponent(jlbSettings, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                );
                jpnSettingsLayout.setVerticalGroup(
                    jpnSettingsLayout.createParallelGroup()
                        .addComponent(jlbSettings, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                );
            }

            GroupLayout navigationPanelLayout = new GroupLayout(navigationPanel);
            navigationPanel.setLayout(navigationPanelLayout);
            navigationPanelLayout.setHorizontalGroup(
                navigationPanelLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, navigationPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(navigationPanelLayout.createParallelGroup()
                            .addComponent(jpnHome, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnSettings, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
            );
            navigationPanelLayout.setVerticalGroup(
                navigationPanelLayout.createParallelGroup()
                    .addGroup(navigationPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jpnHome, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnSettings, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(763, Short.MAX_VALUE))
            );
        }
        contentPane.add(navigationPanel);
        navigationPanel.setBounds(0, 70, 237, 905);

        //======== jpnMainMenu ========
        {
            jpnMainMenu.setBorder(null);
            jpnMainMenu.setLayout(null);

            //======== jpnView ========
            {
                jpnView.setBackground(Color.white);

                GroupLayout jpnViewLayout = new GroupLayout(jpnView);
                jpnView.setLayout(jpnViewLayout);
                jpnViewLayout.setHorizontalGroup(
                    jpnViewLayout.createParallelGroup()
                        .addGap(0, 1155, Short.MAX_VALUE)
                );
                jpnViewLayout.setVerticalGroup(
                    jpnViewLayout.createParallelGroup()
                        .addGap(0, 730, Short.MAX_VALUE)
                );
            }
            jpnMainMenu.add(jpnView);
            jpnView.setBounds(10, 5, 1155, 730);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jpnMainMenu.getComponentCount(); i++) {
                    Rectangle bounds = jpnMainMenu.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jpnMainMenu.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jpnMainMenu.setMinimumSize(preferredSize);
                jpnMainMenu.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(jpnMainMenu);
        jpnMainMenu.setBounds(240, 95, 1161, 735);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - man
    private JPanel headerPanel;
    private JLabel nameAppLabell;
    private JPanel jpnBuffer;
    private JLabel Logo1;
    private JLabel Logo2;
    private JMenuBar menuBar1;
    private static JMenu avatarJMenu;
    private JMenuItem nameJMenuItem;
    private static JMenuItem logOutJMenuItem;
    private JPanel navigationPanel;
    private JPanel jpnHome;
    private static JLabel jlbHome;
    private JPanel jpnSettings;
    private static JLabel jlbSettings;
    private JPanel jpnMainMenu;
    private static JPanel jpnView;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
