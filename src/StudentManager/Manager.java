// HP 7-1-2022 16h53m

package StudentManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Manager {
	static Scanner scanner = new Scanner(System.in);
	
	List<Student> listOfStudent;
	ManagerFile managerFile;
	
	public Manager() {
		managerFile = new ManagerFile();
		listOfStudent = managerFile.readFromFile();
	}
	
	// Adding new student to list:
	public void addStudentToList() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("<?>Enter information of this student:");
		System.out.print("-ID: ");
		String id = scanner.nextLine();
		System.out.print("-Name: ");
		String name = scanner.nextLine();
		System.out.print("-Birthday: ");
		String birthday = scanner.nextLine();
		Date dateOfBirth = sdf.parse(birthday);
		System.out.print("-Sex: ");
		String sex = scanner.nextLine();
		System.out.print("-Address: ");
		String address = scanner.nextLine();
		
		System.out.println("<?>Enter mark of this student:");
		System.out.print("-Math: ");
		double math = scanner.nextDouble(); scanner.nextLine();
		System.out.print("-Physics: ");
		double physics = scanner.nextDouble(); scanner.nextLine();
		System.out.print("-Chemistry: ");
		double chemistry = scanner.nextDouble(); scanner.nextLine();
		System.out.print("-English: ");
		double english = scanner.nextDouble(); scanner.nextLine();
		Mark mark = new Mark(math, physics, chemistry, english);
		
		Student newStudent = new Student(id, name, dateOfBirth, sex, address, mark);
		listOfStudent.add(newStudent);
		managerFile.writeToFile(listOfStudent);
	}
	
	// Removing a student from list by ID:
	public void removeStudentFromListById(String id) {
		Student removeStudent = this.listOfStudent.stream().filter(s -> s.getId().equals(id))
				.findFirst().orElse(null);
		
		if(removeStudent == null) {
			System.out.println("Can't find this student!");
		} else {
			this.listOfStudent.remove(removeStudent);
			System.out.println("Job done!");
			managerFile.writeToFile(listOfStudent);
		}
	}
//  ----------------------------------------------------------------------------
	// Displaying information:
	public void displayInformationOfStudent() {
		System.out.println("=> List student:");
		System.out.printf("%-8s %-20s %-15s %-10s %s\n", "ID", "Name", "Birthday", "Sex", "Address");
		for(int i = 0; i < this.listOfStudent.size(); ++i) {
			this.listOfStudent.get(i).displayInformationOfStudent();
		}
	}
	
	public void displayMarkOfStudent() {
		System.out.printf("%-19s %-15s %-15s %-15s %s\n", "Name", "Math", "Physics", "Chemistry", "English");
		for(int i = 0; i < this.listOfStudent.size(); ++i) {
			System.out.printf("%-20s", this.listOfStudent.get(i).getName());
			this.listOfStudent.get(i).displayMarkOfStudent();
		}
	}
//  ----------------------------------------------------------------------------
	// 1,Sorting list by name:
	public void sortListByName() {
		System.out.println("Sorting list by name:");
		List<Student> list = this.listOfStudent.stream()
				.sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).toList();
		System.out.printf("%-8s %-20s %-15s %-10s %s\n", "ID", "Name", "Birthday", "Sex", "Address");
		for(int i = 0; i < this.listOfStudent.size(); ++i) {
			list.get(i).displayInformationOfStudent();
		}
	}
	
	// 2,Sorting list by birthday:
		public void sortListByBirthday() {
			String[] stringArray = new String[this.listOfStudent.size()];
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					
			List<Student> students = this.listOfStudent.stream()
					.sorted((s1, s2) -> s1.getBirthday().compareTo(s2.getBirthday()))
					.toList();
			
			System.out.println("=> List student:");
			for(int i = 0; i < stringArray.length; ++i) {
				stringArray[i] = sdf.format(students.get(i).getBirthday());
				System.out.printf("%-20s %s\n", students.get(i).getName(), stringArray[i]);
			}
		}
//  ----------------------------------------------------------------------------
	// 1,Ranking of average mark:
	public void sortListByAverageMark() {
		System.out.println("Ranking of average mark:");
		this.listOfStudent.stream().sorted(Comparator.comparingDouble(Student::getAverageMark).reversed())
		.forEach(s -> System.out.printf("%-20s %.2f\n", s.getName(), s.getAverageMark()));
	}
	
	// 2,Ranking of math mark:
	public void sortListByMathMark() {
		System.out.println("=> Ranking of math mark:");
		this.listOfStudent.stream().sorted(Comparator.comparingDouble(Student::getMathMark).reversed())
		.forEach(s -> System.out.printf("%-20s %.2f\n", s.getName(), s.getMathMark()));
	}
	
	// 3,Ranking of physics mark:
	public void sortListByPhysicsMark() {
		System.out.println("=> Ranking of physics mark:");
		this.listOfStudent.stream().sorted(Comparator.comparingDouble(Student::getPhysicsMark).reversed())
		.forEach(s -> System.out.printf("%-20s %.2f\n", s.getName(), s.getPhysicsMark()));
	}
	
	// 4,Ranking of chemistry mark:
	public void sortListByChemistryMark() {
		System.out.println("=> Ranking of chemistry mark:");
		this.listOfStudent.stream().sorted(Comparator.comparingDouble(Student::getChemistryMark).reversed())
		.forEach(s -> System.out.printf("%-20s %.2f\n", s.getName(), s.getChemistryMark()));
	}
	
	// 5,Ranking of english mark:
	public void sortListByEnglishMark() {
		System.out.println("=> Ranking of english mark:");
		this.listOfStudent.stream().sorted(Comparator.comparingDouble(Student::getEnglishMark).reversed())
		.forEach(s -> System.out.printf("%-20s %.2f\n", s.getName(), s.getEnglishMark()));
	}
	
	// 6,Ranking of average mark of a subject
	public void rankingOfAverageMarkOfASubject() {
		double averageMath = 0, totalMath = 0;
		double averagePhysics = 0, totalPhysics = 0;
		double averageChemistry = 0, totalChemistry = 0;
		double averageEnglish = 0, totalEnglish = 0;
		
		for(int i = 0; i < this.listOfStudent.size(); ++i) {
			totalMath += this.listOfStudent.get(i).getMathMark();
			totalPhysics += this.listOfStudent.get(i).getPhysicsMark();
			totalChemistry += this.listOfStudent.get(i).getChemistryMark();
			totalEnglish += this.listOfStudent.get(i).getEnglishMark();
		}
		averageMath = totalMath / this.listOfStudent.size();
		averagePhysics = totalPhysics / this.listOfStudent.size();
		averageChemistry = totalChemistry / this.listOfStudent.size();
		averageEnglish = totalEnglish / this.listOfStudent.size();
		
		SortedMap<Double, String> map = new TreeMap<Double, String>();
		map.put(averageMath, "Math");
		map.put(averagePhysics, "Physics");
		map.put(averageChemistry, "Chemistry");
		map.put(averageEnglish, "English");
		
		System.out.printf("%-20s %s\n", "Subjects", "Average mark");
		//map.forEach((k, v) -> System.out.printf("%-20s %.2f\n", v, k));
		
		Set<Double> set = map.keySet();
		List<Double> list = new ArrayList<Double>(set);
		List<Double> sortedList = list.stream().sorted().toList();
		
		for(int i = (sortedList.size()-1); i >= 0; --i) {
			double value = sortedList.get(i);
			
			for(Entry<Double, String> entry: map.entrySet()) {
				if(entry.getKey() == value) {
					System.out.printf("%-20s %.2f\n", entry.getValue(), entry.getKey());
				}
			}
		}
	}
//  ----------------------------------------------------------------------------
	// Searching student by ID:
	public void searchStudentById() {
		System.out.print("<?>Enter the ID of this student: ");
		String id = scanner.nextLine();
		
		Student student = this.listOfStudent.stream().filter(s -> s.getId().equals(id))
				.findFirst().orElse(null);
		
		if(student == null) {
			System.out.println("Can't find this student!");
		} else {
			System.out.println("Result:");
			System.out.println(student.toString());
		}
	}
	
	// Searching list of student by a part of name:
	public void searchListStudentByAPartOfName() {
		System.out.print("<?>Enter a part of name: ");
		String aPartOfName = scanner.nextLine();
		
		List<Student> students = this.listOfStudent.stream()
				.filter(s -> s.getName().toLowerCase().contains(aPartOfName))
				.collect(Collectors.toList());
		if(students == null) {
			System.out.println("N/A");
		} else {
			int i = 1;
			for(Student student: students) {
				System.out.print(i + ", " + student.toString() + "\n");
				++i;
			}
		}
	}
	
	// Searching information of student with maximum math mark:
	public void searchInformationStudentMaxMath() {
		double maxMath = this.listOfStudent.stream().mapToDouble(s -> s.getMathMark()).max().getAsDouble();
		
		System.out.println("=> Maximum math mark: " + maxMath);
		List<Student> students = this.listOfStudent.stream()
				.filter(s -> s.getMathMark() == maxMath)
				.collect(Collectors.toList());
		System.out.print("=> Student:");
		students.stream().forEach(s -> System.out.print(s.getName() + ", "));
	}
//  ----------------------------------------------------------------------------
	// Calculating average mark of a subject:
	public void calculateAverageMarkOfASubject(int choice) {
		if(choice == 1) {
			double averageMath = 0, totalMath = 0;
			for(int i = 0; i < this.listOfStudent.size(); ++i) {
				totalMath += this.listOfStudent.get(i).getMathMark();
			}
			averageMath = totalMath / this.listOfStudent.size();
			System.out.printf("%-20s %.2f", "Average math mark:", averageMath);
		} else if(choice == 2) {
			double averagePhysics = 0, totalPhysics = 0;
			for(int i = 0; i < this.listOfStudent.size(); ++i) {
				totalPhysics += this.listOfStudent.get(i).getPhysicsMark();
			}
			averagePhysics = totalPhysics / this.listOfStudent.size();
			System.out.printf("%-20s %.2f", "Average physics mark:", averagePhysics);
		} else if(choice == 3) {
			double averageChemistry = 0, totalChemistry = 0;
			for(int i = 0; i < this.listOfStudent.size(); ++i) {
				totalChemistry += this.listOfStudent.get(i).getChemistryMark();
			}
			averageChemistry = totalChemistry / this.listOfStudent.size();
			System.out.printf("%-20s %.2f", "Average chemistry mark:", averageChemistry);
		} else {
			double averageEnglish = 0, totalEnglish = 0;
			for(int i = 0; i < this.listOfStudent.size(); ++i) {
				totalEnglish += this.listOfStudent.get(i).getEnglishMark();
			}
			averageEnglish = totalEnglish / this.listOfStudent.size();
			System.out.printf("%-20s %.2f", "Average english mark:", averageEnglish);
		}
	}
//  ----------------------------------------------------------------------------
	// Editing information of a student
	public void editInformationOfAStudent() throws ParseException {
		System.out.print("<?>Enter the ID of this student: ");
		String id = scanner.nextLine();
		
		Student student = this.listOfStudent.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
		if(student == null) {
			System.out.println("Can't find this student!");
		} else {
			System.out.printf("%-8s %-20s %-15s %-10s %s\n", "ID", "Name", "Birthday", "Sex", "Address");
			student.displayInformationOfStudent();
			
			String newID = null;
			String newName = null;
			String newDate = null;
			Date newBirthday = null;
			String newSex = null;
			String newAddress = null;
			
			// New ID
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
				newID = student.getId();
				break;
			}
			}
			
			// New name:
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
				newName = student.getName();
				break;
			}
			}
			
			// New birthday:
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			System.out.println("<?>Edit birthday?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			
			int choice3 = scanner.nextInt(); scanner.nextLine();
			switch(choice3) {
			case 1: {
				System.out.print("<?>Enter new birthday: ");
				newDate = scanner.nextLine();
				newBirthday = sdf.parse(newDate);
				break;
			}
			case 2: {
				newBirthday = student.getBirthday();
				break;
			}
			}
			
			// New sex:
			System.out.println("<?>Edit sex?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			
			int choice4 = scanner.nextInt(); scanner.nextLine();
			switch(choice4) {
			case 1: {
				System.out.print("<?>Enter new sex: ");
				newSex = scanner.nextLine();
				break;
			}
			case 2: {
				newSex = student.getSex();
				break;
			}
			}
			
			// New address:
			System.out.println("<?>Edit address?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			
			int choice5 = scanner.nextInt(); scanner.nextLine();
			switch(choice5) {
			case 1: {
				System.out.print("<?>Enter new address: ");
				newAddress = scanner.nextLine();
				break;
			}
			case 2: {
				newAddress = student.getAddress();
				break;
			}
			}
			
			Mark mark = student.getMark();
			Student newStudent = new Student(newID, newName, newBirthday, newSex, newAddress, mark);
			
			this.listOfStudent.add(newStudent);
			this.listOfStudent.remove(student);
			managerFile.writeToFile(listOfStudent);
		}
	}
	
	// Editing mark of a student:
	public void editMarkOfAStudent() {
		System.out.print("<?>Enter the ID of this student: ");
		String id = scanner.nextLine();
		
		Student student = this.listOfStudent.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
		
		if(student == null) {
			System.out.println("Can't find this student!");
		} else {
			System.out.printf("%-19s %-15s %-15s %-15s %s\n", "Name", "Math", "Physics", "Chemistry", "English");
			student.displayMarkOfStudent();
			
			Mark newMark = null;
			double newMath = 0.0;
			double newPhysics = 0.0;
			double newChemistry = 0.0;
			double newEnglish = 0.0;
			
			// Math:
			System.out.println("<?>New math mark?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			
			int choice1 = scanner.nextInt(); scanner.nextLine();
			switch(choice1) {
			case 1: {
				newMath = scanner.nextDouble(); scanner.nextLine();
				break;
			}
			case 2: {
				newMath = student.getMathMark();
				break;
			}
			}
			
			// Physics:
			System.out.println("<?>New physics mark?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			
			int choice2 = scanner.nextInt(); scanner.nextLine();
			switch(choice2) {
			case 1: {
				newPhysics = scanner.nextDouble(); scanner.nextLine();
				break;
			}
			case 2: {
				newPhysics = student.getPhysicsMark();
				break;
			}
			}
			
			// Chemistry:
			System.out.println("<?>New chemistry mark?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			
			int choice3 = scanner.nextInt(); scanner.nextLine();
			switch(choice3) {
			case 1: {
				newChemistry = scanner.nextDouble(); scanner.nextLine();
				break;
			}
			case 2: {
				newChemistry = student.getChemistryMark();
				break;
			}
			}
			
			// English:
			System.out.println("<?>New english mark?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			
			int choice4 = scanner.nextInt(); scanner.nextLine();
			switch(choice4) {
			case 1: {
				newEnglish = scanner.nextDouble(); scanner.nextLine();
				break;
			}
			case 2: {
				newEnglish = student.getEnglishMark();
				break;
			}
			}
			
			newMark = new Mark(newMath, newPhysics, newChemistry, newEnglish);
			String idd = student.getId();
			String name = student.getName();
			Date birthday = student.getBirthday();
			String sex = student.getSex();
			String address = student.getAddress();
			
			Student newStudent = new Student(idd, name, birthday, sex, address, newMark);
			this.listOfStudent.add(newStudent);
			this.listOfStudent.remove(student);
			managerFile.writeToFile(listOfStudent);
		}
	}
//  ----------------------------------------------------------------------------
}
