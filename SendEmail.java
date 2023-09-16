
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.util.MailConnectException;
import java.io.Serializable;
import java.util.Properties;

public class SendEmail implements Serializable {

    public String email;
    public String subject;
    private String content;
    public String currentDate;

    public SendEmail() {

    }

    public SendEmail(String email, String subject, String content, String currentDate) {
        this.email = email;
        this.subject = subject;
        this.content = content;
        this.currentDate = currentDate;

    }

    public boolean send() {

        final String username = "example@gmail.com";
        final String password = "example";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            return true;
        } catch (MailConnectException f) {
            System.out.println("Connection Error");
            return false;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

}
