/*
 * Created by JFormDesigner on Sun Jun 04 13:50:17 ICT 2023
 */

package View.AnalyticPage;

import javax.swing.border.*;
import Model.Database.UserDatabase;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author mangg
 */
public class AnalyticPage extends JPanel {
    public AnalyticPage() {
        initComponents();
        textDay.setEnabled(false);
        textEvent.setEnabled(false);
        textDay.setBackground(Color.decode("#999999"));
        textEvent.setBackground(Color.decode("#999999"));
    }
    private void label1MouseClicked(MouseEvent e) {
        String selectedRevenue = Statistic.getSelectedItem().toString();
        Connection con = UserDatabase.getConnection();
        int month;
        int year;
        switch(selectedRevenue) {
            case "Monthly Ticket Revenue":
                month = Integer.parseInt(textMonth.getText());
                year = Integer.parseInt(textYear.getText());
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                String sqlMonthlyRevenue = "select date(tbk_datetime) as date,SUM(TKT_PRICE) as revenue from ticket join ticket_booking tb on ticket.TKT_ID = tb.TBK_TKT_ID where exists(\n" +
                        "    select TBK_TKT_ID from ticket_booking where month(TBK_DATETIME) = " + month + " and\n" +
                        "                                                year(TBK_DATETIME) = "+ year +"\n" +
                        "                                       )\n" +
                        "    group by date\n" +
                        "    order by date;";
                try {
                    PreparedStatement ps = con.prepareStatement(sqlMonthlyRevenue);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()) {
                        String type = rs.getString("date");
                        int revenue = rs.getInt("revenue");
                        dataset.setValue(revenue, "Revenue", type);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                JFreeChart chart = ChartFactory.createBarChart("Revenue", "Type", "Revenue", dataset);
                CategoryPlot categoryPlot = chart.getCategoryPlot();
                categoryPlot.setRangeGridlinePaint(Color.black);

                ChartPanel chartPanel = new ChartPanel(chart);
                chartView.removeAll();
                chartView.add(chartPanel, BorderLayout.CENTER);
                chartView.validate();
                break;
            case "Annual Ticket Revenue":
                year = Integer.parseInt(textYear.getText());
                DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
                String sqlAnnualRevenue = "SELECT \n" +
                        "  MONTH(TBK_DATETIME) AS MONTH, \n" +
                        "  SUM(TKT_PRICE) AS TOTAL_REVENUE \n" +
                        "FROM \n" +
                        "  TICKET \n" +
                        "  JOIN TICKET_BOOKING ON TICKET.TKT_ID = TICKET_BOOKING.TBK_TKT_ID \n" +
                        "  JOIN EVENT ON TICKET.TKT_EVT_ID = EVENT.EVT_ID \n" +
                        "WHERE \n" +
                        "  YEAR(TBK_DATETIME) = '" + year + "'\n" +
                        "GROUP BY \n" +
                        "  MONTH(TBK_DATETIME);";
                try {
                    PreparedStatement ps = con.prepareStatement(sqlAnnualRevenue);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()) {
                        String type = rs.getString("MONTH");
                        int revenue = rs.getInt("TOTAL_REVENUE");
                        dataset3.setValue(revenue, "Revenue", type);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                JFreeChart chart3 = ChartFactory.createBarChart("Revenue", "Type", "Revenue", dataset3);
                CategoryPlot categoryPlot3 = chart3.getCategoryPlot();
                categoryPlot3.setRangeGridlinePaint(Color.black);

                ChartPanel chartPanel3 = new ChartPanel(chart3);
                chartView.removeAll();
                chartView.add(chartPanel3, BorderLayout.CENTER);
                chartView.validate();
                break;
            case "Event-based Ticket Revenue":
                String event = textEvent.getText();
                DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
                String sqlEventTicket = "SELECT EVT_NAME, SUM(TKT_PRICE) * COUNT(*) AS TOTAL_REVENUE\n" +
                        "FROM EVENT\n" +
                        "JOIN TICKET ON EVENT.EVT_ID = TICKET.TKT_EVT_ID\n" +
                        "JOIN TICKET_BOOKING ON TICKET.TKT_ID = TICKET_BOOKING.TBK_TKT_ID\n" +
                        "WHERE EVT_NAME = '" + event + "';";
                try {
                    PreparedStatement ps = con.prepareStatement(sqlEventTicket);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()) {
                        String type = rs.getString("EVT_NAME");
                        int revenue = rs.getInt("TOTAL_REVENUE");
                        dataset2.setValue(revenue, "Revenue", type);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                JFreeChart chart2 = ChartFactory.createBarChart("Revenue", "Type", "Revenue", dataset2);
                CategoryPlot categoryPlot2 = chart2.getCategoryPlot();
                categoryPlot2.setRangeGridlinePaint(Color.black);

                ChartPanel chartPanel2 = new ChartPanel(chart2);
                chartView.removeAll();
                chartView.add(chartPanel2, BorderLayout.CENTER);
                chartView.validate();
                break;
            case "Daily Ticket Sales Statistics":
                String day = textDay.getText();
                month = Integer.parseInt(textMonth.getText());
                year = Integer.parseInt(textYear.getText());
                String date = year + "-" + month + "-" + day;
                DefaultCategoryDataset dataset4 = new DefaultCategoryDataset();
                String sqlDailyTicket =  "SELECT \n" +
                        "  EVT_NAME, \n" +
                        "  COUNT(*) AS TOTAL_TICKETS_SOLD \n" +
                        "FROM \n" +
                        "  EVENT \n" +
                        "  JOIN TICKET ON EVENT.EVT_ID = TICKET.TKT_EVT_ID \n" +
                        "  JOIN TICKET_BOOKING ON TICKET.TKT_ID = TICKET_BOOKING.TBK_TKT_ID \n" +
                        "WHERE \n" +
                        "  DATE(TBK_DATETIME) = '"+ date +"'\n" +
                        "GROUP BY \n" +
                        "  EVT_NAME;";
                try {
                    PreparedStatement ps = con.prepareStatement(sqlDailyTicket);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()) {
                        String type = rs.getString("EVT_NAME");
                        int revenue = rs.getInt("TOTAL_TICKETS_SOLD");
                        dataset4.setValue(revenue, "Revenue", type);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                JFreeChart chart4 = ChartFactory.createBarChart("Revenue", "Type", "Revenue", dataset4);
                CategoryPlot categoryPlot4 = chart4.getCategoryPlot();
                categoryPlot4.setRangeGridlinePaint(Color.black);

                ChartPanel chartPanel4 = new ChartPanel(chart4);
                chartView.removeAll();
                chartView.add(chartPanel4, BorderLayout.CENTER);
                chartView.validate();
                break;
            case "Monthly Ticket Sales Statistics":
                month = Integer.parseInt(textMonth.getText());
                year = Integer.parseInt(textYear.getText());
                DefaultCategoryDataset dataset5 = new DefaultCategoryDataset();
                String sqlMonthlyTicket = "SELECT \n" +
                        "  EVT_NAME, \n" +
                        "  COUNT(*) AS TOTAL_TICKETS_SOLD \n" +
                        "FROM \n" +
                        "  EVENT \n" +
                        "  JOIN TICKET ON EVENT.EVT_ID = TICKET.TKT_EVT_ID \n" +
                        "  JOIN TICKET_BOOKING ON TICKET.TKT_ID = TICKET_BOOKING.TBK_TKT_ID \n" +
                        "WHERE \n" +
                        "  MONTH(TBK_DATETIME) = '" + month + "' \n" +
                        "  AND YEAR(TBK_DATETIME) = '" + year + "' \n" +
                        "GROUP BY \n" +
                        "  EVT_NAME;";
                try {
                    PreparedStatement ps = con.prepareStatement(sqlMonthlyTicket);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()) {
                        String type = rs.getString("EVT_NAME");
                        int revenue = rs.getInt("TOTAL_TICKETS_SOLD");
                        dataset5.setValue(revenue, "Revenue", type);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                JFreeChart chart5 = ChartFactory.createBarChart("Revenue", "Type", "Revenue", dataset5);
                CategoryPlot categoryPlot5 = chart5.getCategoryPlot();
                categoryPlot5.setRangeGridlinePaint(Color.black);

                ChartPanel chartPanel5 = new ChartPanel(chart5);
                chartView.removeAll();
                chartView.add(chartPanel5, BorderLayout.CENTER);
                chartView.validate();
                break;
            case "Annual Ticket Sales Statistics":
                year = Integer.parseInt(textYear.getText());
                DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
                String sqlAnnualTicket = "SELECT MONTH(TBK_DATETIME) AS ticket_month, COUNT(*) AS ticket_count\n" +
                        "FROM ticket_booking\n" +
                        "WHERE YEAR(TBK_DATETIME) = " + year + "\n" +
                        "GROUP BY ticket_month\n" +
                        "ORDER BY ticket_month;";
                try {
                    PreparedStatement ps = con.prepareStatement(sqlAnnualTicket);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()) {
                        String type = rs.getString("ticket_month");
                        int revenue = rs.getInt("ticket_count");
                        dataset1.setValue(revenue, "Revenue", type);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                JFreeChart chart1 = ChartFactory.createBarChart("Revenue", "Type", "Revenue", dataset1);
                CategoryPlot categoryPlot1 = chart1.getCategoryPlot();
                categoryPlot1.setRangeGridlinePaint(Color.black);

                ChartPanel chartPanel1 = new ChartPanel(chart1);
                chartView.removeAll();
                chartView.add(chartPanel1, BorderLayout.CENTER);
                chartView.validate();
                break;
        }
    }

    public JComboBox<String> getStatistic() {
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

    private void StatisticItemStateChanged(ItemEvent e) {
        if(Statistic.getSelectedItem().toString() == "Monthly Ticket Revenue") {
            textDay.setEnabled(false);
            textMonth.setEnabled(true);
            textYear.setEnabled(true);
            textEvent.setEnabled(false);
            textDay.setBackground(Color.decode("#999999"));
            textEvent.setBackground(Color.decode("#999999"));
            textMonth.setBackground(Color.white);
            textYear.setBackground(Color.white);
        } else if (Statistic.getSelectedItem().toString() == "Annual Ticket Revenue") {
            textDay.setEnabled(false);
            textMonth.setEnabled(false);
            textYear.setEnabled(true);
            textEvent.setEnabled(false);
            textDay.setBackground(Color.decode("#999999"));
            textMonth.setBackground(Color.decode("#999999"));
            textEvent.setBackground(Color.decode("#999999"));
            textYear.setBackground(Color.white);
        } else if (Statistic.getSelectedItem().toString() == "Event-based Ticket Revenue") {
            textDay.setEnabled(false);
            textMonth.setEnabled(false);
            textYear.setEnabled(false);
            textEvent.setEnabled(true);
            textDay.setBackground(Color.decode("#999999"));
            textMonth.setBackground(Color.decode("#999999"));
            textYear.setBackground(Color.decode("#999999"));
            textEvent.setBackground(Color.white);
        } else if (Statistic.getSelectedItem().toString() == "Daily Ticket Sales Statistics") {
            textDay.setEnabled(true);
            textMonth.setEnabled(true);
            textYear.setEnabled(true);
            textEvent.setEnabled(false);
            textEvent.setBackground(Color.decode("#999999"));
            textDay.setBackground(Color.white);
            textMonth.setBackground(Color.white);
            textYear.setBackground(Color.white);
        } else if (Statistic.getSelectedItem().toString() == "Monthly Ticket Sales Statistics") {
            textDay.setEnabled(false);
            textMonth.setEnabled(true);
            textYear.setEnabled(true);
            textEvent.setEnabled(false);
            textDay.setBackground(Color.decode("#999999"));
            textEvent.setBackground(Color.decode("#999999"));
            textMonth.setBackground(Color.white);
            textYear.setBackground(Color.white);
        } else if (Statistic.getSelectedItem().toString() == "Annual Ticket Sales Statistics") {
            textDay.setEnabled(false);
            textMonth.setEnabled(false);
            textYear.setEnabled(true);
            textEvent.setEnabled(false);
            textDay.setBackground(Color.decode("#999999"));
            textMonth.setBackground(Color.decode("#999999"));
            textEvent.setBackground(Color.decode("#999999"));
            textYear.setBackground(Color.white);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Man
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
        textEvent = new JTextField();

        //======== this ========
        setBackground(Color.white);
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
        EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing
        . border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,
        java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
        { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )
        throw new RuntimeException( ) ;} } );

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
        Statistic.setBackground(Color.white);
        Statistic.addItemListener(e -> StatisticItemStateChanged(e));

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

        //---- textDay ----
        textDay.setBackground(Color.white);

        //---- textMonth ----
        textMonth.setBackground(Color.white);

        //---- textYear ----
        textYear.setBackground(Color.white);

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
            chartView.setBorder(new TitledBorder("Chart View"));
            chartView.setBackground(Color.white);
            chartView.setLayout(new GridLayout());
        }

        //---- textEvent ----
        textEvent.setBackground(Color.white);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
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
                                    .addComponent(textYear, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                            .addGap(88, 88, 88)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textEvent, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(133, 133, 133)
                            .addComponent(chartView, GroupLayout.PREFERRED_SIZE, 733, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(textEvent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(TypeStatistic))
                                .addComponent(Statistic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(textDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(Day)
                                        .addComponent(Month)
                                        .addComponent(Year))))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(chartView, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
                    .addGap(102, 102, 102))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Man
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
    private JTextField textEvent;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
