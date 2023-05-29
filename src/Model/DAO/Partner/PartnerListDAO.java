package Model.DAO.Partner;

import Model.BEAN.Partner;
import Model.BEAN.Stage;
import Model.DAO.Stage.StageListDAO;
import Model.Database.UserDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PartnerListDAO {
    public static PartnerListDAO getInstance() {
        return new PartnerListDAO();
    }

    public static List<Partner> getList(){
        List<Partner> result = new ArrayList<>();
        Partner partner = null;

        try{
            Connection con = UserDatabase.getConnection();

            String sql = "SELECT * FROM mctmsys.partner";

            System.out.println(sql);
            PreparedStatement ps = con.prepareCall(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int partnerID = rs.getInt("PTN_ID");
                String partnerName = rs.getString("PTN_NAME");
                String partnerPhone = rs.getString("PTN_PHONE_NUMBER");
                String partnerEmail = rs.getString("PTN_EMAIL");
                String partnerAddress = rs.getString("PTN_ADDRESS");
                String partnerLogo = rs.getString("PTN_LOGO");
                String partnerAccNumber = rs.getString("PTN_ACC_NUMBER");
                String partnerBank = rs.getString("PTN_BANK");

                partner = new Partner(partnerID, partnerName, partnerPhone, partnerEmail, partnerAddress, partnerLogo, partnerAccNumber, partnerBank);

                result.add(partner);

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

            String sql = "SELECT * FROM mctmsys.partner ORDER BY PTN_ID DESC LIMIT 1";
            PreparedStatement ps = con.prepareCall(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                result = rs.getInt("PTN_ID");
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
