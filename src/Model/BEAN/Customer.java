package Model.BEAN;

public class Customer {
    private String userName;
    private String phoneNumber;
    private String email;
    private String address;


    public Customer() {
        super();
    }

    public Customer(String userName, String phoneNumber, String email, String address) {
        super();
        this.address = address;
        this.email = email;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}
