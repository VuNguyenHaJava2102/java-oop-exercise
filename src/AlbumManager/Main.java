// HP 4-1-2022 8h38m

package AlbumManager;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		ManagerSong manager = new ManagerSong();
		
		while(true) {
			System.out.println("----------------------Menu----------------------");
			System.out.println("|1.Adding new song to list                     |");
			System.out.println("|2.Removing a song from list                   |");
			System.out.println("|3.Editing information of a song               |");
			System.out.println("|4.Displaying list of song                     |");
			
			System.out.println("|5.Searching                                   |");
			System.out.println("|6.Sorting                                     |");
			System.out.println("|7.Calculating                                 |");
			System.out.println("|8.The best                                    |");
			System.out.println("------------------------------------------------");
			
			System.out.print("Enter your selection: ");
			int choice = scanner.nextInt(); scanner.nextLine();
			
			switch(choice) {
			case 1: {
				manager.addNewSongToList();
				break;
			}
			
			case 2: {
				manager.removeSongFromList();
				break;
			}
			
			case 3: {
				manager.editInformationOfASong();
				break;
			}
			
			case 4: {
				manager.displayingListOfSong();
				break;
			}
			
			case 5: {
				System.out.println("1.Searching a song by name");
				System.out.println("2.Searching a list of song of a singer");
				
				System.out.print("Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.searchSongByName();
					break;
				}
				case 2: {
					manager.searchListOfSongOfASinger();
					break;
				}
				}
				break;
			}
			
			case 6: {
				System.out.println("1.Sorting list by views(Ascending)");
				System.out.println("2.Sorting list by name(alphabetical order)");
				System.out.println("3.Sorting list by release date(oldest)");
				
				System.out.print("Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.sortListByViewsAs();
					break;
				}
				case 2: {
					manager.sortListByName();
					break;
				}
				case 3: {
					manager.sortListByReleaseDate();
					break;
				}
				}
				break;
			}
			
			case 7: {
				System.out.println("1.Calculating average views of a singer");
				System.out.println("2.Calculating the percentage of views of a song in list");
				
				System.out.print("Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.calculateAverageViewsOfASinger();
					break;
				}
				case 2: {
					manager.calculatePercenViewsOfSongInList();
					break;
				}
				}
				break;
			}
			
			case 8: {
				System.out.println("1.Most views");
				System.out.println("2.Most expensive");
				
				System.out.print("Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.findSongWithTheMostViews();
					break;
				}
				case 2: {
					manager.findTheMostExpensiveSong();
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
