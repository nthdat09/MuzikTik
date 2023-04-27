/*
 * Created by JFormDesigner on Thu Apr 27 12:00:43 ICT 2023
 */

package View.CustomersListPage;

import Model.DAO.CustomerListDAO;
import Model.BEAN.CustomerListP;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import java.util.List;

/**
 * @author ADMIN
 */
public class CustomersListPanel {
    public CustomersListPanel() {
        initComponents();
        setCustomerListTable();
    }

    public static JTable getCustomerListTable() {
        return CustomerListTable;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JPanel getCustomersListPage() {
        return customersListPage;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
        customersListPage = new JPanel();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        CustomerListTable = new JTable();
        textField1 = new JLabel();
        jtfSearch = new JTextField();
        jlbDelete = new JButton();
        jlbEdit = new JButton();
        jlbAdd = new JButton();
        jlbSearch = new JButton();

        //======== customersListPage ========
        {
            customersListPage.setBackground(Color.white);
            customersListPage.setName("customersListPage");
            customersListPage.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
            0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
            . BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
            red) ,customersListPage. getBorder( )) ); customersListPage. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
            beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //======== panel1 ========
            {

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                );
            }

            //======== scrollPane1 ========
            {

                //---- CustomerListTable ----
                CustomerListTable.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "ID", "Name", "Phone Number", "Email", "Address", "Type", "Total Point"
                    }
                ));
                CustomerListTable.setAutoCreateRowSorter(true);
                CustomerListTable.setName("cusListTable");
                scrollPane1.setViewportView(CustomerListTable);
            }

            //---- textField1 ----
            textField1.setText("CUSTOMER LIST");
            textField1.setFont(new Font("Lato Black", Font.BOLD, 26));
            textField1.setForeground(new Color(0x61b884));
            textField1.setBorder(null);

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

            //---- jlbEdit ----
            jlbEdit.setText("EDIT");
            jlbEdit.setFont(new Font("Lato Black", Font.BOLD, 16));
            jlbEdit.setForeground(Color.white);
            jlbEdit.setBackground(new Color(0x61b884));

            //---- jlbAdd ----
            jlbAdd.setText("ADD ");
            jlbAdd.setFont(new Font("Lato Black", Font.BOLD, 16));
            jlbAdd.setForeground(Color.white);
            jlbAdd.setBackground(new Color(0x61b884));

            //---- jlbSearch ----
            jlbSearch.setText("SEARCH");
            jlbSearch.setFont(new Font("Lato Black", Font.BOLD, 16));
            jlbSearch.setForeground(Color.white);
            jlbSearch.setBackground(new Color(0x61b884));

            GroupLayout customersListPageLayout = new GroupLayout(customersListPage);
            customersListPage.setLayout(customersListPageLayout);
            customersListPageLayout.setHorizontalGroup(
                customersListPageLayout.createParallelGroup()
                    .addGroup(customersListPageLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, customersListPageLayout.createSequentialGroup()
                            .addContainerGap(530, Short.MAX_VALUE)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(484, Short.MAX_VALUE)))
                    .addGroup(customersListPageLayout.createSequentialGroup()
                        .addGroup(customersListPageLayout.createParallelGroup()
                            .addGroup(customersListPageLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(customersListPageLayout.createParallelGroup()
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 896, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(customersListPageLayout.createSequentialGroup()
                                        .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                        .addGap(287, 287, 287)
                                        .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlbDelete, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(customersListPageLayout.createSequentialGroup()
                                .addGap(401, 401, 401)
                                .addComponent(textField1)))
                        .addContainerGap(99, Short.MAX_VALUE))
            );
            customersListPageLayout.setVerticalGroup(
                customersListPageLayout.createParallelGroup()
                    .addGroup(customersListPageLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, customersListPageLayout.createSequentialGroup()
                            .addContainerGap(279, Short.MAX_VALUE)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(396, Short.MAX_VALUE)))
                    .addGroup(customersListPageLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(textField1)
                        .addGap(18, 18, 18)
                        .addGroup(customersListPageLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbDelete)
                            .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(39, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
    private JPanel customersListPage;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private static JTable CustomerListTable;
    private JLabel textField1;
    private JTextField jtfSearch;
    private JButton jlbDelete;
    private JButton jlbEdit;
    private JButton jlbAdd;
    private JButton jlbSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on'

    public static void setCustomerListTable() {
        List <CustomerListP> listCustomer = CustomerListDAO.getCustomerList();
        DefaultTableModel tableModel = (DefaultTableModel) getCustomerListTable().getModel();
        for (CustomerListP customer : listCustomer) {
            int ID = customer.getId();
            String name = customer.getName();
            String phoneNumber = customer.getPhoneNumber();
            String email = customer.getEmail();
            String address = customer.getAddress();
            String type = customer.getType();
            int totalPoint = customer.getTotalPoint();
            tableModel.addRow(new Object[]{
                    ID + "", name, phoneNumber, email, address, type, totalPoint + ""});
        }
    }

}

