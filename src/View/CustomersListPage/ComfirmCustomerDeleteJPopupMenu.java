package View.CustomersListPage;

import java.awt.*;
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
        // Generated using JFormDesigner Evaluation license - Xuan Quynh Le
        ConfirmJDialog = new JDialog();
        ConfirmText = new JLabel();
        YesButton = new JButton();
        NoButton = new JButton();

        //======== ConfirmJDialog ========
        {
            ConfirmJDialog.setVisible(true);
            ConfirmJDialog.setBackground(Color.white);
            ConfirmJDialog.setForeground(SystemColor.text);
            var ConfirmJDialogContentPane = ConfirmJDialog.getContentPane();

            //---- ConfirmText ----
            ConfirmText.setText("ARE YOU SURE TO DELETE THIS CUSTOMER?");
            ConfirmText.setFont(new Font("Lato Black", Font.PLAIN, 16));
            ConfirmText.setHorizontalAlignment(SwingConstants.CENTER);

            //---- YesButton ----
            YesButton.setText("YES");
            YesButton.setFont(new Font("Lato Black", Font.BOLD, 13));
            YesButton.setBackground(new Color(0x61b884));
            YesButton.setForeground(Color.white);
            YesButton.setBorderPainted(false);

            //---- NoButton ----
            NoButton.setText("NO");
            NoButton.setFont(new Font("Lato Black", Font.BOLD, 13));
            NoButton.setForeground(Color.white);
            NoButton.setBackground(new Color(0xd45c5c));
            NoButton.setBorderPainted(false);

            GroupLayout ConfirmJDialogContentPaneLayout = new GroupLayout(ConfirmJDialogContentPane);
            ConfirmJDialogContentPane.setLayout(ConfirmJDialogContentPaneLayout);
            ConfirmJDialogContentPaneLayout.setHorizontalGroup(
                ConfirmJDialogContentPaneLayout.createParallelGroup()
                    .addComponent(ConfirmText, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(YesButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(NoButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(91, Short.MAX_VALUE))
            );
            ConfirmJDialogContentPaneLayout.setVerticalGroup(
                ConfirmJDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addComponent(ConfirmText, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ConfirmJDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(NoButton)
                            .addComponent(YesButton))
                        .addGap(68, 68, 68))
            );
            ConfirmJDialog.pack();
            ConfirmJDialog.setLocationRelativeTo(ConfirmJDialog.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Xuan Quynh Le
    private JDialog ConfirmJDialog;
    private JLabel ConfirmText;
    private JButton YesButton;
    private JButton NoButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void deleteCustomer() throws SQLException {
        if (this.getSelectedID() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a customer to delete");
        }
        else {
            int rowChanged = CustomerDAO.getInstance().deleteCustomer(getSelectedID());
            if (rowChanged == 0) {
                JOptionPane.showMessageDialog(null, "Delete failed");
            }
            else {
                JOptionPane.showMessageDialog(null, "Delete successfully");
            }

            MainPage.changeView(new CustomersListPanel(), MainPage.getJlbCustomer(), "CustomerListPanel");
            this.getConfirmJDialog().dispose();
        }
    }
    public void cancelDeleteCustomer() {
        System.out.println("Cancel");
        this.getConfirmJDialog().dispose();
    }
}
