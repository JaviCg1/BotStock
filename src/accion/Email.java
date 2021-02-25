package accion;

import java.util.Iterator;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	public static void enviarEmail(String txt) throws InterruptedException {
		final String username = "javisenemail@gmail.com";
		final String password = "";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("javisendemail@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("javicalvograus@gmail.com"));
			message.setSubject(txt );
			message.setText("Dear Javier C. ," + "\n\n Look this Gmail!");
			
			for(int i=0;i<5;i++) {
				Transport.send(message);
				Thread.sleep(3000);
			}
			

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
