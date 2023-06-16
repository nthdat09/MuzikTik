package Model.BEAN.Event;

import Model.Database.UserDatabase;
import View.EventPage.EventPanel;
import View.Home.HomePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatView100 extends JPanel {
    static List<JButton> seatButton100 = new ArrayList<>();
    List<Integer> reservedSeatList = new ArrayList<>();


    static List<Integer> selectedSeat100 = new ArrayList<>();
    static Integer priceList100 = 0;

    private static Integer eventId;
    private static Integer eventStageId;
    public SeatView100() {
        this.setBackground(Color.white);
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        this.setLayout(gridBagLayout);

        for(int i=0; i<=9; i++) {
            for(int j = 0; j<=1; j++) {
                gridBagConstraints.gridx = j;
                gridBagConstraints.gridy = i;
                if (j == 1) {
                    gridBagConstraints.insets.right = 30;
                    this.add(new JButton(), gridBagConstraints);
                } else {
                    gridBagConstraints.insets.right = 0;
                    this.add(new JButton(), gridBagConstraints);
                }
            }
        }

        for(int i=0; i<=9;i++) {
            for(int j=2; j<=7;j++) {
                gridBagConstraints.gridx = j;
                gridBagConstraints.gridy = i;
                if(j == 2) {
                    gridBagConstraints.insets.right = 0;
                    this.add(new JButton(), gridBagConstraints);
                } else if (j == 7) {
                    gridBagConstraints.insets.right = 30;
                    this.add(new JButton(), gridBagConstraints);
                } else {
                    this.add(new JButton(), gridBagConstraints);
                }
            }
        }

        for(int i=0; i<=9; i++) {
            for(int j = 8; j<=9; j++) {
                gridBagConstraints.gridx = j;
                gridBagConstraints.gridy = i;
                if(j == 8) {
                    gridBagConstraints.insets.right = 0;
                    this.add(new JButton(), gridBagConstraints);
                } else {
                    this.add(new JButton(), gridBagConstraints);
                }
            }
        }
        seatButton100.removeAll(seatButton100);
        for (int i = 0; i < 100; i++) {
            seatButton100.add((JButton) this.getComponent(i));
        }
        for(int i = 0; i < seatButton100.size(); i++){
            seatButton100.get(i).setBackground(Color.decode("#92CFAA"));
            seatButton100.get(i).setForeground(Color.WHITE);
        }


        for (int i = 0; i < seatButton100.size(); i++) {
            seatButton100.get(i).setText(String.valueOf(i + 1));
        }
        getReservedSeat();

        for(int i = 0 ; i < reservedSeatList.size(); i++) {
            for(int j = 0; j < seatButton100.size(); j++) {
                if(seatButton100.get(j).getText().equals(String.valueOf(reservedSeatList.get(i)))) {
                    seatButton100.get(j).setBackground(Color.RED);
                    seatButton100.get(j).setForeground(Color.WHITE);
                }
            }
        }
        getInformation();

        for(JButton button : seatButton100) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        if (button.getBackground().equals(Color.decode("#92CFAA"))) {
                            button.setBackground(Color.YELLOW);
                            button.setForeground(Color.BLACK);
                            Integer seatID = Integer.parseInt(button.getText());
                            Connection connection = UserDatabase.getConnection();
                            String sql = "select seat_id, seat_type, tkt_price from seat join ticket t on seat.SEAT_ID = t.TKT_SEAT_ID and seat.SEAT_STG_ID = t.TKT_STG_ID join event e on t.TKT_EVT_ID = e.EVT_ID where seat_id = " + seatID + " and SEAT_STG_ID= " + eventStageId + " and EVT_ID = "+ eventId +";";
                            try {
                                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                                ResultSet resultSet = preparedStatement.executeQuery();
                                while(resultSet.next()) {
                                    String tbData[] = {String.valueOf(resultSet.getInt("seat_id")), resultSet.getString("seat_type"), String.valueOf(resultSet.getInt("tkt_price"))};
                                    DefaultTableModel tableModel = (DefaultTableModel) EventPanel.getSelectedTable100().getModel();
                                    tableModel.addRow(tbData);
                                    break;
                                }
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        } else if (button.getBackground().equals(Color.YELLOW)) {
                            button.setBackground(Color.decode("#92CFAA"));
                            button.setForeground(Color.WHITE);
                            boolean found = false;
                            int rowRemove = 0;
                            for (int row = 0; row < EventPanel.getSelectedTable100().getRowCount(); row++) {
                                for (int col = 0; col < EventPanel.getSelectedTable100().getColumnCount(); col++) {
                                    Object cellValue = EventPanel.getSelectedTable100().getValueAt(row, col);
                                    if (cellValue != null && cellValue.toString().contains(button.getText().toString())) {
                                        EventPanel.getSelectedTable100().setRowSelectionInterval(row, row);
                                        EventPanel.getSelectedTable100().setColumnSelectionInterval(col, col);
                                        found = true;
                                        rowRemove = row;
                                        break;
                                    }
                                }
                                if (found) {
                                    break;
                                }
                            }
                            DefaultTableModel tableModel = (DefaultTableModel) EventPanel.getSelectedTable100().getModel();
                            tableModel.removeRow(rowRemove);
                        }
                    }
            });
        }
    }

    public static void settingBuySeatTable100() {
        DefaultTableModel tableBuy = (DefaultTableModel) EventPanel.getBuySeatTable().getModel();
        DefaultTableModel table100 = (DefaultTableModel) EventPanel.getSelectedTable100().getModel();
        for(int i = 0; i < table100.getRowCount(); i++) {
            String tbData[] = {table100.getValueAt(i, 0).toString(), table100.getValueAt(i, 1).toString(), table100.getValueAt(i, 2).toString()};
            tableBuy.addRow(tbData);
        }
    }


    public void getReservedSeat() {
        Connection connection = UserDatabase.getConnection();
        String sql = "SELECT RSV_SEAT_ID\n" +
                "FROM reserved_seat join event e on reserved_seat.RSV_EVT_ID = e.EVT_ID\n" +
                "WHERE EVT_NAME = '" + HomePanel.getSelectedEvent() +"';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                reservedSeatList.add(resultSet.getInt("RSV_SEAT_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getSelectedSeatAndPrice() {
        for(JButton button : seatButton100) {
            if(button.getBackground().equals(Color.YELLOW)) {
                selectedSeat100.add(Integer.parseInt(button.getText()));
            }
        }

        DefaultTableModel tableModel = (DefaultTableModel) EventPanel.getSelectedTable100().getModel();
        for(int i = 0; i < tableModel.getRowCount(); i++) {
            priceList100 += Integer.parseInt(tableModel.getValueAt(i, 2).toString());
        }
    }

    public static void settingBuySeatTable() {
        DefaultTableModel tableBuy = (DefaultTableModel) EventPanel.getBuySeatTable().getModel();
        DefaultTableModel table100 = (DefaultTableModel) EventPanel.getSelectedTable100().getModel();
        for(int i = 0; i < table100.getRowCount(); i++) {
            String tbData[] = {table100.getValueAt(i, 0).toString(), table100.getValueAt(i, 1).toString(), table100.getValueAt(i, 2).toString()};
            tableBuy.addRow(tbData);
        }
    }

    private void getInformation() {
        Connection connection = UserDatabase.getConnection();
        try {
            String sql = "select * from event where evt_name = '" + HomePanel.getSelectedEvent() + "';";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                eventId = resultSet.getInt("evt_id");
                eventStageId = resultSet.getInt("evt_stg_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Integer getPriceList() {
        return priceList100;
    }

    public static List<Integer> getSeatList() {
        return selectedSeat100;
    }

    public static List<JButton> getSeatButton() {
        return seatButton100;
    }
}
