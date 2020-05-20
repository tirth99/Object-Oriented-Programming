public class Doctor extends Employee {
	private int docID;
	private String name;
	private String dept; //Department that doctor belongs to - Physio, Cardiology// , etc

	public void doCheckup() {
		System.out.println("Checks the patient for potential sickness");
	}

	public void doSurgery() {
		System.out.println("Does surgery if needed.");
	}

	public void prescribeMedicine() {
		System.out.println("Prescribe necessary medicine based on illness.");
	}

	public void prescribeTests() {
		System.out.println("Tells patient to do certain lab tests for potential sickness.");
	}
}
