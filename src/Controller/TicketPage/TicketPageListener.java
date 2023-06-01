package Controller.TicketPage;

import View.TicketPage.TicketListPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TicketPageListener implements ActionListener {
    private final TicketListPanel ticketListPanel;

    public TicketPageListener(TicketListPanel ticketListPanel) {
        this.ticketListPanel = ticketListPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        System.out.println(src);
        switch (src) {
            case "ADD" -> this.ticketListPanel.addTicket();
            case "EDIT" -> ticketListPanel.editTicket();
            case "DELETE" -> ticketListPanel.deleteTicket();
            case "SEARCH" -> {
                try {
                    ticketListPanel.searchTicket();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

    }
}
