/*
 * Created by JFormDesigner on Thu Apr 27 12:00:43 ICT 2023
 */

package View.CustomersListPage;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author ADMIN
 */
public class CustomersListPanel extends JPanel {
    public CustomersListPanel() {
        initComponents();
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JTable getCustomerListTable() {
        return CustomerListTable;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
        panel1 = new JPanel();
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
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
        . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing
        . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
        Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );

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

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(530, Short.MAX_VALUE)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(484, Short.MAX_VALUE)))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 896, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                    .addGap(287, 287, 287)
                                    .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jlbDelete, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(401, 401, 401)
                            .addComponent(textField1)))
                    .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(279, Short.MAX_VALUE)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(396, Short.MAX_VALUE)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(textField1)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbDelete)
                        .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable CustomerListTable;
    private JLabel textField1;
    private JTextField jtfSearch;
    private JButton jlbDelete;
    private JButton jlbEdit;
    private JButton jlbAdd;
    private JButton jlbSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
