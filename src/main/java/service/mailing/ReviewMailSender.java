package service.mailing;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ReviewMailSender implements MailSender {
    private final String myAccountEmail = "i.o.alymova@gmail.com";
    private final String myAccountPassword = ""; //put in config file
    Properties properties = new Properties();

    {
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
    }

    private Message prepareMessage(Session session, String recipient) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Please leave a review"); // add bind for multilingual
            message.setText("Hey, please leave us a review - here's your link"); //think how to add the link
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public void sendEmail(String recipient) {
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, myAccountPassword);
            }
        });

        Message message = prepareMessage(session, recipient);
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
