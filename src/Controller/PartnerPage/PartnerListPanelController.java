package Controller.PartnerPage;

import View.PartnerPage.PartnerListPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PartnerListPanelController implements ActionListener {
    private PartnerListPanel partnerListPanel;

    public PartnerListPanelController(PartnerListPanel partnerListPanel) {
        this.partnerListPanel = partnerListPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);
        if (src.equals("ADD")){
            System.out.println("ADD");
            partnerListPanel.addPartner();
        }
        else if (src.equals("EDIT")){
            System.out.println("EDIT");
            partnerListPanel.editPartner();
        }
        else if (src.equals("DELETE")){
            System.out.println("DELETE");
            partnerListPanel.deletePartner();
        }
        else if (src.equals("SEARCH")){
            System.out.println("SEARCH");
            try {
                partnerListPanel.searchPartner();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
