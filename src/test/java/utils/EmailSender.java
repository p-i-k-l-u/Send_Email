//package utils;
//
//import java.util.Properties;
//
//import jakarta.mail.Authenticator;
//import jakarta.mail.Message;
//import jakarta.mail.PasswordAuthentication;
//import jakarta.mail.Session;
//import jakarta.mail.Transport;
//import jakarta.mail.internet.InternetAddress;
//import jakarta.mail.internet.MimeMessage;
//
//public class EmailSender {
//
//    public static void sendEmail(String html) {
//
//        String from = "piklu@genefied.ai";           // your Gmail
//        String password = "khyo dqai qjnj bmjq";       // Gmail App Password
//        String to = "piklude34@gmail.com";             // recipient
//
//        Properties props = new Properties();
//
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//
//        Session session = Session.getInstance(props,
//            new Authenticator() {
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(from, password);
//                }
//            });
//
//        try {
//
//            Message message = new MimeMessage(session);
//
//            message.setFrom(new InternetAddress(from));
//
//            message.setRecipients(
//                    Message.RecipientType.TO,
//                    InternetAddress.parse(to));
//
//            message.setSubject("Selenium Automation Report");
//
//            // HTML content
//            message.setContent(html, "text/html");
//
//            // DEBUG: Print before sending
//            System.out.println("Sending Email...");
//
//            Transport.send(message);
//
//            // DEBUG: Print after sending
//            System.out.println("Email Sent Successfully");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}

// -----------------------------------------------  AWS Related --------------------------------------

package utils;

import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

public class EmailSender {

	public static void sendEmail(String subject, String html) {

		String from = "piklu@genefied.ai";
		String to = "piklude34@gmail.com";

		SesClient sesClient = SesClient.create();

		Destination destination = Destination.builder().toAddresses(to).build();

		Content subjectContent = Content.builder().data(subject).build();

		Content htmlContent = Content.builder().data(html).build();

		Body body = Body.builder().html(htmlContent).build();

		Message message = Message.builder().subject(subjectContent).body(body).build();

		SendEmailRequest request = SendEmailRequest.builder().source(from).destination(destination).message(message)
				.build();

		sesClient.sendEmail(request);

		System.out.println("Email Sent Successfully");

	}

}