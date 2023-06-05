package Model.DAO.Event.EventInformation;

import Model.Database.UserDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventStatus {
    public static String getStatus(String ticketID) {
        try {
            Connection con = UserDatabase.getConnection();
            String sqlTicketBooked = "Select TBK_TKT_ID from mctmsys.ticket_booking";
            PreparedStatement st = con.prepareCall(sqlTicketBooked);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String ticketBooked = rs.getString("TBK_TKT_ID");
                if(ticketID.equals(ticketBooked)) {
                    return "Booked";
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Available";
    }
}
