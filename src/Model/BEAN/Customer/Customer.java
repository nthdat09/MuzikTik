package Model.BEAN.Customer;

public class Customer {
    private int id;
    private String name;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String address;
    private String type;
    private int totalPoint;

    private int balance;

    public Customer() {
        super();
    }

    public Customer(int id, String name, String username, String password, String phoneNumber, String email, String address, String type, int totalPoint, int balance) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.type = type;
        this.totalPoint = totalPoint;
        this.balance = balance;
    }

    public Customer(int id, String name, String phoneNumber, String email, String address, String type, int totalPoint, int balance) {
        super();
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.type = type;
        this.totalPoint = totalPoint;
        this.balance = balance;
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

    public String getUsernameEmail(){
        String email = getEmail();
        String[] words = email.split("@");
        return words[0];
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

    public int getBalance() {
        return balance;
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

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
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
                ", balance='" + balance + '\'' +
                '}';
    }
}
