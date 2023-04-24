/*
 * Created by JFormDesigner on Mon Apr 24 09:43:14 ICT 2023
 */

package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Admin
 */
public class eventInformationPanel extends JPanel {
    public eventInformationPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
        headerPanel = new JPanel();
        avatarFrame = new JLabel();
        searchButton = new JTextField();
        nameAppLabell = new JLabel();
        navigationPanel = new JPanel();
        homeButton = new JButton();
        eventButton = new JButton();
        customerButton = new JButton();
        stageButton = new JButton();
        partnersButton = new JButton();
        analyticsButton = new JButton();
        settingsButton = new JButton();
        eventartLabel = new JLabel();
        eventnameLabel = new JLabel();
        timeLabel = new JLabel();
        placeLabel = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setBorder(null);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );

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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 589, Short.MAX_VALUE)
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

        //======== navigationPanel ========
        {
            navigationPanel.setBorder(LineBorder.createBlackLineBorder());

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
                    .addComponent(homeButton, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(eventButton, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(customerButton, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(stageButton, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(partnersButton, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(analyticsButton, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(settingsButton, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
            );
            navigationPanelLayout.setVerticalGroup(
                navigationPanelLayout.createParallelGroup()
                    .addGroup(navigationPanelLayout.createSequentialGroup()
                        .addComponent(homeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGap(1394, 1394, 1394))
            );
        }

        //---- eventartLabel ----
        eventartLabel.setText("event art");
        eventartLabel.setBackground(Color.white);
        eventartLabel.setBorder(new LineBorder(Color.black, 2, true));

        //---- eventnameLabel ----
        eventnameLabel.setText("Event name ");
        eventnameLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));

        //---- timeLabel ----
        timeLabel.setText("Time");
        timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- placeLabel ----
        placeLabel.setText("Place");
        placeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- button1 ----
        button1.setText("BUY NOW");

        //---- button2 ----
        button2.setText("Information");

        //---- button3 ----
        button3.setText("Ticket fees");

        //---- button4 ----
        button4.setText("Seat/Stage");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(headerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(navigationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(63, 63, 63)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(eventartLabel, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(eventnameLabel, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(placeLabel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(435, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 431, Short.MAX_VALUE)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                    .addGap(80, 80, 80))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 676, Short.MAX_VALUE))
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(navigationPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(eventartLabel, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(eventnameLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(placeLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addComponent(button1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(button2, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                    .addComponent(button3, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                                .addComponent(button4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 1140, Short.MAX_VALUE))))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
    private JPanel headerPanel;
    private JLabel avatarFrame;
    private JTextField searchButton;
    private JLabel nameAppLabell;
    private JPanel navigationPanel;
    private JButton homeButton;
    private JButton eventButton;
    private JButton customerButton;
    private JButton stageButton;
    private JButton partnersButton;
    private JButton analyticsButton;
    private JButton settingsButton;
    private JLabel eventartLabel;
    private JLabel eventnameLabel;
    private JLabel timeLabel;
    private JLabel placeLabel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
