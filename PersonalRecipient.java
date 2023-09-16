import java.util.ArrayList;
public class PersonalRecipient extends Recipient {
	
    
    private String message;
    
	public PersonalRecipient(RecipientBuilder R) {
		super(R);
		this.nickname = R.nickname;
		this.birthday = R.birthday;
	}
	
	public String getBirthday() {
		return birthday.substring(birthday.indexOf("/")+1);
	}
	
	public String birthdaysend(String currentDate, ArrayList<SendEmail> sentEmails) {
		message = "Hugs and love on your Birthday, Chanuka";
		new Birthdays().birthdaysend( currentDate, sentEmails, getEmail(), message);
		/*SendEmail Ep = new SendEmail(getEmail(), "Birthday Wish", message, currentDate);
		boolean res = true;
		for(int i = 0; i < sentEmails.size(); i++) {
			if (sentEmails.get(i).email.equals(Ep.email)) {
				//if (sentEmails.contains(Ep)== false){
				res = false;
				break;
			}
		}
		if (res){
			sentEmails.add(Ep);
		}
			
	//}*/
		return message;
		
	}
}
