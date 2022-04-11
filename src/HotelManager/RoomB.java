// HP 10-1-2021 10h26m

package HotelManager;
import java.io.Serializable;
import java.text.NumberFormat;

public class RoomB extends Room implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public RoomB() {
		super("B", 30);
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String string1 = nf.format(price);
		
		return "RoomB [Cateloty: " + catelory + ", Price per night: " + string1 + "]";
	}
}