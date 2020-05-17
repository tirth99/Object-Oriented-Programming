/**
 * This class makes deposit to bank account
 */
class Deposit implements Runnable {
	private BankAccount depositAccount;
	private double depositAmount;
	private static final int REPETITIONS = 10;
	private static final int DELAY = 100;

	public Deposit(BankAccount account, double amount) {
		depositAccount = account;
		depositAmount = amount;
	}

	public void run() {
		try {
			for (int i = 1; i <= REPETITIONS; i++) {
				depositAccount.deposit(depositAmount);
				Thread.sleep(DELAY);
			}
		}
		catch (InterruptedException ignored) {
		}
	}
}