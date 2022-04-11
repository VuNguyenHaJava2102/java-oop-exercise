package HotelManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ManagerCustomer {

	static Scanner scanner = new Scanner(System.in);
	
	private ManagerFile managerFile;
	private List<Customer> listOfCustomer;
	
	public ManagerCustomer() {
		managerFile = new ManagerFile();
		this.listOfCustomer = managerFile.readFromFile();
	}
	
	// Adding new customer to system:
	public void addNewCustomerToSystem() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		System.out.println("<?>Enter information of customer");
		System.out.print("1,Name: ");
		String name = scanner.nextLine();
		System.out.print("2,Year of born: ");
		int yearOfBorn = scanner.nextInt(); scanner.nextLine();
		System.out.print("3,Identity number: ");
		String identityNumber = scanner.nextLine();
		
		System.out.print("4,Type of room: ");
		System.out.println("a.A(50$/night)");
		System.out.println("b.B(30$/night)");
		System.out.println("c.C(15$/night)");
		Room room = new Room();
		char choice = scanner.next().charAt(0); scanner.nextLine();
		switch(choice) {
		case 'a': {
			room = new RoomA();
			break;
		}
		
		case 'b': {
			room = new RoomB();
			break;
		}
		
		case 'c': {
			room = new RoomC();
			break;
		}
		}
		
		System.out.print("5,Rental date: ");
		String rentalDate = scanner.nextLine();
		Date dateOfRental = sdf.parse(rentalDate);
		
		System.out.print("6,Check-out date: ");
		String checkOutDate = scanner.nextLine();
		Date dateOfCheckout = sdf.parse(rentalDate);
		
		Customer newCustomer = new Customer(name, yearOfBorn, identityNumber, room, dateOfRental, dateOfCheckout);
		this.listOfCustomer.add(newCustomer);
		
		this.managerFile.writeToFile(listOfCustomer);
	}
	
	// Displaying all information of list:
	public void displayInformationAll() {
		System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%s\n", "Name", "Year of born", "Identity number",
				"Type of room", "Rental date", "Check-out date");
		
		for(int i = 0; i < this.listOfCustomer.size(); ++i) {
			this.listOfCustomer.get(i).displayInformation();
		}
	}
}
