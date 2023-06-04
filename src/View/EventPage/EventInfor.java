/*
 * Created by JFormDesigner on Sun Jun 04 17:11:52 ICT 2023
 */

package View.EventPage;

import Model.DAO.Event.AddNewEvent.getLastestID;
import Model.DAO.Event.AddNewEvent.getStageName;
import Model.Database.UserDatabase;

import java.awt.*;
import java.awt.event.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author mangg
 */
public class EventInfor extends JPanel {
    String filename = null;
    static Integer stageID;
    byte[] event_image = null;
    public EventInfor() {
        initComponents();
        initMoreSetting();
    }

    private void initMoreSetting() {
        TextID.setEnabled(false);
        TextID.setText(String.valueOf((getLastestID.getLatestID() + 1)));
        getStageName.getStageName();
    }
    public JLabel getID() {
        return ID;
    }

    public JLabel getArtist() {
        return Artist;
    }

    public JLabel getStage() {
        return Stage;
    }

    public JLabel getDate() {
        return Date;
    }

    public JLabel getOpenTime() {
        return OpenTime;
    }

    public JLabel getPoster() {
        return Poster;
    }

    public JLabel getDescription() {
        return Description;
    }

    public JLabel getQuantity() {
        return Quantity;
    }

    public JLabel getCloseTime() {
        return CloseTime;
    }

    private void uploadBtnMouseClicked(MouseEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        textPoster.setIcon(new ImageIcon(f.toString()));
        filename = f.getAbsolutePath();
        pathFileText.setText(filename);
        try {
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            event_image = bos.toByteArray();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static JComboBox getStageComboBox() {
        return stageComboBox;
    }

    private void setStageID(Integer stageID) {
        this.stageID = stageID;
    }

    public static Integer getStageID() {
        return stageID;
    }

    private void addBtnMouseClicked(MouseEvent e) {
        int id = Integer.parseInt(TextID.getText());
        String stage = stageComboBox.getSelectedItem().toString();
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Select STG_ID from stage where STG_NAME = '" + stage + "'";
            PreparedStatement psStage = con.prepareStatement(sql);
            ResultSet rsStage = psStage.executeQuery();
            while (rsStage.next()) {
                Integer stageID = Integer.parseInt(rsStage.getString("STG_ID"));
                setStageID(stageID);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String name = textName.getText();
        String artist = textArtist.getText();
        Integer quantity = Integer.parseInt(textQuantity.getText());
        String description = textDescription.getText();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateTextField.getText(), formatter);
        java.sql.Date dateFormatted = java.sql.Date.valueOf(date);

        String openTime = Open_Hour.getValue() + ":" + Open_Minute.getValue() + ":" + Open_Second.getValue();
        java.sql.Time openTimeFormatted = java.sql.Time.valueOf(openTime);
        String closeTime = Close_Hour.getValue() + ":" + Close_Minute.getValue() + ":" + Close_Second.getValue();
        java.sql.Time closeTimeFormatted = java.sql.Time.valueOf(closeTime);

        try {
            Connection con1 = UserDatabase.getConnection();
            String query = "INSERT INTO event (EVT_ID, EVT_NAME, EVT_STG_ID, EVT_ARTIST, EVT_DATE, EVT_OPEN_TIME, EVT_END_TIME, EVT_QUANTITY, EVT_DESCRIPTION, EVT_PHOTO) VALUES";
            query += "(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con1.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, getStageID());
            ps.setString(4, artist);
            ps.setDate(5, dateFormatted);
            ps.setTime(6, openTimeFormatted);
            ps.setTime(7, closeTimeFormatted);
            ps.setInt(8, quantity);
            ps.setString(9, description);
            ps.setBytes(10, event_image);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Event added successfully!");
            textName.setText("");
            textArtist.setText("");
            textQuantity.setText("");
            textDescription.setText("");
            textPoster.setIcon(null);
            pathFileText.setText("");
            Open_Hour.setValue(0);
            Open_Minute.setValue(0);
            Open_Second.setValue(0);
            Close_Hour.setValue(0);
            Close_Minute.setValue(0);
            Close_Second.setValue(0);
            dateTextField.setText("");
            TextID.setText(getLastestID.getLatestID() + 1 + "");
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Man
        ID = new JLabel();
        Name = new JLabel();
        Artist = new JLabel();
        Stage = new JLabel();
        Date = new JLabel();
        OpenTime = new JLabel();
        Open_Hour = new JSpinner();
        textPoster = new JLabel();
        scrollPane1 = new JScrollPane();
        textDescription = new JTextArea();
        textQuantity = new JTextField();
        dateTextField = new JTextField();
        textArtist = new JTextField();
        textName = new JTextField();
        Poster = new JLabel();
        Description = new JLabel();
        Quantity = new JLabel();
        CloseTime = new JLabel();
        Close_Hour = new JSpinner();
        Close_Minute = new JSpinner();
        Close_Second = new JSpinner();
        Open_Second = new JSpinner();
        Open_Minute = new JSpinner();
        pathFileText = new JTextField();
        panel1 = new JPanel();
        addBtn = new JLabel();
        panel2 = new JPanel();
        uploadBtn = new JLabel();
        stageComboBox = new JComboBox();
        TextID = new JLabel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );

        //---- ID ----
        ID.setText("ID");
        ID.setFont(new Font("Lato Black", Font.BOLD, 16));
        ID.setForeground(Color.darkGray);

        //---- Name ----
        Name.setText("Name");
        Name.setFont(new Font("Lato Black", Font.BOLD, 16));
        Name.setForeground(Color.darkGray);

        //---- Artist ----
        Artist.setText("Artist");
        Artist.setFont(new Font("Lato Black", Font.BOLD, 16));
        Artist.setForeground(Color.darkGray);

        //---- Stage ----
        Stage.setText("Stage");
        Stage.setFont(new Font("Lato Black", Font.BOLD, 16));
        Stage.setForeground(Color.darkGray);

        //---- Date ----
        Date.setText("Date");
        Date.setFont(new Font("Lato Black", Font.BOLD, 16));
        Date.setForeground(Color.darkGray);

        //---- OpenTime ----
        OpenTime.setText("Open Time");
        OpenTime.setFont(new Font("Lato Black", Font.BOLD, 16));
        OpenTime.setForeground(Color.darkGray);

        //---- Open_Hour ----
        Open_Hour.setModel(new SpinnerNumberModel(0, 0, 24, 1));

        //---- textPoster ----
        textPoster.setText("text");
        textPoster.setBorder(LineBorder.createBlackLineBorder());

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textDescription);
        }

        //---- Poster ----
        Poster.setText("Poster");
        Poster.setFont(new Font("Lato Black", Font.BOLD, 16));
        Poster.setForeground(Color.darkGray);

        //---- Description ----
        Description.setText("Description");
        Description.setFont(new Font("Lato Black", Font.BOLD, 16));
        Description.setForeground(Color.darkGray);

        //---- Quantity ----
        Quantity.setText("Quantity");
        Quantity.setFont(new Font("Lato Black", Font.BOLD, 16));
        Quantity.setForeground(Color.darkGray);

        //---- CloseTime ----
        CloseTime.setText("Close Time");
        CloseTime.setFont(new Font("Lato Black", Font.BOLD, 16));
        CloseTime.setForeground(Color.darkGray);

        //---- Close_Hour ----
        Close_Hour.setModel(new SpinnerNumberModel(0, 0, 24, 1));

        //---- Close_Minute ----
        Close_Minute.setModel(new SpinnerNumberModel(0, 0, 59, 1));

        //---- Close_Second ----
        Close_Second.setModel(new SpinnerNumberModel(0, 0, 59, 1));

        //---- Open_Second ----
        Open_Second.setModel(new SpinnerNumberModel(0, 0, 59, 1));

        //---- Open_Minute ----
        Open_Minute.setModel(new SpinnerNumberModel(0, 0, 59, 1));

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout());

            //---- addBtn ----
            addBtn.setText("text");
            addBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    addBtnMouseClicked(e);
                }
            });
            panel1.add(addBtn);
        }

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout());

            //---- uploadBtn ----
            uploadBtn.setText("text");
            uploadBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    uploadBtnMouseClicked(e);
                }
            });
            panel2.add(uploadBtn);
        }

        //---- TextID ----
        TextID.setText("text");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(135, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(OpenTime, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(Open_Hour, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                    .addGap(11, 11, 11)
                                    .addComponent(Open_Minute, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                    .addGap(11, 11, 11)
                                    .addComponent(Open_Second, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(CloseTime, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(Close_Hour, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                    .addGap(11, 11, 11)
                                    .addComponent(Close_Minute, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                    .addGap(11, 11, 11)
                                    .addComponent(Close_Second, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                                .addComponent(Description)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(Poster)
                                        .addComponent(textPoster, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(pathFileText, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(111, 111, 111)
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Artist)
                                    .addGap(94, 94, 94)
                                    .addComponent(textArtist, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
                                    .addGap(60, 60, 60)
                                    .addComponent(Quantity)
                                    .addGap(35, 35, 35)
                                    .addComponent(textQuantity, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(Name)
                                        .addComponent(ID))
                                    .addGap(93, 93, 93)
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(textName, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
                                            .addGap(60, 60, 60)
                                            .addComponent(Date))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(TextID)
                                            .addGap(225, 225, 225)
                                            .addComponent(Stage)))
                                    .addGap(57, 57, 57)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateTextField, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                        .addComponent(stageComboBox, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))))))
                    .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(ID)
                            .addComponent(TextID))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(Stage)
                            .addComponent(stageComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(Name)
                        .addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Date)
                        .addComponent(dateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(Artist)
                        .addComponent(textArtist, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Quantity)
                        .addComponent(textQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(OpenTime, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Open_Hour, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Open_Minute, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Open_Second, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                            .addGap(5, 5, 5)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(CloseTime, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Close_Hour, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Close_Minute, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Close_Second, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                            .addGap(5, 5, 5)
                            .addComponent(Description, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Poster)
                            .addGap(8, 8, 8)
                            .addComponent(textPoster, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(panel2, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addComponent(pathFileText, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                            .addGap(106, 106, 106)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(49, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Man
    private JLabel ID;
    private JLabel Name;
    private JLabel Artist;
    private JLabel Stage;
    private JLabel Date;
    private JLabel OpenTime;
    private JSpinner Open_Hour;
    private JLabel textPoster;
    private JScrollPane scrollPane1;
    private JTextArea textDescription;
    private JTextField textQuantity;
    private JTextField dateTextField;
    private JTextField textArtist;
    private JTextField textName;
    private JLabel Poster;
    private JLabel Description;
    private JLabel Quantity;
    private JLabel CloseTime;
    private JSpinner Close_Hour;
    private JSpinner Close_Minute;
    private JSpinner Close_Second;
    private JSpinner Open_Second;
    private JSpinner Open_Minute;
    private JTextField pathFileText;
    private JPanel panel1;
    private JLabel addBtn;
    private JPanel panel2;
    private JLabel uploadBtn;
    private static JComboBox stageComboBox;
    private JLabel TextID;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
