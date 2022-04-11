// HP 10-1-2021 10h27m

package HotelManager;
import java.io.Serializable;
import java.text.NumberFormat;


public class RoomC extends Room implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public RoomC() {
		super("C", 15);
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String string1 = nf.format(price);
		
		return "RoomC [Cateloty: " + catelory + ", Price per night: " + string1 + "]";
	}
}