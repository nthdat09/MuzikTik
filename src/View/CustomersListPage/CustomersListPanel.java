/*
 * Created by JFormDesigner on Thu Apr 27 12:00:43 ICT 2023
 */

package View.CustomersListPage;

import Controller.CustomerPanel.CustomerListListener;
import Model.BEAN.Customer;
import Model.DAO.Customer.CustomerDAO;
import Model.DAO.Customer.CustomerListDAO;
import View.MainPage.MainPage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
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


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
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
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
        swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border
        . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
        ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder
        ( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
        .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
        ( ); }} );

        //======== scrollPane1 ========
        {

            //---- CustomerListTable ----
            CustomerListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "ID", "Name", "Phone Number", "Email", "Address", "Type", "Total Point", "Balance"
                }
            ));
            {
                TableColumnModel cm = CustomerListTable.getColumnModel();
                cm.getColumn(0).setMinWidth(2);
            }
            CustomerListTable.setAutoCreateRowSorter(true);
            CustomerListTable.setName("cusListTable");
            CustomerListTable.setFont(new Font("Lato", Font.PLAIN, 13));
            CustomerListTable.setGridColor(Color.gray);
            CustomerListTable.setSelectionBackground(new Color(0x61b884));
            CustomerListTable.setBorder(LineBorder.createBlackLineBorder());
            CustomerListTable.setSelectionForeground(Color.white);
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
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(377, 377, 377)
                            .addComponent(textField1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
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
                                    .addComponent(jlbDelete)))))
                    .addContainerGap(129, Short.MAX_VALUE))
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
                    .addContainerGap(34, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
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
        getCustomerListTable().getTableHeader().setBackground(Color.decode("61b884"));
        getCustomerListTable().setRowHeight(30);
        getCustomerListTable().getColumnModel().getColumn(0).setPreferredWidth(100);
        getCustomerListTable().setForeground(Color.white);
        getCustomerListTable().getTableHeader().setFont(new Font("Lato Black", Font.BOLD, 25));
    }
    public void setCustomerListTable() {
        DefaultTableModel tableModel = (DefaultTableModel) getCustomerListTable().getModel();
        for (Customer customer : listCustomer) {
            int ID = customer.getId();
            String name = customer.getName();
            String phoneNumber = customer.getPhoneNumber();
            String email = customer.getEmail();
            String address = customer.getAddress();
            String type = customer.getType();
            int totalPoint = customer.getTotalPoint();
            int balance = customer.getBalance();
            tableModel.addRow(new Object[]{
                    ID + "", name, phoneNumber, email, address, type, totalPoint, balance + ""});
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

