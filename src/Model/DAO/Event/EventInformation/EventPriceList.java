package Model.DAO.Event.EventInformation;

import Model.BEAN.Event.EventPrice;
import Model.Database.UserDatabase;
import View.Home.HomePanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventPriceList {
    private static Integer selectedEventID;
    private static Integer selectedStageID;
    public static List<EventPrice> getEventPriceList() {
        selectedEventID = HomePanel.getSelectedEventID();
        selectedStageID = HomePanel.getSelectedStage();
        List<EventPrice> result = new ArrayList<>();
        EventPrice eventPrice = null;
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Select DISTINCT TKT_PRICE, SEAT_TYPE from mctmsys.ticket join mctmsys.seat on ticket.TKT_SEAT_ID = seat.SEAT_ID where TKT_STG_ID = " + selectedStageID + " and TKT_EVT_ID = '" + selectedEventID + "' ";
            PreparedStatement st = con.prepareCall(sql);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                Integer ticketPrice = rs.getInt("TKT_PRICE");
                String seatType = rs.getString("SEAT_TYPE");
                eventPrice = new EventPrice(seatType, ticketPrice);
                result.add(eventPrice);
            }
            st.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
