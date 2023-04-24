package View.customerPanel.controller;


import View.customerPanel.listPanel.historyCustomerPanel;
import View.customerPanel.listPanel.informationCustomerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class controllerCustomerPanel {
    private JPanel root;
    private String kindSelected = "";
    private List<customerList> listItem = null;

    public controllerCustomerPanel(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView (JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "informationCustomer";

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new informationCustomerPanel());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<customerList> listItem) {
        this.listItem = listItem;

        for (customerList item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jlbItem = jlbItem;
            this.jpnItem = jpnItem;
        }
        public LabelEvent() {}
        public void setKind(String kind) {
            this.kind = kind;
        }
        public void setJpnItem(JPanel jpnItem) {
            this.jpnItem = jpnItem;
        }
        public void setJlbItem(JLabel jlbItem) {
            this.jlbItem = jlbItem;
        }
        public String getKind() {
            return kind;
        }
        public JPanel getJpnItem() {
            return jpnItem;
        }
        public JLabel getJlbItem() {
            return jlbItem;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind) {
                case "historyCustomer":
                    node = new historyCustomerPanel();
                    break;
                default:
                    node = new informationCustomerPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
