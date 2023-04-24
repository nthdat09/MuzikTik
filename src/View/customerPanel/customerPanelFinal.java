/*
 * Created by JFormDesigner on Mon Apr 24 08:33:28 ICT 2023
 */

package View.customerPanel;

import View.mainMenu;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author ADMIN
 */
public class customerPanelFinal extends JPanel {
    public customerPanelFinal() {
        initComponents();

        controllerCustomerPanel controller = new controllerCustomerPanel(jpnView);
        controller.setView(jpnInfor, jlbInfor);

        List<customerList> listItem = new ArrayList<>();
        listItem.add(new customerList("informationCustomer",jpnInfor,jlbInfor));
        listItem.add(new customerList("historyCustomer",jpnHistory,jlbHistoory));
        controller.setEvent(listItem);
    }
    public static void main (String[] args) {
        JFrame frame = new JFrame("Đồ án bán vé hoà nhạc");
        frame.setContentPane(new customerPanelFinal());
        frame.pack();
        frame.setVisible(true);
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void informationButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void historyButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Man
        navigationPanel = new JPanel();
        homeButton = new JButton();
        eventButton = new JButton();
        customerButton = new JButton();
        stageButton = new JButton();
        partnersButton = new JButton();
        analyticsButton = new JButton();
        settingsButton = new JButton();
        headerPanel = new JPanel();
        avatarFrame = new JLabel();
        searchButton = new JTextField();
        nameAppLabell = new JLabel();
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        jpnInfor = new JPanel();
        jlbInfor = new JLabel();
        jpnHistory = new JPanel();
        jlbHistoory = new JLabel();
        jpnLogOut = new JPanel();
        jlbLogOut = new JLabel();
        jpnView = new JPanel();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
        ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
        .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
        propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
        ;} } );

        //======== navigationPanel ========
        {
            navigationPanel.setBorder(LineBorder.createBlackLineBorder());
            navigationPanel.setPreferredSize(new Dimension(226, 1000));

            //---- homeButton ----
            homeButton.setText("HOME");
            homeButton.setBackground(Color.white);

            //---- eventButton ----
            eventButton.setText("EVENT");
            eventButton.setBackground(Color.white);

            //---- customerButton ----
            customerButton.setText("CUSTOMER");
            customerButton.setBackground(Color.white);

            //---- stageButton ----
            stageButton.setText("STAGE");
            stageButton.setBackground(Color.white);

            //---- partnersButton ----
            partnersButton.setText("PARTNERS");
            partnersButton.setBackground(Color.white);

            //---- analyticsButton ----
            analyticsButton.setText("ANALYTICS");
            analyticsButton.setBackground(Color.white);

            //---- settingsButton ----
            settingsButton.setText("SETTINGS");
            settingsButton.setBackground(Color.white);

            GroupLayout navigationPanelLayout = new GroupLayout(navigationPanel);
            navigationPanel.setLayout(navigationPanelLayout);
            navigationPanelLayout.setHorizontalGroup(
                navigationPanelLayout.createParallelGroup()
                    .addComponent(homeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eventButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerButton, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(stageButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(partnersButton, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(analyticsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(settingsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            navigationPanelLayout.setVerticalGroup(
                navigationPanelLayout.createParallelGroup()
                    .addGroup(navigationPanelLayout.createSequentialGroup()
                        .addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eventButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stageButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(partnersButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(analyticsButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(settingsButton, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 341, Short.MAX_VALUE))
            );
        }

        //======== headerPanel ========
        {
            headerPanel.setBorder(LineBorder.createBlackLineBorder());
            headerPanel.setBackground(new Color(0x9fc5f8));

            //---- avatarFrame ----
            avatarFrame.setText("text");
            avatarFrame.setBorder(LineBorder.createBlackLineBorder());

            //---- searchButton ----
            searchButton.setText("Search");

            //---- nameAppLabell ----
            nameAppLabell.setText("H\u1ec7 Th\u1ed1ng Qu\u1ea3n L\u00ed B\u00e1n V\u00e9 Ho\u00e0 Nh\u1ea1c");
            nameAppLabell.setFont(nameAppLabell.getFont().deriveFont(nameAppLabell.getFont().getSize() + 7f));

            GroupLayout headerPanelLayout = new GroupLayout(headerPanel);
            headerPanel.setLayout(headerPanelLayout);
            headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(nameAppLabell, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 743, Short.MAX_VALUE)
                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(avatarFrame, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
            );
            headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup()
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(headerPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(avatarFrame, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(nameAppLabell, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
            );
        }

        //======== panel1 ========
        {

            //---- label1 ----
            label1.setText("My Account");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 20f));
            label1.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label2 ----
            label2.setText("Avatar");
            label2.setBorder(LineBorder.createBlackLineBorder());
            label2.setHorizontalAlignment(SwingConstants.CENTER);

            //======== jpnInfor ========
            {
                jpnInfor.setBorder(LineBorder.createBlackLineBorder());

                //---- jlbInfor ----
                jlbInfor.setText("TH\u00d4NG TIN KH\u00c1CH H\u00c0NG");
                jlbInfor.setFont(jlbInfor.getFont().deriveFont(jlbInfor.getFont().getSize() + 3f));
                jlbInfor.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout jpnInforLayout = new GroupLayout(jpnInfor);
                jpnInfor.setLayout(jpnInforLayout);
                jpnInforLayout.setHorizontalGroup(
                    jpnInforLayout.createParallelGroup()
                        .addComponent(jlbInfor, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                );
                jpnInforLayout.setVerticalGroup(
                    jpnInforLayout.createParallelGroup()
                        .addComponent(jlbInfor, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                );
            }

            //======== jpnHistory ========
            {
                jpnHistory.setBorder(LineBorder.createBlackLineBorder());

                //---- jlbHistoory ----
                jlbHistoory.setText("L\u1ecaCH S\u1eec");
                jlbHistoory.setFont(jlbHistoory.getFont().deriveFont(jlbHistoory.getFont().getSize() + 3f));
                jlbHistoory.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout jpnHistoryLayout = new GroupLayout(jpnHistory);
                jpnHistory.setLayout(jpnHistoryLayout);
                jpnHistoryLayout.setHorizontalGroup(
                    jpnHistoryLayout.createParallelGroup()
                        .addComponent(jlbHistoory, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                );
                jpnHistoryLayout.setVerticalGroup(
                    jpnHistoryLayout.createParallelGroup()
                        .addComponent(jlbHistoory, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                );
            }

            //======== jpnLogOut ========
            {
                jpnLogOut.setBorder(LineBorder.createBlackLineBorder());

                //---- jlbLogOut ----
                jlbLogOut.setText("\u0110\u0102NG XU\u1ea4T");
                jlbLogOut.setFont(jlbLogOut.getFont().deriveFont(jlbLogOut.getFont().getSize() + 3f));
                jlbLogOut.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout jpnLogOutLayout = new GroupLayout(jpnLogOut);
                jpnLogOut.setLayout(jpnLogOutLayout);
                jpnLogOutLayout.setHorizontalGroup(
                    jpnLogOutLayout.createParallelGroup()
                        .addComponent(jlbLogOut, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                );
                jpnLogOutLayout.setVerticalGroup(
                    jpnLogOutLayout.createParallelGroup()
                        .addComponent(jlbLogOut, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(jpnInfor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jpnLogOut, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jpnHistory, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(43, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jpnInfor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpnHistory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpnLogOut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(195, Short.MAX_VALUE))
            );
        }

        //======== jpnView ========
        {

            GroupLayout jpnViewLayout = new GroupLayout(jpnView);
            jpnView.setLayout(jpnViewLayout);
            jpnViewLayout.setHorizontalGroup(
                jpnViewLayout.createParallelGroup()
                    .addGap(0, 994, Short.MAX_VALUE)
            );
            jpnViewLayout.setVerticalGroup(
                jpnViewLayout.createParallelGroup()
                    .addGap(0, 796, Short.MAX_VALUE)
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(navigationPanel, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jpnView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 16, Short.MAX_VALUE))
                        .addComponent(headerPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(navigationPanel, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE))
                            .addGap(6, 6, 6))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jpnView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(22, Short.MAX_VALUE))))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Man
    private JPanel navigationPanel;
    private JButton homeButton;
    private JButton eventButton;
    private JButton customerButton;
    private JButton stageButton;
    private JButton partnersButton;
    private JButton analyticsButton;
    private JButton settingsButton;
    private JPanel headerPanel;
    private JLabel avatarFrame;
    private JTextField searchButton;
    private JLabel nameAppLabell;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JPanel jpnInfor;
    private JLabel jlbInfor;
    private JPanel jpnHistory;
    private JLabel jlbHistoory;
    private JPanel jpnLogOut;
    private JLabel jlbLogOut;
    private JPanel jpnView;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
