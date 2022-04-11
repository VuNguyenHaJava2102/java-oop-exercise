// HP 5-1-2022 15h33m

package BankAccountManager;
import java.text.ParseException;
import java.util.Scanner;

public class MainBankAccount {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		ManagerBankAccount manager = new ManagerBankAccount();
		
		while(true) {
			System.out.println("----------------------Menu----------------------");
			System.out.println("|1.Register an account                         |");
			System.out.println("|2.Login                                       |");
			System.out.println("|3.Removing an account from system             |");
			System.out.println("|4.Displaying all account                      |");
			
			System.out.println("|5.Recharge                                    |");
			System.out.println("|6.Withdraw                                    |");
			System.out.println("|7.Transfer                                    |");
			
			System.out.println("|8.Sorting list                                |");
			System.out.println("|0.Exit                                        |");
			System.out.println("------------------------------------------------");
			
			System.out.print("=> Enter your selection: ");
			int choice = scanner.nextInt(); scanner.nextLine();
			
			switch(choice) {
			case 1: {
				manager.creatNewBankAccount();
				break;
			}
			
			case 2: {
				manager.loginAccount();
				break;
			}
			
			case 3: {
				manager.removeAccountFromSystem();
				break;
			}
			
			case 4: {
				manager.dislayingAccount();
				break;
			}
			
			case 5: {
				manager.rechargeMoney();
				break;
			}
			
			case 6: {
				manager.withdrawMoney();
				break;
			}
			
			case 7: {
				manager.transferMoney();
				break;
			}
			
			case 8: {
				manager.sortListByCreatedTime();
				break;
			}
			
			case 20: {
				manager.displayAll();
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
