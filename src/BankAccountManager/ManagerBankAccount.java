// HP 5-1-2022 15h33m

package BankAccountManager;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ManagerBankAccount {
	static Scanner scanner = new Scanner(System.in);

	private List<BankAccount> listOfAccount;
	private ManagerFile managerFile;
	
	public ManagerBankAccount() {
		managerFile = new ManagerFile();
		listOfAccount = managerFile.readFromFile();
	}
	
//  ----------------------------------------------------------------------------
	// Getting current created time:
	public Date getCreatedTime() throws ParseException {
		LocalDateTime current = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:SS");
		String string = current.format(dtf);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");
		Date createdTime = sdf.parse(string);
		
		return createdTime;
	}
	
	// Getting random ID:
	public String getRandomId() {
		Random random = new Random();
		int randomInt = 1000000 + random.nextInt(9999999);
		String id = String.valueOf(randomInt);
		return id;
	}
//  ----------------------------------------------------------------------------
	
	// Creating new account:
	public void creatNewBankAccount() throws ParseException {
		System.out.println("<?>Insert information");
		System.out.print("-Account: ");
		String account = scanner.nextLine();
		
		System.out.print("-Password: ");
		String password = scanner.nextLine();
		
		System.out.print("-User name: ");
		String userName = scanner.nextLine();
		
		System.out.print("-Account balance: ");
		double accountBalance = scanner.nextDouble(); scanner.nextLine();
		
		Date createdTime = getCreatedTime();
		String id = getRandomId();
		
		BankAccount newBankAccount = new BankAccount(account, password, userName, accountBalance, createdTime, id);
		this.listOfAccount.add(newBankAccount);
		managerFile.writeToFile(listOfAccount);
	}
	
	// Login account:
	public void loginAccount() {
		System.out.print("Enter account: ");
		String account = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();
		
		BankAccount bankAccount = this.listOfAccount.stream()
				.filter(a -> a.getAccount().equals(account) && a.getPassword().equals(password))
				.findFirst().orElse(null);
		
		if(bankAccount == null) {
			System.out.println("This account doesn't exist!");
		} else {
			System.out.printf("%-10s %-20s %-15s %-20s %-20s %-15s\n",
					"ID", "Account", "Password", "User name", "Balance account", "Created time");
			bankAccount.display();
		}
	}
	
	// Removing an account from system:
	public void removeAccountFromSystem() {
		System.out.print("Enter the ID of this account: ");
		String id = scanner.nextLine();
		
		BankAccount account = this.listOfAccount.stream()
				.filter(a -> a.getId().equals(id)).findFirst().orElse(null);
		
		if(account == null) {
			System.out.println("This account doesn't exist!");
		} else {
			this.listOfAccount.remove(account);
			managerFile.writeToFile(listOfAccount);
			System.out.println("Job done!");
		}
	}
	
	// Displaying all account:
	public void dislayingAccount() {
		System.out.printf("%-10s %s\n", "ID", "User name");
		for(int i = 0; i < this.listOfAccount.size(); ++i) {
			System.out.printf("%-10s %s\n", this.listOfAccount.get(i).getId(),
					this.listOfAccount.get(i).getNameUser());
		}
	}
	
	public void displayAll() {
		this.listOfAccount.stream().forEach(s -> System.out.println(s.toString()));
	}
//  ----------------------------------------------------------------------------
	// Recharge money:
	public void rechargeMoney() {
		System.out.println("<?>Please login");
		System.out.print("Account: ");
		String account = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();
		
		BankAccount bankAccount = this.listOfAccount.stream()
				.filter(a -> a.getAccount().equals(account) && a.getPassword().equals(password))
				.findFirst().orElse(null);
		
		if(bankAccount == null) {
			System.out.println("This account doesn't exist!");
		} else {
			System.out.println("=> Logged in successfully!");
			System.out.printf("%-10s %-20s %-15s %-20s %-20s %-15s\n",
					"ID", "Account", "Password", "User name", "Balance account", "Created time");
			bankAccount.display();
			
			System.out.print("<?>Enter the transaction amount money: ");
			double amount = scanner.nextDouble(); scanner.nextLine();
			
			double oldBalance = bankAccount.getAccountBalance();
			oldBalance += amount;
			bankAccount.setAccountBalance(oldBalance);
			
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			String string1 = nf.format(amount);
			String string2 = nf.format(oldBalance);
			
			System.out.println("Successful transaction!");
			System.out.println("Transaction amount money: " + string1);
			System.out.println("Updated balance account: " + string2);
			
			managerFile.writeToFile(listOfAccount);
		}
	}
	
	// Withdraw money:
	public void withdrawMoney() {
		System.out.println("<?>Please login");
		System.out.print("Account: ");
		String account = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();
		
		BankAccount bankAccount = this.listOfAccount.stream()
				.filter(a -> a.getAccount().equals(account) && a.getPassword().equals(password))
				.findFirst().orElse(null);
		
		if(bankAccount == null) {
			System.out.println("This account doesn't exist!");
		} else {
			System.out.println("=> Logged in successfully!");
			System.out.printf("%-10s %-20s %-15s %-20s %-20s %-15s\n",
					"ID", "Account", "Password", "User name", "Balance account", "Created time");
			bankAccount.display();
			
			System.out.print("<?>Enter the transaction amount money: ");
			double amount = scanner.nextDouble(); scanner.nextLine();		
			double oldBalance = bankAccount.getAccountBalance();
			
			if(amount > oldBalance) {
				System.out.println("<!>Amount money in account isn't enough to make the transaction!");
			} else {
				oldBalance -= amount;
				bankAccount.setAccountBalance(oldBalance);
				NumberFormat nf = NumberFormat.getCurrencyInstance();
				String string1 = nf.format(amount);
				String string2 = nf.format(oldBalance);
				
				System.out.println("Successful transaction!");
				System.out.println("Transaction amount money: " + string1);
				System.out.println("Updated balance account: " + string2);
				
				managerFile.writeToFile(listOfAccount);
			}
		}
	}
	
	// Transfer money:
	public void transferMoney() {
		System.out.println("<?>Please login");
		System.out.print("Account: ");
		String account = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();
		
		BankAccount sendAccount = this.listOfAccount.stream()
				.filter(a -> a.getAccount().equals(account) && a.getPassword().equals(password))
				.findFirst().orElse(null);
		
		if(sendAccount == null) {
			System.out.println("This account doesn't exist!");
		} else {
			System.out.println("-------------------");
			System.out.printf("%-10s %s\n", "ID", "User name");
			for(int i = 0; i < this.listOfAccount.size(); ++i) {
				if(this.listOfAccount.get(i) != sendAccount) {
					System.out.printf("%-10s %s\n", this.listOfAccount.get(i).getId(),
							this.listOfAccount.get(i).getNameUser());
				}
			}
			System.out.print("<?>Enter the ID of the transaction account: ");
			String ID = scanner.nextLine();
			
			BankAccount receiveAccount = this.listOfAccount.stream()
					.filter(s -> s.getId().equals(ID)).findFirst().orElse(null);
			
			double sendAcc = sendAccount.getAccountBalance();
			double receiveAcc = receiveAccount.getAccountBalance();
			
			System.out.print("<?>Enter the transaction amount money: ");
			double amount = scanner.nextDouble(); scanner.nextLine();
			
			while(amount > sendAcc) {
				System.out.println("<!>Amount money in account isn't enough to make the transaction!");
				System.out.println("<?>Do you want to recharge money?");
				System.out.println("1.Yes");
				System.out.println("2.No");
				
				int choice = scanner.nextInt(); scanner.nextLine();
				switch(choice) {
				case 1: {
					System.out.print("Enter the amount money you want to recharge: ");
					double recharge = scanner.nextDouble(); scanner.nextLine();
					
					sendAcc += recharge;
					sendAccount.setAccountBalance(sendAcc);
					break;
				}
				case 2: {
					break;
				}
				}
			}
			
			sendAcc -= amount;
			receiveAcc += amount;
			
			sendAccount.setAccountBalance(sendAcc);
			receiveAccount.setAccountBalance(receiveAcc);
			
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			String string1 = nf.format(amount);
			String string2 = nf.format(sendAcc);
			String string3 = nf.format(receiveAcc);
			
			System.out.println("Transaction amount: " + string1);
			System.out.println("Updated send account balance: " + string2);
			System.out.println("Updated receive account balance: " + string3);
			
			managerFile.writeToFile(listOfAccount);
		}
	}
//  ----------------------------------------------------------------------------
	// Sorting list by created time:
	public void sortListByCreatedTime() {
		List<BankAccount> list = this.listOfAccount.stream()
				.sorted((a1, a2) -> a1.getCreatedTime().compareTo(a2.getCreatedTime())).toList();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");
		String[] array = new String[list.size()];
		
		System.out.printf("%-10s %-20s %s\n", "ID", "User name", "Created time");
		for(int i = 0; i < list.size(); ++i) {
			array[i] = sdf.format(list.get(i).getCreatedTime());
			System.out.printf("%-10s %-20s %s\n", list.get(i).getId(), list.get(i).getNameUser(),
					array[i]);
		}
	}
}
