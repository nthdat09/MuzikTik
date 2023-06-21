/*
 * Created by JFormDesigner on Wed Apr 26 21:17:29 ICT 2023
 */

package View.PartnerPage;

import Controller.PartnerPage.PartnerListPanelController;
import Model.BEAN.Partner.Partner;
import Model.DAO.Partner.PartnerDAO;
import Model.DAO.Partner.PartnerListDAO;
import View.MainPage.MainPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 */
public class PartnerListPanel extends JPanel {
    ActionListener ac = new PartnerListPanelController(this);
    Partner partnerSelected = new Partner();
    List<Partner> partnerList = null;
    String textSearched = "";
    public PartnerListPanel() {
        initComponents();
        initMoreSetting();
    }

    public PartnerListPanel(List<Partner> partnerList, String textSearched){
        initComponents();

        this.partnerList = partnerList;
        setPartnerListTable();

        getJlbDelete().addActionListener(ac);
        getJlbEdit().addActionListener(ac);
        getJlbAdd().addActionListener(ac);
        getJlbSearch().addActionListener(ac);

        jtfSearch.setText(textSearched);
    }

    public void initMoreSetting(){
        partnerList = PartnerListDAO.getList();

        setPartnerListTable();
        setColor();

        getJlbDelete().addActionListener(ac);
        getJlbEdit().addActionListener(ac);
        getJlbAdd().addActionListener(ac);
        getJlbSearch().addActionListener(ac);
    }

    private void setPartnerListTable() {
        DefaultTableModel tableModel = (DefaultTableModel) getPartnerListTable().getModel();
        for (Partner partner : partnerList) {
            int partnerID = partner.getId();
            String partnerName = partner.getName();
            String partnerPhone = partner.getPhoneNumber();
            String partnerEmail = partner.getEmail();
            String partnerAddress = partner.getAddress();
            String partnerAccNumber = partner.getAccNumber();
            String partnerBank = partner.getBank();

            tableModel.addRow(new Object[]{partnerID, partnerName, partnerPhone, partnerEmail, partnerAddress, partnerAccNumber, partnerBank});
        }
    }

    private Partner getDataFromJTable() {
        int i = PartnerListTable.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Please choose a partner to edit");
            return null;
        } else {
            partnerSelected = partnerList.get(i);
            int IDSelected = partnerSelected.getId();
            System.out.println("ID selected: " + IDSelected);
            return partnerSelected;
        }
    }

    public void addPartner() {
        System.out.println("Add partner");
        int newID = PartnerListDAO.getLastID() + 1;
        MainPage.changeView(new PartnerInformationPanel(newID), MainPage.getJlbPartners(), "Partner Information Form");
    }


    public void editPartner() {
        System.out.println("Edit partner");
        MainPage.changeView(new PartnerInformationPanel(getDataFromJTable()), MainPage.getJlbPartners(), "Partner Information Form");


    }

    public void deletePartner() {
        System.out.println("Delete partner");
        int i = PartnerListTable.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete");
        } else {
            partnerSelected = partnerList.get(i);
            int IDSelected = partnerSelected.getId();
            ConfirmPartnerDeleteJPopupMenu confirmPartnerDeleteJPopupMenu = new ConfirmPartnerDeleteJPopupMenu();
            confirmPartnerDeleteJPopupMenu.setSelectedID(IDSelected);
        }
    }

    public void searchPartner() throws SQLException {
        System.out.println("Search partner");
        textSearched = jtfSearch.getText();
        partnerList = PartnerListDAO.getList();
        System.out.println("Text input: " + textSearched);
        if (!textSearched.equals("")) {
            System.out.println("Search");
            List<Integer> idResult = new ArrayList<>();

            for (Partner partner: partnerList) {
                String partnerCompiled = partner.getId() + "!@#$" + partner.getName() + "!@#$" + partner.getAddress() + "!@#$"
                        + partner.getEmail() + "!@#$" + partner.getPhoneNumber() + "!@#$" + partner.getAccNumber()
                        + partner.getBank();

                if (partnerCompiled.contains(textSearched)) {
                    idResult.add(partner.getId());
                }
            }

            partnerList.clear();
            for (int id : idResult) {
                Partner partner = PartnerDAO.getInstance().selectByID(id);
                if (partner != null) {
                    partnerList.add(partner);
                }
            }
            MainPage.changeView(new PartnerListPanel(partnerList, textSearched), MainPage.getJlbStages(), "Partner List Panel");
        } else {
            System.out.println("No search");
            MainPage.changeView(new PartnerListPanel(), MainPage.getJlbPartners(), "Partner List Panel");
        }
    }

    public void setColor() {
        getPartnerListTable().getTableHeader().setBackground(Color.white);
        getPartnerListTable().getTableHeader().setForeground(Color.decode("#61b884"));
        getPartnerListTable().getTableHeader().setFont(new Font("Lato Black", Font.BOLD, 16));
        getPartnerListTable().setRowHeight(20);
        getPartnerListTable().getColumnModel().getColumn(0).setPreferredWidth(20);
        getPartnerListTable().getColumnModel().getColumn(1).setPreferredWidth(70);
        getPartnerListTable().getColumnModel().getColumn(2).setPreferredWidth(45);
        getPartnerListTable().getColumnModel().getColumn(3).setPreferredWidth(100);
        getPartnerListTable().getColumnModel().getColumn(4).setPreferredWidth(110);
        getPartnerListTable().getColumnModel().getColumn(5).setPreferredWidth(45);
        getPartnerListTable().getColumnModel().getColumn(6).setPreferredWidth(30);
        getPartnerListTable().setForeground(Color.DARK_GRAY);
        getPartnerListTable().setFont(new Font("Lato",Font.PLAIN, 14));
    }

    public JButton getJlbSearch() {
        return jlbSearch;
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

    public JTable getPartnerListTable() {
        return PartnerListTable;
    }

    public JLabel getLabel1() {
        return label1;
    }

    public JScrollPane getScrollPane1() {
        return scrollPane1;
    }

    public JTextField getJtfSearch() {
        return jtfSearch;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        PartnerListTable = new JTable();
        jtfSearch = new JTextField();
        jlbDelete = new JButton();
        jlbEdit = new JButton();
        jlbAdd = new JButton();
        jlbSearch = new JButton();

        //======== this ========
        setBackground(Color.white);
        setPreferredSize(new Dimension(1160, 381));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border
        .EmptyBorder ( 0, 0 ,0 , 0) ,  "" , javax. swing .border . TitledBorder. CENTER ,javax
        . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dialo\u0067", java .awt . Font. BOLD ,
        12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans
        .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "borde\u0072" .equals ( e.
        getPropertyName () ) )throw new RuntimeException( ) ;} } );

        //---- label1 ----
        label1.setText("PARTNERS CUSTOMER LIST");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Lato Black", Font.BOLD, 25));
        label1.setForeground(new Color(0x61b884));

        //======== scrollPane1 ========
        {

            //---- PartnerListTable ----
            PartnerListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "ID", "Name", "Phone Number", "Email", "Address", "Account Number", "Bank"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            PartnerListTable.setGridColor(Color.lightGray);
            PartnerListTable.setSelectionBackground(new Color(0x61b884));
            PartnerListTable.setSelectionForeground(Color.white);
            scrollPane1.setViewportView(PartnerListTable);
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
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(476, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(466, 466, 466))
                .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 603, Short.MAX_VALUE)
                    .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jlbDelete))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbDelete, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(100, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable PartnerListTable;
    private JTextField jtfSearch;
    private JButton jlbDelete;
    private JButton jlbEdit;
    private JButton jlbAdd;
    private JButton jlbSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
