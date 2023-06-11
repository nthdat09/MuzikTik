/*
 * Created by JFormDesigner on Tue Apr 25 08:30:00 ICT 2023
 */

package View.EventPage;

import Model.BEAN.CustomerBuyTicket;
import Model.BEAN.TicketID;
import Model.DAO.Customer.CustomerListDAO;
import Model.DAO.Event.EventInformation.BookingTicket;
import Model.DAO.Event.EventInformation.CustomerInformationValidate;
import Model.DAO.Event.EventInformation.EventTableDatabase;
import Model.DAO.Ticket.SendTicketEmail;
import Model.Database.UserDatabase;
import View.CustomersListPage.InformationCustomerForm;
import View.Home.HomePanel;
import View.MainPage.MainPage;
import com.mysql.cj.jdbc.Blob;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static View.CustomersListPage.InformationCustomerForm.settingForNewCustomer;

/**
 * @author Admin
 */
public class EventPanel extends JPanel {
    ArrayList<JLabel> ticketTypeJlb = new ArrayList<>();
    List<CustomerBuyTicket> customer = null;
    static String seatID = "";
    Border border = BorderFactory.createLineBorder(Color.decode("#61b884"),1);
    public EventPanel() {
        initComponents();
        initSetting();
    }
    
    private void initSetting() {
        selectedTab(0);
        scrollPane1.getVerticalScrollBar().setUnitIncrement(19);
        UIManager.put(jpnEventInformation, Color.white);
        ticketFeeScrollPanel.getVerticalScrollBar().setUnitIncrement(19);
        scrollPane2.getVerticalScrollBar().setUnitIncrement(19);
        seatEventScrollPanel.getVerticalScrollBar().setUnitIncrement(19);
        pickTicketScrollPane.getVerticalScrollBar().setUnitIncrement(19);
    }
    public static ArrayList<JLabel> addTicketType() {
        ArrayList<JLabel> ticketTypeJlb = new ArrayList<>();
        ticketTypeJlb.add(getJlbTicketType1());
        ticketTypeJlb.add(getJlbTicketType2());
        ticketTypeJlb.add(getJlbTicketType3());
        ticketTypeJlb.add(getJlbTicketType4());
        ticketTypeJlb.add(getJlbTicketType5());
        return ticketTypeJlb;
    }
    public static ArrayList<JLabel> addTicketPrice() {
        ArrayList<JLabel> ticketPriceJlb = new ArrayList<>();
        ticketPriceJlb.add(getJlbTicketPrice1());
        ticketPriceJlb.add(getJlbTicketPrice2());
        ticketPriceJlb.add(getJlbTicketPrice3());
        ticketPriceJlb.add(getJlbTicketPrice4());
        ticketPriceJlb.add(getJlbTicketPrice5());
        return ticketPriceJlb;
    }
    public static JLabel getSeatingChartView() {
        return seatingChartView;
    }
    private static JLabel getJlbTicketPrice1() {
        return ticketPrice6;
    }
    private static JLabel getJlbTicketPrice2() {
        return ticketPrice7;
    }
    private static JLabel getJlbTicketPrice3() {
        return ticketPrice8;
    }
    private static JLabel getJlbTicketPrice4() {
        return ticketPrice9;
    }
    private static JLabel getJlbTicketPrice5() {
        return ticketPrice10;
    }
    private static JLabel getJlbTicketType1() {
        return ticketType1;
    }
    private static JLabel getJlbTicketType2() {
        return ticketType2;
    }
    private static JLabel getJlbTicketType3() {
        return ticketType3;
    }
    private static JLabel getJlbTicketType4() {
        return ticketType4;
    }
    private static JLabel getJlbTicketType5() {
        return ticketType5;
    }
    public static JTable getSeatTable() {
        return seatTable;
    }
    public static JLabel getEventSeatingChart() {
        return eventSeatStage;
    }
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

    private void jpnTicketFeeMouseClicked(MouseEvent e) {
        jtbTabEvent.setSelectedIndex(1);
        selectedTab(1);
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
        DefaultTableModel tableModel = (DefaultTableModel) seatTable.getModel();
        tableModel.setRowCount(0);

        EventTableDatabase.getEventTableDatabase();
    }

    private void jpnBuyNowMouseClicked(MouseEvent e) {
        jpnInfo.setVisible(false);
        jpnTicketFee.setVisible(false);
        SeatPanel.setVisible(false);
        jpnBuyNow.setVisible(false);

        jtbTabEvent.setSelectedIndex(3);
    }

    private void jlbNextButtonMouseClicked(MouseEvent e) {
        Integer totalPrice = 0;
        Integer quantity = selectedSeatTable.getRowCount();
        jtbTabEvent.setSelectedIndex(4);
        for(int i = 0; i < selectedSeatTable.getRowCount(); i++) {
            String seatID = selectedSeatTable.getValueAt(i, 0).toString();
            String seatType = selectedSeatTable.getValueAt(i, 1).toString();
            String seatPrice = selectedSeatTable.getValueAt(i, 2).toString();

            totalPrice = totalPrice + Integer.parseInt(seatPrice);

            String[] row = {seatID, seatType, seatPrice};
            DefaultTableModel model = (DefaultTableModel) BuySeatTable.getModel();
            model.addRow(row);
        }

        totalDisplay.setText(totalPrice.toString() + " VND");
        if(quantity == 1) {
            quantityDisplay.setText(quantity.toString() + " ticket");
        } else
        quantityDisplay.setText(quantity.toString() + " tickets");
    }

    private void jpnBackMouseClicked(MouseEvent e) {
        jpnInfo.setVisible(true);
        jpnTicketFee.setVisible(true);
        SeatPanel.setVisible(true);
        jpnBuyNow.setVisible(true);

        jtbTabEvent.setSelectedIndex(0);
        selectedTab(0);
    }

    private void jlbBackMouseClicked(MouseEvent e) {
        jpnInfo.setVisible(true);
        jpnTicketFee.setVisible(true);
        SeatPanel.setVisible(true);
        jpnBuyNow.setVisible(true);

        jtbTabEvent.setSelectedIndex(0);
        selectedTab(0);
        DefaultTableModel tbModel = (DefaultTableModel) BuySeatTable.getModel();
        tbModel.setRowCount(0);
    }
    public static JLabel getEventName2() {
        return EventName2;
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

    public static JLabel getEventName() {
        return EventName;
    }
    public static JLabel getEventArt() {
        return EventArt;
    }
    public static JLabel getEventTime() {
        return EventTime;
    }
    public static JLabel getEventPlace() {
        return EventPlace;
    }
    public static JLabel getDescriptionText() {
        return DescriptionText;
    }
    private void checkBox2(ActionEvent e) {
        isCheckSelected(2);
    }

    private void checkBox3(ActionEvent e) {
        isCheckSelected(3);
    }
    
    public static JTable getSelectedSSeatTable() {
        return selectedSeatTable;
    }
    private void seatTableMouseClicked(MouseEvent e) {
    }

    private void addJlbMouseClicked(MouseEvent e) {
        int row = seatTable.getSelectedRow();
        TableModel model = seatTable.getModel();
        String ticketID = model.getValueAt(row, 0).toString();
        String ticketType = model.getValueAt(row, 1).toString();
        String price = model.getValueAt(row, 2).toString();
        String status = model.getValueAt(row, 3).toString();
        if(status.equals("Booked")) {
            JOptionPane.showConfirmDialog(null, "This seat is booked! Please choose another seat!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String statusPending = "Pending";
        model.setValueAt(statusPending, row, 3);
        for(int i=0; i < selectedSeatTable.getRowCount(); i++) {
            String seatID = selectedSeatTable.getValueAt(i, 0).toString();
            if(seatID.equals(ticketID)) {
                JOptionPane.showConfirmDialog(null, "This seat is already selected! Please choose another seat!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        String tbData[] = {ticketID, ticketType, price, statusPending};
        DefaultTableModel tbModel = (DefaultTableModel) selectedSeatTable.getModel();
        tbModel.addRow(tbData);
    }

    private void deleteJlbMouseClicked(MouseEvent e) {
        int row = selectedSeatTable.getSelectedRow();
        DefaultTableModel tbModel = (DefaultTableModel) selectedSeatTable.getModel();
        tbModel.removeRow(row);
    }

    private void jlbNextMouseClicked(MouseEvent e) {
        customer = CustomerInformationValidate.validateCustomer();
        System.out.println(customer.size());
        try {
            if(customer.size() == 0) {
                JOptionPane.showConfirmDialog(null, "You are not a customer yet! Please register to buy ticket!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                int newID = CustomerListDAO.getLastID();
                String nameCustomer = fullNameText.getText();
                String phoneNumber = phoneNumberText.getText();
                String email = emailText.getText();

                MainPage.changeView(new InformationCustomerForm(newID + 1), MainPage.getJlbCustomer(), "InformationCustomerPanel");
                settingForNewCustomer(nameCustomer, phoneNumber, email);
            } else {
                Integer balance = customer.get(0).getBalance();
                Integer totalPrice = Integer.parseInt(totalDisplay.getText().replace(" USD", ""));
                Integer newBalance = balance - totalPrice;
                if(balance < totalPrice) {
                    JOptionPane.showMessageDialog(null, "Your balance is not enough to buy this ticket!");
                    return;
                } else {
                    try {
                        Connection con = UserDatabase.getConnection();
                        String sql = "UPDATE customer SET CUS_BALANCE = '" + newBalance + "' WHERE CUS_PHONE_NUMBER  = '" + phoneNumberText.getText() + "' AND CUS_NAME = '" + fullNameText.getText() + "' AND CUS_EMAIL = '" + emailText.getText() + "'";
                        for(int i=0; i < BuySeatTable.getRowCount();i++) {
                            String seatID = selectedSeatTable.getValueAt(i, 0).toString();
                            System.out.println(seatID);
                            if(seatID.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Please select your seat!");
                                return;
                            } else {
                                setSeatID(seatID);
                                List<TicketID> bookedTicket = BookingTicket.bookingTicket();
                                Integer ticketID = bookedTicket.get(0).getTicketID();
                                try {
                                        String sqlInsertReservedSeat = "INSERT INTO ticket_booking (TBK_TKT_ID, TBK_CUS_ID, TBK_DATETIME, TBT_POINT) VALUES ('" + ticketID + "', '" + customer.get(0).getCustomerID() + "', '" + java.time.LocalDate.now() + "', '1')";
                                        PreparedStatement ps2 = con.prepareStatement(sqlInsertReservedSeat);
                                        new Thread(() -> {
                                            try {
                                                Thread.sleep(1000);
                                                SendTicketEmail.sendCodeToEmail(totalPrice, HomePanel.getSelectedStage(), ticketID, Integer.parseInt(seatID), emailText.getText());
                                            } catch (Exception err) {
                                                System.err.println(err);
                                            }
                                        }).start();
                                        ps2.executeUpdate();
                                        ps2.close();
                                        } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Ticket have been booked!");
                                    }
                                }
                        }
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.executeUpdate();
                        ps.close();
                        con.close();

                        JOptionPane.showMessageDialog(null, "Your ticket has been booked successfully!");
                        fullNameText.setText("");
                        emailText.setText("");
                        phoneNumberText.setText("");

                        totalDisplay.setText("0 USD");
                        quantityDisplay.setText("0 tickets");

                        DefaultTableModel tableModel = (DefaultTableModel) seatTable.getModel();
                        tableModel.setRowCount(0);
                        DefaultTableModel tableBuyModel = (DefaultTableModel) BuySeatTable.getModel();
                        tableBuyModel.setRowCount(0);
                        DefaultTableModel tableSelectedModel = (DefaultTableModel) selectedSeatTable.getModel();
                        tableSelectedModel.setRowCount(0);

                        jpnInfo.setVisible(true);
                        jpnTicketFee.setVisible(true);
                        SeatPanel.setVisible(true);
                        jpnBuyNow.setVisible(true);

                        selectedTab(0);
                        jtbTabEvent.setSelectedIndex(0);
                        selectedTab(0);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }


    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }
    public static String getSeatID() {
        return seatID;
    }
    public static JTextField getNameTextField() {
        return fullNameText;
    }
    public static JTextField getEmailTextField() {
        return emailText;
    }
    public static JTextField getPhoneTextField() {
        return phoneNumberText;
    }

    private void button1MouseClicked(MouseEvent e) {
        MainPage.changeView(new EventInfor(), MainPage.getJlbEvent(), "EventInfor");
        EventInfor.getTextID().setText(Integer.toString(HomePanel.getSelectedEventID()));
        EventInfor.getTextName().setText(HomePanel.getSelectedEvent());
        EventInfor.getStageComboBox().setSelectedItem(HomePanel.getSelectedStage());
        String desCriptionText = DescriptionText.getText();
        desCriptionText = desCriptionText.replace("<HTML>", "");
        desCriptionText = desCriptionText.replace("</HTML>", "");
        EventInfor.getTextDescription().setText(desCriptionText);
        String[] date = EventTime.getText().split("/");

        EventInfor.getDateTextField().setText(date[2] + "-" + date[1] + "-" + date[0]);
        EventInfor.getTextPoster().setIcon(EventArt.getIcon());
        Connection con = UserDatabase.getConnection();
        String sql = "SELECT * FROM event WHERE EVT_ID = '" + HomePanel.getSelectedEventID() + "'";
    try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                EventInfor.getTextQuantity().setText(rs.getString("EVT_QUANTITY"));
                EventInfor.getTextArtist().setText(rs.getString("EVT_ARTIST"));
                String openTime = rs.getTime("EVT_OPEN_TIME").toString();
                String[] openTimeSplit = openTime.split(":");
                EventInfor.getOpen_Hour().setModel(new SpinnerNumberModel(Integer.parseInt(openTimeSplit[0]), 0, 24, 1));
                EventInfor.getOpen_Minute().setModel(new SpinnerNumberModel(Integer.parseInt(openTimeSplit[1]), 0, 60, 1));
                EventInfor.getOpen_Second().setModel(new SpinnerNumberModel(Integer.parseInt(openTimeSplit[2]), 0, 60, 1));

                String endTime = rs.getTime("EVT_END_TIME").toString();
                String[] endTimeSplit = endTime.split(":");
                EventInfor.getClose_Hour().setModel(new SpinnerNumberModel(Integer.parseInt(endTimeSplit[0]), 0, 24, 1));
                EventInfor.getClose_Minute().setModel(new SpinnerNumberModel(Integer.parseInt(endTimeSplit[1]), 0, 60, 1));
                EventInfor.getClose_Second().setModel(new SpinnerNumberModel(Integer.parseInt(endTimeSplit[2]), 0, 60, 1));

                Blob blob = (Blob) rs.getBlob("EVT_POSTER");
                if (blob != null) {
                    int blobLength = (int) blob.length();
                    byte[] bytes = blob.getBytes(1, blobLength);
                    EventInfor.setEvent_Image(bytes);
                    ImageIcon icon = new ImageIcon(bytes);
                    Image image = icon.getImage();
                    Image newImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    ImageIcon newIcon = new ImageIcon(newImage);
                    EventInfor.getTextPoster().setIcon(newIcon);
                }
            }
            ps.close();
            rs.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
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
        ticketFeeScrollPanel = new JScrollPane();
        panel2 = new JPanel();
        jlbSeatingChart3 = new JLabel();
        ticketType1 = new JLabel();
        ticketType2 = new JLabel();
        ticketType3 = new JLabel();
        ticketType4 = new JLabel();
        ticketType5 = new JLabel();
        ticketPrice6 = new JLabel();
        ticketPrice7 = new JLabel();
        ticketPrice8 = new JLabel();
        ticketPrice9 = new JLabel();
        ticketPrice10 = new JLabel();
        SeatEvent = new JPanel();
        labe124 = new JLabel();
        seatEventScrollPanel = new JScrollPane();
        seatEventPanel = new JPanel();
        jlbSeatingChart = new JLabel();
        seatingChartView = new JLabel();
        jpnPickTicket = new JPanel();
        pickTicketScrollPane = new JScrollPane();
        jpnTicket = new JPanel();
        jpnNextButton = new JPanel();
        jlbNextButton = new JLabel();
        jlbSeatingChart2 = new JLabel();
        pickTicketScrollTable = new JScrollPane();
        seatTable = new JTable();
        eventSeatStage = new JLabel();
        scrollPane3 = new JScrollPane();
        selectedSeatTable = new JTable();
        addJpn = new JPanel();
        addJlb = new JLabel();
        deleteJpn = new JPanel();
        deleteJlb = new JLabel();
        jpnPayment = new JPanel();
        scrollPane2 = new JScrollPane();
        panel1 = new JPanel();
        JlbInforCus = new JLabel();
        jlbPayment = new JLabel();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        jpnBack = new JPanel();
        jlbBack = new JLabel();
        jpnNext = new JPanel();
        jlbNext = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        fullNameText = new JTextField();
        emailText = new JTextField();
        phoneNumberText = new JTextField();
        JlbInforCus2 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        totalDisplay = new JLabel();
        quantityDisplay = new JLabel();
        scrollPane4 = new JScrollPane();
        BuySeatTable = new JTable();

        //======== this ========
        setBackground(Color.white);
        setMinimumSize(new Dimension(1268, 355));
        setPreferredSize(new Dimension(1030, 2000));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
        border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER
        ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font
        . BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener(
        new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r"
        .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(null);

        //======== jpnEventHeader ========
        {
            jpnEventHeader.setBackground(Color.white);
            jpnEventHeader.setPreferredSize(new Dimension(1030, 355));

            //---- EventArt ----
            EventArt.setText("event art");
            EventArt.setBackground(new Color(0x33ffcc));
            EventArt.setBorder(null);

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
                });

                GroupLayout jpnInfoLayout = new GroupLayout(jpnInfo);
                jpnInfo.setLayout(jpnInfoLayout);
                jpnInfoLayout.setHorizontalGroup(
                    jpnInfoLayout.createParallelGroup()
                        .addComponent(jlbInfo, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                );
                jpnInfoLayout.setVerticalGroup(
                    jpnInfoLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, jpnInfoLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jlbInfo, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
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
                });

                GroupLayout jpnTicketFeeLayout = new GroupLayout(jpnTicketFee);
                jpnTicketFee.setLayout(jpnTicketFeeLayout);
                jpnTicketFeeLayout.setHorizontalGroup(
                    jpnTicketFeeLayout.createParallelGroup()
                        .addGroup(jpnTicketFeeLayout.createSequentialGroup()
                            .addComponent(TicketFeeText, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                );
                jpnTicketFeeLayout.setVerticalGroup(
                    jpnTicketFeeLayout.createParallelGroup()
                        .addComponent(TicketFeeText, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
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
                });

                GroupLayout SeatPanelLayout = new GroupLayout(SeatPanel);
                SeatPanel.setLayout(SeatPanelLayout);
                SeatPanelLayout.setHorizontalGroup(
                    SeatPanelLayout.createParallelGroup()
                        .addComponent(jlbSeat, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                );
                SeatPanelLayout.setVerticalGroup(
                    SeatPanelLayout.createParallelGroup()
                        .addComponent(jlbSeat, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
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
                        .addGroup(jpnEventHeaderLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                                .addComponent(jpnInfo, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jpnTicketFee, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SeatPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(EventArt, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jpnEventHeaderLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, jpnEventHeaderLayout.createSequentialGroup()
                                .addComponent(jpnBuyNow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68))
                            .addGroup(GroupLayout.Alignment.TRAILING, jpnEventHeaderLayout.createSequentialGroup()
                                .addGroup(jpnEventHeaderLayout.createParallelGroup()
                                    .addComponent(EventTime, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EventPlace, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EventName, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
            );
            jpnEventHeaderLayout.setVerticalGroup(
                jpnEventHeaderLayout.createParallelGroup()
                    .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jpnEventHeaderLayout.createParallelGroup()
                            .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                                .addComponent(EventName, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(EventTime, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EventPlace, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(jpnBuyNow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                                .addComponent(EventArt, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 2, Short.MAX_VALUE)))
                        .addGap(36, 36, 36)
                        .addGroup(jpnEventHeaderLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnEventHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jpnTicketFee, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addComponent(jpnInfo, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                            .addComponent(SeatPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 19, Short.MAX_VALUE))
            );
        }
        add(jpnEventHeader);
        jpnEventHeader.setBounds(0, 0, 1180, 365);

        //======== jtbTabEvent ========
        {
            jtbTabEvent.setPreferredSize(new Dimension(1079, 2000));
            jtbTabEvent.setBackground(Color.white);

            //======== jpnEventInformation ========
            {
                jpnEventInformation.setBorder(null);

                //======== scrollPane1 ========
                {
                    scrollPane1.setPreferredSize(new Dimension(1020, 10021));
                    scrollPane1.setBorder(null);

                    //======== InformationPanel ========
                    {
                        InformationPanel.setBackground(Color.white);
                        InformationPanel.setBorder(null);

                        //---- EventName2 ----
                        EventName2.setText("EVENT NAME");
                        EventName2.setFont(new Font("Lato Black", Font.BOLD, 22));
                        EventName2.setForeground(new Color(0x61b884));
                        EventName2.setHorizontalAlignment(SwingConstants.LEFT);

                        //---- DescriptionText ----
                        DescriptionText.setText("Description Event");
                        DescriptionText.setVerticalAlignment(SwingConstants.TOP);
                        DescriptionText.setFont(new Font("Lato", Font.PLAIN, 14));
                        DescriptionText.setBorder(null);

                        //---- button1 ----
                        button1.setText("EDIT");
                        button1.setForeground(Color.white);
                        button1.setBackground(new Color(0x61b884));
                        button1.setFont(new Font("Lato Black", Font.BOLD, 14));
                        button1.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                button1MouseClicked(e);
                            }
                        });

                        GroupLayout InformationPanelLayout = new GroupLayout(InformationPanel);
                        InformationPanel.setLayout(InformationPanelLayout);
                        InformationPanelLayout.setHorizontalGroup(
                            InformationPanelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, InformationPanelLayout.createSequentialGroup()
                                    .addGap(55, 55, 55)
                                    .addGroup(InformationPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(DescriptionText, GroupLayout.DEFAULT_SIZE, 1057, Short.MAX_VALUE)
                                        .addGroup(InformationPanelLayout.createSequentialGroup()
                                            .addComponent(EventName2, GroupLayout.PREFERRED_SIZE, 710, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(92, 92, 92))
                        );
                        InformationPanelLayout.setVerticalGroup(
                            InformationPanelLayout.createParallelGroup()
                                .addGroup(InformationPanelLayout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addGroup(InformationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(button1)
                                        .addComponent(EventName2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(DescriptionText, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(24, Short.MAX_VALUE))
                        );
                    }
                    scrollPane1.setViewportView(InformationPanel);
                }

                GroupLayout jpnEventInformationLayout = new GroupLayout(jpnEventInformation);
                jpnEventInformation.setLayout(jpnEventInformationLayout);
                jpnEventInformationLayout.setHorizontalGroup(
                    jpnEventInformationLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE)
                );
                jpnEventInformationLayout.setVerticalGroup(
                    jpnEventInformationLayout.createParallelGroup()
                        .addGroup(jpnEventInformationLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 47, Short.MAX_VALUE))
                );
            }
            jtbTabEvent.addTab("text", jpnEventInformation);

            //======== jpnEventTicket ========
            {

                //======== ticketFeeScrollPanel ========
                {
                    ticketFeeScrollPanel.setBorder(null);
                    ticketFeeScrollPanel.setPreferredSize(new Dimension(602, 10021));

                    //======== panel2 ========
                    {
                        panel2.setBackground(Color.white);

                        //---- jlbSeatingChart3 ----
                        jlbSeatingChart3.setText("TICKET FEES");
                        jlbSeatingChart3.setForeground(new Color(0x61b884));
                        jlbSeatingChart3.setFont(new Font("Lato Black", Font.BOLD, 22));
                        jlbSeatingChart3.setHorizontalAlignment(SwingConstants.LEFT);

                        //---- ticketType1 ----
                        ticketType1.setText("text");

                        //---- ticketType2 ----
                        ticketType2.setText("text");

                        //---- ticketType3 ----
                        ticketType3.setText("text");

                        //---- ticketType4 ----
                        ticketType4.setText("text");

                        //---- ticketType5 ----
                        ticketType5.setText("text");

                        //---- ticketPrice6 ----
                        ticketPrice6.setText("text");

                        //---- ticketPrice7 ----
                        ticketPrice7.setText("text");

                        //---- ticketPrice8 ----
                        ticketPrice8.setText("text");

                        //---- ticketPrice9 ----
                        ticketPrice9.setText("text");

                        //---- ticketPrice10 ----
                        ticketPrice10.setText("text");

                        GroupLayout panel2Layout = new GroupLayout(panel2);
                        panel2.setLayout(panel2Layout);
                        panel2Layout.setHorizontalGroup(
                            panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(jlbSeatingChart3, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGroup(panel2Layout.createParallelGroup()
                                                .addComponent(ticketType1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ticketType2, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ticketType3, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ticketType5, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ticketType4, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
                                            .addGap(89, 89, 89)
                                            .addGroup(panel2Layout.createParallelGroup()
                                                .addComponent(ticketPrice9, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ticketPrice6, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ticketPrice7, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ticketPrice8, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ticketPrice10, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))))
                                    .addContainerGap())
                        );
                        panel2Layout.setVerticalGroup(
                            panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jlbSeatingChart3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ticketType1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ticketPrice6, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addComponent(ticketType2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(ticketType3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(ticketType4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(ticketType5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ticketPrice10, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addComponent(ticketPrice7, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(ticketPrice8, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(ticketPrice9, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(72, 72, 72))
                        );
                    }
                    ticketFeeScrollPanel.setViewportView(panel2);
                }

                GroupLayout jpnEventTicketLayout = new GroupLayout(jpnEventTicket);
                jpnEventTicket.setLayout(jpnEventTicketLayout);
                jpnEventTicketLayout.setHorizontalGroup(
                    jpnEventTicketLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, jpnEventTicketLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ticketFeeScrollPanel, GroupLayout.PREFERRED_SIZE, 1174, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
                jpnEventTicketLayout.setVerticalGroup(
                    jpnEventTicketLayout.createParallelGroup()
                        .addGroup(jpnEventTicketLayout.createSequentialGroup()
                            .addComponent(ticketFeeScrollPanel, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 236, Short.MAX_VALUE))
                );
            }
            jtbTabEvent.addTab("text", jpnEventTicket);

            //======== SeatEvent ========
            {
                SeatEvent.setBorder(null);
                SeatEvent.setBackground(Color.white);

                //---- labe124 ----
                labe124.setText("\u1ea2nh s\u01a1 \u0111\u1ed3 gh\u1ebf");
                labe124.setBorder(LineBorder.createBlackLineBorder());

                //======== seatEventScrollPanel ========
                {
                    seatEventScrollPanel.setBorder(null);

                    //======== seatEventPanel ========
                    {
                        seatEventPanel.setBackground(Color.white);

                        //---- jlbSeatingChart ----
                        jlbSeatingChart.setText("SEATING CHART");
                        jlbSeatingChart.setForeground(new Color(0x61b884));
                        jlbSeatingChart.setFont(new Font("Lato Black", Font.BOLD, 22));
                        jlbSeatingChart.setHorizontalAlignment(SwingConstants.LEFT);

                        //---- seatingChartView ----
                        seatingChartView.setText("seatingChartView");

                        GroupLayout seatEventPanelLayout = new GroupLayout(seatEventPanel);
                        seatEventPanel.setLayout(seatEventPanelLayout);
                        seatEventPanelLayout.setHorizontalGroup(
                            seatEventPanelLayout.createParallelGroup()
                                .addGroup(seatEventPanelLayout.createSequentialGroup()
                                    .addGap(52, 52, 52)
                                    .addGroup(seatEventPanelLayout.createParallelGroup()
                                        .addComponent(jlbSeatingChart, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(seatingChartView, GroupLayout.PREFERRED_SIZE, 1082, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap())
                        );
                        seatEventPanelLayout.setVerticalGroup(
                            seatEventPanelLayout.createParallelGroup()
                                .addGroup(seatEventPanelLayout.createSequentialGroup()
                                    .addComponent(jlbSeatingChart, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(seatingChartView, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                    }
                    seatEventScrollPanel.setViewportView(seatEventPanel);
                }

                GroupLayout SeatEventLayout = new GroupLayout(SeatEvent);
                SeatEvent.setLayout(SeatEventLayout);
                SeatEventLayout.setHorizontalGroup(
                    SeatEventLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, SeatEventLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seatEventScrollPanel, GroupLayout.PREFERRED_SIZE, 1194, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
                SeatEventLayout.setVerticalGroup(
                    SeatEventLayout.createParallelGroup()
                        .addGroup(SeatEventLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(seatEventScrollPanel, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(239, Short.MAX_VALUE))
                );
            }
            jtbTabEvent.addTab("text", SeatEvent);

            //======== jpnPickTicket ========
            {
                jpnPickTicket.setBackground(Color.white);
                jpnPickTicket.setPreferredSize(new Dimension(1025, 1000));

                //======== pickTicketScrollPane ========
                {
                    pickTicketScrollPane.setBackground(Color.white);
                    pickTicketScrollPane.setBorder(null);

                    //======== jpnTicket ========
                    {
                        jpnTicket.setBackground(Color.white);
                        jpnTicket.setBorder(null);

                        //======== jpnNextButton ========
                        {
                            jpnNextButton.setBackground(new Color(0x61b884));

                            //---- jlbNextButton ----
                            jlbNextButton.setText("NEXT");
                            jlbNextButton.setHorizontalAlignment(SwingConstants.CENTER);
                            jlbNextButton.setBorder(null);
                            jlbNextButton.setFont(new Font("Lato Black", Font.BOLD, 22));
                            jlbNextButton.setBackground(new Color(0x61b884));
                            jlbNextButton.setForeground(Color.white);
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
                                    .addComponent(jlbNextButton, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            );
                            jpnNextButtonLayout.setVerticalGroup(
                                jpnNextButtonLayout.createParallelGroup()
                                    .addComponent(jlbNextButton, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            );
                        }

                        //---- jlbSeatingChart2 ----
                        jlbSeatingChart2.setText("TICKET FEES");
                        jlbSeatingChart2.setForeground(new Color(0x61b884));
                        jlbSeatingChart2.setFont(new Font("Lato Black", Font.BOLD, 22));
                        jlbSeatingChart2.setHorizontalAlignment(SwingConstants.LEFT);

                        //======== pickTicketScrollTable ========
                        {

                            //---- seatTable ----
                            seatTable.setModel(new DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                    "Seat ID", "Seat Type", "Price", "Status"
                                }
                            ));
                            seatTable.setFont(new Font("Century Gothic", Font.PLAIN, 13));
                            seatTable.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    seatTableMouseClicked(e);
                                }
                            });
                            pickTicketScrollTable.setViewportView(seatTable);
                        }

                        //---- eventSeatStage ----
                        eventSeatStage.setText("text");

                        //======== scrollPane3 ========
                        {

                            //---- selectedSeatTable ----
                            selectedSeatTable.setModel(new DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                    "Seat ID", "Seat Type", "Price", "Status"
                                }
                            ));
                            scrollPane3.setViewportView(selectedSeatTable);
                        }

                        //======== addJpn ========
                        {
                            addJpn.setBackground(new Color(0x61b884));
                            addJpn.setLayout(new GridLayout());

                            //---- addJlb ----
                            addJlb.setText("ADD");
                            addJlb.setForeground(Color.white);
                            addJlb.setHorizontalAlignment(SwingConstants.CENTER);
                            addJlb.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    addJlbMouseClicked(e);
                                }
                            });
                            addJpn.add(addJlb);
                        }

                        //======== deleteJpn ========
                        {
                            deleteJpn.setBackground(new Color(0x61b884));
                            deleteJpn.setLayout(new GridLayout());

                            //---- deleteJlb ----
                            deleteJlb.setText("DELETE");
                            deleteJlb.setForeground(Color.white);
                            deleteJlb.setHorizontalAlignment(SwingConstants.CENTER);
                            deleteJlb.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    deleteJlbMouseClicked(e);
                                }
                            });
                            deleteJpn.add(deleteJlb);
                        }

                        GroupLayout jpnTicketLayout = new GroupLayout(jpnTicket);
                        jpnTicket.setLayout(jpnTicketLayout);
                        jpnTicketLayout.setHorizontalGroup(
                            jpnTicketLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, jpnTicketLayout.createSequentialGroup()
                                    .addGroup(jpnTicketLayout.createParallelGroup()
                                        .addGroup(jpnTicketLayout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addComponent(jlbSeatingChart2, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpnTicketLayout.createSequentialGroup()
                                            .addGap(26, 26, 26)
                                            .addComponent(eventSeatStage, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpnTicketLayout.createSequentialGroup()
                                            .addGap(177, 177, 177)
                                            .addComponent(jpnNextButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpnTicketLayout.createSequentialGroup()
                                            .addGap(84, 84, 84)
                                            .addComponent(addJpn, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                            .addGap(84, 84, 84)
                                            .addComponent(deleteJpn, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                    .addGroup(jpnTicketLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pickTicketScrollTable, GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                                        .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE))
                                    .addGap(84, 84, 84))
                        );
                        jpnTicketLayout.setVerticalGroup(
                            jpnTicketLayout.createParallelGroup()
                                .addGroup(jpnTicketLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addGroup(jpnTicketLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jpnTicketLayout.createSequentialGroup()
                                            .addComponent(jlbSeatingChart2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(eventSeatStage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(pickTicketScrollTable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpnTicketLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jpnTicketLayout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpnTicketLayout.createSequentialGroup()
                                            .addGap(32, 32, 32)
                                            .addGroup(jpnTicketLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(addJpn, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(deleteJpn, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jpnNextButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(100, Short.MAX_VALUE))
                        );
                    }
                    pickTicketScrollPane.setViewportView(jpnTicket);
                }

                GroupLayout jpnPickTicketLayout = new GroupLayout(jpnPickTicket);
                jpnPickTicket.setLayout(jpnPickTicketLayout);
                jpnPickTicketLayout.setHorizontalGroup(
                    jpnPickTicketLayout.createParallelGroup()
                        .addGroup(jpnPickTicketLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(pickTicketScrollPane, GroupLayout.PREFERRED_SIZE, 1199, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jpnPickTicketLayout.setVerticalGroup(
                    jpnPickTicketLayout.createParallelGroup()
                        .addGroup(jpnPickTicketLayout.createSequentialGroup()
                            .addComponent(pickTicketScrollPane, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                );
            }
            jtbTabEvent.addTab("text", jpnPickTicket);

            //======== jpnPayment ========
            {
                jpnPayment.setBackground(Color.white);
                jpnPayment.setPreferredSize(new Dimension(1079, 1000));

                //======== scrollPane2 ========
                {
                    scrollPane2.setBorder(null);

                    //======== panel1 ========
                    {
                        panel1.setBackground(Color.white);

                        //---- JlbInforCus ----
                        JlbInforCus.setText("CUSTOMER INFORMATION");
                        JlbInforCus.setFont(new Font("Lato Black", Font.BOLD, 16));
                        JlbInforCus.setForeground(new Color(0x61b884));

                        //---- jlbPayment ----
                        jlbPayment.setText("PAYMENT METHOD");
                        jlbPayment.setForeground(new Color(0x61b884));
                        jlbPayment.setFont(new Font("Lato Black", Font.BOLD, 16));

                        //---- checkBox1 ----
                        checkBox1.setText("Credit card");
                        checkBox1.setFont(new Font("Lato Black", Font.BOLD, 14));
                        checkBox1.setForeground(new Color(0x626262));
                        checkBox1.addActionListener(e -> {
			checkBox1(e);
			checkBox1(e);
		});

                        //---- checkBox2 ----
                        checkBox2.setText("Payment using Internet Banking");
                        checkBox2.setFont(new Font("Lato Black", Font.BOLD, 14));
                        checkBox2.setForeground(new Color(0x626262));
                        checkBox2.addActionListener(e -> checkBox2(e));

                        //---- checkBox3 ----
                        checkBox3.setText("Payment using E-Wallet");
                        checkBox3.setForeground(new Color(0x626262));
                        checkBox3.setFont(new Font("Lato Black", Font.BOLD, 14));
                        checkBox3.addActionListener(e -> checkBox3(e));

                        //======== jpnBack ========
                        {
                            jpnBack.setBorder(null);
                            jpnBack.setBackground(new Color(0x61b884));
                            jpnBack.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    jpnBackMouseClicked(e);
                                }
                            });

                            //---- jlbBack ----
                            jlbBack.setText("BACK");
                            jlbBack.setHorizontalAlignment(SwingConstants.CENTER);
                            jlbBack.setFont(new Font("Lato Black", Font.BOLD, 19));
                            jlbBack.setForeground(Color.white);
                            jlbBack.setBackground(new Color(0x61b884));
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
                                    .addComponent(jlbBack, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            );
                            jpnBackLayout.setVerticalGroup(
                                jpnBackLayout.createParallelGroup()
                                    .addComponent(jlbBack, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            );
                        }

                        //======== jpnNext ========
                        {
                            jpnNext.setBorder(null);
                            jpnNext.setBackground(new Color(0x61b884));

                            //---- jlbNext ----
                            jlbNext.setText("NEXT");
                            jlbNext.setHorizontalAlignment(SwingConstants.CENTER);
                            jlbNext.setFont(new Font("Lato Black", Font.BOLD, 17));
                            jlbNext.setForeground(Color.white);
                            jlbNext.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    jlbNextMouseClicked(e);
                                }
                            });

                            GroupLayout jpnNextLayout = new GroupLayout(jpnNext);
                            jpnNext.setLayout(jpnNextLayout);
                            jpnNextLayout.setHorizontalGroup(
                                jpnNextLayout.createParallelGroup()
                                    .addComponent(jlbNext, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            );
                            jpnNextLayout.setVerticalGroup(
                                jpnNextLayout.createParallelGroup()
                                    .addComponent(jlbNext, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            );
                        }

                        //---- label3 ----
                        label3.setText("Full Name");
                        label3.setForeground(new Color(0x626262));
                        label3.setFont(new Font("Lato Black", Font.BOLD, 16));

                        //---- label4 ----
                        label4.setText("Email");
                        label4.setForeground(new Color(0x626262));
                        label4.setFont(new Font("Lato Black", Font.BOLD, 16));

                        //---- label5 ----
                        label5.setText("Phone Number");
                        label5.setForeground(new Color(0x626262));
                        label5.setFont(new Font("Lato Black", Font.BOLD, 16));

                        //---- fullNameText ----
                        fullNameText.setFont(new Font("Lato", Font.PLAIN, 16));
                        fullNameText.setForeground(new Color(0x61b884));

                        //---- emailText ----
                        emailText.setFont(new Font("Lato", Font.PLAIN, 16));
                        emailText.setForeground(new Color(0x61b884));

                        //---- phoneNumberText ----
                        phoneNumberText.setFont(new Font("Lato", Font.PLAIN, 16));
                        phoneNumberText.setForeground(new Color(0x61b884));

                        //---- JlbInforCus2 ----
                        JlbInforCus2.setText("TICKET INFORMATION");
                        JlbInforCus2.setFont(new Font("Lato Black", Font.BOLD, 16));
                        JlbInforCus2.setForeground(new Color(0x61b884));

                        //---- label1 ----
                        label1.setText("Quantity:");
                        label1.setForeground(Color.black);

                        //---- label2 ----
                        label2.setText("Total:");
                        label2.setForeground(Color.black);

                        //---- totalDisplay ----
                        totalDisplay.setText("text");

                        //---- quantityDisplay ----
                        quantityDisplay.setText("text");

                        //======== scrollPane4 ========
                        {

                            //---- BuySeatTable ----
                            BuySeatTable.setModel(new DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                    "SeatID", "Seat Type", "Price"
                                }
                            ));
                            scrollPane4.setViewportView(BuySeatTable);
                        }

                        GroupLayout panel1Layout = new GroupLayout(panel1);
                        panel1.setLayout(panel1Layout);
                        panel1Layout.setHorizontalGroup(
                            panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGap(71, 71, 71)
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(jlbPayment, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addGroup(panel1Layout.createParallelGroup()
                                                        .addComponent(label5)
                                                        .addComponent(label4)
                                                        .addComponent(label3))
                                                    .addGap(27, 27, 27)
                                                    .addGroup(panel1Layout.createParallelGroup()
                                                        .addComponent(emailText, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(phoneNumberText, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fullNameText, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(checkBox1)
                                                .addComponent(checkBox2)
                                                .addComponent(checkBox3, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGap(35, 35, 35)
                                            .addComponent(JlbInforCus, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
                                                    .addContainerGap(293, Short.MAX_VALUE))
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(JlbInforCus2, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
                                                    .addContainerGap(625, Short.MAX_VALUE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(panel1Layout.createParallelGroup()
                                                        .addComponent(totalDisplay, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(quantityDisplay, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
                                                    .addContainerGap(602, Short.MAX_VALUE))))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                                            .addComponent(jpnBack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jpnNext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(392, 392, 392))))
                        );
                        panel1Layout.setVerticalGroup(
                            panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(JlbInforCus, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JlbInforCus2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addGap(71, 71, 71)
                                                    .addGroup(panel1Layout.createParallelGroup()
                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                            .addComponent(fullNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(emailText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(phoneNumberText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                                            .addComponent(label3)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(label4)
                                                            .addGap(44, 44, 44))))
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE))
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(quantityDisplay, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(totalDisplay, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)))
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(jpnBack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jpnNext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addContainerGap(572, Short.MAX_VALUE))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGap(153, 153, 153)
                                            .addComponent(label5)
                                            .addGap(12, 12, 12)
                                            .addComponent(jlbPayment, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(checkBox1)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(checkBox2)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(checkBox3)
                                            .addContainerGap(589, Short.MAX_VALUE))))
                        );
                    }
                    scrollPane2.setViewportView(panel1);
                }

                GroupLayout jpnPaymentLayout = new GroupLayout(jpnPayment);
                jpnPayment.setLayout(jpnPaymentLayout);
                jpnPaymentLayout.setHorizontalGroup(
                    jpnPaymentLayout.createParallelGroup()
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE)
                );
                jpnPaymentLayout.setVerticalGroup(
                    jpnPaymentLayout.createParallelGroup()
                        .addGroup(jpnPaymentLayout.createSequentialGroup()
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 50, Short.MAX_VALUE))
                );
            }
            jtbTabEvent.addTab("text", jpnPayment);
        }
        add(jtbTabEvent);
        jtbTabEvent.setBounds(-15, 325, 1195, 651);

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
    // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
    private JPanel jpnEventHeader;
    private static JLabel EventArt;
    private static JLabel EventName;
    private static JLabel EventTime;
    private static JLabel EventPlace;
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
    private static JLabel EventName2;
    private static JLabel DescriptionText;
    private JButton button1;
    private JPanel jpnEventTicket;
    private JScrollPane ticketFeeScrollPanel;
    private JPanel panel2;
    private JLabel jlbSeatingChart3;
    private static JLabel ticketType1;
    private static JLabel ticketType2;
    private static JLabel ticketType3;
    private static JLabel ticketType4;
    private static JLabel ticketType5;
    private static JLabel ticketPrice6;
    private static JLabel ticketPrice7;
    private static JLabel ticketPrice8;
    private static JLabel ticketPrice9;
    private static JLabel ticketPrice10;
    private JPanel SeatEvent;
    private JLabel labe124;
    private JScrollPane seatEventScrollPanel;
    private JPanel seatEventPanel;
    private JLabel jlbSeatingChart;
    private static JLabel seatingChartView;
    private JPanel jpnPickTicket;
    private JScrollPane pickTicketScrollPane;
    private static JPanel jpnTicket;
    private JPanel jpnNextButton;
    private JLabel jlbNextButton;
    private JLabel jlbSeatingChart2;
    private JScrollPane pickTicketScrollTable;
    private static JTable seatTable;
    private static JLabel eventSeatStage;
    private JScrollPane scrollPane3;
    private static JTable selectedSeatTable;
    private JPanel addJpn;
    private JLabel addJlb;
    private JPanel deleteJpn;
    private JLabel deleteJlb;
    private JPanel jpnPayment;
    private JScrollPane scrollPane2;
    private JPanel panel1;
    private JLabel JlbInforCus;
    private JLabel jlbPayment;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JPanel jpnBack;
    private JLabel jlbBack;
    private JPanel jpnNext;
    private JLabel jlbNext;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private static JTextField fullNameText;
    private static JTextField emailText;
    private static JTextField phoneNumberText;
    private JLabel JlbInforCus2;
    private JLabel label1;
    private JLabel label2;
    private JLabel totalDisplay;
    private JLabel quantityDisplay;
    private JScrollPane scrollPane4;
    private JTable BuySeatTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
