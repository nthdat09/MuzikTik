package Model.DAO.Ticket;

import Model.BEAN.TicketBooking.TicketBooking;
import Model.Database.UserDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    public static TicketDAO getInstance() {
        return new TicketDAO();
    }
    public TicketBooking selectByID(int ID) throws SQLException {
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "Select * from mctmsys.ticket where TKT_ID = " + ID + ";";
            System.out.println(sql);
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TicketBooking ticketBooking = new TicketBooking();
                ticketBooking.setTicketID(rs.getInt("TKT_ID"));
                ticketBooking.setEventID(rs.getInt("TKT_EVT_ID"));
                ticketBooking.setPrice(rs.getInt("TKT_PRICE"));
                ticketBooking.setStageID(rs.getInt("TKT_STG_ID"));
                ticketBooking.setSeatID(rs.getInt("TKT_SEAT_ID"));
                return ticketBooking;
            }
            ps.close();
            rs.close();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateTicket(TicketBooking ticketBooking) throws SQLException {
        int rowChanged = 0;
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "Update mctmsys.ticket set TKT_EVT_ID = ?, TKT_PRICE = ?, TKT_STG_ID = ?, TKT_SEAT_ID = ? where TKT_ID = ?;";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, ticketBooking.getEventID());
            ps.setDouble(2, (double) ticketBooking.getPrice());
            ps.setInt(3, ticketBooking.getStageID());
            ps.setInt(4, ticketBooking.getSeatID());
            ps.setInt(5, ticketBooking.getTicketID());
            rowChanged = ps.executeUpdate();
            System.out.println("Row changed: " + rowChanged);
            ps.close();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return rowChanged;
    }

    public int addTicket(TicketBooking oldTicketBooking) throws SQLException {
        int rowChanged = 0;
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Insert into mctmsys.ticket(TKT_ID, TKT_EVT_ID, TKT_PRICE, TKT_STG_ID, TKT_SEAT_ID) values(?, ?, ?, ?, ?);";

            System.out.println(sql);

            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, oldTicketBooking.getTicketID());
            ps.setInt(2, oldTicketBooking.getEventID());
            ps.setInt(3, (int) oldTicketBooking.getPrice());
            ps.setInt(4, oldTicketBooking.getStageID());
            ps.setInt(5, oldTicketBooking.getSeatID());

            rowChanged = ps.executeUpdate();
            System.out.println("Row changed: " + rowChanged);

            ps.close();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return rowChanged;
    }

    public int deleteTicket(int ID) throws SQLException {
        int rowChanged = 0;
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "Delete from mctmsys.ticket where TKT_ID = ?;";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, ID);
            rowChanged = ps.executeUpdate();
            ps.close();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return rowChanged;
    }

    public static List<TicketBooking>  getTicketList(){
        List<TicketBooking> result = new ArrayList<>();
        TicketBooking ticketBooking = null;
        try {
            // Tạo kết nối đến CSDL
            Connection con = UserDatabase.getConnection();

            // Tạo ra đối tượng PreparedStatement
            String sql = "SELECT * FROM mctmsys.ticket";
            PreparedStatement st = con.prepareCall(sql);

            // Thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Tìm kiếm trong database
            while(rs.next()) {
                ticketBooking = new TicketBooking();
                ticketBooking.setTicketID(rs.getInt("TKT_ID"));
                ticketBooking.setEventID(rs.getInt("TKT_EVT_ID"));
                ticketBooking.setPrice(rs.getInt("TKT_PRICE"));
                ticketBooking.setStageID(rs.getInt("TKT_STG_ID"));
                ticketBooking.setSeatID(rs.getInt("TKT_SEAT_ID"));
                result.add(ticketBooking);
            }

            // Đóng kết nối đến CSDL
            st.close();
            rs.close();
            UserDatabase.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
