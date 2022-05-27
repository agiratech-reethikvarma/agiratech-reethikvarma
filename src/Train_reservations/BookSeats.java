package Train_reservations;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

public class BookSeats {
	BookSeats() {
		

	}

	Scanner s = new Scanner(System.in);
	static int count = 0;
	String seatno;
	static String[] SSseats = new String[20];
	static ArrayList<String> bookedseats = new ArrayList<String>();
	static ArrayList<String> availableseats = new ArrayList<String>();

	HashMap<String, BookSeats> Ticketslist = new HashMap<String, BookSeats>();

	public void  ticketreserve(){

		Map<Character, ArrayList<String>> seatList = new HashMap<Character, ArrayList<String>>();
		seatList.put('W', new ArrayList<String>());
		seatList.put('S', new ArrayList<String>());
		for (int i = 0; i < SSseats.length; i++) {
			count = i + 1;
			if (count % 4 == 0 || count % 4 == 1) {
				SSseats[i] = Integer.toString(count);
				seatList.get('W').add(SSseats[i]);
				availableseats.add(SSseats[i]);
			} else {
				SSseats[i] = Integer.toString(count);
				seatList.get('S').add(SSseats[i]);
				availableseats.add(SSseats[i]);

			}
		}
		System.out.println("window seats are :" + seatList.get('W') + "\n");
		System.out.println("Asile seats are :" + seatList.get('S') + "\n");

	}

// Get seats from user and bookes the ticket

	public void bookSeat(String seatno) {

		if (bookedseats.contains(seatno)) {
			System.out.println("Entered seat is already booked please select the available seats.");

			getSeatsfromuser();

		} else {

			int Iseatno = Integer.parseInt(seatno);

			if (Iseatno > 0 && Iseatno < 21) {
				if (Iseatno % 4 == 0 || Iseatno % 4 == 1) {
					System.out.println("Booked window seat:" + seatno);
					bookedseats.add(seatno);
					availableseats.set((Iseatno - 1), "R");
					getbookedseats();
					getavailableseats();
					Tokengen();

				} else if (Iseatno % 4 == 2 || Iseatno % 4 == 3) {
					System.out.println("Booked Asile Seat:" + seatno);
					bookedseats.add(seatno);
					availableseats.set((Iseatno - 1), "R");
					getbookedseats();
					getavailableseats();
					Tokengen();
				} else {
					System.out.println("There are no available seats.");
				}

			} else {
				System.out.println("Please enter the seat number correctly");
			}

		}

	}

// Checking book seat in arraylist
	public void getbookedseats() {
		count = bookedseats.size() - 1;
		System.out.println("Booked seat is : " + bookedseats.get(count));

	}

//Runtime input to get seats from user
	public void getSeatsfromuser() {

		System.out.println("Enter the seat Number : ");
		seatno = s.nextLine();
		if (availableseats.contains(seatno)) {
			bookSeat(seatno);
		} else {
			System.out.println("1.Entered seat is already booked please select the available seats.");

			getSeatsfromuser();

		}
	}

	public void getavailableseats() {

		System.out.println("Available seats are :\n\t-W-\t-S-\t-S-\t-W-");
		for (int i = 0; i < availableseats.size(); i++) {
			count = i + 1;
			System.out.print("\t " + availableseats.get(i));
			if (count % 4 == 0) {
				System.out.println();
			}
		}

	}

//	public static void main(String[] args) {
//		BookSeats s = new BookSeats();
////		s.TwoSittingSeats();
////		s.getavailableseats();
////		s.getSeatsfromuser();
//		s.Tokengen();
//
//	}

//	Creating Seats for 2Sitting and set Preferences.

	public void TwoSittingSeats() {

		System.out.println("All seats in a coach");
		System.out.println("\t-W-" + "\t\t-S-" + "\t\t-S-" + "\t\t-W-");
		for (int i = 0; i < SSseats.length; i++) {
			count = i + 1;
			System.out.print("\t " + count + "\t");
			if (count % 4 == 0) {
				System.out.println();
			}
		}

	}

//	static ArrayList<BookSeats> tokens = new ArrayList<BookSeats>();

	int age;
	String name;
	char gen;
	String AS, DS;
	String DOJ;

	public BookSeats(String name, int age, char gen, String AS, String DS, String DOJ, String Seatno) {

		this.name = name;
		this.age = age;
		this.gen = gen;
		this.AS = AS;
		this.DS = DS;
		this.DOJ = DOJ;
		this.seatno = Seatno;

	}

	void Tokengen() {
//		Reservation_info r=new Reservation_info();

		String a = Character.toString(Reservation_info.ASN.charAt(0));
		String b = Character.toString(Reservation_info.DSN.charAt(0));

		String ID = a + b + seatno;

		System.out.println(ID);

		Ticketslist.put(ID, new BookSeats(Reservation_info.name, Reservation_info.age, Reservation_info.gen,
				Reservation_info.ASN, Reservation_info.DSN, Reservation_info.RD, seatno));

		System.out.println(Ticketslist.get(ID).name + "/" + Ticketslist.get(ID).age + "/" + Ticketslist.get(ID).AS + "/"
				+ Ticketslist.get(ID).DS + "/" + Ticketslist.get(ID).DOJ);

//			convert the DOJ to LocalDate formate because it is in String formate.
//		for (int i = 0; i < tokens.size(); i++) {
//			System.out.println(tokens.get(i));
//		}
	}

	public void getAllTickets() {
		System.out.println("List Of All Tickets Which Are Reserved.");
		Set<String> key = Ticketslist.keySet();
		for (String Id : key) {
			System.out.println("Ticket :" + Id + ":\n" + Ticketslist.get(Id).seatno + "\t" + Ticketslist.get(Id).name
					+ "\t" + Ticketslist.get(Id).age + "\t" + Ticketslist.get(Id).AS + "\t" + Ticketslist.get(Id).DS
					+ "\t" + Ticketslist.get(Id).DOJ);
		}

	}

	public void cancelTicket() {

		String CancelTok;
		System.out.println("### Warning ### -->> You are About to Cancel The Ticket ");
		System.out.println("Please Enter your Token Number: ");
		CancelTok = s.next();
		int Iseatno = Integer.parseInt(CancelTok);

		String Cseat = Ticketslist.get(CancelTok).seatno;
		availableseats.set((Iseatno - 1), Cseat);
		bookedseats.remove(Cseat);
		System.out.println("Booked seat list: ");
		for (int i = 0; i < bookedseats.size(); i++) {
			System.out.println(bookedseats.get(i));
		}
		System.out.println("Available seat list: ");
		for (int i = 0; i < availableseats.size(); i++) {
			System.out.println(availableseats.get(i));
		}
	

		Ticketslist.remove(CancelTok);

	}

}
