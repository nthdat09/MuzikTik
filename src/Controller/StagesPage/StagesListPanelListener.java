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
        switch (src) {
            case "ADD" -> this.stagesListPanel.addStage();
            case "EDIT" -> stagesListPanel.editStage();
            case "DELETE" -> stagesListPanel.deleteStage();
            case "SEARCH" -> {
                try {
                    stagesListPanel.searchStage();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
