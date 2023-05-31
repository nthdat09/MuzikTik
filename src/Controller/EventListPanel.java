package Controller;

import View.EventPage.EventPanel;
import View.Home.HomePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventListPanel implements MouseListener {
    private final HomePanel homePanel;
    private int selectedEventHandle;

    public EventListPanel(HomePanel homePanel,int selectedEventHandle) {
        this.homePanel = homePanel;
        this.selectedEventHandle = selectedEventHandle;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch(selectedEventHandle) {
            case 1:
                String src = homePanel.getEventName1().getText();
                this.homePanel.clickEventPanel(src);
                break;
            case 2:
                String src2 = homePanel.getEventName2().getText();
                this.homePanel.clickEventPanel(src2);
                break;
            case 3:
                String src3 = homePanel.getEventName3().getText();
                this.homePanel.clickEventPanel(src3);
                break;
            case 4:
                String src4 = homePanel.getEventName4().getText();
                this.homePanel.clickEventPanel(src4);
                break;
            case 5:
                String src5 = homePanel.getEventName5().getText();
                this.homePanel.clickEventPanel(src5);
                break;
            case 6:
                String src6 = homePanel.getEventName6().getText();
                this.homePanel.clickEventPanel(src6);
                break;
            case 7:
                String src7 = homePanel.getEventName7().getText();
                this.homePanel.clickEventPanel(src7);
                break;
            case 8:
                String src8 = homePanel.getEventName8().getText();
                this.homePanel.clickEventPanel(src8);
                break;
            case 9:
                String src9 = homePanel.getEventName9().getText();
                this.homePanel.clickEventPanel(src9);
                break;
        }
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
