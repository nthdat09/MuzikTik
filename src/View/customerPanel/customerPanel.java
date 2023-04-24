/*
 * Created by JFormDesigner on Mon Apr 24 08:33:28 ICT 2023
 */

package View.customerPanel;

import View.customerPanel.controller.controllerCustomerPanel;
import View.customerPanel.controller.customerList;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author ADMIN
 */
public class customerPanel extends JPanel {
    public customerPanel() {
        initComponents();

        controllerCustomerPanel controller = new controllerCustomerPanel(jpnView);
        controller.setView(jpnInfor, jlbInfor);

        List<customerList> listItem = new ArrayList<>();
        listItem.add(new customerList("informationCustomer",jpnInfor,jlbInfor));
        listItem.add(new customerList("historyCustomer",jpnHistory,jlbHistoory));
        controller.setEvent(listItem);
    }
    public static void main (String[] args) {
        JFrame frame = new JFrame("Đồ án bán vé hoà nhạc");
        frame.setContentPane(new customerPanel());
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
        // Generated using JFormDesigner Evaluation license - Man
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        jpnInfor = new JPanel();
        jlbInfor = new JLabel();
        jpnHistory = new JPanel();
        jlbHistoory = new JLabel();
        jpnLogOut = new JPanel();
        jlbLogOut = new JLabel();
        jpnView = new JPanel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
        . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax
        . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
        12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans
        . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .
        getPropertyName () )) throw new RuntimeException( ); }} );

        //======== panel1 ========
        {

            //---- label1 ----
            label1.setText("My Account");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 20f));
            label1.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label2 ----
            label2.setText("Avatar");
            label2.setBorder(LineBorder.createBlackLineBorder());
            label2.setHorizontalAlignment(SwingConstants.CENTER);

            //======== jpnInfor ========
            {
                jpnInfor.setBorder(LineBorder.createBlackLineBorder());

                //---- jlbInfor ----
                jlbInfor.setText("TH\u00d4NG TIN KH\u00c1CH H\u00c0NG");
                jlbInfor.setFont(jlbInfor.getFont().deriveFont(jlbInfor.getFont().getSize() + 3f));
                jlbInfor.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout jpnInforLayout = new GroupLayout(jpnInfor);
                jpnInfor.setLayout(jpnInforLayout);
                jpnInforLayout.setHorizontalGroup(
                    jpnInforLayout.createParallelGroup()
                        .addComponent(jlbInfor, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                );
                jpnInforLayout.setVerticalGroup(
                    jpnInforLayout.createParallelGroup()
                        .addComponent(jlbInfor, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                );
            }

            //======== jpnHistory ========
            {
                jpnHistory.setBorder(LineBorder.createBlackLineBorder());

                //---- jlbHistoory ----
                jlbHistoory.setText("L\u1ecaCH S\u1eec");
                jlbHistoory.setFont(jlbHistoory.getFont().deriveFont(jlbHistoory.getFont().getSize() + 3f));
                jlbHistoory.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout jpnHistoryLayout = new GroupLayout(jpnHistory);
                jpnHistory.setLayout(jpnHistoryLayout);
                jpnHistoryLayout.setHorizontalGroup(
                    jpnHistoryLayout.createParallelGroup()
                        .addComponent(jlbHistoory, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                );
                jpnHistoryLayout.setVerticalGroup(
                    jpnHistoryLayout.createParallelGroup()
                        .addComponent(jlbHistoory, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                );
            }

            //======== jpnLogOut ========
            {
                jpnLogOut.setBorder(LineBorder.createBlackLineBorder());

                //---- jlbLogOut ----
                jlbLogOut.setText("\u0110\u0102NG XU\u1ea4T");
                jlbLogOut.setFont(jlbLogOut.getFont().deriveFont(jlbLogOut.getFont().getSize() + 3f));
                jlbLogOut.setHorizontalAlignment(SwingConstants.CENTER);

                GroupLayout jpnLogOutLayout = new GroupLayout(jpnLogOut);
                jpnLogOut.setLayout(jpnLogOutLayout);
                jpnLogOutLayout.setHorizontalGroup(
                    jpnLogOutLayout.createParallelGroup()
                        .addComponent(jlbLogOut, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                );
                jpnLogOutLayout.setVerticalGroup(
                    jpnLogOutLayout.createParallelGroup()
                        .addComponent(jlbLogOut, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(jpnInfor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jpnLogOut, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jpnHistory, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(43, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jpnInfor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpnHistory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpnLogOut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(191, Short.MAX_VALUE))
            );
        }

        //======== jpnView ========
        {

            GroupLayout jpnViewLayout = new GroupLayout(jpnView);
            jpnView.setLayout(jpnViewLayout);
            jpnViewLayout.setHorizontalGroup(
                jpnViewLayout.createParallelGroup()
                    .addGap(0, 994, Short.MAX_VALUE)
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
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpnView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Man
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JPanel jpnInfor;
    private JLabel jlbInfor;
    private JPanel jpnHistory;
    private JLabel jlbHistoory;
    private JPanel jpnLogOut;
    private JLabel jlbLogOut;
    private JPanel jpnView;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
