public class Nurse extends Employee {
	private int nurseID;
	private String name;

	public void routineObservations() {
		System.out.println("Do routine check on patients making sure they are fine.");
	}

	public void helpSurgery() {
		System.out.println("Help doctor during surgery.");
	}
}
