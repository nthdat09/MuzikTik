/*
 * Created by JFormDesigner on Mon Apr 24 09:04:23 ICT 2023
 */

package View.CustomerPanel.ListPanel;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author ADMIN
 */
public class HistoryCustomerPanel extends JPanel {
    public HistoryCustomerPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder (
        0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder
        . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .
        red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java .
        beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- label1 ----
        label1.setText("TICKETS");
        label1.setForeground(new Color(0x61b884));
        label1.setFont(new Font("Lato Black", Font.BOLD, 22));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addContainerGap(511, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(label1)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(300, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
