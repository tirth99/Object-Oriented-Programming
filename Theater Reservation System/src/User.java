import java.io.*;

/**
 * This class registers new user as well as authenticates existing user.
 */

public class User {
	private static File userdata = new File("C:\\Users\\tirth\\OneDrive\\Desktop\\cs151\\Theater Reservation System\\src\\data.txt");
	private BufferedWriter bw = new BufferedWriter(new FileWriter(userdata, true));
	private static BufferedReader br;

	static {
		try {
			br = new BufferedReader(new FileReader(userdata));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private String userid;
	private String pass;

	public User(String userid, String password) throws IOException {
		this.userid = userid;
		this.pass = password;
	}

	public void setUserid(String id) {
		this.userid = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setPass(String password) {
		this.pass = password;
	}

	public String getPass() {
		return pass;
	}
	// This method checks if the id is unique ir not.
	public static boolean uniqueID(String id) throws IOException {
		int lineNum = 0;
		String tmpid;
		br = new BufferedReader(new FileReader(userdata));

		while((tmpid = br.readLine()) != null) {
			lineNum++;
			if(lineNum % 2 != 0 && tmpid.equalsIgnoreCase(id)) {
				System.out.println("ID already taken/exists.");
				br.close();
				return false;
			}
		}
		return true;
	}

	public static boolean checkID(String id) throws IOException {
		int lineNum = 0;
		String tmpid;
		br = new BufferedReader(new FileReader(userdata));

		while((tmpid = br.readLine()) != null) {
			lineNum++;
			if (lineNum % 2 != 0 && tmpid.equalsIgnoreCase(id)) {
				br.close();
				return false;
			}
		}
		System.out.println("ID not found.");
		br.close();
		return true;
	}

	public static boolean checkPass(String id, String pass) throws IOException {
		int lineNum = 0;
		String tmpid;
		String tmppass;
		br = new BufferedReader(new FileReader(userdata));

		while((tmpid = br.readLine()) != null) {
			lineNum++;
			if (lineNum % 2 != 0 && tmpid.equalsIgnoreCase(id)) {
				tmppass = br.readLine();
				if(tmppass.equals(pass))
					return false;
			}
		}
		System.out.println("The password you entered is incorrect.");
		return true;
	}

	public void addNewUser(User user) {
		try {
			bw.write(user.getUserid());
			bw.newLine();
			bw.write(user.getPass());
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static boolean isEmptyFile() throws IOException {
		br = new BufferedReader(new FileReader(userdata));

		return br.readLine() == null;
	}
}

