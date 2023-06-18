/*
 * Created by JFormDesigner on Sun Jun 18 09:57:51 ICT 2023
 */

package View.MainPage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author giama
 */
public class MainPageCustomer extends JPanel {
    public MainPageCustomer() {
        initComponents();
    }

    private void jpnBufferMouseEntered(MouseEvent e) {
        // TODO add your code here
    }

    private void jpnBufferMouseExited(MouseEvent e) {
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

    public JMenu getAvatarJMenu() {
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

    public JPanel getJpnView() {
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
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
        . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing
        .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
        Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
        ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
        public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName (
        ) ) )throw new RuntimeException( ) ;} } );
        setLayout(null);

        //======== headerPanel ========
        {
            headerPanel.setBorder(null);
            headerPanel.setBackground(Color.white);
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
        add(headerPanel);
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
                            .addGroup(navigationPanelLayout.createSequentialGroup()
                                .addComponent(jpnHome, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, navigationPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jpnSettings, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)))
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
        add(navigationPanel);
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
        add(jpnMainMenu);
        jpnMainMenu.setBounds(240, 95, 1161, 735);

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
