package CommodityManager;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		ManagerCommodity manager = new ManagerCommodity();
		
		while(true) {
			System.out.println("----------------------Menu----------------------");
			System.out.println("|1.Adding new commodity to system              |");
			System.out.println("|2.Removing commodity from system              |");
			System.out.println("|3.Editing information of commodity            |");
			System.out.println("|4.Displaying all commodity                    |");
			
			System.out.println("|5.Sorting(*)                                  |");
			System.out.println("|6.Searching(*)                                |");
			System.out.println("|7.Calculating(*)                              |");
			System.out.println("|8.Checking(*)                                 |");
			
			System.out.println("|0.Exit menu                                   |");
			System.out.println("------------------------------------------------");
			
			System.out.print("<?>Enter your selection: ");
			int choice1 = scanner.nextInt(); scanner.nextLine();
			
			switch(choice1) {
			case 1: {
				manager.addNewCommodityToSystem();
				break;
			}
			
			case 2: {
				manager.removeCommodityFromSystemById();
				break;
			}
			
			case 3: {
				manager.editInformationOfCommodity();
				break;
			}
			
			case 4: {
				manager.displayInformationOfAllCommodity();
				break;
			}
			
			case 5: {
				System.out.println("1.Sorting list by date of manufacture");
				System.out.println("2.Sorting list by unit price(Ascending)");
				System.out.println("3.Sorting list by total price(Ascending)");
				
				System.out.print("<?>Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.sortListByDateOfManufacture();
					break;
				}
				case 2: {
					manager.sortListByUnitPriceAscending();
					break;
				}
				case 3: {
					manager.sortListByTotalPriceAscending();
					break;
				}
				}
				break;
			}
			
			case 6: {
				System.out.println("1.Searching commodity by ID");
				System.out.println("2.Searching commodity by two interval");
				
				System.out.print("<?>Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.searchCommodityById();
					break;
				}
				case 2: {
					manager.searchListOfCommodityByInterval();
					break;
				}
				}
				break;
			}
			
			case 7: {
				System.out.println("1.Calculating shelf life of commodity");
				
				System.out.print("<?>Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.calculateShelfLifeOfCommodity();
					break;
				}
				}
				break;
			}
			
			case 8: {
				System.out.println("1.Checking commodity are expired or not");
				
				System.out.print("<?>Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.checkCommodityAreExpiredOrNot();
					break;
				}
				}
				break;
			}
			}
		}
	}
}
