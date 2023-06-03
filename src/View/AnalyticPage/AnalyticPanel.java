/*
 * Created by JFormDesigner on Wed Apr 26 21:57:41 ICT 2023
 */

package View.AnalyticPage;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Admin
 */
public class AnalyticPanel {
    public AnalyticPanel() {
        initComponents();
    }

    public JComboBox getStatistic() {
        return Statistic;
    }

    public JLabel getTypeStatistic() {
        return TypeStatistic;
    }

    public JLabel getDay() {
        return Day;
    }

    public JLabel getMonth() {
        return Month;
    }

    public JLabel getYear() {
        return Year;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
        Analytic = new JPanel();
        Statistic = new JComboBox();
        TypeStatistic = new JLabel();
        Day = new JLabel();
        Month = new JLabel();
        Year = new JLabel();
        textDay = new JTextField();
        textMonth = new JTextField();
        textField3 = new JTextField();

        //======== Analytic ========
        {
            Analytic.setBackground(Color.white);
            Analytic.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
            border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER
            , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
            .BOLD ,12 ), java. awt. Color. red) ,Analytic. getBorder( )) ); Analytic. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r"
            .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- Statistic ----
            Statistic.setFont(new Font("Lato Black", Font.BOLD, 16));

            //---- TypeStatistic ----
            TypeStatistic.setText("Types of Statistics");
            TypeStatistic.setFont(new Font("Lato Black", Font.BOLD, 16));

            //---- Day ----
            Day.setText("Day");
            Day.setFont(new Font("Lato Black", Font.BOLD, 16));

            //---- Month ----
            Month.setText("Month");
            Month.setFont(new Font("Lato Black", Font.BOLD, 16));

            //---- Year ----
            Year.setText("Year");
            Year.setFont(new Font("Lato Black", Font.BOLD, 16));

            GroupLayout AnalyticLayout = new GroupLayout(Analytic);
            Analytic.setLayout(AnalyticLayout);
            AnalyticLayout.setHorizontalGroup(
                AnalyticLayout.createParallelGroup()
                    .addGroup(AnalyticLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(AnalyticLayout.createParallelGroup()
                            .addGroup(AnalyticLayout.createSequentialGroup()
                                .addComponent(Day)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textDay, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                            .addComponent(TypeStatistic))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AnalyticLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(AnalyticLayout.createSequentialGroup()
                                .addComponent(Month)
                                .addGap(18, 18, 18)
                                .addComponent(textMonth, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Year)
                                .addGap(18, 18, 18)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                            .addComponent(Statistic))
                        .addContainerGap(222, Short.MAX_VALUE))
            );
            AnalyticLayout.setVerticalGroup(
                AnalyticLayout.createParallelGroup()
                    .addGroup(AnalyticLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(AnalyticLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(TypeStatistic)
                            .addComponent(Statistic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AnalyticLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Day)
                            .addComponent(Month)
                            .addComponent(textDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Year)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(362, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
    private JPanel Analytic;
    private JComboBox Statistic;
    private JLabel TypeStatistic;
    private JLabel Day;
    private JLabel Month;
    private JLabel Year;
    private JTextField textDay;
    private JTextField textMonth;
    private JTextField textField3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
