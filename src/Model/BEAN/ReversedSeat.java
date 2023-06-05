package Model.BEAN;

public class ReversedSeat {
    private String eventID;
    private String stageID;
    public ReversedSeat(String eventID, String stageID) {
        this.eventID = eventID;
        this.stageID = stageID;
    }
    public String getEventID() {
        return eventID;
    }
    public void setEventID(String eventID) {
        this.eventID = eventID;
    }
    public String getStageID() {
        return stageID;
    }
    public void setStageID(String stageID) {
        this.stageID = stageID;
    }
}
