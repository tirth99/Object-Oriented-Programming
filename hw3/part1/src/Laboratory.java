import java.util.ArrayList;

public class Laboratory {
	private String sickness;
	private ArrayList<String> allSicknesses;

	public void doTests() {
		System.out.println("Do tests based on doctor's advice.");
	}

	public boolean isFatal(String sickness) {
		System.out.println("Checks if the sickness of the patient is fatal or not by checking the arraylist");
	}
}
