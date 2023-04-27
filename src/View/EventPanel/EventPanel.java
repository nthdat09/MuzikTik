/*
 * Created by JFormDesigner on Tue Apr 25 08:30:00 ICT 2023
 */

package View.EventPanel;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Admin
 */
public class EventPanel extends JPanel {
    public EventPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
        panel1 = new JPanel();
        EventArt = new JLabel();
        EventName = new JLabel();
        EventTime = new JLabel();
        EventPlace = new JLabel();
        jpnInfo = new JPanel();
        jlbInfo = new JLabel();
        jpnTicketFee = new JPanel();
        TicketFeeText = new JLabel();
        SeatPanel = new JPanel();
        jlbSeat = new JLabel();
        jpnBuyNow = new JPanel();
        jlbBuyNow = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setMinimumSize(new Dimension(1268, 355));
        setPreferredSize(new Dimension(1030, 820));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
        . EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax
        . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
        12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans
        . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .
        getPropertyName () )) throw new RuntimeException( ); }} );

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setPreferredSize(new Dimension(1030, 355));

            //---- EventArt ----
            EventArt.setText("event art");
            EventArt.setBackground(new Color(0x33ffcc));
            EventArt.setBorder(LineBorder.createBlackLineBorder());

            //---- EventName ----
            EventName.setText("Event Name");
            EventName.setFont(new Font("Lato Black", Font.BOLD, 30));
            EventName.setForeground(new Color(0x61b884));

            //---- EventTime ----
            EventTime.setText("Event Time");
            EventTime.setFont(new Font("Lato", Font.PLAIN, 18));

            //---- EventPlace ----
            EventPlace.setText("Event Place");
            EventPlace.setFont(new Font("Lato", Font.PLAIN, 18));

            //======== jpnInfo ========
            {
                jpnInfo.setBackground(new Color(0x61b884));
                jpnInfo.setPreferredSize(new Dimension(140, 38));

                //---- jlbInfo ----
                jlbInfo.setText("INFORMATION");
                jlbInfo.setForeground(Color.white);
                jlbInfo.setFont(new Font("Lato Black", Font.BOLD, 16));
                jlbInfo.setHorizontalTextPosition(SwingConstants.RIGHT);
                jlbInfo.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout jpnInfoLayout = new GroupLayout(jpnInfo);
                jpnInfo.setLayout(jpnInfoLayout);
                jpnInfoLayout.setHorizontalGroup(
                    jpnInfoLayout.createParallelGroup()
                        .addGroup(jpnInfoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jlbInfo, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                );
                jpnInfoLayout.setVerticalGroup(
                    jpnInfoLayout.createParallelGroup()
                        .addGroup(jpnInfoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jlbInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }

            //======== jpnTicketFee ========
            {
                jpnTicketFee.setBackground(new Color(0x61b884));
                jpnTicketFee.setPreferredSize(new Dimension(121, 38));

                //---- TicketFeeText ----
                TicketFeeText.setText("TICKET FEES");
                TicketFeeText.setForeground(Color.white);
                TicketFeeText.setFont(new Font("Lato Black", Font.BOLD, 16));
                TicketFeeText.setHorizontalTextPosition(SwingConstants.RIGHT);
                TicketFeeText.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout jpnTicketFeeLayout = new GroupLayout(jpnTicketFee);
                jpnTicketFee.setLayout(jpnTicketFeeLayout);
                jpnTicketFeeLayout.setHorizontalGroup(
                    jpnTicketFeeLayout.createParallelGroup()
                        .addComponent(TicketFeeText, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                );
                jpnTicketFeeLayout.setVerticalGroup(
                    jpnTicketFeeLayout.createParallelGroup()
                        .addComponent(TicketFeeText, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
            }

            //======== SeatPanel ========
            {
                SeatPanel.setBackground(new Color(0x61b884));

                //---- jlbSeat ----
                jlbSeat.setText("SEAT");
                jlbSeat.setForeground(Color.white);
                jlbSeat.setFont(new Font("Lato Black", Font.BOLD, 16));
                jlbSeat.setHorizontalTextPosition(SwingConstants.RIGHT);
                jlbSeat.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout SeatPanelLayout = new GroupLayout(SeatPanel);
                SeatPanel.setLayout(SeatPanelLayout);
                SeatPanelLayout.setHorizontalGroup(
                    SeatPanelLayout.createParallelGroup()
                        .addComponent(jlbSeat, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                );
                SeatPanelLayout.setVerticalGroup(
                    SeatPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, SeatPanelLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jlbSeat, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                );
            }

            //======== jpnBuyNow ========
            {
                jpnBuyNow.setBackground(new Color(0x61b884));
                jpnBuyNow.setPreferredSize(new Dimension(140, 38));

                //---- jlbBuyNow ----
                jlbBuyNow.setText("BUY NOW");
                jlbBuyNow.setForeground(Color.white);
                jlbBuyNow.setFont(new Font("Lato Black", Font.BOLD, 16));
                jlbBuyNow.setHorizontalTextPosition(SwingConstants.RIGHT);
                jlbBuyNow.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout jpnBuyNowLayout = new GroupLayout(jpnBuyNow);
                jpnBuyNow.setLayout(jpnBuyNowLayout);
                jpnBuyNowLayout.setHorizontalGroup(
                    jpnBuyNowLayout.createParallelGroup()
                        .addComponent(jlbBuyNow, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                );
                jpnBuyNowLayout.setVerticalGroup(
                    jpnBuyNowLayout.createParallelGroup()
                        .addComponent(jlbBuyNow, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(EventArt, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(EventName, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(EventTime, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(EventPlace, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jpnBuyNow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jpnInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpnTicketFee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SeatPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(77, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(EventArt, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(EventName, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EventTime, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EventPlace, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpnBuyNow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(jpnInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnTicketFee, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(SeatPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 96, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
    private JPanel panel1;
    private JLabel EventArt;
    private JLabel EventName;
    private JLabel EventTime;
    private JLabel EventPlace;
    private JPanel jpnInfo;
    private JLabel jlbInfo;
    private JPanel jpnTicketFee;
    private JLabel TicketFeeText;
    private JPanel SeatPanel;
    private JLabel jlbSeat;
    private JPanel jpnBuyNow;
    private JLabel jlbBuyNow;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
