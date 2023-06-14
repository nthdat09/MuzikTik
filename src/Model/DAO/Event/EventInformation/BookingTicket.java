package Model.DAO.Event.EventInformation;

import Model.BEAN.Ticket.TicketID;
import Model.Database.UserDatabase;
import View.EventPage.EventPanel;
import View.Home.HomePanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class BookingTicket {
    private static String selectedSeatID;
    private static Integer selectedEventID;
    public static List<TicketID> bookingTicket() {
        selectedSeatID = EventPanel.getSeatID();
        selectedEventID = HomePanel.getSelectedEventID();
        List<TicketID> result = new ArrayList<>();
        TicketID ticketID = null;
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Select * from mctmsys.ticket where TKT_SEAT_ID = '" + selectedSeatID + "' AND TKT_EVT_ID = '" + selectedEventID + "'";
            PreparedStatement st = con.prepareCall(sql);
            java.sql.ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Integer ticketIDNumber = rs.getInt("TKT_ID");
                ticketID = new TicketID(ticketIDNumber);
                result.add(ticketID);
            }
            st.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
