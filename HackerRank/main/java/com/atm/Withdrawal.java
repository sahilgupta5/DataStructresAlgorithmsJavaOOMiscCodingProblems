package main.java.com.atm;

public class Withdrawal extends Transaction {
	private int amount;

	// initialize constructor
	public Withdrawal(int accountNum, Bank bankData, int amount) {
		super(accountNum, bankData);
		this.amount = amount;
	}

	// check if withdrawal possible
	public boolean isWithdrawalPossible() {
		if (this.amount > this.getBankData().getAvailableBalance(this.getAccountNumber()))
			return false;
		return true;
	}

	@Override
	public void execute() {
		// authenticate user first and then debit
		this.getBankData().debit(this.getAccountNumber(), this.amount);
	}

}
