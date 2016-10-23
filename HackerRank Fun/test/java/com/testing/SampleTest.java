package test.java.com.testing;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import main.java.com.atm.Account;
import main.java.com.atm.BalanceInquiry;
import main.java.com.atm.Bank;
import main.java.com.atm.Deposit;
import main.java.com.atm.Transaction;
import main.java.com.atm.Withdrawal;

public class SampleTest extends TestCase {
	private static Account accounts[];
	Bank bankData;
	Transaction inquiry;
	int amount;
	Transaction deposit;
	Transaction withdraw;

	// Authenticating user
	public boolean authenticate(int accn_no, int pin) {
		return bankData.authenticateUser(accn_no, pin);
	}

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	// Verify print statements
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	public void cleanUpStreams() {
		outContent.reset();
	}

	public void createAccounts() {
		accounts = new Account[3];
		accounts[0] = new Account(101101234, 1244, 50000);
		accounts[1] = new Account(101101345, 2325, 20000);
		accounts[2] = new Account(10233243, 5618, 350000);
		bankData = new Bank(accounts);

	}

	public void testingAuthentication() {
		createAccounts();
		// verify account number
		int accountNum = accounts[2].getAccountNumber();
		assertTrue(accountNum == 10233243);

		// Authnetication must fail as account number is incorrect
		assertFalse(authenticate(101101233, 1244));

		// Authenticaltion must fail as pin is incorrect

		assertFalse(authenticate(101101234, 2244));

		// Authentication must pass
		assertTrue(authenticate(101101234, 1244));

	}

	public void testingCredit() {
		createAccounts();
		deposit = new Deposit(accounts[1].getAccountNumber(), bankData, 200);
		inquiry = new BalanceInquiry(accounts[1].getAccountNumber(), bankData);
		// verify balance after deposit
		setUpStreams();
		deposit.execute();
		inquiry.execute();
		assertEquals(outContent.toString(), "20200\n");
		cleanUpStreams();

	}

	public void testingDebit() {
		createAccounts();
		withdraw = new Withdrawal(accounts[0].getAccountNumber(), bankData, 10000);
		inquiry = new BalanceInquiry(accounts[0].getAccountNumber(), bankData);
		// verify balance after withdraw
		setUpStreams();
		withdraw.execute();
		inquiry.execute();
		assertEquals(outContent.toString(), "40000\n");
		cleanUpStreams();

	}

}
