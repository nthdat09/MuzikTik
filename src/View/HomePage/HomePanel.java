/*
 * Created by JFormDesigner on Sun Apr 23 10:39:47 ICT 2023
 */

package View.HomePage;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author ADMIN
 */
public class HomePanel extends JFrame {
    public HomePanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
        mainScrollPanel = new JScrollPane();
        panel2 = new JPanel();
        mainLabel = new JLabel();
        mainLivePicture = new JLabel();
        previousButton = new JLabel();
        nextButton = new JLabel();
        eventLabel = new JLabel();
        evetntPicture3 = new JLabel();
        evetntPicture1 = new JLabel();
        evetntPicture2 = new JLabel();
        eventName1 = new JLabel();
        eventName2 = new JLabel();
        eventDate2 = new JLabel();
        eventDate1 = new JLabel();
        eventName3 = new JLabel();
        eventDate3 = new JLabel();
        evetntPicture4 = new JLabel();
        evetntPicture5 = new JLabel();
        evetntPicture6 = new JLabel();
        eventName6 = new JLabel();
        eventDate6 = new JLabel();
        eventDate5 = new JLabel();
        eventName5 = new JLabel();
        eventName4 = new JLabel();
        eventDate4 = new JLabel();
        evetntPicture7 = new JLabel();
        evetntPicture8 = new JLabel();
        evetntPicture9 = new JLabel();
        eventName9 = new JLabel();
        eventDate9 = new JLabel();
        eventDate8 = new JLabel();
        eventName8 = new JLabel();
        eventName7 = new JLabel();
        eventDate7 = new JLabel();

        //======== this ========
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== mainScrollPanel ========
        {

            //======== panel2 ========
            {
                panel2.setBackground(Color.white);
                panel2.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
                0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
                . BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
                red) ,panel2. getBorder( )) ); panel2. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
                beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

                //---- mainLabel ----
                mainLabel.setText("Let Make Live Happen");
                mainLabel.setFont(new Font("Lato Black", Font.BOLD, 30));
                mainLabel.setForeground(new Color(0x61b884));

                //---- mainLivePicture ----
                mainLivePicture.setText("text");
                mainLivePicture.setBorder(LineBorder.createBlackLineBorder());

                //---- previousButton ----
                previousButton.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Arrows-Left-Round-icon.png"));

                //---- nextButton ----
                nextButton.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Arrows-Right-Round-icon.png"));

                //---- eventLabel ----
                eventLabel.setText("HIGHLIGHT EVENT");
                eventLabel.setFont(new Font("Lato Black", Font.BOLD, 28));
                eventLabel.setForeground(new Color(0x61b884));

                //---- evetntPicture3 ----
                evetntPicture3.setText("text");
                evetntPicture3.setBorder(LineBorder.createBlackLineBorder());

                //---- evetntPicture1 ----
                evetntPicture1.setText("text");
                evetntPicture1.setBorder(LineBorder.createBlackLineBorder());

                //---- evetntPicture2 ----
                evetntPicture2.setText("text");
                evetntPicture2.setBorder(LineBorder.createBlackLineBorder());

                //---- eventName1 ----
                eventName1.setText("Event Name");
                eventName1.setFont(new Font("Lato Black", Font.BOLD, 20));
                eventName1.setForeground(new Color(0x61b884));

                //---- eventName2 ----
                eventName2.setText("Event Name");
                eventName2.setFont(new Font("Lato Black", Font.BOLD, 20));
                eventName2.setForeground(new Color(0x61b884));

                //---- eventDate2 ----
                eventDate2.setText("Date");
                eventDate2.setFont(new Font("Lato", Font.PLAIN, 18));
                eventDate2.setForeground(new Color(0x61b884));

                //---- eventDate1 ----
                eventDate1.setText("Date");
                eventDate1.setFont(new Font("Lato", Font.PLAIN, 18));
                eventDate1.setForeground(new Color(0x61b884));

                //---- eventName3 ----
                eventName3.setText("Event Name");
                eventName3.setFont(new Font("Lato Black", Font.BOLD, 20));
                eventName3.setForeground(new Color(0x61b884));

                //---- eventDate3 ----
                eventDate3.setText("Date");
                eventDate3.setFont(new Font("Lato", Font.PLAIN, 18));
                eventDate3.setForeground(new Color(0x61b884));

                //---- evetntPicture4 ----
                evetntPicture4.setText("text");
                evetntPicture4.setBorder(LineBorder.createBlackLineBorder());

                //---- evetntPicture5 ----
                evetntPicture5.setText("text");
                evetntPicture5.setBorder(LineBorder.createBlackLineBorder());

                //---- evetntPicture6 ----
                evetntPicture6.setText("text");
                evetntPicture6.setBorder(LineBorder.createBlackLineBorder());

                //---- eventName6 ----
                eventName6.setText("Event Name");
                eventName6.setFont(eventName6.getFont().deriveFont(eventName6.getFont().getSize() + 7f));

                //---- eventDate6 ----
                eventDate6.setText("Date");
                eventDate6.setFont(eventDate6.getFont().deriveFont(eventDate6.getFont().getSize() + 7f));

                //---- eventDate5 ----
                eventDate5.setText("Date");
                eventDate5.setFont(eventDate5.getFont().deriveFont(eventDate5.getFont().getSize() + 7f));

                //---- eventName5 ----
                eventName5.setText("Event Name");
                eventName5.setFont(eventName5.getFont().deriveFont(eventName5.getFont().getSize() + 7f));

                //---- eventName4 ----
                eventName4.setText("Event Name");
                eventName4.setFont(eventName4.getFont().deriveFont(eventName4.getFont().getSize() + 7f));

                //---- eventDate4 ----
                eventDate4.setText("Date");
                eventDate4.setFont(eventDate4.getFont().deriveFont(eventDate4.getFont().getSize() + 7f));

                //---- evetntPicture7 ----
                evetntPicture7.setText("text");
                evetntPicture7.setBorder(LineBorder.createBlackLineBorder());

                //---- evetntPicture8 ----
                evetntPicture8.setText("text");
                evetntPicture8.setBorder(LineBorder.createBlackLineBorder());

                //---- evetntPicture9 ----
                evetntPicture9.setText("text");
                evetntPicture9.setBorder(LineBorder.createBlackLineBorder());

                //---- eventName9 ----
                eventName9.setText("Event Name");
                eventName9.setFont(eventName9.getFont().deriveFont(eventName9.getFont().getSize() + 7f));

                //---- eventDate9 ----
                eventDate9.setText("Date");
                eventDate9.setFont(eventDate9.getFont().deriveFont(eventDate9.getFont().getSize() + 7f));

                //---- eventDate8 ----
                eventDate8.setText("Date");
                eventDate8.setFont(eventDate8.getFont().deriveFont(eventDate8.getFont().getSize() + 7f));

                //---- eventName8 ----
                eventName8.setText("Event Name");
                eventName8.setFont(eventName8.getFont().deriveFont(eventName8.getFont().getSize() + 7f));

                //---- eventName7 ----
                eventName7.setText("Event Name");
                eventName7.setFont(eventName7.getFont().deriveFont(eventName7.getFont().getSize() + 7f));

                //---- eventDate7 ----
                eventDate7.setText("Date");
                eventDate7.setFont(eventDate7.getFont().deriveFont(eventDate7.getFont().getSize() + 7f));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(434, 434, 434)
                            .addComponent(mainLabel)
                            .addGap(0, 899, Short.MAX_VALUE))
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(164, 164, 164)
                                    .addComponent(eventName1)
                                    .addGap(274, 274, 274)
                                    .addComponent(eventName2)
                                    .addGap(253, 253, 253)
                                    .addComponent(eventName3))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(197, 197, 197)
                                    .addComponent(eventDate1)
                                    .addGap(340, 340, 340)
                                    .addComponent(eventDate2)
                                    .addGap(333, 333, 333)
                                    .addComponent(eventDate3))
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(460, 460, 460)
                                        .addComponent(evetntPicture2, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                        .addGap(104, 104, 104)
                                        .addComponent(evetntPicture3, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(previousButton)
                                        .addGap(62, 62, 62)
                                        .addComponent(mainLivePicture, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addComponent(nextButton)))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(495, 495, 495)
                                    .addComponent(eventLabel))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(91, 91, 91)
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(panel2Layout.createParallelGroup()
                                                .addGroup(panel2Layout.createSequentialGroup()
                                                    .addComponent(evetntPicture7, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(109, 109, 109)
                                                    .addComponent(evetntPicture8, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(104, 104, 104)
                                                    .addComponent(evetntPicture9, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(panel2Layout.createSequentialGroup()
                                                    .addGap(73, 73, 73)
                                                    .addComponent(eventName7)
                                                    .addGap(281, 281, 281)
                                                    .addComponent(eventName8)
                                                    .addGap(266, 266, 266)
                                                    .addComponent(eventName9))
                                                .addGroup(panel2Layout.createSequentialGroup()
                                                    .addGap(106, 106, 106)
                                                    .addComponent(eventDate7)
                                                    .addGap(340, 340, 340)
                                                    .addComponent(eventDate8)
                                                    .addGap(326, 326, 326)
                                                    .addComponent(eventDate9)))
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addComponent(evetntPicture1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                                .addGap(733, 733, 733)))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addComponent(evetntPicture4, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                            .addGap(109, 109, 109)
                                            .addComponent(evetntPicture5, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                            .addGap(104, 104, 104)
                                            .addComponent(evetntPicture6, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(73, 73, 73)
                                            .addComponent(eventName4)
                                            .addGap(281, 281, 281)
                                            .addComponent(eventName5)
                                            .addGap(266, 266, 266)
                                            .addComponent(eventName6))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(106, 106, 106)
                                            .addComponent(eventDate4)
                                            .addGap(340, 340, 340)
                                            .addComponent(eventDate5)
                                            .addGap(326, 326, 326)
                                            .addComponent(eventDate6)))))
                            .addContainerGap(547, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(183, 183, 183)
                                            .addComponent(nextButton))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(33, 33, 33)
                                            .addComponent(mainLabel)
                                            .addGap(38, 38, 38)
                                            .addComponent(mainLivePicture, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                                    .addComponent(eventLabel)
                                    .addGap(42, 42, 42)
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(evetntPicture1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(evetntPicture3, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(evetntPicture2, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(eventName3)
                                            .addGap(18, 18, 18)
                                            .addComponent(eventDate3))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(16, 16, 16)
                                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(eventName1)
                                                .addComponent(eventName2))
                                            .addGap(18, 18, 18)
                                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(eventDate1)
                                                .addComponent(eventDate2))))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(195, 195, 195)
                                    .addComponent(previousButton)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 885, Short.MAX_VALUE)))
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(evetntPicture4, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                .addComponent(evetntPicture5, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                .addComponent(evetntPicture6, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                            .addGap(16, 16, 16)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(eventName4)
                                .addComponent(eventName5)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(eventName6)))
                            .addGap(16, 16, 16)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(eventDate4)
                                .addComponent(eventDate5)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(eventDate6)))
                            .addGap(279, 279, 279)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(evetntPicture7, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                .addComponent(evetntPicture8, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                .addComponent(evetntPicture9, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                            .addGap(16, 16, 16)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(eventName7)
                                .addComponent(eventName8)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(eventName9)))
                            .addGap(16, 16, 16)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(eventDate7)
                                .addComponent(eventDate8)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(eventDate9)))
                            .addGap(50, 50, 50))
                );
            }
            mainScrollPanel.setViewportView(panel2);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(mainScrollPanel, GroupLayout.PREFERRED_SIZE, 1157, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(mainScrollPanel, GroupLayout.DEFAULT_SIZE, 1919, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
    private JScrollPane mainScrollPanel;
    private JPanel panel2;
    private JLabel mainLabel;
    private JLabel mainLivePicture;
    private JLabel previousButton;
    private JLabel nextButton;
    private JLabel eventLabel;
    private JLabel evetntPicture3;
    private JLabel evetntPicture1;
    private JLabel evetntPicture2;
    private JLabel eventName1;
    private JLabel eventName2;
    private JLabel eventDate2;
    private JLabel eventDate1;
    private JLabel eventName3;
    private JLabel eventDate3;
    private JLabel evetntPicture4;
    private JLabel evetntPicture5;
    private JLabel evetntPicture6;
    private JLabel eventName6;
    private JLabel eventDate6;
    private JLabel eventDate5;
    private JLabel eventName5;
    private JLabel eventName4;
    private JLabel eventDate4;
    private JLabel evetntPicture7;
    private JLabel evetntPicture8;
    private JLabel evetntPicture9;
    private JLabel eventName9;
    private JLabel eventDate9;
    private JLabel eventDate8;
    private JLabel eventName8;
    private JLabel eventName7;
    private JLabel eventDate7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
