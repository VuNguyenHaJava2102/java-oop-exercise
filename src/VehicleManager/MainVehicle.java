package VehicleManager;
import java.text.ParseException;
import java.util.Scanner;

public class MainVehicle {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		ManagerVehicle manager = new ManagerVehicle();
		
		while(true) {
			System.out.println("----------------------Menu----------------------");
			System.out.println("|1.Adding new vehicle to list                  |");
			System.out.println("|2.Removing a vehicle from list by ID          |");
			System.out.println("|3.Editing information of a vehicle            |");
			System.out.println("|4.Displaying                                  |");
			System.out.println("|5.Sorting list                                |");
			System.out.println("|0.Exit menu                                   |");
			System.out.println("------------------------------------------------");
			
			System.out.print("Enter your selection: ");
			int choice1 = scanner.nextInt(); scanner.nextLine();
			
			switch(choice1) {
			case 1: {
				System.out.println("(1):Adding new vehicle to list");
				manager.addVehicleToList();
				break;
			}
			
			case 2: {
				System.out.println("(2):Removing a vehicle from list");
				manager.removeVehicleFromListById();
				break;
			}
			
			case 3: {
				System.out.println("(3):Edit information of a vehicle");
				manager.editInformationOfAVehicle();
				break;
			}
			
			case 4: {
				System.out.println("(4)Displaying");
				System.out.println("1.Displaying information of all vehicle");
				System.out.println("2.Displaying information of a vehicle by ID");
				System.out.print("Continue enter your selection: ");
				
				int choice2 = scanner.nextInt(); scanner.nextLine();
				switch(choice2) {
				case 1: {
					manager.displayInformationOfAllVehicle();
					break;
				}
				
				case 2: {
					manager.displayInformationOfAVehicleById();
					break;
				}
				}
				break;
			}
			
			case 5: {
				System.out.println("(5)Sorting list");
				System.out.println("1.Sorting list by capacity(ascending)");
				System.out.println("2.Sorting list by date of manufacture");
				System.out.print("Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.sortListbyCapacity();
					break;
				}
				case 2: {
					manager.sortListByDateOfManufacture();
					break;
				}
				}
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
