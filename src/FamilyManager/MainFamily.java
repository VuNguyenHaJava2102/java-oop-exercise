package FamilyManager;
import java.text.ParseException;
import java.util.Scanner;

public class MainFamily {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		ManagerFamily manager = new ManagerFamily();
		
		while(true) {
			System.out.println("----------------------Menu----------------------");
			System.out.println("|1.Adding new family to list                   |");
			System.out.println("|2.Removing a family from list                 |");
			System.out.println("|3.Displaying(*)                               |");
			System.out.println("|4.Searching(*)                                |");
			System.out.println("|5.Sorting(*)                                  |");
			System.out.println("|6.The best(*)                                 |");
			System.out.println("|0.Exit menu                                   |");
			System.out.println("------------------------------------------------");
			
			System.out.print("Enter your selection: ");
			int choice1 = scanner.nextInt(); scanner.nextLine();
			
			switch(choice1) {
			case 1: {
				manager.addNewFamilyToList();
				break;
			}
			
			case 2: {
				manager.removeFamilyFromList();
				break;
			}
			
			case 3: {
				System.out.println("1.Displaying all family");
				System.out.println("2.Displaying all member of a family");
				
				System.out.print("Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.displayAllFamily();
					break;
				}
				case 2: {
					manager.displayAllMemberOfAFamily();
					break;
				}
				}
				break;
			}
			
			case 4: {
				System.out.println("1.Searching information of a member by identity number");
				System.out.println("2.Searching information of all member are student");
				
				System.out.print("Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.getInformationOfAMemberByIn();
					break;
				}
				case 2: {
					manager.searchMembersAreStudent();
					break;
				}
				}
				break;
			}
			
			case 5: {
				System.out.println("1.Sorting list by birthday");
				System.out.println("2.Sorting list by name");
				
				System.out.print("Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.sortListByBirthday();
					break;
				}
				case 2: {
					manager.sortListByName();
					break;
				}
				}
				break;
			}
			
			case 6: {
				System.out.println("1.The youngest member");
				System.out.println("2.");
				
				System.out.print("Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.youngestMember();
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
