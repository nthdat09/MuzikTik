/*
 * Created by JFormDesigner on Mon Apr 24 09:08:31 ICT 2023
 */

package View.CustomerPanel.ListPanel;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author ADMIN
 */
public class InformationCustomerPanel extends JPanel {
    public InformationCustomerPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        button6 = new JButton();
        button5 = new JButton();
        textField4 = new JTextField();
        textField3 = new JTextField();
        textField2 = new JTextField();
        textField1 = new JTextField();
        button7 = new JButton();
        button8 = new JButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder (
        0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder
        . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .
        red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java .
        beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

        //---- label5 ----
        label5.setText("T\u00ean:");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 8f));

        //---- label6 ----
        label6.setText("Email:");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 8f));

        //---- label7 ----
        label7.setText("\u0110\u1ecba Ch\u1ec9:");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 8f));

        //---- label8 ----
        label8.setText("S\u1ed1 \u0110i\u1ec7n Tho\u1ea1i:");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 8f));

        //---- label9 ----
        label9.setText("Th\u00f4ng Tin Thanh To\u00e1n");
        label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 8f));

        //---- label10 ----
        label10.setText("Th\u1ebb t\u00edn d\u1ee5ng/ghi n\u1ee3");
        label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 8f));

        //---- label11 ----
        label11.setText("T\u00e0i kho\u1ea3n ng\u00e2n h\u00e0ng");
        label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 8f));

        //---- button6 ----
        button6.setText("TH\u00caM T\u00c0I KHO\u1ea2N NG\u00c2N H\u00c0NG");

        //---- button5 ----
        button5.setText("TH\u00caM TH\u1eba M\u1edaI");

        //---- button7 ----
        button7.setText("L\u01afU");
        button7.setPreferredSize(new Dimension(80, 30));

        //---- button8 ----
        button8.setText("THO\u00c1T");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label10, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label11, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button6, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(587, 587, 587)
                            .addComponent(button7, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56)
                            .addComponent(button8, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(label9, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label10, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(120, 120, 120)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(button7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button8))
                    .addContainerGap(172, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JButton button6;
    private JButton button5;
    private JTextField textField4;
    private JTextField textField3;
    private JTextField textField2;
    private JTextField textField1;
    private JButton button7;
    private JButton button8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
