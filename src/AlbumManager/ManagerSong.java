// HP 4-1-2021 8h38m

package AlbumManager;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManagerSong {

	static Scanner scanner = new Scanner(System.in);

	private List<Song> listOfSong;
	private ManagerFile managerFile;

	public ManagerSong() {
		managerFile = new ManagerFile();
		listOfSong = managerFile.readFromFile();
	}

//  ----------------------------------------------------------------------------
	// Adding new song to list:
	public void addNewSongToList() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		System.out.println("<?>Insert information about this song");
		System.out.print("-ID: ");
		String id = scanner.nextLine();
		
		System.out.print("-Name: ");
		String name = scanner.nextLine();
		
		System.out.print("-Singer: ");
		String singer = scanner.nextLine();
		
		System.out.print("-Price: ");
		double price = scanner.nextDouble(); scanner.nextLine();
		
		System.out.print("-Release date: ");
		String release = scanner.nextLine();
		
		Date releaseDate = sdf.parse(release);
		System.out.print("-Views: ");
		long views = scanner.nextLong(); scanner.nextLine();

		Song newSong = new Song(id, name, singer, price, releaseDate, views);
		this.listOfSong.add(newSong);

		managerFile.writeToFile(listOfSong);
	}

	// Removing a song from list by ID:
	public void removeSongFromList() {
		System.out.print("Enter the ID of this song: ");
		String id = scanner.nextLine();

		Song removeSong = this.listOfSong.stream()
				.filter(s -> s.getId().equals(id))
				.findFirst()
				.orElse(null);

		if (removeSong == null) {
			System.out.println("This song does't exist!");
		} else {
			this.listOfSong.remove(removeSong);
			System.out.println("Job done!");
			managerFile.writeToFile(listOfSong);
		}
	}

	// Editing list of song:
	public void editInformationOfASong() throws ParseException {
		System.out.print("Enter the ID of this song: ");
		String id = scanner.nextLine();

		Song editSong = this.listOfSong.stream()
				.filter(s -> s.getId().equals(id))
				.findFirst()
				.orElse(null);

		if (editSong == null) {
			System.out.println("Can't find this song!");
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			String newID = null;
			String newName = null;
			String newSinger = null;
			double newPrice = 0;
			String newDay = null;
			Date newReleaseDate = null;
			long newView = 0;

			// New ID:
			System.out.println("<?>Edit the ID");
			System.out.println("1.Yes");
			System.out.println("2.No");
			int choice1 = scanner.nextInt();
			scanner.nextLine();

			switch (choice1) {
			case 1: {
				System.out.print("Enter new ID: ");
				newID = scanner.nextLine();
				break;
			}
			case 2: {
				newID = editSong.getId();
				break;
			}
			}

			// New name:
			System.out.println("<?>Edit the name");
			System.out.println("1.Yes");
			System.out.println("2.No");
			int choice2 = scanner.nextInt();
			scanner.nextLine();

			switch (choice2) {
			case 1: {
				System.out.print("Enter new name: ");
				newName = scanner.nextLine();
				break;
			}
			case 2: {
				newName = editSong.getName();
				break;
			}
			}

			// New Singer:
			System.out.println("<?>Edit the singer");
			System.out.println("1.Yes");
			System.out.println("2.No");
			int choice3 = scanner.nextInt();
			scanner.nextLine();

			switch (choice3) {
			case 1: {
				System.out.print("Enter new singer: ");
				newSinger = scanner.nextLine();
				break;
			}
			case 2: {
				newSinger = editSong.getSinger();
				break;
			}
			}

			// New price:
			System.out.println("<?>Edit the price");
			System.out.println("1.Yes");
			System.out.println("2.No");
			int choice4 = scanner.nextInt();
			scanner.nextLine();

			switch (choice4) {
			case 1: {
				System.out.print("Enter new price: ");
				newPrice = scanner.nextDouble();
				scanner.nextLine();
				break;
			}
			case 2: {
				newPrice = editSong.getPrice();
				break;
			}
			}

			// New release date:
			System.out.println("<?>Edit the release date");
			System.out.println("1.Yes");
			System.out.println("2.No");
			int choice5 = scanner.nextInt();
			scanner.nextLine();

			switch (choice5) {
			case 1: {
				System.out.print("Enter new release date: ");
				newDay = scanner.nextLine();
				newReleaseDate = sdf.parse(newDay);
				break;
			}
			case 2: {
				newReleaseDate = editSong.getReleaseDate();
				break;
			}
			}

			// New views:
			System.out.println("<?>Edit the view");
			System.out.println("1.Yes");
			System.out.println("2.No");
			int choice6 = scanner.nextInt();
			scanner.nextLine();

			switch (choice6) {
			case 1: {
				System.out.print("Enter new views: ");
				newView = scanner.nextLong();
				scanner.nextLine();
				break;
			}
			case 2: {
				newView = editSong.getViews();
				break;
			}
			}

			Song newSong = new Song(newID, newName, newSinger, newPrice, newReleaseDate, newView);
			this.listOfSong.add(newSong);
			this.listOfSong.remove(editSong);

			managerFile.writeToFile(listOfSong);
		}
	}

	// Displaying list of song:
	public void displayingListOfSong() {
		System.out.println("List song:");

		System.out.print("   ");
		System.out.printf("%-25s %-25s %-15s %-10s %-15s %s\n", "ID", "Name", "Singer", "Price", "Release date",
				"Views");
		for (int i = 0; i < this.listOfSong.size(); ++i) {
			System.out.print((i + 1) + ", ");
			this.listOfSong.get(i).display();
		}
	}

//  ----------------------------------------------------------------------------
	// Searching a song by name:
	public void searchSongByName() {
		System.out.print("Enter the name of this song: ");
		String name = scanner.nextLine();

		Song searchSong = this.listOfSong.stream()
				.filter(s -> s.getName().equals(name))
				.findFirst()
				.orElse(null);

		if (searchSong == null) {
			System.out.println("Can't find this song!");
		} else {
			System.out.println("=> Result:");
			System.out.println(searchSong.toString());
		}
	}

	// Searching a list of song of a singer:
	public void searchListOfSongOfASinger() {
		System.out.print("Enter the name of the singer: ");
		String nameOfSinger = scanner.nextLine();

		List<Song> list = this.listOfSong.stream()
				.filter(s -> s.getSinger().equals(nameOfSinger))
				.collect(Collectors.toList());

		if (list == null) {
			System.out.println("N/A");
		} else {
			for (int i = 0; i < list.size(); ++i) {
				System.out.print((i + 1) + ", " + list.get(i).toString() + "\n");
			}
		}
	}

//  ----------------------------------------------------------------------------
	// Sorting list by views(ascending)
	public void sortListByViewsAs() {
		List<Song> list = this.listOfSong.stream().sorted(Comparator.comparingLong(Song::getViews)).toList();

		DecimalFormat df = new DecimalFormat("#,###");
		String[] array = new String[list.size()];
		for (int i = 0; i < list.size(); ++i) {
			System.out.print((i + 1) + ",");
			array[i] = df.format(list.get(i).getViews());
			System.out.printf("%-25s %s \n", list.get(i).getName(), array[i]);
		}
	}

	// Sorting list by release date of song
	public void sortListByReleaseDate() {
		List<Song> list = this.listOfSong.stream()
				.sorted((s1, s2) -> s1.getReleaseDate().compareTo(s2.getReleaseDate())).toList();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String[] array = new String[list.size()];

		for (int i = 0; i < list.size(); ++i) {
			array[i] = sdf.format(list.get(i).getReleaseDate());
			System.out.print((i + 1) + ", ");
			System.out.printf("%-25s %s \n", list.get(i).getName(), array[i]);
		}
	}

	// Sorting list by name:
	public void sortListByName() {
		List<Song> list = this.listOfSong.stream().sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).toList();

		System.out.printf("   %-25s %s\n", "Name of song", "Singer");
		for (int i = 0; i < list.size(); ++i) {
			System.out.print((i + 1) + ", ");
			System.out.printf("%-25s %s \n", list.get(i).getName(), list.get(i).getSinger());
		}
	}

//  ----------------------------------------------------------------------------
	// Calculating average views of a singer
	public void calculateAverageViewsOfASinger() {
		System.out.print("Enter the name of this singer: ");
		String name = scanner.nextLine();

		List<Song> list = this.listOfSong.stream().filter(s -> s.getSinger().toLowerCase().equals(name)).toList();

		long averageViews = 0, totalViews = 0;
		for (int i = 0; i < list.size(); ++i) {
			totalViews += list.get(i).getViews();
		}
		averageViews = totalViews / list.size();

		System.out.println("=> Average views of " + list.size() + " songs of " + name + ": " + averageViews);
	}

	// Calculating the percentage of views of a song in list:
	public void calculatePercenViewsOfSongInList() {
		System.out.print("Enter the name of this song: ");
		String nameSong = scanner.nextLine();

		Song song = this.listOfSong.stream().filter(s -> s.getName().toLowerCase().equals(nameSong)).findFirst()
				.orElse(null);

		long totalPrice = 0;
		for (int i = 0; i < this.listOfSong.size(); ++i) {
			totalPrice += this.listOfSong.get(i).getPrice();
		}
		double percentage = song.getPrice() / totalPrice;

		System.out.println(song.getName() + "'s price: " + song.getPrice());
		System.out.println("Total price: " + totalPrice);

		NumberFormat nf = NumberFormat.getPercentInstance();
		System.out.println("=> Result: " + nf.format(percentage));
	}

//  ----------------------------------------------------------------------------
	// Finding the song with the biggest views
	public void findSongWithTheMostViews() {
		long views = this.listOfSong.stream().mapToLong(s -> s.getViews()).max().getAsLong();

		Song song = this.listOfSong.stream().filter(s -> s.getViews() == views).findFirst().orElse(null);

		System.out.println("=> The song with biggest views:");
		System.out.println(song.getName() + "\t" + song.getViews());
	}

	// Finding the most expensive song:
	public void findTheMostExpensiveSong() {
		double mostPrice = this.listOfSong.stream().mapToDouble(s -> s.getPrice()).max().getAsDouble();

		Song song = this.listOfSong.stream().filter(s -> s.getPrice() == mostPrice).findFirst().orElse(null);

		System.out.println("=> The most expensive song:");
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String string = nf.format(song.getPrice());
		System.out.println(song.getName() + "\t" + string);
	}
}
