package Model.BEAN;

public class TicketID {
    private Integer ticketID;
    private Integer seatID;
    private Integer eventID;
    public TicketID(Integer ticketID, Integer seatID, Integer eventID) {
        this.ticketID = ticketID;
        this.seatID = seatID;
        this.eventID = eventID;
    }
    public Integer getTicketID() {
        return ticketID;
    }
    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }
    public Integer getSeatID() {
        return seatID;
    }
    public void setSeatID(Integer seatID) {
        this.seatID = seatID;
    }
    public Integer getEventID() {
        return eventID;
    }
    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }
}
