package Controller.StagesPage;

import View.StagesPage.ConfirmStageDeleteJPopupMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StageDeleteConfirmJDialogController implements ActionListener {
    private ConfirmStageDeleteJPopupMenu comfirmDeleteJPopupMenu;

    public StageDeleteConfirmJDialogController(ConfirmStageDeleteJPopupMenu comfirmDeleteJPopupMenu) {
        this.comfirmDeleteJPopupMenu = comfirmDeleteJPopupMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);
        if (src.equals("YES")){
            try {
                comfirmDeleteJPopupMenu.deleteStage();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } else if (src.equals("NO")){
            comfirmDeleteJPopupMenu.cancelDeleteStage();
        }
    }
}
