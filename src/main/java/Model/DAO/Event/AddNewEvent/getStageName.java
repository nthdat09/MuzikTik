package Model.DAO.Event.AddNewEvent;

import Model.Database.UserDatabase;
import View.EventPage.EventInformationPanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getStageName {
    public static void getStageName() {
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "SELECT STG_NAME FROM mctmsys.stage";
            PreparedStatement st = con.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String stageName = rs.getString("STG_NAME");
                EventInformationPanel.getStageComboBox().addItem(stageName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
