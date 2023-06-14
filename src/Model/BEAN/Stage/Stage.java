package Model.BEAN.Stage;

public class Stage {
    private  int id;
    private String name;
    private String address;
    private double rentalPrice;

    private int capacity;
    private String openTime;
    private String closeTime;

    public Stage() {
        super();
    }

    public Stage(int id, String name, String address, double rentalPrice, int capacity, String openTime, String closeTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rentalPrice = rentalPrice;
        this.capacity = capacity;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public String toString() {
        return
                "Stage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rentalPrice=" + rentalPrice +
                ", capacity=" + capacity +
                ", openTime='" + openTime + '\'' +
                ", closeTime='" + closeTime + '\'' +
                '}';
    }
}
