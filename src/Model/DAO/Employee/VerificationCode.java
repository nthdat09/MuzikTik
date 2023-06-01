package Model.DAO.Employee;

public class VerificationCode {
    private static int code;
    private String userName;

    public VerificationCode(int code, String userName) {
        this.code = code;
        this.userName = userName;
    }

    public static int createVerificationCode() {
        code = (int) Math.floor(((Math.random() * 899999) + 100000));
        return code;
    }
}
