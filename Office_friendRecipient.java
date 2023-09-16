import java.util.ArrayList;
public class Office_friendRecipient extends Recipient {
    
    private String message;
	public Office_friendRecipient(RecipientBuilder R) {
		super(R);
		this.birthday = R.birthday;
		this.post = R.post;
	}
	
	public String getBirthday() {
		return birthday.substring(birthday.indexOf("/")+1);
	}
	
	public String birthdaysend(String currentDate, ArrayList<SendEmail> sentEmails ) {
		message = "Wish you a happy birthday, Chanuka";
		new Birthdays().birthdaysend( currentDate, sentEmails, getEmail(), message);
		
		return message;
	}

}
