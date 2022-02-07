package service;

import dao.UserDAO;
import service.mailing.MailSender;
import service.mailing.ReviewMailSender;

import java.util.List;

public class ReviewService {

    public void sendScheduledEmails() {
        //TODO: Get emails of all users with services changed status to DONE yesterday
        List<String> recipients = List.of("i.o.alymova@gmail.com", "i.o.alymova@gmail.com");
        MailSender mailSender = new ReviewMailSender();
        recipients.forEach(mailSender::sendEmail);
    }
}
