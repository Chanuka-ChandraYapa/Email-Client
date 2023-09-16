import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
  
import java.io.FileNotFoundException; 
import java.io.IOException;  

import java.util.Scanner; 
  
public class FileHandle {
    private static FileHandle instance = null;
    private File Obj = new File("clientList.txt");
    private ArrayList<String> arr = new ArrayList<String>();
    private static int count;

    private FileHandle(){}

    public static FileHandle get_instance(){
        if (instance == null){
            instance =  new FileHandle();
        }
        return instance;
    }

    public void emailRead(){
        try {
            
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                arr.add(data);
                
            }
            
            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    public void emailUpdate(String newEmail){
        
        if (!arr.contains(newEmail)) {
	        arr.add(newEmail);
	        try {
	            FileWriter Writer = new FileWriter("clientList.txt",true);
	            Writer.write(System.lineSeparator()+newEmail);
	            
	            Writer.close();
	            System.out.println("Successfully written.");
	        }
	        catch (IOException e) {
	            System.out.println("An error has occurred.");
	            e.printStackTrace();
	        }
        }
        else {
        	System.out.println("Entered details are already available");
        }
        
        
    }
    
    public ArrayList<String> getEmails() {
    	return arr;
    }
    
    public int getCount() {
    	count = arr.size();
    	return count;
    }
    
}
