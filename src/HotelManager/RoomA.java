// HP 10-1-2021 10h23m

package HotelManager;
import java.io.Serializable;
import java.text.NumberFormat;

public class RoomA extends Room implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public RoomA() {
		super("A", 50);
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String string1 = nf.format(price);
		
		return "RoomA [Cateloty: " + catelory + ", Price per night: " + string1 + "]";
	}
}
