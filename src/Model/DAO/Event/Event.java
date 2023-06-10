package Model.DAO.Event;

import Model.BEAN.EventList;
import Model.Database.UserDatabase;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Event {
    public static List<EventList> getEventList() {
        List<EventList> result = new ArrayList<>();
        EventList eventList = null;
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "SELECT * FROM mctmsys.event";
            PreparedStatement st = con.prepareCall(sql);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                Blob eventPictureBlob = rs.getBlob("EVT_POSTER");
                byte[] eventPictureByte = eventPictureBlob.getBytes(1, (int) eventPictureBlob.length());
                ImageIcon eventPicture = new ImageIcon(eventPictureByte);
                String eventName = rs.getString("EVT_NAME");
                String eventDate = rs.getString("EVT_DATE");
                eventList = new EventList(eventPicture, eventName, eventDate);
                result.add(eventList);
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
