package Controller;

import Model.CustomerList;
import Model.SpecificEvent;
import View.CustomerPanel.ListPanel.HistoryCustomerPanel;
import View.CustomerPanel.ListPanel.InformationCustomerPanel;
import View.EventPanel.SpecificEventPanel.InformationEvent;
import View.EventPanel.SpecificEventPanel.TicketFeesEvent;
import View.EventPanel.SpecificEventPanel.SeatEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
public class SpecificEventListener {
    private JPanel root;
    private String kindSelected = "";
    private List<SpecificEvent> listItem = null;

    public SpecificEventListener(JPanel jpnRoot) {
        this.root = jpnRoot;
    }


}
