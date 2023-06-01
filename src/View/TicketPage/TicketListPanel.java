/*
 * Created by JFormDesigner on Wed Apr 26 21:53:33 ICT 2023
 */

package View.TicketPage;

import Controller.TicketPage.TicketPageListener;
import Model.BEAN.Ticket;
import Model.DAO.Ticket.TicketDAO;
import Model.DAO.Ticket.TicketListDAO;
import View.MainPage.MainPage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author Admin
 */
public class TicketListPanel extends JPanel{
    ActionListener ac = new TicketPageListener(this);
    Ticket ticketSelected = new Ticket();
    List<Ticket> listTicket = null;
    String textSearched = "";

    public TicketListPanel() {
        initComponents();
        initMoreSetting();
    }

    public TicketListPanel(List<Ticket> listTicket, String textSearched) {
        initComponents();

        this.listTicket = listTicket;
        setTicketListTable();

        getJlbAdd().addActionListener(ac);
        getJlbEdit().addActionListener(ac);
        getJlbDelete().addActionListener(ac);
        getJlbSearch().addActionListener(ac);

        jtfSearch.setText(textSearched);
    }

    public void initMoreSetting() {
        listTicket = TicketListDAO.getList();

        setTicketListTable();
        jlbAdd.addActionListener(ac);
        jlbEdit.addActionListener(ac);
        jlbDelete.addActionListener(ac);
        jlbSearch.addActionListener(ac);
    }

    public Ticket getDataFromJTable() {
        int i = TicketListTable.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Please choose a ticket to edit");
            return null;
        } else {
            ticketSelected = listTicket.get(i);
            int IDSelected = ticketSelected.getTicketID();
            System.out.println("ID selected: " + IDSelected);
            return ticketSelected;
        }
    }

    public void setTicketListTable() {
        DefaultTableModel tableModel = (DefaultTableModel) getTicketListTable().getModel();
        for (Ticket ticket : listTicket) {
            int TKT_ID = ticket.getTicketID();
            int EVT_ID = ticket.getEventID();
            int STG_ID = ticket.getStageID();
            int SEAT_ID = ticket.getSeatID();
            double TKT_PRICE = ticket.getPrice();
            tableModel.addRow(new Object[]{String.valueOf(TKT_ID), String.valueOf(EVT_ID), String.valueOf(STG_ID), String.valueOf(SEAT_ID), String.valueOf(TKT_PRICE)});
        }
    }

    public void addTicket() {
        System.out.println("addTicket");
        int newID = TicketListDAO.getLastID() + 1;
        MainPage.changeView(new TicketInformationForm(newID).getTicketInformationFormPanel(), MainPage.getJlbTickets(), "Ticket Information Form");
    }

    public void editTicket() {
        System.out.println("editTicket");
        MainPage.changeView(new TicketInformationForm(getDataFromJTable()).getTicketInformationFormPanel(), MainPage.getJlbTickets(), "Ticket Information Form");
    }

    public void deleteTicket() {
        System.out.println("deleteTicket");
        int i = TicketListTable.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete");
        } else {
            ticketSelected = listTicket.get(i);
            int IDSelected = ticketSelected.getTicketID();
            ComfirmTicketDeleteJPopupMenu comfirmTicketDeleteJPopupMenu = new ComfirmTicketDeleteJPopupMenu();
            comfirmTicketDeleteJPopupMenu.setSelectedID(IDSelected);
        }
    }

    public void searchTicket() throws SQLException {
        System.out.println("search Ticket");
        textSearched = jtfSearch.getText();
        listTicket = TicketDAO.getInstance().getTicketList();
        System.out.println("Text input: " + textSearched);
        if (!textSearched.equals("")) {
            System.out.println("Search");
            List<Integer> idResult = new ArrayList<>();

            for (Ticket ticket : listTicket) {
                String ticketCompiled = ticket.getTicketID() + "!@#$" + ticket.getEventID() + "!@#$" + ticket.getStageID() + "!@#$" + ticket.getSeatID() + "!@#$" + ticket.getPrice();

                if (ticketCompiled.contains(textSearched)) {
                    idResult.add(ticket.getTicketID());
                }
            }

            listTicket.clear();
            for (int id : idResult) {
                Ticket ticket = TicketDAO.getInstance().selectByID(id);
                if (ticket != null) {
                    listTicket.add(ticket);
                }
            }
            MainPage.changeView(new TicketListPanel(listTicket, textSearched), MainPage.getJlbTickets(), "Ticket List Panel");
        } else {
            System.out.println("No search");
            MainPage.changeView(new TicketListPanel(), MainPage.getJlbTickets(), "Ticket List Panel");
        }
    }

    public JButton getJlbAdd() {
        return jlbAdd;
    }

    public JButton getJlbEdit() {
        return jlbEdit;
    }

    public JButton getJlbDelete() {
        return jlbDelete;
    }

    public JButton getJlbSearch() {
        return jlbSearch;
    }

    public JTable getTicketListTable() {
        return TicketListTable;
    }

    public JTextField getJtfSearch() {
        return jtfSearch;
    }

    public JLabel getJlbTicket() {
        return jlbTicket;
    }

    public JScrollPane getScrollPane1() {
        return scrollPane1;
    }

    public JPanel getThis() {
        return this;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        jlbTicket = new JLabel();
        scrollPane1 = new JScrollPane();
        TicketListTable = new JTable();
        jtfSearch = new JTextField();
        jlbDelete = new JButton();
        jlbEdit = new JButton();
        jlbAdd = new JButton();
        jlbSearch = new JButton();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
        swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border
        . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
        ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder
        ( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
        .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
        ( ); }} );

        //---- jlbTicket ----
        jlbTicket.setText("TICKET LIST");
        jlbTicket.setHorizontalAlignment(SwingConstants.CENTER);
        jlbTicket.setFont(new Font("Lato Black", Font.BOLD, 25));
        jlbTicket.setForeground(new Color(0x61b884));

        //======== scrollPane1 ========
        {

            //---- TicketListTable ----
            TicketListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "TicketID", "EventID", "SeatID", "StageID", "Ticket Price"
                }
            ));
            scrollPane1.setViewportView(TicketListTable);
        }

        //---- jtfSearch ----
        jtfSearch.setFont(new Font("Lato", Font.PLAIN, 16));
        jtfSearch.setForeground(new Color(0x61b884));
        jtfSearch.setCaretColor(new Color(0x61b884));

        //---- jlbDelete ----
        jlbDelete.setText("DELETE");
        jlbDelete.setFont(new Font("Lato Black", Font.BOLD, 16));
        jlbDelete.setForeground(Color.white);
        jlbDelete.setBackground(new Color(0x61b884));

        //---- jlbEdit ----
        jlbEdit.setText("EDIT");
        jlbEdit.setFont(new Font("Lato Black", Font.BOLD, 16));
        jlbEdit.setForeground(Color.white);
        jlbEdit.setBackground(new Color(0x61b884));

        //---- jlbAdd ----
        jlbAdd.setText("ADD");
        jlbAdd.setFont(new Font("Lato Black", Font.BOLD, 16));
        jlbAdd.setForeground(Color.white);
        jlbAdd.setBackground(new Color(0x61b884));

        //---- jlbSearch ----
        jlbSearch.setText("SEARCH");
        jlbSearch.setFont(new Font("Lato Black", Font.BOLD, 16));
        jlbSearch.setForeground(Color.white);
        jlbSearch.setBackground(new Color(0x61b884));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(418, 418, 418)
                            .addComponent(jlbTicket))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 896, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                    .addGap(287, 287, 287)
                                    .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(jlbDelete)))))
                    .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jlbTicket)
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbDelete, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(39, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
    private JLabel jlbTicket;
    private JScrollPane scrollPane1;
    private JTable TicketListTable;
    private JTextField jtfSearch;
    private JButton jlbDelete;
    private JButton jlbEdit;
    private JButton jlbAdd;
    private JButton jlbSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

