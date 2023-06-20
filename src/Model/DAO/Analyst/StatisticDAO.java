package Model.DAO.Analyst;

import Model.BEAN.Analyst.Statistic;
import Model.Database.UserDatabase;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatisticDAO {

    public static StatisticDAO getInstance() {
        return new StatisticDAO();
    }

    public List<Statistic> getMonthlyTicketRevenue(String month, String year) {
        List<Statistic> statisticList = new ArrayList<>();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Connection con = UserDatabase.getConnection();
        String sqlMonthlyRevenue = "select date(tbk_datetime) as date,SUM(TKT_PRICE) as revenue from mctmsys.ticket " +
                "join mctmsys.ticket_booking tb on ticket.TKT_ID = tb.TBK_TKT_ID where exists(\n" +
                "    select TBK_TKT_ID from mctmsys.ticket_booking where month(TBK_DATETIME) = " + month + " and\n" +
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
                statisticList.add(new Statistic(type, revenue));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return statisticList;

    }

    public List<Statistic> getAnnualTicketRevenue(String year) {
        List<Statistic> statisticList = new ArrayList<>();
        DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
        Connection con = UserDatabase.getConnection();
        String sqlAnnualRevenue = "SELECT \n" +
                "  MONTH(TBK_DATETIME) AS MONTH, \n" +
                "  SUM(TKT_PRICE) AS TOTAL_REVENUE \n" +
                "FROM \n" +
                "  mctmsys.ticket \n" +
                "  JOIN mctmsys.ticket_booking ON TICKET.TKT_ID = TICKET_BOOKING.TBK_TKT_ID \n" +
                "  JOIN mctmsys.event ON TICKET.TKT_EVT_ID = EVENT.EVT_ID \n" +
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
                statisticList.add(new Statistic(type, revenue));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return statisticList;
    }

    public List<Statistic> getEventbasedTicketRevenue(String event) {
        List<Statistic> statisticList = new ArrayList<>();
        DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
        Connection con = UserDatabase.getConnection();
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        String sqlEventTicket = "SELECT SEAT_TYPE, SUM(TKT_PRICE) AS TOTAL_REVENUE FROM EVENT JOIN TICKET ON EVENT.EVT_ID = TICKET.TKT_EVT_ID\n" +
                "                        join ticket_booking tb on ticket.TKT_ID = tb.TBK_TKT_ID\n" +
                "                        JOIN seat s on ticket.TKT_SEAT_ID = s.SEAT_ID and ticket.TKT_STG_ID = s.SEAT_STG_ID\n" +
                "                                                  WHERE EVT_NAME = '" + event + "'\n" +
                "                        group by SEAT_TYPE;";
        try {
            PreparedStatement ps = con.prepareStatement(sqlEventTicket);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String type = rs.getString("SEAT_TYPE");
                int revenue = rs.getInt("TOTAL_REVENUE");
                dataset2.setValue(revenue, "Revenue", type);
                statisticList.add(new Statistic(type, revenue));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return statisticList;
    }

    public List<Statistic> getDailyTicketSalesStatistics(String day, String month, String year) {
        List<Statistic> statisticList = new ArrayList<>();
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        Connection con = UserDatabase.getConnection();
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
                statisticList.add(new Statistic(type, revenue));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return statisticList;
    }

    public List<Statistic> getMonthlyTicketSalesStatistics(String month, String year) {
        List<Statistic> statisticList = new ArrayList<>();
        DefaultCategoryDataset dataset5 = new DefaultCategoryDataset();
        Connection con = UserDatabase.getConnection();
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
                statisticList.add(new Statistic(type, revenue));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return statisticList;
    }

    public List<Statistic> getAnnualTicketSalesStatistics(String year) {
        List<Statistic> statisticList = new ArrayList<>();
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        Connection con = UserDatabase.getConnection();
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
                statisticList.add(new Statistic(type, revenue));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return statisticList;
    }
}
