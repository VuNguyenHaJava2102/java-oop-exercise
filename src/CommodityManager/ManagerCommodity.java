package CommodityManager;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ManagerCommodity {
	static Scanner scanner = new Scanner(System.in);

	private List<Commodity> listOfCommodity;
	private MangerFile managerFile;
	
	public ManagerCommodity() {
		managerFile = new MangerFile();
		this.listOfCommodity = managerFile.readFromFile();
	}
	
//  ----------------------------------------------------------------------------
	// Adding new commodity to system:
	public void addNewCommodityToSystem() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		System.out.println("<?>Enter information about commodity");
		System.out.print("-ID: ");
		String id = scanner.nextLine();
		System.out.print("-Name: ");
		String name = scanner.nextLine();
		System.out.print("-Quantity: ");
		int quantity = scanner.nextInt(); scanner.nextLine();
		System.out.print("-Unit price: ");
		double unitPrice = scanner.nextDouble(); scanner.nextLine();
		System.out.print("-Date of manufacture: ");
		String date1 = scanner.nextLine();
		Date dateOfManufacture = sdf.parse(date1);
		System.out.print("-Date of expiration: ");
		String date2 = scanner.nextLine();
		Date dateOfExporation = sdf.parse(date2);
		
		Commodity newCommodity = new Commodity(id, name, quantity, unitPrice, dateOfManufacture, dateOfExporation);
		this.listOfCommodity.add(newCommodity);
		
		managerFile.writeToFile(listOfCommodity);
	}
	
	// Removing commodity from system by ID:
	public void removeCommodityFromSystemById() {
		
		boolean value = true;
		while(value) {
			System.out.print("<?>Enter the ID of this commodity: ");
			String id = scanner.nextLine();
			
			Commodity removeCommodity = this.listOfCommodity.stream()
					.filter(c -> c.getId().equals(id))
				    .findFirst().orElse(null);
			
			if(removeCommodity == null) {
				System.out.println("Can't find this commodity!");
			} else {
				this.listOfCommodity.remove(removeCommodity);
				managerFile.writeToFile(listOfCommodity);
				value = false;
			}
		}
	}
	
	// Displaying information of all commodity of system:
	public void displayInformationOfAllCommodity() {
		System.out.printf("%-10s %-20s %-10s %-15s %-20s %s\n", "ID", "Name", "Quantity", "Unit price",
				"Date of manufacture", "Date of expiration");
		
		for(int i = 0; i < this.listOfCommodity.size(); ++i) {
			this.listOfCommodity.get(i).displayInformation();
		}
	}
	
	// Edit information of commodity:
	public void editInformationOfCommodity() throws ParseException {
		String newID = null;
		String newName = null;
		int newQuantity = 0;
		double newUnitPrice = 0.0;
		String newDateManu = null;
		Date newDateOfManufacture = null;
		String newDateEx = null;
		Date newDateOfExpiration = null;
		
		boolean value = true;
		while(value) {
			System.out.print("<?>Enter the ID of this commodity: ");
			String id = scanner.nextLine();
			
			Commodity editCommodity = this.listOfCommodity.stream()
					.filter(c -> c.getId().equals(id))
				    .findFirst().orElse(null);
			
			if(editCommodity == null) {
				System.out.println("Can't find this commodity!");
			} else {
				// ID:
				System.out.println("<?>Edit ID?");
				System.out.println("1.Yes");
				System.out.println("2.No");
				
				int choice1 = scanner.nextInt(); scanner.nextLine();
				switch(choice1) {
				case 1: {
					System.out.print("<?>Enter new ID: ");
					newID = scanner.nextLine();
					break;
				}
				case 2: {
					newID = editCommodity.getId();
					break;
				}
				}
				
				// Name:
				System.out.println("<?>Edit name?");
				System.out.println("1.Yes");
				System.out.println("2.No");
				
				int choice2 = scanner.nextInt(); scanner.nextLine();
				switch(choice2) {
				case 1: {
					System.out.print("<?>Enter new name: ");
					newName = scanner.nextLine();
					break;
				}
				case 2: {
					newName = editCommodity.getName();
					break;
				}
				}
				
				// Quantity:
				System.out.println("<?>Edit quantity?");
				System.out.println("1.Yes");
				System.out.println("2.No");
				
				int choice3 = scanner.nextInt(); scanner.nextLine();
				switch(choice3) {
				case 1: {
					System.out.print("<?>Enter new quantity: ");
					newQuantity = scanner.nextInt(); scanner.nextLine();
					break;
				}
				case 2: {
					newQuantity = editCommodity.getQuantity();
					break;
				}
				}
				
				// Unit price:
				System.out.println("<?>Edit unit price?");
				System.out.println("1.Yes");
				System.out.println("2.No");
				
				int choice4 = scanner.nextInt(); scanner.nextLine();
				switch(choice4) {
				case 1: {
					System.out.print("<?>Enter new unit price: ");
					newUnitPrice = scanner.nextDouble(); scanner.nextLine();
					break;
				}
				case 2: {
					newUnitPrice = editCommodity.getUnitPrice();
					break;
				}
				}
				
				// Date of manufacture:
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				System.out.println("<?>Edit date of manufacture?");
				System.out.println("1.Yes");
				System.out.println("2.No");
				
				int choice5 = scanner.nextInt(); scanner.nextLine();
				switch(choice5) {
				case 1: {
					System.out.print("<?>Enter new date of manufacture: ");
					newDateManu = scanner.nextLine();
					newDateOfManufacture = sdf.parse(newDateManu);
					break;
				}
				case 2: {
					newDateOfManufacture = editCommodity.getDateOfManufacture();
					break;
				}
				}
				
				// Date of expiration:
				System.out.println("<?>Edit date of expiration?");
				System.out.println("1.Yes");
				System.out.println("2.No");
				
				int choice6 = scanner.nextInt(); scanner.nextLine();
				switch(choice6) {
				case 1: {
					System.out.print("<?>Enter new date of expiration: ");
					newDateEx = scanner.nextLine();
					newDateOfExpiration = sdf.parse(newDateEx);
					break;
				}
				case 2: {
					newDateOfExpiration = editCommodity.getDateOfExpiration();
					break;
				}
				}
				
				Commodity newCommodity = new Commodity(newID, newName, newQuantity, newUnitPrice,
						newDateOfManufacture, newDateOfExpiration);
				this.listOfCommodity.add(newCommodity);
				this.listOfCommodity.remove(editCommodity);
				
				value = false;
			}
			managerFile.writeToFile(listOfCommodity);
		}
	}
//  ----------------------------------------------------------------------------
	// Sorting list by date of manufacture(oldest)
	public void sortListByDateOfManufacture() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String[] array = new String[this.listOfCommodity.size()];
		
		List<Commodity> list = this.listOfCommodity.stream()
				.sorted((c1, c2) -> c1.getDateOfManufacture().compareTo(c2.getDateOfManufacture()))
				.toList();
		
		System.out.printf("%-15s %-20s %s\n", "ID", "Name", "Date of manufacture");
		for(int i = 0; i < list.size(); ++i) {
			array[i] = sdf.format(list.get(i).getDateOfManufacture());
			System.out.printf("%-15s %-20s %s\n", list.get(i).getId(),
					list.get(i).getName(), array[i]);
		}
	}
	
	// Sorting list by unit price(ascending):
	public void sortListByUnitPriceAscending() {
		List<Commodity> list = this.listOfCommodity.stream()
				.sorted(Comparator.comparingDouble(Commodity::getUnitPrice)).toList();
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String[] array = new String[list.size()];
		
		System.out.printf("%-15s %-20s %s\n", "ID", "Name", "Unit price");
		for(int i = 0; i < this.listOfCommodity.size(); ++i) {
			array[i] = nf.format(list.get(i).getUnitPrice());
			System.out.printf("%-15s %-20s %s\n", list.get(i).getId(),
					list.get(i).getName(), array[i]);
		}
	}
	
	// Sorting list by total price:
	public void sortListByTotalPriceAscending() {
		List<Commodity> list = this.listOfCommodity.stream()
				.sorted(Comparator.comparingDouble(Commodity::getTotalPrice)).toList();
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String[] array = new String[list.size()];
		
		System.out.printf("%-15s %-20s %s\n", "ID", "Name", "Total price");
		for(int i = 0; i < this.listOfCommodity.size(); ++i) {
			array[i] = nf.format(list.get(i).getTotalPrice());
			System.out.printf("%-15s %-20s %s\n", list.get(i).getId(),
					list.get(i).getName(), array[i]);
		}
	}
//  ----------------------------------------------------------------------------
	// Searching commodity by ID:
	public void searchCommodityById() {
		System.out.print("<?>Enter the ID of this commodity: ");
		String id = scanner.nextLine();
		
		Commodity searchCommodity = this.listOfCommodity.stream()
				.filter(c -> c.getId().equals(id))
				.findFirst().orElse(null);
		
		System.out.printf("%-15s %-15s %-10s %-10s %-15s %-15s", "ID", "Name", "Quantity", "Unit price",
				"Date of manufacture", "Date of exporation");
		if(searchCommodity == null) {
			System.out.println("N/A");
		} else {
			searchCommodity.displayInformation();
		}
	}
	
	// Searching list of commodity by interval
	public void searchListOfCommodityByInterval() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		System.out.print("<?>Timeline 1: ");
		String time1 = scanner.nextLine();
		Date date1 = sdf.parse(time1);
		
		System.out.print("<?>Timeline 2: ");
		String time2 = scanner.nextLine();
		Date date2 = sdf.parse(time2);
		
		List<Commodity> list = this.listOfCommodity.stream()
				.filter(c -> c.getDateOfManufacture().compareTo(date1) > 0 &&
						c.getDateOfExpiration().compareTo(date2) < 0).toList();
		
		System.out.printf("%-15s %-15s %-10s %-10s %-15s %-15s", "ID", "Name", "Quantity", "Unit price",
				"Date of manufacture", "Date of exporation");
		for(int i = 0; i < list.size(); ++i) {
			list.get(i).displayInformation();
		}
	}
//  ----------------------------------------------------------------------------
	// Calculating shelf life of commodity:
	public void calculateShelfLifeOfCommodity() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		boolean value = true;
		
		while(value) {
			System.out.print("Enter the ID of this commodity: ");
			String id = scanner.nextLine();
			
			Commodity commodity = this.listOfCommodity.stream().filter(c -> c.getId().equals(id))
					.findFirst().orElse(null);
			
			if(commodity == null) {
				System.out.println("Can't find this commodity! Try agian!");
			} else {
				long diffTime = commodity.getDateOfExpiration().getTime() - commodity.getDateOfManufacture().getTime();
				long diffDate = diffTime / (24 * 60 * 60 * 1000);
				
				System.out.println("-Date of manufacture: " + sdf.format(commodity.getDateOfManufacture()));
				System.out.println("-Date of expiration: " + sdf.format(commodity.getDateOfExpiration()));
				System.out.println("Shelf life of this commodity: " + commodity.getName() + ": " + diffDate);
				value = false;
			}
		}
	}
//  ----------------------------------------------------------------------------
	// Checking commodity are expired or not
	public void checkCommodityAreExpiredOrNot() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		boolean value = true;
		
		while(value) {
			System.out.print("Enter the ID of this commodity: ");
			String id = scanner.nextLine();
			
			Commodity commodity = this.listOfCommodity.stream().filter(c -> c.getId().equals(id))
					.findFirst().orElse(null);
			
			if(commodity == null) {
				System.out.println("Can't find this commodity! Try agian!");
			} else {
				Date currentDate = new Date();
				Date checkDate = commodity.getDateOfExpiration();
				
				long diffTime = 0;
				long diffDate = 0;
				
				if(checkDate.compareTo(currentDate) > 0) {
					diffTime = checkDate.getTime() - currentDate.getTime();
					diffDate = diffTime / (24 * 60 * 60 * 1000);
					
					System.out.println("This commodity hasn't expired and has " + diffDate + " days left.");
				} else {
					diffTime = currentDate.getTime() - checkDate.getTime();
					diffDate = diffTime / (24 * 60 * 60 * 1000);
					
					System.out.println("This commodity has expired for " + diffDate + " days.");
				}
				value = false;
			}
		}
	}
}	
