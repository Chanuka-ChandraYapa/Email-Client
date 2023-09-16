import java.util.ArrayList;
public class Birthdays {

	public String birthdaysend(String currentDate, ArrayList<SendEmail> sentEmails,String email, String message){
        SendEmail Eo = new SendEmail(email, "Birthday Wish", message, currentDate);
		boolean res = true;
		for(int i = 0; i < sentEmails.size(); i++) {
			if (sentEmails.get(i).email.equals(Eo.email)) {
				//if (sentEmails.contains(Ep) == false){
				res = false;
				break;
			}
		}
		if (res){
			sentEmails.add(Eo);
            //Eo.send();
		}
		
        return message;
    }
}
