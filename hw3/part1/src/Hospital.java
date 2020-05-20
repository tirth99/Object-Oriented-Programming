import java.util.ArrayList;

public class Hospital {
	private ArrayList<Patient> patients;
	private String name;

	public void giveSalary() {
		System.out.println("Gives salary to all the employees");
	}

	public void addPatient(Patient p) {
		System.out.println("Add the patient into hospital system");
	}
	public void dischargePatient(Patient p) {
		System.out.println("Removes the particular patient from hospital system");
	}

	public String getName() {
		System.out.println("Returns the name of hospital");
	}

	public ArrayList<Patient> getPatients() {
		System.out.println(("Returns all the patients in the hospital"));
	}
}
