// HP 7-1-2022 21h07m

package CommodityManager;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Commodity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private int quantity;
	private double unitPrice;
	private Date dateOfManufacture;
	private Date dateOfExpiration;
	public Commodity(String id, String name, int quantity, double unitPrice,
			         Date dateOfManufacture, Date dateOfExpiration) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.dateOfManufacture = dateOfManufacture;
		this.dateOfExpiration = dateOfExpiration;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}
	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}
	public Date getDateOfExpiration() {
		return dateOfExpiration;
	}
	public void setDateOfExpiration(Date dateOfExpiration) {
		this.dateOfExpiration = dateOfExpiration;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Commodity [id=" + id
				+ ", name=" + name
				+ ", quantity=" + quantity
				+ ", unitPrice=" + unitPrice
				+ ", dateOfManufacture=" + dateOfManufacture
				+ ", dateOfExpiration=" + dateOfExpiration + "]";
	}
	
	public void displayInformation() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String string1 = sdf.format(dateOfManufacture);
		String string2 = sdf.format(dateOfExpiration);
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String string3 = nf.format(unitPrice);
		
		System.out.printf("%-10s %-20s %-10d %-15s %-20s %s\n", id, name, quantity,
				string3, string1, string2);
	}
	
	public double getTotalPrice() {
		return this.unitPrice * this.quantity;
	}
}
