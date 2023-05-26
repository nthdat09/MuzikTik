package Controller.TicketPage;

import View.TicketPage.TicketInformationForm;
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
        if (src.equals("ADD")){
            this.ticketListPanel.addTicket();
        } else if (src.equals("EDIT")){
            ticketListPanel.editTicket();
        } else if (src.equals("DELETE")){
            ticketListPanel.deleteTicket();
        } else if (src.equals("SEARCH")){
            try {
                ticketListPanel.searchTicket();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
