package Model.BEAN.Seat;

public class Seat {
    int SEAT_ID;
    String SEAT_TYPE;
    int SEAT_STG_ID;

    public Seat() {
        super();
    }

    public Seat(int SEAT_ID, String SEAT_TYPE, int SEAT_STG_ID) {
        this.SEAT_ID = SEAT_ID;
        this.SEAT_TYPE = SEAT_TYPE;
        this.SEAT_STG_ID = SEAT_STG_ID;
    }

    public int getSEAT_ID() {
        return SEAT_ID;
    }

    public void setSEAT_ID(int SEAT_ID) {
        this.SEAT_ID = SEAT_ID;
    }

    public String getSEAT_TYPE() {
        return SEAT_TYPE;
    }

    public void setSEAT_TYPE(String SEAT_TYPE) {
        this.SEAT_TYPE = SEAT_TYPE;
    }

    public int getSEAT_STG_ID() {
        return SEAT_STG_ID;
    }

    public void setSEAT_STG_ID(int SEAT_STG_ID) {
        this.SEAT_STG_ID = SEAT_STG_ID;
    }
}
