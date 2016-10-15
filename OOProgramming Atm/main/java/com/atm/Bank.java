package main.java.com.atm;

public class Bank {
	private Account[] accounts;

	// initialize constructor
	public Bank(Account accounts[]) {
		this.accounts = accounts;
	}

	// return the account for the corresponding account number
	private Account getAccount(int accountNum) {
		return accounts[accountNum];
	}

	public boolean authenticateUser(int pin, int accountNum) {
		return getAccount(accountNum).validatePin(pin);
	}

	public int getAvailableBalance(int accountNum) {
		return getAccount(accountNum).getCurrentBalance();
	}

	public void credit(int accountNum, int amount) {
		getAccount(accountNum).credit(amount);
	}

	public void debit(int accountNum, int amount) {
		getAccount(accountNum).debit(amount);
	}
}
