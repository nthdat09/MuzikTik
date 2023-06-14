package View.TicketPage;

import java.awt.*;
import Controller.TicketPage.TicketDeleteConfirmJDialogController;
import Model.DAO.Ticket.TicketDAO;
import View.MainPage.MainPage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ComfirmTicketDeleteJPopupMenu extends JDialog{
    ActionListener ac = new TicketDeleteConfirmJDialogController(this);
    int selectedID;

    public void setSelectedID(int selectedID) {
        this.selectedID = selectedID;
    }

    public int getSelectedID() {
        return selectedID;
    }

    public ComfirmTicketDeleteJPopupMenu() {
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
            ConfirmText.setText("ARE YOU SURE TO DELETE THIS TICKET?");
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
                        .addContainerGap(94, Short.MAX_VALUE)
                        .addComponent(YesButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(NoButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addComponent(ConfirmText, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
            );
            ConfirmJDialogContentPaneLayout.setVerticalGroup(
                ConfirmJDialogContentPaneLayout.createParallelGroup()
                    .addGroup(ConfirmJDialogContentPaneLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(ConfirmText, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(ConfirmJDialogContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(NoButton)
                            .addComponent(YesButton))
                        .addContainerGap(66, Short.MAX_VALUE))
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

    public void deleteTicket() throws SQLException {
        if (this.getSelectedID() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a ticket to delete");
        }
        else {
            System.out.println("Delete ticket");
            int rowChanged = TicketDAO.getInstance().deleteTicket(this.getSelectedID());
            if (rowChanged == 0) {
                JOptionPane.showMessageDialog(null, "Delete ticket failed");
            }
            else {
                JOptionPane.showMessageDialog(null, "Delete ticket successfully");
            }
            MainPage.changeView(new TicketListPanel(), MainPage.getJlbTickets() , "Ticket Information Form");
            this.getConfirmJDialog().dispose();
        }
    }
    public void cancelDeleteTicket() {
        System.out.println("Cancel");
        this.getConfirmJDialog().dispose();
    }
}
