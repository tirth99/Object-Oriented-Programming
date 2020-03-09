import java.util.*;
import java.io.*;

/**
 * This is tester class where we will execute our program.
 */

public class Main {
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.displayMenu1();
	}

	public void displayMenu1() throws IOException {

		boolean finished = true;
		do {
			String input;
			String pass;
			System.out.println("Sign [U]p   Sign [I]n   E[X]it");
			Scanner kb = new Scanner(System.in);
			input = kb.nextLine();
			switch (input.toUpperCase()) {
				case "U":
					do {
						System.out.println("Enter id: ");
						input = kb.nextLine();
					} while (!User.uniqueID(input));
					System.out.println(("Enter pass: "));
					pass = kb.nextLine();
					User u = new User(input, pass);
					u.addNewUser(u);
					finished = false;
					break;

				case "I":
					if(User.isEmptyFile())
						break;
					do {
						System.out.println("Enter id: ");
						input = kb.nextLine();
					} while (User.checkID(input));
					do {
						System.out.println(("Enter pass: "));
						pass = kb.nextLine();
					} while (User.checkPass(input, pass));
					finished = false;
					break;

				case "X":
					System.exit(0);

				default:
					throw new IllegalArgumentException("Incorrect Input.");
			}
		}while (finished);
	}
	public void displayMenu2 {
		
	}
}