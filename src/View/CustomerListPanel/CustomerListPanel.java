/*
 * Created by JFormDesigner on Mon Apr 24 12:42:18 ICT 2023
 */

package View.CustomerListPanel;

import DAO.CustomerListDAO;
import Model.CustomerListP;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
import java.util.List;

/**
 * @author ADMIN
 */
public class CustomerListPanel {
    public CustomerListPanel() {
        initComponents();
    }

    public static JTable getCustomerListTable() {
        return CustomerListTable;
    }

    public JPanel getPanel1() {
        return this.panel1;
    }

    public JScrollPane getScrollPane1() {
        return this.scrollPane1;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
        this.panel1 = new JPanel();
        this.scrollPane1 = new JScrollPane();
        this.CustomerListTable = new JTable();

        //======== panel1 ========
        {
            this.panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
            border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER
            ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font
            . BOLD ,12 ) ,java . awt. Color .red ) ,this.panel1. getBorder () ) ); this.panel1. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r"
            .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //======== scrollPane1 ========
            {

                //---- CustomerListTable ----
                this.CustomerListTable.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "ID", "Name", "Phone Number", "Email", "Address", "Type", "Total Point"
                    }
                ));
                this.CustomerListTable.setAutoCreateRowSorter(true);
                this.CustomerListTable.setName("cusListTable");
                this.scrollPane1.setViewportView(this.CustomerListTable);
            }

            GroupLayout panel1Layout = new GroupLayout(this.panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(this.scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(this.scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
    JPanel panel1;
    JScrollPane scrollPane1;
    static JTable CustomerListTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void setCustomerListTable() {
        List<CustomerListP> listCustomer =  CustomerListDAO.getInstance().getCustomerList();
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("CustomerListPanel");
        frame.setContentPane(new CustomerListPanel().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        setCustomerListTable();
    }
}
