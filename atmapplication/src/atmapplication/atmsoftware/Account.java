package atmapplication.atmsoftware;

public class Account {
	private String username;
    private String location;
    private String accountNumber;
    private String pin;
    private double balance;
    
    public Account(String username, String location, String accountNumber, String pin, double balance) {
        this.username = username;
        this.location = location;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }
    
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
    

}
