package View.PartnerPage;

import java.awt.*;
import Controller.PartnerPage.PartnerDeleteConfirmJDialogController;
import Model.DAO.Partner.PartnerDAO;
import View.MainPage.MainPage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ConfirmPartnerDeleteJPopupMenu extends JDialog{
    ActionListener ac = new PartnerDeleteConfirmJDialogController(this);
    int selectedID;

    public void setSelectedID(int selectedID) {
        this.selectedID = selectedID;
    }

    public int getSelectedID() {
        return selectedID;
    }

    public ConfirmPartnerDeleteJPopupMenu() {
        initComponents();
        initSomeComponents();
    }

    public void initSomeComponents() {
        getYesButton().addActionListener(ac);
        getNoButton().addActionListener(ac);
    }

    public void deletePartner() {
        if (this.getSelectedID() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a stage to delete");
        }
        else {
            System.out.println("Delete Partner");
            int rowChanged = PartnerDAO.getInstance().deletePartner(this.getSelectedID());
            if (rowChanged == 0) {
                JOptionPane.showMessageDialog(null, "Delete failed");
                return;
            }
            else {
                JOptionPane.showMessageDialog(null, "Delete successfully");
            }
            MainPage.changeView(new PartnerListPanel(), MainPage.getJlbPartners() , "Partner List Panel");
            this.getConfirmJDialog().dispose();
        }
    }

    public void cancelDeletePartner() {
        System.out.println("Cancel");
        this.getConfirmJDialog().dispose();
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

    public JLabel getConfirmText() {
        return ConfirmText;
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
            ConfirmText.setText("ARE YOU SURE TO DELETE THIS PARTNER?");
            ConfirmText.setFont(new Font("Lato Black", Font.BOLD, 16));
            ConfirmText.setHorizontalAlignment(SwingConstants.CENTER);

            //---- YesButton ----
            YesButton.setText("YES");
            YesButton.setFont(new Font("Lato Black", Font.BOLD, 13));
            YesButton.setBackground(new Color(0x61b884));
            YesButton.setForeground(Color.white);

            //---- NoButton ----
            NoButton.setText("NO");
            NoButton.setFont(new Font("Lato Black", Font.BOLD, 13));
            NoButton.setBackground(new Color(0xd45c5c));
            NoButton.setForeground(Color.white);

            GroupLayout ConfirmJDialogContentPaneLayout = new GroupLayout(ConfirmJDialogContentPane);
            ConfirmJDialogContentPane.setLayout(ConfirmJDialogContentPaneLayout);
            ConfirmJDialogContentPaneLayout.setHorizontalGroup(
                ConfirmJDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(YesButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(NoButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(101, Short.MAX_VALUE))
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ConfirmText, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                        .addContainerGap())
            );
            ConfirmJDialogContentPaneLayout.setVerticalGroup(
                ConfirmJDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap(63, Short.MAX_VALUE)
                        .addComponent(ConfirmText, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ConfirmJDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(NoButton)
                            .addComponent(YesButton))
                        .addGap(55, 55, 55))
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
