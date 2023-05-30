package Model.DAO.Stage;

import Model.BEAN.Stage;
import Model.Database.UserDatabase;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class StageDAO {
    public static StageDAO getInstance() {
        return new StageDAO();
    }
    public Stage selectByID(int ID) throws SQLException {
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "Select * from mctmsys.stage where STG_ID = " + ID + ";";
            System.out.println(sql);
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Stage stage = new Stage();
                stage.setId(rs.getInt("STG_ID"));
                stage.setName(rs.getString("STG_NAME"));
                stage.setAddress(rs.getString("STG_ADDRESS"));
                stage.setCapacity(rs.getInt("STG_CAPACITY"));
                stage.setRentalPrice(rs.getInt("STG_RENTAL_PRICE"));
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

                Time openTime = rs.getTime("STG_OPEN_TIME");
                String openTimeString = timeFormat.format(openTime);

                Time closeTime = rs.getTime("STG_CLOSE_TIME");
                String closeTimeString = timeFormat.format(closeTime);

                stage.setOpenTime(openTimeString);
                stage.setCloseTime(closeTimeString);

                return stage;
            }
            ps.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int updateStage(Stage stage) {
        int rowChanged = 0;
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "UPDATE mctmsys.stage SET STG_NAME = ?, STG_ADDRESS = ?, STG_RENTAL_PRICE = ?, STG_CAPACITY = ?, STG_OPEN_TIME = ?, STG_CLOSE_TIME = ? WHERE STG_ID = ?;";
            System.out.println(sql);
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, stage.getName());
            ps.setString(2, stage.getAddress());
            ps.setDouble(3, stage.getRentalPrice());
            ps.setInt(4, stage.getCapacity());
            ps.setString(5, stage.getOpenTime());
            ps.setString(6, stage.getCloseTime());
            ps.setInt(7, stage.getId());
            rowChanged = ps.executeUpdate();
            ps.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowChanged;
    }

    public int addStage(Stage stage) {
        int rowChanged = 0;
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "INSERT INTO mctmsys.stage (STG_ID, STG_NAME, STG_ADDRESS, STG_RENTAL_PRICE, STG_CAPACITY, STG_OPEN_TIME, STG_CLOSE_TIME) VALUES (?, ?, ?, ?, ?, ?, ?);";

            System.out.println(sql);

            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, stage.getId());
            ps.setString(2, stage.getName());
            ps.setString(3, stage.getAddress());
            ps.setDouble(4, stage.getRentalPrice());
            ps.setInt(5, stage.getCapacity());
            ps.setString(6, stage.getOpenTime());
            ps.setString(7, stage.getCloseTime());

            rowChanged = ps.executeUpdate();
            System.out.println(rowChanged + " row(s) changed");

            ps.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowChanged;
    }

    public int deleteStage(int selectedID) {
        int rowChanged = 0;
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "DELETE FROM mctmsys.stage WHERE STG_ID = ?;";
            System.out.println(sql);

            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, selectedID);

            rowChanged = ps.executeUpdate();
            System.out.println(rowChanged + " row(s) changed");
            ps.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowChanged;
    }

    public List<Stage> getStageList() {
        List<Stage> stageList = null;
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "SELECT * FROM mctmsys.stage;";
            System.out.println(sql);

            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            stageList = new java.util.ArrayList<>();

            while (rs.next()) {
                Stage stage = new Stage();
                stage.setId(rs.getInt("STG_ID"));
                stage.setName(rs.getString("STG_NAME"));
                stage.setAddress(rs.getString("STG_ADDRESS"));
                stage.setCapacity(rs.getInt("STG_CAPACITY"));
                stage.setRentalPrice(rs.getInt("STG_RENTAL_PRICE"));
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

                Time openTime = rs.getTime("STG_OPEN_TIME");
                String openTimeString = timeFormat.format(openTime);

                Time closeTime = rs.getTime("STG_CLOSE_TIME");
                String closeTimeString = timeFormat.format(closeTime);

                stage.setOpenTime(openTimeString);
                stage.setCloseTime(closeTimeString);

                stageList.add(stage);
            }

            ps.close();
            rs.close();
            UserDatabase.closeConnection(con);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stageList;
    }
}
