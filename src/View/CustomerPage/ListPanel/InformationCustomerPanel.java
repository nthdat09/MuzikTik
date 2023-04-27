/*
 * Created by JFormDesigner on Mon Apr 24 09:08:31 ICT 2023
 */

package View.CustomerPage.ListPanel;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author ADMIN
 */
public class InformationCustomerPanel extends JPanel {
    public InformationCustomerPanel() {
        initComponents();
        initMoreSetting();
    }

    public void initMoreSetting() {

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

    public JLabel getLabel9() {
        return this.label9;
    }

    public JLabel getLabel10() {
        return this.label10;
    }

    public JPanel getInformationCustomerPanel() {
        return this.InformationCustomerPanel;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
        this.InformationCustomerPanel = new JPanel();
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
        this.label9 = new JLabel();
        this.label10 = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
        border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER
        ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font
        .BOLD,12),java.awt.Color.red), getBorder())); addPropertyChangeListener(
        new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order"
        .equals(e.getPropertyName()))throw new RuntimeException();}});

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

        //---- label9 ----
        this.label9.setFont(new Font("Lato Black", Font.BOLD, 20));
        this.label9.setText("Wallet Balance");

        //---- label10 ----
        this.label10.setText("text");
        this.label10.setFont(new Font("Lato", Font.PLAIN, 20));
        this.label10.setForeground(new Color(0x61b884));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(414, Short.MAX_VALUE)
                    .addComponent(this.button8, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(this.button7, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(214, 214, 214))
                .addGroup(layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(this.label9, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(this.label10, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(this.label5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(this.label6, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(this.label7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(this.label3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 3, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(this.label8, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(this.label4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addComponent(this.label2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.label1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(464, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.label1)
                        .addComponent(this.label5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.label2)
                        .addComponent(this.label6, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(11, 11, 11)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.label7, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.label3))
                    .addGap(25, 25, 25)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.label8, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.label4))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(this.label9, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(this.label10)))
                    .addGap(45, 45, 45)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(this.button7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(this.button8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
    JPanel InformationCustomerPanel;
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
    JLabel label9;
    JLabel label10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
