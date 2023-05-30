package Model.BEAN;

import Model.DAO.Event.EventInformation.EventInformation;
import Model.DAO.Event.EventInformation.StageInformation;
import Model.Database.UserDatabase;
import View.Home.HomePanel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GetStageName {
    private static Integer selectedStage = HomePanel.getSelectedStage();
    public static List<StageInformation> getStageInformationList() {
        List<StageInformation> result = new ArrayList<>();
        StageInformation stageInformation = null;
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Select * from mctmsys.stage where STG_ID = '" + selectedStage + "'";
            PreparedStatement st = con.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String eventName = rs.getString("STG_NAME");
                stageInformation = new StageInformation(eventName);
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
