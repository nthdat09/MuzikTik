/*
 * Created by JFormDesigner on Tue Apr 25 09:49:59 ICT 2023
 */

package View.EventPage.SpecificEventPanel;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Admin
 */
public class InformationEvent {
    public InformationEvent() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Man
        scrollPane1 = new JScrollPane();
        InformationPanel = new JPanel();
        EventName = new JLabel();
        DescriptionText = new JLabel();
        button1 = new JButton();

        //======== scrollPane1 ========
        {
            scrollPane1.setPreferredSize(new Dimension(1020, 10021));

            //======== InformationPanel ========
            {
                InformationPanel.setBackground(Color.white);
                InformationPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
                swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border
                . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
                ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,InformationPanel. getBorder
                ( )) ); InformationPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
                .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
                ( ); }} );

                //---- EventName ----
                EventName.setText("Event Name");
                EventName.setFont(new Font("Lato Black", Font.BOLD, 30));
                EventName.setForeground(new Color(0x61b884));
                EventName.setHorizontalAlignment(SwingConstants.LEFT);

                //---- DescriptionText ----
                DescriptionText.setText("Description Event");
                DescriptionText.setVerticalAlignment(SwingConstants.TOP);
                DescriptionText.setFont(new Font("Lato", Font.PLAIN, 14));

                //---- button1 ----
                button1.setText("EDIT");
                button1.setForeground(Color.white);
                button1.setBackground(new Color(0x61b884));
                button1.setFont(new Font("Lato Black", Font.BOLD, 14));

                GroupLayout InformationPanelLayout = new GroupLayout(InformationPanel);
                InformationPanel.setLayout(InformationPanelLayout);
                InformationPanelLayout.setHorizontalGroup(
                    InformationPanelLayout.createParallelGroup()
                        .addGroup(InformationPanelLayout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addGroup(InformationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(InformationPanelLayout.createSequentialGroup()
                                    .addComponent(EventName, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                .addComponent(DescriptionText, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(59, Short.MAX_VALUE))
                );
                InformationPanelLayout.setVerticalGroup(
                    InformationPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, InformationPanelLayout.createSequentialGroup()
                            .addGroup(InformationPanelLayout.createParallelGroup()
                                .addGroup(InformationPanelLayout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addGap(43, 43, 43))
                                .addGroup(GroupLayout.Alignment.TRAILING, InformationPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(EventName, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addComponent(DescriptionText, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }
            scrollPane1.setViewportView(InformationPanel);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Man
    private JScrollPane scrollPane1;
    private JPanel InformationPanel;
    private JLabel EventName;
    private JLabel DescriptionText;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
