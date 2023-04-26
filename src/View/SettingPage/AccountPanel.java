/*
 * Created by JFormDesigner on Wed Apr 26 21:29:50 ICT 2023
 */

package View.SettingPage;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Admin
 */
public class AccountPanel extends JPanel {
    public AccountPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        jbtCancel = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        jbtSave = new JButton();
        jlbAccount = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
        javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax
        . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
        .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans.
        PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .
        equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

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

        //---- jbtCancel ----
        jbtCancel.setText("CANCEL");
        jbtCancel.setPreferredSize(new Dimension(80, 30));
        jbtCancel.setFont(new Font("Lato Black", Font.BOLD, 18));
        jbtCancel.setBackground(new Color(0x61b884));
        jbtCancel.setForeground(Color.white);

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

        //---- jbtSave ----
        jbtSave.setText("SAVE");
        jbtSave.setPreferredSize(new Dimension(80, 30));
        jbtSave.setFont(new Font("Lato Black", Font.BOLD, 18));
        jbtSave.setBackground(new Color(0x61b884));
        jbtSave.setForeground(Color.white);

        //---- jlbAccount ----
        jlbAccount.setText("MY ACCOUNT");
        jlbAccount.setFont(new Font("Lato Black", Font.BOLD, 26));
        jlbAccount.setForeground(new Color(0x61b884));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createParallelGroup()
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup()
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(350, 350, 350)
                                .addComponent(jbtSave, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtCancel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(219, 219, 219)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(429, 429, 429)
                            .addComponent(jlbAccount)))
                    .addContainerGap(428, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createParallelGroup()
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup()
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(label1)))
                        .addGap(13, 13, 13)
                        .addComponent(label2)
                        .addGap(25, 25, 25)
                        .addComponent(label3)
                        .addGap(39, 39, 39)
                        .addComponent(label4)
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup()
                            .addComponent(jbtSave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtCancel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jlbAccount)
                    .addGap(82, 82, 82)
                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11)
                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addGap(25, 25, 25)
                    .addComponent(label8, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(214, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JButton jbtCancel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton jbtSave;
    private JLabel jlbAccount;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
