package Controller.TicketPage;

import View.TicketPage.TicketInformationForm;

import java.awt.event.ActionListener;

public class TicketInformationController implements ActionListener{
    private final TicketInformationForm ticketInformationForm;

    public TicketInformationController(TicketInformationForm ticketInformationForm) {
        this.ticketInformationForm = ticketInformationForm;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("SAVE")){
            try {
                ticketInformationForm.saveTicket();
            }

            catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        else if (src.equals("CANCEL")){
            try {
                ticketInformationForm.cancelTicket();
            }

            catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
