package Controller.StagesPage;

import View.StagesPage.StageInformationForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StageInformationController implements ActionListener {
    private final StageInformationForm stageInformationForm;

    public StageInformationController(StageInformationForm stageInformationForm) {
        this.stageInformationForm = stageInformationForm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("SAVE")){
            try {
                stageInformationForm.saveStage();
            }

            catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        else if (src.equals("CANCEL")){
            try {
                stageInformationForm.cancelStage();
            }

            catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
