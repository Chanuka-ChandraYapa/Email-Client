// your index number = 200742E

//import libraries
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Email_Client {

	public static void main(String[] args) {

		ArrayList<SendEmail> sentEmails = new Serialize().deserialize();
		// ArrayList<SendEmail> sentEmails = new ArrayList<SendEmail>();
		// get the current Date
		LocalDate date = LocalDate.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String currentDate = date.format(dateFormatter);

		// read the email details from the txt file
		FileHandle F1 = FileHandle.get_instance();
		F1.emailRead();

		// add email details to an arraylist
		ArrayList<String> arr2 = F1.getEmails();
		System.out.println(F1.getCount());

		// build each recipient object and store them in an arraylist
		ArrayList<Recipient> recipientList = new ArrayList<Recipient>();
		for (int i = 0; i < F1.getCount(); i++) {
			recipientList.add(new RecipientBuilder(arr2.get(i)).build());
		}

		// send birthday wishes on the current data
		for (int i = 0; i < F1.getCount(); i++) {
			Recipient Ri = recipientList.get(i);
			String birthday = Ri.getBirthday();
			if (birthday.equals(currentDate.substring(currentDate.indexOf("/") + 1))) {
				Ri.birthdaysend(currentDate, sentEmails);
			}
		}

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter option type: \n"
					+ "1 - Adding a new recipient\n"
					+ "2 - Sending an email\n"
					+ "3 - Printing out all the recipients who have birthdays\n"
					+ "4 - Printing out details of all the emails sent\n"
					+ "5 - Printing out the number of recipient objects in the application");

			int option = scanner.nextInt();

			switch (option) {
				case 1:
					// input format - Official: nimal,nimal@gmail.com,ceo
					// Use a single input to get all the details of a recipient
					// code to add a new recipient
					// store details in clientList.txt file
					// Hint: use methods for reading and writing files
					System.out.println("Enter details of the recipient\n"
							+ "input format - Official: nimal,nimal@gmail.com,ceo");
					Scanner myObj = new Scanner(System.in); // Create a Scanner object

					String newEmail = myObj.nextLine();
					F1.emailUpdate(newEmail);
					Recipient Rnew = new RecipientBuilder(newEmail).build();
					recipientList.add(Rnew);

					String birthday = Rnew.getBirthday();
					if (birthday.equals(currentDate.substring(currentDate.indexOf("/") + 1))) {
						Rnew.birthdaysend(currentDate, sentEmails);
					}
					break;
				case 2:
					// input format - email, subject, content
					// code to send an email
					System.out.println("Enter the email, subject and content\n"
							+ "input format - email, subject, content");
					Scanner scan = new Scanner(System.in);
					String data = scan.nextLine();
					String[] arr = data.split(",");
					SendEmail E1 = new SendEmail(arr[0], arr[1], arr[2], currentDate);

					if (E1.send()) {
						sentEmails.add(E1);
						System.out.println("Email sent successfully");

					}

					break;
				case 3:
					// input format - yyyy/MM/dd (ex: 2018/09/17)
					// code to print recipients who have birthdays on the given date
					System.out.println("Enter the date : \n"
							+ "input format - yyyy/MM/dd (ex: 2018/09/17)");

					Scanner scan2 = new Scanner(System.in);
					String data2 = scan2.nextLine();
					int it = 0;
					for (int i = 0; i < F1.getCount(); i++) {
						Recipient Ri = recipientList.get(i);

						if (Ri.getBirthday().equals(data2.substring(data2.indexOf("/") + 1))) {
							it += 1;
							System.out.println(Ri.getName() + " has birthday on " + Ri.birthday);
						}
					}
					if (it == 0) {
						System.out.println("No friends has birthdays on this date");
					}
					break;
				case 4:
					// input format - yyyy/MM/dd (ex: 2018/09/17)
					// code to print the details of all the emails sent on the input date
					System.out.println("Enter the date : \n" + "input format - yyyy/MM/dd (ex: 2018/09/17)");
					Scanner scan3 = new Scanner(System.in);
					String data3 = scan3.nextLine();
					it = 0;
					for (int i = 0; i < sentEmails.size(); i++) {
						if (sentEmails.get(i).currentDate.equals(data3)) {
							it += 1;
							System.out.println("Email " + (i + 1) + " : "
									+ "Sent to " + sentEmails.get(i).email
									+ " on " + sentEmails.get(i).subject);
						}
					}
					if (it == 0) {
						System.out.println("No Emails sent in this date");
					}
					break;
				case 5:
					// code to print the number of recipient objects in the application
					System.out.println(F1.getCount() + " recipients are in the application");
					break;

			}
		}
		// start email client
		// code to create objects for each recipient in clientList.txt
		// use necessary variables, methods and classes
		new Serialize().serialize(sentEmails);
	}

}

// create more classes needed for the implementation (remove the public access
// modifier from classes when you submit your code)