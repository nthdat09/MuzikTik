package Model.BEAN;

import javax.swing.*;

public class EventList {
    private ImageIcon eventPicture;
    private String eventName;
    private String eventDate;
    public EventList(ImageIcon eventPicture, String eventName, String eventDate) {
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

    public ImageIcon getEventPicture() {
        return eventPicture;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventPicture(ImageIcon eventPicture) {
        this.eventPicture = eventPicture;
    }

}
