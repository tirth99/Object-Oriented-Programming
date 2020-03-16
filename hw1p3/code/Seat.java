import java.io.*;
import java.time.LocalDateTime;

/**
 * Manages seats and rows and their reservation.
 */

public class Seat {
	private String seatType;
	private int seatNumber;
	private static int[] mainFloor = new int[150];
	private static int[] southBalcony = new int[50];
	private static int[] westBalcony = new int[100];
	private static int[] eastBalcony = new int[100];
	private static File mf;
	private static File sb;
	private static File wb;
	private static File eb;
	private static BufferedWriter bw;
	private static BufferedReader br;

	public Seat() throws IOException {
		mf = new File("C:\\Users\\tirth\\OneDrive\\Desktop\\cs151\\Theater Reservation System\\src\\mfseats.txt");
		if (!mf.exists()) {
			mf.createNewFile();
		}
		sb = new File("C:\\Users\\tirth\\OneDrive\\Desktop\\cs151\\Theater Reservation System\\src\\sbseats.txt");
		sb.createNewFile();
		wb = new File("C:\\Users\\tirth\\OneDrive\\Desktop\\cs151\\Theater Reservation System\\src\\wbseats.txt");
		wb.createNewFile();
		eb = new File("C:\\Users\\tirth\\OneDrive\\Desktop\\cs151\\Theater Reservation System\\src\\ebseats.txt");
		eb.createNewFile();
	}

	public Seat(String type, int number) {
		this.seatType = type;
		this.seatNumber = number;
	}

	public static void retrieveMfReservations() throws FileNotFoundException, IOException {
		br = new BufferedReader(new FileReader(mf));
		String tmp;
		int lineNum = 0;

		while((tmp = br.readLine()) != null) {
			mainFloor[lineNum++] = Integer.parseInt(tmp);
		}
		br.close();
	}

	public static void retrieveSbReservations() throws IOException {
		br = new BufferedReader(new FileReader(sb));
		String tmp;
		int lineNum = 0;

		while ((tmp = br.readLine()) != null) {
			southBalcony[lineNum++] = Integer.parseInt(tmp);
		}
		br.close();
	}
	public static void retrieveWbReservations() throws IOException {
		br = new BufferedReader(new FileReader(wb));
		String tmp;
		int lineNum = 0;

		while ((tmp = br.readLine()) != null) {
			westBalcony[lineNum++] = Integer.parseInt(tmp);
		}
		br.close();
	}
	public static void retrieveEbReservations() throws IOException {
		br = new BufferedReader(new FileReader(eb));
		String tmp;
		int lineNum = 0;

		while ((tmp = br.readLine()) != null) {
			eastBalcony[lineNum++] = Integer.parseInt(tmp);
		}
		br.close();
	}


	public void setSeatType(String type) {
		if(type.equalsIgnoreCase("mf"))
			seatType = "Main Floor";
		if(type.equalsIgnoreCase("sb"))
			seatType = "South Balcony";
		if(type.equalsIgnoreCase("wb"))
			seatType = "West Balcony";
		if(type.equalsIgnoreCase("eb"))
			seatType = "East Balcony";
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatNumber(int no) {
		this.seatNumber = no;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void bookTicket(String type, int no) {

		if (isCorrectArgument(type, no) && isNotReserved(type, no)) {

			if (type.equalsIgnoreCase("mf"))
				mainFloor[no - 1] = 1;
			else if (type.equalsIgnoreCase("sb"))
				southBalcony[no - 1] = 1;
			else if (type.equalsIgnoreCase("wb"))
				westBalcony[no - 1] = 1;
			else if (type.equalsIgnoreCase("eb"))
				eastBalcony[no - 1] = 1;
		}
	}

	public void cancelTicket(String type, int no) throws IOException {
		retrieveMfReservations();
		retrieveSbReservations();
		retrieveWbReservations();
		retrieveEbReservations();
		if (isCorrectArgument(type, no) && isReserved(type, no)) {

			if (type.equalsIgnoreCase("mf"))
				mainFloor[no - 1] = 0;
			else if (type.equalsIgnoreCase("sb"))
				southBalcony[no - 1] = 0;
			else if (type.equalsIgnoreCase("wb"))
				westBalcony[no - 1] = 0;
			else if (type.equalsIgnoreCase("eb"))
				eastBalcony[no - 1] = 0;
		}
	}

	public void showAvailableSeats() throws IOException {
		retrieveMfReservations();
		System.out.println("Main Floor: ");
		for(int i = 0; i < mainFloor.length; i++) {
			if(mainFloor[i] == 0)
				System.out.print((i+1) + " ");
		}
		retrieveSbReservations();
		System.out.println();
		System.out.println("South Balcony: ");
		for(int i = 0; i < southBalcony.length; i++) {
			if(southBalcony[i] == 0)
				System.out.print((i+1) + " ");
		}
		retrieveWbReservations();
		System.out.println();
		System.out.println("West Balcony: ");
		for(int i = 0; i < westBalcony.length; i++) {
			if(westBalcony[i] == 0)
				System.out.print((i+1) + " ");
		}
		retrieveEbReservations();
		System.out.println();
		System.out.println("East Balcony: ");
		for(int i = 0; i < eastBalcony.length; i++) {
			if(eastBalcony[i] == 0)
				System.out.print((i+1) + " ");
		}
		System.out.println();
	}
	public boolean isNotReserved(String type, int no) {

		if(type.equalsIgnoreCase("mf") && mainFloor[no-1] == 0)
		  	return true;
		else if(type.equalsIgnoreCase("sb") && southBalcony[no-1] == 0)
			return true;
		else if(type.equalsIgnoreCase("wb") && westBalcony[no-1] == 0)
			return true;
		else if(type.equalsIgnoreCase("eb") && eastBalcony[no-1] == 0)
			return true;
		else
			System.out.println("Seat is already reserved by someone else.");
			return false;
	}
	public boolean isReserved(String type, int no) {

		if(type.equalsIgnoreCase("mf") && mainFloor[no-1] == 1)
			return true;
		else if(type.equalsIgnoreCase("sb") && southBalcony[no-1] == 1)
			return true;
		else if(type.equalsIgnoreCase("wb") && westBalcony[no-1] == 1)
			return true;
		else if(type.equalsIgnoreCase("eb") && eastBalcony[no-1] == 1)
			return true;
		else
			System.out.println("Ticket is not reserved by anyone.");
			return false;
	}
	public boolean isCorrectArgument(String type, int no) {

		if(type.equalsIgnoreCase("mf") && (no >= 1 && no <= 150))
			return true;
		else if(type.equalsIgnoreCase("sb") && (no >= 1 && no <= 50))
			return true;
		else if(type.equalsIgnoreCase("wb") && (no >= 1 && no <= 100))
			return true;
		else if(type.equalsIgnoreCase("eb") && (no >= 1 && no <= 100))
			return true;
		else
			System.out.println("Ticket type/no " + type + no + " is incorrect.");
			return false;
	}

	public static void writeIntoFile() throws IOException {

//		br = new BufferedReader(new FileReader(mf));
//		bw = new BufferedWriter(new FileWriter(mf));
//		if(mf.length() != 0) {
//			String currentLine;
//			if((currentLine = br.readLine()))
//		}
//
//		br= new BufferedReader(new FileReader(mf));
//		String abc= br.readLine();
//		LocalDateTime localDateTime1 = LocalDateTime.parse(abc);
//		localDateTime1.equals(localDateTime);
		bw = new BufferedWriter(new FileWriter(mf));
		for(int i = 0; i < mainFloor.length; i++) {
			bw.write(String.valueOf(mainFloor[i]));
			bw.newLine();
		}
		bw.close();
		bw = new BufferedWriter(new FileWriter(sb));
		for(int i = 0; i < southBalcony.length; i++) {
			bw.write(String.valueOf(southBalcony[i]));
			bw.newLine();
		}
		bw.close();
		bw = new BufferedWriter(new FileWriter(wb));
		for(int i = 0; i < westBalcony.length; i++) {
			bw.write(String.valueOf(westBalcony[i]));
			bw.newLine();
		}
		bw.close();
		bw = new BufferedWriter(new FileWriter(eb));
		for(int i = 0; i < eastBalcony.length; i++) {
			bw.write(String.valueOf(eastBalcony[i]));
			bw.newLine();
		}
		bw.close();
	}
}
