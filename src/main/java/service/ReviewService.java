package service;

import service.mailing.MailSender;
import service.mailing.ReviewMailSender;

import java.util.List;

public class ReviewService {


    public void sendScheduledEmails() {
        List<String> recipients = List.of("i.o.alymova@gmail.com", "i.o.alymova@gmail.com");
        MailSender mailSender = new ReviewMailSender();
        recipients.forEach(mailSender::sendEmail);
    }
}
