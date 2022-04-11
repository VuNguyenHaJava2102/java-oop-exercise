package FamilyManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ManagerFamily {
	static Scanner scanner = new Scanner(System.in);

	private List<Family> listOfFamily;
	private ManagerFile managerFile;
	
	public ManagerFamily() {
		managerFile = new ManagerFile();
		listOfFamily = managerFile.readFromFile();
	}
	
	// Adding new family to list:
	public void addNewFamilyToList() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		Family newFamlily = new Family();
		List<Person> listPerson = new ArrayList<Person>();
		
		System.out.println("<?>Enter information about family");
		System.out.print("-Address: ");
		String address = scanner.nextLine();
		
		System.out.print("-Apartment number: ");
		int apartmentNumber = scanner.nextInt(); scanner.nextLine();
		
		System.out.print("-Number of member: ");
		int numberOfMember = scanner.nextInt(); scanner.nextLine();
		
		System.out.println("<?>Enter information of all members:");
		for(int i = 0; i < numberOfMember; ++i) {
			System.out.println("Member " + (i+1));
			System.out.print(" +Name: ");
			String name = scanner.nextLine();
			System.out.print(" +Birthday: ");
			String date = scanner.nextLine();
			Date birthday = sdf.parse(date);
			System.out.print(" +Sex: ");
			String sex = scanner.nextLine();
			System.out.print(" +Job: ");
			String job = scanner.nextLine();
			System.out.print(" +Identity number: ");
			String identityNumber = scanner.nextLine();
			
			Person newPerson = new Person(name, birthday, sex, job, identityNumber);
			listPerson.add(newPerson);
		}
		newFamlily = new Family(apartmentNumber, address, numberOfMember, listPerson);
		listOfFamily.add(newFamlily);
		managerFile.writeToFile(listOfFamily);
	}
	
	// Removing a family by apartment number:
	public void removeFamilyFromList() {
		System.out.print("<?>Enter apartment number of this family: ");
		int number = scanner.nextInt(); scanner.nextLine();
		
		Family family = this.listOfFamily.stream().filter(f -> f.getApartmentNumber() == number)
				.findAny().orElse(null);
		
		if(family == null) {
			System.out.println("Can't find this family!");
		} else {
			this.listOfFamily.remove(family);
			managerFile.writeToFile(listOfFamily);
			System.out.println("Job done!");
		}
	}
	
	// Displaying information of a family:
	public void displayAllFamily() {
		System.out.printf("%-20s %-15s %s\n", "Apartment number", "Address", "Number of members");
		for(int i = 0; i < this.listOfFamily.size(); ++i) {
			this.listOfFamily.get(i).display();
		}
	}
	
	// Displaying all members of a family:
	public void displayAllMemberOfAFamily() {
		System.out.print("Enter the apartment number of this family: ");
		int apartment = scanner.nextInt(); scanner.nextLine();
		
		Family family = this.listOfFamily.stream().filter(f -> f.getApartmentNumber() == apartment)
				.findFirst().orElse(null);
		
		if(family == null) {
			System.out.println("Can't find this family!");
		} else {
			System.out.println();
			System.out.printf("%-20s %-15s %-10s %-15s %s\n", "Name", "Birthday", "Sex", "Job", "Identity number");
			for(int i = 0; i < family.getListOfPerson().size(); ++i) {
				family.getListOfPerson().get(i).displayInformation();
			}
		}
	}
//  ----------------------------------------------------------------------------
	// Searching information of a member by identity number:
	public void getInformationOfAMemberByIn() {
		System.out.print("<?>Enter the identity number of this member: ");
		String in = scanner.nextLine();
		
		Family family = this.listOfFamily.stream().filter(f -> f.getListIdentityNumber().contains(in))
				.findFirst().orElse(null);
		
		if(family == null) {
			System.out.println("Can't find this person!");
		} else {
			System.out.println("=> Result:");
			System.out.printf("%-20s %-15s %-10s %-15s %s\n", "Name", "Birthday", "Sex", "Job", "Identity number");
			Person person = family.getMemberByIdentityNumber(in);
			person.displayInformation();
		}
	}
	
	// Searching information of all members are student:
	public void searchMembersAreStudent() {
		List<Person> listAll = new ArrayList<Person>();
		for(int i = 0; i < this.listOfFamily.size(); ++i) {
			listAll.addAll(this.listOfFamily.get(i).getListOfPerson());
		}
		
		List<Person> members = listAll.stream().filter(m -> m.getJob().toLowerCase().equals("student")).toList();
		
		System.out.printf("%-20s %-15s %-10s %-15s %s\n", "Name", "Birthday", "Sex", "Job", "Identity number");
		for(int i = 0; i < members.size(); ++i) {
			members.get(i).displayInformation();
		}
	}
//  ----------------------------------------------------------------------------	
	// Sorting all members of all family by birthday:
	public void sortListByBirthday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		
		List<Person> listAll = new ArrayList<Person>();
		for(int i = 0; i < this.listOfFamily.size(); ++i) {
			listAll.addAll(this.listOfFamily.get(i).getListOfPerson());
		}
		
		List<Person> list = listAll.stream().sorted((p1, p2) -> p1.getBirthday().compareTo(p2.getBirthday()))
				.toList();
		String[] array = new String[list.size()];
		
		for(int i = 0; i < list.size(); ++i) {
			array[i] = sdf.format(list.get(i).getBirthday());
			System.out.printf("%-20s %s\n", list.get(i).getName(), array[i]);
		}
	}
	
	// Sorting all members of all family by name:
	public void sortListByName() {
		List<Person> listAll = new ArrayList<Person>();
		for(int i = 0; i < this.listOfFamily.size(); ++i) {
			listAll.addAll(this.listOfFamily.get(i).getListOfPerson());
		}
		
		List<Person> list = listAll.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
				.toList();
		
		for(int i = 0; i < list.size(); ++i) {
			System.out.printf("%-20s %s\n", list.get(i).getName(), list.get(i).getIdentityNumber());
		}
	}
//  ----------------------------------------------------------------------------
	// The youngest member:
	public void youngestMember() {
		int minAge = this.listOfFamily.stream().mapToInt(f -> f.getMinAgeOfAfamily()).min().getAsInt();
		
		List<Person> listAll = new ArrayList<Person>();
		for(int i = 0; i < this.listOfFamily.size(); ++i) {
			listAll.addAll(this.listOfFamily.get(i).getListOfPerson());
		}
		
		Person person = listAll.stream().filter(f -> f.getAge() == minAge).findFirst().orElse(null);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		String string = sdf.format(person.getBirthday());
		
		System.out.println("=> Youngest member:");
		System.out.printf("%-17s %-12s %s\n", "Name", "Birthday", "Age");
		System.out.printf("%-17s %-12s %d\n", person.getName(), string, person.getAge());
	}
}
