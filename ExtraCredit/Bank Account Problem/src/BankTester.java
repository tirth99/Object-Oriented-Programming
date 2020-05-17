import java.util.Random;

/**
 * This tester class runs two threads that deposit and withdraw
 * from the same bank account
 */
public class BankTester {
	public static void main(String[] args) {
		BankAccount account = new BankAccount();

		Deposit deposit = new Deposit(account, 100);
		Withdraw withdraw = new Withdraw(account, 100);

		Thread t1 = new Thread(deposit);
		Thread t2 = new Thread(withdraw);

		t1.start();
		t2.start();
	}
}