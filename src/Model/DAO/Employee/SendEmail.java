package Model.DAO.Employee;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
    private static final String FROM_EMAIL = "fantastic4vn@gmail.com";
    private static final String PASSWORD = "sfplhrtytaefaudj\n";
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 465;

    public static void sendCodeToEmail(int code, String toEmail) throws EmailException {
        String subject = "Verification Code";
        String body = "Your verification code is: " + code;

        sendEmail(FROM_EMAIL, PASSWORD, SMTP_HOST, SMTP_PORT, subject, body, toEmail);
    }

    private static void sendEmail(String fromEmail, String password, String smtpHost, int smtpPort,
                                  String subject, String body, String toEmail) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName(smtpHost);
        email.setSmtpPort(smtpPort);
        email.setAuthenticator(new DefaultAuthenticator(fromEmail, password));
        email.setSSLOnConnect(true);
        email.setTLS(false);

        try {
            email.setFrom(fromEmail, "Fantastic Four");
            email.setSubject(subject);
            email.setMsg(body);
            email.addTo(toEmail);
            email.send();
            System.err.println("Sent email to " + toEmail + " successfully");
        } catch (EmailException e) {
            System.err.println("Failed to send email to " + toEmail);
            throw e;
        }
    }

}
