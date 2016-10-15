package main.java.com.atm;

public abstract class Transaction {

	private int accountNum;
	private Bank bankData;

	// initilize constructor
	public Transaction(int accountNum, Bank bankData) {
		this.accountNum = accountNum;
		this.bankData = bankData;
	}

	abstract public void execute();

	public int getAccountNumber() {
		return accountNum;
	}

	public Bank getBankData() {
		return bankData;
	}

}
