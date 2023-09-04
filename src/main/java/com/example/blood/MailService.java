package com.example.blood;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class MailService {
    public static String WELCOME_SUBJECT = "Welcome to our application";
    public static String WELCOME_TEXT = "We hope you help others by donating blood";
    public static String PASSWORD_RESET_SUBJECT = "Password reset";
    public static String PASSWORD_RESET_TEXT = "Your new password is : ";
    public static boolean sendMail(String recepient, String subject, String textMessage) {
        System.out.println("Preparing to send");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "temporary171842@gmail.com";
        String myAccountPassword = "fnmgjkppbluhkqjm"; // easypassword
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, myAccountPassword);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient, subject, textMessage);
        try{
            Transport.send(message);
            System.out.println("Message sent successfully...");
            return true;
        } catch (Exception e)
        {
            System.out.println("Message not sent...");
            return false;
        }
    }
    private static Message prepareMessage(Session session, String myAccountEmail, String recipient, String subject, String textMessage)
    {
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(textMessage);
            return message;
        } catch (Exception e)
        {
            System.out.println("Exception : " + e);
        }
        return null;
    }





//     GPT SUCKS
//    public static void send() throws Exception {
//      // Create a Session object.
//      Session session = Session.getInstance(new Properties());
//
//      // Create a Message object.
//      Message message = new MimeMessage(session);
//
//      // Set the sender and recipient addresses.
//      message.setFrom(new InternetAddress("temporary171842@gmail.com"));
//      message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("dilshad.ara.129@gmail.com")});
//
//      // Set the subject and body of the message.
//      message.setSubject("This is a test email");
//      message.setText("This is the body of the email message.");
//
//      // Send the message.
//      Transport.send(message);
//    }
}
