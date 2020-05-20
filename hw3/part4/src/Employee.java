import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee implements Cloneable {

	private int id;
	private String name;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Employee clone() {
		try {
			Employee cloned = (Employee) super.clone();
			return cloned;
		} catch (CloneNotSupportedException e) {
			return null; // won't happen
		}
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static ArrayList<Employee> clone(ArrayList<Employee> list){

		ArrayList<Employee> clonedList = new ArrayList<>();
		for(Employee employee : list) {
			clonedList.add(employee.clone());
		}
		return clonedList;
	}

	public static class EmployeeComparator implements Comparator<Employee> {
		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}

	public static void main(String[] args){

		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee((int) (Math.random() * 100), "Mikaela"));
		employeeList.add(new Employee((int) (Math.random() * 100), "Savannah"));
		employeeList.add(new Employee((int) (Math.random() * 100), "Aaren"));

		System.out.println("\nOriginal ArrayList of Unsorted Employees: ");
		for(Employee e : employeeList) {
			System.out.println("Employee ID: " + e.getId() + "		Employee Name: " + e.getName());
		}

		ArrayList<Employee> clonedList = clone(employeeList);
		System.out.println("\nCloned ArrayList of Unsorted Employees: ");
		for(Employee e : clonedList) {
			System.out.println("Employee ID: " + e.getId() + "		Employee Name: " + e.getName());
		}

		Collections.sort(clonedList, new EmployeeComparator());
		System.out.println("\nCloned ArrayList of Employees after sorting: ");
		for(Employee e : clonedList) {
			System.out.println("Employee ID: " + e.getId() + "		Employee Name: " + e.getName());
		}
	}
}