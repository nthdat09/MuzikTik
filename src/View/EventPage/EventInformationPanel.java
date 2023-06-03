/*
 * Created by JFormDesigner on Sat Jun 03 11:01:36 ICT 2023
 */

package View.EventPage;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.miginfocom.swing.*;

/**
 * @author quynh
 */
public class EventInformationPanel extends JPanel {
    public EventInformationPanel() {
        initComponents();
    }

    public JLabel getID() {
        return ID;
    }

    public JLabel getName() {
        return Name;
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
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
        TextID = new JTextField();
        textName = new JTextField();
        textArtist = new JTextField();
        textStage = new JTextField();
        textField4 = new JTextField();
        textQuantity = new JTextField();
        scrollPane1 = new JScrollPane();
        textDescription = new JTextArea();
        textPoster = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setFont(new Font("Lato Black", Font.BOLD, 16));
        setForeground(Color.darkGray);
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
        border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER
        ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font
        .BOLD,12),java.awt.Color.red), getBorder())); addPropertyChangeListener(
        new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order"
        .equals(e.getPropertyName()))throw new RuntimeException();}});
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
        Name.setBounds(new Rectangle(new Point(45, 80), Name.getPreferredSize()));

        //---- Artist ----
        Artist.setText("Artist");
        Artist.setFont(new Font("Lato Black", Font.BOLD, 16));
        Artist.setForeground(Color.darkGray);
        add(Artist);
        Artist.setBounds(new Rectangle(new Point(45, 120), Artist.getPreferredSize()));

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
        Date.setBounds(new Rectangle(new Point(445, 80), Date.getPreferredSize()));

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
        Quantity.setBounds(new Rectangle(new Point(445, 120), Quantity.getPreferredSize()));

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
        Poster.setBounds(new Rectangle(new Point(445, 165), Poster.getPreferredSize()));

        //---- TextID ----
        TextID.setForeground(Color.black);
        TextID.setBackground(new Color(0xb8cfe5));
        add(TextID);
        TextID.setBounds(180, 40, 205, TextID.getPreferredSize().height);
        add(textName);
        textName.setBounds(180, 80, 205, textName.getPreferredSize().height);
        add(textArtist);
        textArtist.setBounds(180, 120, 205, textArtist.getPreferredSize().height);
        add(textStage);
        textStage.setBounds(545, 40, 205, textStage.getPreferredSize().height);
        add(textField4);
        textField4.setBounds(545, 80, 205, textField4.getPreferredSize().height);
        add(textQuantity);
        textQuantity.setBounds(545, 120, 205, textQuantity.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textDescription);
        }
        add(scrollPane1);
        scrollPane1.setBounds(40, 300, 345, 180);

        //---- textPoster ----
        textPoster.setText("text");
        textPoster.setBorder(LineBorder.createBlackLineBorder());
        add(textPoster);
        textPoster.setBounds(445, 195, 155, 150);

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
    // Generated using JFormDesigner Evaluation license - Le Xuan Quynh
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
    private JTextField TextID;
    private JTextField textName;
    private JTextField textArtist;
    private JTextField textStage;
    private JTextField textField4;
    private JTextField textQuantity;
    private JScrollPane scrollPane1;
    private JTextArea textDescription;
    private JLabel textPoster;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
