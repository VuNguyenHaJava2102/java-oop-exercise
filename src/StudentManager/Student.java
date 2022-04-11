// HP 27-12-2021 18h04m

package StudentManager;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private Date birthday;
	private String sex;
	private String address;
	private Mark mark;
	
	public Student(String id, String name, Date birthday, String sex, String address, Mark mark) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
		this.mark = mark;
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

	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Mark getMark() {
		return mark;
	}
	public void setMark(Mark mark) {
		this.mark = mark;
	}
//  ----------------------------------------------------------------------------
	// Getting average mark:
		public double getAverageMark() {
			return (this.mark.getMath() + this.mark.getPhysics()
			      + this.mark.getChemistry() + this.mark.getEnglish()) / 4;
		}
		
		public double getMathMark() {
			return this.mark.getMath();
		}
		
		public double getPhysicsMark() {
			return this.mark.getPhysics();
		}
		
		public double getChemistryMark() {
			return this.mark.getChemistry();
		}
		
		public double getEnglishMark() {
			return this.mark.getEnglish();
		}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String string1 = sdf.format(birthday);
		
		return "Student [ID: " + id
				+ ", Name: " + name
				+ ", Birthday: " + string1
				+ ", Sex: " + sex
				+ ", Address: " + address + "]"
				+ "\n" + mark;
	}
	
	public void displayInformationOfStudent() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String string1 = sdf.format(birthday);
		
		System.out.printf("%-8s %-20s %-15s %-10s %s\n", id, name, string1, sex, address);
	}
	
	public void displayMarkOfStudent() {
		mark.displayMark();
	}
}
