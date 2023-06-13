/*
 * Created by JFormDesigner on Thu Apr 27 11:57:11 ICT 2023
 */

package View.StagesPage;

import Controller.StagesPage.StagesListPanelListener;
import Model.BEAN.Stage;
import Model.DAO.Stage.StageDAO;
import Model.DAO.Stage.StageListDAO;
import View.MainPage.MainPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ADMIN
 */
public class StagesListPanel extends JPanel {
    ActionListener ac = new StagesListPanelListener(this);
    Stage stageSelected = new Stage();
    List<Stage> listStage = null;
    String textSearched = "";
    public StagesListPanel() {
        initComponents();
        initMoreSetting();
    }

    public StagesListPanel(List<Stage> stageList, String textSearched){
        initComponents();

        this.listStage = stageList;
        setStagesListTable();

        getJlbDelete().addActionListener(ac);
        getJlbEdit().addActionListener(ac);
        getJlbAdd().addActionListener(ac);
        getJlbSearch().addActionListener(ac);

        jtfSearch.setText(textSearched);
    }

    private void initMoreSetting() {
        listStage = StageListDAO.getList();

        setStagesListTable();
        setColor();

        getJlbDelete().addActionListener(ac);
        getJlbEdit().addActionListener(ac);
        getJlbAdd().addActionListener(ac);
        getJlbSearch().addActionListener(ac);
    }

    public void setStagesListTable() {
        DefaultTableModel tableModel = (DefaultTableModel) getStagesListTable().getModel();
        for (Stage stage: listStage) {
            int id = stage.getId();
            String name = stage.getName();
            String address = stage.getAddress();
            double rentalPrice = stage.getRentalPrice();
            int capacity = stage.getCapacity();
            String openTime = stage.getOpenTime();
            String closeTime = stage.getCloseTime();
            tableModel.addRow(new Object[]{String.valueOf(id), name, address, String.valueOf(rentalPrice), String.valueOf(capacity), openTime, closeTime});
        }
    }

    private Stage getDataFromJTable() {
        int i = StagesListTable.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Please choose a stage to edit");
            return null;
        } else {
            stageSelected = listStage.get(i);
            int IDSelected = stageSelected.getId();
            System.out.println("ID selected: " + IDSelected);
            return stageSelected;
        }
    }


    public void addStage() {
        System.out.println("addStage");
        int newID = StageListDAO.getLastID();
        MainPage.changeView(new StageInformationForm(newID + 1).getStageInformationFormPanel(), MainPage.getJlbStages(), "Stage Information Form");

    }
    public void editStage() {
        System.out.println("editStage");
        MainPage.changeView(new StageInformationForm(getDataFromJTable()).getStageInformationFormPanel(), MainPage.getJlbStages(), "Stage Information Form");
    }

    public void deleteStage() {
        System.out.println("deleteStage");
        int i = StagesListTable.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete");
        } else {
            stageSelected = listStage.get(i);
            int IDSelected = stageSelected.getId();
            ConfirmStageDeleteJPopupMenu confirmStageDeleteJPopupMenuDeleteJPopupMenu = new ConfirmStageDeleteJPopupMenu();
            confirmStageDeleteJPopupMenuDeleteJPopupMenu.setSelectedID(IDSelected);
        }
    }
    public void searchStage() throws SQLException {
        System.out.println("search Stage");
        textSearched = jtfSearch.getText();
        listStage = StageDAO.getInstance().getStageList();
        System.out.println("Text input: " + textSearched);
        if (!textSearched.equals("")) {
            System.out.println("Search");
            List<Integer> idResult = new ArrayList<>();

            for (Stage stage: listStage) {
                String stageCompiled = stage.getId() + "!@#$" + stage.getName() + "!@#$" + stage.getAddress() + "!@#$" + stage.getRentalPrice()
                        + "!@#$" + stage.getCapacity() + "!@#$" + stage.getOpenTime() + "!@#$" + stage.getCloseTime();

                if (stageCompiled.contains(textSearched)) {
                    idResult.add(stage.getId());
                }
            }

            listStage.clear();
            for (int id : idResult) {
                Stage stage = StageDAO.getInstance().selectByID(id);
                if (stage != null) {
                    listStage.add(stage);
                }
            }
            MainPage.changeView(new StagesListPanel(listStage, textSearched), MainPage.getJlbStages(), "Stage List Panel");
        } else {
            System.out.println("No search");
            MainPage.changeView(new StagesListPanel(), MainPage.getJlbStages(), "Stage List Panel");
        }
    }


    public void setColor() {
        getStagesListTable().getTableHeader().setBackground(Color.white);
        getStagesListTable().getTableHeader().setForeground(Color.decode("#61b884"));
        getStagesListTable().getTableHeader().setFont(new Font("Lato Black", Font.BOLD, 16));
        getStagesListTable().setRowHeight(20);
        getStagesListTable().getColumnModel().getColumn(2).setPreferredWidth(350);
        getStagesListTable().getColumnModel().getColumn(0).setPreferredWidth(20);
        getStagesListTable().getColumnModel().getColumn(4).setPreferredWidth(45);
        getStagesListTable().setForeground(Color.DARK_GRAY);
        getStagesListTable().setFont(new Font("Lato",Font.PLAIN, 14));
    }


    public JTable getStagesListTable() {
        return StagesListTable;
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

    public JTextField getJtfSearch() {
        return jtfSearch;
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
        jlbStageList = new JLabel();
        scrollPane1 = new JScrollPane();
        StagesListTable = new JTable();
        jtfSearch = new JTextField();
        jlbDelete = new JButton();
        jlbEdit = new JButton();
        jlbAdd = new JButton();
        jlbSearch = new JButton();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;

        //---- jlbStageList ----
        jlbStageList.setText("STAGES INFORMATION LIST");
        jlbStageList.setHorizontalAlignment(SwingConstants.CENTER);
        jlbStageList.setFont(new Font("Lato Black", Font.BOLD, 24));
        jlbStageList.setForeground(new Color(0x61b884));

        //======== scrollPane1 ========
        {

            //---- StagesListTable ----
            StagesListTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "ID", "Name", "Address", "Rental Price", "Capacity", "Open Time", "Close Time"
                }
            ));
            StagesListTable.setFont(new Font("Lato", Font.PLAIN, 12));
            StagesListTable.setSelectionBackground(new Color(0x61b884));
            StagesListTable.setSelectionForeground(Color.white);
            StagesListTable.setGridColor(Color.lightGray);
            scrollPane1.setViewportView(StagesListTable);
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
                    .addGap(321, 321, 321)
                    .addComponent(jlbStageList)
                    .addContainerGap(597, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(88, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1080, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                            .addGap(440, 440, 440)
                            .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jlbDelete)))
                    .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jlbStageList)
                    .addGap(32, 32, 32)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbDelete, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(216, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
    private JLabel jlbStageList;
    private JScrollPane scrollPane1;
    private JTable StagesListTable;
    private JTextField jtfSearch;
    private JButton jlbDelete;
    private JButton jlbEdit;
    private JButton jlbAdd;
    private JButton jlbSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
