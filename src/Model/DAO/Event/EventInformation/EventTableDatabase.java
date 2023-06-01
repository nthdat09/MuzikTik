package Model.DAO.Event.EventInformation;

import Model.Database.UserDatabase;
import View.EventPage.EventPanel;
import View.Home.HomePanel;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EventTableDatabase {
    private static Integer selectedID;
    public static void getEventTableDatabase() {
        selectedID = HomePanel.getSelectedEventID();
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "select TKT_ID, SEAT_ID,SEAT_TYPE, TKT_PRICE from mctmsys.ticket join mctmsys.seat on ticket.TKT_SEAT_ID = seat.SEAT_ID and ticket.TKT_STG_ID = seat.SEAT_STG_ID  where TKT_EVT_ID = '" + selectedID + "'";
            PreparedStatement st = con.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String ticketID = rs.getString("TKT_ID");
                String seatID = rs.getString("SEAT_ID");
                String seatType = rs.getString("SEAT_TYPE");
                String ticketPrice = rs.getString("TKT_PRICE");

                String tbData[] = {seatID, seatType, ticketPrice};
                DefaultTableModel tblModel = (DefaultTableModel) EventPanel.getSeatTable().getModel();
                tblModel.addRow(tbData);
            }
            rs.close();
            st.close();
            con.close();
    } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
