package View.StagesPage;

import Controller.StagesPage.StageDeleteConfirmJDialogController;
import Model.DAO.Stage.StageDAO;
import Model.DAO.Ticket.TicketDAO;
import View.MainPage.MainPage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ConfirmStageDeleteJPopupMenu extends JDialog{
    ActionListener ac = new StageDeleteConfirmJDialogController(this);
    int selectedID;

    public void setSelectedID(int selectedID) {
        this.selectedID = selectedID;
    }

    public int getSelectedID() {
        return selectedID;
    }

    public ConfirmStageDeleteJPopupMenu() {
        initComponents();
        initSomeComponents();
    }

    public void initSomeComponents() {
        getYesButton().addActionListener(ac);
        getNoButton().addActionListener(ac);
    }

    public JLabel getConfirmText() {
        return ConfirmText;
    }

    public JButton getYesButton() {
        return YesButton;
    }

    public JButton getNoButton() {
        return NoButton;
    }

    public JDialog getConfirmJDialog() {
        return ConfirmJDialog;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        ConfirmJDialog = new JDialog();
        ConfirmText = new JLabel();
        YesButton = new JButton();
        NoButton = new JButton();

        //======== ConfirmJDialog ========
        {
            ConfirmJDialog.setVisible(true);
            var ConfirmJDialogContentPane = ConfirmJDialog.getContentPane();

            //---- ConfirmText ----
            ConfirmText.setText("ARE YOU SURE TO DELETE THIS STAGE?");

            //---- YesButton ----
            YesButton.setText("YES");

            //---- NoButton ----
            NoButton.setText("NO");

            GroupLayout ConfirmJDialogContentPaneLayout = new GroupLayout(ConfirmJDialogContentPane);
            ConfirmJDialogContentPane.setLayout(ConfirmJDialogContentPaneLayout);
            ConfirmJDialogContentPaneLayout.setHorizontalGroup(
                ConfirmJDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap(120, Short.MAX_VALUE)
                        .addGroup(ConfirmJDialogContentPaneLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, ConfirmJDialogContentPaneLayout.createSequentialGroup()
                                .addComponent(YesButton)
                                .addGap(46, 46, 46)
                                .addComponent(NoButton)
                                .addGap(145, 145, 145))
                            .addGroup(GroupLayout.Alignment.TRAILING, ConfirmJDialogContentPaneLayout.createSequentialGroup()
                                .addComponent(ConfirmText, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113))))
            );
            ConfirmJDialogContentPaneLayout.setVerticalGroup(
                ConfirmJDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap(101, Short.MAX_VALUE)
                        .addComponent(ConfirmText, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addGroup(ConfirmJDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(YesButton)
                            .addComponent(NoButton))
                        .addGap(98, 98, 98))
            );
            ConfirmJDialog.pack();
            ConfirmJDialog.setLocationRelativeTo(ConfirmJDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
    private JDialog ConfirmJDialog;
    private JLabel ConfirmText;
    private JButton YesButton;
    private JButton NoButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void deleteStage() throws SQLException {
        if (this.getSelectedID() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a stage to delete");
            return;
        }
        else {
            System.out.println("Delete Stage");
            int rowChanged = StageDAO.getInstance().deleteStage(this.getSelectedID());
            if (rowChanged == 0) {
                JOptionPane.showMessageDialog(null, "Delete Stage Failed");
                return;
            }
            else {
                JOptionPane.showMessageDialog(null, "Delete Stage Successfully");
            }
            MainPage.changeView(new StagesListPanel(), MainPage.getJlbStages() , "Stage List Panel");
            this.getConfirmJDialog().dispose();
        }
    }
    public void cancelDeleteStage() {
        System.out.println("Cancel");
        this.getConfirmJDialog().dispose();
    }

}
