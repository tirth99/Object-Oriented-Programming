/**
 * A Bank Account class with deposit and withdrawal methods
 * along with getter method to operate a bank account.
 */
public class BankAccount {
	public static double currentBalance;

	public BankAccount()
	{
		currentBalance = 0;
	}

	public void deposit(double amount) {
		System.out.println("Depositing " + amount);
		double afterDeposit = currentBalance + amount;
		System.out.println("New balance after depositing is " + afterDeposit);
		currentBalance = afterDeposit;
	}

	public void withdraw(double amount) {
		System.out.println("Withdrawing " + amount);
		double afterWithdraw = currentBalance - amount;
		System.out.println("New balance after withdrawing is " + afterWithdraw);
		currentBalance = afterWithdraw;
	}
}