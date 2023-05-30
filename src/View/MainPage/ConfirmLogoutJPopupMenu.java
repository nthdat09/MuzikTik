package View.MainPage;

import Controller.MainMenu.ConfirmLogoutController;
import View.LoginPage.LoginPage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ConfirmLogoutJPopupMenu extends JDialog{
    ActionListener ac = new ConfirmLogoutController(this);
    int selectedID;

    MainPage mainPage;

    public void setSelectedID(int selectedID) {
        this.selectedID = selectedID;
    }

    public int getSelectedID() {
        return selectedID;
    }

    public ConfirmLogoutJPopupMenu(MainPage mainPage) {
        initComponents();
        initSomeComponents();
        this.mainPage = mainPage;
    }

    public void initSomeComponents() {
        getYesButton().addActionListener(ac);
        getNoButton().addActionListener(ac);
    }

    public void Logout() {
        this.mainPage.dispose();
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }

    public void cancelLogout() {
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
            ConfirmText.setText("ARE YOU SURE TO LOGOUT?");

            //---- YesButton ----
            YesButton.setText("YES");

            //---- NoButton ----
            NoButton.setText("NO");

            GroupLayout ConfirmJDialogContentPaneLayout = new GroupLayout(ConfirmJDialogContentPane);
            ConfirmJDialogContentPane.setLayout(ConfirmJDialogContentPaneLayout);
            ConfirmJDialogContentPaneLayout.setHorizontalGroup(
                ConfirmJDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap(151, Short.MAX_VALUE)
                        .addGroup(ConfirmJDialogContentPaneLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, ConfirmJDialogContentPaneLayout.createSequentialGroup()
                                .addComponent(YesButton)
                                .addGap(46, 46, 46)
                                .addComponent(NoButton)
                                .addGap(145, 145, 145))
                            .addGroup(GroupLayout.Alignment.TRAILING, ConfirmJDialogContentPaneLayout.createSequentialGroup()
                                .addComponent(ConfirmText)
                                .addGap(154, 154, 154))))
            );
            ConfirmJDialogContentPaneLayout.setVerticalGroup(
                ConfirmJDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap(100, Short.MAX_VALUE)
                        .addComponent(ConfirmText, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
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


}
