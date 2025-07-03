package org.trackit.bustracking.utill;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class MailSender {

    public static boolean sendMail(String recipientEmail,String subject,String body) {
        final String senderMail = "library.gietbbsr@gmail.com";
        final String senderPassword = "dqmq zxif nzpu fwjv";




        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Enable TLS

        // Create the mail session with authentication
        Session sc = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, senderPassword);
            }
        });

        try {
            // Create a simple email
            Message message = new MimeMessage(sc);
            message.setFrom(new InternetAddress(senderMail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject(subject);
            message.setText(body);

            // Send the email
            Transport.send(message);

            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;

    }
}

