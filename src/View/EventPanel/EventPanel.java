/*
 * Created by JFormDesigner on Tue Apr 25 08:30:00 ICT 2023
 */

package View.EventPanel;

import java.awt.event.*;
import View.MainPage.Main;

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
        selectedTab(0);
    }
    Border border = BorderFactory.createLineBorder(Color.decode("#61b884"),1);

    private void jlbInfoMouseClicked(MouseEvent e) {
        jtbTabEvent.setSelectedIndex(0);
        selectedTab(0);
    }

    private void TicketFeeTextMouseClicked(MouseEvent e) {
        jtbTabEvent.setSelectedIndex(1);
        selectedTab(1);
    }

    private void jlbSeatMouseClicked(MouseEvent e) {
        jtbTabEvent.setSelectedIndex(2);
        selectedTab(2);
    }

    private void jlbInfoMouseEntered(MouseEvent e) {

    }

    private void jlbInfoMouseExited(MouseEvent e) {

    }

    private void jpnTicketFeeMouseClicked(MouseEvent e) {
        jtbTabEvent.setSelectedIndex(1);
        selectedTab(1);
    }

    private void jpnTicketFeeMouseEntered(MouseEvent e) {

    }

    private void TicketFeeTextMouseEntered(MouseEvent e) {

    }

    private void TicketFeeTextMouseExited(MouseEvent e) {

    }

    private void jlbSeatMouseEntered(MouseEvent e) {

    }

    private void jlbSeatMouseExited(MouseEvent e) {

    }

    private void jpnInfoMouseClicked(MouseEvent e) {
        jtbTabEvent.setSelectedIndex(0);
        selectedTab(0);
    }

    private void SeatPanelMouseClicked(MouseEvent e) {
        jtbTabEvent.setSelectedIndex(2);
        selectedTab(2);
    }

    public void selectedTab(int indexSelected) {
        switch(indexSelected) {
        case 0:
            jpnInfo.setBackground(Color.WHITE);
            jpnInfo.setBorder(border);
            jlbInfo.setForeground(Color.decode("#61b884"));
            //
            jpnTicketFee.setBackground(Color.decode("#61b884"));
            TicketFeeText.setForeground(Color.WHITE);
            //
            SeatPanel.setBackground(Color.decode("#61b884"));
            jlbSeat.setForeground(Color.WHITE);
            break;
        case 1:
            jpnInfo.setBackground(Color.decode("#61b884"));
            jlbInfo.setForeground(Color.WHITE);
            //
            jpnTicketFee.setBackground(Color.WHITE);
            jpnTicketFee.setBorder(border);
            TicketFeeText.setForeground(Color.decode("#61b884"));
            //
            SeatPanel.setBackground(Color.decode("#61b884"));
            jlbSeat.setForeground(Color.WHITE);
            break;
        case 2:
            jpnInfo.setBackground(Color.decode("#61b884"));
            jlbInfo.setForeground(Color.WHITE);
            //
            jpnTicketFee.setBackground(Color.decode("#61b884"));
            TicketFeeText.setForeground(Color.WHITE);
            //
            SeatPanel.setBackground(Color.WHITE);
            SeatPanel.setBorder(border);
            jlbSeat.setForeground(Color.decode("#61b884"));
            break;
        }
    }

    private void jlbBuyNowMouseClicked(MouseEvent e) {
        jpnInfo.setVisible(false);
        jpnTicketFee.setVisible(false);
        SeatPanel.setVisible(false);
        jpnBuyNow.setVisible(false);

        jtbTabEvent.setSelectedIndex(3);
    }

    private void jpnBuyNowMouseClicked(MouseEvent e) {
        jpnInfo.setVisible(false);
        jpnTicketFee.setVisible(false);
        SeatPanel.setVisible(false);
        jpnBuyNow.setVisible(false);

        jtbTabEvent.setSelectedIndex(3);
    }

    private void jlbNextButtonMouseClicked(MouseEvent e) {
        jtbTabEvent.setSelectedIndex(4);
    }

    private void jpnNextButtonMouseClicked(MouseEvent e) {

    }

    private void jpnBackMouseClicked(MouseEvent e) {
        jpnInfo.setVisible(true);
        jpnTicketFee.setVisible(true);
        SeatPanel.setVisible(true);
        jpnBuyNow.setVisible(true);

        jtbTabEvent.setSelectedIndex(0);
    }

    private void jlbBackMouseClicked(MouseEvent e) {
        jpnInfo.setVisible(true);
        jpnTicketFee.setVisible(true);
        SeatPanel.setVisible(true);
        jpnBuyNow.setVisible(true);

        jtbTabEvent.setSelectedIndex(0);
    }

    private void checkBox1(ActionEvent e) {
        isCheckSelected(1);
    }

    private void isCheckSelected(int index) {
        if(index == 1) {
            checkBox2.setSelected(false);
            checkBox3.setSelected(false);
        } else if (index == 2) {
            checkBox1.setSelected(false);
            checkBox3.setSelected(false);
        } else {
            checkBox1.setSelected(false);
            checkBox2.setSelected(false);
        }
    }

    private void checkBox2(ActionEvent e) {
        isCheckSelected(2);
    }

    private void checkBox3(ActionEvent e) {
        isCheckSelected(3);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Man
        jpnEventHeader = new JPanel();
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
        jtbTabEvent = new JTabbedPane();
        jpnEventInformation = new JPanel();
        scrollPane1 = new JScrollPane();
        InformationPanel = new JPanel();
        EventName2 = new JLabel();
        DescriptionText = new JLabel();
        button1 = new JButton();
        jpnEventTicket = new JPanel();
        TicketFee = new JPanel();
        Scroll = new JScrollPane();
        TicketFeeTable = new JTable();
        label1 = new JLabel();
        SeatEvent = new JPanel();
        label2 = new JLabel();
        jlbSeatingChart = new JLabel();
        jpnPickTicket = new JPanel();
        scrollPane3 = new JScrollPane();
        table3 = new JTable();
        jpnNextButton = new JPanel();
        jlbNextButton = new JLabel();
        table1 = new JTable();
        jpnPayment = new JPanel();
        JlbInforCus = new JLabel();
        scrollPane4 = new JScrollPane();
        table4 = new JTable();
        jlbPayment = new JLabel();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        table6 = new JTable();
        table7 = new JTable();
        jpnBack = new JPanel();
        jlbBack = new JLabel();
        jpnNext = new JPanel();
        jlbNext = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setMinimumSize(new Dimension(1268, 355));
        setPreferredSize(new Dimension(1030, 820));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
        . swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing
        . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
        Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );
        setLayout(null);

        //======== jpnEventHeader ========
        {
            jpnEventHeader.setBackground(Color.white);
            jpnEventHeader.setPreferredSize(new Dimension(1030, 355));

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
                jpnInfo.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jpnInfoMouseClicked(e);
                    }
                });

                //---- jlbInfo ----
                jlbInfo.setText("INFORMATION");
                jlbInfo.setForeground(Color.white);
                jlbInfo.setFont(new Font("Lato Black", Font.BOLD, 16));
                jlbInfo.setHorizontalTextPosition(SwingConstants.RIGHT);
                jlbInfo.setHorizontalAlignment(SwingConstants.CENTER);
                jlbInfo.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jlbInfoMouseClicked(e);
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jlbInfoMouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        jlbInfoMouseExited(e);
                    }
                });

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
                jpnTicketFee.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jpnTicketFeeMouseClicked(e);
                        jpnTicketFeeMouseClicked(e);
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jpnTicketFeeMouseEntered(e);
                    }
                });

                //---- TicketFeeText ----
                TicketFeeText.setText("TICKET FEES");
                TicketFeeText.setForeground(Color.white);
                TicketFeeText.setFont(new Font("Lato Black", Font.BOLD, 16));
                TicketFeeText.setHorizontalTextPosition(SwingConstants.RIGHT);
                TicketFeeText.setHorizontalAlignment(SwingConstants.CENTER);
                TicketFeeText.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        TicketFeeTextMouseClicked(e);
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        TicketFeeTextMouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        TicketFeeTextMouseExited(e);
                    }
                });

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
                SeatPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        SeatPanelMouseClicked(e);
                    }
                });

                //---- jlbSeat ----
                jlbSeat.setText("SEAT");
                jlbSeat.setForeground(Color.white);
                jlbSeat.setFont(new Font("Lato Black", Font.BOLD, 16));
                jlbSeat.setHorizontalTextPosition(SwingConstants.RIGHT);
                jlbSeat.setHorizontalAlignment(SwingConstants.CENTER);
                jlbSeat.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jlbSeatMouseClicked(e);
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jlbSeatMouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        jlbSeatMouseExited(e);
                    }
                });

                GroupLayout SeatPanelLayout = new GroupLayout(SeatPanel);
                SeatPanel.setLayout(SeatPanelLayout);
                SeatPanelLayout.setHorizontalGroup(
                    SeatPanelLayout.createParallelGroup()
                        .addComponent(jlbSeat, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                );
                SeatPanelLayout.setVerticalGroup(
                    SeatPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, SeatPanelLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jlbSeat, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
                );
            }

            //======== jpnBuyNow ========
            {
                jpnBuyNow.setBackground(new Color(0x61b884));
                jpnBuyNow.setPreferredSize(new Dimension(140, 38));
                jpnBuyNow.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jpnBuyNowMouseClicked(e);
                    }
                });

                //---- jlbBuyNow ----
                jlbBuyNow.setText("BUY NOW");
                jlbBuyNow.setForeground(Color.white);
                jlbBuyNow.setFont(new Font("Lato Black", Font.BOLD, 16));
                jlbBuyNow.setHorizontalTextPosition(SwingConstants.RIGHT);
                jlbBuyNow.setHorizontalAlignment(SwingConstants.CENTER);
                jlbBuyNow.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jlbBuyNowMouseClicked(e);
                    }
                });

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

            GroupLayout jpnEventHeaderLayout = new GroupLayout(jpnEventHeader);
            jpnEventHeader.setLayout(jpnEventHeaderLayout);
            jpnEventHeaderLayout.setHorizontalGroup(
                jpnEventHeaderLayout.createParallelGroup()
                    .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jpnEventHeaderLayout.createParallelGroup()
                            .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                                .addComponent(EventArt, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpnEventHeaderLayout.createParallelGroup()
                                    .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(jpnEventHeaderLayout.createParallelGroup()
                                            .addComponent(EventName, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(EventTime, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(EventPlace, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(GroupLayout.Alignment.TRAILING, jpnEventHeaderLayout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jpnBuyNow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                                .addComponent(jpnInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpnTicketFee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SeatPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(89, Short.MAX_VALUE))
            );
            jpnEventHeaderLayout.setVerticalGroup(
                jpnEventHeaderLayout.createParallelGroup()
                    .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jpnEventHeaderLayout.createParallelGroup()
                            .addComponent(EventArt, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                                .addComponent(EventName, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EventTime, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EventPlace, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpnBuyNow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addGroup(jpnEventHeaderLayout.createParallelGroup()
                            .addComponent(jpnInfo, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(jpnTicketFee, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(SeatPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            );
        }
        add(jpnEventHeader);
        jpnEventHeader.setBounds(0, 0, 1030, 385);

        //======== jtbTabEvent ========
        {

            //======== jpnEventInformation ========
            {

                //======== scrollPane1 ========
                {
                    scrollPane1.setPreferredSize(new Dimension(1020, 10021));

                    //======== InformationPanel ========
                    {
                        InformationPanel.setBackground(Color.white);

                        //---- EventName2 ----
                        EventName2.setText("Event Name");
                        EventName2.setFont(new Font("Lato Black", Font.BOLD, 30));
                        EventName2.setForeground(new Color(0x61b884));
                        EventName2.setHorizontalAlignment(SwingConstants.LEFT);

                        //---- DescriptionText ----
                        DescriptionText.setText("Description Event");
                        DescriptionText.setVerticalAlignment(SwingConstants.TOP);
                        DescriptionText.setFont(new Font("Lato", Font.PLAIN, 14));

                        //---- button1 ----
                        button1.setText("EDIT");
                        button1.setForeground(Color.white);
                        button1.setBackground(new Color(0x61b884));
                        button1.setFont(new Font("Lato Black", Font.BOLD, 14));

                        GroupLayout InformationPanelLayout = new GroupLayout(InformationPanel);
                        InformationPanel.setLayout(InformationPanelLayout);
                        InformationPanelLayout.setHorizontalGroup(
                            InformationPanelLayout.createParallelGroup()
                                .addGroup(InformationPanelLayout.createSequentialGroup()
                                    .addGap(59, 59, 59)
                                    .addGroup(InformationPanelLayout.createParallelGroup()
                                        .addComponent(DescriptionText, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(InformationPanelLayout.createSequentialGroup()
                                            .addComponent(EventName2, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                            .addGap(610, 610, 610)
                                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(59, Short.MAX_VALUE))
                        );
                        InformationPanelLayout.setVerticalGroup(
                            InformationPanelLayout.createParallelGroup()
                                .addGroup(InformationPanelLayout.createSequentialGroup()
                                    .addGroup(InformationPanelLayout.createParallelGroup()
                                        .addGroup(InformationPanelLayout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(InformationPanelLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(EventName2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                    .addComponent(DescriptionText, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
                        );
                    }
                    scrollPane1.setViewportView(InformationPanel);
                }

                GroupLayout jpnEventInformationLayout = new GroupLayout(jpnEventInformation);
                jpnEventInformation.setLayout(jpnEventInformationLayout);
                jpnEventInformationLayout.setHorizontalGroup(
                    jpnEventInformationLayout.createParallelGroup()
                        .addGroup(jpnEventInformationLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jpnEventInformationLayout.setVerticalGroup(
                    jpnEventInformationLayout.createParallelGroup()
                        .addGroup(jpnEventInformationLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 7, Short.MAX_VALUE))
                );
            }
            jtbTabEvent.addTab("text", jpnEventInformation);

            //======== jpnEventTicket ========
            {

                //======== TicketFee ========
                {
                    TicketFee.setBackground(Color.white);
                    TicketFee.setFont(new Font("Lato Black", Font.BOLD, 18));

                    //======== Scroll ========
                    {

                        //---- TicketFeeTable ----
                        TicketFeeTable.setBorder(LineBorder.createBlackLineBorder());
                        Scroll.setViewportView(TicketFeeTable);
                    }

                    //---- label1 ----
                    label1.setText("TICKET");
                    label1.setForeground(new Color(0x61b884));
                    label1.setFont(new Font("Lato Black", Font.BOLD, 22));
                    label1.setHorizontalAlignment(SwingConstants.LEFT);

                    GroupLayout TicketFeeLayout = new GroupLayout(TicketFee);
                    TicketFee.setLayout(TicketFeeLayout);
                    TicketFeeLayout.setHorizontalGroup(
                        TicketFeeLayout.createParallelGroup()
                            .addGroup(TicketFeeLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(TicketFeeLayout.createParallelGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Scroll, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(465, Short.MAX_VALUE))
                    );
                    TicketFeeLayout.setVerticalGroup(
                        TicketFeeLayout.createParallelGroup()
                            .addGroup(TicketFeeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Scroll, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                                .addGap(132, 132, 132))
                    );
                }

                GroupLayout jpnEventTicketLayout = new GroupLayout(jpnEventTicket);
                jpnEventTicket.setLayout(jpnEventTicketLayout);
                jpnEventTicketLayout.setHorizontalGroup(
                    jpnEventTicketLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, jpnEventTicketLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(TicketFee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
                jpnEventTicketLayout.setVerticalGroup(
                    jpnEventTicketLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, jpnEventTicketLayout.createSequentialGroup()
                            .addGap(0, 8, Short.MAX_VALUE)
                            .addComponent(TicketFee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
            }
            jtbTabEvent.addTab("text", jpnEventTicket);

            //======== SeatEvent ========
            {
                SeatEvent.setBorder(null);

                //---- label2 ----
                label2.setText("\u1ea2nh s\u01a1 \u0111\u1ed3 gh\u1ebf");
                label2.setBorder(LineBorder.createBlackLineBorder());

                //---- jlbSeatingChart ----
                jlbSeatingChart.setText("SEATING CHART");
                jlbSeatingChart.setForeground(new Color(0x61b884));
                jlbSeatingChart.setFont(new Font("Lato Black", Font.BOLD, 22));
                jlbSeatingChart.setHorizontalAlignment(SwingConstants.LEFT);

                GroupLayout SeatEventLayout = new GroupLayout(SeatEvent);
                SeatEvent.setLayout(SeatEventLayout);
                SeatEventLayout.setHorizontalGroup(
                    SeatEventLayout.createParallelGroup()
                        .addGroup(SeatEventLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jlbSeatingChart, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(800, Short.MAX_VALUE))
                );
                SeatEventLayout.setVerticalGroup(
                    SeatEventLayout.createParallelGroup()
                        .addGroup(SeatEventLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jlbSeatingChart, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(505, Short.MAX_VALUE))
                );
            }
            jtbTabEvent.addTab("text", SeatEvent);

            //======== jpnPickTicket ========
            {

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(table3);
                }

                //======== jpnNextButton ========
                {
                    jpnNextButton.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            jpnNextButtonMouseClicked(e);
                        }
                    });

                    //---- jlbNextButton ----
                    jlbNextButton.setText("NEXT");
                    jlbNextButton.setHorizontalAlignment(SwingConstants.CENTER);
                    jlbNextButton.setBorder(LineBorder.createBlackLineBorder());
                    jlbNextButton.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            jlbNextButtonMouseClicked(e);
                        }
                    });

                    GroupLayout jpnNextButtonLayout = new GroupLayout(jpnNextButton);
                    jpnNextButton.setLayout(jpnNextButtonLayout);
                    jpnNextButtonLayout.setHorizontalGroup(
                        jpnNextButtonLayout.createParallelGroup()
                            .addGroup(jpnNextButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlbNextButton, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                    jpnNextButtonLayout.setVerticalGroup(
                        jpnNextButtonLayout.createParallelGroup()
                            .addGroup(jpnNextButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlbNextButton, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }

                GroupLayout jpnPickTicketLayout = new GroupLayout(jpnPickTicket);
                jpnPickTicket.setLayout(jpnPickTicketLayout);
                jpnPickTicketLayout.setHorizontalGroup(
                    jpnPickTicketLayout.createParallelGroup()
                        .addGroup(jpnPickTicketLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(table1, GroupLayout.PREFERRED_SIZE, 642, GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53)
                            .addGroup(jpnPickTicketLayout.createParallelGroup()
                                .addComponent(jpnNextButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                            .addContainerGap(22, Short.MAX_VALUE))
                );
                jpnPickTicketLayout.setVerticalGroup(
                    jpnPickTicketLayout.createParallelGroup()
                        .addGroup(jpnPickTicketLayout.createSequentialGroup()
                            .addGroup(jpnPickTicketLayout.createParallelGroup()
                                .addGroup(jpnPickTicketLayout.createSequentialGroup()
                                    .addGap(74, 74, 74)
                                    .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                    .addGap(74, 74, 74)
                                    .addComponent(jpnNextButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpnPickTicketLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(table1, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(128, Short.MAX_VALUE))
                );
            }
            jtbTabEvent.addTab("text", jpnPickTicket);

            //======== jpnPayment ========
            {

                //---- JlbInforCus ----
                JlbInforCus.setText("Th\u00f4ng Tin Ng\u01b0\u1eddi Nh\u1eadn V\u00e9");

                //======== scrollPane4 ========
                {
                    scrollPane4.setViewportView(table4);
                }

                //---- jlbPayment ----
                jlbPayment.setText("H\u00ecnh Th\u1ee9c Thanh To\u00e1n");

                //---- checkBox1 ----
                checkBox1.setText("Th\u1ebb t\u00edn d\u1ee5ng");
                checkBox1.addActionListener(e -> {
			checkBox1(e);
			checkBox1(e);
		});

                //---- checkBox2 ----
                checkBox2.setText("S\u1eed d\u1ee5ng Internet Banking");
                checkBox2.addActionListener(e -> checkBox2(e));

                //---- checkBox3 ----
                checkBox3.setText("Thanh to\u00e1n tr\u1ef1c tuy\u1ebfn MoMo");
                checkBox3.addActionListener(e -> checkBox3(e));

                //======== jpnBack ========
                {
                    jpnBack.setBorder(LineBorder.createBlackLineBorder());
                    jpnBack.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            jpnBackMouseClicked(e);
                        }
                    });

                    //---- jlbBack ----
                    jlbBack.setText("BACK");
                    jlbBack.setHorizontalAlignment(SwingConstants.CENTER);
                    jlbBack.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            jlbBackMouseClicked(e);
                        }
                    });

                    GroupLayout jpnBackLayout = new GroupLayout(jpnBack);
                    jpnBack.setLayout(jpnBackLayout);
                    jpnBackLayout.setHorizontalGroup(
                        jpnBackLayout.createParallelGroup()
                            .addComponent(jlbBack, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    );
                    jpnBackLayout.setVerticalGroup(
                        jpnBackLayout.createParallelGroup()
                            .addComponent(jlbBack, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    );
                }

                //======== jpnNext ========
                {
                    jpnNext.setBorder(LineBorder.createBlackLineBorder());

                    //---- jlbNext ----
                    jlbNext.setText("NEXT");
                    jlbNext.setHorizontalAlignment(SwingConstants.CENTER);

                    GroupLayout jpnNextLayout = new GroupLayout(jpnNext);
                    jpnNext.setLayout(jpnNextLayout);
                    jpnNextLayout.setHorizontalGroup(
                        jpnNextLayout.createParallelGroup()
                            .addComponent(jlbNext, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    );
                    jpnNextLayout.setVerticalGroup(
                        jpnNextLayout.createParallelGroup()
                            .addComponent(jlbNext, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    );
                }

                GroupLayout jpnPaymentLayout = new GroupLayout(jpnPayment);
                jpnPayment.setLayout(jpnPaymentLayout);
                jpnPaymentLayout.setHorizontalGroup(
                    jpnPaymentLayout.createParallelGroup()
                        .addGroup(jpnPaymentLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jpnPaymentLayout.createParallelGroup()
                                .addGroup(jpnPaymentLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlbPayment, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                                    .addComponent(scrollPane4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
                                .addGroup(jpnPaymentLayout.createSequentialGroup()
                                    .addGap(52, 52, 52)
                                    .addGroup(jpnPaymentLayout.createParallelGroup()
                                        .addComponent(checkBox3)
                                        .addComponent(checkBox2)
                                        .addComponent(checkBox1)))
                                .addGroup(jpnPaymentLayout.createSequentialGroup()
                                    .addComponent(JlbInforCus, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addGap(289, 289, 289)))
                            .addGroup(jpnPaymentLayout.createParallelGroup()
                                .addGroup(jpnPaymentLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                                    .addGroup(jpnPaymentLayout.createParallelGroup()
                                        .addComponent(table7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jpnPaymentLayout.createSequentialGroup()
                                            .addComponent(table6, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))
                                    .addGap(34, 34, 34))
                                .addGroup(GroupLayout.Alignment.TRAILING, jpnPaymentLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                    .addComponent(jpnBack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jpnNext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(48, 48, 48))))
                );
                jpnPaymentLayout.setVerticalGroup(
                    jpnPaymentLayout.createParallelGroup()
                        .addGroup(jpnPaymentLayout.createSequentialGroup()
                            .addGroup(jpnPaymentLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(jpnNext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpnPaymentLayout.createSequentialGroup()
                                    .addGroup(jpnPaymentLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jpnPaymentLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(JlbInforCus, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jlbPayment, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                            .addGap(26, 26, 26)
                                            .addComponent(checkBox1)
                                            .addGap(18, 18, 18)
                                            .addComponent(checkBox2))
                                        .addGroup(jpnPaymentLayout.createSequentialGroup()
                                            .addGap(24, 24, 24)
                                            .addComponent(table7, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(table6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jpnPaymentLayout.createParallelGroup()
                                        .addGroup(jpnPaymentLayout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(checkBox3))
                                        .addGroup(jpnPaymentLayout.createSequentialGroup()
                                            .addGap(37, 37, 37)
                                            .addComponent(jpnBack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                            .addContainerGap(139, Short.MAX_VALUE))
                );
            }
            jtbTabEvent.addTab("text", jpnPayment);
        }
        add(jtbTabEvent);
        jtbTabEvent.setBounds(0, 355, 1025, jtbTabEvent.getPreferredSize().height);

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

    public static void main (String[] args) {
        JFrame frame = new JFrame("Đồ án bán vé hoà nhạc");
        frame.setContentPane(new EventPanel());
        frame.pack();
        frame.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Man
    private JPanel jpnEventHeader;
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
    private JTabbedPane jtbTabEvent;
    private JPanel jpnEventInformation;
    private JScrollPane scrollPane1;
    private JPanel InformationPanel;
    private JLabel EventName2;
    private JLabel DescriptionText;
    private JButton button1;
    private JPanel jpnEventTicket;
    private JPanel TicketFee;
    private JScrollPane Scroll;
    private JTable TicketFeeTable;
    private JLabel label1;
    private JPanel SeatEvent;
    private JLabel label2;
    private JLabel jlbSeatingChart;
    private JPanel jpnPickTicket;
    private JScrollPane scrollPane3;
    private JTable table3;
    private JPanel jpnNextButton;
    private JLabel jlbNextButton;
    private JTable table1;
    private JPanel jpnPayment;
    private JLabel JlbInforCus;
    private JScrollPane scrollPane4;
    private JTable table4;
    private JLabel jlbPayment;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JTable table6;
    private JTable table7;
    private JPanel jpnBack;
    private JLabel jlbBack;
    private JPanel jpnNext;
    private JLabel jlbNext;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
