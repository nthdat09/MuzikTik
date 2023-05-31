package Controller.Menu;

import Model.BEAN.MenuList;
import View.AnalyticPage.AnalyticPanel;
import View.CustomersListPage.CustomersListPanel;
import View.EventPage.EventPanel;
import View.Home.HomePanel;
import View.PartnerPage.PartnerListPanel;
import View.SettingPage.AccountPanel;
import View.StagesPage.StagesListPanel;
import View.TicketPage.TicketListPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwitchMenuController {
    private JPanel rootPanel;
    private String selectedKind = "";
    private List<MenuList> listItem = null;
    private final Map<String, Class<? extends JPanel>> panelMap = new HashMap<>();

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SwitchMenuController() {
        initializePanelMap();
    }

    public SwitchMenuController(JPanel rootPanel) {
        this.rootPanel = rootPanel;
        initializePanelMap();
    }

    private void initializePanelMap() {
        panelMap.put("HomePanel", HomePanel.class);
        panelMap.put("EventPanel", EventPanel.class);
        panelMap.put("CustomersPanel", CustomersListPanel.class);
        panelMap.put("TicketPanel", TicketListPanel.class);
        panelMap.put("StagePanel", StagesListPanel.class);
        panelMap.put("PartnerPanel", PartnerListPanel.class);
        panelMap.put("AnalyticPanel", AnalyticPanel.class);
        panelMap.put("AccountPanel", AccountPanel.class);
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        selectedKind = "HomePanel";

        rootPanel.removeAll();
        rootPanel.setLayout(new BorderLayout());
        rootPanel.add(new HomePanel());
        rootPanel.validate();
        rootPanel.repaint();
    }

    public void changeViewController(JPanel jPanel, JLabel jlbItem, String kind) {
        selectedKind = kind;

        rootPanel.removeAll();
        rootPanel.setLayout(new BorderLayout());
        rootPanel.add(jPanel);
        rootPanel.validate();
        rootPanel.repaint();
    }

    public void setEvent(List<MenuList> listItem) {
        this.listItem = listItem;
        for (MenuList item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {
        private JPanel jpnItem;
        private JLabel jlbItem;
        private String kind;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jlbItem = jlbItem;
            this.jpnItem = jpnItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(kind);
            Class<? extends JPanel> panelClass = panelMap.get(kind);
            if (panelClass != null) {
                JPanel node;
                try {
                    node = panelClass.getDeclaredConstructor().newInstance();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return;
                }
                rootPanel.removeAll();
                rootPanel.setLayout(new BorderLayout());
                rootPanel.add(node);
                rootPanel.validate();
                rootPanel.repaint();
                setChangeBackground(kind);
            }
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
            jpnItem.setBackground(new Color(97, 184, 132));
            jlbItem.setForeground(new Color(255, 255, 255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!selectedKind.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(255, 255, 255));
                jlbItem.setForeground(new Color(97, 184, 132));
            }
        }

        private void setChangeBackground(String kind) {
            for (MenuList item : listItem) {
                if (item.getKind().equalsIgnoreCase(kind)) {
                    item.getJpn().setBackground(new Color(97, 184, 132));
                    item.getJlb().setForeground(new Color(255, 255, 255));
                } else {
                    item.getJpn().setBackground(new Color(255, 255, 255));
                    item.getJlb().setForeground(new Color(97, 184, 132));
                }
            }
        }
    }
}
