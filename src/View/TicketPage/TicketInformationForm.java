package View.TicketPage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

import Controller.TicketPage.TicketInformationController;
import Model.BEAN.Ticket;
import Model.DAO.Ticket.TicketDAO;
import View.MainPage.MainPage;

public class TicketInformationForm extends JPanel{
    static int selectedID = -1;
    ActionListener ac = new TicketInformationController(this);
    public TicketInformationForm() {
        initComponents();
        getSaveButton().addActionListener(ac);
        getCancelButton().addActionListener(ac);
    }

    public TicketInformationForm(Ticket ticket) {
        initComponents();
        getSaveButton().addActionListener(ac);
        getCancelButton().addActionListener(ac);
        initSomeComponents(ticket);
    }

    public TicketInformationForm(int newID){
        initComponents();
        getSaveButton().addActionListener(ac);
        getCancelButton().addActionListener(ac);
        this.TicketIDField.setText(newID + "");
    }

    private void initSomeComponents(Ticket ticket) {
        this.EventIDField.setText(ticket.getEventID() + "");
        this.TicketIDField.setText(ticket.getTicketID() + "");
        this.TicketPriceField.setText(ticket.getPrice() + "");
        this.StageIDField.setText(ticket.getStageID() + "");
        this.SeatIDField.setText(ticket.getSeatID() + "");
        this.selectedID = ticket.getTicketID();
        System.out.println("Selected Ticket ID: " + selectedID);
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

    public JButton getSaveButton() {
        return this.SaveButton;
    }

    public JButton getCancelButton() {
        return this.CancelButton;
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

    public JPanel getTicketInformationFormPanel() {
        return this.TicketInformationFormPanel;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
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

        //======== TicketInformationFormPanel ========
        {
            this.TicketInformationFormPanel.setBackground(Color.white);
            this.TicketInformationFormPanel.setMinimumSize(new Dimension(670, 500));
            this.TicketInformationFormPanel.setMaximumSize(new Dimension(670, 500));
            this.TicketInformationFormPanel.setPreferredSize(new Dimension(670, 450));
            this.TicketInformationFormPanel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
            . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing
            .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
            Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
            ) ,this.TicketInformationFormPanel. getBorder () ) ); this.TicketInformationFormPanel. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
            public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName (
            ) ) )throw new RuntimeException( ) ;} } );

            //---- TicketID ----
            this.TicketID.setText("Ticket ID");
            this.TicketID.setFont(new Font("Leelawadee", Font.BOLD, 20));
            this.TicketID.setForeground(Color.black);

            //---- EventID ----
            this.EventID.setText("Event ID");
            this.EventID.setFont(new Font("Leelawadee", Font.BOLD, 20));
            this.EventID.setForeground(Color.black);

            //---- TicketPrice ----
            this.TicketPrice.setText("Ticket Price");
            this.TicketPrice.setFont(new Font("Leelawadee", Font.BOLD, 20));
            this.TicketPrice.setForeground(Color.black);

            //---- StageID ----
            this.StageID.setText("Stage ID");
            this.StageID.setFont(new Font("Leelawadee", Font.BOLD, 20));
            this.StageID.setForeground(Color.black);

            //---- SeatID ----
            this.SeatID.setText("Seat ID");
            this.SeatID.setFont(new Font("Leelawadee", Font.BOLD, 20));
            this.SeatID.setForeground(Color.black);

            //---- TicketIDField ----
            this.TicketIDField.setEditable(false);
            this.TicketIDField.setBackground(Color.lightGray);

            //---- SaveButton ----
            this.SaveButton.setText("SAVE");

            //---- CancelButton ----
            this.CancelButton.setText("CANCEL");

            GroupLayout TicketInformationFormPanelLayout = new GroupLayout(this.TicketInformationFormPanel);
            TicketInformationFormPanel.setLayout(TicketInformationFormPanelLayout);
            TicketInformationFormPanelLayout.setHorizontalGroup(
                TicketInformationFormPanelLayout.createParallelGroup()
                    .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                        .addGroup(TicketInformationFormPanelLayout.createParallelGroup()
                            .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(this.SaveButton)
                                .addGap(53, 53, 53)
                                .addComponent(this.CancelButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                            .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                .addGroup(TicketInformationFormPanelLayout.createParallelGroup()
                                    .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addGroup(TicketInformationFormPanelLayout.createParallelGroup()
                                            .addComponent(this.EventID, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(this.TicketID, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(this.SeatID, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                        .addGap(105, 105, 105)
                                        .addComponent(this.StageID, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(this.TicketPrice)))
                                .addGap(90, 90, 90)
                                .addGroup(TicketInformationFormPanelLayout.createParallelGroup()
                                    .addComponent(this.TicketIDField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.SeatIDField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.TicketPriceField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.StageIDField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.EventIDField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))
                        .addGap(170, 170, 170))
            );
            TicketInformationFormPanelLayout.setVerticalGroup(
                TicketInformationFormPanelLayout.createParallelGroup()
                    .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(TicketInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(this.TicketID, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.TicketIDField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                        .addGroup(TicketInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(this.EventID, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                            .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(this.EventIDField)))
                        .addGap(18, 18, 18)
                        .addGroup(TicketInformationFormPanelLayout.createParallelGroup()
                            .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                .addComponent(this.SeatID, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(this.StageID, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                            .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                .addComponent(this.SeatIDField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(this.StageIDField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(TicketInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(this.TicketPrice, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addGroup(TicketInformationFormPanelLayout.createSequentialGroup()
                                .addComponent(this.TicketPriceField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addGap(40, 40, 40)
                        .addGroup(TicketInformationFormPanelLayout.createParallelGroup()
                            .addComponent(this.SaveButton)
                            .addComponent(this.CancelButton)))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void saveTicket() throws SQLException {
        System.out.println("Save Ticket");
        if (this.TicketIDField.getText().isEmpty() || this.EventIDField.getText().isEmpty()
                || this.SeatIDField.getText().isEmpty() || this.StageIDField.getText().isEmpty()
                || this.TicketPriceField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        } else {
            Ticket ticket = null;
            if (selectedID == -1 ) { // insert
                ticket = new Ticket();
                ticket.setTicketID(Integer.parseInt(this.TicketIDField.getText()));
                ticket.setEventID(Integer.parseInt(this.EventIDField.getText()));
                ticket.setSeatID(Integer.parseInt(this.SeatIDField.getText()));
                ticket.setStageID(Integer.parseInt(this.StageIDField.getText()));
                ticket.setPrice(Double.parseDouble(this.TicketPriceField.getText()));
            }
            else { // update
                ticket = TicketDAO.getInstance().selectByID(selectedID);
                ticket.setTicketID(selectedID);
                ticket.setEventID(Integer.parseInt(this.EventIDField.getText()));
                ticket.setSeatID(Integer.parseInt(this.SeatIDField.getText()));
                ticket.setStageID(Integer.parseInt(this.StageIDField.getText()));
                ticket.setPrice(Double.parseDouble(this.TicketPriceField.getText()));
            }
            if (selectedID != -1) {
                System.out.println("Update Ticket");
                int rowChanged = TicketDAO.getInstance().updateTicket(ticket);
                if (rowChanged == 0) {
                    JOptionPane.showMessageDialog(null, "Update failed");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Update successful");
                }
            }
            else {
                System.out.println("Add Ticket");
                int rowChanged = TicketDAO.getInstance().addTicket(ticket);
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
