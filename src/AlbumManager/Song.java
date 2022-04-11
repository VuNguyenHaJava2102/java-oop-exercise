// HP 1-1-2022 17h48

package AlbumManager;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Song implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String singer;
	private double price;
	private Date releaseDate;
	private long views;
	
	public Song(String id, String name, String singer, double price, Date releaseDate, long views) {
		this.id = id;
		this.name = name;
		this.singer = singer;
		this.price = price;
		this.releaseDate = releaseDate;
		this.views = views;
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

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public long getViews() {
		return views;
	}

	public void setViews(long views) {
		this.views = views;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String string1 = nf.format(price);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String string2 = sdf.format(releaseDate);
		
		return "Album [ID: " + id
				+ ", Name: " + name
			    + ", Singer: " + singer
			    + ", Price: " + string1
			    + ", Release date: " + string2
			    + ", Views: " + views + "]";
	}
	
	public void display() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String string1 = nf.format(price);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String string2 = sdf.format(releaseDate);
		
		DecimalFormat df = new DecimalFormat("#,###");
		String string3 = df.format(views);
		
		System.out.printf("%-25s %-25s %-15s %-10s %-15s %s\n", id, name, singer, string1, string2, string3);
	}
}