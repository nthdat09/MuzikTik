/*package Controller;

import Model.Menu;
import View.mainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class SwitchScreen {
    private JPanel root;
    private String kindSelected = "";
    private List<Menu> ListItem = null;

    public SwitchScreen(JPanel jpn){
        this.root = jpn;
    }
    public void setView(JButton jbtItem){
        kindSelected = "Home";
        jbtItem.setBackground(Color.red);
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new mainMenu());
        root.validate();
        root.repaint();
    }*/

  /*  public void setEvent(List<Menu> listItem){
        this.ListItem = ListItem;
        for (Menu item : ListItem) {
            item.getJbt().addMouseListener(new LabelEvent(item.getKind(), item.getJbt()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        private JButton jbtItem;
        public LabelEvent(String kind, JButton jbtItem){
            this.kind = kind;
            this.jbtItem = jbtItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind){
                case "Home":
                    node = new mainMenu();
                    break;
                case "Customer":
                    node = new mainMenu();
                    break;
                default:
                    node = new mainMenu();
                    break;
            }

            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jbtItem.setBackground(Color.red);

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Hi");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jbtItem.setBackground(Color.red);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jbtItem.setBackground(Color.red);
            }
        }

        private void setChangeBackground (String kind){
            for (Menu item: ListItem){
                if (item.getKind().equalsIgnoreCase(kind)){
                    jbtItem.setBackground(Color.red);
                } else{
                    jbtItem.setBackground(Color.green);
                }
            }
        }
    }

}
*/