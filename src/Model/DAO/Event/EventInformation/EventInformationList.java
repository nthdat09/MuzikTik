package Model.DAO.Event.EventInformation;

import Model.BEAN.EventInformation;
import Model.Database.UserDatabase;
import View.Home.HomePanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EventInformationList {
    private static String selectedEvent;
    public static List<EventInformation> getEventInformationList() {
        selectedEvent = HomePanel.getSelectedEvent();
        List<EventInformation> result = new ArrayList<>();
        EventInformation eventInformation = null;
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Select * from mctmsys.event where EVT_NAME = '" + selectedEvent + "'";
            PreparedStatement st = con.prepareCall(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Integer eventID = rs.getInt("EVT_ID");
                String eventName = rs.getString("EVT_NAME");
                Integer eventStageID = rs.getInt("EVT_STG_ID");
                Integer eventArtistID = rs.getInt("EVT_ART_ID");
                LocalDate eventDate = rs.getDate("EVT_DATE").toLocalDate();
                LocalTime eventOpenTime = rs.getTime("EVT_OPEN_TIME").toLocalTime();
                LocalTime eventCloseTime = rs.getTime("EVT_END_TIME").toLocalTime();
                Integer eventQuantity = rs.getInt("EVT_QUANTITY");
                String eventDescription = rs.getString("EVT_DESCRIPTION");

                eventInformation = new EventInformation(eventID, eventName, eventStageID, eventArtistID, eventDate, eventOpenTime, eventCloseTime, eventQuantity, eventDescription);
                result.add(eventInformation);
            }
            st.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
