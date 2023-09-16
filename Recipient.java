import java.util.ArrayList;

abstract class Recipient {
	public String nickname;
	private String dataString;
	private String[] data;
	private String name;
    private String email; 
    public String birthday; 
    public String post;
	
    public Recipient(RecipientBuilder R) {
    	this.dataString = R.dataString;
        this.data = R.data;
        this.name = R.name;
        this.email = R.email;
        
        
    }
    

    public abstract String getBirthday();
    
    public abstract String birthdaysend(String currentDate, ArrayList<SendEmail> sentEmails);

    
    public String getName() {
        return name;
    }


    public String getDataString() {
        return dataString;
    }


    public String[] getData() {
        return data;
    }

    public String getEmail() {
        return email;
    }
    
    public String getNickname() {
        return nickname;
    }
 

}
