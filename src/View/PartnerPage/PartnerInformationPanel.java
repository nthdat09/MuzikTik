/*
 * Created by JFormDesigner on Wed Apr 26 21:22:42 ICT 2023
 */

package View.PartnerPage;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Admin
 */
public class PartnerInformationPanel extends JPanel {
    public PartnerInformationPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        button7 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        button8 = new JButton();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
        .EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax
        .swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,
        12),java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans
        .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.
        getPropertyName()))throw new RuntimeException();}});

        //---- label5 ----
        label5.setText("Name:");
        label5.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- label6 ----
        label6.setText("Email:");
        label6.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- label7 ----
        label7.setText("Address:");
        label7.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- label8 ----
        label8.setText("Number Phone:");
        label8.setFont(new Font("Lato Black", Font.BOLD, 20));

        //---- button7 ----
        button7.setText("CANCEL");
        button7.setPreferredSize(new Dimension(80, 30));
        button7.setFont(new Font("Lato Black", Font.BOLD, 18));
        button7.setBackground(new Color(0x61b884));
        button7.setForeground(Color.white);

        //---- label1 ----
        label1.setText("text");
        label1.setFont(new Font("Lato", Font.PLAIN, 20));
        label1.setForeground(new Color(0x61b884));

        //---- label2 ----
        label2.setText("text");
        label2.setFont(new Font("Lato", Font.PLAIN, 20));
        label2.setForeground(new Color(0x61b884));

        //---- label3 ----
        label3.setText("text");
        label3.setFont(new Font("Lato", Font.PLAIN, 20));
        label3.setForeground(new Color(0x61b884));

        //---- label4 ----
        label4.setText("text");
        label4.setFont(new Font("Lato", Font.PLAIN, 20));
        label4.setForeground(new Color(0x61b884));

        //---- button8 ----
        button8.setText("SAVE");
        button8.setPreferredSize(new Dimension(80, 30));
        button8.setFont(new Font("Lato Black", Font.BOLD, 18));
        button8.setBackground(new Color(0x61b884));
        button8.setForeground(Color.white);

        //---- label9 ----
        label9.setFont(new Font("Lato Black", Font.BOLD, 20));
        label9.setText("Account Number");

        //---- label10 ----
        label10.setText("text");
        label10.setFont(new Font("Lato", Font.PLAIN, 20));
        label10.setForeground(new Color(0x61b884));

        //---- label11 ----
        label11.setText("PARTNER INFORMATION");
        label11.setFont(new Font("Lato Black", Font.BOLD, 24));
        label11.setForeground(new Color(0x61b884));

        //---- label12 ----
        label12.setFont(new Font("Lato Black", Font.BOLD, 20));
        label12.setText("Beneficiary Account");

        //---- label13 ----
        label13.setText("text");
        label13.setFont(new Font("Lato", Font.PLAIN, 20));
        label13.setForeground(new Color(0x61b884));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(219, 219, 219)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label12, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label10, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label13, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(444, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(433, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(label11)
                            .addGap(306, 306, 306))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(button8, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button7, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                            .addGap(110, 110, 110))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(label11)
                    .addGap(33, 33, 33)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addGap(13, 13, 13)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label8)
                        .addComponent(label4))
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label10))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label13)
                        .addComponent(label12, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(button8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(37, 37, 37))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JButton button7;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton button8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
