/*
 * Created by JFormDesigner on Wed Apr 26 20:56:46 ICT 2023
 */

package View.EventListPanel;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Admin
 */
public class EventListPanel extends JPanel {
    public EventListPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
        evetntPicture1 = new JLabel();
        eventName1 = new JLabel();
        eventDate1 = new JLabel();
        evetntPicture2 = new JLabel();
        eventName2 = new JLabel();
        eventDate2 = new JLabel();
        evetntPicture3 = new JLabel();
        eventName3 = new JLabel();
        eventDate3 = new JLabel();
        label1 = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setForeground(Color.white);
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
        . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing .border . TitledBorder
        . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069al\u006fg", java .
        awt . Font. BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) )
        ;  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
        ) { if( "\u0062or\u0064er" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
        ;

        //---- evetntPicture1 ----
        evetntPicture1.setText("text");
        evetntPicture1.setBorder(LineBorder.createBlackLineBorder());

        //---- eventName1 ----
        eventName1.setText("Event Name");
        eventName1.setFont(new Font("Lato Black", Font.BOLD, 20));
        eventName1.setForeground(new Color(0x61b884));

        //---- eventDate1 ----
        eventDate1.setText("Date");
        eventDate1.setFont(new Font("Lato", Font.PLAIN, 18));
        eventDate1.setForeground(new Color(0x61b884));

        //---- evetntPicture2 ----
        evetntPicture2.setText("text");
        evetntPicture2.setBorder(LineBorder.createBlackLineBorder());

        //---- eventName2 ----
        eventName2.setText("Event Name");
        eventName2.setFont(new Font("Lato Black", Font.BOLD, 20));
        eventName2.setForeground(new Color(0x61b884));

        //---- eventDate2 ----
        eventDate2.setText("Date");
        eventDate2.setFont(new Font("Lato", Font.PLAIN, 18));
        eventDate2.setForeground(new Color(0x61b884));

        //---- evetntPicture3 ----
        evetntPicture3.setText("text");
        evetntPicture3.setBorder(LineBorder.createBlackLineBorder());

        //---- eventName3 ----
        eventName3.setText("Event Name");
        eventName3.setFont(new Font("Lato Black", Font.BOLD, 20));
        eventName3.setForeground(new Color(0x61b884));

        //---- eventDate3 ----
        eventDate3.setText("Date");
        eventDate3.setFont(new Font("Lato", Font.PLAIN, 18));
        eventDate3.setForeground(new Color(0x61b884));

        //---- label1 ----
        label1.setText("EVENT");
        label1.setFont(new Font("Lato Black", Font.BOLD, 30));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setForeground(new Color(0x61b884));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(446, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                    .addGap(432, 432, 432))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(evetntPicture1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                    .addComponent(evetntPicture2, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                    .addGap(96, 96, 96)
                    .addComponent(evetntPicture3, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19))
                .addGroup(layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(eventDate1))
                        .addComponent(eventName1))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(279, 279, 279)
                            .addComponent(eventName2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                            .addComponent(eventName3)
                            .addGap(89, 89, 89))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(314, 314, 314)
                            .addComponent(eventDate2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                            .addComponent(eventDate3)
                            .addGap(127, 127, 127))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(evetntPicture1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                        .addComponent(evetntPicture3, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                        .addComponent(evetntPicture2, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(eventName1)
                        .addComponent(eventName2)
                        .addComponent(eventName3))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(eventDate1)
                        .addComponent(eventDate2)
                        .addComponent(eventDate3))
                    .addContainerGap(216, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
    private JLabel evetntPicture1;
    private JLabel eventName1;
    private JLabel eventDate1;
    private JLabel evetntPicture2;
    private JLabel eventName2;
    private JLabel eventDate2;
    private JLabel evetntPicture3;
    private JLabel eventName3;
    private JLabel eventDate3;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
