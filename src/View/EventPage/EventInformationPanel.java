/*
 * Created by JFormDesigner on Sat Jun 03 11:01:36 ICT 2023
 */

package View.EventPage;

import java.awt.event.*;
import java.beans.*;
import Model.DAO.Event.AddNewEvent.getLastestID;
import Model.DAO.Event.AddNewEvent.getStageName;
import Model.Database.UserDatabase;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

import static Model.DAO.Event.AddNewEvent.getLastestID.getLatestID;

/**
 * @author quynh
 */
public class EventInformationPanel extends JPanel {
    String filename = null;
    static Integer stageID;
    byte[] event_image = null;
    public EventInformationPanel() {
        initComponents();
        initMoreSetting();
    }
    private void initComponent() {
    }
    private void initMoreSetting() {
        idText.setText(getLastestID.getLatestID() + 1 + "");
        getStageName.getStageName();
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

    public JLabel getID() {
        return ID;
    }

    public String getName() {
        return Name.getText();
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

    public JLabel getCloseTime() {
        return CloseTime;
    }

    public JLabel getQuantity() {
        return Quantity;
    }

    public JLabel getDescription() {
        return Description;
    }

    public JLabel getPoster() {
        return Poster;
    }

    private void addBtnMouseClicked(MouseEvent e) {
        int id = Integer.parseInt(idText.getText());
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
            idText.setText(getLastestID.getLatestID() + 1 + "");
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err);
        }
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

    public JFormattedTextField getDateTextField() {
        return dateTextField;
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
        Open_Minute = new JSpinner();
        Open_Second = new JSpinner();
        Close_Second = new JSpinner();
        Close_Minute = new JSpinner();
        Close_Hour = new JSpinner();
        CloseTime = new JLabel();
        Quantity = new JLabel();
        Description = new JLabel();
        Poster = new JLabel();
        textName = new JTextField();
        textArtist = new JTextField();
        textQuantity = new JTextField();
        scrollPane1 = new JScrollPane();
        textDescription = new JTextArea();
        textPoster = new JLabel();
        idText = new JLabel();
        stageComboBox = new JComboBox();
        panel1 = new JPanel();
        addBtn = new JLabel();
        panel2 = new JPanel();
        uploadBtn = new JLabel();
        pathFileText = new JTextField();
        dateTextField = new JFormattedTextField();

        //======== this ========
        setBackground(Color.white);
        setFont(new Font("Lato Black", Font.BOLD, 16));
        setForeground(Color.darkGray);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
        javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax
        . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
        .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans.
        PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .
        equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //---- ID ----
        ID.setText("ID");
        ID.setFont(new Font("Lato Black", Font.BOLD, 16));
        ID.setForeground(Color.darkGray);
        add(ID);
        ID.setBounds(new Rectangle(new Point(45, 40), ID.getPreferredSize()));

        //---- Name ----
        Name.setText("Name");
        Name.setFont(new Font("Lato Black", Font.BOLD, 16));
        Name.setForeground(Color.darkGray);
        add(Name);
        Name.setBounds(45, 80, 125, Name.getPreferredSize().height);

        //---- Artist ----
        Artist.setText("Artist");
        Artist.setFont(new Font("Lato Black", Font.BOLD, 16));
        Artist.setForeground(Color.darkGray);
        add(Artist);
        Artist.setBounds(45, 120, 120, Artist.getPreferredSize().height);

        //---- Stage ----
        Stage.setText("Stage");
        Stage.setFont(new Font("Lato Black", Font.BOLD, 16));
        Stage.setForeground(Color.darkGray);
        add(Stage);
        Stage.setBounds(new Rectangle(new Point(445, 40), Stage.getPreferredSize()));

        //---- Date ----
        Date.setText("Date");
        Date.setFont(new Font("Lato Black", Font.BOLD, 16));
        Date.setForeground(Color.darkGray);
        add(Date);
        Date.setBounds(445, 80, 95, Date.getPreferredSize().height);

        //---- OpenTime ----
        OpenTime.setText("Open Time");
        OpenTime.setFont(new Font("Lato Black", Font.BOLD, 16));
        OpenTime.setForeground(Color.darkGray);
        add(OpenTime);
        OpenTime.setBounds(40, 165, 105, 45);

        //---- Open_Hour ----
        Open_Hour.setModel(new SpinnerNumberModel(0, 0, 24, 1));
        add(Open_Hour);
        Open_Hour.setBounds(185, 165, 59, 41);

        //---- Open_Minute ----
        Open_Minute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        add(Open_Minute);
        Open_Minute.setBounds(255, 165, 59, 41);

        //---- Open_Second ----
        Open_Second.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        add(Open_Second);
        Open_Second.setBounds(325, 165, 59, 41);

        //---- Close_Second ----
        Close_Second.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        add(Close_Second);
        Close_Second.setBounds(325, 215, 59, 41);

        //---- Close_Minute ----
        Close_Minute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        add(Close_Minute);
        Close_Minute.setBounds(255, 215, 59, 41);

        //---- Close_Hour ----
        Close_Hour.setModel(new SpinnerNumberModel(0, 0, 24, 1));
        add(Close_Hour);
        Close_Hour.setBounds(185, 215, 59, 41);

        //---- CloseTime ----
        CloseTime.setText("Close Time");
        CloseTime.setFont(new Font("Lato Black", Font.BOLD, 16));
        CloseTime.setForeground(Color.darkGray);
        add(CloseTime);
        CloseTime.setBounds(40, 215, 105, 45);

        //---- Quantity ----
        Quantity.setText("Quantity");
        Quantity.setFont(new Font("Lato Black", Font.BOLD, 16));
        Quantity.setForeground(Color.darkGray);
        add(Quantity);
        Quantity.setBounds(445, 120, 90, Quantity.getPreferredSize().height);

        //---- Description ----
        Description.setText("Description");
        Description.setFont(new Font("Lato Black", Font.BOLD, 16));
        Description.setForeground(Color.darkGray);
        add(Description);
        Description.setBounds(40, 265, Description.getPreferredSize().width, 35);

        //---- Poster ----
        Poster.setText("Poster");
        Poster.setFont(new Font("Lato Black", Font.BOLD, 16));
        Poster.setForeground(Color.darkGray);
        add(Poster);
        Poster.setBounds(new Rectangle(new Point(625, 165), Poster.getPreferredSize()));
        add(textName);
        textName.setBounds(180, 80, 205, textName.getPreferredSize().height);
        add(textArtist);
        textArtist.setBounds(180, 120, 205, textArtist.getPreferredSize().height);
        add(textQuantity);
        textQuantity.setBounds(545, 120, 205, textQuantity.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textDescription);
        }
        add(scrollPane1);
        scrollPane1.setBounds(40, 300, 455, 270);

        //---- textPoster ----
        textPoster.setBorder(new TitledBorder("Image"));
        add(textPoster);
        textPoster.setBounds(570, 195, 155, 150);

        //---- idText ----
        idText.setText("text");
        add(idText);
        idText.setBounds(new Rectangle(new Point(180, 40), idText.getPreferredSize()));
        add(stageComboBox);
        stageComboBox.setBounds(545, 40, 205, stageComboBox.getPreferredSize().height);

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout());

            //---- addBtn ----
            addBtn.setText("Add");
            addBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    addBtnMouseClicked(e);
                }
            });
            panel1.add(addBtn);
        }
        add(panel1);
        panel1.setBounds(560, 490, 175, 45);

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout());

            //---- uploadBtn ----
            uploadBtn.setText("Upload");
            uploadBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    uploadBtnMouseClicked(e);
                }
            });
            panel2.add(uploadBtn);
        }
        add(panel2);
        panel2.setBounds(595, 405, 100, 30);
        add(pathFileText);
        pathFileText.setBounds(545, 360, 240, 35);
        add(dateTextField);
        dateTextField.setBounds(545, 80, 205, dateTextField.getPreferredSize().height);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
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
    private JSpinner Open_Minute;
    private JSpinner Open_Second;
    private JSpinner Close_Second;
    private JSpinner Close_Minute;
    private JSpinner Close_Hour;
    private JLabel CloseTime;
    private JLabel Quantity;
    private JLabel Description;
    private JLabel Poster;
    private JTextField textName;
    private JTextField textArtist;
    private JTextField textQuantity;
    private JScrollPane scrollPane1;
    private JTextArea textDescription;
    private JLabel textPoster;
    private JLabel idText;
    private static JComboBox stageComboBox;
    private JPanel panel1;
    private JLabel addBtn;
    private JPanel panel2;
    private JLabel uploadBtn;
    private JTextField pathFileText;
    private JFormattedTextField dateTextField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
