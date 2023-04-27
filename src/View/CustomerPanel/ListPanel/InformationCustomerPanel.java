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

    public JLabel getLabel5() {
        return this.label5;
    }

    public JLabel getLabel6() {
        return this.label6;
    }

    public JLabel getLabel7() {
        return this.label7;
    }

    public JLabel getLabel8() {
        return this.label8;
    }

    public JButton getButton7() {
        return this.button7;
    }

    public JLabel getLabel1() {
        return this.label1;
    }

    public JLabel getLabel2() {
        return this.label2;
    }

    public JLabel getLabel3() {
        return this.label3;
    }

    public JLabel getLabel4() {
        return this.label4;
    }

    public JButton getButton8() {
        return this.button8;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
        this.label5 = new JLabel();
        this.label6 = new JLabel();
        this.label7 = new JLabel();
        this.label8 = new JLabel();
        this.button7 = new JButton();
        this.label1 = new JLabel();
        this.label2 = new JLabel();
        this.label3 = new JLabel();
        this.label4 = new JLabel();
        this.button8 = new JButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
        border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER
        ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font
        . BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener(
        new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r"
        .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

        //---- label5 ----
        this.label5.setText("Name:");
        this.label5.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- label6 ----
        this.label6.setText("Email:");
        this.label6.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- label7 ----
        this.label7.setText("Address:");
        this.label7.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- label8 ----
        this.label8.setText("Number Phone:");
        this.label8.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- button7 ----
        this.button7.setText("CANCEL");
        this.button7.setPreferredSize(new Dimension(80, 30));
        this.button7.setFont(new Font("Lato Black", Font.BOLD, 18));
        this.button7.setBackground(new Color(0x61b884));
        this.button7.setForeground(Color.white);

        //---- label1 ----
        this.label1.setText("text");
        this.label1.setFont(new Font("Lato", Font.PLAIN, 20));
        this.label1.setForeground(new Color(0x61b884));

        //---- label2 ----
        this.label2.setText("text");
        this.label2.setFont(new Font("Lato", Font.PLAIN, 20));
        this.label2.setForeground(new Color(0x61b884));

        //---- label3 ----
        this.label3.setText("text");
        this.label3.setFont(new Font("Lato", Font.PLAIN, 20));
        this.label3.setForeground(new Color(0x61b884));

        //---- label4 ----
        this.label4.setText("text");
        this.label4.setFont(new Font("Lato", Font.PLAIN, 20));
        this.label4.setForeground(new Color(0x61b884));

        //---- button8 ----
        this.button8.setText("SAVE");
        this.button8.setPreferredSize(new Dimension(80, 30));
        this.button8.setFont(new Font("Lato Black", Font.BOLD, 18));
        this.button8.setBackground(new Color(0x61b884));
        this.button8.setForeground(Color.white);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(this.label5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addComponent(this.label6, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(this.label3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(this.label8, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(this.label4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                .addComponent(this.label2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(this.label1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addGap(589, 589, 589))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(this.label7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(this.button8, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(this.button7, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(214, 214, 214))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(96, 96, 96)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.label1)
                        .addComponent(this.label5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.label2)
                        .addComponent(this.label6, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.label3)
                        .addComponent(this.label7, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.label8, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.label4))
                    .addGap(44, 44, 44)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.button7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.button8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JButton button7;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JButton button8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
