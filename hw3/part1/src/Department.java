/**
 * Different hospital departments with designated doctors.
 */

public class Department {
	private int deptID;
	private String deptName;

	public void addDept(String dept) {
		System.out.println("Different department of hospital.");
	}

	public void removeDept(String dept) {
		System.out.println("Remove certain department if not useful.");
	}

	public void addDoctor(Doctor doc) {
		System.out.println("Add a doctor to the particular department/specialty");
	}

	public void removeDoctor(Doctor doc) {
		System.out.println("Remove the doctor from that department.");
	}
}
