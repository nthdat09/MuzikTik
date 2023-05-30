package Model.DAO.Event;

import Model.BEAN.EventList;
import Model.Database.UserDatabase;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Event {
    public static List<EventList> getEventList() {
        List<EventList> result = new ArrayList<>();
        EventList eventList = null;
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "SELECT * FROM mctmsys.eventtest";
            PreparedStatement st = con.prepareCall(sql);

            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                String eventPicture = rs.getString("eventPicture");
                String eventName = rs.getString("eventName");
                String eventDate = rs.getString("eventDate");
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
