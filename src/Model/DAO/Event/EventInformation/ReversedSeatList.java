package Model.DAO.Event.EventInformation;

import Model.BEAN.ReversedSeat;
import Model.Database.UserDatabase;
import View.EventPage.EventPanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ReversedSeatList {
    private static String selectedSeatID;
    public static List<ReversedSeat> reversedSeatList() {
        selectedSeatID = EventPanel.getSeatID();
        List<ReversedSeat> result = new ArrayList<>();
        ReversedSeat reversedSeat = null;
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Select * from mctmsys.ticket where TKT_SEAT_ID = '" + selectedSeatID + "'";
            PreparedStatement st = con.prepareCall(sql);
            java.sql.ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String eventID = rs.getString("TKT_EVT_ID");
                String stageID = rs.getString("TKT_STG_ID");
                reversedSeat = new ReversedSeat(eventID,stageID);
                result.add(reversedSeat);
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
