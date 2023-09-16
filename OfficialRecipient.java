import java.util.ArrayList;
public class OfficialRecipient extends Recipient{
	
	public OfficialRecipient(RecipientBuilder R) {
		super(R);
		this.post = R.post;
	}
	
	public String getBirthday() {
		return "null";
	}
	
	public String birthdaysend(String currentDate, ArrayList<SendEmail> sentEmails) {
		return null;
	}
}
