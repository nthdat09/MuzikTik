package Model.DAO.Partner;

import Model.BEAN.Partner;
import Model.Database.UserDatabase;

import java.sql.*;
import java.util.List;

public class PartnerDAO {
    public static PartnerDAO getInstance() {
        return new PartnerDAO();
    }
    public Partner selectByID(int ID) throws SQLException {
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Select * from mctmsys.partner where PTN_ID = " + ID + ";";
            System.out.println(sql);

            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Partner partner = new Partner();
                partner.setId(rs.getInt("PTN_ID"));
                partner.setName(rs.getString("PTN_NAME"));
                partner.setPhoneNumber(rs.getString("PTN_PHONE_NUMBER"));
                partner.setEmail(rs.getString("PTN_EMAIL"));
                partner.setAddress(rs.getString("PTN_ADDRESS"));
                partner.setLogo(rs.getString("PTN_LOGO"));
                partner.setAccNumber(rs.getString("PTN_ACC_NUMBER"));
                partner.setBank(rs.getString("PTN_BANK"));

                return partner;
            }
            ps.close();
            rs.close();
            con.close();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updatePartner(Partner partner) {
        int rowChanged = 0;
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "UPDATE mctmsys.partner SET PTN_NAME = ?, PTN_PHONE_NUMBER = ?, PTN_EMAIL = ?, PTN_ADDRESS = ?, PTN_LOGO = ?, PTN_ACC_NUMBER = ?, PTN_BANK = ? WHERE PTN_ID = ?;";
            System.out.println(sql);
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, partner.getName());
            ps.setString(2, partner.getPhoneNumber());
            ps.setString(3, partner.getEmail());
            ps.setString(4, partner.getAddress());
            ps.setString(5, partner.getLogo());
            ps.setString(6, partner.getAccNumber());
            ps.setString(7, partner.getBank());
            ps.setInt(8, partner.getId());

            rowChanged = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowChanged;
    }

    public int addPartner(Partner partner) {
        int rowChanged = 0;
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "INSERT INTO mctmsys.partner (PTN_ID, PTN_NAME, PTN_PHONE_NUMBER, PTN_EMAIL, PTN_ADDRESS, PTN_LOGO, PTN_ACC_NUMBER, PTN_BANK) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            System.out.println(sql);

            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, partner.getId());
            ps.setString(2, partner.getName());
            ps.setString(3, partner.getPhoneNumber());
            ps.setString(4, partner.getEmail());
            ps.setString(5, partner.getAddress());
            ps.setString(6, partner.getLogo());
            ps.setString(7, partner.getAccNumber());
            ps.setString(8, partner.getBank());

            rowChanged = ps.executeUpdate();
            System.out.println(rowChanged + " row(s) changed");

            ps.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowChanged;
    }

    public int deletePartner(int selectedID) {
        int rowChanged = 0;
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "DELETE FROM mctmsys.partner WHERE PTN_ID = ?;";
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

    public List<Partner> getPartnerList() {
        List<Partner> partnerList = null;
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "SELECT * FROM mctmsys.partner;";
            System.out.println(sql);

            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            partnerList = new java.util.ArrayList<>();

            while (rs.next()) {
                Partner partner = new Partner();
                partner.setId(rs.getInt("PTN_ID"));
                partner.setName(rs.getString("PTN_NAME"));
                partner.setPhoneNumber(rs.getString("PTN_PHONE_NUMBER"));
                partner.setEmail(rs.getString("PTN_EMAIL"));
                partner.setAddress(rs.getString("PTN_ADDRESS"));
                partner.setLogo(rs.getString("PTN_LOGO"));
                partner.setAccNumber(rs.getString("PTN_ACC_NUMBER"));
                partner.setBank(rs.getString("PTN_BANK"));

                partnerList.add(partner);
            }
            ps.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return partnerList;
    }
}
