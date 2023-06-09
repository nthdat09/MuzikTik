/*
 * Created by JFormDesigner on Wed Apr 26 20:56:46 ICT 2023
 */

package View.EventListPanel;

import javax.swing.table.*;
import Model.Database.UserDatabase;
import View.EventPage.EventInfor;
import View.MainPage.MainPage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Admin
 */
public class EventListPanel extends JPanel {
    public EventListPanel() {
        initComponents();
        try {
            Connection connection = UserDatabase.getConnection();
            String sql = "SELECT * FROM event";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                    Integer idEvent = resultSet.getInt("EVT_ID");
                    String nameEvent = resultSet.getString("EVT_NAME");
                    String nameArtist = resultSet.getString("EVT_ARTIST");
                    Integer idStage = resultSet.getInt("EVT_STG_ID");
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
                    defaultTableModel1.addRow(new Object[]{idEvent, nameEvent, nameArtist, idStage, openTimeStr, closeTimeStr, dateStr, quantity, description});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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


        EventInfor.getDateTextField().setText(eventListTable.getValueAt(eventListTable.getSelectedRow(), 6).toString());

        EventInfor.getTextQuantity().setText(eventListTable.getValueAt(eventListTable.getSelectedRow(), 7).toString());
        EventInfor.getTextDescription().setText(eventListTable.getValueAt(eventListTable.getSelectedRow(), 8).toString());
        Connection connection = UserDatabase.getConnection();
        String sql = "SELECT EVT_PHOTO FROM event WHERE EVT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(eventListTable.getValueAt(eventListTable.getSelectedRow(), 0).toString()));
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Blob blob = resultSet.getBlob("EVT_PHOTO");
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
        DefaultTableModel defaultTableModel = (DefaultTableModel) eventListTable.getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(defaultTableModel);
        eventListTable.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(jtfSearch.getText().trim()));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - man
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
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;

        //---- label1 ----
        label1.setText("EVENT");
        label1.setFont(new Font("Lato Black", Font.BOLD, 30));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setForeground(new Color(0x61b884));

        //---- jtfSearch ----
        jtfSearch.setText(" Search MuzikTic");
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
                    "Event ID", "Event Name", "Event Artist", "Event Stage ID", "Event Open Time", "Event CloseTime", "Event Date", "Event Quantity", "EventDescription"
                }
            ));
            scrollPane1.setViewportView(eventListTable);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 654, Short.MAX_VALUE)
                            .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(jlbDelete)
                            .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 696, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                            .addGap(432, 432, 432))))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(164, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1021, GroupLayout.PREFERRED_SIZE)
                    .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addGap(2, 2, 2)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbDelete, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
                    .addGap(31, 31, 31)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - man
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
