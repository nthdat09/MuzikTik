package Model.BEAN;

public class CustomerListP {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String type;
    private int totalPoint;

    public CustomerListP() {
        super();
    }

    public CustomerListP(int id, String name, String phoneNumber, String email, String address, String type, int totalPoint) {
        super();
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.type = type;
        this.totalPoint = totalPoint;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    @Override
    public String toString() {
        return "CustomerListP{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", totalPoint=" + totalPoint +
                '}';
    }
}
