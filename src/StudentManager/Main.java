// HP 28-12-2021 16h01m
// Edit 7-1-2021 16h53m

package StudentManager;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		Manager manager = new Manager();
		
		while(true) {
			System.out.println("\n----------------------Menu----------------------");
			System.out.println("|1.Adding new student to list.                 |");
			System.out.println("|2.Removing a student from list by ID.         |");
			
			System.out.println("|3.Displaying(*)                               |");
			System.out.println("|4.Sorting list.(*)                            |");
			System.out.println("|5.Searching information.(*)                   |");
			System.out.println("|6.Calculating(*)                              |");
			System.out.println("|7.Ranking(*)                                  |");
			System.out.println("|8.Editing information of a student(*)         |");
			
			System.out.println("|0.Exit menu.                                  |");
			System.out.println("------------------------------------------------");
			System.out.print("<?>Enter your selection: ");
			int choice1 = scanner.nextInt(); scanner.nextLine();
			
			switch(choice1) {
			case 1: {
				System.out.println("(1):Adding new student to list");
				manager.addStudentToList();
				
				break;
			}
			
			case 2: {
				System.out.println("(2):Remving a student from list by ID");
				System.out.print("<?>Enter the ID of this student: ");
				String id = scanner.nextLine();
				manager.removeStudentFromListById(id);
				
				break;
			}
			
			case 3: {
				System.out.println("1.Displaying information of student");
				System.out.println("2.Dispalying mark of student");
				
				System.out.print("<?>Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.displayInformationOfStudent();
					break;
				}
				case 2: {
					manager.displayMarkOfStudent();
					break;
				}
				}
				break;
			}
			
			case 4: {
				System.out.println("(4):Sorting list");
				System.out.println("a.Sorting list by name(Alphabetical order)");
				System.out.println("b.Sorting list by birthday");
				System.out.print("<?>Continue enter your selection: ");
				
				char choice2 = scanner.next().charAt(0); scanner.nextLine();
				switch(choice2) {
				case 'a': {
					manager.sortListByName();
					break;
				}
				case 'b': {
					manager.sortListByBirthday();
					break;
				}
				}
				break;
			}
			
			case 5: {
				System.out.println("(5):Searching information");
				System.out.println("a.Searching information of a student by ID");
				System.out.println("b.Searching by a part of name");
				System.out.println("c.Searching student with maximum mark of a subject(*)");
				System.out.print("<?>Continue enter your selection: ");
				char choice2 = scanner.next().charAt(0); scanner.nextLine();
				
				switch(choice2) {
				case 'a': {
					manager.searchStudentById();
					break;
				}
				case 'b': {
					manager.searchListStudentByAPartOfName();
					break;
				}
				case 'c': {
					System.out.println("<?>What subject?");
					System.out.println("1.Math");
					System.out.println("2.Physics");
					System.out.println("3.Chemistry");
					System.out.println("4.English");
					
					int choice3 = scanner.nextInt(); scanner.nextLine();
					switch(choice3) {
					case 1: {
						manager.searchInformationStudentMaxMath();
						break;
					}
					}
					break;
				}
				}
				break;
			}
			
			case 6: {
				System.out.println("(6):Calculating");
				System.out.println("a.Average mark of a subject(*)");
				
				System.out.print("<?>Continue enter your selection: ");
				char choice2 = scanner.next().charAt(0); scanner.nextLine();
				
				switch(choice2) {
				case 'a': {
					System.out.println("<?>What subject?");
					System.out.println("1.Math");
					System.out.println("2.Physics");
					System.out.println("3.Chemistry");
					System.out.println("4.English");
					
					int choice3 = scanner.nextInt(); scanner.nextLine();
					manager.calculateAverageMarkOfASubject(choice3);
					break;
				}
				}
				break;
			}
			
			case 7: {
				System.out.println("a.Ranking of average mark of a subject"); //dai` vl (con` cach' nao` ngan' hon k?
				System.out.println("b.Ranking of mark of a subject(*)");
				System.out.println("c.Ranking of average mark of a student");
				
				System.out.print("<?>Continue enter your selection: ");
				char choice2 = scanner.next().charAt(0); scanner.nextLine();
				
				switch(choice2) {
				case 'a': {
					manager.rankingOfAverageMarkOfASubject();
					break;
				}
				case 'b': {
					System.out.println("<?>What subject");
					System.out.println("1.Math");
					System.out.println("2.Physics");
					System.out.println("3.Chemistry");
					System.out.println("4.English");
					
					int choice3 = scanner.nextInt(); scanner.nextLine();
					
					switch(choice3) {
					case 1: {
						manager.sortListByMathMark();
						break;
					}
					case 2: {
						manager.sortListByPhysicsMark();
						break;
					}
					case 3: {
						manager.sortListByChemistryMark();
						break;
					}
					case 4: {
						manager.sortListByEnglishMark();
						break;
					}
					}
					break;
				}
				
				case 'c': {
					manager.sortListByAverageMark();
					break;
				}
				}
				break;
			}
			
			case 8: {
				System.out.println("1.Editing information of a student");
				System.out.println("2.Editing mark of a student");
				
				System.out.print("<?>Continue enter your selection: ");
				int choice2 = scanner.nextInt(); scanner.nextLine();
				
				switch(choice2) {
				case 1: {
					manager.editInformationOfAStudent();
					break;
				}
				case 2: {
					manager.editMarkOfAStudent();
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
