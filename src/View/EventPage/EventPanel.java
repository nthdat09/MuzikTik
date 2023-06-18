/*
 * Created by JFormDesigner on Tue Apr 25 08:30:00 ICT 2023
 */

package View.EventPage;

import java.awt.event.*;
import Model.BEAN.Customer.CustomerBuyTicket;
import Model.BEAN.Event.*;
import Model.BEAN.Event.EventSuggestionTextField;
import Model.BEAN.Event.SeatView50;
import Model.BEAN.Ticket.TicketID;
import Model.DAO.Customer.CustomerListDAO;
import Model.DAO.Event.EventInformation.BookingTicket;
import Model.DAO.Event.EventInformation.CustomerInformationValidate;
import Model.DAO.Event.EventInformation.EventTableDatabase;
import Model.DAO.Ticket.SendTicketEmail;
import Model.Database.UserDatabase;
import View.Home.HomePanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Admin
 */
public class EventPanel extends JPanel {
    ArrayList<JLabel> ticketTypeJlb = new ArrayList<>();
    List<CustomerBuyTicket> customer = null;

    static String seatID = "";
    Integer count = 0;
    Border border = BorderFactory.createLineBorder(Color.decode("#61b884"), 1);

    public EventPanel()  {
        initComponents();
        initSetting();
        initCustomerName();
        fullNameText.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
            }
        });
    }

    private void initCustomerName() {
        Connection connection = UserDatabase.getConnection();
        String sql = "SELECT CUS_NAME FROM customer";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("CUS_NAME");
                fullNameText.addItemSuggestion(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void initSetting() {
        selectedTab(0);
        scrollPane1.getVerticalScrollBar().setUnitIncrement(19);
        pickTicketScrollPane2.getVerticalScrollBar().setUnitIncrement(19);
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

    private static final String EMAIL_PATTERN = "^(.+)@(\\S+)$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isValid(final String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
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
        switch (indexSelected) {
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

        Connection con = UserDatabase.getConnection();
        int capacity = 0;
        String sql = "Select stg_capacity from stage where stg_id = " + HomePanel.getSelectedStage();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            capacity = 0;
            while (rs.next()) {
                capacity = rs.getInt("stg_capacity");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        if (capacity == 50) {
            jtbTabEvent.setSelectedIndex(3);
        } else if (capacity == 100) {
            jtbTabEvent.setSelectedIndex(4);
        }
    }

    private void jpnBuyNowMouseClicked(MouseEvent e) {
        jpnInfo.setVisible(false);
        jpnTicketFee.setVisible(false);
        SeatPanel.setVisible(false);
        jpnBuyNow.setVisible(false);

        Connection con = UserDatabase.getConnection();
        int capacity = 0;
        String sql = "Select stg_capacity from stage where stg_id = " + HomePanel.getSelectedStage();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            capacity = 0;
            while (rs.next()) {
                capacity = rs.getInt("stg_capacity");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        if (capacity == 50) {
            jtbTabEvent.setSelectedIndex(3);
        } else if (capacity == 100) {
            jtbTabEvent.setSelectedIndex(4);
        }
    }

    private void jlbNextButtonMouseClicked(MouseEvent e) {
        Integer quantity = selectedTable50.getRowCount();
        Integer priceList = 0;
        DefaultTableModel tbModel = (DefaultTableModel) selectedTable50.getModel();
        for(int i = 0; i<tbModel.getRowCount();i++) {
            priceList += Integer.parseInt(tbModel.getValueAt(i, 2).toString());
        }
        jtbTabEvent.setSelectedIndex(5);
        quantityDisplay.setText(String.valueOf(quantity));
        totalDisplay.setText(String.valueOf(priceList) + " VND");
        SeatView50.settingBuySeatTable();
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

    private void checkBox1(ActionEvent e) {
        isCheckSelected(1);
    }

    private void isCheckSelected(int index) {
        if (index == 1) {
            checkBox3.setSelected(false);
        } else {
            checkBox1.setSelected(false);
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

    private void checkBox3(ActionEvent e) {
        isCheckSelected(3);
    }

    private void jlbNextMouseClicked(MouseEvent e) {
        Integer ticketBookingID = null;
        if (fullNameText.getText().toString().equals("") || phoneNumberText.getText().toString().equals("") || emailText.getText().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all information!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (checkBox1.isSelected() == false && checkBox3.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Please choose a payment method!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (!isValid(emailText.getText().toString())) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (Pattern.compile("^\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}$").matcher(phoneNumberText.getText().toString()).matches() == false) {
            JOptionPane.showMessageDialog(null, "Please enter a valid phone number!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (checkBox3.isSelected() == true) {
            customer = CustomerInformationValidate.validateCustomer();
            try {
                if (customer.size() == 0) {
                    JOptionPane.showConfirmDialog(null, "You are not a customer yet! Please register to buy ticket!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                    int newID = CustomerListDAO.getLastID();
                    String nameCustomer = fullNameText.getText();
                    String phoneNumber = phoneNumberText.getText();
                    String email = emailText.getText();

                    JFrame frame = new JFrame("Register");
                    frame.setContentPane(new NewCustomerEvent(newID + 1));
                    NewCustomerEvent.settingForNewCustomer(nameCustomer, phoneNumber, email);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setSize(1050, 650);

                } else {
                    Integer balance = customer.get(0).getBalance();
                    Integer totalPrice = Integer.parseInt(totalDisplay.getText().replace(" VND", ""));
                    Integer newBalance = balance - totalPrice;
                    if (balance < totalPrice) {
                        JOptionPane.showMessageDialog(null, "Your balance is not enough to buy this ticket!");
                        return;
                    } else {
                        try {
                            Connection con = UserDatabase.getConnection();
                            String sql = "UPDATE customer SET CUS_BALANCE = '" + newBalance + "' WHERE CUS_PHONE_NUMBER  = '" + phoneNumberText.getText() + "' AND CUS_NAME = '" + fullNameText.getText() + "' AND CUS_EMAIL = '" + emailText.getText() + "'";
                            for (int i = 0; i < BuySeatTable.getRowCount(); i++) {
                                String seatID = BuySeatTable.getValueAt(i, 0).toString();
                                if (seatID.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Please select your seat!");
                                    return;
                                } else {
                                    setSeatID(seatID);
                                    List<TicketID> bookedTicket = BookingTicket.bookingTicket();
                                    Integer ticketID = bookedTicket.get(0).getTicketID();
                                    String sqlTicketBooking = "SELECT MAX(TBK_ID) from ticket_booking";
                                    PreparedStatement ps1 = con.prepareStatement(sqlTicketBooking);
                                    ResultSet rs = ps1.executeQuery();
                                    while (rs.next()) {
                                        ticketBookingID = rs.getInt(1) + 1;
                                    }
                                    try {
                                        String sqlInsertReservedSeat = "INSERT INTO ticket_booking (TBK_ID,TBK_TKT_ID, TBK_CUS_ID, TBK_DATETIME, TBT_POINT) VALUES ('" + ticketBookingID + "', '" + ticketID + "', '" + customer.get(0).getCustomerID() + "', '" + java.time.LocalDate.now() + "', '1')";
                                        PreparedStatement ps2 = con.prepareStatement(sqlInsertReservedSeat);
                                        new Thread(() -> {
                                            try {
                                                Thread.sleep(1000);
                                                SendTicketEmail.sendCodeToEmail(totalPrice, HomePanel.getSelectedStage(), ticketID, Integer.parseInt(seatID), emailText.getText(), getEventName().getText(), fullNameText.getText(), getEventPlace().getText(), getEventTime().getText());
                                            } catch (Exception err) {
                                                System.err.println(err);
                                            }
                                        }).start();
                                        ps2.executeUpdate();
                                        ps2.close();
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, ex);
                                    }
                                }
                            }
                            PreparedStatement ps = con.prepareStatement(sql);
                            ps.executeUpdate();

                            String sqlGetPoint = "Select cus_total_point from customer where cus_id = " + customer.get(0).getCustomerID();
                            PreparedStatement psGetPoint = con.prepareStatement(sqlGetPoint);
                            ResultSet rsGetPoint = psGetPoint.executeQuery();
                            while (rsGetPoint.next()) {
                                Integer previousPoint = rsGetPoint.getInt("cus_total_point");
                                Integer point = totalPrice / 1000;
                                Integer totalPoint = point + previousPoint;
                                String sqlUpdatePoint = "Update customer set cus_total_point = " + totalPoint + " where cus_id = " + customer.get(0).getCustomerID();
                                PreparedStatement ps3 = con.prepareStatement(sqlUpdatePoint);
                                ps3.executeUpdate();
                            }

                            ps.close();
                            con.close();

                            JOptionPane.showMessageDialog(null, "Your ticket has been booked successfully!");
                            fullNameText.setText("");
                            emailText.setText("");
                            phoneNumberText.setText("");

                            totalDisplay.setText("0 VND");
                            quantityDisplay.setText("0 tickets");


                            DefaultTableModel tableBuyModel = (DefaultTableModel) BuySeatTable.getModel();
                            tableBuyModel.setRowCount(0);

                            List<JButton> btnList = SeatView50.getSeatButton();
                            for (JButton btn : btnList) {
                                if (btn.getBackground() == Color.YELLOW) {
                                    btn.setBackground(Color.RED);
                                    btn.setForeground(Color.WHITE);
                                }
                            }

                            List<JButton> btnList100 = SeatView100.getSeatButton();
                            for (JButton btn : btnList100) {
                                if (btn.getBackground() == Color.YELLOW) {
                                    btn.setBackground(Color.RED);
                                    btn.setForeground(Color.WHITE);
                                }
                            }

                            DefaultTableModel tableReserved = (DefaultTableModel) selectedTable100.getModel();
                            tableReserved.setRowCount(0);

                            DefaultTableModel tableSelected = (DefaultTableModel) selectedTable50.getModel();
                            tableSelected.setRowCount(0);

                            jpnInfo.setVisible(true);
                            jpnTicketFee.setVisible(true);
                            SeatPanel.setVisible(true);
                            jpnBuyNow.setVisible(true);

                            selectedTab(0);
                            jtbTabEvent.setSelectedIndex(0);
                            selectedTab(0);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error1: " + ex.getMessage());
                        }
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error2: " + ex.getMessage());
            }
        } else {
            customer = CustomerInformationValidate.validateCustomer();
            if (customer.size() == 0) {
                JOptionPane.showConfirmDialog(null, "You are not a customer yet! Please register to buy ticket!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                int newID = CustomerListDAO.getLastID();
                String nameCustomer = fullNameText.getText();
                String phoneNumber = phoneNumberText.getText();
                String email = emailText.getText();

                JFrame frame = new JFrame("Register");
                frame.setContentPane(new NewCustomerEvent(newID + 1));
                NewCustomerEvent.settingForNewCustomer(nameCustomer, phoneNumber, email);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setSize(1050, 550);
            } else {
                Integer totalPrice = Integer.parseInt(totalDisplay.getText().replace(" VND", ""));
                Connection con = UserDatabase.getConnection();
                for (int i = 0; i < BuySeatTable.getRowCount(); i++) {
                    String seatID = BuySeatTable.getValueAt(i, 0).toString();
                    System.out.println(seatID);
                    if (seatID.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please select your seat!");
                        return;
                    } else {
                        try {
                            setSeatID(seatID);
                            List<TicketID> bookedTicket = BookingTicket.bookingTicket();
                            Integer ticketID = bookedTicket.get(0).getTicketID();
                            String sqlTicketBooking = "SELECT MAX(TBK_ID) from ticket_booking";
                            PreparedStatement ps1 = con.prepareStatement(sqlTicketBooking);
                            ResultSet rs = ps1.executeQuery();
                            while (rs.next()) {
                                ticketBookingID = rs.getInt(1) + 1;
                            }
                            try {
                                String sqlInsertReservedSeat = "INSERT INTO ticket_booking (TBK_ID,TBK_TKT_ID, TBK_CUS_ID, TBK_DATETIME, TBT_POINT) VALUES ('" + ticketBookingID + "', '" + ticketID + "', '" + customer.get(0).getCustomerID() + "', '" + java.time.LocalDate.now() + "', '1')";
                                PreparedStatement ps2 = con.prepareStatement(sqlInsertReservedSeat);
                                new Thread(() -> {
                                    try {
                                        Thread.sleep(1000);
                                        SendTicketEmail.sendCodeToEmail(totalPrice, HomePanel.getSelectedStage(), ticketID, Integer.parseInt(seatID), emailText.getText(), getEventName().getText(), fullNameText.getText(), getEventPlace().getText(), getEventTime().getText());
                                    } catch (Exception err) {
                                        System.err.println(err);
                                    }
                                }).start();
                                ps2.executeUpdate();
                                ps2.close();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, ex);
                            }
                            try {
                                String sqlInsertReservedSeat = "insert into reserved_seat (RSV_CUS_ID, RSV_SEAT_ID, RSV_STG_ID, RSV_EVT_ID) values ('" + customer.get(0).getCustomerID() + "', '" + seatID + "' , '" + HomePanel.getSelectedStage() + "', '" + HomePanel.getSelectedEventID() + "')";
                                PreparedStatement ps2 = con.prepareStatement(sqlInsertReservedSeat);
                                ps2.executeUpdate();
                                ps2.close();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                            }
                        } catch (SQLException sql) {
                            JOptionPane.showMessageDialog(null, "Error: " + sql.getMessage());
                        }
                    }
                }
                try {
                    String sqlGetPoint = "Select cus_total_point from customer where cus_id = " + customer.get(0).getCustomerID();
                    PreparedStatement psGetPoint = con.prepareStatement(sqlGetPoint);
                    ResultSet rsGetPoint = psGetPoint.executeQuery();
                    while (rsGetPoint.next()) {
                        Integer previousPoint = rsGetPoint.getInt("cus_total_point");
                        Integer point = totalPrice / 1000;
                        Integer totalPoint = point + previousPoint;
                        String sqlUpdatePoint = "Update customer set cus_total_point = " + totalPoint + " where cus_id = " + customer.get(0).getCustomerID();
                        PreparedStatement ps3 = con.prepareStatement(sqlUpdatePoint);
                        ps3.executeUpdate();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }

                JOptionPane.showMessageDialog(null, "Your ticket has been booked successfully!");
                fullNameText.setText("");
                emailText.setText("");
                phoneNumberText.setText("");

                totalDisplay.setText("0 VND");
                quantityDisplay.setText("0 tickets");

                DefaultTableModel tableBuyModel = (DefaultTableModel) BuySeatTable.getModel();
                tableBuyModel.setRowCount(0);

                jpnInfo.setVisible(true);
                jpnTicketFee.setVisible(true);
                SeatPanel.setVisible(true);
                jpnBuyNow.setVisible(true);

                List<JButton> btnList50 = SeatView50.getSeatButton();
                for (JButton btn : btnList50) {
                    if (btn.getBackground() == Color.YELLOW) {
                        btn.setBackground(Color.RED);
                        btn.setForeground(Color.WHITE);
                    }
                }

                List<JButton> btnList100 = SeatView100.getSeatButton();
                for (JButton btn : btnList100) {
                    if (btn.getBackground() == Color.YELLOW) {
                        btn.setBackground(Color.RED);
                        btn.setForeground(Color.WHITE);
                    }
                }

                DefaultTableModel tableReserved = (DefaultTableModel) selectedTable100.getModel();
                tableReserved.setRowCount(0);

                DefaultTableModel tableSelected = (DefaultTableModel) selectedTable50.getModel();
                tableSelected.setRowCount(0);

                selectedTab(0);
                jtbTabEvent.setSelectedIndex(0);
                selectedTab(0);
            }
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

        private void emailTextFocusLost(FocusEvent e) {
            Connection con = UserDatabase.getConnection();
            String sql = "SELECT CUS_PHONE_NUMBER FROM customer WHERE CUS_EMAIL = '" + emailText.getText().toString() + "' AND CUS_NAME = '" + fullNameText.getText().toString() + "'";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String phoneNumber = resultSet.getString("CUS_PHONE_NUMBER");
                    phoneNumberText.setText(phoneNumber);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }




        private void emailTextKeyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (c== KeyEvent.VK_BACK_SPACE || c== KeyEvent.VK_DELETE) {
                emailText.setText("");
            }
        }

        public static JTable getSelectedTable100() {
            return selectedTable100;
        }

        public static JTable getSelectedTable50() {
            return selectedTable50;
        }

        private void jlbNextButton2MouseClicked(MouseEvent e) {
            Integer quantity = selectedTable100.getRowCount();
            Integer priceList = 0;
            DefaultTableModel tableModel = (DefaultTableModel) selectedTable100.getModel();
            for(int i = 0; i < tableModel.getRowCount(); i++) {
                priceList += Integer.parseInt(tableModel.getValueAt(i, 2).toString());
            }
            jtbTabEvent.setSelectedIndex(5);
            quantityDisplay.setText(String.valueOf(quantity));
            totalDisplay.setText(String.valueOf(priceList) + " VND");
            SeatView100.settingBuySeatTable100();
        }

        public static JTable getBuySeatTable() {
            return BuySeatTable;
        }

        private void fullNameTextFocusLost(FocusEvent e) {
            Connection con = UserDatabase.getConnection();
            count = 0;
            String sql = "select * from customer where cus_name = '" + fullNameText.getText().toString() + "';";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    count++;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            if (count == 1) {
                String sql1 = "select * from customer where cus_name = '" + fullNameText.getText().toString() + "';";
                try {
                    PreparedStatement preparedStatement = con.prepareStatement(sql1);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        String email = resultSet.getString("cus_email");
                        String phoneNumber = resultSet.getString("cus_phone_number");
                        emailText.setText(email);
                        phoneNumberText.setText(phoneNumber);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } else if (count > 1) {
                String sqlselect = "select cus_email from customer where cus_name = '" + fullNameText.getText().toString() + "';";
                try {
                    PreparedStatement preparedStatement = con.prepareStatement(sqlselect);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        String email = resultSet.getString("cus_email");
                        emailText.addItemSuggestion(email);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        private void fullNameTextKeyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (c== KeyEvent.VK_BACK_SPACE || c== KeyEvent.VK_DELETE) {
                fullNameText.setText("");
            }
        }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - man
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
        panel3 = new JPanel();
        jtbTabEvent = new JTabbedPane();
        jpnEventInformation = new JPanel();
        scrollPane1 = new JScrollPane();
        InformationPanel = new JPanel();
        DescriptionText = new JLabel();
        jpnEventTicket = new JPanel();
        ticketFeeScrollPanel = new JScrollPane();
        panel2 = new JPanel();
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
        seatingChartView = new JLabel();
        jpnSeat50 = new JPanel();
        pickTicketScrollPane = new JScrollPane();
        jpnTicket = new JPanel();
        jpnNextButton = new JPanel();
        jlbNextButton = new JLabel();
        label6 = new JLabel();
        seatingChart50 = new SeatView50();
        scrollPane3 = new JScrollPane();
        selectedTable50 = new JTable();
        panel4 = new JPanel();
        label8 = new JLabel();
        label9 = new JLabel();
        panel6 = new JPanel();
        label10 = new JLabel();
        panel7 = new JPanel();
        jpnSeat100 = new JPanel();
        pickTicketScrollPane2 = new JScrollPane();
        jpnTicket2 = new JPanel();
        jpnNextButton2 = new JPanel();
        jlbNextButton2 = new JLabel();
        label7 = new JLabel();
        panel5 = new SeatView100();
        selectedSeat100 = new JScrollPane();
        selectedTable100 = new JTable();
        panel8 = new JPanel();
        label11 = new JLabel();
        label12 = new JLabel();
        panel9 = new JPanel();
        label13 = new JLabel();
        panel10 = new JPanel();
        jpnPayment = new JPanel();
        scrollPane2 = new JScrollPane();
        panel1 = new JPanel();
        JlbInforCus = new JLabel();
        jlbPayment = new JLabel();
        checkBox1 = new JCheckBox();
        checkBox3 = new JCheckBox();
        jpnBack = new JPanel();
        jlbBack = new JLabel();
        jpnNext = new JPanel();
        jlbNext = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        fullNameText = new EventSuggestionTextField();
        emailText = new EventSuggestionTextField();
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
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
        0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
        . BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
        red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
        beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //======== jpnEventHeader ========
        {
            jpnEventHeader.setBackground(Color.white);
            jpnEventHeader.setPreferredSize(new Dimension(1030, 355));

            //---- EventArt ----
            EventArt.setBackground(new Color(0x33ffcc));
            EventArt.setBorder(null);

            //---- EventName ----
            EventName.setText("Event Name");
            EventName.setFont(new Font("Lato Black", Font.BOLD, 22));
            EventName.setForeground(new Color(0x61b884));

            //---- EventTime ----
            EventTime.setText(" Event Time");
            EventTime.setFont(new Font("Lato Black", Font.PLAIN, 18));
            EventTime.setIcon(new ImageIcon(getClass().getResource("/Asset/Icon/alarm-clock.png")));

            //---- EventPlace ----
            EventPlace.setText("Event Place");
            EventPlace.setFont(new Font("Lato Black", Font.PLAIN, 18));
            EventPlace.setIcon(new ImageIcon(getClass().getResource("/Asset/Icon/marker.png")));

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
                        .addComponent(TicketFeeText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                jpnBuyNow.setBackground(new Color(0xd45c5c));
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
                        .addComponent(jlbBuyNow, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                );
                jpnBuyNowLayout.setVerticalGroup(
                    jpnBuyNowLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, jpnBuyNowLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jlbBuyNow, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }

            //======== panel3 ========
            {

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                );
            }

            GroupLayout jpnEventHeaderLayout = new GroupLayout(jpnEventHeader);
            jpnEventHeader.setLayout(jpnEventHeaderLayout);
            jpnEventHeaderLayout.setHorizontalGroup(
                jpnEventHeaderLayout.createParallelGroup()
                    .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jpnEventHeaderLayout.createParallelGroup()
                            .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                                .addComponent(jpnInfo, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jpnTicketFee, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SeatPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(715, Short.MAX_VALUE))
                            .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                                .addComponent(EventArt, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addGroup(jpnEventHeaderLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, jpnEventHeaderLayout.createSequentialGroup()
                                        .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jpnBuyNow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, jpnEventHeaderLayout.createParallelGroup()
                                        .addComponent(EventTime, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(EventName, GroupLayout.PREFERRED_SIZE, 538, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(EventPlace, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)))
                                .addGap(93, 93, 93))))
            );
            jpnEventHeaderLayout.setVerticalGroup(
                jpnEventHeaderLayout.createParallelGroup()
                    .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jpnEventHeaderLayout.createParallelGroup()
                            .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                                .addComponent(EventArt, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(jpnEventHeaderLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpnEventHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jpnTicketFee, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                        .addComponent(jpnInfo, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(SeatPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpnEventHeaderLayout.createSequentialGroup()
                                .addComponent(EventName, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(EventTime, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EventPlace, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(jpnEventHeaderLayout.createParallelGroup()
                                    .addComponent(jpnBuyNow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
            );
        }
        add(jpnEventHeader);
        jpnEventHeader.setBounds(0, 0, 1185, 310);

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

                        //---- DescriptionText ----
                        DescriptionText.setText("Description Event");
                        DescriptionText.setVerticalAlignment(SwingConstants.TOP);
                        DescriptionText.setFont(new Font("Lato", Font.PLAIN, 14));
                        DescriptionText.setBorder(null);

                        GroupLayout InformationPanelLayout = new GroupLayout(InformationPanel);
                        InformationPanel.setLayout(InformationPanelLayout);
                        InformationPanelLayout.setHorizontalGroup(
                            InformationPanelLayout.createParallelGroup()
                                .addGroup(InformationPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(DescriptionText, GroupLayout.PREFERRED_SIZE, 1113, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(563, Short.MAX_VALUE))
                        );
                        InformationPanelLayout.setVerticalGroup(
                            InformationPanelLayout.createParallelGroup()
                                .addGroup(InformationPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(DescriptionText, GroupLayout.PREFERRED_SIZE, 609, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(91, Short.MAX_VALUE))
                        );
                    }
                    scrollPane1.setViewportView(InformationPanel);
                }

                GroupLayout jpnEventInformationLayout = new GroupLayout(jpnEventInformation);
                jpnEventInformation.setLayout(jpnEventInformationLayout);
                jpnEventInformationLayout.setHorizontalGroup(
                    jpnEventInformationLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, jpnEventInformationLayout.createSequentialGroup()
                            .addContainerGap(22, Short.MAX_VALUE)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1172, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
                jpnEventInformationLayout.setVerticalGroup(
                    jpnEventInformationLayout.createParallelGroup()
                        .addGroup(jpnEventInformationLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 523, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(206, Short.MAX_VALUE))
                );
            }
            jtbTabEvent.addTab("text", jpnEventInformation);

            //======== jpnEventTicket ========
            {
                jpnEventTicket.setBackground(Color.white);

                //======== ticketFeeScrollPanel ========
                {
                    ticketFeeScrollPanel.setBorder(null);
                    ticketFeeScrollPanel.setPreferredSize(new Dimension(602, 10021));
                    ticketFeeScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                    //======== panel2 ========
                    {
                        panel2.setBackground(Color.white);

                        //---- ticketType1 ----
                        ticketType1.setText(" text");
                        ticketType1.setIcon(new ImageIcon(getClass().getResource("/Asset/Icon/ticket-alt.png")));
                        ticketType1.setFont(new Font("Lato Black", Font.BOLD, 16));
                        ticketType1.setForeground(new Color(0x61b884));

                        //---- ticketType2 ----
                        ticketType2.setText(" text");
                        ticketType2.setIcon(new ImageIcon(getClass().getResource("/Asset/Icon/ticket-alt.png")));
                        ticketType2.setFont(new Font("Lato Black", Font.BOLD, 16));
                        ticketType2.setForeground(new Color(0x61b884));

                        //---- ticketType3 ----
                        ticketType3.setText(" text");
                        ticketType3.setIcon(new ImageIcon(getClass().getResource("/Asset/Icon/ticket-alt.png")));
                        ticketType3.setFont(new Font("Lato Black", Font.BOLD, 16));
                        ticketType3.setForeground(new Color(0x61b884));

                        //---- ticketType4 ----
                        ticketType4.setText(" text");
                        ticketType4.setIcon(new ImageIcon(getClass().getResource("/Asset/Icon/ticket-alt.png")));
                        ticketType4.setFont(new Font("Lato Black", Font.BOLD, 16));
                        ticketType4.setForeground(new Color(0x61b884));

                        //---- ticketType5 ----
                        ticketType5.setText(" text");
                        ticketType5.setIcon(new ImageIcon(getClass().getResource("/Asset/Icon/ticket-alt.png")));
                        ticketType5.setFont(new Font("Lato Black", Font.BOLD, 16));
                        ticketType5.setForeground(new Color(0x61b884));

                        //---- ticketPrice6 ----
                        ticketPrice6.setText("text");
                        ticketPrice6.setFont(new Font("Lato Black", Font.BOLD, 16));

                        //---- ticketPrice7 ----
                        ticketPrice7.setText("text");
                        ticketPrice7.setFont(new Font("Lato Black", Font.BOLD, 16));

                        //---- ticketPrice8 ----
                        ticketPrice8.setText("text");
                        ticketPrice8.setFont(new Font("Lato Black", Font.BOLD, 16));

                        //---- ticketPrice9 ----
                        ticketPrice9.setText("text");
                        ticketPrice9.setFont(new Font("Lato Black", Font.BOLD, 16));

                        //---- ticketPrice10 ----
                        ticketPrice10.setText("text");
                        ticketPrice10.setFont(new Font("Lato Black", Font.BOLD, 16));

                        GroupLayout panel2Layout = new GroupLayout(panel2);
                        panel2.setLayout(panel2Layout);
                        panel2Layout.setHorizontalGroup(
                            panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(ticketType2, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                        .addComponent(ticketType1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                        .addComponent(ticketType5, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                        .addComponent(ticketType4, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                        .addComponent(ticketType3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(ticketPrice6, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ticketPrice10, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ticketPrice9, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ticketPrice8, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ticketPrice7, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))
                                    .addGap(649, 649, 649))
                        );
                        panel2Layout.setVerticalGroup(
                            panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addComponent(ticketPrice6, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)
                                            .addComponent(ticketPrice7, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)
                                            .addComponent(ticketPrice8, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(ticketPrice9, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(ticketPrice10, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(ticketType1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(18, 18, 18)
                                            .addComponent(ticketType2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)
                                            .addComponent(ticketType3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(ticketType4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(ticketType5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(145, 145, 145))
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
                            .addComponent(ticketFeeScrollPanel, GroupLayout.PREFERRED_SIZE, 1234, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
                jpnEventTicketLayout.setVerticalGroup(
                    jpnEventTicketLayout.createParallelGroup()
                        .addGroup(jpnEventTicketLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(ticketFeeScrollPanel, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(342, Short.MAX_VALUE))
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

                        //---- seatingChartView ----
                        seatingChartView.setText("seatingChartView");

                        GroupLayout seatEventPanelLayout = new GroupLayout(seatEventPanel);
                        seatEventPanel.setLayout(seatEventPanelLayout);
                        seatEventPanelLayout.setHorizontalGroup(
                            seatEventPanelLayout.createParallelGroup()
                                .addGroup(seatEventPanelLayout.createSequentialGroup()
                                    .addGap(231, 231, 231)
                                    .addComponent(seatingChartView, GroupLayout.PREFERRED_SIZE, 675, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(278, Short.MAX_VALUE))
                        );
                        seatEventPanelLayout.setVerticalGroup(
                            seatEventPanelLayout.createParallelGroup()
                                .addGroup(seatEventPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(seatingChartView, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(184, Short.MAX_VALUE))
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
                            .addComponent(seatEventScrollPanel, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(257, Short.MAX_VALUE))
                );
            }
            jtbTabEvent.addTab("text", SeatEvent);

            //======== jpnSeat50 ========
            {
                jpnSeat50.setBackground(Color.white);
                jpnSeat50.setPreferredSize(new Dimension(1025, 1000));

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
                            jlbNextButton.setFont(new Font("Lato Black", Font.BOLD, 16));
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
                                    .addGroup(jpnNextButtonLayout.createSequentialGroup()
                                        .addComponent(jlbNextButton, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                            );
                            jpnNextButtonLayout.setVerticalGroup(
                                jpnNextButtonLayout.createParallelGroup()
                                    .addComponent(jlbNextButton, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            );
                        }

                        //---- label6 ----
                        label6.setText("SEATING CHART");
                        label6.setHorizontalAlignment(SwingConstants.CENTER);
                        label6.setFont(new Font("Lato Black", Font.BOLD, 18));
                        label6.setForeground(new Color(0x61b884));

                        //======== scrollPane3 ========
                        {

                            //---- selectedTable50 ----
                            selectedTable50.setModel(new DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                    "Seat ID", "Type", "Price"
                                }
                            ));
                            scrollPane3.setViewportView(selectedTable50);
                        }

                        //======== panel4 ========
                        {
                            panel4.setBackground(new Color(0xff3333));
                            panel4.setLayout(null);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < panel4.getComponentCount(); i++) {
                                    Rectangle bounds = panel4.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = panel4.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                panel4.setMinimumSize(preferredSize);
                                panel4.setPreferredSize(preferredSize);
                            }
                        }

                        //---- label8 ----
                        label8.setText("Occupied");

                        //---- label9 ----
                        label9.setText("Selected ");

                        //======== panel6 ========
                        {
                            panel6.setBackground(Color.yellow);
                            panel6.setLayout(null);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < panel6.getComponentCount(); i++) {
                                    Rectangle bounds = panel6.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = panel6.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                panel6.setMinimumSize(preferredSize);
                                panel6.setPreferredSize(preferredSize);
                            }
                        }

                        //---- label10 ----
                        label10.setText("Available");

                        //======== panel7 ========
                        {
                            panel7.setBackground(new Color(0x92cfaa));
                            panel7.setLayout(null);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < panel7.getComponentCount(); i++) {
                                    Rectangle bounds = panel7.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = panel7.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                panel7.setMinimumSize(preferredSize);
                                panel7.setPreferredSize(preferredSize);
                            }
                        }

                        GroupLayout jpnTicketLayout = new GroupLayout(jpnTicket);
                        jpnTicket.setLayout(jpnTicketLayout);
                        jpnTicketLayout.setHorizontalGroup(
                            jpnTicketLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, jpnTicketLayout.createSequentialGroup()
                                    .addContainerGap(32, Short.MAX_VALUE)
                                    .addGroup(jpnTicketLayout.createParallelGroup()
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 491, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jpnTicketLayout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(seatingChart50, GroupLayout.PREFERRED_SIZE, 649, GroupLayout.PREFERRED_SIZE)
                                            .addGap(48, 48, 48)
                                            .addGroup(jpnTicketLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jpnNextButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                    .addGap(0, 230, Short.MAX_VALUE))
                                .addGroup(jpnTicketLayout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label8, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(panel6, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label9, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(panel7, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label10, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 727, Short.MAX_VALUE))
                        );
                        jpnTicketLayout.setVerticalGroup(
                            jpnTicketLayout.createParallelGroup()
                                .addGroup(jpnTicketLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label6)
                                    .addGap(28, 28, 28)
                                    .addGroup(jpnTicketLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jpnTicketLayout.createSequentialGroup()
                                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jpnNextButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(seatingChart50, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jpnTicketLayout.createParallelGroup()
                                        .addGroup(jpnTicketLayout.createSequentialGroup()
                                            .addGroup(jpnTicketLayout.createParallelGroup()
                                                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addContainerGap(131, Short.MAX_VALUE))
                                        .addGroup(jpnTicketLayout.createSequentialGroup()
                                            .addGroup(jpnTicketLayout.createParallelGroup()
                                                .addComponent(panel6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(panel7, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                            .addContainerGap(131, Short.MAX_VALUE))))
                        );
                    }
                    pickTicketScrollPane.setViewportView(jpnTicket);
                }

                GroupLayout jpnSeat50Layout = new GroupLayout(jpnSeat50);
                jpnSeat50.setLayout(jpnSeat50Layout);
                jpnSeat50Layout.setHorizontalGroup(
                    jpnSeat50Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, jpnSeat50Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pickTicketScrollPane, GroupLayout.PREFERRED_SIZE, 1199, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
                jpnSeat50Layout.setVerticalGroup(
                    jpnSeat50Layout.createParallelGroup()
                        .addGroup(jpnSeat50Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(pickTicketScrollPane, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(273, Short.MAX_VALUE))
                );
            }
            jtbTabEvent.addTab("text", jpnSeat50);

            //======== jpnSeat100 ========
            {
                jpnSeat100.setBackground(Color.white);

                //======== pickTicketScrollPane2 ========
                {
                    pickTicketScrollPane2.setBackground(Color.white);
                    pickTicketScrollPane2.setBorder(null);

                    //======== jpnTicket2 ========
                    {
                        jpnTicket2.setBackground(Color.white);
                        jpnTicket2.setBorder(null);

                        //======== jpnNextButton2 ========
                        {
                            jpnNextButton2.setBackground(new Color(0x61b884));

                            //---- jlbNextButton2 ----
                            jlbNextButton2.setText("NEXT");
                            jlbNextButton2.setHorizontalAlignment(SwingConstants.CENTER);
                            jlbNextButton2.setBorder(null);
                            jlbNextButton2.setFont(new Font("Lato Black", Font.BOLD, 16));
                            jlbNextButton2.setBackground(new Color(0x61b884));
                            jlbNextButton2.setForeground(Color.white);
                            jlbNextButton2.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    jlbNextButton2MouseClicked(e);
                                }
                            });

                            GroupLayout jpnNextButton2Layout = new GroupLayout(jpnNextButton2);
                            jpnNextButton2.setLayout(jpnNextButton2Layout);
                            jpnNextButton2Layout.setHorizontalGroup(
                                jpnNextButton2Layout.createParallelGroup()
                                    .addGroup(jpnNextButton2Layout.createSequentialGroup()
                                        .addComponent(jlbNextButton2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                            );
                            jpnNextButton2Layout.setVerticalGroup(
                                jpnNextButton2Layout.createParallelGroup()
                                    .addComponent(jlbNextButton2, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            );
                        }

                        //---- label7 ----
                        label7.setText("SEATING CHART");
                        label7.setHorizontalAlignment(SwingConstants.CENTER);
                        label7.setFont(new Font("Lato Black", Font.BOLD, 18));
                        label7.setForeground(new Color(0x61b884));

                        //======== selectedSeat100 ========
                        {

                            //---- selectedTable100 ----
                            selectedTable100.setModel(new DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                    "Seat ID", "Type", "Price"
                                }
                            ));
                            selectedSeat100.setViewportView(selectedTable100);
                        }

                        //======== panel8 ========
                        {
                            panel8.setBackground(new Color(0x92cfaa));
                            panel8.setLayout(null);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < panel8.getComponentCount(); i++) {
                                    Rectangle bounds = panel8.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = panel8.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                panel8.setMinimumSize(preferredSize);
                                panel8.setPreferredSize(preferredSize);
                            }
                        }

                        //---- label11 ----
                        label11.setText("Available");

                        //---- label12 ----
                        label12.setText("Selected ");

                        //======== panel9 ========
                        {
                            panel9.setBackground(Color.yellow);
                            panel9.setLayout(null);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < panel9.getComponentCount(); i++) {
                                    Rectangle bounds = panel9.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = panel9.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                panel9.setMinimumSize(preferredSize);
                                panel9.setPreferredSize(preferredSize);
                            }
                        }

                        //---- label13 ----
                        label13.setText("Occupied");

                        //======== panel10 ========
                        {
                            panel10.setBackground(new Color(0xff3333));
                            panel10.setLayout(null);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < panel10.getComponentCount(); i++) {
                                    Rectangle bounds = panel10.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = panel10.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                panel10.setMinimumSize(preferredSize);
                                panel10.setPreferredSize(preferredSize);
                            }
                        }

                        GroupLayout jpnTicket2Layout = new GroupLayout(jpnTicket2);
                        jpnTicket2.setLayout(jpnTicket2Layout);
                        jpnTicket2Layout.setHorizontalGroup(
                            jpnTicket2Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, jpnTicket2Layout.createSequentialGroup()
                                    .addContainerGap(233, Short.MAX_VALUE)
                                    .addGroup(jpnTicket2Layout.createParallelGroup()
                                        .addGroup(jpnTicket2Layout.createSequentialGroup()
                                            .addComponent(panel10, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(label13, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(panel9, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(label12, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                            .addGap(29, 29, 29)
                                            .addComponent(panel8, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(label11, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                            .addGap(146, 146, 146))
                                        .addComponent(selectedSeat100, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE))
                                    .addGap(74, 74, 74)
                                    .addComponent(jpnNextButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(136, 136, 136))
                                .addGroup(GroupLayout.Alignment.TRAILING, jpnTicket2Layout.createSequentialGroup()
                                    .addContainerGap(75, Short.MAX_VALUE)
                                    .addComponent(panel5, GroupLayout.PREFERRED_SIZE, 1154, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(75, Short.MAX_VALUE))
                                .addGroup(jpnTicket2Layout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 491, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                        jpnTicket2Layout.setVerticalGroup(
                            jpnTicket2Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, jpnTicket2Layout.createSequentialGroup()
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jpnNextButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(133, 133, 133))
                                .addGroup(jpnTicket2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label7)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panel5, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jpnTicket2Layout.createParallelGroup()
                                        .addComponent(panel10, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label13, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panel9, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label12, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panel8, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                    .addComponent(selectedSeat100, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
                        );
                    }
                    pickTicketScrollPane2.setViewportView(jpnTicket2);
                }

                GroupLayout jpnSeat100Layout = new GroupLayout(jpnSeat100);
                jpnSeat100.setLayout(jpnSeat100Layout);
                jpnSeat100Layout.setHorizontalGroup(
                    jpnSeat100Layout.createParallelGroup()
                        .addGroup(jpnSeat100Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, jpnSeat100Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pickTicketScrollPane2, GroupLayout.PREFERRED_SIZE, 1199, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 1200, Short.MAX_VALUE)
                );
                jpnSeat100Layout.setVerticalGroup(
                    jpnSeat100Layout.createParallelGroup()
                        .addGroup(jpnSeat100Layout.createParallelGroup()
                            .addGroup(jpnSeat100Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pickTicketScrollPane2, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(300, Short.MAX_VALUE)))
                        .addGap(0, 735, Short.MAX_VALUE)
                );
            }
            jtbTabEvent.addTab("text", jpnSeat100);

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
                        panel1.setLayout(null);

                        //---- JlbInforCus ----
                        JlbInforCus.setText("CUSTOMER INFORMATION");
                        JlbInforCus.setFont(new Font("Lato Black", Font.BOLD, 18));
                        JlbInforCus.setForeground(new Color(0x61b884));
                        panel1.add(JlbInforCus);
                        JlbInforCus.setBounds(33, 33, 258, 39);

                        //---- jlbPayment ----
                        jlbPayment.setText("PAYMENT METHOD");
                        jlbPayment.setForeground(new Color(0x61b884));
                        jlbPayment.setFont(new Font("Lato Black", Font.BOLD, 18));
                        panel1.add(jlbPayment);
                        jlbPayment.setBounds(33, 189, 513, 46);

                        //---- checkBox1 ----
                        checkBox1.setText("Cash");
                        checkBox1.setFont(new Font("Lato Black", Font.BOLD, 16));
                        checkBox1.setForeground(new Color(0x626262));
                        checkBox1.setBackground(Color.white);
                        checkBox1.addActionListener(e -> {
			checkBox1(e);
			checkBox1(e);
		});
                        panel1.add(checkBox1);
                        checkBox1.setBounds(new Rectangle(new Point(33, 241), checkBox1.getPreferredSize()));

                        //---- checkBox3 ----
                        checkBox3.setText("Payment using MuzicTik Wallet");
                        checkBox3.setForeground(new Color(0x626262));
                        checkBox3.setFont(new Font("Lato Black", Font.BOLD, 16));
                        checkBox3.setBackground(Color.white);
                        checkBox3.addActionListener(e -> checkBox3(e));
                        panel1.add(checkBox3);
                        checkBox3.setBounds(33, 278, 314, checkBox3.getPreferredSize().height);

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
                            jlbBack.setFont(new Font("Lato Black", Font.BOLD, 16));
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
                                    .addComponent(jlbBack, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            );
                        }
                        panel1.add(jpnBack);
                        jpnBack.setBounds(760, 311, jpnBack.getPreferredSize().width, 44);

                        //======== jpnNext ========
                        {
                            jpnNext.setBorder(null);
                            jpnNext.setBackground(new Color(0x61b884));

                            //---- jlbNext ----
                            jlbNext.setText("NEXT");
                            jlbNext.setHorizontalAlignment(SwingConstants.CENTER);
                            jlbNext.setFont(new Font("Lato Black", Font.BOLD, 16));
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
                                    .addGroup(GroupLayout.Alignment.TRAILING, jpnNextLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jlbNext, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
                            );
                            jpnNextLayout.setVerticalGroup(
                                jpnNextLayout.createParallelGroup()
                                    .addComponent(jlbNext, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            );
                        }
                        panel1.add(jpnNext);
                        jpnNext.setBounds(new Rectangle(new Point(954, 311), jpnNext.getPreferredSize()));

                        //---- label3 ----
                        label3.setText("Full Name:");
                        label3.setForeground(new Color(0x626262));
                        label3.setFont(new Font("Lato Black", Font.BOLD, 16));
                        panel1.add(label3);
                        label3.setBounds(new Rectangle(new Point(33, 69), label3.getPreferredSize()));

                        //---- label4 ----
                        label4.setText("Email:");
                        label4.setForeground(new Color(0x626262));
                        label4.setFont(new Font("Lato Black", Font.BOLD, 16));
                        panel1.add(label4);
                        label4.setBounds(new Rectangle(new Point(33, 116), label4.getPreferredSize()));

                        //---- label5 ----
                        label5.setText("Phone Number:");
                        label5.setForeground(new Color(0x626262));
                        label5.setFont(new Font("Lato Black", Font.BOLD, 16));
                        panel1.add(label5);
                        label5.setBounds(new Rectangle(new Point(33, 162), label5.getPreferredSize()));

                        //---- fullNameText ----
                        fullNameText.setFont(new Font("Lato", Font.PLAIN, 16));
                        fullNameText.setForeground(new Color(0x61b884));
                        fullNameText.addFocusListener(new FocusAdapter() {
                            @Override
                            public void focusLost(FocusEvent e) {
                                fullNameTextFocusLost(e);
                            }
                        });
                        fullNameText.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyTyped(KeyEvent e) {
                                fullNameTextKeyTyped(e);
                            }
                        });
                        panel1.add(fullNameText);
                        fullNameText.setBounds(155, 70, 246, 30);

                        //---- emailText ----
                        emailText.setFont(new Font("Lato", Font.PLAIN, 16));
                        emailText.setForeground(new Color(0x61b884));
                        emailText.addFocusListener(new FocusAdapter() {
                            @Override
                            public void focusLost(FocusEvent e) {
                                emailTextFocusLost(e);
                            }
                        });
                        emailText.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyTyped(KeyEvent e) {
                                emailTextKeyTyped(e);
                            }
                        });
                        panel1.add(emailText);
                        emailText.setBounds(155, 115, 246, 29);

                        //---- phoneNumberText ----
                        phoneNumberText.setFont(new Font("Lato", Font.PLAIN, 16));
                        phoneNumberText.setForeground(new Color(0x61b884));
                        panel1.add(phoneNumberText);
                        phoneNumberText.setBounds(157, 160, 246, 29);

                        //---- JlbInforCus2 ----
                        JlbInforCus2.setText("TICKET INFORMATION");
                        JlbInforCus2.setFont(new Font("Lato Black", Font.BOLD, 18));
                        JlbInforCus2.setForeground(new Color(0x61b884));
                        panel1.add(JlbInforCus2);
                        JlbInforCus2.setBounds(555, 33, 224, 39);

                        //---- label1 ----
                        label1.setText("Quantity:");
                        label1.setForeground(new Color(0x61b884));
                        label1.setFont(new Font("Lato Black", Font.BOLD, 16));
                        panel1.add(label1);
                        label1.setBounds(558, 202, 91, label1.getPreferredSize().height);

                        //---- label2 ----
                        label2.setText("Total:");
                        label2.setForeground(new Color(0x61b884));
                        label2.setFont(new Font("Lato Black", Font.BOLD, 16));
                        panel1.add(label2);
                        label2.setBounds(558, 243, 69, 19);

                        //---- totalDisplay ----
                        totalDisplay.setText("text");
                        totalDisplay.setFont(new Font("Lato Black", Font.BOLD, 16));
                        totalDisplay.setForeground(new Color(0x666666));
                        panel1.add(totalDisplay);
                        totalDisplay.setBounds(655, 241, 171, totalDisplay.getPreferredSize().height);

                        //---- quantityDisplay ----
                        quantityDisplay.setText("text");
                        quantityDisplay.setFont(new Font("Lato Black", Font.BOLD, 16));
                        quantityDisplay.setForeground(new Color(0x666666));
                        panel1.add(quantityDisplay);
                        quantityDisplay.setBounds(655, 202, 171, quantityDisplay.getPreferredSize().height);

                        //======== scrollPane4 ========
                        {

                            //---- BuySeatTable ----
                            BuySeatTable.setModel(new DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                    "SeatID", "Seat Type", "Price (VND)"
                                }
                            ));
                            BuySeatTable.setFont(new Font("Lato", Font.PLAIN, 14));
                            scrollPane4.setViewportView(BuySeatTable);
                        }
                        panel1.add(scrollPane4);
                        scrollPane4.setBounds(555, 78, 547, 111);

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < panel1.getComponentCount(); i++) {
                                Rectangle bounds = panel1.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = panel1.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            panel1.setMinimumSize(preferredSize);
                            panel1.setPreferredSize(preferredSize);
                        }
                    }
                    scrollPane2.setViewportView(panel1);
                }

                GroupLayout jpnPaymentLayout = new GroupLayout(jpnPayment);
                jpnPayment.setLayout(jpnPaymentLayout);
                jpnPaymentLayout.setHorizontalGroup(
                    jpnPaymentLayout.createParallelGroup()
                        .addGroup(jpnPaymentLayout.createSequentialGroup()
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 1200, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                );
                jpnPaymentLayout.setVerticalGroup(
                    jpnPaymentLayout.createParallelGroup()
                        .addGroup(jpnPaymentLayout.createSequentialGroup()
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 162, Short.MAX_VALUE))
                );
            }
            jtbTabEvent.addTab("text", jpnPayment);
        }
        add(jtbTabEvent);
        jtbTabEvent.setBounds(-15, 265, 1200, 775);

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
    private JPanel panel3;
    private JTabbedPane jtbTabEvent;
    private JPanel jpnEventInformation;
    private JScrollPane scrollPane1;
    private JPanel InformationPanel;
    private static JLabel DescriptionText;
    private JPanel jpnEventTicket;
    private JScrollPane ticketFeeScrollPanel;
    private JPanel panel2;
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
    private static JLabel seatingChartView;
    private JPanel jpnSeat50;
    private JScrollPane pickTicketScrollPane;
    private static JPanel jpnTicket;
    private JPanel jpnNextButton;
    private JLabel jlbNextButton;
    private JLabel label6;
    private SeatView50 seatingChart50;
    private JScrollPane scrollPane3;
    private static JTable selectedTable50;
    private JPanel panel4;
    private JLabel label8;
    private JLabel label9;
    private JPanel panel6;
    private JLabel label10;
    private JPanel panel7;
    private JPanel jpnSeat100;
    private JScrollPane pickTicketScrollPane2;
    private static JPanel jpnTicket2;
    private JPanel jpnNextButton2;
    private JLabel jlbNextButton2;
    private JLabel label7;
    private SeatView100 panel5;
    private JScrollPane selectedSeat100;
    private static JTable selectedTable100;
    private JPanel panel8;
    private JLabel label11;
    private JLabel label12;
    private JPanel panel9;
    private JLabel label13;
    private JPanel panel10;
    private JPanel jpnPayment;
    private JScrollPane scrollPane2;
    private JPanel panel1;
    private JLabel JlbInforCus;
    private JLabel jlbPayment;
    private JCheckBox checkBox1;
    private JCheckBox checkBox3;
    private JPanel jpnBack;
    private JLabel jlbBack;
    private JPanel jpnNext;
    private JLabel jlbNext;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private static EventSuggestionTextField fullNameText;
    private static EventSuggestionTextField emailText;
    private static JTextField phoneNumberText;
    private JLabel JlbInforCus2;
    private JLabel label1;
    private JLabel label2;
    private JLabel totalDisplay;
    private JLabel quantityDisplay;
    private JScrollPane scrollPane4;
    private static JTable BuySeatTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
