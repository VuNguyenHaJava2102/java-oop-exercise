// HP 6-1-2022 14h00m

package FamilyManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Family implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int apartmentNumber;
	private String address;
	private int numberOfMember;
	private List<Person> listOfPerson;
	
	public Family(int apartmentNumber, String address, int numberOfMember, List<Person> listOfPerson) {
		this.apartmentNumber = apartmentNumber;
		this.address = address;
		this.numberOfMember = numberOfMember;
		this.listOfPerson = listOfPerson;
	}

	public Family() {
	}

	
	public int getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumberOfMember() {
		return numberOfMember;
	}

	public void setNumberOfMember(int numberOfMember) {
		this.numberOfMember = numberOfMember;
	}

	public List<Person> getListOfPerson() {
		return listOfPerson;
	}

	public void setListOfPerson(List<Person> listOfPerson) {
		this.listOfPerson = listOfPerson;
	}
	
	@Override
	public String toString() {
		return "Family [apartmentNumber=" + apartmentNumber
				+ ", address=" + address
				+ ", numberOfMember=" + numberOfMember
				+ ", listOfPerson=" + listOfPerson + "]";
	}

	public void display() {
		System.out.printf("%-20d %-15s %d\n", apartmentNumber, address, numberOfMember);
	}
	
	public void displayInformationOfMember() {
		for(int i = 0; i < this.listOfPerson.size(); ++i) {
			this.listOfPerson.get(i).displayInformation();
		}
	}
//  ----------------------------------------------------------------------------
	// Getting list of identity number:
	public List<String> getListIdentityNumber() {
		List<String> idenNum = new ArrayList<String>();
		for(int i = 0; i < this.listOfPerson.size(); ++i) {
			idenNum.add(this.listOfPerson.get(i).getIdentityNumber());
		}
		return idenNum;
	}
	
	// Getting member by identity number:
	public Person getMemberByIdentityNumber(String idenNum) {
		Person person = null;
		for(int i = 0; i < this.listOfPerson.size(); ++i) {
			if(this.listOfPerson.get(i).getIdentityNumber().equals(idenNum)) {
				person = this.listOfPerson.get(i);
				break;
			}
		}
		return person;
	}
	
	// Getting youngest member:
	public int getMinAgeOfAfamily() {
		int minAge = this.listOfPerson.get(0).getAge();
		for(int i = 0; i < this.listOfPerson.size(); ++i) {
			if(minAge > this.listOfPerson.get(i).getAge()) {
				minAge = this.listOfPerson.get(i).getAge();
			}
		}
		return minAge;
	}
}
