package by.stankevich.artemiy.finalproject.dealerstat.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailConfirmRegistration(String to, String firstName, String lastName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Confirm registration");

        StringBuffer textMessage = new StringBuffer();
        textMessage.append("Congratulations " + firstName + " " + lastName + ", you are successfully " +
                "registered as like TRADER");
        textMessage.append("\nFrom this moment on, your account is active and you have access " +
                "to add goods for game items.");
        message.setText(textMessage.toString());
        mailSender.send(message);
    }
}
