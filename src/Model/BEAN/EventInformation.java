package Model.BEAN;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventInformation {
    private Integer eventID;
    private String eventName;
    private Integer eventStageID;
    private String eventArtist;
    private LocalDate eventDate;
    private LocalTime eventOpenTime;
    private LocalTime eventCloseTime;
    private Integer eventQuantity;
    private String eventDescription;

    public EventInformation(Integer eventID, String eventName, Integer eventStageID, String eventArtist, LocalDate eventDate, LocalTime eventOpenTime, LocalTime eventCloseTime, Integer eventQuantity, String eventDescription) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventStageID = eventStageID;
        this.eventArtist = eventArtist;
        this.eventOpenTime = eventOpenTime;
        this.eventCloseTime = eventCloseTime;
        this.eventQuantity = eventQuantity;
        this.eventDescription = eventDescription;
    }
    public String getEventName() {
        return eventName;
    }
    public Integer getEventID() {
        return eventID;
    }
    public LocalDate getEventDate() {
        return eventDate;
    }
    public String getEventArtistID() {
        return eventArtist;
    }
    public Integer getEventQuantity() {
        return eventQuantity;
    }
    public Integer getEventStageID() {
        return eventStageID;
    }
    public LocalTime getEventCloseTime() {
        return eventCloseTime;
    }
    public LocalTime getEventOpenTime() {
        return eventOpenTime;
    }
    public String getEventDescription() {
        return eventDescription;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public void setEventArtistID(String eventArtistID) {
        this.eventArtist = eventArtist;
    }
    public void setEventCloseTime(LocalTime eventCloseTime) {
        this.eventCloseTime = eventCloseTime;
    }
    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
    public void setEventOpenTime(LocalTime eventOpenTime) {
        this.eventOpenTime = eventOpenTime;
    }
    public void setEventQuantity(Integer eventQuantity) {
        this.eventQuantity = eventQuantity;
    }
    public void setEventStageID(Integer eventStageID) {
        this.eventStageID = eventStageID;
    }
}
