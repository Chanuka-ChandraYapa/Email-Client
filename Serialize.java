import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

  
public class Serialize {
	public void serialize(ArrayList<SendEmail> e) {
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream("Arraylist.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(e);
	         out.close();
	         fileOut.close();
	         
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public ArrayList<SendEmail> deserialize()  {
		 ArrayList<SendEmail> e = new ArrayList<>();
	      try {
	         FileInputStream fileIn = new FileInputStream("Arraylist.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (ArrayList) in.readObject();
	         in.close();
	         fileIn.close();
	         
	      } catch (IOException i) {
	         i.printStackTrace();
	         return null;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return null;
		}
		return e;
	}
}
