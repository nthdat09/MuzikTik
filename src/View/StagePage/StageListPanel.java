/*
 * Created by JFormDesigner on Wed Apr 26 21:51:11 ICT 2023
 */

package View.StagePage;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Admin
 */
public class StageListPanel {
    public StageListPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
        StageList = new JPanel();
        jlbStageList = new JLabel();
        jtfSearch = new JTextField();
        jbtAdd = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== StageList ========
        {
            StageList.setBackground(Color.white);
            StageList.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
            0,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
            .BOTTOM,new java.awt.Font("D\u0069al\u006fg",java.awt.Font.BOLD,12),java.awt.Color.
            red),StageList. getBorder()));StageList. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
            beans.PropertyChangeEvent e){if("\u0062or\u0064er".equals(e.getPropertyName()))throw new RuntimeException();}});

            //---- jlbStageList ----
            jlbStageList.setText("STAGES LIST");
            jlbStageList.setHorizontalAlignment(SwingConstants.CENTER);
            jlbStageList.setFont(new Font("Lato Black", Font.BOLD, 25));
            jlbStageList.setForeground(new Color(0x61b884));

            //---- jtfSearch ----
            jtfSearch.setText("Search ");
            jtfSearch.setFont(new Font("Lato", Font.PLAIN, 16));
            jtfSearch.setForeground(new Color(0x61b884));
            jtfSearch.setCaretColor(new Color(0x61b884));

            //---- jbtAdd ----
            jbtAdd.setText("ADD NEW STAGE");
            jbtAdd.setFont(new Font("Lato Black", Font.BOLD, 16));
            jbtAdd.setForeground(Color.white);
            jbtAdd.setBackground(new Color(0x61b884));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }

            GroupLayout StageListLayout = new GroupLayout(StageList);
            StageList.setLayout(StageListLayout);
            StageListLayout.setHorizontalGroup(
                StageListLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, StageListLayout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addGroup(StageListLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(StageListLayout.createSequentialGroup()
                                .addGap(376, 376, 376)
                                .addComponent(jlbStageList))
                            .addGroup(StageListLayout.createSequentialGroup()
                                .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                .addGap(572, 572, 572)
                                .addComponent(jbtAdd))
                            .addComponent(scrollPane1))
                        .addGap(38, 38, 38))
            );
            StageListLayout.setVerticalGroup(
                StageListLayout.createParallelGroup()
                    .addGroup(StageListLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jlbStageList)
                        .addGap(12, 12, 12)
                        .addGroup(StageListLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtAdd))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(84, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
    private JPanel StageList;
    private JLabel jlbStageList;
    private JTextField jtfSearch;
    private JButton jbtAdd;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
