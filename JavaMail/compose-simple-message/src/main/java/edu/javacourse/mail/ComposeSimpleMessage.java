package edu.javacourse.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import java.util.Properties;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class ComposeSimpleMessage {

    private static final Logger log = LoggerFactory.getLogger(ComposeSimpleMessage.class);

    public static void main(String[] args) throws Exception {

        final Properties props = new Properties();
        props.load(ClassLoader.getSystemResourceAsStream("mail.properties"));

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(props.getProperty("smtp.username"), props.getProperty("smtp.pass"));
            }
        });

        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(props.getProperty("address.sender")));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(props.getProperty("address.recipient")));
        message.setSubject("Test JavaMail");

        message.setText("Hello!\n\n\tThis is a test message from JavaMail.\n\nThank you.");

        Transport.send(message);

        log.info("Message was sent");
    }

}
