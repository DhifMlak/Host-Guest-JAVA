package utils;

import entites.Logement;
import entites.Offre;
import entites.Reservation;
import entites.Sortie;
import static java.lang.ProcessBuilder.Redirect.to;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class Shared {
    
    public void sendmail(String mail, String Message1) throws MessagingException{
    
    String from = "fromemail@gmail.com";
       String username = "hostandguestpidev@gmail.com";//change accordingly
       String password = "host&guest";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
	   }
         });

     
       
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            
            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mail));
            
            // Set Subject: header field
            message.setSubject("Reservation");
            
            // Now set the actual message
            message.setText(Message1);
            
            // Send message
            Transport.send(message);
            
            System.out.println("Sent message successfully....");
       

    }
    public static String username;
    public static ScreenController.Screen screen;
    public static Sortie offre;
    public static Logement offre2;
    public static Reservation reservation;
}

