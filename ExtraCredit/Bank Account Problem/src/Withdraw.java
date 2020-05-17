/**
 * This class withdraws from bank account.
 */
class Withdraw implements Runnable {
	private BankAccount account;
	private double amount;
	private static final int REPETITIONS = 10;
	private static final int DELAY = 100;

	public Withdraw(BankAccount account, double amount)
	{
		this.account = account;
		this.amount = amount;
	}

	public void run()
	{
		try
		{
			for (int i = 1; i <= REPETITIONS; i++)
			{
				account.withdraw(amount);
				Thread.sleep(DELAY);
			}
		}
		catch (InterruptedException ignored)
		{
		}
	}
}
