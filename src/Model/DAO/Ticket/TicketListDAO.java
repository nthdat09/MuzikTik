package Model.DAO.Ticket;

import Model.BEAN.Ticket;
import Model.Database.UserDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketListDAO {
    public static TicketListDAO getInstance() {
        return new TicketListDAO();
    }

    public static List<Ticket> getList() {
        List<Ticket> result = new ArrayList<>();
        Ticket ticket = null;
        try {
            Connection con = UserDatabase.getConnection();

            String sql = "Select * from mctmsys.ticket";
            PreparedStatement ps = con.prepareCall(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ticketID = rs.getInt("TKT_ID");
                int eventID = rs.getInt("TKT_EVT_ID");
                int price = rs.getInt("TKT_PRICE");
                int stageID = rs.getInt("TKT_STG_ID");
                int seatID = rs.getInt("TKT_SEAT_ID");

                ticket = new Ticket(ticketID, eventID, price, stageID, seatID);
                result.add(ticket);
            }

            ps.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static int getLastID(){
        int result = 0;
        try {
            Connection con = UserDatabase.getConnection();

            String sql = "Select TKT_ID from mctmsys.ticket order by TKT_ID desc limit 1";
            PreparedStatement ps = con.prepareCall(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result = rs.getInt("TKT_ID");
            }

            ps.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
