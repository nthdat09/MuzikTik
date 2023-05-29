package Model.BEAN;

public class Ticket {
    private int ticketID;
    private int eventID;
    private double price;
    private int stageID;
    private int seatID;

    public Ticket() {
        super();
    }

    public Ticket(int ticketID, int eventID, double price, int stageID, int seatID) {
        this.ticketID = ticketID;
        this.eventID = eventID;
        this.price = price;
        this.stageID = stageID;
        this.seatID = seatID;
    }

    public static Ticket getInstance() {
        return new Ticket();
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStageID() {
        return stageID;
    }

    public void setStageID(int stageID) {
        this.stageID = stageID;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", eventID=" + eventID +
                ", price=" + price +
                ", stageID=" + stageID +
                ", seatID=" + seatID +
                '}';
    }

    public void toPrint(){
        System.out.println("Ticket{" +
                "ticketID=" + ticketID +
                ", eventID=" + eventID +
                ", price=" + price +
                ", stageID=" + stageID +
                ", seatID=" + seatID +
                '}');
    }
}
