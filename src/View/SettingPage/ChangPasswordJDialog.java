/*
 * Created by JFormDesigner on Thu Jun 01 10:30:02 ICT 2023
 */

package View.SettingPage;

import Controller.AccountPanel.ChangPasswordJDialogController;
import Model.DAO.Employee.EmployeeDAO;
import View.MainPage.MainPage;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Dat2
 */
public class ChangPasswordJDialog extends JDialog {
    ActionListener ac = new ChangPasswordJDialogController(this);
    public ChangPasswordJDialog() {
        super();
        initComponents();
        initMoreSetting();
    }

    private void initMoreSetting() {
        getOkButton().addActionListener(ac);
        getCancelButton().addActionListener(ac);
        getShowPasswordJbt().addActionListener(ac);
    }

    public void save() {
        if (getOldPasswordField().getText().equals("") || getNewPasswordField().getText().equals("")
                || getReTypeNewPasswordField().getText().equals("")) { // check if any field is empty
            JOptionPane.showMessageDialog(this, "Please fill all the fields");
        }
        else { // check if old password is correct and new password and retype new password are the same
            String oldPassword = getOldPasswordField().getText();
            String newPassword = getNewPasswordField().getText();
            String reTypeNewPassword = getReTypeNewPasswordField().getText();

            if(!oldPassword.equals(EmployeeDAO.getPasswordByUsername(MainPage.getUsername()))){ // check if old password is correct
                JOptionPane.showMessageDialog(this, "Old password is not correct");
            }

            else if(!newPassword.equals(reTypeNewPassword)){
                JOptionPane.showMessageDialog(this, "New password and retype new password are not the same");
            }

            else {
                int rowChanged = EmployeeDAO.updatePasswordByUsername(MainPage.getUsername(), newPassword);
                if(rowChanged == 1){
                    JOptionPane.showMessageDialog(this, "Change password successfully");
                    this.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Change password failed");
                }
            }
        }

    }
    public void cancel() {
        this.dispose();
    }

    public void showPassword() {
        getOldPasswordField().setEchoChar((char) 0);
        getNewPasswordField().setEchoChar((char) 0);
        getReTypeNewPasswordField().setEchoChar((char) 0);

        getShowPasswordJbt().setText("HIDE");
    }
    public void hidePassword() {
        getOldPasswordField().setEchoChar('*');
        getNewPasswordField().setEchoChar('*');
        getReTypeNewPasswordField().setEchoChar('*');

        getShowPasswordJbt().setText("SHOW");
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JPasswordField getOldPasswordField() {
        return oldPasswordField;
    }

    public JPasswordField getNewPasswordField() {
        return newPasswordField;
    }

    public JPasswordField getReTypeNewPasswordField() {
        return reTypeNewPasswordField;
    }

    public JButton getShowPasswordJbt() {
        return ShowPasswordJbt;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
        dialogPane = new JPanel();
        buttonBar = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        oldPasswordField = new JPasswordField();
        newPasswordField = new JPasswordField();
        reTypeNewPasswordField = new JPasswordField();
        ShowPasswordJbt = new JButton();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        var contentPane = getContentPane();

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0
            ,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
            ,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red),
            dialogPane. getBorder()));dialogPane. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}});
            dialogPane.setLayout(new BorderLayout());

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setFont(new Font("Lato Black", Font.BOLD, 14));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 144, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //======== contentPanel ========
            {
                contentPanel.setFont(new Font("Lato Black", Font.BOLD, 14));

                //---- label1 ----
                label1.setText("CHANGE PASSWORD");
                label1.setFont(new Font("Lato Black", Font.BOLD, 22));
                label1.setForeground(new Color(0x61b884));
                label1.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label2 ----
                label2.setText("Old password:");
                label2.setFont(new Font("Lato Black", Font.BOLD, 14));
                label2.setForeground(new Color(0x61b884));

                //---- label3 ----
                label3.setText("New password:");
                label3.setFont(new Font("Lato Black", Font.BOLD, 14));
                label3.setForeground(new Color(0x61b884));

                //---- label4 ----
                label4.setText("Re-type new password:");
                label4.setFont(new Font("Lato Black", Font.BOLD, 14));
                label4.setForeground(new Color(0x61b884));

                //---- oldPasswordField ----
                oldPasswordField.setFont(new Font("Lato Black", Font.BOLD, 14));

                //---- newPasswordField ----
                newPasswordField.setFont(new Font("Lato Black", Font.BOLD, 14));

                //---- reTypeNewPasswordField ----
                reTypeNewPasswordField.setFont(new Font("Lato Black", Font.BOLD, 14));

                //---- ShowPasswordJbt ----
                ShowPasswordJbt.setText("SHOW");
                ShowPasswordJbt.setFont(new Font("Lato Black", Font.BOLD, 14));
                ShowPasswordJbt.setBackground(new Color(0x61b884));
                ShowPasswordJbt.setForeground(Color.white);

                //---- okButton ----
                okButton.setText("OK");
                okButton.setFont(new Font("Lato Black", Font.BOLD, 14));
                okButton.setForeground(Color.white);
                okButton.setBackground(new Color(0x61b884));

                //---- cancelButton ----
                cancelButton.setText("CANCEL");
                cancelButton.setFont(new Font("Lato Black", Font.BOLD, 14));
                cancelButton.setBackground(new Color(0x61b884));
                cancelButton.setForeground(Color.white);

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(label3)
                                                .addComponent(label2)
                                                .addComponent(label4))
                                            .addGap(18, 18, 18)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(oldPasswordField, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(reTypeNewPasswordField, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                    .addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(ShowPasswordJbt)))
                                            .addGap(89, 89, 89))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                            .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cancelButton)
                                            .addGap(46, 46, 46))))))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(oldPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ShowPasswordJbt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(reTypeNewPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(okButton)
                                .addComponent(cancelButton))
                            .addGap(44, 44, 44))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
    private JPanel dialogPane;
    private JPanel buttonBar;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JPasswordField oldPasswordField;
    private JPasswordField newPasswordField;
    private JPasswordField reTypeNewPasswordField;
    private JButton ShowPasswordJbt;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
