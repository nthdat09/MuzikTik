/*
 * Created by JFormDesigner on Wed Apr 26 20:56:46 ICT 2023
 */

package View.EventListPanel;

import Model.Database.UserDatabase;
import View.EventPage.EventInfor;
import View.MainPage.MainPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * @author Admin
 */
public class EventListPanel extends JPanel {
    public EventListPanel() {
        initComponents();
        try {
            Connection connection = UserDatabase.getConnection();
            String sql = "SELECT EVT_ID, EVT_NAME, EVT_ARTIST, STG_NAME, EVT_DATE, EVT_OPEN_TIME, EVT_END_TIME, EVT_QUANTITY, EVT_DESCRIPTION\n" +
                    "FROM EVENT e, STAGE s\n" +
                    "WHERE e.EVT_STG_ID = s.STG_ID;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                    Integer idEvent = resultSet.getInt("EVT_ID");
                    String nameEvent = resultSet.getString("EVT_NAME");
                    String nameArtist = resultSet.getString("EVT_ARTIST");
                    String nameStage = resultSet.getString("STG_NAME");
                    Time openTime = resultSet.getTime("EVT_OPEN_TIME");
                    Time closeTime = resultSet.getTime("EVT_END_TIME");
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String openTimeStr = sdf.format(openTime);
                    String closeTimeStr = sdf.format(closeTime);

                    Date date = resultSet.getDate("EVT_DATE");
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
                    String dateStr = sdf1.format(date);

                    Integer quantity = resultSet.getInt("EVT_QUANTITY");


                    String description = resultSet.getString("EVT_DESCRIPTION");
                    DefaultTableModel defaultTableModel1 = (DefaultTableModel) eventListTable.getModel();
                    defaultTableModel1.addRow(new Object[]{idEvent, nameEvent, nameArtist, nameStage, openTimeStr, closeTimeStr, dateStr, quantity, description});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setColor();
    }

    private void jlbAddMouseClicked(MouseEvent e) {
        MainPage.changeView(new EventInfor(), MainPage.getJlbEvent(), "EventInfor");
    }

    private void jlbEditMouseClicked(MouseEvent e) {
        if(eventListTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a event to edit");
            return;
        }
        MainPage.changeView(new EventInfor(), MainPage.getJlbEvent(), "EventInfor");
        EventInfor.getTextID().setText(eventListTable.getValueAt(eventListTable.getSelectedRow(), 0).toString());
        EventInfor.getTextName().setText(eventListTable.getValueAt(eventListTable.getSelectedRow(), 1).toString());
        EventInfor.getTextArtist().setText(eventListTable.getValueAt(eventListTable.getSelectedRow(), 2).toString());

        EventInfor.getOpen_Hour().setModel(new SpinnerNumberModel(Integer.parseInt(eventListTable.getValueAt(eventListTable.getSelectedRow(), 4).toString().split(":")[0]), 0, 23, 1));
        EventInfor.getOpen_Minute().setModel(new SpinnerNumberModel(Integer.parseInt(eventListTable.getValueAt(eventListTable.getSelectedRow(), 4).toString().split(":")[1]), 0, 59, 1));
        EventInfor.getOpen_Second().setModel(new SpinnerNumberModel(Integer.parseInt(eventListTable.getValueAt(eventListTable.getSelectedRow(), 4).toString().split(":")[2]), 0, 59, 1));

        EventInfor.getClose_Hour().setModel(new SpinnerNumberModel(Integer.parseInt(eventListTable.getValueAt(eventListTable.getSelectedRow(), 5).toString().split(":")[0]), 0, 23, 1));
        EventInfor.getClose_Minute().setModel(new SpinnerNumberModel(Integer.parseInt(eventListTable.getValueAt(eventListTable.getSelectedRow(), 5).toString().split(":")[1]), 0, 59, 1));
        EventInfor.getClose_Second().setModel(new SpinnerNumberModel(Integer.parseInt(eventListTable.getValueAt(eventListTable.getSelectedRow(), 5).toString().split(":")[2]), 0, 59, 1));

        EventInfor.getStageComboBox().setSelectedItem(eventListTable.getValueAt(eventListTable.getSelectedRow(), 3).toString());
        EventInfor.getDateTextField().setText(eventListTable.getValueAt(eventListTable.getSelectedRow(), 6).toString());

        EventInfor.getTextQuantity().setText(eventListTable.getValueAt(eventListTable.getSelectedRow(), 7).toString());
        EventInfor.getTextDescription().setText(eventListTable.getValueAt(eventListTable.getSelectedRow(), 8).toString());
        Connection connection = UserDatabase.getConnection();
        String sql = "SELECT EVT_POSTER FROM event WHERE EVT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(eventListTable.getValueAt(eventListTable.getSelectedRow(), 0).toString()));
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Blob blob = resultSet.getBlob("EVT_POSTER");
                EventInfor.getTextPoster().setIcon(new ImageIcon(blob.getBytes(1, (int) blob.length())));
                EventInfor.setEvent_Image(blob.getBytes(1, (int) blob.length()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void jlbDeleteMouseClicked(MouseEvent e) {
        if(eventListTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a event to delete");
            return;
        }
        JOptionPane.showConfirmDialog(null, "Are you sure to delete this event?", "Delete", JOptionPane.YES_NO_OPTION);
        if(JOptionPane.YES_OPTION == 0) {
            deleteEvent();
        }
    }

    private void deleteEvent() {
        Integer idSelectedToDelete = Integer.parseInt(eventListTable.getValueAt(eventListTable.getSelectedRow(), 0).toString());
        Connection connection = UserDatabase.getConnection();
        String sql = "DELETE FROM event WHERE EVT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idSelectedToDelete);
            preparedStatement.executeUpdate();
            DefaultTableModel defaultTableModel = (DefaultTableModel) eventListTable.getModel();
            defaultTableModel.removeRow(eventListTable.getSelectedRow());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void jlbSearchMouseClicked(MouseEvent e) {
        String search = jtfSearch.getText();
        if(search.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter something to search");
            return;
        } else {
            DefaultTableModel defaultTableModel = (DefaultTableModel) eventListTable.getModel();
            TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(defaultTableModel);
            eventListTable.setRowSorter(tableRowSorter);
            tableRowSorter.setRowFilter(RowFilter.regexFilter(search));
        }
    }

    public void setColor() {
        getEventListTable().getTableHeader().setBackground(Color.white);
        getEventListTable().getTableHeader().setForeground(Color.decode("#61b884"));
        getEventListTable().getTableHeader().setFont(new Font("Lato Black", Font.BOLD, 16));
        getEventListTable().setRowHeight(20);
        getEventListTable().getColumnModel().getColumn(0).setPreferredWidth(10);
        getEventListTable().getColumnModel().getColumn(2).setPreferredWidth(100);
        getEventListTable().getColumnModel().getColumn(3).setPreferredWidth(100);
        getEventListTable().getColumnModel().getColumn(4).setPreferredWidth(30);
        getEventListTable().getColumnModel().getColumn(5).setPreferredWidth(50);
        getEventListTable().getColumnModel().getColumn(6).setPreferredWidth(45);
        getEventListTable().getColumnModel().getColumn(7).setPreferredWidth(45);
        getEventListTable().getColumnModel().getColumn(1).setPreferredWidth(200);
        getEventListTable().setForeground(Color.DARK_GRAY);
        getEventListTable().setFont(new Font("Lato",Font.PLAIN, 14));
    }

    public JTable getEventListTable() {
        return eventListTable;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
        label1 = new JLabel();
        jtfSearch = new JTextField();
        jlbDelete = new JButton();
        jlbEdit = new JButton();
        jlbAdd = new JButton();
        jlbSearch = new JButton();
        scrollPane1 = new JScrollPane();
        eventListTable = new JTable();

        //======== this ========
        setBackground(Color.white);
        setForeground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
        , 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
         getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- label1 ----
        label1.setText("EVENT INFORMATION LIST");
        label1.setFont(new Font("Lato Black", Font.BOLD, 25));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setForeground(new Color(0x61b884));

        //---- jtfSearch ----
        jtfSearch.setFont(new Font("Lato", Font.PLAIN, 16));
        jtfSearch.setForeground(new Color(0x61b884));
        jtfSearch.setCaretColor(new Color(0x61b884));

        //---- jlbDelete ----
        jlbDelete.setText("DELETE");
        jlbDelete.setFont(new Font("Lato Black", Font.BOLD, 16));
        jlbDelete.setForeground(Color.white);
        jlbDelete.setBackground(new Color(0x61b884));
        jlbDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jlbDeleteMouseClicked(e);
            }
        });

        //---- jlbEdit ----
        jlbEdit.setText("EDIT");
        jlbEdit.setFont(new Font("Lato Black", Font.BOLD, 16));
        jlbEdit.setForeground(Color.white);
        jlbEdit.setBackground(new Color(0x61b884));
        jlbEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jlbEditMouseClicked(e);
            }
        });

        //---- jlbAdd ----
        jlbAdd.setText("ADD ");
        jlbAdd.setFont(new Font("Lato Black", Font.BOLD, 16));
        jlbAdd.setForeground(Color.white);
        jlbAdd.setBackground(new Color(0x61b884));
        jlbAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jlbAddMouseClicked(e);
            }
        });

        //---- jlbSearch ----
        jlbSearch.setText("SEARCH");
        jlbSearch.setFont(new Font("Lato Black", Font.BOLD, 16));
        jlbSearch.setForeground(Color.white);
        jlbSearch.setBackground(new Color(0x61b884));
        jlbSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jlbSearchMouseClicked(e);
            }
        });

        //======== scrollPane1 ========
        {

            //---- eventListTable ----
            eventListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "ID", "Name", "Artist", "Stage Name", "Open Time", "Close Time", "Date", "Quantity", "Description"
                }
            ));
            {
                TableColumnModel cm = eventListTable.getColumnModel();
                cm.getColumn(0).setMinWidth(20);
                cm.getColumn(4).setMinWidth(100);
            }
            eventListTable.setFont(new Font("Lato", Font.PLAIN, 13));
            eventListTable.setGridColor(Color.lightGray);
            eventListTable.setSelectionBackground(new Color(0x61b884));
            eventListTable.setSelectionForeground(Color.white);
            eventListTable.setPreferredScrollableViewportSize(new Dimension(300, 400));
            eventListTable.setMinimumSize(new Dimension(100, 16));
            scrollPane1.setViewportView(eventListTable);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1303, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 663, Short.MAX_VALUE)
                                    .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlbDelete)
                                    .addGap(24, 24, 24))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(192, 192, 192)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlbDelete, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
    private JLabel label1;
    private JTextField jtfSearch;
    private JButton jlbDelete;
    private JButton jlbEdit;
    private JButton jlbAdd;
    private JButton jlbSearch;
    private JScrollPane scrollPane1;
    private JTable eventListTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
