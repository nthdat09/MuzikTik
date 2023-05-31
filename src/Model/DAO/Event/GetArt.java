package Model.DAO.Event;

import Model.BEAN.EventArtID;
import Model.Database.UserDatabase;
import View.Home.HomePanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetArt {
    private static Integer selectedEventID;
    public static List<EventArtID> getArtByID() {
        selectedEventID = HomePanel.getSelectedEventID();
        List<EventArtID> result = new ArrayList<>();
        EventArtID eventArtID = null;
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Select * from mctmsys.eventtest where EVT_ID = '" + selectedEventID + "'";
            PreparedStatement st = con.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String artID = rs.getString("eventPicture");
                eventArtID = new EventArtID(artID);
                result.add(eventArtID);
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
