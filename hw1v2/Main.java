import javax.jws.soap.SOAPBinding;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Menu menu = new Menu();
		User user = new User();
		menu.displayMenu1();
//		menu.displayMenu2(user);
	}
}
