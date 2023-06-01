package Model.DAO.Event.EventInformation;

import Model.BEAN.StageInformation;
import Model.Database.UserDatabase;
import View.Home.HomePanel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetStageName {
    private static Integer selectedStage;
    public static List<StageInformation> getStageInformationList() {
        selectedStage = HomePanel.getSelectedStage();
        List<StageInformation> result = new ArrayList<>();
        StageInformation stageInformation = null;
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Select * from mctmsys.stage where STG_ID = '" + selectedStage + "'";
            PreparedStatement st = con.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String eventName = rs.getString("STG_NAME");
                String eventSeatingChart = rs.getString("STG_MAP");
                stageInformation = new StageInformation(eventName,eventSeatingChart);
                result.add(stageInformation);
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
