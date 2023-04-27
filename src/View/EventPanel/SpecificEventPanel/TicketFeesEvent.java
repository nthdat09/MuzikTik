/*
 * Created by JFormDesigner on Tue Apr 25 10:07:14 ICT 2023
 */

package View.EventPanel.SpecificEventPanel;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Admin
 */
public class TicketFeesEvent {
    public TicketFeesEvent() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
        TicketFee = new JPanel();
        Scroll = new JScrollPane();
        TicketFeeTable = new JTable();
        label1 = new JLabel();

        //======== TicketFee ========
        {
            TicketFee.setBackground(Color.white);
            TicketFee.setFont(new Font("Lato Black", Font.BOLD, 18));
            TicketFee.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,TicketFee. getBorder( )) ); TicketFee. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

            //======== Scroll ========
            {

                //---- TicketFeeTable ----
                TicketFeeTable.setBorder(LineBorder.createBlackLineBorder());
                Scroll.setViewportView(TicketFeeTable);
            }

            //---- label1 ----
            label1.setText("TICKET");
            label1.setForeground(new Color(0x61b884));
            label1.setFont(new Font("Lato Black", Font.BOLD, 22));
            label1.setHorizontalAlignment(SwingConstants.LEFT);

            GroupLayout TicketFeeLayout = new GroupLayout(TicketFee);
            TicketFee.setLayout(TicketFeeLayout);
            TicketFeeLayout.setHorizontalGroup(
                TicketFeeLayout.createParallelGroup()
                    .addGroup(TicketFeeLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(TicketFeeLayout.createParallelGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Scroll, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(465, Short.MAX_VALUE))
            );
            TicketFeeLayout.setVerticalGroup(
                TicketFeeLayout.createParallelGroup()
                    .addGroup(TicketFeeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Scroll, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(116, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Nguyen Thanh Dat
    private JPanel TicketFee;
    private JScrollPane Scroll;
    private JTable TicketFeeTable;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
