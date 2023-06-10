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
    public static Path getAbsolutePath() {
        // Get Current Directory using getAbsolutePath()
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        return currentPath;
    }
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
                if (eventPictureBlob != null) {
                    byte[] eventPictureByte = eventPictureBlob.getBytes(1, (int) eventPictureBlob.length());
                    ImageIcon eventPicture = new ImageIcon(eventPictureByte);
                    String eventName = rs.getString("EVT_NAME");
                    String eventDate = rs.getString("EVT_DATE");
                    eventList = new EventList(eventPicture, eventName, eventDate);
                }
                else {
                    Path workingDir = getAbsolutePath();
                    // Set default avatar
                    Path filePath = Paths.get(workingDir.toString(), "src", "Asset", "Event", "4F0C27.jpg");
                    File file = new File(filePath.toString());

                    // Convert file to byte[]
                    FileInputStream fis = null;
                    try {
                        fis = new FileInputStream(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] buf = new byte[1024];
                    try {
                        for (int readNum; (readNum = fis.read(buf)) != -1;) {
                            bos.write(buf, 0, readNum); //no doubt here is 0
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    byte[] eventPictureByte = bos.toByteArray();
                    ImageIcon eventPicture = new ImageIcon(eventPictureByte);
                    String eventName = rs.getString("EVT_NAME");
                    String eventDate = rs.getString("EVT_DATE");
                    eventList = new EventList(eventPicture, eventName, eventDate);
                }
            }

            result.add(eventList);
            st.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
