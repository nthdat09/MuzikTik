/*
 * Created by JFormDesigner on Thu Apr 27 12:08:53 ICT 2023
 */

package View.Home;

import java.awt.event.*;
import View.MainPage.MainPage;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author ADMIN
 */
public class HomePanel extends JPanel {
    public HomePanel() {
        initComponents();
        show(position);
        slideDot1.setSelected(true);
    }

    int position = 0;
    int index = 0;
    int time =0;
    public String[] takeImage() {
        File f = new File(getClass().getResource("/Image").getFile());
        System.out.println(f);
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
    private void radioButton1MouseClicked(MouseEvent e) {
        slideDot2.setSelected(false);
        slideDot3.setSelected(false);
        slideDot4.setSelected(false);
        slideDot5.setSelected(false);
        slideDot6.setSelected(false);
        show(0);
        index = 0;
        position = 0;
    }

    private void radioButton2MouseClicked(MouseEvent e) {
        slideDot1.setSelected(false);
        slideDot3.setSelected(false);
        slideDot4.setSelected(false);
        slideDot5.setSelected(false);
        slideDot6.setSelected(false);
        show(1);
        index = 1;
        position = 1;
    }

    private void radioButton3MouseClicked(MouseEvent e) {
        slideDot1.setSelected(false);
        slideDot2.setSelected(false);
        slideDot4.setSelected(false);
        slideDot5.setSelected(false);
        slideDot6.setSelected(false);
        show(2);
        index = 2;
        position = 2;
    }

    private void radioButton4MouseClicked(MouseEvent e) {
        slideDot1.setSelected(false);
        slideDot2.setSelected(false);
        slideDot3.setSelected(false);
        slideDot5.setSelected(false);
        slideDot6.setSelected(false);
        show(3);
        index = 3;
        position = 3;
    }

    private void radioButton5MouseClicked(MouseEvent e) {
        slideDot1.setSelected(false);
        slideDot2.setSelected(false);
        slideDot3.setSelected(false);
        slideDot4.setSelected(false);
        slideDot6.setSelected(false);
        show(4);
        index = 4;
        position = 4;
    }

    private void radioButton6MouseClicked(MouseEvent e) {
        slideDot1.setSelected(false);
        slideDot2.setSelected(false);
        slideDot3.setSelected(false);
        slideDot4.setSelected(false);
        slideDot5.setSelected(false);
        show(5);
        index = 5;
        position = 5;
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
        position=position-1;
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

        if(index > 0) {
            slideDots.get(index).setSelected(false);
            slideDots.get(index-1).setSelected(true);
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
        evetntPicture3 = new JLabel();
        evetntPicture1 = new JLabel();
        evetntPicture2 = new JLabel();
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
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );

        //======== mainScrollPanel ========
        {

            //======== panel2 ========
            {
                panel2.setBackground(Color.white);

                //---- mainLabel ----
                mainLabel.setText("Let Make Live Happen");
                mainLabel.setFont(new Font("Lato Black", Font.BOLD, 30));
                mainLabel.setForeground(new Color(0x61b884));

                //---- mainLivePicture ----
                mainLivePicture.setText("text");
                mainLivePicture.setBorder(LineBorder.createBlackLineBorder());

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

                //---- evetntPicture3 ----
                evetntPicture3.setText("text");
                evetntPicture3.setBorder(LineBorder.createBlackLineBorder());

                //---- evetntPicture1 ----
                evetntPicture1.setText("text");
                evetntPicture1.setBorder(LineBorder.createBlackLineBorder());

                //---- evetntPicture2 ----
                evetntPicture2.setText("text");
                evetntPicture2.setBorder(LineBorder.createBlackLineBorder());

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
                evetntPicture4.setText("text");
                evetntPicture4.setBorder(LineBorder.createBlackLineBorder());

                //---- evetntPicture5 ----
                evetntPicture5.setText("text");
                evetntPicture5.setBorder(LineBorder.createBlackLineBorder());

                //---- evetntPicture6 ----
                evetntPicture6.setText("text");
                evetntPicture6.setBorder(LineBorder.createBlackLineBorder());

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
                evetntPicture7.setText("text");
                evetntPicture7.setBorder(LineBorder.createBlackLineBorder());

                //---- evetntPicture8 ----
                evetntPicture8.setText("text");
                evetntPicture8.setBorder(LineBorder.createBlackLineBorder());

                //---- evetntPicture9 ----
                evetntPicture9.setText("text");
                evetntPicture9.setBorder(LineBorder.createBlackLineBorder());

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
                slideDot1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton1MouseClicked(e);
                    }
                });

                //---- slideDot2 ----
                slideDot2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton2MouseClicked(e);
                    }
                });

                //---- slideDot3 ----
                slideDot3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton3MouseClicked(e);
                    }
                });

                //---- slideDot4 ----
                slideDot4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton4MouseClicked(e);
                    }
                });

                //---- slideDot5 ----
                slideDot5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton5MouseClicked(e);
                    }
                });

                //---- slideDot6 ----
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
                                    .addComponent(evetntPicture1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(evetntPicture2, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                        .addGap(104, 104, 104)
                                        .addComponent(evetntPicture3, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(404, 404, 404)
                                        .addGroup(panel2Layout.createParallelGroup()
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
                                                .addComponent(slideDot6))
                                            .addComponent(eventLabel))))
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
                                        .addComponent(eventDate9))))
                            .addContainerGap(581, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mainLivePicture, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addGap(538, 538, 538))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(mainLabel)
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(38, 38, 38)
                                            .addComponent(mainLivePicture, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addGap(111, 111, 111)
                                            .addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(195, 195, 195)
                                    .addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(slideDot1)
                                .addComponent(slideDot2)
                                .addComponent(slideDot3)
                                .addComponent(slideDot4)
                                .addComponent(slideDot5)
                                .addComponent(slideDot6))
                            .addGap(73, 73, 73)
                            .addComponent(eventLabel)
                            .addGap(42, 42, 42)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(evetntPicture1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(evetntPicture3, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(evetntPicture2, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
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
                            .addContainerGap(656, Short.MAX_VALUE))
                );
            }
            mainScrollPanel.setViewportView(panel2);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(mainScrollPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1135, Short.MAX_VALUE)
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
    private JLabel evetntPicture3;
    private JLabel evetntPicture1;
    private JLabel evetntPicture2;
    private JLabel eventName1;
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
