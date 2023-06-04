package Model.DAO.Event.AddNewEvent;

import Model.Database.UserDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getLastestID {
    public static int getLatestID() {
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "SELECT MAX(EVT_ID) FROM event";
            PreparedStatement st = con.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("MAX(EVT_ID)");
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
