/*
 * Created by JFormDesigner on Thu Apr 27 12:00:43 ICT 2023
 */

package View.CustomersListPage;

import java.awt.event.*;
import Controller.CustomerPanel.CustomerListListener;
import Model.BEAN.Customer.Customer;
import Model.BEAN.Seat.Seat;
import Model.BEAN.TicketBooking.TicketBooking;
import Model.DAO.Customer.CustomerDAO;
import Model.DAO.Customer.CustomerListDAO;
import Model.DAO.Seat.SeatDAO;
import Model.DAO.Ticket_Booking.TicketBookingDAO;
import View.MainPage.MainPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ADMIN
 */
public class CustomersListPanel extends JPanel{
    ActionListener ac = new CustomerListListener(this);
    Customer customerSelected = new Customer();
    String textSearched = "";
    List <Customer> listCustomer = null;

    public CustomersListPanel() {
        initComponents();
        initMoreSetting();
    }

    public CustomersListPanel(List<Customer> listCustomerP, String textSearched){
        initComponents();
        this.listCustomer = listCustomerP;
        setCustomerListTable();
        getJlbAdd().addActionListener(ac);
        getJlbEdit().addActionListener(ac);
        getJlbDelete().addActionListener(ac);
        getJlbSearch().addActionListener(ac);
        jtfSearch.setText(textSearched);
    }

    public void initMoreSetting(){
        listCustomer = CustomerListDAO.getCustomerList();
        setCustomerListTable();
        setColor();
        getJlbAdd().addActionListener(ac);
        getJlbEdit().addActionListener(ac);
        getJlbDelete().addActionListener(ac);
        getJlbSearch().addActionListener(ac);
    }

    public Customer getDataFromJTable(){
        int i = CustomerListTable.getSelectedRow();
        if (i == -1){
            JOptionPane.showMessageDialog(null, "Please choose a customer to edit");
            return null;
        }
        else {
            customerSelected = listCustomer.get(i);
            int IDSelected = customerSelected.getId();
            System.out.println("ID selected: " + IDSelected);
            return customerSelected;
        }
    }


    public JTable getCustomerListTable() {
        return CustomerListTable;
    }

    public JPanel getThis() {
        return this;
    }

    public JButton getJlbDelete() {
        return jlbDelete;
    }

    public JButton getJlbEdit() {
        return jlbEdit;
    }

    public JButton getJlbAdd() {
        return jlbAdd;
    }

    public JButton getJlbSearch() {
        return jlbSearch;
    }

    public JScrollPane getScrollPane1() {
        return scrollPane1;
    }

    public JLabel getTextField1() {
        return textField1;
    }

    public JTextField getJtfSearch() {
        return jtfSearch;
    }

    private void CustomerListTableMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
            ShowPurchasedHistory(e);
        }
    }

    private void ShowPurchasedHistory(MouseEvent e) {
        int index = CustomerListTable.getSelectedRow();
        TableModel model = CustomerListTable.getModel();

        String id = model.getValueAt(index, 0).toString();

        List<TicketBooking> purchasedTicket = TicketBookingDAO.getTicketByCustomerID(Integer.parseInt(id));
        List<String> SeatTypeTicket = new ArrayList<>();

        for (TicketBooking ticketBooking : purchasedTicket) {
            String seatType = SeatDAO.getSeatTypeByID(ticketBooking.getSeatID(), ticketBooking.getStageID());
            SeatTypeTicket.add(seatType);
        }

        JTable purchasedTicketTable = new JTable();
        purchasedTicketTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Ticket ID", "Event ID", "Price", "Stage ID", "Seat ID", "Seat Type"
                }
        ));

        for (TicketBooking ticketBooking : purchasedTicket) {
            Object[] row = new Object[6];
            row[0] = ticketBooking.getTicketID();
            row[1] = ticketBooking.getEventID();
            row[2] = ticketBooking.getPrice();
            row[3] = ticketBooking.getStageID();
            row[4] = ticketBooking.getSeatID();
            row[5] = SeatTypeTicket.get(purchasedTicket.indexOf(ticketBooking));
            ((DefaultTableModel) purchasedTicketTable.getModel()).addRow(row);
        }

        purchasedTicketTable.setAutoCreateRowSorter(true);
        purchasedTicketTable.setRowHeight(30);
        purchasedTicketTable.setGridColor(Color.black);
        purchasedTicketTable.setBackground(Color.white);
        purchasedTicketTable.setForeground(Color.black);
        purchasedTicketTable.setFont(new Font("Arial", Font.PLAIN, 15));
        purchasedTicketTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        purchasedTicketTable.getTableHeader().setOpaque(false);
        purchasedTicketTable.getTableHeader().setBackground(Color.black);
        purchasedTicketTable.getTableHeader().setForeground(Color.white);
        purchasedTicketTable.getTableHeader().setReorderingAllowed(false);
        purchasedTicketTable.getTableHeader().setResizingAllowed(false);
        purchasedTicketTable.setRowSelectionAllowed(true);
        purchasedTicketTable.setColumnSelectionAllowed(false);
        purchasedTicketTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        purchasedTicketTable.setPreferredScrollableViewportSize(purchasedTicketTable.getPreferredSize());
        purchasedTicketTable.setFillsViewportHeight(true);

        TableColumnModel columnModel = purchasedTicketTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);

        purchasedTicketTable.setPreferredScrollableViewportSize(purchasedTicketTable.getPreferredSize());
        purchasedTicketTable.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(purchasedTicketTable);
        scrollPane.setPreferredSize(new Dimension(500, 200));
        JOptionPane.showMessageDialog(null, scrollPane, "Purchased Ticket", JOptionPane.INFORMATION_MESSAGE);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        scrollPane1 = new JScrollPane();
        CustomerListTable = new JTable();
        textField1 = new JLabel();
        jtfSearch = new JTextField();
        jlbDelete = new JButton();
        jlbEdit = new JButton();
        jlbAdd = new JButton();
        jlbSearch = new JButton();

        //======== this ========
        setBackground(Color.white);
        setName("customersListPage");
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( )
        { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () ))
        throw new RuntimeException( ); }} );

        //======== scrollPane1 ========
        {

            //---- CustomerListTable ----
            CustomerListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "ID", "Name", "Username", "Password", "Phone Number", "Email", "Address", "Type", "Total Point", "Balance"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false, false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = CustomerListTable.getColumnModel();
                cm.getColumn(0).setMinWidth(2);
            }
            CustomerListTable.setName("cusListTable");
            CustomerListTable.setFont(new Font("Lato", Font.PLAIN, 13));
            CustomerListTable.setGridColor(Color.lightGray);
            CustomerListTable.setSelectionBackground(new Color(0x61b884));
            CustomerListTable.setBorder(null);
            CustomerListTable.setSelectionForeground(Color.white);
            CustomerListTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    CustomerListTableMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(CustomerListTable);
        }

        //---- textField1 ----
        textField1.setText("CUSTOMER INFORMATION LIST");
        textField1.setFont(new Font("Lato Black", Font.BOLD, 25));
        textField1.setForeground(new Color(0x61b884));
        textField1.setBorder(null);

        //---- jtfSearch ----
        jtfSearch.setFont(new Font("Lato", Font.PLAIN, 16));
        jtfSearch.setForeground(new Color(0x61b884));
        jtfSearch.setCaretColor(new Color(0x61b884));
        jtfSearch.setName("jtfSearch");

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
        jlbSearch.setName("SEARCH");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(425, 425, 425)
                    .addComponent(textField1)
                    .addContainerGap(425, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(78, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1081, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                            .addGap(337, 337, 337)
                            .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jlbDelete)))
                    .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(textField1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbDelete))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
    private JScrollPane scrollPane1;
    private JTable CustomerListTable;
    private JLabel textField1;
    private JTextField jtfSearch;
    private JButton jlbDelete;
    private JButton jlbEdit;
    private JButton jlbAdd;
    private JButton jlbSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on'

    public void setColor() {
        getCustomerListTable().getTableHeader().setBackground(Color.white);
        getCustomerListTable().getTableHeader().setForeground(Color.decode("#61b884"));
        getCustomerListTable().getTableHeader().setFont(new Font("Lato Black", Font.BOLD, 16));
        getCustomerListTable().setRowHeight(20);
        getCustomerListTable().getColumnModel().getColumn(0).setPreferredWidth(5);
        getCustomerListTable().getColumnModel().getColumn(2).setPreferredWidth(55);
        getCustomerListTable().getColumnModel().getColumn(3).setPreferredWidth(55);
        getCustomerListTable().getColumnModel().getColumn(4).setPreferredWidth(90);
        getCustomerListTable().getColumnModel().getColumn(6).setPreferredWidth(150);
        getCustomerListTable().getColumnModel().getColumn(7).setPreferredWidth(40);
        getCustomerListTable().getColumnModel().getColumn(8).setPreferredWidth(50);
        getCustomerListTable().getColumnModel().getColumn(9).setPreferredWidth(40);
        getCustomerListTable().setForeground(Color.DARK_GRAY);
        getCustomerListTable().setFont(new Font("Lato",Font.PLAIN, 14));
    }
    public void setCustomerListTable() {
        DefaultTableModel tableModel = (DefaultTableModel) getCustomerListTable().getModel();
        for (Customer customer : listCustomer) {
            int ID = customer.getId();
            String name = customer.getName();
            String username = customer.getUsername();
            String password = customer.getPassword();
            String phoneNumber = customer.getPhoneNumber();
            String email = customer.getEmail();
            String address = customer.getAddress();
            String type = customer.getType();
            int totalPoint = customer.getTotalPoint();
            int balance = customer.getBalance();
            tableModel.addRow(new Object[]{
                    ID + "", name, username, password, phoneNumber, email, address, type, totalPoint, balance + ""});
        }
    }

    public void addCustomer() {
        int newID = CustomerListDAO.getLastID();
        MainPage.changeView(new InformationCustomerForm(newID + 1), MainPage.getJlbCustomer(), "InformationCustomerPanel");
    }

    public void editCustomer() {
        MainPage.changeView(new InformationCustomerForm(getDataFromJTable()), MainPage.getJlbCustomer(), "InformationCustomerPanel");
    }

    public void deleteCustomer() {
        int i = CustomerListTable.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete");
        } else {
            customerSelected = listCustomer.get(i);
            int IDSelected = customerSelected.getId();
            ComfirmCustomerDeleteJPopupMenu confirmDeleteJPopupMenu = new ComfirmCustomerDeleteJPopupMenu();
            confirmDeleteJPopupMenu.setSelectedID(IDSelected);
        }
    }
    public void searchCustomer() throws SQLException {
        textSearched = jtfSearch.getText();
        listCustomer = CustomerListDAO.getCustomerList();
        System.out.println("Text input: " + textSearched);
        if (!textSearched.equals("")) {
            System.out.println("Search");
            List<Integer> idResult = new ArrayList<>();

            for (Customer customer : listCustomer) {
                String customerCompiled = customer.getId() + "!@#$" + customer.getName() + "!@#$" + customer.getUsernameEmail() + "!@#$" + customer.getAddress() + "!@#$" + customer.getTotalPoint() + "!@#$" + customer.getPhoneNumber() + "!@#$" + customer.getBalance();
                System.out.println(customerCompiled);
                if (customerCompiled.contains(textSearched) == true) {
                    idResult.add(customer.getId());
                }
            }
            listCustomer.clear();
            for (int id : idResult) {
                Customer cus = CustomerDAO.getInstance().selectByID(id);
                if (cus != null) {
                    listCustomer.add(cus);
                }
            }
            MainPage.changeView(new CustomersListPanel(listCustomer, textSearched), MainPage.getJlbCustomer(), "CustomerListPanel");
        }
        else {
            System.out.println("No search");
            MainPage.changeView(new CustomersListPanel(), MainPage.getJlbCustomer(), "CustomerListPanel");
        }
    }

}

