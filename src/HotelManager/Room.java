// HP 10-1-2021 10h15m

package HotelManager;
import java.io.Serializable;

public class Room implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected String catelory;
	protected double price;
	
	public Room(String catelory, double price) {
		this.catelory = catelory;
		this.price = price;
	}
	
	public Room() {
	}

	public String getCatelory() {
		return catelory;
	}

	public void setCatelory(String catelory) {
		this.catelory = catelory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
