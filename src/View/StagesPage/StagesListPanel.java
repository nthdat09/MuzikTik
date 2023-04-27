/*
 * Created by JFormDesigner on Thu Apr 27 11:57:11 ICT 2023
 */

package View.StagesPage;

import View.MainPage.MainPage;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author ADMIN
 */
public class StagesListPanel extends JPanel {
    public StagesListPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
        StageList = new JPanel();
        jlbStageList = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        jtfSearch = new JTextField();
        jlbDelete = new JButton();
        jlbEdit = new JButton();
        jlbAdd = new JButton();
        jlbSearch = new JButton();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
        . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing
        . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
        Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );

        //======== StageList ========
        {
            StageList.setBackground(Color.white);

            //---- jlbStageList ----
            jlbStageList.setText("STAGES LIST");
            jlbStageList.setHorizontalAlignment(SwingConstants.CENTER);
            jlbStageList.setFont(new Font("Lato Black", Font.BOLD, 25));
            jlbStageList.setForeground(new Color(0x61b884));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }

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

            GroupLayout StageListLayout = new GroupLayout(StageList);
            StageList.setLayout(StageListLayout);
            StageListLayout.setHorizontalGroup(
                StageListLayout.createParallelGroup()
                    .addGroup(StageListLayout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(jlbStageList)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(StageListLayout.createSequentialGroup()
                        .addGroup(StageListLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(scrollPane1, GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.LEADING, StageListLayout.createSequentialGroup()
                                .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                .addGap(287, 287, 287)
                                .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jlbDelete)))
                        .addGap(0, 135, Short.MAX_VALUE))
            );
            StageListLayout.setVerticalGroup(
                StageListLayout.createParallelGroup()
                    .addGroup(StageListLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jlbStageList)
                        .addGap(31, 31, 31)
                        .addGroup(StageListLayout.createParallelGroup()
                            .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(StageListLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(StageListLayout.createParallelGroup()
                                    .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbDelete, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(33, Short.MAX_VALUE))
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StageList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(StageList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 32, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
    private JPanel StageList;
    private JLabel jlbStageList;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JTextField jtfSearch;
    private JButton jlbDelete;
    private JButton jlbEdit;
    private JButton jlbAdd;
    private JButton jlbSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
