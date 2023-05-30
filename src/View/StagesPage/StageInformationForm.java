package View.StagesPage;

import Controller.StagesPage.StageInformationController;
import Model.BEAN.Stage;
import Model.DAO.Stage.StageDAO;
import View.MainPage.MainPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class StageInformationForm extends JPanel{
    static int selectedID = -1;
    ActionListener ac = new StageInformationController(this);
    public StageInformationForm() {
        initComponents();
        getSaveButton().addActionListener(ac);
        getCancelButton().addActionListener(ac);
    }

    public StageInformationForm(Stage stage) {
        initComponents();
        getSaveButton().addActionListener(ac);
        getCancelButton().addActionListener(ac);
        initSomeComponents(stage);
    }

    public StageInformationForm(int newID){
        initComponents();
        getSaveButton().addActionListener(ac);
        getCancelButton().addActionListener(ac);
        this.IDField.setText(String.valueOf(newID));
    }

    private void initSomeComponents(Stage stage) {
        this.IDField.setText(String.valueOf(stage.getId()));
        this.NameField.setText(stage.getName());
        this.AddressField.setText(stage.getAddress());
        this.RentalPriceField.setText(String.valueOf(stage.getRentalPrice()));
        this.CapacityField.setText(String.valueOf(stage.getCapacity()));

        this.Open_Hour.setValue(Integer.parseInt(stage.getOpenTime().substring(0, 2)));
        this.Open_Minute.setValue(Integer.parseInt(stage.getOpenTime().substring(3, 5)));
        this.Open_Second.setValue(Integer.parseInt(stage.getOpenTime().substring(6, 8)));

        this.Close_Hour.setValue(Integer.parseInt(stage.getCloseTime().substring(0, 2)));
        this.Close_Minute.setValue(Integer.parseInt(stage.getCloseTime().substring(3, 5)));
        this.Close_Second.setValue(Integer.parseInt(stage.getCloseTime().substring(6, 8)));

        this.selectedID = stage.getId();
    }

    public JTextField getIDField() {
        return this.IDField;
    }

    public JTextField getNameField() {
        return this.NameField;
    }

    public JTextField getAddressField() {
        return this.AddressField;
    }

    public JTextField getRentalPriceField() {
        return this.RentalPriceField;
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

    public JPanel getStageInformationFormPanel() {
        return this.StageInformationFormPanel;
    }

    public JLabel getTicketPrice2() {
        return this.TicketPrice2;
    }

    public JLabel getTicketPrice3() {
        return this.TicketPrice3;
    }

    public JTextField getCapacityField() {
        return this.CapacityField;
    }

    public JSpinner getOpen_Hour() {
        return this.Open_Hour;
    }

    public JSpinner getOpen_Minute() {
        return this.Open_Minute;
    }

    public JSpinner getOpen_Second() {
        return this.Open_Second;
    }

    public JSpinner getClose_Hour() {
        return this.Close_Hour;
    }

    public JSpinner getClose_Minute() {
        return this.Close_Minute;
    }

    public JSpinner getClose_Second() {
        return this.Close_Second;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Dat
        this.StageInformationFormPanel = new JPanel();
        this.TicketID = new JLabel();
        this.EventID = new JLabel();
        this.TicketPrice = new JLabel();
        this.StageID = new JLabel();
        this.SeatID = new JLabel();
        this.IDField = new JTextField();
        this.NameField = new JTextField();
        this.AddressField = new JTextField();
        this.RentalPriceField = new JTextField();
        this.SaveButton = new JButton();
        this.CancelButton = new JButton();
        this.TicketPrice2 = new JLabel();
        this.TicketPrice3 = new JLabel();
        this.CapacityField = new JTextField();
        this.Open_Hour = new JSpinner();
        this.Open_Minute = new JSpinner();
        this.Open_Second = new JSpinner();
        this.Close_Hour = new JSpinner();
        this.Close_Minute = new JSpinner();
        this.Close_Second = new JSpinner();

        //======== StageInformationFormPanel ========
        {
            this.StageInformationFormPanel.setBackground(Color.white);
            this.StageInformationFormPanel.setMinimumSize(new Dimension(670, 500));
            this.StageInformationFormPanel.setMaximumSize(new Dimension(670, 500));
            this.StageInformationFormPanel.setPreferredSize(new Dimension(670, 600));
            this.StageInformationFormPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
            swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border
            . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067"
            ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,this.StageInformationFormPanel. getBorder
            ( )) ); this.StageInformationFormPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
            .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException
            ( ); }} );

            //---- TicketID ----
            this.TicketID.setText("ID");
            this.TicketID.setFont(new Font("Leelawadee", Font.BOLD, 20));
            this.TicketID.setForeground(Color.black);

            //---- EventID ----
            this.EventID.setText("Name");
            this.EventID.setFont(new Font("Leelawadee", Font.BOLD, 20));
            this.EventID.setForeground(Color.black);

            //---- TicketPrice ----
            this.TicketPrice.setText("Capacity");
            this.TicketPrice.setFont(new Font("Leelawadee", Font.BOLD, 20));
            this.TicketPrice.setForeground(Color.black);

            //---- StageID ----
            this.StageID.setText("Rental Price");
            this.StageID.setFont(new Font("Leelawadee", Font.BOLD, 20));
            this.StageID.setForeground(Color.black);

            //---- SeatID ----
            this.SeatID.setText("Address");
            this.SeatID.setFont(new Font("Leelawadee", Font.BOLD, 20));
            this.SeatID.setForeground(Color.black);

            //---- IDField ----
            this.IDField.setEditable(false);
            this.IDField.setBackground(Color.lightGray);
            this.IDField.setForeground(Color.white);

            //---- SaveButton ----
            this.SaveButton.setText("SAVE");

            //---- CancelButton ----
            this.CancelButton.setText("CANCEL");

            //---- TicketPrice2 ----
            this.TicketPrice2.setText("Open Time");
            this.TicketPrice2.setFont(new Font("Leelawadee", Font.BOLD, 20));
            this.TicketPrice2.setForeground(Color.black);

            //---- TicketPrice3 ----
            this.TicketPrice3.setText("Close Time");
            this.TicketPrice3.setFont(new Font("Leelawadee", Font.BOLD, 20));
            this.TicketPrice3.setForeground(Color.black);

            //---- Open_Hour ----
            this.Open_Hour.setModel(new SpinnerNumberModel(0, 0, 24, 1));

            //---- Open_Minute ----
            this.Open_Minute.setModel(new SpinnerNumberModel(0, 0, 59, 1));

            //---- Open_Second ----
            this.Open_Second.setModel(new SpinnerNumberModel(0, 0, 59, 1));

            //---- Close_Hour ----
            this.Close_Hour.setModel(new SpinnerNumberModel(0, 0, 24, 1));

            //---- Close_Minute ----
            this.Close_Minute.setModel(new SpinnerNumberModel(0, 0, 59, 1));

            //---- Close_Second ----
            this.Close_Second.setModel(new SpinnerNumberModel(0, 0, 59, 1));

            GroupLayout StageInformationFormPanelLayout = new GroupLayout(this.StageInformationFormPanel);
            StageInformationFormPanel.setLayout(StageInformationFormPanelLayout);
            StageInformationFormPanelLayout.setHorizontalGroup(
                StageInformationFormPanelLayout.createParallelGroup()
                    .addGroup(StageInformationFormPanelLayout.createSequentialGroup()
                        .addGroup(StageInformationFormPanelLayout.createParallelGroup()
                            .addGroup(StageInformationFormPanelLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(StageInformationFormPanelLayout.createParallelGroup()
                                    .addComponent(this.EventID, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.TicketID, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.SeatID, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.StageID, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(StageInformationFormPanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(this.TicketPrice))))
                            .addGroup(StageInformationFormPanelLayout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addGroup(StageInformationFormPanelLayout.createParallelGroup()
                                    .addComponent(this.TicketPrice3)
                                    .addComponent(this.TicketPrice2)))
                            .addGroup(StageInformationFormPanelLayout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(this.SaveButton)))
                        .addGap(33, 33, 33)
                        .addGroup(StageInformationFormPanelLayout.createParallelGroup()
                            .addGroup(StageInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(this.CancelButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                .addComponent(this.NameField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addComponent(this.IDField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addGroup(StageInformationFormPanelLayout.createSequentialGroup()
                                    .addComponent(this.Open_Hour, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(this.Open_Minute, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(this.Open_Second, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                                .addComponent(this.CapacityField)
                                .addComponent(this.RentalPriceField)
                                .addComponent(this.AddressField))
                            .addGroup(StageInformationFormPanelLayout.createSequentialGroup()
                                .addComponent(this.Close_Hour, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(this.Close_Minute, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(this.Close_Second, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
                        .addGap(169, 169, 169))
            );
            StageInformationFormPanelLayout.setVerticalGroup(
                StageInformationFormPanelLayout.createParallelGroup()
                    .addGroup(StageInformationFormPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(StageInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(this.TicketID, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.IDField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                        .addGroup(StageInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(StageInformationFormPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(this.EventID, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                            .addGroup(StageInformationFormPanelLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(this.NameField)))
                        .addGap(18, 18, 18)
                        .addGroup(StageInformationFormPanelLayout.createParallelGroup()
                            .addGroup(StageInformationFormPanelLayout.createSequentialGroup()
                                .addComponent(this.SeatID, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(this.StageID, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                            .addGroup(StageInformationFormPanelLayout.createSequentialGroup()
                                .addComponent(this.AddressField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(this.RentalPriceField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(StageInformationFormPanelLayout.createParallelGroup()
                            .addGroup(StageInformationFormPanelLayout.createSequentialGroup()
                                .addComponent(this.TicketPrice, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(GroupLayout.Alignment.TRAILING, StageInformationFormPanelLayout.createSequentialGroup()
                                .addComponent(this.CapacityField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(StageInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(this.TicketPrice2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.Open_Hour, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.Open_Minute, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.Open_Second, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(StageInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(this.TicketPrice3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.Close_Hour, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.Close_Minute, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.Close_Second, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(StageInformationFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(this.SaveButton)
                            .addComponent(this.CancelButton))
                        .addContainerGap(50, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Dat
    private JPanel StageInformationFormPanel;
    private JLabel TicketID;
    private JLabel EventID;
    private JLabel TicketPrice;
    private JLabel StageID;
    private JLabel SeatID;
    private JTextField IDField;
    private JTextField NameField;
    private JTextField AddressField;
    private JTextField RentalPriceField;
    private JButton SaveButton;
    private JButton CancelButton;
    private JLabel TicketPrice2;
    private JLabel TicketPrice3;
    private JTextField CapacityField;
    private JSpinner Open_Hour;
    private JSpinner Open_Minute;
    private JSpinner Open_Second;
    private JSpinner Close_Hour;
    private JSpinner Close_Minute;
    private JSpinner Close_Second;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


    public void saveStage() throws SQLException {
        System.out.println("Save Stage");
        if (this.IDField.getText().equals("") || this.NameField.getText().equals("") || this.AddressField.getText().equals("")
                || this.RentalPriceField.getText().equals("") || this.CapacityField.getText().equals("")
                || this.Open_Hour.getValue().equals("") || this.Open_Minute.getValue().equals("") || this.Open_Second.getValue().equals("")
                || this.Close_Hour.getValue().equals("") || this.Close_Minute.getValue().equals("") || this.Close_Second.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        }
        else {
            Stage stage = null;
            if (selectedID == -1 ) { // insert
                stage = new Stage();
                stage.setId(Integer.parseInt(this.IDField.getText()));
                stage.setName(this.NameField.getText());
                stage.setAddress(this.AddressField.getText());
                stage.setRentalPrice(Double.parseDouble(this.RentalPriceField.getText()));
                stage.setCapacity(Integer.parseInt(this.CapacityField.getText()));

                String openTime = this.Open_Hour.getValue() + ":" + this.Open_Minute.getValue() + ":" + this.Open_Second.getValue();
                stage.setOpenTime(openTime);

                String closeTime = this.Close_Hour.getValue() + ":" + this.Close_Minute.getValue() + ":" + this.Close_Second.getValue();
                stage.setCloseTime(closeTime);
            }
            else { // update
                try {
                stage = StageDAO.getInstance().selectByID(selectedID);
                stage.setId(selectedID);
                stage.setName(this.NameField.getText());
                stage.setAddress(this.AddressField.getText());
                stage.setRentalPrice(Double.parseDouble(this.RentalPriceField.getText()));
                stage.setCapacity(Integer.parseInt(this.CapacityField.getText()));
                String openTime = this.Open_Hour.getValue() + ":" + this.Open_Minute.getValue() + ":" + this.Open_Second.getValue();
                stage.setOpenTime(openTime);

                String closeTime = this.Close_Hour.getValue() + ":" + this.Close_Minute.getValue() + ":" + this.Close_Second.getValue();
                stage.setCloseTime(closeTime);
            } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (selectedID != -1) {
                System.out.println("Update Stage");
                int rowChanged = StageDAO.getInstance().updateStage(stage);
                if (rowChanged == 0) {
                    JOptionPane.showMessageDialog(null, "Update failed");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Update successfully");
                }
            }
            else {
                System.out.println("Insert Stage");
                int rowChanged = StageDAO.getInstance().addStage(stage);
                if (rowChanged == 0) {
                    JOptionPane.showMessageDialog(null, "Insert failed");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Insert successfully");
                }
            }
            MainPage.changeView(new StagesListPanel(), MainPage.getJlbStages() , "Stage List Panel");
        }
    }

    public void cancelStage() {
        MainPage.changeView(new StagesListPanel(), MainPage.getJlbStages() , "Stage List Panel");
    }
}
