/*
 * Created by JFormDesigner on Wed Apr 26 21:29:50 ICT 2023
 */

package View.SettingPage;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Admin
 */
public class AccountPanel extends JPanel {
    public AccountPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
        jbtCancel = new JButton();
        jbtSave = new JButton();
        jlbMyAccount = new JLabel();
        jlbUsername = new JLabel();
        jpnUsername = new JPanel();
        jlbFillUsername = new JLabel();
        jlbEmail = new JLabel();
        jlbPhoneNumber = new JLabel();
        jlbDOB = new JLabel();
        jlbDOB2 = new JLabel();
        jlbAvatar = new JLabel();
        jlbURLAva = new JLabel();
        jlbFillUsername2 = new JLabel();
        jlbFillUsername3 = new JLabel();
        jlbFillUsername4 = new JLabel();
        jlbFillUsername5 = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder (
        0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder
        . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .
        red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java .
        beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

        //---- jbtCancel ----
        jbtCancel.setText("CANCEL");
        jbtCancel.setPreferredSize(new Dimension(80, 30));
        jbtCancel.setFont(new Font("Lato Black", Font.BOLD, 18));
        jbtCancel.setBackground(new Color(0x61b884));
        jbtCancel.setForeground(Color.white);

        //---- jbtSave ----
        jbtSave.setText("SAVE");
        jbtSave.setPreferredSize(new Dimension(80, 30));
        jbtSave.setFont(new Font("Lato Black", Font.BOLD, 18));
        jbtSave.setBackground(new Color(0x61b884));
        jbtSave.setForeground(Color.white);

        //---- jlbMyAccount ----
        jlbMyAccount.setText("MY ACCOUNT");
        jlbMyAccount.setBackground(new Color(0x61b884));
        jlbMyAccount.setFont(new Font("Lato Black", Font.BOLD, 24));
        jlbMyAccount.setForeground(new Color(0x61b884));

        //---- jlbUsername ----
        jlbUsername.setText("Username");
        jlbUsername.setFont(new Font("Lato Black", Font.BOLD, 20));
        jlbUsername.setForeground(new Color(0x626262));

        //======== jpnUsername ========
        {
            jpnUsername.setBackground(Color.white);
            jpnUsername.setBorder(new LineBorder(new Color(0x626262)));

            //---- jlbFillUsername ----
            jlbFillUsername.setText("text");
            jlbFillUsername.setFont(new Font("Lato", Font.PLAIN, 16));
            jlbFillUsername.setForeground(new Color(0x61b884));

            GroupLayout jpnUsernameLayout = new GroupLayout(jpnUsername);
            jpnUsername.setLayout(jpnUsernameLayout);
            jpnUsernameLayout.setHorizontalGroup(
                jpnUsernameLayout.createParallelGroup()
                    .addComponent(jlbFillUsername, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
            );
            jpnUsernameLayout.setVerticalGroup(
                jpnUsernameLayout.createParallelGroup()
                    .addComponent(jlbFillUsername, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            );
        }

        //---- jlbEmail ----
        jlbEmail.setText("Email");
        jlbEmail.setFont(new Font("Lato Black", Font.BOLD, 20));
        jlbEmail.setForeground(new Color(0x626262));

        //---- jlbPhoneNumber ----
        jlbPhoneNumber.setText("Phone Number");
        jlbPhoneNumber.setFont(new Font("Lato Black", Font.BOLD, 20));
        jlbPhoneNumber.setForeground(new Color(0x626262));

        //---- jlbDOB ----
        jlbDOB.setText("Date of Birth");
        jlbDOB.setFont(new Font("Lato Black", Font.BOLD, 20));
        jlbDOB.setForeground(new Color(0x626262));

        //---- jlbDOB2 ----
        jlbDOB2.setText("Address");
        jlbDOB2.setFont(new Font("Lato Black", Font.BOLD, 20));
        jlbDOB2.setForeground(new Color(0x626262));

        //---- jlbAvatar ----
        jlbAvatar.setText("Avatar");
        jlbAvatar.setFont(new Font("Lato Black", Font.BOLD, 20));
        jlbAvatar.setForeground(new Color(0x626262));

        //---- jlbURLAva ----
        jlbURLAva.setText("text");
        jlbURLAva.setBackground(Color.white);
        jlbURLAva.setBorder(LineBorder.createBlackLineBorder());

        //---- jlbFillUsername2 ----
        jlbFillUsername2.setText("text");
        jlbFillUsername2.setFont(new Font("Lato", Font.PLAIN, 16));
        jlbFillUsername2.setForeground(new Color(0x61b884));

        //---- jlbFillUsername3 ----
        jlbFillUsername3.setText("text");
        jlbFillUsername3.setFont(new Font("Lato", Font.PLAIN, 16));
        jlbFillUsername3.setForeground(new Color(0x61b884));

        //---- jlbFillUsername4 ----
        jlbFillUsername4.setText("text");
        jlbFillUsername4.setFont(new Font("Lato", Font.PLAIN, 16));
        jlbFillUsername4.setForeground(new Color(0x61b884));

        //---- jlbFillUsername5 ----
        jlbFillUsername5.setText("text");
        jlbFillUsername5.setFont(new Font("Lato", Font.PLAIN, 16));
        jlbFillUsername5.setForeground(new Color(0x61b884));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(350, 569, Short.MAX_VALUE)
                    .addComponent(jbtSave, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jbtCancel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 219, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(404, 404, 404)
                    .addComponent(jlbMyAccount)
                    .addGap(0, 464, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jlbDOB)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbFillUsername4, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jlbDOB2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbFillUsername5, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(jlbUsername)
                                .addComponent(jlbEmail)
                                .addComponent(jlbAvatar)
                                .addComponent(jlbPhoneNumber))
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(jlbFillUsername3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpnUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbURLAva, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbFillUsername2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGap(0, 523, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jlbMyAccount)
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(jlbUsername)
                        .addComponent(jpnUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbEmail)
                        .addComponent(jlbFillUsername2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbPhoneNumber)
                        .addComponent(jlbFillUsername3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbDOB)
                        .addComponent(jlbFillUsername4))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbDOB2)
                        .addComponent(jlbFillUsername5))
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbAvatar)
                        .addComponent(jlbURLAva, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                    .addGap(92, 92, 92)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(jbtSave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtCancel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lê Xuân Quỳnh
    private JButton jbtCancel;
    private JButton jbtSave;
    private JLabel jlbMyAccount;
    private JLabel jlbUsername;
    private JPanel jpnUsername;
    private JLabel jlbFillUsername;
    private JLabel jlbEmail;
    private JLabel jlbPhoneNumber;
    private JLabel jlbDOB;
    private JLabel jlbDOB2;
    private JLabel jlbAvatar;
    private JLabel jlbURLAva;
    private JLabel jlbFillUsername2;
    private JLabel jlbFillUsername3;
    private JLabel jlbFillUsername4;
    private JLabel jlbFillUsername5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
