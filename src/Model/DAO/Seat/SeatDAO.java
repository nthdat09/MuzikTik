package Model.DAO.Seat;

import Model.Database.UserDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatDAO {
    public static SeatDAO getInstance() {
        return new SeatDAO();
    }

    public static String getSeatTypeByID(int SEAT_ID, int SEAT_STG_ID){
        String SEAT_TYPE = "";

        try{
            Connection con = UserDatabase.getConnection();

            String sql = "Select SEAT_TYPE from mctmsys.seat where SEAT_ID = ? and SEAT_STG_ID = ?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, SEAT_ID);
            ps.setInt(2, SEAT_STG_ID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                SEAT_TYPE = rs.getString("SEAT_TYPE");
            }

            rs.close();
            ps.close();
            con.close();

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return SEAT_TYPE;
    }
}
