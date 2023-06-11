package View.StagesPage;

import java.awt.*;
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
        // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
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
            ConfirmText.setFont(new Font("Lato Black", Font.BOLD, 16));
            ConfirmText.setHorizontalAlignment(SwingConstants.CENTER);

            //---- YesButton ----
            YesButton.setText("YES");
            YesButton.setFont(new Font("Lato Black", Font.BOLD, 13));
            YesButton.setForeground(Color.white);
            YesButton.setBackground(new Color(0x61b884));

            //---- NoButton ----
            NoButton.setText("NO");
            NoButton.setFont(new Font("Lato Black", Font.BOLD, 13));
            NoButton.setForeground(Color.white);
            NoButton.setBackground(new Color(0xd45c5c));

            GroupLayout ConfirmJDialogContentPaneLayout = new GroupLayout(ConfirmJDialogContentPane);
            ConfirmJDialogContentPane.setLayout(ConfirmJDialogContentPaneLayout);
            ConfirmJDialogContentPaneLayout.setHorizontalGroup(
                ConfirmJDialogContentPaneLayout.createParallelGroup()
                    .addComponent(ConfirmText, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(YesButton)
                        .addGap(46, 46, 46)
                        .addComponent(NoButton)
                        .addContainerGap(124, Short.MAX_VALUE))
            );
            ConfirmJDialogContentPaneLayout.setVerticalGroup(
                ConfirmJDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(ConfirmText, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ConfirmJDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(YesButton)
                            .addComponent(NoButton))
                        .addContainerGap(69, Short.MAX_VALUE))
            );
            ConfirmJDialog.pack();
            ConfirmJDialog.setLocationRelativeTo(ConfirmJDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
    private JDialog ConfirmJDialog;
    private JLabel ConfirmText;
    private JButton YesButton;
    private JButton NoButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


}
