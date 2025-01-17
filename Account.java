package Final_Project;

public class Account {
	private long numberAccount;
	private String password;
	private double money;
	public Account(long numberAccount, String password, double money) {
		this.numberAccount = numberAccount;
		this.password = password;
		this.money = money;
	}
	public long getNumberAccount() {
		return numberAccount;
	}
	public void setNumberAccount(long numberAccount) {
		this.numberAccount = numberAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}
