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
        jtfSearch = new JTextField();
        jlbDelete = new JButton();
        jlbEdit = new JButton();
        jlbAdd = new JButton();
        jlbSearch = new JButton();

        //======== this ========
        setBackground(Color.white);
        setForeground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
        javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax
        . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
        .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans.
        PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .
        equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

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

        //---- jtfSearch ----
        jtfSearch.setText(" Search MuzikTic");
        jtfSearch.setFont(new Font("Lato", Font.PLAIN, 16));
        jtfSearch.setForeground(new Color(0x61b884));
        jtfSearch.setCaretColor(new Color(0x61b884));

        //---- jlbDelete ----
        jlbDelete.setText("DELETE");
        jlbDelete.setFont(new Font("Lato Black", Font.BOLD, 16));
        jlbDelete.setForeground(Color.white);
        jlbDelete.setBackground(new Color(0x61b884));

        //---- jlbEdit ----
        jlbEdit.setText("EDIT");
        jlbEdit.setFont(new Font("Lato Black", Font.BOLD, 16));
        jlbEdit.setForeground(Color.white);
        jlbEdit.setBackground(new Color(0x61b884));

        //---- jlbAdd ----
        jlbAdd.setText("ADD ");
        jlbAdd.setFont(new Font("Lato Black", Font.BOLD, 16));
        jlbAdd.setForeground(Color.white);
        jlbAdd.setBackground(new Color(0x61b884));

        //---- jlbSearch ----
        jlbSearch.setText("SEARCH");
        jlbSearch.setFont(new Font("Lato Black", Font.BOLD, 16));
        jlbSearch.setForeground(Color.white);
        jlbSearch.setBackground(new Color(0x61b884));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(446, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                    .addGap(432, 432, 432))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(evetntPicture1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                            .addComponent(evetntPicture2, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                            .addGap(96, 96, 96)
                            .addComponent(evetntPicture3, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addComponent(eventName1)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(279, 279, 279)
                                    .addComponent(eventName2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                                    .addComponent(eventName3)
                                    .addGap(70, 70, 70))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(679, 679, 679)
                                    .addComponent(eventDate3)
                                    .addGap(108, 108, 108)))))
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(101, 101, 101)
                            .addComponent(eventDate1)
                            .addGap(356, 356, 356)
                            .addComponent(eventDate2)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 404, Short.MAX_VALUE)
                            .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(jlbDelete)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addGap(2, 2, 2)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(jtfSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(jlbSearch, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbAdd, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbEdit, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbDelete, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(eventDate3)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(eventDate1)
                        .addComponent(eventDate2))
                    .addContainerGap(156, Short.MAX_VALUE))
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
    private JTextField jtfSearch;
    private JButton jlbDelete;
    private JButton jlbEdit;
    private JButton jlbAdd;
    private JButton jlbSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
