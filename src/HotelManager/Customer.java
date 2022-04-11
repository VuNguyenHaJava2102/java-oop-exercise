// HP 10-1-2021 15h36m

package HotelManager;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int yearOfBorn;
	private String identityNumber;
	private Room typeOfRoom;
	private Date rentalDate;
	private Date checkOutDate;
	
	public Customer(String name, int yearOfBorn, String identityNumber,
			        Room typeOfRoom, Date rentalDate, Date checkOutDate) {
		this.name = name;
		this.yearOfBorn = yearOfBorn;
		this.identityNumber = identityNumber;
		this.typeOfRoom = typeOfRoom;
		this.rentalDate = rentalDate;
		this.checkOutDate = checkOutDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfBorn() {
		return yearOfBorn;
	}

	public void setYearOfBorn(int yearOfBorn) {
		this.yearOfBorn = yearOfBorn;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public Room getTypeOfRoom() {
		return typeOfRoom;
	}

	public void setTypeOfRoom(Room typeOfRoom) {
		this.typeOfRoom = typeOfRoom;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	@Override
	public String toString() {
		return "Customer [Name: " + name
				+ ", Year of born: " + yearOfBorn
				+ ", Identity number: " + identityNumber
				+ ", Type of Room: " + typeOfRoom.getCatelory()
				+ ", Rental date: " + rentalDate
				+ ", Chech-out date: " + checkOutDate + "]";
	}
	
	public void displayInformation() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String string1 = sdf.format(rentalDate);
		String string2 = sdf.format(checkOutDate);
		
		System.out.printf("|%-15s |%-15d |%-15s |%-15s |%-15s |%s\n", name, yearOfBorn, identityNumber,
				typeOfRoom.catelory, string1, string2);
	}
}
