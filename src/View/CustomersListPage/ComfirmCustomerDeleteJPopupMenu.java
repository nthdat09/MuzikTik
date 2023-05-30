package View.CustomersListPage;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

import Controller.CustomerPanel.CustomerDeleteConfirmJDialogController;
import Model.DAO.Customer.CustomerDAO;
import View.MainPage.MainPage;

public class ComfirmCustomerDeleteJPopupMenu extends JDialog{
    ActionListener ac = new CustomerDeleteConfirmJDialogController(this);
    int selectedID;

    public void setSelectedID(int selectedID) {
        this.selectedID = selectedID;
    }

    public int getSelectedID() {
        return selectedID;
    }

    public ComfirmCustomerDeleteJPopupMenu() {
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
            ConfirmText.setText("ARE YOU SURE TO DELETE THIS CUSTOMER?");

            //---- YesButton ----
            YesButton.setText("YES");

            //---- NoButton ----
            NoButton.setText("NO");

            GroupLayout ConfirmJDialogContentPaneLayout = new GroupLayout(ConfirmJDialogContentPane);
            ConfirmJDialogContentPane.setLayout(ConfirmJDialogContentPaneLayout);
            ConfirmJDialogContentPaneLayout.setHorizontalGroup(
                ConfirmJDialogContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap(100, Short.MAX_VALUE)
                        .addGroup(ConfirmJDialogContentPaneLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, ConfirmJDialogContentPaneLayout.createSequentialGroup()
                                .addComponent(YesButton)
                                .addGap(46, 46, 46)
                                .addComponent(NoButton)
                                .addGap(145, 145, 145))
                            .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                                .addComponent(ConfirmText, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93))))
            );
            ConfirmJDialogContentPaneLayout.setVerticalGroup(
                ConfirmJDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(ConfirmText, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
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

    public void deleteCustomer() throws SQLException {
        if (this.getSelectedID() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a customer to delete");
            return;
        }
        else {
            CustomerDAO.getInstance().deleteCustomer(getSelectedID());
            MainPage.changeView(new CustomersListPanel(), MainPage.getJlbCustomer(), "CustomerListPanel");
            this.getConfirmJDialog().dispose();
        }
    }
    public void cancelDeleteCustomer() {
        System.out.println("Cancel");
        this.getConfirmJDialog().dispose();
    }
}
