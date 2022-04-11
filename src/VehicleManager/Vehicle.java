// HP 28-12-2021 16h09m

package VehicleManager;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nameOfOwner;
	private String manufacturer;
	private int capacity;
	private double price;
	private Date dateOfManufacture;
	
	public Vehicle(String id, String nameOfOwner, String manufacturer, int capacity,
			       double price, Date dateOfManufacture) {
		this.id = id;
		this.nameOfOwner = nameOfOwner;
		this.manufacturer = manufacturer;
		this.capacity = capacity;
		this.price = price;
		this.dateOfManufacture = dateOfManufacture;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNameOfOwner() {
		return nameOfOwner;
	}
	public void setNameOfOwner(String nameOfOwner) {
		this.nameOfOwner = nameOfOwner;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}
	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String string1 = nf.format(price);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String string2 = sdf.format(dateOfManufacture);
		
		return "Vehicle [ID: " + id
				+ ", Owner: " + nameOfOwner
				+ ", Manufacturer: " + manufacturer
				+ ", Capacity: " + capacity
				+ ", Price: " + string1
				+ ", Date of manufacture: " + string2 + "]";
	}
}
