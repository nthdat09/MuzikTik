package Model.BEAN.Customer;

public class CustomerBuyTicket {

    private Integer customerID;
    private String name;
    private String phoneNumber;
    private String email;
    Integer balance;
    public CustomerBuyTicket(Integer customerID,String name, String phoneNumber, String email, Integer balance){
        this.customerID = customerID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.balance = balance;
    }
    public Integer getCustomerID(){
        return customerID;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getEmail(){
        return email;
    }
    public Integer getBalance(){
        return balance;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setBalance(Integer balance){
        this.balance = balance;
    }
}
