package main.java.com.atm;

public class Bank {
	private Account[] accounts;

	// initialize constructor
	public Bank(Account accounts[]) {
		this.accounts = accounts;
	}

	// return the account for the corresponding account number
	private Account getAccount(int accountNum) {
		for (Account a : accounts) {
			if (a.getAccountNumber() == accountNum)
				return a;
		}
		return null;
	}

	public boolean authenticateUser(int accountNum, int pin) {
		Account a = getAccount(accountNum);
		if (a == null) {
			return false;
		}
		return a.validatePin(pin);
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
