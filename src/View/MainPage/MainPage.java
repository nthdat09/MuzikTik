/*
 * Created by JFormDesigner on Sun Apr 23 10:39:47 ICT 2023
 */

package View.MainPage;

import Controller.MainMenu.LogoutController;
import Controller.Menu.SwitchMenuController;
import Model.BEAN.Employee;
import Model.BEAN.MenuList;
import Model.DAO.Employee.EmployeeDAO;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ADMIN
 */
public class MainPage extends JFrame {
    ActionListener ac = new LogoutController(this);
    static String username;

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MainPage(String username) {
        initComponents();
        initSomeSetting(username);
    }

    private void initSomeSetting(String username) {
        SwitchMenuController controller = new SwitchMenuController(jpnView);
        controller.setUserName(username);
        controller.setView(jpnHome,jlbHome);

        this.username = username;

        List<MenuList> listItem = new ArrayList<MenuList>();
        listItem.add(new MenuList("HomePanel", jpnHome, jlbHome));
        listItem.add(new MenuList("EventPanel", jpnEvent,jlbEvent));
        listItem.add(new MenuList("CustomersPanel", jpnCustomers, jlbCustomer));
        listItem.add(new MenuList("TicketPanel", jpnTickets,jlbTickets));
        listItem.add(new MenuList("StagePanel",jpnStages,jlbStages));
        listItem.add(new MenuList("PartnerPanel",jpnPartners,jlbPartners));
        listItem.add(new MenuList("AnalyticPanel",jpnAnalytics,jlbAnalytics));
        listItem.add(new MenuList("AccountPanel", jpnSettings,jlbSettings));
        controller.setEvent(listItem);

        this.getLogOutJMenuItem().addActionListener(ac);
        // Set username
        this.getNameJMenuItem().setText("Hello, " + username);

        // Set avatar
        setImageForLogoUser();

        // Set icon for app
        ImageIcon imageIcon = new ImageIcon("src/Asset/Logo/Logo.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        this.setIconImage(imageIcon.getImage());

    }

    public static Path getAbsolutePath() {
        // Get Current Directory using getAbsolutePath()
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        return currentPath;
    }

    public static void setImageForLogoUser(){
        // Set avatar
        Employee employee = EmployeeDAO.getUserByUsername(MainPage.getUsername());
        if (employee.getAvatar() != null) { // If avatar is not null
            ImageIcon imageIcon = new ImageIcon(employee.getAvatar());
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            getAvatarJMenu().setIcon(imageIcon);
        }
        else {
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
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum); //no doubt here is 0
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            byte[] bytes = bos.toByteArray();
            employee.setAvatar(bytes);
            EmployeeDAO.updateAvatar(employee);
            ImageIcon imageIcon = new ImageIcon(bytes);
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            getAvatarJMenu().setIcon(imageIcon);
        }
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

    Border border = new LineBorder(Color.decode("#61b884"),1,true);

    private void button1MouseClicked(MouseEvent e) {
        jpnMainMenu.setVisible(false);
    }
    
    private void searchButtonMouseEntered(MouseEvent e) {
        // TODO add your code here
    }


    private void jlbHomeMouseEntered(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbHomeMouseExited(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbEventMouseExited(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbEventMouseEntered(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbCustomerMouseEntered(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbCustomerMouseExited(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbTicketsMouseEntered(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbTicketsMouseExited(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbStagesMouseEntered(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbStagesMouseExited(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbParnersMouseEntered(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbParnersMouseExited(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbAnalyticsMouseEntered(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbAnalyticsMouseExited(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbSettingsMouseEntered(MouseEvent e) {
        // TODO add your code here
    }

    private void jlbSettingsMouseExited(MouseEvent e) {
        // TODO add your code here
    }

    public static JLabel getJlbCustomer() {
        return jlbCustomer;
    }

    public static JLabel getJlbTickets(){
        return jlbTickets;
    }

    public static JPanel getJpnView() {
        return jpnView;
    }

    public static JLabel getJlbStages() {
        return jlbStages;
    }

    public static JLabel getJlbPartners() {
        return jlbPartners;
    }

    public JLabel getJlbAnalytics() {
        return jlbAnalytics;
    }

    public static JLabel getJlbSettings() {
        return jlbSettings;
    }

    public static JLabel getJlbEvent() {
        return jlbEvent;
    }

    public JLabel getJlbHome() {
        return jlbHome;
    }

    public static JMenu getAvatarJMenu() {
        return avatarJMenu;
    }

    private void jpnBufferMouseEntered(MouseEvent e) {
        // TODO add your code here
    }

    private void jpnBufferMouseExited(MouseEvent e) {
        // TODO add your code here
    }

    public JMenuItem getNameJMenuItem() {
        return nameJMenuItem;
    }

    public JMenuItem getLogOutJMenuItem() {
        return logOutJMenuItem;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
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
        jpnEvent = new JPanel();
        jlbEvent = new JLabel();
        jpnCustomers = new JPanel();
        jlbCustomer = new JLabel();
        jpnTickets = new JPanel();
        jlbTickets = new JLabel();
        jpnStages = new JPanel();
        jlbStages = new JLabel();
        jpnPartners = new JPanel();
        jlbPartners = new JLabel();
        jpnAnalytics = new JPanel();
        jlbAnalytics = new JLabel();
        jpnSettings = new JPanel();
        jlbSettings = new JLabel();
        jpnMainMenu = new JPanel();
        jpnView = new JPanel();

        //======== this ========
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== headerPanel ========
        {
            headerPanel.setBorder(new LineBorder(new Color(0xbebebe)));
            headerPanel.setBackground(Color.white);
            headerPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
            . border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder
            . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
            awt .Font .BOLD ,12 ), java. awt. Color. red) ,headerPanel. getBorder( )) )
            ; headerPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
            ;
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
            menuBar1.setBounds(1260, 15, 105, 40);

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
        headerPanel.setBounds(0, 0, 1401, 75);

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
                jlbHome.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jlbHomeMouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        jlbHomeMouseExited(e);
                    }
                });

                GroupLayout jpnHomeLayout = new GroupLayout(jpnHome);
                jpnHome.setLayout(jpnHomeLayout);
                jpnHomeLayout.setHorizontalGroup(
                    jpnHomeLayout.createParallelGroup()
                        .addComponent(jlbHome, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                );
                jpnHomeLayout.setVerticalGroup(
                    jpnHomeLayout.createParallelGroup()
                        .addComponent(jlbHome, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                );
            }

            //======== jpnEvent ========
            {
                jpnEvent.setPreferredSize(new Dimension(225, 65));
                jpnEvent.setBackground(Color.white);

                //---- jlbEvent ----
                jlbEvent.setText("EVENTS");
                jlbEvent.setHorizontalAlignment(SwingConstants.CENTER);
                jlbEvent.setBorder(null);
                jlbEvent.setPreferredSize(new Dimension(225, 65));
                jlbEvent.setForeground(new Color(0x61b884));
                jlbEvent.setFont(new Font("Lato Black", Font.BOLD, 20));
                jlbEvent.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jlbEventMouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        jlbEventMouseExited(e);
                    }
                });

                GroupLayout jpnEventLayout = new GroupLayout(jpnEvent);
                jpnEvent.setLayout(jpnEventLayout);
                jpnEventLayout.setHorizontalGroup(
                    jpnEventLayout.createParallelGroup()
                        .addComponent(jlbEvent, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                );
                jpnEventLayout.setVerticalGroup(
                    jpnEventLayout.createParallelGroup()
                        .addComponent(jlbEvent, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                );
            }

            //======== jpnCustomers ========
            {
                jpnCustomers.setPreferredSize(new Dimension(225, 65));
                jpnCustomers.setBackground(Color.white);

                //---- jlbCustomer ----
                jlbCustomer.setText("CUSTOMERS");
                jlbCustomer.setHorizontalAlignment(SwingConstants.CENTER);
                jlbCustomer.setBorder(null);
                jlbCustomer.setPreferredSize(new Dimension(225, 65));
                jlbCustomer.setForeground(new Color(0x61b884));
                jlbCustomer.setFont(new Font("Lato Black", Font.BOLD, 20));
                jlbCustomer.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jlbCustomerMouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        jlbCustomerMouseExited(e);
                    }
                });

                GroupLayout jpnCustomersLayout = new GroupLayout(jpnCustomers);
                jpnCustomers.setLayout(jpnCustomersLayout);
                jpnCustomersLayout.setHorizontalGroup(
                    jpnCustomersLayout.createParallelGroup()
                        .addComponent(jlbCustomer, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                );
                jpnCustomersLayout.setVerticalGroup(
                    jpnCustomersLayout.createParallelGroup()
                        .addComponent(jlbCustomer, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                );
            }

            //======== jpnTickets ========
            {
                jpnTickets.setPreferredSize(new Dimension(225, 65));
                jpnTickets.setBackground(Color.white);

                //---- jlbTickets ----
                jlbTickets.setText("TICKETS");
                jlbTickets.setHorizontalAlignment(SwingConstants.CENTER);
                jlbTickets.setBorder(null);
                jlbTickets.setPreferredSize(new Dimension(225, 65));
                jlbTickets.setForeground(new Color(0x61b884));
                jlbTickets.setFont(new Font("Lato Black", Font.BOLD, 20));
                jlbTickets.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jlbTicketsMouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        jlbTicketsMouseExited(e);
                    }
                });

                GroupLayout jpnTicketsLayout = new GroupLayout(jpnTickets);
                jpnTickets.setLayout(jpnTicketsLayout);
                jpnTicketsLayout.setHorizontalGroup(
                    jpnTicketsLayout.createParallelGroup()
                        .addComponent(jlbTickets, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                );
                jpnTicketsLayout.setVerticalGroup(
                    jpnTicketsLayout.createParallelGroup()
                        .addComponent(jlbTickets, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                );
            }

            //======== jpnStages ========
            {
                jpnStages.setPreferredSize(new Dimension(225, 65));
                jpnStages.setBackground(Color.white);

                //---- jlbStages ----
                jlbStages.setText("STAGES");
                jlbStages.setHorizontalAlignment(SwingConstants.CENTER);
                jlbStages.setBorder(null);
                jlbStages.setPreferredSize(new Dimension(225, 65));
                jlbStages.setForeground(new Color(0x61b884));
                jlbStages.setFont(new Font("Lato Black", Font.BOLD, 20));
                jlbStages.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jlbStagesMouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        jlbStagesMouseExited(e);
                    }
                });

                GroupLayout jpnStagesLayout = new GroupLayout(jpnStages);
                jpnStages.setLayout(jpnStagesLayout);
                jpnStagesLayout.setHorizontalGroup(
                    jpnStagesLayout.createParallelGroup()
                        .addComponent(jlbStages, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                );
                jpnStagesLayout.setVerticalGroup(
                    jpnStagesLayout.createParallelGroup()
                        .addGroup(jpnStagesLayout.createSequentialGroup()
                            .addComponent(jlbStages, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 2, Short.MAX_VALUE))
                );
            }

            //======== jpnPartners ========
            {
                jpnPartners.setPreferredSize(new Dimension(225, 65));
                jpnPartners.setBackground(Color.white);

                //---- jlbPartners ----
                jlbPartners.setText("PARTNERS");
                jlbPartners.setHorizontalAlignment(SwingConstants.CENTER);
                jlbPartners.setBorder(null);
                jlbPartners.setPreferredSize(new Dimension(225, 65));
                jlbPartners.setForeground(new Color(0x61b884));
                jlbPartners.setFont(new Font("Lato Black", Font.BOLD, 20));
                jlbPartners.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jlbParnersMouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        jlbParnersMouseExited(e);
                    }
                });

                GroupLayout jpnPartnersLayout = new GroupLayout(jpnPartners);
                jpnPartners.setLayout(jpnPartnersLayout);
                jpnPartnersLayout.setHorizontalGroup(
                    jpnPartnersLayout.createParallelGroup()
                        .addComponent(jlbPartners, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                );
                jpnPartnersLayout.setVerticalGroup(
                    jpnPartnersLayout.createParallelGroup()
                        .addComponent(jlbPartners, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                );
            }

            //======== jpnAnalytics ========
            {
                jpnAnalytics.setPreferredSize(new Dimension(225, 65));
                jpnAnalytics.setBackground(Color.white);

                //---- jlbAnalytics ----
                jlbAnalytics.setText("ANALYTICS");
                jlbAnalytics.setHorizontalAlignment(SwingConstants.CENTER);
                jlbAnalytics.setBorder(null);
                jlbAnalytics.setPreferredSize(new Dimension(225, 65));
                jlbAnalytics.setForeground(new Color(0x61b884));
                jlbAnalytics.setFont(new Font("Lato Black", Font.BOLD, 20));
                jlbAnalytics.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jlbAnalyticsMouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        jlbAnalyticsMouseExited(e);
                    }
                });

                GroupLayout jpnAnalyticsLayout = new GroupLayout(jpnAnalytics);
                jpnAnalytics.setLayout(jpnAnalyticsLayout);
                jpnAnalyticsLayout.setHorizontalGroup(
                    jpnAnalyticsLayout.createParallelGroup()
                        .addComponent(jlbAnalytics, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                );
                jpnAnalyticsLayout.setVerticalGroup(
                    jpnAnalyticsLayout.createParallelGroup()
                        .addComponent(jlbAnalytics, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
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
                jlbSettings.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jlbSettingsMouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        jlbSettingsMouseExited(e);
                    }
                });

                GroupLayout jpnSettingsLayout = new GroupLayout(jpnSettings);
                jpnSettings.setLayout(jpnSettingsLayout);
                jpnSettingsLayout.setHorizontalGroup(
                    jpnSettingsLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, jpnSettingsLayout.createSequentialGroup()
                            .addGap(0, 6, Short.MAX_VALUE)
                            .addComponent(jlbSettings, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                    .addGroup(navigationPanelLayout.createSequentialGroup()
                        .addGroup(navigationPanelLayout.createParallelGroup()
                            .addComponent(jpnHome, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnEvent, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnCustomers, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnTickets, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnStages, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnPartners, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnAnalytics, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnSettings, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            navigationPanelLayout.setVerticalGroup(
                navigationPanelLayout.createParallelGroup()
                    .addGroup(navigationPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jpnHome, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnEvent, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnCustomers, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnTickets, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnStages, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnPartners, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnAnalytics, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnSettings, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(409, Short.MAX_VALUE))
            );
        }
        contentPane.add(navigationPanel);
        navigationPanel.setBounds(0, 65, navigationPanel.getPreferredSize().width, 905);

        //======== jpnMainMenu ========
        {
            jpnMainMenu.setBorder(null);
            jpnMainMenu.setBackground(Color.white);
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
            jpnView.setBounds(5, 5, 1155, 730);

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
    // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
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
    private JPanel jpnEvent;
    private static JLabel jlbEvent;
    private JPanel jpnCustomers;
    private static JLabel jlbCustomer;
    private JPanel jpnTickets;
    private static JLabel jlbTickets;
    private JPanel jpnStages;
    private static JLabel jlbStages;
    private JPanel jpnPartners;
    private static JLabel jlbPartners;
    private JPanel jpnAnalytics;
    private static JLabel jlbAnalytics;
    private JPanel jpnSettings;
    private static JLabel jlbSettings;
    private JPanel jpnMainMenu;
    private static JPanel jpnView;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
