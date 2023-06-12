package Model.DAO.Event.EventInformation;

import Model.BEAN.EventArtID;
import Model.Database.UserDatabase;
import View.EventPage.EventPanel;
import View.Home.HomePanel;

import javax.swing.*;
import java.awt.*;
import java.sql.Blob;
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
            String sql = "Select * from mctmsys.event where EVT_ID = '" + selectedEventID + "' ORDER BY EVT_ID DESC";
            PreparedStatement st = con.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Blob artID = rs.getBlob("EVT_POSTER");
                byte[] eventPictureByte = artID.getBytes(1, (int) artID.length());
                ImageIcon eventPicture = new ImageIcon(eventPictureByte);
                EventPanel.getEventArt().setIcon(eventPicture);
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
