package Controller;

import View.EventPage.EventPanel;
import View.Home.HomePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventListPanel implements MouseListener {
    private final HomePanel homePanel;

    public EventListPanel(HomePanel homePanel) {
        this.homePanel = homePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String src = homePanel.getEventName1().getText();
        System.out.print(src);
        this.homePanel.clickEventPanel(src);
    }
    @Override
    public void mousePressed(MouseEvent e) {
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
