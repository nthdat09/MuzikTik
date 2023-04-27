/*
 * Created by JFormDesigner on Mon Apr 24 08:33:28 ICT 2023
 */

package View.CustomerPage;

import java.awt.*;
import Controller.CustomerPanelListener;
import Model.CustomerList;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author ADMIN
 */
public class CustomerPanel extends JPanel {
    public CustomerPanel() {
        initComponents();

        CustomerPanelListener controller = new CustomerPanelListener(jpnView);
        controller.setView(jpnInfor, jlbInfor);

        List<CustomerList> listItem = new ArrayList<>();
        listItem.add(new CustomerList("informationCustomer",jpnInfor,jlbInfor));
        listItem.add(new CustomerList("historyCustomer",jpnHistory,jlbHistoory));
        controller.setEvent(listItem);
    }
    public static void main (String[] args) {
        JFrame frame = new JFrame("Đồ án bán vé hoà nhạc");
        frame.setContentPane(new CustomerPanel());
        frame.pack();
        frame.setVisible(true);
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void informationButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void historyButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        jpnInfor = new JPanel();
        jlbInfor = new JLabel();
        jpnHistory = new JPanel();
        jlbHistoory = new JLabel();
        jpnView = new JPanel();

        //======== this ========
        setPreferredSize(new Dimension(1268, 820));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
        swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border
        . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
        ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder
        ( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
        .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
        ( ); }} );

        //======== panel1 ========
        {
            panel1.setPreferredSize(new Dimension(256, 808));
            panel1.setBackground(Color.white);

            //---- label1 ----
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 20f));
            label1.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label2 ----
            label2.setText("Avatar");
            label2.setBorder(LineBorder.createBlackLineBorder());
            label2.setHorizontalAlignment(SwingConstants.CENTER);

            //======== jpnInfor ========
            {
                jpnInfor.setBorder(null);
                jpnInfor.setBackground(new Color(0x61b884));

                //---- jlbInfor ----
                jlbInfor.setText("TH\u00d4NG TIN KH\u00c1CH H\u00c0NG");
                jlbInfor.setFont(new Font("Lato Black", Font.BOLD, 16));
                jlbInfor.setHorizontalAlignment(SwingConstants.CENTER);
                jlbInfor.setForeground(Color.white);

                GroupLayout jpnInforLayout = new GroupLayout(jpnInfor);
                jpnInfor.setLayout(jpnInforLayout);
                jpnInforLayout.setHorizontalGroup(
                    jpnInforLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, jpnInforLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jlbInfor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jpnInforLayout.setVerticalGroup(
                    jpnInforLayout.createParallelGroup()
                        .addComponent(jlbInfor, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                );
            }

            //======== jpnHistory ========
            {
                jpnHistory.setBorder(null);
                jpnHistory.setBackground(new Color(0x61b884));

                //---- jlbHistoory ----
                jlbHistoory.setText("HISTORY");
                jlbHistoory.setFont(new Font("Lato Black", Font.BOLD, 16));
                jlbHistoory.setHorizontalAlignment(SwingConstants.CENTER);
                jlbHistoory.setForeground(Color.white);

                GroupLayout jpnHistoryLayout = new GroupLayout(jpnHistory);
                jpnHistory.setLayout(jpnHistoryLayout);
                jpnHistoryLayout.setHorizontalGroup(
                    jpnHistoryLayout.createParallelGroup()
                        .addComponent(jlbHistoory, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                );
                jpnHistoryLayout.setVerticalGroup(
                    jpnHistoryLayout.createParallelGroup()
                        .addComponent(jlbHistoory, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addComponent(jpnInfor, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnHistory, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58)
                        .addComponent(jpnInfor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jpnHistory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(367, Short.MAX_VALUE))
            );
        }

        //======== jpnView ========
        {
            jpnView.setBackground(Color.white);

            GroupLayout jpnViewLayout = new GroupLayout(jpnView);
            jpnView.setLayout(jpnViewLayout);
            jpnViewLayout.setHorizontalGroup(
                jpnViewLayout.createParallelGroup()
                    .addGap(0, 594, Short.MAX_VALUE)
            );
            jpnViewLayout.setVerticalGroup(
                jpnViewLayout.createParallelGroup()
                    .addGap(0, 808, Short.MAX_VALUE)
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jpnView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(403, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jpnView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JPanel jpnInfor;
    private JLabel jlbInfor;
    private JPanel jpnHistory;
    private JLabel jlbHistoory;
    private JPanel jpnView;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
