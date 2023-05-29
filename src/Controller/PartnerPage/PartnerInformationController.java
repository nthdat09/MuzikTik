package Controller.PartnerPage;

import View.PartnerPage.PartnerInformationPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PartnerInformationController implements ActionListener {
    private PartnerInformationPanel partnerInformationPanel;
    public PartnerInformationController(PartnerInformationPanel partnerInformationPanel) {
        this.partnerInformationPanel = partnerInformationPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);
        if (src.equals("SAVE")){
            System.out.println("SAVE");
            partnerInformationPanel.savePartner();
        }
        else if (src.equals("CANCEL")){
            System.out.println("CANCEL");
            partnerInformationPanel.cancelPartner();
        }
    }
}
