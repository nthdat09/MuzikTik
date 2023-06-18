package View.TicketPage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

import Controller.TicketPage.TicketInformationController;
import Model.BEAN.TicketBooking.TicketBooking;
import Model.DAO.Ticket.TicketDAO;
import View.MainPage.MainPage;

public class TicketInformationForm extends JPanel{
    static int selectedID = -1;
    ActionListener ac = new TicketInformationController(this);

    public TicketInformationForm(TicketBooking ticketBooking) {
        initComponents();
        getSaveButton().addActionListener(ac);
        getCancelButton().addActionListener(ac);
        initSomeComponents(ticketBooking);
    }

    public TicketInformationForm(int newID){
        initComponents();
        getSaveButton().addActionListener(ac);
        getCancelButton().addActionListener(ac);
        this.TicketIDField.setText(String.valueOf(newID));
    }

    private void initSomeComponents(TicketBooking ticketBooking) {
        this.EventIDField.setText(String.valueOf(ticketBooking.getEventID()));
        this.TicketIDField.setText(String.valueOf(ticketBooking.getTicketID()));
        this.TicketPriceField.setText(String.valueOf(ticketBooking.getPrice()));
        this.StageIDField.setText(String.valueOf(ticketBooking.getStageID()));
        this.SeatIDField.setText(String.valueOf(ticketBooking.getSeatID()));
        this.selectedID = ticketBooking.getTicketID();
        System.out.println("Selected Ticket ID: " + selectedID);
    }

    public JButton getSaveButton() {
        return this.SaveButton;
    }

    public JButton getCancelButton() {
        return this.CancelButton;
    }

    public JPanel getTicketInformationFormPanel() {
        return this.TicketInformationFormPanel;
    }

    public JLabel getTicketID() {
        return this.TicketID;
    }

    public JLabel getEventID() {
        return this.EventID;
    }

    public JLabel getTicketPrice() {
        return this.TicketPrice;
    }

    public JLabel getStageID() {
        return this.StageID;
    }

    public JLabel getSeatID() {
        return this.SeatID;
    }

    public JTextField getTicketIDField() {
        return this.TicketIDField;
    }

    public JTextField getEventIDField() {
        return this.EventIDField;
    }

    public JTextField getSeatIDField() {
        return this.SeatIDField;
    }

    public JTextField getStageIDField() {
        return this.StageIDField;
    }

    public JTextField getTicketPriceField() {
        return this.TicketPriceField;
    }

    public JLabel getLabel1() {
        return this.label1;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
        this.TicketInformationFormPanel = new JPanel();
        this.TicketID = new JLabel();
        this.EventID = new JLabel();
        this.TicketPrice = new JLabel();
        this.StageID = new JLabel();
        this.SeatID = new JLabel();
        this.TicketIDField = new JTextField();
        this.EventIDField = new JTextField();
        this.SeatIDField = new JTextField();
        this.StageIDField = new JTextField();
        this.TicketPriceField = new JTextField();
        this.SaveButton = new JButton();
        this.CancelButton = new JButton();
        this.label1 = new JLabel();

        //======== TicketInformationFormPanel ========
        {
            this.TicketInformationFormPanel.setBackground(Color.white);
            this.TicketInformationFormPanel.setMinimumSize(new Dimension(670, 500));
            this.TicketInformationFormPanel.setMaximumSize(new Dimension(670, 500));
            this.TicketInformationFormPanel.setPreferredSize(new Dimension(670, 450));
            this.TicketInformationFormPanel.setFont(new Font("Lato Black", Font.BOLD, 16));
            this.TicketInformationFormPanel.setForeground(new Color(0x61b884));
            this.TicketInformationFormPanel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder (
            0, 0 ,0 , 0) ,  "" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder
            . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .
            red ) ,this.TicketInformationFormPanel. getBorder () ) ); this.TicketInformationFormPanel. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java .
            beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //---- TicketID ----
            this.TicketID.setText("Ticket ID:");
            this.TicketID.setFont(new Font("Lato Black", Font.BOLD, 16));
            this.TicketID.setForeground(new Color(0x61b884));

            //---- EventID ----
            this.EventID.setText("Event ID:");
            this.EventID.setFont(new Font("Lato Black", Font.BOLD, 16));
            this.EventID.setForeground(new Color(0x61b884));
            this.EventID.setBackground(Color.white);

            //---- TicketPrice ----
            this.TicketPrice.setText("Ticket Price:");
            this.TicketPrice.setFont(new Font("Lato Black", Font.BOLD, 16));
            this.TicketPrice.setForeground(new Color(0x61b884));
            this.TicketPrice.setBackground(Color.white);

            //---- StageID ----
            this.StageID.setText("Stage ID:");
            this.StageID.setFont(new Font("Lato Black", Font.BOLD, 16));
            this.StageID.setForeground(new Color(0x61b884));
            this.StageID.setBackground(Color.white);

            //---- SeatID ----
            this.SeatID.setText("Seat ID:");
            this.SeatID.setFont(new Font("Lato Black", Font.BOLD, 16));
            this.SeatID.setForeground(new Color(0x61b884));
            this.SeatID.setBackground(Color.white);

            //---- TicketIDField ----
            this.TicketIDField.setEditable(false);
            this.TicketIDField.setBackground(new Color(0xcccccc));
            this.TicketIDField.setFont(new Font("Lato", Font.PLAIN, 16));
            this.TicketIDField.setDisabledTextColor(new Color(0x333333));

            //---- EventIDField ----
            this.EventIDField.setFont(new Font("Lato", Font.PLAIN, 16));

            //---- SeatIDField ----
            this.SeatIDField.setFont(new Font("Lato", Font.PLAIN, 16));

            //---- StageIDField ----
            this.StageIDField.setFont(new Font("Lato", Font.PLAIN, 16));

            //---- TicketPriceField ----
            this.TicketPriceField.setFont(new Font("Lato", Font.PLAIN, 16));

            //---- SaveButton ----
            this.SaveButton.setText("SAVE");
            this.SaveButton.setFont(new Font("Lato Black", Font.BOLD, 16));
            this.SaveButton.setBackground(new Color(0x61b884));
            this.SaveButton.setForeground(Color.white);

            //---- CancelButton ----
            this.CancelButton.setText("CANCEL");
            this.CancelButton.setFont(new Font("Lato Black", Font.BOLD, 16));
            this.CancelButton.setBackground(new Color(0x61b884));
            this.CancelButton.setForeground(Color.white);

            //---- label1 ----
            this.label1.setText("TICKET INFORMATION");
            this.label1.setForeground(new Color(0x61b884));
            this.label1.setFont(new Font("Lato Black", Font.BOLD, 24));

            GroupLayout TicketInformationFormPanelLayout = new GroupLayout(this.TicketInformationFormPanel);
            TicketInformationFormPanel.setLayout(TicketInformationFormPanelLayout);
            TicketInformationFormPanelLayout.setHorizontalGroup(
                TicketInformationFormPanelLayout.createParallelGroup()
                    .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                        .addGroup(TicketInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                .addGroup(TicketInformationFormPanelLayout.createParallelGroup()
                                    .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addGroup(TicketInformationFormPanelLayout.createParallelGroup()
                                            .addComponent(this.TicketID, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(this.TicketPrice)))
                                    .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                        .addGap(169, 169, 169)
                                        .addGroup(TicketInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(this.TicketPriceField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                            .addComponent(this.TicketIDField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                                .addGroup(TicketInformationFormPanelLayout.createParallelGroup()
                                    .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                        .addGroup(TicketInformationFormPanelLayout.createParallelGroup()
                                            .addComponent(this.SeatID, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(this.StageID, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(TicketInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(this.EventIDField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(this.SeatIDField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(this.StageIDField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(this.EventID, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                .addGap(0, 372, Short.MAX_VALUE)
                                .addComponent(this.label1, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
                                .addGap(268, 268, 268)))
                        .addGap(106, 106, 106))
                    .addGroup(GroupLayout.Alignment.TRAILING, TicketInformationFormPanelLayout.createSequentialGroup()
                        .addGap(0, 770, Short.MAX_VALUE)
                        .addComponent(this.SaveButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(this.CancelButton, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
            );
            TicketInformationFormPanelLayout.setVerticalGroup(
                TicketInformationFormPanelLayout.createParallelGroup()
                    .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(this.label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TicketInformationFormPanelLayout.createParallelGroup()
                            .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                .addGroup(TicketInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(this.TicketID)
                                    .addComponent(this.TicketIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(TicketInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(this.TicketPriceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.TicketPrice)))
                            .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                .addGroup(TicketInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(this.EventID)
                                    .addComponent(this.EventIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(TicketInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(this.SeatID)
                                    .addComponent(this.SeatIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(TicketInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(this.StageID)
                                    .addComponent(this.StageIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(TicketInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(this.CancelButton)
                                    .addComponent(this.SaveButton))))
                        .addContainerGap(218, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
    private JPanel TicketInformationFormPanel;
    private JLabel TicketID;
    private JLabel EventID;
    private JLabel TicketPrice;
    private JLabel StageID;
    private JLabel SeatID;
    private JTextField TicketIDField;
    private JTextField EventIDField;
    private JTextField SeatIDField;
    private JTextField StageIDField;
    private JTextField TicketPriceField;
    private JButton SaveButton;
    private JButton CancelButton;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void saveTicket() throws SQLException {
        System.out.println("Save Ticket");
        if (this.TicketIDField.getText().isEmpty() || this.EventIDField.getText().isEmpty()
                || this.SeatIDField.getText().isEmpty() || this.StageIDField.getText().isEmpty()
                || this.TicketPriceField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        } else {
            TicketBooking ticketBooking = null;
            if (selectedID == -1 ) { // insert
                ticketBooking = new TicketBooking();
                ticketBooking.setTicketID(Integer.parseInt(this.TicketIDField.getText()));
            }
            else { // update
                ticketBooking = TicketDAO.getInstance().selectByID(selectedID);
                ticketBooking.setTicketID(selectedID);
            }
            ticketBooking.setEventID(Integer.parseInt(this.EventIDField.getText()));
            ticketBooking.setSeatID(Integer.parseInt(this.SeatIDField.getText()));
            ticketBooking.setStageID(Integer.parseInt(this.StageIDField.getText()));
            ticketBooking.setPrice(Double.parseDouble(this.TicketPriceField.getText()));
            if (selectedID != -1) {
                System.out.println("Update Ticket");
                int rowChanged = TicketDAO.getInstance().updateTicket(ticketBooking);
                if (rowChanged == 0) {
                    JOptionPane.showMessageDialog(null, "Update failed");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Update successful");
                }
            }
            else {
                System.out.println("Add Ticket");
                int rowChanged = TicketDAO.getInstance().addTicket(ticketBooking);
                if (rowChanged == 0) {
                    JOptionPane.showMessageDialog(null, "Add failed");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Add successful");
                }
            }
            MainPage.changeView(new TicketListPanel(), MainPage.getJlbTickets() , "Ticket Information Form");
        }
    }

    public void cancelTicket() {
        System.out.println("Cancel Ticket");
        MainPage.changeView(new TicketListPanel(), MainPage.getJlbTickets() , "Ticket Information Form");
    }
}
