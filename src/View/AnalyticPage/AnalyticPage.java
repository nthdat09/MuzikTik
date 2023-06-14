/*
 * Created by JFormDesigner on Sun Jun 04 13:50:17 ICT 2023
 */

package View.AnalyticPage;

import Model.Database.UserDatabase;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author mangg
 */
public class AnalyticPage extends JPanel {
    public AnalyticPage() {
        initComponents();
        textEvent.setEnabled(false);
        dayComboBox.setBackground(Color.decode("#92CFAA"));
        textEvent.setBackground(Color.decode("#92CFAA"));
    }
    private void label1MouseClicked(MouseEvent e) {
        String selectedRevenue = Statistic.getSelectedItem().toString();
        Connection con = UserDatabase.getConnection();
        int month;
        int year;
        switch(selectedRevenue) {
            case "Monthly Ticket Revenue":
                month = Integer.parseInt(monthComboBox.getSelectedItem().toString());
                year = Integer.parseInt(yearComboBox.getSelectedItem().toString());
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

                JFreeChart chart = ChartFactory.createBarChart("Monthly Ticket Revenue", "Type", "Revenue", dataset);
                CategoryPlot categoryPlot = chart.getCategoryPlot();
                categoryPlot.setRangeGridlinePaint(Color.decode("#61B884"));
                chart.setBackgroundPaint(Color.WHITE);
                chart.getPlot().setBackgroundPaint(Color.white);

                ChartPanel chartPanel = new ChartPanel(chart);
                chartView.removeAll();
                chartView.add(chartPanel, BorderLayout.CENTER);
                chartView.validate();
                break;
            case "Annual Ticket Revenue":
                year = Integer.parseInt(yearComboBox.getSelectedItem().toString());
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

                JFreeChart chart3 = ChartFactory.createBarChart("Annual Ticket Revenue", "Type", "Revenue", dataset3);
                CategoryPlot categoryPlot3 = chart3.getCategoryPlot();
                categoryPlot3.setRangeGridlinePaint(Color.decode("#61B884"));
                chart3.setBackgroundPaint(Color.WHITE);
                chart3.getPlot().setBackgroundPaint(Color.white);

                ChartPanel chartPanel3 = new ChartPanel(chart3);
                chartView.removeAll();
                chartView.add(chartPanel3, BorderLayout.CENTER);
                chartView.validate();
                break;
            case "Event-based Ticket Revenue":
                String event = textEvent.getText();
                DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
                String sqlEventTicket = "SELECT EVT_NAME, SUM(TKT_PRICE) AS TOTAL_REVENUE\n" +
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

                JFreeChart chart2 = ChartFactory.createBarChart("Event-based Ticket Revenue", "Type", "Revenue", dataset2);
                CategoryPlot categoryPlot2 = chart2.getCategoryPlot();
                categoryPlot2.setRangeGridlinePaint(Color.decode("#61B884"));
                chart2.setBackgroundPaint(Color.WHITE);
                chart2.getPlot().setBackgroundPaint(Color.white);

                ChartPanel chartPanel2 = new ChartPanel(chart2);
                chartView.removeAll();
                chartView.add(chartPanel2, BorderLayout.CENTER);
                chartView.validate();
                break;
            case "Daily Ticket Sales Statistics":
                String day = dayComboBox.getSelectedItem().toString();
                month = Integer.parseInt(monthComboBox.getSelectedItem().toString());
                year = Integer.parseInt(yearComboBox.getSelectedItem().toString());
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

                JFreeChart chart4 = ChartFactory.createBarChart("Daily Ticket Sales Statistics", "Type", "Ticket", dataset4);
                CategoryPlot categoryPlot4 = chart4.getCategoryPlot();
                categoryPlot4.setRangeGridlinePaint(Color.decode("#61B884"));
                chart4.setBackgroundPaint(Color.WHITE);
                chart4.getPlot().setBackgroundPaint(Color.white);

                ChartPanel chartPanel4 = new ChartPanel(chart4);
                chartView.removeAll();
                chartView.add(chartPanel4, BorderLayout.CENTER);
                chartView.validate();
                break;
            case "Monthly Ticket Sales Statistics":
                month = Integer.parseInt(monthComboBox.getSelectedItem().toString());
                year = Integer.parseInt(yearComboBox.getSelectedItem().toString());
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

                JFreeChart chart5 = ChartFactory.createBarChart("Monthly Ticket Sales Statistics", "Type", "Ticket", dataset5);
                CategoryPlot categoryPlot5 = chart5.getCategoryPlot();
                categoryPlot5.setRangeGridlinePaint(Color.decode("#61B884"));
                chart5.setBackgroundPaint(Color.WHITE);
                chart5.getPlot().setBackgroundPaint(Color.white);

                ChartPanel chartPanel5 = new ChartPanel(chart5);
                chartView.removeAll();
                chartView.add(chartPanel5, BorderLayout.CENTER);
                chartView.validate();
                break;
            case "Annual Ticket Sales Statistics":
                year = Integer.parseInt(yearComboBox.getSelectedItem().toString());
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

                JFreeChart chart1 = ChartFactory.createBarChart("Annual Ticket Sales Statistics", "Type", "Ticket", dataset1);
                CategoryPlot categoryPlot1 = chart1.getCategoryPlot();
                categoryPlot1.setRangeGridlinePaint(Color.decode("#61B884"));
                chart1.setBackgroundPaint(Color.WHITE);
                chart1.getPlot().setBackgroundPaint(Color.white);

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
            dayComboBox.setEnabled(false);
            monthComboBox.setEnabled(true);
            yearComboBox.setEnabled(true);
            textEvent.setEnabled(false);
            dayComboBox.setBackground(Color.decode("#92CFAA"));
            textEvent.setBackground(Color.decode("#92CFAA"));
            monthComboBox.setBackground(Color.white);
            yearComboBox.setBackground(Color.white);
        } else if (Statistic.getSelectedItem().toString() == "Annual Ticket Revenue") {
            dayComboBox.setEnabled(false);
            monthComboBox.setEnabled(false);
            yearComboBox.setEnabled(true);
            textEvent.setEnabled(false);
            dayComboBox.setBackground(Color.decode("#92CFAA"));
            monthComboBox.setBackground(Color.decode("#92CFAA"));
            textEvent.setBackground(Color.decode("#92CFAA"));
            yearComboBox.setBackground(Color.white);
        } else if (Statistic.getSelectedItem().toString() == "Event-based Ticket Revenue") {
            dayComboBox.setEnabled(false);
            monthComboBox.setEnabled(false);
            yearComboBox.setEnabled(false);
            textEvent.setEnabled(true);
            dayComboBox.setBackground(Color.decode("#92CFAA"));
            monthComboBox.setBackground(Color.decode("#92CFAA"));
            yearComboBox.setBackground(Color.decode("#92CFAA"));
            textEvent.setBackground(Color.white);
        } else if (Statistic.getSelectedItem().toString() == "Daily Ticket Sales Statistics") {
            dayComboBox.setEnabled(true);
            monthComboBox.setEnabled(true);
            yearComboBox.setEnabled(true);
            textEvent.setEnabled(false);
            textEvent.setBackground(Color.decode("#92CFAA"));
            dayComboBox.setBackground(Color.white);
            monthComboBox.setBackground(Color.white);
            yearComboBox.setBackground(Color.white);
        } else if (Statistic.getSelectedItem().toString() == "Monthly Ticket Sales Statistics") {
            dayComboBox.setEnabled(false);
            monthComboBox.setEnabled(true);
            yearComboBox.setEnabled(true);
            textEvent.setEnabled(false);
            dayComboBox.setBackground(Color.decode("#92CFAA"));
            textEvent.setBackground(Color.decode("#92CFAA"));
            monthComboBox.setBackground(Color.white);
            yearComboBox.setBackground(Color.white);
        } else if (Statistic.getSelectedItem().toString() == "Annual Ticket Sales Statistics") {
            dayComboBox.setEnabled(false);
            monthComboBox.setEnabled(false);
            yearComboBox.setEnabled(true);
            textEvent.setEnabled(false);
            dayComboBox.setBackground(Color.decode("#92CFAA"));
            monthComboBox.setBackground(Color.decode("#92CFAA"));
            textEvent.setBackground(Color.decode("#92CFAA"));
            yearComboBox.setBackground(Color.white);
        }
    }

    private void comboBox2ItemStateChanged(ItemEvent e) {
        if(monthComboBox.getSelectedItem().toString() == "1" || monthComboBox.getSelectedItem().toString() == "3" ||
                monthComboBox.getSelectedItem().toString() == "5" || monthComboBox.getSelectedItem().toString() == "7" ||
                monthComboBox.getSelectedItem().toString() == "8" || monthComboBox.getSelectedItem().toString() == "10" ||
                monthComboBox.getSelectedItem().toString() == "12") {
            dayComboBox.removeAllItems();
            for(int i = 1; i <= 31; i++) {
                dayComboBox.addItem(i);
            }
        } else if(monthComboBox.getSelectedItem().toString() == "4" || monthComboBox.getSelectedItem().toString() == "6" ||
                monthComboBox.getSelectedItem().toString() == "9" || monthComboBox.getSelectedItem().toString() == "11") {
            dayComboBox.removeAllItems();
            for(int i = 1; i <= 30; i++) {
                dayComboBox.addItem(i);
            }
        } else if(monthComboBox.getSelectedItem().toString() == "2") {
            dayComboBox.removeAllItems();
            for(int i = 1; i <= 28; i++) {
                dayComboBox.addItem(i);
            }
        }
    }

    private void button1MouseClicked(MouseEvent e) {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        Statistic = new JComboBox<>();
        TypeStatistic = new JLabel();
        Day = new JLabel();
        Month = new JLabel();
        Year = new JLabel();
        panel1 = new JPanel();
        label1 = new JLabel();
        chartView = new JPanel();
        textEvent = new JTextField();
        title = new JLabel();
        label2 = new JLabel();
        dayComboBox = new JComboBox();
        monthComboBox = new JComboBox<>();
        yearComboBox = new JComboBox<>();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
        . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing
        . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
        Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );

        //---- Statistic ----
        Statistic.setFont(new Font("Lato", Font.PLAIN, 16));
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
        TypeStatistic.setText("Types of Statistics:");
        TypeStatistic.setFont(new Font("Lato Black", Font.BOLD, 16));
        TypeStatistic.setForeground(new Color(0x61b884));

        //---- Day ----
        Day.setText("Day:");
        Day.setFont(new Font("Lato Black", Font.BOLD, 16));
        Day.setForeground(new Color(0x61b884));

        //---- Month ----
        Month.setText("Month:");
        Month.setFont(new Font("Lato Black", Font.BOLD, 16));
        Month.setForeground(new Color(0x61b884));

        //---- Year ----
        Year.setText("Year:");
        Year.setFont(new Font("Lato Black", Font.BOLD, 16));
        Year.setForeground(new Color(0x61b884));

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0x61b884));
            panel1.setLayout(new GridLayout());

            //---- label1 ----
            label1.setText("ENTER");
            label1.setFont(new Font("Lato Black", Font.BOLD, 16));
            label1.setForeground(Color.white);
            label1.setBackground(Color.white);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
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
            chartView.setBorder(new TitledBorder(""));
            chartView.setBackground(Color.white);
            chartView.setLayout(new GridLayout());
        }

        //---- textEvent ----
        textEvent.setBackground(Color.white);
        textEvent.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- title ----
        title.setText("STATISTIC AND ANALYSIS");
        title.setFont(new Font("Lato Black", Font.PLAIN, 25));
        title.setBackground(Color.white);
        title.setForeground(new Color(0x61b884));

        //---- label2 ----
        label2.setText("Event:");
        label2.setFont(new Font("Lato Black", Font.BOLD, 16));
        label2.setForeground(new Color(0x61b884));

        //---- dayComboBox ----
        dayComboBox.setBackground(Color.white);
        dayComboBox.setFont(new Font("Lato", Font.BOLD, 16));

        //---- monthComboBox ----
        monthComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12"
        }));
        monthComboBox.setBackground(Color.white);
        monthComboBox.setFont(new Font("Lato", Font.BOLD, 16));
        monthComboBox.addItemListener(e -> comboBox2ItemStateChanged(e));

        //---- yearComboBox ----
        yearComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "2013",
            "2014",
            "2015",
            "2016",
            "2017",
            "2018",
            "2019",
            "2020",
            "2021",
            "2022",
            "2023"
        }));
        yearComboBox.setBackground(Color.white);
        yearComboBox.setFont(new Font("Lato", Font.BOLD, 16));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(436, 436, 436)
                    .addComponent(title)
                    .addContainerGap(420, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(chartView, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1102, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(TypeStatistic)
                                            .addGap(37, 37, 37))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(Day)
                                            .addGap(18, 18, 18)
                                            .addComponent(dayComboBox, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(Statistic, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(Month)
                                            .addGap(18, 18, 18)
                                            .addComponent(monthComboBox, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                            .addGap(68, 68, 68)
                                            .addComponent(Year)
                                            .addGap(18, 18, 18)
                                            .addComponent(yearComboBox, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(48, 48, 48)
                                    .addComponent(label2)
                                    .addGap(18, 18, 18)
                                    .addComponent(textEvent, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)))))
                    .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(title)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(TypeStatistic)
                        .addComponent(Statistic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(11, 11, 11)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Day)
                        .addComponent(Month)
                        .addComponent(dayComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(monthComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(yearComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Year)
                        .addComponent(label2)
                        .addComponent(textEvent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                    .addComponent(chartView, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)
                    .addGap(66, 66, 66))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
    private JComboBox<String> Statistic;
    private JLabel TypeStatistic;
    private JLabel Day;
    private JLabel Month;
    private JLabel Year;
    private JPanel panel1;
    private JLabel label1;
    private JPanel chartView;
    private JTextField textEvent;
    private JLabel title;
    private JLabel label2;
    private JComboBox dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
