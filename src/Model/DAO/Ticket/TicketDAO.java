package Model.DAO.Ticket;

import Model.BEAN.Ticket;
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
    public Ticket selectByID(int ID) throws SQLException {
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "Select * from mctmsys.ticket where TKT_ID = " + ID + ";";
            System.out.println(sql);
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setTicketID(rs.getInt("TKT_ID"));
                ticket.setEventID(rs.getInt("TKT_EVT_ID"));
                ticket.setPrice(rs.getInt("TKT_PRICE"));
                ticket.setStageID(rs.getInt("TKT_STG_ID"));
                ticket.setSeatID(rs.getInt("TKT_SEAT_ID"));
                return ticket;
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

    public int updateTicket(Ticket ticket) throws SQLException {
        int rowChanged = 0;
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "Update mctmsys.ticket set TKT_EVT_ID = ?, TKT_PRICE = ?, TKT_STG_ID = ?, TKT_SEAT_ID = ? where TKT_ID = ?;";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, ticket.getEventID());
            ps.setDouble(2, (double) ticket.getPrice());
            ps.setInt(3, ticket.getStageID());
            ps.setInt(4, ticket.getSeatID());
            ps.setInt(5, ticket.getTicketID());
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

    public int addTicket(Ticket oldTicket) throws SQLException {
        int rowChanged = 0;
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Insert into mctmsys.ticket(TKT_ID, TKT_EVT_ID, TKT_PRICE, TKT_STG_ID, TKT_SEAT_ID) values(?, ?, ?, ?, ?);";

            System.out.println(sql);

            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, oldTicket.getTicketID());
            ps.setInt(2, oldTicket.getEventID());
            ps.setInt(3, (int) oldTicket.getPrice());
            ps.setInt(4, oldTicket.getStageID());
            ps.setInt(5, oldTicket.getSeatID());

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

    public static List<Ticket>  getTicketList(){
        List<Ticket> result = new ArrayList<>();
        Ticket ticket = null;
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
                ticket = new Ticket();
                ticket.setTicketID(rs.getInt("TKT_ID"));
                ticket.setEventID(rs.getInt("TKT_EVT_ID"));
                ticket.setPrice(rs.getInt("TKT_PRICE"));
                ticket.setStageID(rs.getInt("TKT_STG_ID"));
                ticket.setSeatID(rs.getInt("TKT_SEAT_ID"));
                result.add(ticket);
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
