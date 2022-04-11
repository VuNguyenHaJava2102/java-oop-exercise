package HotelManager;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {
		ManagerCustomer manager = new ManagerCustomer();
		
		while(true) {
			System.out.println("----------------------Menu----------------------");
			System.out.println("|1.Adding new customer to system               |");
			System.out.println("|2.Displaying                                  |");
			System.out.println("|0.Exit menu                                   |");
			System.out.println("------------------------------------------------");
			
			System.out.print("Enter yout selection: ");
			int choice1 = scanner.nextInt(); scanner.nextLine();
			switch(choice1) {
			case 1: {
				manager.addNewCustomerToSystem();
				break;
			}
			
			case 2: {
				manager.displayInformationAll();
				break;
			}
			
			case 0: {
				return;
			}
			
			default: {
				continue;
			}
			}
		}
	}
}
