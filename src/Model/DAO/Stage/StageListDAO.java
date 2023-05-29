package Model.DAO.Stage;

import Model.BEAN.Stage;
import Model.Database.UserDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StageListDAO {
    public static StageListDAO getInstance() {
        return new StageListDAO();
    }

    public static List<Stage> getList(){
        List<Stage> result = new ArrayList<>();
        Stage stage = null;

        try{
            Connection con = UserDatabase.getConnection();

            String sql = "SELECT * FROM mctmsys.stage";

            System.out.println(sql);
            PreparedStatement ps = con.prepareCall(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int stageID = rs.getInt("STG_ID");
                String stageName = rs.getString("STG_NAME");
                String stageAddress = rs.getString("STG_ADDRESS");
                double rentalPrice = rs.getDouble("STG_RENTAL_PRICE");
                int capacity = rs.getInt("STG_CAPACITY");

                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

                Time openTime = rs.getTime("STG_OPEN_TIME");
                String openTimeString = timeFormat.format(openTime);

                Time closeTime = rs.getTime("STG_CLOSE_TIME");
                String closeTimeString = timeFormat.format(closeTime);

                stage = new Stage(stageID, stageName, stageAddress, rentalPrice, capacity, openTimeString, closeTimeString);
                result.add(stage);
            }
            result.toString();

            ps.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (java.sql.SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public static int getLastID() {
        int result = 0;

        try{
            Connection con = UserDatabase.getConnection();

            String sql = "SELECT STG_ID FROM mctmsys.stage ORDER BY STG_ID DESC LIMIT 1";
            PreparedStatement ps = con.prepareCall(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                result = rs.getInt("STG_ID");
            }

            ps.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (java.sql.SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
