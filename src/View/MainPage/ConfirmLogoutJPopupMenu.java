package View.MainPage;

import java.awt.*;
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
        this.getConfirmJDialog().dispose();
        this.mainPage.Destroy();

        LoginPage.getLoginPageDialog().setVisible(true);
    }

    public void cancelLogout() {
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
        // Generated using JFormDesigner Evaluation license - Dat
        ConfirmJDialog = new JDialog();
        ConfirmText = new JLabel();
        YesButton = new JButton();
        NoButton = new JButton();

        //======== ConfirmJDialog ========
        {
            ConfirmJDialog.setVisible(true);
            ConfirmJDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            var ConfirmJDialogContentPane = ConfirmJDialog.getContentPane();

            //---- ConfirmText ----
            ConfirmText.setText("ARE YOU SURE TO LOGOUT?");
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
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap(90, Short.MAX_VALUE)
                        .addComponent(YesButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(NoButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ConfirmText, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                        .addContainerGap())
            );
            ConfirmJDialogContentPaneLayout.setVerticalGroup(
                ConfirmJDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(ConfirmText, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(ConfirmJDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(YesButton)
                            .addComponent(NoButton))
                        .addContainerGap(54, Short.MAX_VALUE))
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
