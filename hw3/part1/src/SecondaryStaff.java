public class SecondaryStaff extends Employee {
	private int staffID;
	private String name;

	public void reserveAppointment() {
		System.out.println("Reserve patient appointments.");
	}

	public void sellDrugs() {
		System.out.println("Pharmacy selling medicine to patients.");
	}

	public void recievePayment() {
		System.out.println("Receive payment for the hospital bill from patient.");
	}
}
