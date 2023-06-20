package Model.DAO.Ticket;

import Model.Database.UserDatabase;
import org.apache.commons.mail.EmailException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SendTicketEmail {
    private static final String FROM_EMAIL = "fantastic4vn@gmail.com";
    private static final String PASSWORD = "sfplhrtytaefaudj\n";
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 465;
    public static void sendCodeToEmail(int total, int stageID, int ticketID, int seatID, String toEmail, String eventName, Integer cusID, String eventAdd, String eventDate) throws EmailException {
        String evtName = eventName.replace("<HTML>","");
        String evtNewName = evtName.replace("</HTML>","");
        Connection connection = UserDatabase.getConnection();
        String sql = "Select cus_name, cus_email from customer where cus_id = " + cusID;
        String cusName = "";
        String cusEmail = "";;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cusName = rs.getString("cus_name");
                cusEmail = rs.getString("cus_email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String subject = "Confirm successful payment for event " + evtNewName + " !";
        String body =
                "Dear " + cusName +
                ",\r\n\nWe are pleased to inform you that your ticket purchase for the upcoming concert has been successful. \r\n\n" +
                        "Your ticket code is: " + ticketID + ".\r\n\n"
                        + evtNewName + " will be held at " + eventAdd + " on " + eventDate
                + ".\r\n\nYour assigned seat number is: " + seatID +
                        ".\r\n\nPlease be reminded that the concert will start promptly, and we advise you to arrive at least 30 minutes prior to the event to avoid any inconvenience.\n" +
                        "\n" +
                        "Thank you for choosing to attend the concert and we look forward to seeing you there.\n" +
                        "\n" +
                        "Best regards, \nMUZIKTIC";

      //  String body = "Your ticket ID is: " + ticketID + "\r\nYour seat ID is: " + seatID + "\r\nYour stage ID is: " + stageID + "\r\nYour total is: " + total + "VND" + "\r\nThank you for using our service!";

        sendTicketEmail(FROM_EMAIL, PASSWORD, SMTP_HOST, SMTP_PORT, subject, body, cusEmail);
    }

    public static void sendMoreCodeToEmail(List<Integer> listTicketID, List<String> listSeatID, String toEmail, String eventName, Integer cusID, String eventAdd, String eventDate) throws EmailException {
        String evtName = eventName.replace("<HTML>","");
        String evtNewName = evtName.replace("</HTML>","");
        Connection connection = UserDatabase.getConnection();
        String sql = "Select cus_name, cus_email from customer where cus_id = " + cusID;
        String cusName = "";
        String cusEmail = "";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cusName = rs.getString("cus_name");
                cusEmail = rs.getString("cus_email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String subject = "Confirm successful payment for event " + evtNewName + " !";
        String body =
                "Dear " + cusName +
                        ",\r\n\nWe are pleased to inform you that your ticket purchase for the upcoming concert has been successful. \r\n\n" +
                        "Your ticket code is: ";
        for (int i = 0; i < listTicketID.size(); i++) {
            if(i == 0) {
                body += listTicketID.get(i) + " - Seat number: " + listSeatID.get(i) + "\r\n";
            } else {
                body += "\t\t\t    " + listTicketID.get(i) + " - Seat number: " + listSeatID.get(i) + "\r\n";
            }
        }
        body += evtNewName + " will be held at " + eventAdd + " on " + eventDate
                + ".\r\n\nPlease be reminded that the concert will start promptly, and we advise you to arrive at least 30 minutes prior to the event to avoid any inconvenience.\n" +
                "\n" +
                "Thank you for choosing to attend the concert and we look forward to seeing you there.\n" +
                "\n" +
                "Best regards, \nMUZIKTIC";

        sendTicketEmail(FROM_EMAIL, PASSWORD, SMTP_HOST, SMTP_PORT, subject, body, cusEmail);
    }

    private static void sendTicketEmail(String fromEmail, String password, String smtpHost, int smtpPort,
                                   String subject, String body, String toEmail) throws EmailException {
        org.apache.commons.mail.Email email = new org.apache.commons.mail.SimpleEmail();
        email.setHostName(smtpHost);
        email.setSmtpPort(smtpPort);
        email.setAuthenticator(new org.apache.commons.mail.DefaultAuthenticator(fromEmail, password));
        email.setSSLOnConnect(true);
        email.setTLS(false);

        try {
            email.setFrom(fromEmail, "MUZIKTIC - Music Concert Ticketing");
            email.setSubject(subject);
            email.setMsg(body);
            email.addTo(toEmail);
            email.send();
            System.err.println("Sent email to " + toEmail + " successfully");
        } catch (EmailException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
