package Controller;

import Model.BEAN.MenuList;
import View.AnalyticPage.AnalyticPanel;
import View.CustomerPage.ListPanel.InformationCustomerPanel;
import View.CustomersListPage.CustomersListPanel;
import View.EventPage.EventPanel;
import View.Home.HomePanel;
import View.PartnerPage.PartnerPanel;
import View.SettingPage.AccountPanel;
import View.StagesPage.StagesListPanel;
import View.TicketPage.TicketListPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class SwitchMenuController {
    private JPanel rootPanel;
    private String selectedKind = "";
    private List<MenuList> listItem = null;

    public SwitchMenuController() {
    }

    public SwitchMenuController(JPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        selectedKind = "HomePanel";

        rootPanel.removeAll();
        rootPanel.setLayout(new BorderLayout());
        rootPanel.add(new HomePanel());
        rootPanel.validate();
        rootPanel.repaint();
    }
    public void setEvent(List<MenuList> listItem) {
        this.listItem = listItem;
        for (MenuList item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(),item.getJlb()));
        }
    }

    public void SwitchView(JPanel informationCustomerPanel,  selectedKind) {
        rootPanel.removeAll();
        rootPanel.setLayout(new BorderLayout());
        rootPanel.add(new HomePanel());
        rootPanel.validate();
        rootPanel.repaint();
    }

    class LabelEvent implements MouseListener {
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;
        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jlbItem = jlbItem;
            this.jpnItem = jpnItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind) {
                case "HomePanel":
                    node = new HomePanel();
                    break;
                case "EventPanel":
                    node = new EventPanel();
                    break;
                case "CustomersPanel":
                    node = new CustomersListPanel().getCustomersListPage();
                    break;
                case "TicketPanel":
                    node = new TicketListPanel();
                    break;
                case "StagePanel":
                    node = new StagesListPanel();
                    break;
                case "PartnerPanel":
                    node = new PartnerPanel();
                    break;
                case "AnalyticPanel":
                    node = new AnalyticPanel();
                    break;
                default:
                    node = new AccountPanel();
                    break;
            }
            rootPanel.removeAll();
            rootPanel.setLayout(new BorderLayout());
            rootPanel.add(node);
            rootPanel.validate();
            rootPanel.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            selectedKind = kind;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(97,184,132));
            jlbItem.setForeground(new Color(255,255,255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!selectedKind.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(255, 255, 255));
                jlbItem.setForeground(new Color(97, 184, 132));
            }
        }
        private void setChangeBackground(String kind) {
            for (MenuList item : listItem) {
                if(item.getKind().equalsIgnoreCase(kind)) {
                    item.getJpn().setBackground(new Color(97,184,132));
                    item.getJlb().setForeground(new Color(255,255,255));
                } else {
                    item.getJpn().setBackground(new Color(255,255,255));
                    item.getJlb().setForeground(new Color(97,184,132));
                }
            }
        }

        private void SwitchView(JPanel view){ // Đổi màn chính giữa sang Jpanel khác
            kind = view.getName();
            rootPanel.removeAll();
            rootPanel.setLayout(new BorderLayout());
            rootPanel.add(node);
            rootPanel.validate();
            rootPanel.repaint();
            setChangeBackground(kind);
        }
    }
}
