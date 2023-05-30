package Model.BEAN;

public class EventList {
    private String eventPicture;
    private String eventName;
    private String eventDate;
    public EventList(String eventPicture,String eventName, String eventDate) {
        super();
        this.eventPicture = eventPicture;
        this.eventName = eventName;
        this.eventDate = eventDate;
    }
    public String getEventDate() {
        return eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventPicture() {
        return eventPicture;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventPicture(String eventPicture) {
        this.eventPicture = eventPicture;
    }

}
