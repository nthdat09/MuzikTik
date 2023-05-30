/*
 * Created by JFormDesigner on Thu Apr 27 12:08:53 ICT 2023
 */

package View.Home;

import java.awt.event.*;

import Controller.EventListPanel;
import Controller.SwitchMenuController;
import Model.BEAN.*;
import Model.DAO.Event.Event;
import Model.DAO.Event.EventInformation.EventArtID;
import Model.DAO.Event.EventInformation.EventInformation;
import Model.DAO.Event.EventInformation.StageInformation;
import View.EventPage.EventPanel;
import View.MainPage.MainPage;
import Model.DAO.Event.EventInformation.EventInformation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author ADMIN
 */
public class HomePanel extends JPanel {
    static Integer selectedEventID;
    static String selectedEvent;
    static Integer selectedStage;
    MouseListener ac1 = new EventListPanel(this);
    MouseListener ac2 = new EventListPanel(this);
    MouseListener ac3 = new EventListPanel(this);
    MouseListener ac4 = new EventListPanel(this);
    MouseListener ac5 = new EventListPanel(this);
    MouseListener ac6 = new EventListPanel(this);
    MouseListener ac7 = new EventListPanel(this);
    MouseListener ac8 = new EventListPanel(this);
    MouseListener ac9 = new EventListPanel(this);
    List<EventArtID> eventArt = null;
    List<EventInformation> eventInformationList= null;
    List<StageInformation> eventStageInformation = null;
    List<EventList> listEvent = null;
    ArrayList<JLabel> listLabelPicture = new ArrayList<JLabel>();
    ArrayList<JLabel> listLabelName = new ArrayList<JLabel>();
    ArrayList<JLabel> listLabelDate = new ArrayList<JLabel>();

    public HomePanel() {
        initComponents();
        initMoreSetting();
        initEventHandler();
    }

    public void initEventHandler() {
        eventPicture1.addMouseListener(ac1);
        eventPicture2.addMouseListener(ac2);
        eventPicture3.addMouseListener(ac3);
        evetntPicture4.addMouseListener(ac4);
        evetntPicture5.addMouseListener(ac5);
        evetntPicture6.addMouseListener(ac6);
        evetntPicture7.addMouseListener(ac7);
        evetntPicture8.addMouseListener(ac8);
        evetntPicture9.addMouseListener(ac9);
    }

    public void initMoreSetting() {
        show(position);
        slideDot1.setSelected(true);
        mainScrollPanel.getVerticalScrollBar().setUnitIncrement(19);
        addListPicture();
        addLabelName();
        addLabelDate();
        listEvent = Event.getEventList();
        setEventList();
    }
    public void addListPicture() {
        listLabelPicture.add(eventPicture1);
        listLabelPicture.add(eventPicture2);
        listLabelPicture.add(eventPicture3);
        listLabelPicture.add(evetntPicture4);
        listLabelPicture.add(evetntPicture5);
        listLabelPicture.add(evetntPicture6);
        listLabelPicture.add(evetntPicture7);
        listLabelPicture.add(evetntPicture8);
        listLabelPicture.add(evetntPicture9);
    }
    public void addLabelName() {
        listLabelName.add(eventName1);
        listLabelName.add(eventName2);
        listLabelName.add(eventName3);
        listLabelName.add(eventName4);
        listLabelName.add(eventName5);
        listLabelName.add(eventName6);
        listLabelName.add(eventName7);
        listLabelName.add(eventName8);
        listLabelName.add(eventName9);
    }
    public void addLabelDate() {
        listLabelDate.add(eventDate1);
        listLabelDate.add(eventDate2);
        listLabelDate.add(eventDate3);
        listLabelDate.add(eventDate4);
        listLabelDate.add(eventDate5);
        listLabelDate.add(eventDate6);
        listLabelDate.add(eventDate7);
        listLabelDate.add(eventDate8);
        listLabelDate.add(eventDate9);
    }

    public void setEventList() {
        for (int i = 0; i < listEvent.size(); i++) {
            String eventPicture = listEvent.get(i).getEventPicture();
            String eventName = listEvent.get(i).getEventName();
            String eventDate = listEvent.get(i).getEventDate();

            ImageIcon icon = new ImageIcon(getClass().getResource("/Image/" + eventPicture));;
            listLabelPicture.get(i).setIcon(icon);
            listLabelName.get(i).setText(eventName);
            listLabelDate.get(i).setText(eventDate);
        }
    }

    int position = 0;
    int index = 0;
    public String[] takeImage() {
        File f = new File(getClass().getResource("/Image").getFile());
        String[] Images = f.list();
        return Images;
    }

    public void show(int i) {
        String[] Images = takeImage();
        String img = Images[i];
        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/" + img));
        Image image = icon.getImage().getScaledInstance(796, 262, Image.SCALE_SMOOTH);
        mainLivePicture.setIcon(new ImageIcon(image));
    }

    public void clickEventPanel(String src) {
        setSelectedEvent(src);
        MainPage.changeView(new EventPanel(), MainPage.getJlbEvent(), "EventPanel");
        eventInformationList = EventInformationList.getEventInformationList();
        eventSetting();
        eventStageInformation = GetStageName.getStageInformationList();
        stageSetting();
        eventArt = GetArt.getArtByID();
        pictureArtSetting();
    }
    public void eventSetting() {
        for(EventInformation eventInformation : eventInformationList) {
            EventPanel.getEventName().setText(eventInformation.getEventName());
            String fomattedString = localDateToString(eventInformation.getEventDate());
            EventPanel.getEventTime().setText(fomattedString);
            setSelectedStage(eventInformation.getEventStageID());
            EventPanel.getDescriptionText().setText(eventInformation.getEventDescription());
            setSelectedEventID(eventInformation.getEventID());
        }
    }
    public void pictureArtSetting() {
        for(EventArtID art : eventArt) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Image/" + art.getEventArtID()));;
            EventPanel.getEventArt().setIcon(icon);
        }
    }
    public void stageSetting() {
        for(StageInformation stage : eventStageInformation) {
            EventPanel.getEventPlace().setText(stage.getStageName());
        }
    }
    public String localDateToString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedString = localDate.format(formatter);

        return formattedString;
    }
    public void setSelectedEventID(Integer eventID) {
        selectedEventID = eventID;
    }
    public static Integer getSelectedEventID() {
        return selectedEventID;
    }
    public void setSelectedEvent(String src) {
        selectedEvent = src;
    }
    public static String getSelectedEvent() {
        return selectedEvent;
    }
    public void setSelectedStage(Integer stageID) {
        selectedStage = stageID;
    }
    public static Integer getSelectedStage() {
        return selectedStage;
    }
    private void radioButton1MouseClicked(MouseEvent e) {
        if(slideDot1.isSelected()) {
            slideDot2.setSelected(false);
            slideDot3.setSelected(false);
            slideDot4.setSelected(false);
            slideDot5.setSelected(false);
            slideDot6.setSelected(false);
            show(0);
            index = 0;
            position = 0;
        }
    }

    private void radioButton2MouseClicked(MouseEvent e) {
        if(slideDot2.isSelected()) {
            slideDot1.setSelected(false);
            slideDot3.setSelected(false);
            slideDot4.setSelected(false);
            slideDot5.setSelected(false);
            slideDot6.setSelected(false);
            show(1);
            index = 1;
            position = 1;
        }
    }

    private void radioButton3MouseClicked(MouseEvent e) {
        if(slideDot3.isSelected()) {
            slideDot1.setSelected(false);
            slideDot2.setSelected(false);
            slideDot4.setSelected(false);
            slideDot5.setSelected(false);
            slideDot6.setSelected(false);
            show(2);
            index = 2;
            position = 2;
        }
    }

    private void radioButton4MouseClicked(MouseEvent e) {
        if(slideDot4.isSelected()) {
            slideDot1.setSelected(false);
            slideDot2.setSelected(false);
            slideDot3.setSelected(false);
            slideDot5.setSelected(false);
            slideDot6.setSelected(false);
            show(3);
            index = 3;
            position = 3;
        }
    }

    private void radioButton5MouseClicked(MouseEvent e) {
        if(slideDot5.isSelected()) {
            slideDot1.setSelected(false);
            slideDot2.setSelected(false);
            slideDot3.setSelected(false);
            slideDot4.setSelected(false);
            slideDot6.setSelected(false);
            show(4);
            index = 4;
            position = 4;
        }
    }

    private void radioButton6MouseClicked(MouseEvent e) {
        if(slideDot6.isSelected()) {
            slideDot1.setSelected(false);
            slideDot2.setSelected(false);
            slideDot3.setSelected(false);
            slideDot4.setSelected(false);
            slideDot5.setSelected(false);
            show(5);
            index = 5;
            position = 5;
        }
    }

    private void previousButtonMouseClicked(MouseEvent e) {
        new Thread();
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        int p = this.mainLivePicture.getX();
        if(p>-1) {
            Animacion.Animacion.mover_izquierda(200, 900, 1, 2, mainLivePicture);
        }
        if(position > 0) {
            position = position - 1;
        }
        if (position>=takeImage().length) {
            position = takeImage().length+1;
        }
        show(position);
        ArrayList<JRadioButton> slideDots = new ArrayList<>();
        slideDots.add(slideDot1);
        slideDots.add(slideDot2);
        slideDots.add(slideDot3);
        slideDots.add(slideDot4);
        slideDots.add(slideDot5);
        slideDots.add(slideDot6);

        if (index > 0) {
            slideDots.get(index).setSelected(false);
            slideDots.get(index - 1).setSelected(true);
            index = index - 1;
        }
    }

    private void nextButtonMouseClicked(MouseEvent e) {
        new Thread();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(HomePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        int p = this.mainLivePicture.getX();
        if(p>-1) {
            Animacion.Animacion.mover_izquierda(200, 900, 1, 2, mainLivePicture);
        }
        position=position+1;
        if (position>=takeImage().length) {
            position = takeImage().length-1;
        }
        show(position);
        ArrayList<JRadioButton> slideDots = new ArrayList<>();
        slideDots.add(slideDot1);
        slideDots.add(slideDot2);
        slideDots.add(slideDot3);
        slideDots.add(slideDot4);
        slideDots.add(slideDot5);
        slideDots.add(slideDot6);

        if(index < 5) {
            slideDots.get(index+1).setSelected(true);
            slideDots.get(index).setSelected(false);
            index = index + 1;
        }
    }

    public static JLabel getEventName1() {
        return eventName1;
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Man
        mainScrollPanel = new JScrollPane();
        panel2 = new JPanel();
        mainLabel = new JLabel();
        mainLivePicture = new JLabel();
        previousButton = new JLabel();
        nextButton = new JLabel();
        eventLabel = new JLabel();
        eventPicture3 = new JLabel();
        eventPicture1 = new JLabel();
        eventPicture2 = new JLabel();
        eventName1 = new JLabel();
        eventName2 = new JLabel();
        eventDate2 = new JLabel();
        eventDate1 = new JLabel();
        eventName3 = new JLabel();
        eventDate3 = new JLabel();
        evetntPicture4 = new JLabel();
        evetntPicture5 = new JLabel();
        evetntPicture6 = new JLabel();
        eventName6 = new JLabel();
        eventDate6 = new JLabel();
        eventDate5 = new JLabel();
        eventName5 = new JLabel();
        eventName4 = new JLabel();
        eventDate4 = new JLabel();
        evetntPicture7 = new JLabel();
        evetntPicture8 = new JLabel();
        evetntPicture9 = new JLabel();
        eventName9 = new JLabel();
        eventDate9 = new JLabel();
        eventDate8 = new JLabel();
        eventName8 = new JLabel();
        eventName7 = new JLabel();
        eventDate7 = new JLabel();
        slideDot1 = new JRadioButton();
        slideDot2 = new JRadioButton();
        slideDot3 = new JRadioButton();
        slideDot4 = new JRadioButton();
        slideDot5 = new JRadioButton();
        slideDot6 = new JRadioButton();

        //======== this ========
        setBackground(Color.white);
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
        .swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing
        .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
        Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red
        ), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
        public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName(
        )))throw new RuntimeException();}});

        //======== mainScrollPanel ========
        {
            mainScrollPanel.setBorder(null);

            //======== panel2 ========
            {
                panel2.setBackground(Color.white);

                //---- mainLabel ----
                mainLabel.setText("Let Make Live Happen");
                mainLabel.setFont(new Font("Lato Black", Font.BOLD, 30));
                mainLabel.setForeground(new Color(0x61b884));

                //---- mainLivePicture ----
                mainLivePicture.setBorder(null);

                //---- previousButton ----
                previousButton.setIcon(null);
                previousButton.setText("previous");
                previousButton.setForeground(Color.black);
                previousButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        previousButtonMouseClicked(e);
                    }
                });

                //---- nextButton ----
                nextButton.setIcon(null);
                nextButton.setForeground(Color.black);
                nextButton.setText("Next");
                nextButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        nextButtonMouseClicked(e);
                    }
                });

                //---- eventLabel ----
                eventLabel.setText("HIGHLIGHT EVENT");
                eventLabel.setFont(new Font("Lato Black", Font.BOLD, 28));
                eventLabel.setForeground(new Color(0x61b884));

                //---- eventPicture3 ----
                eventPicture3.setBorder(null);

                //---- eventPicture1 ----
                eventPicture1.setBorder(null);

                //---- eventPicture2 ----
                eventPicture2.setBorder(null);

                //---- eventName1 ----
                eventName1.setText("Event Name");
                eventName1.setFont(new Font("Lato Black", Font.BOLD, 20));
                eventName1.setForeground(new Color(0x61b884));

                //---- eventName2 ----
                eventName2.setText("Event Name");
                eventName2.setFont(new Font("Lato Black", Font.BOLD, 20));
                eventName2.setForeground(new Color(0x61b884));

                //---- eventDate2 ----
                eventDate2.setText("Date");
                eventDate2.setFont(new Font("Lato", Font.PLAIN, 18));
                eventDate2.setForeground(new Color(0x61b884));

                //---- eventDate1 ----
                eventDate1.setText("Date");
                eventDate1.setFont(new Font("Lato", Font.PLAIN, 18));
                eventDate1.setForeground(new Color(0x61b884));

                //---- eventName3 ----
                eventName3.setText("Event Name");
                eventName3.setFont(new Font("Lato Black", Font.BOLD, 20));
                eventName3.setForeground(new Color(0x61b884));

                //---- eventDate3 ----
                eventDate3.setText("Date");
                eventDate3.setFont(new Font("Lato", Font.PLAIN, 18));
                eventDate3.setForeground(new Color(0x61b884));

                //---- evetntPicture4 ----
                evetntPicture4.setBorder(null);

                //---- evetntPicture5 ----
                evetntPicture5.setBorder(null);

                //---- evetntPicture6 ----
                evetntPicture6.setBorder(null);

                //---- eventName6 ----
                eventName6.setText("Event Name");
                eventName6.setFont(eventName6.getFont().deriveFont(eventName6.getFont().getSize() + 7f));

                //---- eventDate6 ----
                eventDate6.setText("Date");
                eventDate6.setFont(eventDate6.getFont().deriveFont(eventDate6.getFont().getSize() + 7f));

                //---- eventDate5 ----
                eventDate5.setText("Date");
                eventDate5.setFont(eventDate5.getFont().deriveFont(eventDate5.getFont().getSize() + 7f));

                //---- eventName5 ----
                eventName5.setText("Event Name");
                eventName5.setFont(eventName5.getFont().deriveFont(eventName5.getFont().getSize() + 7f));

                //---- eventName4 ----
                eventName4.setText("Event Name");
                eventName4.setFont(eventName4.getFont().deriveFont(eventName4.getFont().getSize() + 7f));

                //---- eventDate4 ----
                eventDate4.setText("Date");
                eventDate4.setFont(eventDate4.getFont().deriveFont(eventDate4.getFont().getSize() + 7f));

                //---- evetntPicture7 ----
                evetntPicture7.setBorder(null);

                //---- evetntPicture8 ----
                evetntPicture8.setBorder(null);

                //---- evetntPicture9 ----
                evetntPicture9.setBorder(null);

                //---- eventName9 ----
                eventName9.setText("Event Name");
                eventName9.setFont(eventName9.getFont().deriveFont(eventName9.getFont().getSize() + 7f));

                //---- eventDate9 ----
                eventDate9.setText("Date");
                eventDate9.setFont(eventDate9.getFont().deriveFont(eventDate9.getFont().getSize() + 7f));

                //---- eventDate8 ----
                eventDate8.setText("Date");
                eventDate8.setFont(eventDate8.getFont().deriveFont(eventDate8.getFont().getSize() + 7f));

                //---- eventName8 ----
                eventName8.setText("Event Name");
                eventName8.setFont(eventName8.getFont().deriveFont(eventName8.getFont().getSize() + 7f));

                //---- eventName7 ----
                eventName7.setText("Event Name");
                eventName7.setFont(eventName7.getFont().deriveFont(eventName7.getFont().getSize() + 7f));

                //---- eventDate7 ----
                eventDate7.setText("Date");
                eventDate7.setFont(eventDate7.getFont().deriveFont(eventDate7.getFont().getSize() + 7f));

                //---- slideDot1 ----
                slideDot1.setBackground(Color.white);
                slideDot1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton1MouseClicked(e);
                    }
                });

                //---- slideDot2 ----
                slideDot2.setBackground(Color.white);
                slideDot2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton2MouseClicked(e);
                    }
                });

                //---- slideDot3 ----
                slideDot3.setBackground(Color.white);
                slideDot3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton3MouseClicked(e);
                    }
                });

                //---- slideDot4 ----
                slideDot4.setBackground(Color.white);
                slideDot4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton4MouseClicked(e);
                    }
                });

                //---- slideDot5 ----
                slideDot5.setBackground(Color.white);
                slideDot5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton5MouseClicked(e);
                    }
                });

                //---- slideDot6 ----
                slideDot6.setBackground(Color.white);
                slideDot6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton6MouseClicked(e);
                    }
                });

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(434, 434, 434)
                            .addComponent(mainLabel)
                            .addGap(0, 899, Short.MAX_VALUE))
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(eventName1)
                                        .addGap(274, 274, 274)
                                        .addComponent(eventName2)
                                        .addGap(253, 253, 253)
                                        .addComponent(eventName3))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(eventDate1)
                                        .addGap(340, 340, 340)
                                        .addComponent(eventDate2)
                                        .addGap(333, 333, 333)
                                        .addComponent(eventDate3))
                                    .addComponent(eventPicture1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(evetntPicture4, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                        .addGap(109, 109, 109)
                                        .addComponent(evetntPicture5, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                        .addGap(104, 104, 104)
                                        .addComponent(evetntPicture6, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(eventName4)
                                        .addGap(281, 281, 281)
                                        .addComponent(eventName5)
                                        .addGap(266, 266, 266)
                                        .addComponent(eventName6))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(eventDate4)
                                        .addGap(340, 340, 340)
                                        .addComponent(eventDate5)
                                        .addGap(326, 326, 326)
                                        .addComponent(eventDate6))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(369, 369, 369)
                                        .addComponent(eventPicture2, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                        .addGap(104, 104, 104)
                                        .addComponent(eventPicture3, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(404, 404, 404)
                                        .addGroup(panel2Layout.createParallelGroup()
                                            .addComponent(eventLabel)
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                .addComponent(slideDot1)
                                                .addGap(18, 18, 18)
                                                .addComponent(slideDot2)
                                                .addGap(18, 18, 18)
                                                .addComponent(slideDot3)
                                                .addGap(18, 18, 18)
                                                .addComponent(slideDot4)
                                                .addGap(18, 18, 18)
                                                .addComponent(slideDot5)
                                                .addGap(18, 18, 18)
                                                .addComponent(slideDot6)))))
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(evetntPicture7, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                        .addGap(109, 109, 109)
                                        .addComponent(evetntPicture8, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                        .addGap(104, 104, 104)
                                        .addComponent(evetntPicture9, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(eventName7)
                                        .addGap(281, 281, 281)
                                        .addComponent(eventName8)
                                        .addGap(266, 266, 266)
                                        .addComponent(eventName9))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(eventDate7)
                                        .addGap(340, 340, 340)
                                        .addComponent(eventDate8)
                                        .addGap(326, 326, 326)
                                        .addComponent(eventDate9)))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                    .addGap(70, 70, 70)
                                    .addComponent(mainLivePicture, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62)
                                    .addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(581, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(mainLabel)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(154, 154, 154)
                                    .addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(148, 148, 148)
                                    .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(75, 75, 75)
                                    .addComponent(mainLivePicture, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)))
                            .addGap(27, 27, 27)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(slideDot1)
                                .addComponent(slideDot2)
                                .addComponent(slideDot3)
                                .addComponent(slideDot4)
                                .addComponent(slideDot5)
                                .addComponent(slideDot6))
                            .addGap(200, 200, 200)
                            .addComponent(eventLabel)
                            .addGap(42, 42, 42)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(eventPicture1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(eventPicture3, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eventPicture2, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(eventName3)
                                    .addGap(18, 18, 18)
                                    .addComponent(eventDate3))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(eventName1)
                                        .addComponent(eventName2))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(eventDate1)
                                        .addComponent(eventDate2))))
                            .addGap(175, 175, 175)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(evetntPicture4, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                .addComponent(evetntPicture5, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                .addComponent(evetntPicture6, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                            .addGap(16, 16, 16)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(eventName4)
                                .addComponent(eventName5)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(eventName6)))
                            .addGap(16, 16, 16)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(eventDate4)
                                .addComponent(eventDate5)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(eventDate6)))
                            .addGap(179, 179, 179)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(evetntPicture7, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                .addComponent(evetntPicture8, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                .addComponent(evetntPicture9, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                            .addGap(16, 16, 16)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(eventName7)
                                .addComponent(eventName8)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(eventName9)))
                            .addGap(16, 16, 16)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(eventDate7)
                                .addComponent(eventDate8)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(eventDate9)))
                            .addContainerGap(471, Short.MAX_VALUE))
                );
            }
            mainScrollPanel.setViewportView(panel2);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(mainScrollPanel, GroupLayout.PREFERRED_SIZE, 1250, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(mainScrollPanel, GroupLayout.PREFERRED_SIZE, 911, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2239, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Man
    private JScrollPane mainScrollPanel;
    private JPanel panel2;
    private JLabel mainLabel;
    private JLabel mainLivePicture;
    private JLabel previousButton;
    private JLabel nextButton;
    private JLabel eventLabel;
    private JLabel eventPicture3;
    private JLabel eventPicture1;
    private JLabel eventPicture2;
    private static JLabel eventName1;
    private JLabel eventName2;
    private JLabel eventDate2;
    private JLabel eventDate1;
    private JLabel eventName3;
    private JLabel eventDate3;
    private JLabel evetntPicture4;
    private JLabel evetntPicture5;
    private JLabel evetntPicture6;
    private JLabel eventName6;
    private JLabel eventDate6;
    private JLabel eventDate5;
    private JLabel eventName5;
    private JLabel eventName4;
    private JLabel eventDate4;
    private JLabel evetntPicture7;
    private JLabel evetntPicture8;
    private JLabel evetntPicture9;
    private JLabel eventName9;
    private JLabel eventDate9;
    private JLabel eventDate8;
    private JLabel eventName8;
    private JLabel eventName7;
    private JLabel eventDate7;
    private JRadioButton slideDot1;
    private JRadioButton slideDot2;
    private JRadioButton slideDot3;
    private JRadioButton slideDot4;
    private JRadioButton slideDot5;
    private JRadioButton slideDot6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
