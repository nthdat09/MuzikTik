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

        getShowPasswordJbt().setText("Hide Password");
    }
    public void hidePassword() {
        getOldPasswordField().setEchoChar('*');
        getNewPasswordField().setEchoChar('*');
        getReTypeNewPasswordField().setEchoChar('*');

        getShowPasswordJbt().setText("Show Password");
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
        // Generated using JFormDesigner Evaluation license - Dat
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        oldPasswordField = new JPasswordField();
        newPasswordField = new JPasswordField();
        reTypeNewPasswordField = new JPasswordField();
        ShowPasswordJbt = new JButton();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        var contentPane = getContentPane();

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
            border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER
            , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
            .BOLD ,12 ), java. awt. Color. red) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r"
            .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("CHANGE PASSWORD");
                label1.setFont(new Font("Inter", Font.BOLD, 16));

                //---- label2 ----
                label2.setText("OLD PASSWORD");

                //---- label3 ----
                label3.setText("NEW PASSWORD");

                //---- label4 ----
                label4.setText("RE-TYPE NEW PASSWORD");

                //---- ShowPasswordJbt ----
                ShowPasswordJbt.setText("Show Password");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(label2)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(oldPasswordField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(ShowPasswordJbt))
                                .addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4)
                                .addComponent(reTypeNewPasswordField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(55, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(138, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
                            .addGap(125, 125, 125))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                            .addGap(3, 3, 3)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(oldPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(ShowPasswordJbt))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reTypeNewPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
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
    // Generated using JFormDesigner Evaluation license - Dat
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JPasswordField oldPasswordField;
    private JPasswordField newPasswordField;
    private JPasswordField reTypeNewPasswordField;
    private JButton ShowPasswordJbt;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
