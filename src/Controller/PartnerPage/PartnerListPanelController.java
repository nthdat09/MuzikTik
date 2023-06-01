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
        switch (src) {
            case "ADD" -> {
                System.out.println("ADD");
                partnerListPanel.addPartner();
            }
            case "EDIT" -> {
                System.out.println("EDIT");
                partnerListPanel.editPartner();
            }
            case "DELETE" -> {
                System.out.println("DELETE");
                partnerListPanel.deletePartner();
            }
            case "SEARCH" -> {
                System.out.println("SEARCH");
                try {
                    partnerListPanel.searchPartner();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

    }
}
