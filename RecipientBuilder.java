
public class RecipientBuilder {
	public String dataString;
	public String[] data;
	public String name;
    public String nickname;
    public String email; 
    public String birthday;
    public String post;
    
    public RecipientBuilder(String data) {
    	this.dataString = data;
    	this.data =data.split(",");
    }
    public RecipientBuilder addName(){
        this.name = data[0].substring(data[0].indexOf(":")+2);
        return this;
    }
    public RecipientBuilder addNickname(){
        this.nickname = data[1];
        return this;
    }
    public RecipientBuilder addEmail(){
        if (data[0].substring(0,data[0].indexOf(":")).equals("Personal")) {
        	this.email = data[2];
        }
        else {
        	this.email = data[1];
        }
        return this;
    }
    
    public RecipientBuilder addBirthday(){
        this.birthday = data[3];
        return this;
    }
    public RecipientBuilder addPost(){
        this.post = data[2];
        return this;
    }
    public Recipient build(){
    	if (data[0].substring(0,data[0].indexOf(":")).equals("Personal")) {
    		addName();
    		addNickname();
    		addEmail();
    		addBirthday();
    		return new PersonalRecipient(this);
    	}
    	else if (data[0].substring(0,data[0].indexOf(":")).equals("Official")) {
    		addName();
    		addEmail();
    		addPost();
    		return new OfficialRecipient(this);
    	}
    	else if (data[0].substring(0,data[0].indexOf(":")).equals("Office_friend")) {
    		addName();
    		addEmail();
    		addPost();
    		addBirthday();
    		return new Office_friendRecipient(this);
    	}
    	else {
    		return null;
    	}
        
    }
}
