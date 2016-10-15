package main.java.com.atm;

public class Account {
	private int pin;
	private int accountNum;
	private int currentBalance;

	// initialize constructor
	public Account(int accountNum, int pin, int currentBalance) {
		this.accountNum = accountNum;
		this.currentBalance = currentBalance;
	}

	public boolean validatePin(int pin) {
		return pin == this.pin;
	}

	public int getAccountNumber() {
		return accountNum;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void credit(int amount) {
		currentBalance += amount;
	}

	public void debit(int amount) {
		currentBalance -= amount;
	}
}
