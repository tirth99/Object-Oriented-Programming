import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * This is tester class where we will execute our program.
 */

public class Menu {
	private File reservations;
//	private BufferedWriter bw;
	private BufferedReader br;


	public Menu () throws IOException {
		reservations = new File("C:\\Users\\tirth\\OneDrive\\Desktop\\cs151\\Theater Reservation System\\src\\reservations.txt");
		if(!reservations.exists())
			reservations.createNewFile();
//		bw = new BufferedWriter(new FileWriter(reservations));
//		br = new BufferedReader(new FileReader(reservations));
	}

	public void displayMenu1() throws IOException {

		boolean finished = true;
		do {
			String input;
			String pass;
			System.out.println("Sign [U]p   Sign [I]n   E[X]it");
			Scanner kb = new Scanner(System.in);
			input = kb.nextLine().trim();
			switch (input.toUpperCase()) {
				case "U":
					do {
						new User();
						System.out.println("Enter id: ");
						input = kb.nextLine().trim();
					} while (!User.uniqueID(input));
					User u = new User();
					u.setUserid(input);
					System.out.println(("Enter pass: "));
					pass = kb.nextLine().trim();
					u.setPass(pass);
					u.addNewUser(u);
					break;

				case "I":
					if (User.isEmptyFile())
						break;
					User user = new User(null, null);
					do {
						System.out.println("Enter id: ");
						input = kb.nextLine().trim();
						user.setUserid(input);
					} while (User.checkID(input));
					do {
						System.out.println(("Enter pass: "));
						pass = kb.nextLine().trim();
						user.setPass(pass);
					} while (User.checkPass(input, pass));
					displayMenu2(user);
//					finished = false;
					break;

				case "X":
					finished =false;
					break;

				default:
					System.out.println("Incorrect Input.");
					break;
			}
		} while (finished);
	}

	public void displayMenu2(User user) throws IOException {
		boolean finish = true;
		do {
			String input;
			String type;
			int no;
			System.out.println("[R]eserve    [V]iew    [C]ancel    [O]ut");
			Scanner kb = new Scanner(System.in);
			input = kb.nextLine();
			switch (input.toUpperCase()) {
				case "R":
					booking(user);
					break;

				case "V":
					br = new BufferedReader(new FileReader(reservations));
					String str;
					while((str = br.readLine()) != null) {
						if(str.contains(user.getUserid())) {
							System.out.println(str);
							System.out.println(br.readLine());
						}
					}
					br.close();
					break;

				case "C":
					cancelling(user);
					break;

				case "O":
					finish = false;
					break;

				default:
					System.out.println("Incorrect input");
			}
		} while(finish);
	}
	public void booking(User user) throws IOException {
		Scanner kb = new Scanner(System.in);
		boolean finish = true;
		int no;
		String type;
		String input;
		Seat s = new Seat();
		s.showAvailableSeats();
		System.out.println("Want to reserve: ");
		input = kb.nextLine();
		String[] seats = input.split("\\s+");
		for (int i = 0; i < seats.length; i++) {
			type = seats[i].substring(0, 2);
			no = Integer.parseInt(seats[i].substring(2));
			s.bookTicket(type, no);

		}
		writingToReservations(user.getUserid(), seats);
		Seat.writeIntoFile();
		System.out.println("Want to reserve more tickets? (Y/N)");
		input = kb.nextLine();

		if (input.toUpperCase().equalsIgnoreCase("Y")) {
			booking(user);
		} };

	public void writingToReservations(String userid, String[] seats) throws IOException {

		BufferedWriter bw = new BufferedWriter(new FileWriter(reservations,true));
		br = new BufferedReader(new FileReader(reservations));
		StringBuilder sb = new StringBuilder();
		if(reservations.length() != 0) {
//			File tmp = new File("C:\\Users\\tirth\\OneDrive\\Desktop\\cs151\\Theater Reservation System\\src\\tmp.txt");
//			BufferedWriter tbw = new BufferedWriter(new FileWriter(tmp));
			String currentLine;
			boolean newUser = true;
			while((currentLine = br.readLine()) != null) {
				if(currentLine.contains(userid)) {
					newUser = false;
					String tmpstr;
					while ((tmpstr = br.readLine()).contains("userID:")) {
						for(String str : seats) {
							tmpstr = tmpstr + str +",";
						}
						sb.append(tmpstr);
					}
				}

//				else {
//					sb.append(currentLine);
//					sb.append("\n");
//				}
			}

			if(newUser) {
				sb.append("\n");
				sb.append("userID:"+ userid);
				sb.append("\n");
				for(String as : seats) {
					sb.append(as + ",");
				}
			}
//			tbw.close();
			br.close();
//			reservations = tmp;
			bw.write(sb.toString());
			bw.close();
		}
		else {
			bw.write("userID:"+ userid);
			bw.newLine();
			for(String as : seats) {
				bw.write(as + ",");
			}
			bw.close();
		}
	}

	public void cancelling(User user) throws IOException {
		Scanner kb = new Scanner(System.in);
		String input;
		br = new BufferedReader(new FileReader(reservations));
		String str;
		while((str = br.readLine()) != null) {
			if(str.contains(user.getUserid())) {
				System.out.println(str);
				System.out.println(br.readLine());
			}
		}
		br.close();
		System.out.println("Tickets you want to cancel: ");
		input = kb.nextLine();
		String[] canseats = input.split("\\s+");

		cancellingReservation(user.getUserid(), canseats);
		Seat.writeIntoFile();

	}

	public void cancellingReservation(String userID, String[] canseats) throws IOException {

		Seat s = new Seat();
//		bw = new BufferedWriter(new FileWriter(reservations,true));
		br = new BufferedReader(new FileReader(reservations));
		StringBuilder sb = new StringBuilder();
		if(reservations.length() != 0) {
			String currentLine;
			while((currentLine = br.readLine()) != null) {
				if(currentLine.contains(userID)) {
					sb.append(currentLine);
					sb.append("\n");
					String tmp = br.readLine();
					String type;
					int no;
					Set<String> result = new HashSet<>();
					String[] tmpseats = tmp.split(",");
//					HashSet<String> bookedSeats = Arrays.stream(tmpseats).collect(Collectors.toCollection(HashSet::new));
//					HashSet<String> canceledSeats = Arrays.stream(canseats).collect(Collectors.toCollection(HashSet::new));
//					List<String> resultSeats = bookedSeats.stream().filter(s1 -> !canceledSeats.contains(s1)).collect(Collectors.toList());
//
//					canceledSeats.forEach(s1 -> {
//						try {
//							s.cancelTicket(s1.substring(0,2),Integer.parseInt(s1.substring(2)));
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					});
//					for (String seats : canseats) {
//						for (int i = 0; i < tmpseats.length; i++) {
//							if (!tmpseats[i].equalsIgnoreCase(seats)) {
//								result.add(tmpseats[i]);
//
//							}
//							else {
//								if(result.contains(tmpseats[i])) {
//									result.remove(tmpseats[i]);
//								}
//
//								type = seats.substring(0, 2);
//								no = Integer.parseInt(seats.substring(2));
//								s.cancelTicket(type, no);
//								break;
//							}
//						}
//					}
					for(String str: canseats) {
						tmp = tmp.replace(str+",","");
						type = str.substring(0, 2);
						no = Integer.parseInt(str.substring(2));
						s.cancelTicket(type, no);
						Seat.writeIntoFile();
					}
					sb.append(tmp);
				}
			}
			br.close();
			BufferedWriter bw = new BufferedWriter(new FileWriter(reservations));
			bw.write(sb.toString());
			bw.close();
		}
		else {
			System.out.println("No reservations are made until now.");
		}
	}
}