/*
 * Created by JFormDesigner on Sat Jun 03 12:43:05 ICT 2023
 */

package View.AnalyticPage;

import java.awt.*;
import javax.swing.*;

/**
 * @author mangg
 */
public class AnalyticPanel extends JPanel {
    public AnalyticPanel() {
        initComponents();
    }

    public JLabel getYear() {
        return Year;
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Man
        Year = new JLabel();
        textField3 = new JTextField();
        Statistic = new JComboBox();
        TypeStatistic = new JLabel();
        textDay = new JTextField();
        Day = new JLabel();
        textMonth = new JTextField();
        Month = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
        new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e"
        , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 )
        , java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );

        //---- Year ----
        Year.setText("Year");
        Year.setFont(new Font("Lato Black", Font.BOLD, 16));

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

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(TypeStatistic)
                            .addGap(36, 36, 36)
                            .addComponent(Statistic, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Day)
                            .addGap(12, 12, 12)
                            .addComponent(textDay, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(Month)
                            .addGap(18, 18, 18)
                            .addComponent(textMonth, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Year)
                            .addGap(18, 18, 18)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(TypeStatistic))
                        .addComponent(Statistic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(textDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(Day)
                                .addComponent(Month)
                                .addComponent(Year))))
                    .addContainerGap(470, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Man
    private JLabel Year;
    private JTextField textField3;
    private JComboBox Statistic;
    private JLabel TypeStatistic;
    private JTextField textDay;
    private JLabel Day;
    private JTextField textMonth;
    private JLabel Month;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
