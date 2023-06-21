/*
 * Created by JFormDesigner on Sun Jun 04 17:11:52 ICT 2023
 */

package View.EventPage;

import Model.DAO.Event.AddNewEvent.getLastestID;
import Model.DAO.Event.AddNewEvent.getStageName;
import Model.Database.UserDatabase;
import View.EventListPanel.EventListPanel;
import View.MainPage.MainPage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import com.github.lgooddatepicker.components.*;


/**
 * @author mangg
 */
public class EventInformation extends JPanel {
    String filename = null;
    static Integer stageID;
    static byte[] event_image = null;
    public EventInformation() {
        initComponents();
        initMoreSetting();
    }

    public void initMoreSetting() {
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

    public static void getImage() {
        String sql = "SELECT EVT_POSTER FROM mctmsys.event WHERE EVT_ID = ?";
        Connection connection = UserDatabase.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(TextID.getText()));
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Blob blob = resultSet.getBlob("EVT_POSTER");
                event_image = blob.getBytes(1, (int) blob.length());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void addBtnMouseClicked(MouseEvent e) {
        String stage = stageComboBox.getSelectedItem().toString();
        try {
            Connection con1 = UserDatabase.getConnection();
            String sql1 = "Select STG_ID from mctmsys.stage where STG_NAME = '" + stage + "'";
            PreparedStatement psStage = con1.prepareStatement(sql1);
            ResultSet rsStage = psStage.executeQuery();
            while (rsStage.next()) {
                Integer stageID = Integer.parseInt(rsStage.getString("STG_ID"));
                setStageID(stageID);
            }
        } catch (SQLException throwables1) {
            throwables1.printStackTrace();
        }

        int id = Integer.parseInt(TextID.getText());
        try {
            Connection con = UserDatabase.getConnection();
            String sql = "Select EVT_ID from mctmsys.event where EVT_ID = '" + id + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                try {
                    String sqlUpdate = "UPDATE mctmsys.event SET EVT_NAME = ?, EVT_STG_ID = ?, EVT_ARTIST = ?, EVT_DATE = ?, EVT_OPEN_TIME = ?, EVT_END_TIME = ?, EVT_QUANTITY = ?, EVT_DESCRIPTION = ?, EVT_POSTER = ? WHERE EVT_ID = " + id + ";";
                    PreparedStatement psUpdate = con.prepareStatement(sqlUpdate);
                    psUpdate.setString(1, textName.getText());
                    psUpdate.setInt(2, stageID);
                    psUpdate.setString(3, textArtist.getText());
                    psUpdate.setDate(4, java.sql.Date.valueOf(getDateJDatePicker().getDate()));
                    psUpdate.setTime(5, java.sql.Time.valueOf(Open_Hour.getValue() + ":" + Open_Minute.getValue() + ":" + Open_Second.getValue()));
                    psUpdate.setTime(6, java.sql.Time.valueOf(Close_Hour.getValue() + ":" + Close_Minute.getValue() + ":" + Close_Second.getValue()));
                    psUpdate.setInt(7, Integer.parseInt(textQuantity.getText()));
                    psUpdate.setString(8, textDescription.getText());
                    psUpdate.setBytes(9, event_image);
                    psUpdate.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update successfully!");
                } catch (Exception err) {
                    JOptionPane.showInputDialog(this, "Error: " + err.getMessage());
                }
            } else {
                if(textName.getText().equals("") || textArtist.getText().equals("")  || textDescription.getText().equals("") || getDateJDatePicker().getText().equals("")  || textPoster.getIcon() == null || textQuantity.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please fill all information!");
                } else {
                    String name = textName.getText();
                    String artist = textArtist.getText();
                    try {
                        Integer quantity = Integer.parseInt(textQuantity.getText());
                    } catch (NumberFormatException err) {
                        JOptionPane.showMessageDialog(this, "Quantity must be a number!");
                        return;
                    }
                    Integer quantity = Integer.parseInt(textQuantity.getText());
                    String description = textDescription.getText();

                    java.sql.Date dateFormatted = null;
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate localDate = getDateJDatePicker().getDate();
                        String date = formatter.format(localDate);
                        dateFormatted = java.sql.Date.valueOf(date);

                    } catch (DateTimeParseException err) {
                        JOptionPane.showMessageDialog(this, "Date must be in dd-MM-yyyy format!");
                        return;
                    }
                    String openTime = Open_Hour.getValue() + ":" + Open_Minute.getValue() + ":" + Open_Second.getValue();
                    java.sql.Time openTimeFormatted = java.sql.Time.valueOf(openTime);
                    String closeTime = Close_Hour.getValue() + ":" + Close_Minute.getValue() + ":" + Close_Second.getValue();
                    java.sql.Time closeTimeFormatted = java.sql.Time.valueOf(closeTime);

                    try {
                        Connection con2 = UserDatabase.getConnection();
                        String query = "INSERT INTO mctmsys.event (EVT_ID, EVT_NAME, EVT_STG_ID, EVT_ARTIST, EVT_DATE, EVT_OPEN_TIME, EVT_END_TIME, EVT_QUANTITY, EVT_DESCRIPTION, EVT_POSTER) VALUES";
                        query += "(?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps1 = con2.prepareStatement(query);
                        ps1.setInt(1, id);
                        System.out.println(id);
                        ps1.setString(2, name);
                        System.out.println(name);
                        ps1.setInt(3, stageID);
                        System.out.println(stageID);
                        ps1.setString(4, artist);
                        System.out.println(artist);
                        ps1.setDate(5, dateFormatted);
                        System.out.println(dateFormatted);
                        ps1.setTime(6, openTimeFormatted);
                        System.out.println(openTimeFormatted);
                        ps1.setTime(7, closeTimeFormatted);
                        System.out.println(closeTimeFormatted);
                        ps1.setInt(8, quantity);
                        System.out.println(quantity);
                        ps1.setString(9, description);
                        System.out.println(description);
                        ps1.setBytes(10, event_image);
                        ps1.executeUpdate();

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
                        getDateJDatePicker().setText("");
                        TextID.setText(getLastestID.getLatestID() + 1 + "");

                        MainPage.changeView(new EventListPanel(), MainPage.getJlbEvent(), "Event List");
                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(null, err);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static JTextField getTextID() {
        return TextID;
    }

    public static JTextField getTextName() {
        return textName;
    }

    public static JTextArea getTextDescription() {
        return textDescription;
    }

    public static JTextField getTextQuantity() {
        return textQuantity;
    }

    public static JTextField getTextArtist() {
        return textArtist;
    }

    public static JSpinner getOpen_Hour() {
        return Open_Hour;
    }

    public static JSpinner getOpen_Minute() {
        return Open_Minute;
    }

    public static JSpinner getOpen_Second() {
        return Open_Second;
    }

    public static JSpinner getClose_Second() {
        return Close_Second;
    }

    public static JSpinner getClose_Minute() {
        return Close_Minute;
    }

    public static JSpinner getClose_Hour() {
        return Close_Hour;
    }

    public static JLabel getTextPoster() {
        return textPoster;
    }

    private void button1MouseClicked(MouseEvent e) {
        MainPage.changeView(new EventListPanel(), MainPage.getJlbEvent(), "EventInfor");
    }

    public static DatePicker getDateJDatePicker() {
        return dateJDatePicker;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Xuan Quynh Le
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
        dateJDatePicker = new DatePicker();
        textArtist = new JTextField();
        textName = new JTextField();
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
        button1 = new JButton();
        panel2 = new JPanel();
        uploadBtn = new JLabel();
        stageComboBox = new JComboBox();
        label1 = new JLabel();
        TextID = new JTextField();
        panel3 = new JPanel();
        addBtn = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
        swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border
        .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog"
        ,java.awt.Font.BOLD,12),java.awt.Color.red), getBorder
        ())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
        .beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException
        ();}});

        //---- ID ----
        ID.setText("ID");
        ID.setFont(new Font("Lato Black", Font.BOLD, 16));
        ID.setForeground(new Color(0x61b884));

        //---- Name ----
        Name.setText("Event name");
        Name.setFont(new Font("Lato Black", Font.BOLD, 16));
        Name.setForeground(new Color(0x61b884));

        //---- Artist ----
        Artist.setText("Artist");
        Artist.setFont(new Font("Lato Black", Font.BOLD, 16));
        Artist.setForeground(new Color(0x61b884));

        //---- Stage ----
        Stage.setText("Stage");
        Stage.setFont(new Font("Lato Black", Font.BOLD, 16));
        Stage.setForeground(new Color(0x61b884));

        //---- Date ----
        Date.setText("Date");
        Date.setFont(new Font("Lato Black", Font.BOLD, 16));
        Date.setForeground(new Color(0x61b884));

        //---- OpenTime ----
        OpenTime.setText("Open Time");
        OpenTime.setFont(new Font("Lato Black", Font.BOLD, 16));
        OpenTime.setForeground(new Color(0x61b884));

        //---- Open_Hour ----
        Open_Hour.setModel(new SpinnerNumberModel(0, 0, 24, 1));
        Open_Hour.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- textPoster ----
        textPoster.setBorder(new LineBorder(new Color(0x61b884)));

        //======== scrollPane1 ========
        {

            //---- textDescription ----
            textDescription.setFont(new Font("Arial", Font.PLAIN, 16));
            textDescription.setWrapStyleWord(true);
            textDescription.setLineWrap(true);
            scrollPane1.setViewportView(textDescription);
        }

        //---- textQuantity ----
        textQuantity.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- dateJDatePicker ----
        dateJDatePicker.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- textArtist ----
        textArtist.setFont(new Font("Arial", Font.PLAIN, 16));

        //---- textName ----
        textName.setFont(new Font("Arial", Font.PLAIN, 16));

        //---- Description ----
        Description.setText("Description");
        Description.setFont(new Font("Lato Black", Font.BOLD, 16));
        Description.setForeground(new Color(0x61b884));

        //---- Quantity ----
        Quantity.setText("Quantity");
        Quantity.setFont(new Font("Lato Black", Font.BOLD, 16));
        Quantity.setForeground(new Color(0x61b884));

        //---- CloseTime ----
        CloseTime.setText("Close Time");
        CloseTime.setFont(new Font("Lato Black", Font.BOLD, 16));
        CloseTime.setForeground(new Color(0x61b884));

        //---- Close_Hour ----
        Close_Hour.setModel(new SpinnerNumberModel(0, 0, 24, 1));
        Close_Hour.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- Close_Minute ----
        Close_Minute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        Close_Minute.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- Close_Second ----
        Close_Second.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        Close_Second.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- Open_Second ----
        Open_Second.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        Open_Second.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- Open_Minute ----
        Open_Minute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        Open_Minute.setFont(new Font("Lato", Font.PLAIN, 16));

        //---- pathFileText ----
        pathFileText.setBorder(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0x61b884));
            panel1.setLayout(new GridLayout());

            //---- button1 ----
            button1.setText("CANCEL");
            button1.setFont(new Font("Lato Black", Font.BOLD, 16));
            button1.setForeground(Color.white);
            button1.setBackground(new Color(0x61b884));
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            panel1.add(button1);
        }

        //======== panel2 ========
        {
            panel2.setBackground(new Color(0x61b884));
            panel2.setLayout(new GridLayout());

            //---- uploadBtn ----
            uploadBtn.setText("UPLOAD POSTER");
            uploadBtn.setFont(new Font("Lato Black", Font.BOLD, 14));
            uploadBtn.setHorizontalAlignment(SwingConstants.CENTER);
            uploadBtn.setForeground(Color.white);
            uploadBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    uploadBtnMouseClicked(e);
                }
            });
            panel2.add(uploadBtn);
        }

        //---- stageComboBox ----
        stageComboBox.setFont(new Font("Lato", Font.PLAIN, 16));
        stageComboBox.setBackground(Color.white);

        //---- label1 ----
        label1.setText("EVENT INFORMATION");
        label1.setFont(new Font("Lato Black", Font.BOLD, 25));
        label1.setForeground(new Color(0x61b884));

        //---- TextID ----
        TextID.setBackground(new Color(0xcccccc));
        TextID.setFont(new Font("Lato", Font.PLAIN, 16));
        TextID.setEditable(false);
        TextID.setDisabledTextColor(new Color(0x333333));

        //======== panel3 ========
        {
            panel3.setBackground(new Color(0x61b884));
            panel3.setLayout(new GridLayout());

            //---- addBtn ----
            addBtn.setText("SAVE");
            addBtn.setFont(new Font("Lato Black", Font.BOLD, 16));
            addBtn.setHorizontalAlignment(SwingConstants.CENTER);
            addBtn.setForeground(Color.white);
            addBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    addBtnMouseClicked(e);
                }
            });
            panel3.add(addBtn);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(381, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(388, 388, 388))
                .addGroup(layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(ID)
                                            .addGap(102, 102, 102)
                                            .addComponent(TextID, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(Name)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textName, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(Artist)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textArtist, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(Stage)
                                            .addGap(74, 74, 74)
                                            .addComponent(stageComboBox, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(175, 175, 175)
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createParallelGroup()
                                            .addComponent(OpenTime, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Quantity)
                                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(CloseTime, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(Date)
                                            .addGap(86, 86, 86)))
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textQuantity, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(Open_Hour, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(Open_Minute, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(Open_Second, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(Close_Hour, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(Close_Minute, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(Close_Second, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(dateJDatePicker, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
                                .addComponent(textPoster, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                            .addComponent(pathFileText, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(Description)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                    .addGap(520, 520, 520)
                                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                    .addGap(45, 45, 45)
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 901, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 40, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(label1)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(ID)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(TextID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Date)
                            .addComponent(dateJDatePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Quantity, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Name))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textArtist, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Artist))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Stage)
                                .addComponent(stageComboBox, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Open_Hour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Open_Minute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Open_Second, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(Close_Second, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Close_Minute, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Close_Hour, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(OpenTime)
                            .addGap(30, 30, 30)
                            .addComponent(CloseTime)))
                    .addGap(12, 12, 12)
                    .addComponent(Description)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(171, 171, 171)
                            .addComponent(pathFileText, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(textPoster, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(47, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Xuan Quynh Le
    private JLabel ID;
    private JLabel Name;
    private JLabel Artist;
    private JLabel Stage;
    private JLabel Date;
    private JLabel OpenTime;
    private static JSpinner Open_Hour;
    private static JLabel textPoster;
    private JScrollPane scrollPane1;
    private static JTextArea textDescription;
    private static JTextField textQuantity;
    private static DatePicker dateJDatePicker;
    private static JTextField textArtist;
    private static JTextField textName;
    private JLabel Description;
    private JLabel Quantity;
    private JLabel CloseTime;
    private static JSpinner Close_Hour;
    private static JSpinner Close_Minute;
    private static JSpinner Close_Second;
    private static JSpinner Open_Second;
    private static JSpinner Open_Minute;
    private JTextField pathFileText;
    private JPanel panel1;
    private JButton button1;
    private JPanel panel2;
    private JLabel uploadBtn;
    private static JComboBox stageComboBox;
    private JLabel label1;
    private static JTextField TextID;
    private JPanel panel3;
    private JLabel addBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
