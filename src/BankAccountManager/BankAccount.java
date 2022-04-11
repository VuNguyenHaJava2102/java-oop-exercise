// HP 5-1-2022 9h43m

package BankAccountManager;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String account;
	private String password;
	private String nameUser;
	private double accountBalance;
	private Date createdTime;
	private String id;
	
	public BankAccount(String account, String password, String nameUser,
			           double accountBalance, Date createdTime, String id) {
		this.account = account;
		this.password = password;
		this.nameUser = nameUser;
		this.accountBalance = accountBalance;
		this.createdTime = createdTime;
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

	@Override
	public String toString() {
		return "BankAccount [account=" + account
				+ ", password=" + password
				+ ", nameUser=" + nameUser
				+ ", accountBalance=" + accountBalance
				+ ", id=" + id + "]";
	}

	public void display() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String balance = nf.format(accountBalance);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");
		String time = sdf.format(createdTime);
		
		System.out.printf("%-10s %-20s %-15s %-20s %-20s %-15s\n",
				id, account, password, nameUser, balance, time);	
	}
}
