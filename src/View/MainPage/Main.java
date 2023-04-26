/*
 * Created by JFormDesigner on Sun Apr 23 10:39:47 ICT 2023
 */

package View.MainPage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author ADMIN
 */
public class Main extends JFrame {
    public Main() {
        initComponents();
        jpnDropMenu4.setSize(0,0);
        jpnDropMenu4.setBorder(border);
    }

    Border border = new LineBorder(Color.decode("#61b884"),1,true);

    private void searchButtonMouseEntered(MouseEvent e) {
        // TODO add your code here
    }

    private void button1MouseExited(MouseEvent e) {
        jpnMainMenu.setVisible(true);
    }

    private void button1MouseClicked(MouseEvent e) {
        jpnMainMenu.setVisible(false);
    }

    private void jpnAvatarMouseEntered(MouseEvent e) {
        jpnDropMenu4.setSize(300,300);
    }

    private void label10MouseExited(MouseEvent e) {
        jpnDropMenu4.setSize(0,0);
        jpnBuffer.setSize(220,19);
        jpnBuffer2.setSize(220,25);
    }
    private void label10MousePressed(MouseEvent e) {
        
    }

    private void label10MouseEntered(MouseEvent e) {
        jpnDropMenu4.setSize(195,245);
    }

    private void jpnDropMenu4MouseEntered(MouseEvent e) {
        jpnDropMenu4.setSize(195,245);
    }

    private void jpnDropMenu4MouseExited(MouseEvent e) {
        jpnDropMenu4.setSize(0,0);
        jpnBuffer.setSize(0,0);
    }

    private void jpnBufferMouseEntered(MouseEvent e) {
        jpnDropMenu4.setSize(195,245);
    }

    private void jpnBufferMouseExited(MouseEvent e) {
        jpnDropMenu4.setSize(0,0);
        jpnBuffer.setSize(0,0);
    }

    private void jpnBuffer2MouseEntered(MouseEvent e) {
        jpnDropMenu4.setSize(195,245);
    }

    private void jpnBuffer2MouseExited(MouseEvent e) {
        jpnDropMenu4.setSize(0,0);
        jpnBuffer.setSize(0,0);
        jpnBuffer2.setSize(0,0);
    }

    private void jlbHomeMouseEntered(MouseEvent e) {
        jpnHome.setBackground(Color.white);
        jpnHome.setBorder(border);
        jlbHome.setForeground(Color.decode("#61b884"));
    }

    private void jlbHomeMouseExited(MouseEvent e) {
        jpnHome.setBackground(Color.decode("#61b884"));
        jpnHome.setBorder(BorderFactory.createEmptyBorder());
        jlbHome.setForeground(Color.white);
    }

    private void jlbEventMouseExited(MouseEvent e) {
        jpnEvent.setBackground(Color.decode("#61b884"));
        jpnEvent.setBorder(BorderFactory.createEmptyBorder());
        jlbEvent.setForeground(Color.white);
    }

    private void jlbEventMouseEntered(MouseEvent e) {
        jpnEvent.setBackground(Color.white);
        jpnEvent.setBorder(border);
        jlbEvent.setForeground(Color.decode("#61b884"));
    }

    private void jlbCustomerMouseEntered(MouseEvent e) {
        jpnCustomers.setBackground(Color.white);
        jpnCustomers.setBorder(border);
        jlbCustomer.setForeground(Color.decode("#61b884"));
    }

    private void jlbCustomerMouseExited(MouseEvent e) {
        jpnCustomers.setBackground(Color.decode("#61b884"));
        jpnCustomers.setBorder(BorderFactory.createEmptyBorder());
        jlbCustomer.setForeground(Color.white);
    }

    private void jlbTicketsMouseEntered(MouseEvent e) {
        jpnTickets.setBackground(Color.white);
        jpnTickets.setBorder(border);
        jlbTickets.setForeground(Color.decode("#61b884"));
    }

    private void jlbTicketsMouseExited(MouseEvent e) {
        jpnTickets.setBackground(Color.decode("#61b884"));
        jpnTickets.setBorder(BorderFactory.createEmptyBorder());
        jlbTickets.setForeground(Color.white);
    }

    private void jlbStagesMouseEntered(MouseEvent e) {
        jpnStages.setBackground(Color.white);
        jpnStages.setBorder(border);
        jlbStages.setForeground(Color.decode("#61b884"));
    }

    private void jlbStagesMouseExited(MouseEvent e) {
        jpnStages.setBackground(Color.decode("#61b884"));
        jpnStages.setBorder(BorderFactory.createEmptyBorder());
        jlbStages.setForeground(Color.white);
    }

    private void jlbParnersMouseEntered(MouseEvent e) {
        jpnPartners.setBackground(Color.white);
        jpnPartners.setBorder(border);
        jlbParners.setForeground(Color.decode("#61b884"));
    }

    private void jlbParnersMouseExited(MouseEvent e) {
        jpnPartners.setBackground(Color.decode("#61b884"));
        jpnPartners.setBorder(BorderFactory.createEmptyBorder());
        jlbParners.setForeground(Color.white);
    }

    private void jlbAnalyticsMouseEntered(MouseEvent e) {
        jpnAnalytics.setBackground(Color.white);
        jpnAnalytics.setBorder(border);
        jlbAnalytics.setForeground(Color.decode("#61b884"));
    }

    private void jlbAnalyticsMouseExited(MouseEvent e) {
        jpnAnalytics.setBackground(Color.decode("#61b884"));
        jpnAnalytics.setBorder(BorderFactory.createEmptyBorder());
        jlbAnalytics.setForeground(Color.white);
    }

    private void jlbSettingsMouseEntered(MouseEvent e) {
        jpnSettings.setBackground(Color.white);
        jpnSettings.setBorder(border);
        jlbSettings.setForeground(Color.decode("#61b884"));
    }

    private void jlbSettingsMouseExited(MouseEvent e) {
        jpnSettings.setBackground(Color.decode("#61b884"));
        jpnSettings.setBorder(BorderFactory.createEmptyBorder());
        jlbSettings.setForeground(Color.white);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
        headerPanel = new JPanel();
        searchButton = new JTextField();
        nameAppLabell = new JLabel();
        label10 = new JLabel();
        jpnBuffer = new JPanel();
        Logo1 = new JLabel();
        Logo2 = new JLabel();
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
        jlbParners = new JLabel();
        jpnAnalytics = new JPanel();
        jlbAnalytics = new JLabel();
        jpnSettings = new JPanel();
        jlbSettings = new JLabel();
        jpnMainMenu = new JPanel();
        jpnDropMenu4 = new JPanel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        jpnBuffer2 = new JPanel();

        //======== this ========
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== headerPanel ========
        {
            headerPanel.setBorder(new LineBorder(new Color(0xbebebe)));
            headerPanel.setBackground(Color.white);
            headerPanel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder (
            new javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  ""
            , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM
            , new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 )
            ,java . awt. Color .red ) ,headerPanel. getBorder () ) ); headerPanel. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
            ;} } );
            headerPanel.setLayout(null);

            //---- searchButton ----
            searchButton.setText("Search");
            searchButton.setFont(new Font("Lato", Font.PLAIN, 16));
            searchButton.setForeground(new Color(0x666666));
            searchButton.setBorder(new LineBorder(new Color(0x61b884), 1, true));
            searchButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    searchButtonMouseEntered(e);
                }
            });
            headerPanel.add(searchButton);
            searchButton.setBounds(750, 20, 461, 30);

            //---- nameAppLabell ----
            nameAppLabell.setFont(new Font("Fredoka One", Font.BOLD, 20));
            nameAppLabell.setIcon(new ImageIcon(getClass().getResource("/Asset/music logo design - no name.png")));
            headerPanel.add(nameAppLabell);
            nameAppLabell.setBounds(0, 5, 80, 65);

            //---- label10 ----
            label10.setText("Avatar");
            label10.setHorizontalAlignment(SwingConstants.CENTER);
            label10.setBorder(new LineBorder(new Color(0x61b884)));
            label10.setFont(new Font("Lato Black", Font.BOLD, 18));
            label10.setForeground(new Color(0x61b884));
            label10.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    label10MouseEntered(e);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    label10MouseExited(e);
                }
                @Override
                public void mousePressed(MouseEvent e) {
                    label10MousePressed(e);
                }
            });
            headerPanel.add(label10);
            label10.setBounds(1235, 10, 105, 45);

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
            Logo1.setBounds(new Rectangle(new Point(85, 15), Logo1.getPreferredSize()));

            //---- Logo2 ----
            Logo2.setText("CONCERT MUSIC TICKETING");
            Logo2.setForeground(new Color(0x0098da));
            Logo2.setFont(new Font("Fredoka One", Font.BOLD, 15));
            headerPanel.add(Logo2);
            Logo2.setBounds(new Rectangle(new Point(85, 45), Logo2.getPreferredSize()));

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
                jpnHome.setBackground(new Color(0x61b884));

                //---- jlbHome ----
                jlbHome.setText("HOME");
                jlbHome.setHorizontalAlignment(SwingConstants.CENTER);
                jlbHome.setBorder(null);
                jlbHome.setPreferredSize(new Dimension(225, 65));
                jlbHome.setBackground(new Color(0x61b884));
                jlbHome.setFont(new Font("Lato Black", Font.BOLD, 20));
                jlbHome.setForeground(Color.white);
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
                        .addComponent(jlbHome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jpnHomeLayout.setVerticalGroup(
                    jpnHomeLayout.createParallelGroup()
                        .addComponent(jlbHome, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                );
            }

            //======== jpnEvent ========
            {
                jpnEvent.setPreferredSize(new Dimension(225, 65));
                jpnEvent.setBackground(new Color(0x61b884));

                //---- jlbEvent ----
                jlbEvent.setText("EVENTS");
                jlbEvent.setHorizontalAlignment(SwingConstants.CENTER);
                jlbEvent.setBorder(null);
                jlbEvent.setPreferredSize(new Dimension(225, 65));
                jlbEvent.setForeground(Color.white);
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
                        .addComponent(jlbEvent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jpnEventLayout.setVerticalGroup(
                    jpnEventLayout.createParallelGroup()
                        .addComponent(jlbEvent, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                );
            }

            //======== jpnCustomers ========
            {
                jpnCustomers.setPreferredSize(new Dimension(225, 65));
                jpnCustomers.setBackground(new Color(0x61b884));

                //---- jlbCustomer ----
                jlbCustomer.setText("CUSTOMERS");
                jlbCustomer.setHorizontalAlignment(SwingConstants.CENTER);
                jlbCustomer.setBorder(null);
                jlbCustomer.setPreferredSize(new Dimension(225, 65));
                jlbCustomer.setForeground(Color.white);
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
                        .addGroup(GroupLayout.Alignment.TRAILING, jpnCustomersLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jlbCustomer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
                jpnCustomersLayout.setVerticalGroup(
                    jpnCustomersLayout.createParallelGroup()
                        .addComponent(jlbCustomer, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                );
            }

            //======== jpnTickets ========
            {
                jpnTickets.setPreferredSize(new Dimension(225, 65));
                jpnTickets.setBackground(new Color(0x61b884));

                //---- jlbTickets ----
                jlbTickets.setText("TICKETS");
                jlbTickets.setHorizontalAlignment(SwingConstants.CENTER);
                jlbTickets.setBorder(null);
                jlbTickets.setPreferredSize(new Dimension(225, 65));
                jlbTickets.setForeground(Color.white);
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
                        .addGroup(GroupLayout.Alignment.TRAILING, jpnTicketsLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jlbTickets, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
                jpnTicketsLayout.setVerticalGroup(
                    jpnTicketsLayout.createParallelGroup()
                        .addComponent(jlbTickets, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                );
            }

            //======== jpnStages ========
            {
                jpnStages.setPreferredSize(new Dimension(225, 65));
                jpnStages.setBackground(new Color(0x61b884));

                //---- jlbStages ----
                jlbStages.setText("STAGES");
                jlbStages.setHorizontalAlignment(SwingConstants.CENTER);
                jlbStages.setBorder(null);
                jlbStages.setPreferredSize(new Dimension(225, 65));
                jlbStages.setForeground(Color.white);
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
                        .addGroup(GroupLayout.Alignment.TRAILING, jpnStagesLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jlbStages, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                jpnPartners.setBackground(new Color(0x61b884));

                //---- jlbParners ----
                jlbParners.setText("PARTNERS");
                jlbParners.setHorizontalAlignment(SwingConstants.CENTER);
                jlbParners.setBorder(null);
                jlbParners.setPreferredSize(new Dimension(225, 65));
                jlbParners.setForeground(Color.white);
                jlbParners.setFont(new Font("Lato Black", Font.BOLD, 20));
                jlbParners.addMouseListener(new MouseAdapter() {
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
                        .addGroup(GroupLayout.Alignment.TRAILING, jpnPartnersLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jlbParners, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
                jpnPartnersLayout.setVerticalGroup(
                    jpnPartnersLayout.createParallelGroup()
                        .addComponent(jlbParners, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                );
            }

            //======== jpnAnalytics ========
            {
                jpnAnalytics.setPreferredSize(new Dimension(225, 65));
                jpnAnalytics.setBackground(new Color(0x61b884));

                //---- jlbAnalytics ----
                jlbAnalytics.setText("ANALYTICS");
                jlbAnalytics.setHorizontalAlignment(SwingConstants.CENTER);
                jlbAnalytics.setBorder(null);
                jlbAnalytics.setPreferredSize(new Dimension(225, 65));
                jlbAnalytics.setForeground(Color.white);
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
                        .addGroup(GroupLayout.Alignment.TRAILING, jpnAnalyticsLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jlbAnalytics, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
                jpnAnalyticsLayout.setVerticalGroup(
                    jpnAnalyticsLayout.createParallelGroup()
                        .addComponent(jlbAnalytics, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                );
            }

            //======== jpnSettings ========
            {
                jpnSettings.setPreferredSize(new Dimension(225, 65));
                jpnSettings.setBackground(new Color(0x61b884));

                //---- jlbSettings ----
                jlbSettings.setText("SETTINGS");
                jlbSettings.setHorizontalAlignment(SwingConstants.CENTER);
                jlbSettings.setBorder(null);
                jlbSettings.setPreferredSize(new Dimension(225, 65));
                jlbSettings.setForeground(Color.white);
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
                            .addGap(0, 0, Short.MAX_VALUE)
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
                        .addContainerGap()
                        .addGroup(navigationPanelLayout.createParallelGroup()
                            .addComponent(jpnHome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnEvent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnCustomers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnTickets, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnStages, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnPartners, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnAnalytics, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnSettings, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
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
                        .addContainerGap(203, Short.MAX_VALUE))
            );
        }
        contentPane.add(navigationPanel);
        navigationPanel.setBounds(0, 65, navigationPanel.getPreferredSize().width, 699);

        //======== jpnMainMenu ========
        {
            jpnMainMenu.setBorder(null);
            jpnMainMenu.setBackground(Color.white);
            jpnMainMenu.setLayout(null);

            //======== jpnDropMenu4 ========
            {
                jpnDropMenu4.setBorder(null);
                jpnDropMenu4.setBackground(Color.white);
                jpnDropMenu4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jpnDropMenu4MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        jpnDropMenu4MouseExited(e);
                    }
                });

                //---- label12 ----
                label12.setText("*t\u00ean kh\u00e1ch h\u00e0ng");
                label12.setFont(new Font("Lato Black", Font.BOLD, 18));
                label12.setForeground(new Color(0x61b884));

                //---- label13 ----
                label13.setText("*ID");
                label13.setFont(new Font("Lato Black", Font.BOLD, 18));
                label13.setForeground(new Color(0x61b884));

                //---- label14 ----
                label14.setText("*\u0111\u0103ng xu\u1ea5t");
                label14.setFont(new Font("Lato Black", Font.BOLD, 18));
                label14.setForeground(new Color(0x61b884));

                GroupLayout jpnDropMenu4Layout = new GroupLayout(jpnDropMenu4);
                jpnDropMenu4.setLayout(jpnDropMenu4Layout);
                jpnDropMenu4Layout.setHorizontalGroup(
                    jpnDropMenu4Layout.createParallelGroup()
                        .addGroup(jpnDropMenu4Layout.createSequentialGroup()
                            .addGroup(jpnDropMenu4Layout.createParallelGroup()
                                .addComponent(label12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(GroupLayout.Alignment.TRAILING, jpnDropMenu4Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(jpnDropMenu4Layout.createParallelGroup()
                                        .addComponent(label13, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label14, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap())
                );
                jpnDropMenu4Layout.setVerticalGroup(
                    jpnDropMenu4Layout.createParallelGroup()
                        .addGroup(jpnDropMenu4Layout.createSequentialGroup()
                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label13, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label14, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            jpnMainMenu.add(jpnDropMenu4);
            jpnDropMenu4.setBounds(950, 0, 210, 5);

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
        jpnMainMenu.setBounds(240, 95, 1161, 633);

        //======== jpnBuffer2 ========
        {
            jpnBuffer2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    jpnBufferMouseEntered(e);
                    jpnBuffer2MouseEntered(e);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    jpnBufferMouseExited(e);
                    jpnBuffer2MouseExited(e);
                }
            });

            GroupLayout jpnBuffer2Layout = new GroupLayout(jpnBuffer2);
            jpnBuffer2.setLayout(jpnBuffer2Layout);
            jpnBuffer2Layout.setHorizontalGroup(
                jpnBuffer2Layout.createParallelGroup()
                    .addGap(0, 220, Short.MAX_VALUE)
            );
            jpnBuffer2Layout.setVerticalGroup(
                jpnBuffer2Layout.createParallelGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
            );
        }
        contentPane.add(jpnBuffer2);
        jpnBuffer2.setBounds(1180, 75, 220, 25);

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
    // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
    private JPanel headerPanel;
    private JTextField searchButton;
    private JLabel nameAppLabell;
    private JLabel label10;
    private JPanel jpnBuffer;
    private JLabel Logo1;
    private JLabel Logo2;
    private JPanel navigationPanel;
    private JPanel jpnHome;
    private JLabel jlbHome;
    private JPanel jpnEvent;
    private JLabel jlbEvent;
    private JPanel jpnCustomers;
    private JLabel jlbCustomer;
    private JPanel jpnTickets;
    private JLabel jlbTickets;
    private JPanel jpnStages;
    private JLabel jlbStages;
    private JPanel jpnPartners;
    private JLabel jlbParners;
    private JPanel jpnAnalytics;
    private JLabel jlbAnalytics;
    private JPanel jpnSettings;
    private JLabel jlbSettings;
    private JPanel jpnMainMenu;
    private JPanel jpnDropMenu4;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JPanel jpnBuffer2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
