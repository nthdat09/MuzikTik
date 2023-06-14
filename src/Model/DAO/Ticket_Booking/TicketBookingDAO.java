package Model.DAO.Ticket_Booking;

import Model.BEAN.TicketBooking.TicketBooking;
import Model.Database.UserDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketBookingDAO {
    public static TicketBookingDAO getInstance() {
        return new TicketBookingDAO();
    }

    public static List<TicketBooking> getTicketByCustomerID(int customerID) {
        List<TicketBooking> purchasedHistory = new ArrayList<>();
        try{
            Connection con = UserDatabase.getConnection();

            String sql = "SELECT * FROM mctmsys.ticket WHERE TKT_ID IN (SELECT TBK_TKT_ID FROM mctmsys.ticket_booking WHERE TBK_CUS_ID = " + customerID + ");";

            PreparedStatement ps = con.prepareCall(sql);
            System.out.println(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                TicketBooking ticketBooking = new TicketBooking();
                ticketBooking.setTicketID(rs.getInt("TKT_ID"));
                ticketBooking.setEventID(rs.getInt("TKT_EVT_ID"));
                ticketBooking.setSeatID(rs.getInt("TKT_SEAT_ID"));
                ticketBooking.setPrice(rs.getInt("TKT_PRICE"));
                ticketBooking.setStageID(rs.getInt("TKT_STG_ID"));
                purchasedHistory.add(ticketBooking);
            }
            ps.close();
            rs.close();
            con.close();

            return purchasedHistory;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
