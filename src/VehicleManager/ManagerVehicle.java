package VehicleManager;
import java.util.Comparator;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ManagerVehicle {

	static Scanner scanner = new Scanner(System.in);
	
	private List<Vehicle> listOfVehicle;
	private ManagerFile managerFile;
	
	public ManagerVehicle() {
		managerFile = new ManagerFile();
		listOfVehicle = managerFile.readFromFile();
	}
	
//  ----------------------------------------------------------------------------
	// Adding new vehicle to list:
	public void addVehicleToList() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		System.out.println("<?>Enter information about vehicle:");
		System.out.print("-ID: ");
		String id = scanner.nextLine();
		System.out.print("-Name of owner: ");
		String nameOfOwner = scanner.nextLine();
		System.out.print("-Manufacturer: ");
		String manufacturer = scanner.nextLine();
		System.out.print("-Capacity: ");
		int capacity = scanner.nextInt(); scanner.nextLine();
		System.out.print("-Price: ");
		double price = scanner.nextLong(); scanner.nextLine();
		System.out.print("-Date of manufacture: ");
		String date = scanner.nextLine();
		Date dateOfManufacture = sdf.parse(date);
		
		Vehicle newVehicle = new Vehicle(id, nameOfOwner, manufacturer, capacity, price, dateOfManufacture);
		listOfVehicle.add(newVehicle);
		
		managerFile.writeToFile(listOfVehicle);
	}
	
	// Removing a vehicle from list by id:
	public void removeVehicleFromListById() {
		System.out.print("Enter the ID of this vehicle: ");
		String id = scanner.nextLine();
		
		Vehicle vehicle = this.listOfVehicle.stream().filter(v -> v.getId().equals(id))
				.findFirst().orElse(null);
		if(vehicle == null) {
			System.out.println("Can't find this vehicle!");
		} else {
			this.listOfVehicle.remove(vehicle);
			System.out.println("Job done");
		}
	}
	
	// Editing information of a vehicle:
	public void editInformationOfAVehicle() throws ParseException {
		System.out.print("Enter the ID of the vehicle you want to edit information: ");
		String id = scanner.nextLine();
		
		Vehicle vehicle = this.listOfVehicle.stream().filter(v -> v.getId().equals(id))
				.findFirst().orElse(null);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		String newID = null;
		String newOwner = null;
		String newManufacturer = null;
		int newCapacity = 0;
		double newPrice = 0.0;
		String newDay = null;
		Date newDate = null;
		
		if(vehicle == null) {
			System.out.println("Can't find this vehicle!");
		} else {
			System.out.println("Old information:" + vehicle.toString());
			
			// ID:
			System.out.println("<?>Edit ID?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			
			int choice1 = scanner.nextInt(); scanner.nextLine();
			switch(choice1) {
			case 2: {
				newID = vehicle.getId();
				break;
			}
			case 1: {
				System.out.print("New ID: ");
				newID = scanner.nextLine();
				break;
			}
			}
			
			// Name of owner:
			System.out.println("<?>Edit owner?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			
			int choice2 = scanner.nextInt(); scanner.nextLine();
			switch(choice2) {
			case 2: {
				newOwner = vehicle.getNameOfOwner();
				break;
			}
			case 1: {
				System.out.print("New owner: ");
				newOwner = scanner.nextLine();
				break;
			}
			}
			
			// Manufacturer:
			System.out.println("<?>Edit manufacturer?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			
			int choice3 = scanner.nextInt(); scanner.nextLine();
			switch(choice3) {
			case 2: {
				newManufacturer = vehicle.getManufacturer();
				break;
			}
			case 1: {
				System.out.print("New manufacturer: ");
				newManufacturer = scanner.nextLine();
				break;
			}
			}
			
			// Capacity:
			System.out.println("<?>Edit capacity?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			
			int choice4 = scanner.nextInt(); scanner.nextLine();
			switch(choice4) {
			case 2: {
				newCapacity = vehicle.getCapacity();
				break;
			}
			case 1: {
				System.out.print("New capacity: ");
				newCapacity = scanner.nextInt();
				break;
			}
			}
			
			// Price:
			System.out.println("<?>Edit price?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			
			int choice5 = scanner.nextInt(); scanner.nextLine();
			switch(choice5) {
			case 2: {
				newPrice = vehicle.getPrice();
				break;
			}
			case 1: {
				System.out.print("New price: ");
				newPrice = scanner.nextDouble(); scanner.nextLine();
				break;
			}
			}
			
			// Date of manufacture:
			System.out.println("<?>Edit date of manufacture?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			
			int choice6 = scanner.nextInt(); scanner.nextLine();
			switch(choice6) {
			case 2: {
				newDate = vehicle.getDateOfManufacture();
				break;
			}
			case 1: {
				System.out.print("New date of manufacture: ");
				newDay = scanner.nextLine();
				newDate = sdf.parse(newDay);
				break;
			}
			}
			
			Vehicle editVehicle = new Vehicle(newID, newOwner, newManufacturer, newCapacity, newPrice, newDate);
			this.listOfVehicle.add(editVehicle);
			this.listOfVehicle.remove(vehicle);
			
			managerFile.writeToFile(listOfVehicle);
		}
	}
//  ----------------------------------------------------------------------------
	// Displaying information of all vehicle:
	public void displayInformationOfAllVehicle() {
		for(int i = 0; i < this.listOfVehicle.size(); ++i) {
			System.out.println((i+1) + ", " + this.listOfVehicle.get(i).toString());
		}
	}
	
	// Displaying information of a vehicle by a vehicle:
	public void displayInformationOfAVehicleById() {
		System.out.print("Enter the ID of this vehicle: ");
		String id = scanner.nextLine();
		
		Vehicle vehicle = this.listOfVehicle.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
		if(vehicle == null) {
			System.out.println("Can't find this vehicle!");
		} else {
			System.out.println("Result:");
			System.out.println(vehicle.toString());
		}
	}
//  ----------------------------------------------------------------------------
	// Sorting list by capacity(Ascending):
	public void sortListbyCapacity() {
		List<Vehicle> list = this.listOfVehicle.stream()
				.sorted(Comparator.comparingDouble(Vehicle::getCapacity)).toList();
		
		for(int i = 0; i < this.listOfVehicle.size(); ++i) {
			System.out.printf("%-15s %d\n", list.get(i).getId(), list.get(i).getCapacity());
		}
	}
	
	// Sorting list by date of manufacture:
	public void sortListByDateOfManufacture() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		List<Vehicle> list = this.listOfVehicle.stream()
				.sorted((v1, v2) -> v1.getDateOfManufacture().compareTo(v2.getDateOfManufacture()))
				.toList();
		
		String[] array = new String[list.size()];
		System.out.println("=> List vehicle:");
		for(int i = 0; i < array.length; ++i) {
			array[i] = sdf.format(list.get(i).getDateOfManufacture());
			System.out.print((i+1) + ", ");
			System.out.printf("%-20s %s\n", list.get(i).getId(), array[i]);
		}
	}
}
