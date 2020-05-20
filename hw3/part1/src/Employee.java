public class Employee implements Unique {
	private int employeeID;
	private String name;
	private int salary;

	public int getID() {
		System.out.println("Returns the unique ID of the employee");
	}

	public void setID(int ID) {
		System.out.println("Change ID if needed");
	}

	public String getName() {
		System.out.println("Returns the name of employee");
	}

	public int getSalary() {
		System.out.println("Returns the salary of the employee");
	}
}
