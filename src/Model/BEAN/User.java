package Model.BEAN;

public class User {
    private String username;
    private String password;

    private String email;


    public User() {
        super();
    }

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

public User(String username, String password, String email) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + "]";
    }
}
