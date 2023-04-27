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
        // Generated using JFormDesigner Evaluation license - Man
        StageList = new JPanel();
        jlbStageList = new JLabel();
        jtfSearch = new JTextField();
        jbtAdd = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
        border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e" , javax. swing .border . TitledBorder. CENTER
        ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dialo\u0067", java .awt . Font
        . BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener(
        new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "borde\u0072"
        .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

        //======== StageList ========
        {
            StageList.setBackground(Color.white);

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
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addContainerGap(69, Short.MAX_VALUE))
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createParallelGroup()
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(StageList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 1040, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createParallelGroup()
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(StageList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 620, Short.MAX_VALUE)
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Man
    private JPanel StageList;
    private JLabel jlbStageList;
    private JTextField jtfSearch;
    private JButton jbtAdd;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
