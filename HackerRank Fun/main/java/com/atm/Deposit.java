package main.java.com.atm;

public class Deposit extends Transaction {
	private int amount;

	public Deposit(int accountNum, Bank bankData, int amount) {
		super(accountNum, bankData);
		this.amount = amount;
	}

	@Override
	public void execute() {

		// authenticate user first and then debit
		this.getBankData().credit(this.getAccountNumber(), this.amount);

	}

}
