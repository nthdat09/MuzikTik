package Model.BEAN.Event;

import Model.Database.UserDatabase;
import View.EventPage.EventPanel;
import View.Home.HomePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SeatView50 extends JPanel {
    List<Integer> reversedSeatList = new ArrayList<>();
    static List<JButton> seatButton = new ArrayList<>();
    static List<Integer> selectedSeat = new ArrayList<>();
    static Integer priceList = 0;
    private Integer eventId;
    private Integer eventStageId;
    public SeatView50() {
        this.setBackground(Color.WHITE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        this.setLayout(gridBagLayout);

        JButton btn = new JButton("1");
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        this.add(btn, gridBagConstraints);

        JButton btn2 = new JButton("2");
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets.right = 30;
        this.add(btn2, gridBagConstraints);

        JButton btn3 = new JButton("3");
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets.right = 0;
        this.add(btn3, gridBagConstraints);

        JButton btn4 = new JButton();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        this.add(btn4, gridBagConstraints);

        JButton btn5 = new JButton();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        this.add(btn5, gridBagConstraints);

        JButton btn6 = new JButton();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        this.add(btn6, gridBagConstraints);

        JButton btn7 = new JButton();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets.right = 30;
        this.add(btn7, gridBagConstraints);

        JButton btn8 = new JButton();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets.right = 0;
        this.add(btn8, gridBagConstraints);

        JButton btn31 = new JButton();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        this.add(btn31, gridBagConstraints);


        JButton btn10 = new JButton();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        this.add(btn10, gridBagConstraints);

        JButton btn11 = new JButton();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        this.add(btn11, gridBagConstraints);

        JButton btn12 = new JButton();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        this.add(btn12, gridBagConstraints);

        JButton btn13 = new JButton();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        this.add(btn13, gridBagConstraints);

        JButton btn14 = new JButton();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        this.add(btn14, gridBagConstraints);

        JButton btn15 = new JButton();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets.right = 30;
        this.add(btn15, gridBagConstraints);

        JButton btn16 = new JButton();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets.right = 0;
        this.add(btn16, gridBagConstraints);

        JButton btn30 = new JButton();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        this.add(btn30, gridBagConstraints);

        JButton btn17 = new JButton();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        this.add(btn17, gridBagConstraints);

        JButton btn18 = new JButton();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 2;
        this.add(btn18, gridBagConstraints);

        JButton btn19 = new JButton();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 2;
        this.add(btn19, gridBagConstraints);

        JButton btn20 = new JButton();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        this.add(btn20, gridBagConstraints);

        JButton btn21 = new JButton();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        this.add(btn21, gridBagConstraints);

        JButton btn22 = new JButton();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        this.add(btn22, gridBagConstraints);

        JButton btn23 = new JButton();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        this.add(btn23, gridBagConstraints);

        JButton btn24 = new JButton();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets.right = 30;
        this.add(btn24, gridBagConstraints);

        JButton btn25 = new JButton();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets.right = 0;
        this.add(btn25, gridBagConstraints);

        JButton btn26 = new JButton();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        this.add(btn26, gridBagConstraints);

        JButton btn27 = new JButton();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 3;
        this.add(btn27, gridBagConstraints);

        JButton btn28 = new JButton();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 3;
        this.add(btn28, gridBagConstraints);

        JButton btn29 = new JButton();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 3;
        this.add(btn29, gridBagConstraints);

        JButton btn32 = new JButton();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        this.add(btn32, gridBagConstraints);

        JButton btn33 = new JButton();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        this.add(btn33, gridBagConstraints);

        JButton btn34 = new JButton();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        this.add(btn34, gridBagConstraints);

        JButton btn35 = new JButton();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        this.add(btn35, gridBagConstraints);

        JButton btn36 = new JButton();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets.right = 30;
        this.add(btn36, gridBagConstraints);

        JButton btn37 = new JButton();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets.right = 0;
        this.add(btn37, gridBagConstraints);

        JButton btn38 = new JButton();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        this.add(btn38, gridBagConstraints);

        JButton btn39 = new JButton();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        this.add(btn39, gridBagConstraints);

        JButton btn40 = new JButton();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 4;
        this.add(btn40, gridBagConstraints);

        JButton btn41 = new JButton();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 4;
        this.add(btn41, gridBagConstraints);

        JButton btn42 = new JButton();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        this.add(btn42, gridBagConstraints);

        JButton btn43 = new JButton();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        this.add(btn43, gridBagConstraints);

        JButton btn44 = new JButton();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        this.add(btn44, gridBagConstraints);

        JButton btn45 = new JButton();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        this.add(btn45, gridBagConstraints);

        JButton btn46 = new JButton();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets.right = 30;
        this.add(btn46, gridBagConstraints);

        JButton btn47 = new JButton();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets.right = 0;
        this.add(btn47, gridBagConstraints);

        JButton btn48 = new JButton();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 5;
        this.add(btn48, gridBagConstraints);

        JButton btn49 = new JButton();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        this.add(btn49, gridBagConstraints);

        JButton btn50 = new JButton();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 5;
        this.add(btn50, gridBagConstraints);

        JButton btn51 = new JButton();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 5;
        this.add(btn51, gridBagConstraints);
        seatButton.removeAll(seatButton);
        for (int i = 0; i < 50; i++) {
            seatButton.add((JButton) this.getComponent(i));
        }

        getReservedSeat();
        for(int i = 0; i < seatButton.size(); i++){
            seatButton.get(i).setBackground(Color.decode("#92CFAA"));
            seatButton.get(i).setForeground(Color.WHITE);
        }


        for (int i = 0; i < seatButton.size(); i++) {
            seatButton.get(i).setText(String.valueOf(i + 1));
        }

        for(int i = 0 ; i < reversedSeatList.size(); i++) {
            for(int j = 0; j < seatButton.size(); j++) {
                if(seatButton.get(j).getText().equals(String.valueOf(reversedSeatList.get(i)))) {
                    seatButton.get(j).setBackground(Color.decode("#d45c5c"));
                    seatButton.get(j).setForeground(Color.WHITE);
                }
            }
        }

        getInformation();

        for (JButton button : seatButton) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (button.getBackground().equals(Color.decode("#92CFAA"))) {
                        button.setBackground(Color.decode("#fff9aa"));
                        button.setForeground(Color.BLACK);
                        Integer seatID = Integer.parseInt(button.getText());
                        Connection connection = UserDatabase.getConnection();
                        String sql = "select seat_id, seat_type, tkt_price from seat join ticket t on seat.SEAT_ID = t.TKT_SEAT_ID and seat.SEAT_STG_ID = t.TKT_STG_ID join event e on t.TKT_EVT_ID = e.EVT_ID where seat_id = " + seatID + " and SEAT_STG_ID= " + eventStageId + " and EVT_ID = "+ eventId +";";
                        try {
                            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                            ResultSet resultSet = preparedStatement.executeQuery();
                            while(resultSet.next()) {
                                String tbData[] = {String.valueOf(resultSet.getInt("seat_id")), resultSet.getString("seat_type"), String.valueOf(resultSet.getInt("tkt_price"))};
                                DefaultTableModel tableModel = (DefaultTableModel) EventPanel.getSelectedTable50().getModel();
                                tableModel.addRow(tbData);
                                break;
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    } else if (button.getBackground().equals(Color.decode("#fff9aa"))) {
                        button.setBackground(Color.decode("#92CFAA"));
                        button.setForeground(Color.WHITE);
                        boolean found = false;
                        int rowRemove = 0;
                        for (int row = 0; row < EventPanel.getSelectedTable50().getRowCount(); row++) {
                            for (int col = 0; col < EventPanel.getSelectedTable50().getColumnCount(); col++) {
                                Object cellValue = EventPanel.getSelectedTable50().getValueAt(row, col);
                                if (cellValue != null && cellValue.toString().contains(button.getText().toString())) {
                                    EventPanel.getSelectedTable50().setRowSelectionInterval(row, row);
                                    EventPanel.getSelectedTable50().setColumnSelectionInterval(col, col);
                                    found = true;
                                    rowRemove = row;
                                    break;
                                }
                            }
                            if (found) {
                                break;
                            }
                        }
                        DefaultTableModel tableModel = (DefaultTableModel) EventPanel.getSelectedTable50().getModel();
                        tableModel.removeRow(rowRemove);
                    }
                }
            });
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
                reversedSeatList.add(resultSet.getInt("RSV_SEAT_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getSelectedSeatAndPrice() {
        for(JButton button : seatButton) {
            if(button.getBackground().equals(Color.decode("#fff9aa"))) {
                selectedSeat.add(Integer.parseInt(button.getText()));
            }
        }

        DefaultTableModel tableModel = (DefaultTableModel) EventPanel.getSelectedTable50().getModel();
        for(int i = 0; i < tableModel.getRowCount(); i++) {
            priceList += Integer.parseInt(tableModel.getValueAt(i, 2).toString());
        }
    }

    public static void settingBuySeatTable() {
        DefaultTableModel tableBuy = (DefaultTableModel) EventPanel.getBuySeatTable().getModel();
        DefaultTableModel table50 = (DefaultTableModel) EventPanel.getSelectedTable50().getModel();
        for(int i = 0; i < table50.getRowCount(); i++) {
            String tbData[] = {table50.getValueAt(i, 0).toString(), table50.getValueAt(i, 1).toString(), table50.getValueAt(i, 2).toString()};
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
        return priceList;
    }

    public static List<Integer> getSeatList() {
        return selectedSeat;
    }

    public static List<JButton> getSeatButton() {
        return seatButton;
    }
}
