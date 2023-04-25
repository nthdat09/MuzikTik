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
    }

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
        jpnBuffer.setSize(220,20);
    }
    private void label10MousePressed(MouseEvent e) {
        
    }

    private void label10MouseEntered(MouseEvent e) {
        jpnDropMenu4.setSize(210,245);
    }

    private void jpnDropMenu4MouseEntered(MouseEvent e) {
        jpnDropMenu4.setSize(210,245);
    }

    private void jpnDropMenu4MouseExited(MouseEvent e) {
        jpnDropMenu4.setSize(0,0);
        jpnBuffer.setSize(0,0);
    }

    private void jpnBufferMouseEntered(MouseEvent e) {
        jpnDropMenu4.setSize(210,245);
    }

    private void jpnBufferMouseExited(MouseEvent e) {
        jpnDropMenu4.setSize(0,0);
        jpnBuffer.setSize(0,0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Man
        headerPanel = new JPanel();
        searchButton = new JTextField();
        nameAppLabell = new JLabel();
        label10 = new JLabel();
        jpnBuffer = new JPanel();
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

        //======== this ========
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== headerPanel ========
        {
            headerPanel.setBorder(null);
            headerPanel.setBorder(new CompoundBorder(new TitledBorder(new EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", TitledBorder.CENTER, TitledBorder.BOTTOM,new Font("Dialo\u0067"
            , Font.BOLD,12), Color.red),headerPanel. getBorder
            ()));headerPanel. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
            .beans.PropertyChangeEvent e){if("borde\u0072".equals(e.getPropertyName()))throw new RuntimeException
            ();}});
            headerPanel.setLayout(null);

            //---- searchButton ----
            searchButton.setText("Search");
            searchButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    searchButtonMouseEntered(e);
                }
            });
            headerPanel.add(searchButton);
            searchButton.setBounds(700, 15, 461, searchButton.getPreferredSize().height);

            //---- nameAppLabell ----
            nameAppLabell.setText("H\u1ec7 Th\u1ed1ng Qu\u1ea3n L\u00ed B\u00e1n V\u00e9 Ho\u00e0 Nh\u1ea1c");
            nameAppLabell.setFont(nameAppLabell.getFont().deriveFont(nameAppLabell.getFont().getSize() + 7f));
            headerPanel.add(nameAppLabell);
            nameAppLabell.setBounds(40, 25, 355, 30);

            //---- label10 ----
            label10.setText("MENU");
            label10.setHorizontalAlignment(SwingConstants.CENTER);
            label10.setBorder(LineBorder.createBlackLineBorder());
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
                        .addGap(0, 20, Short.MAX_VALUE)
                );
            }
            headerPanel.add(jpnBuffer);
            jpnBuffer.setBounds(1180, 55, 220, 0);

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

                //---- jlbHome ----
                jlbHome.setText("HOME");
                jlbHome.setHorizontalAlignment(SwingConstants.CENTER);
                jlbHome.setBorder(LineBorder.createBlackLineBorder());
                jlbHome.setPreferredSize(new Dimension(225, 65));

                GroupLayout jpnHomeLayout = new GroupLayout(jpnHome);
                jpnHome.setLayout(jpnHomeLayout);
                jpnHomeLayout.setHorizontalGroup(
                    jpnHomeLayout.createParallelGroup()
                        .addComponent(jlbHome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jpnHomeLayout.setVerticalGroup(
                    jpnHomeLayout.createParallelGroup()
                        .addComponent(jlbHome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
            }

            //======== jpnEvent ========
            {
                jpnEvent.setPreferredSize(new Dimension(225, 65));

                //---- jlbEvent ----
                jlbEvent.setText("EVENT");
                jlbEvent.setHorizontalAlignment(SwingConstants.CENTER);
                jlbEvent.setBorder(LineBorder.createBlackLineBorder());
                jlbEvent.setPreferredSize(new Dimension(225, 65));

                GroupLayout jpnEventLayout = new GroupLayout(jpnEvent);
                jpnEvent.setLayout(jpnEventLayout);
                jpnEventLayout.setHorizontalGroup(
                    jpnEventLayout.createParallelGroup()
                        .addComponent(jlbEvent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jpnEventLayout.setVerticalGroup(
                    jpnEventLayout.createParallelGroup()
                        .addComponent(jlbEvent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
            }

            //======== jpnCustomers ========
            {
                jpnCustomers.setPreferredSize(new Dimension(225, 65));

                //---- jlbCustomer ----
                jlbCustomer.setText("CUSTOMERS");
                jlbCustomer.setHorizontalAlignment(SwingConstants.CENTER);
                jlbCustomer.setBorder(LineBorder.createBlackLineBorder());
                jlbCustomer.setPreferredSize(new Dimension(225, 65));

                GroupLayout jpnCustomersLayout = new GroupLayout(jpnCustomers);
                jpnCustomers.setLayout(jpnCustomersLayout);
                jpnCustomersLayout.setHorizontalGroup(
                    jpnCustomersLayout.createParallelGroup()
                        .addComponent(jlbCustomer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jpnCustomersLayout.setVerticalGroup(
                    jpnCustomersLayout.createParallelGroup()
                        .addComponent(jlbCustomer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
            }

            //======== jpnTickets ========
            {
                jpnTickets.setPreferredSize(new Dimension(225, 65));

                //---- jlbTickets ----
                jlbTickets.setText("TICKETS");
                jlbTickets.setHorizontalAlignment(SwingConstants.CENTER);
                jlbTickets.setBorder(LineBorder.createBlackLineBorder());
                jlbTickets.setPreferredSize(new Dimension(225, 65));

                GroupLayout jpnTicketsLayout = new GroupLayout(jpnTickets);
                jpnTickets.setLayout(jpnTicketsLayout);
                jpnTicketsLayout.setHorizontalGroup(
                    jpnTicketsLayout.createParallelGroup()
                        .addComponent(jlbTickets, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jpnTicketsLayout.setVerticalGroup(
                    jpnTicketsLayout.createParallelGroup()
                        .addComponent(jlbTickets, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
            }

            //======== jpnStages ========
            {
                jpnStages.setPreferredSize(new Dimension(225, 65));

                //---- jlbStages ----
                jlbStages.setText("STAGES");
                jlbStages.setHorizontalAlignment(SwingConstants.CENTER);
                jlbStages.setBorder(LineBorder.createBlackLineBorder());
                jlbStages.setPreferredSize(new Dimension(225, 65));

                GroupLayout jpnStagesLayout = new GroupLayout(jpnStages);
                jpnStages.setLayout(jpnStagesLayout);
                jpnStagesLayout.setHorizontalGroup(
                    jpnStagesLayout.createParallelGroup()
                        .addComponent(jlbStages, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jpnStagesLayout.setVerticalGroup(
                    jpnStagesLayout.createParallelGroup()
                        .addComponent(jlbStages, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
            }

            //======== jpnPartners ========
            {
                jpnPartners.setPreferredSize(new Dimension(225, 65));

                //---- jlbParners ----
                jlbParners.setText("PARTNERS");
                jlbParners.setHorizontalAlignment(SwingConstants.CENTER);
                jlbParners.setBorder(LineBorder.createBlackLineBorder());
                jlbParners.setPreferredSize(new Dimension(225, 65));

                GroupLayout jpnPartnersLayout = new GroupLayout(jpnPartners);
                jpnPartners.setLayout(jpnPartnersLayout);
                jpnPartnersLayout.setHorizontalGroup(
                    jpnPartnersLayout.createParallelGroup()
                        .addComponent(jlbParners, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jpnPartnersLayout.setVerticalGroup(
                    jpnPartnersLayout.createParallelGroup()
                        .addComponent(jlbParners, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
            }

            //======== jpnAnalytics ========
            {
                jpnAnalytics.setPreferredSize(new Dimension(225, 65));

                //---- jlbAnalytics ----
                jlbAnalytics.setText("ANALYTICS");
                jlbAnalytics.setHorizontalAlignment(SwingConstants.CENTER);
                jlbAnalytics.setBorder(LineBorder.createBlackLineBorder());
                jlbAnalytics.setPreferredSize(new Dimension(225, 65));

                GroupLayout jpnAnalyticsLayout = new GroupLayout(jpnAnalytics);
                jpnAnalytics.setLayout(jpnAnalyticsLayout);
                jpnAnalyticsLayout.setHorizontalGroup(
                    jpnAnalyticsLayout.createParallelGroup()
                        .addComponent(jlbAnalytics, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jpnAnalyticsLayout.setVerticalGroup(
                    jpnAnalyticsLayout.createParallelGroup()
                        .addComponent(jlbAnalytics, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
            }

            //======== jpnSettings ========
            {
                jpnSettings.setPreferredSize(new Dimension(225, 65));

                //---- jlbSettings ----
                jlbSettings.setText("SETTINGS");
                jlbSettings.setHorizontalAlignment(SwingConstants.CENTER);
                jlbSettings.setBorder(LineBorder.createBlackLineBorder());
                jlbSettings.setPreferredSize(new Dimension(225, 65));

                GroupLayout jpnSettingsLayout = new GroupLayout(jpnSettings);
                jpnSettings.setLayout(jpnSettingsLayout);
                jpnSettingsLayout.setHorizontalGroup(
                    jpnSettingsLayout.createParallelGroup()
                        .addComponent(jlbSettings, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jpnSettingsLayout.setVerticalGroup(
                    jpnSettingsLayout.createParallelGroup()
                        .addComponent(jlbSettings, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
            }

            GroupLayout navigationPanelLayout = new GroupLayout(navigationPanel);
            navigationPanel.setLayout(navigationPanelLayout);
            navigationPanelLayout.setHorizontalGroup(
                navigationPanelLayout.createParallelGroup()
                    .addComponent(jpnHome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, navigationPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(navigationPanelLayout.createParallelGroup()
                            .addComponent(jpnEvent, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnCustomers, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnTickets, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnStages, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnPartners, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnAnalytics, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnSettings, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            );
            navigationPanelLayout.setVerticalGroup(
                navigationPanelLayout.createParallelGroup()
                    .addGroup(navigationPanelLayout.createSequentialGroup()
                        .addComponent(jpnHome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnEvent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnCustomers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnTickets, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnStages, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnPartners, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnAnalytics, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnSettings, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
            );
        }
        contentPane.add(navigationPanel);
        navigationPanel.setBounds(0, 75, navigationPanel.getPreferredSize().width, 699);

        //======== jpnMainMenu ========
        {
            jpnMainMenu.setBorder(null);
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

                //---- label13 ----
                label13.setText("*ID");

                //---- label14 ----
                label14.setText("*\u0111\u0103ng xu\u1ea5t");

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
        jpnMainMenu.setBounds(230, 75, 1171, 693);

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
    
    public static void main (String[] args) {
        JFrame frame = new JFrame("Đồ án bán vé hoà nhạc");
        frame.setContentPane(new Main());
        frame.pack();
        frame.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Man
    private JPanel headerPanel;
    private JTextField searchButton;
    private JLabel nameAppLabell;
    private JLabel label10;
    private JPanel jpnBuffer;
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
