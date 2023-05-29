package Controller.StagesPage;

import View.StagesPage.StagesListPanel;

import java.awt.event.ActionListener;

public class StagesListPanelListener implements ActionListener{
    private final StagesListPanel stagesListPanel;

    public StagesListPanelListener(StagesListPanel stagesListPanel) {
        this.stagesListPanel = stagesListPanel;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);
        if (src.equals("ADD")){
            this.stagesListPanel.addStage();
        } else if (src.equals("EDIT")){
            stagesListPanel.editStage();
        } else if (src.equals("DELETE")){
            stagesListPanel.deleteStage();
        } else if (src.equals("SEARCH")){
            try {
                stagesListPanel.searchStage();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
