package Model.BEAN;

public class EventPrice {
    private String eventType;
    private Integer eventPrice;
    public EventPrice(String eventType, Integer eventPrice){
        this.eventType = eventType;
        this.eventPrice = eventPrice;
    }
    public String getEventType(){
        return eventType;
    }
    public Integer getEventPrice(){
        return eventPrice;
    }
    public void setEventType(String eventType){
        this.eventType = eventType;
    }
    public void setEventPrice(Integer eventPrice){
        this.eventPrice = eventPrice;
    }
}

