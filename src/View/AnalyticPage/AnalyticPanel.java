/*
 * Created by JFormDesigner on Sat Jun 03 12:43:05 ICT 2023
 */

package View.AnalyticPage;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import Model.Database.UserDatabase;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

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

    private void label1MouseClicked(MouseEvent e) {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Man
        Analytic = new JPanel();
        Statistic = new JComboBox<>();
        TypeStatistic = new JLabel();
        Day = new JLabel();
        Month = new JLabel();
        Year = new JLabel();
        textDay = new JTextField();
        textMonth = new JTextField();
        textYear = new JTextField();
        panel1 = new JPanel();
        label1 = new JLabel();
        chartView = new JPanel();

        //======== Analytic ========
        {
            Analytic.setBackground(Color.white);
            Analytic.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
            , 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
            Analytic. getBorder( )) ); Analytic. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- Statistic ----
            Statistic.setFont(new Font("Lato Black", Font.BOLD, 16));
            Statistic.setModel(new DefaultComboBoxModel<>(new String[] {
                "Monthly Ticket Revenue",
                "Annual Ticket Revenue",
                "Event-based Ticket Revenue",
                "Daily Ticket Sales Statistics",
                "Monthly Ticket Sales Statistics",
                "Annual Ticket Sales Statistics"
            }));

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

            //======== panel1 ========
            {
                panel1.setLayout(new GridLayout());

                //---- label1 ----
                label1.setText("text");
                label1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        label1MouseClicked(e);
                    }
                });
                panel1.add(label1);
            }

            //======== chartView ========
            {
                chartView.setLayout(new GridLayout());
            }

            GroupLayout AnalyticLayout = new GroupLayout(Analytic);
            Analytic.setLayout(AnalyticLayout);
            AnalyticLayout.setHorizontalGroup(
                AnalyticLayout.createParallelGroup()
                    .addGroup(AnalyticLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(AnalyticLayout.createParallelGroup()
                            .addComponent(chartView, GroupLayout.PREFERRED_SIZE, 965, GroupLayout.PREFERRED_SIZE)
                            .addGroup(AnalyticLayout.createSequentialGroup()
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
                                        .addComponent(textYear, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Statistic))
                                .addGap(43, 43, 43)
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(130, Short.MAX_VALUE))
            );
            AnalyticLayout.setVerticalGroup(
                AnalyticLayout.createParallelGroup()
                    .addGroup(AnalyticLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(AnalyticLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(TypeStatistic)
                            .addComponent(Statistic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AnalyticLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Day)
                            .addComponent(Month)
                            .addComponent(textDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Year)
                            .addComponent(textYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(chartView, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Man
    private JPanel Analytic;
    private JComboBox<String> Statistic;
    private JLabel TypeStatistic;
    private JLabel Day;
    private JLabel Month;
    private JLabel Year;
    private JTextField textDay;
    private JTextField textMonth;
    private JTextField textYear;
    private JPanel panel1;
    private JLabel label1;
    private JPanel chartView;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
