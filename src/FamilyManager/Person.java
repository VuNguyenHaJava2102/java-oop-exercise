// HP 6-1-2022 10h25m

package FamilyManager;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private Date birthday;
	private String sex;
	private String job;
	private String identityNumber;
	
	public Person(String name, Date birthday, String sex, String job, String identityNumber) {
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.job = job;
		this.identityNumber = identityNumber;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	@Override
	public String toString() {
		return "Person [name=" + name
				+ ", birthday=" + birthday
				+ ", sex=" + sex
				+ ", job=" + job
				+ ", identityNumber=" + identityNumber + "]";
	}
	
	public void displayInformation() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String dateOfBirth = sdf.format(birthday);
		
		System.out.printf("%-20s %-15s %-10s %-15s %s\n", name, dateOfBirth, sex, job, identityNumber);
	}
	
	public int getAge() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		
		String string = sdf.format(birthday).substring(6, 10);
		int age = 2022 - Integer.parseInt(string);
		return age;
	}
}
