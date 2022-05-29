package Train_reservations;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class BookSeats {

	static int count = 0;
	String seatno;
	Scanner s = new Scanner(System.in);
	static String[] SSseats = new String[20];
	static ArrayList<String> bookedseats = new ArrayList<String>();
	static ArrayList<String> availableseats = new ArrayList<String>();
	HashMap<String, BookSeats> Ticketslist = new HashMap<String, BookSeats>();

	int age;
	String name;
	char gen;
	String AS, DS, DOJ;

//	Static Block.
//==>>	This static block is created to add the seats List Initially in available seats.
	/*
	 * The main reason to create this in static block is to overcome the Error when
	 * getting Available seats. we can also give this is in method but when we call
	 * the function every time to do a specific action m ultiple times seats list is
	 * added multiple times with duplicated seats.
	 */
	/*
	 * when Given this in static block , this block runs and adds seats and when we
	 * call the available seats we can just get only seats and no need to add seats
	 * in that method so that we can overcome the duplication of keys
	 */

	static {
		for (int i = 0; i < SSseats.length; i++) {
			count = i + 1;
			if (count % 4 == 0 || count % 4 == 1) {
				SSseats[i] = Integer.toString(count);
				availableseats.add(SSseats[i]);
			} else {
				SSseats[i] = Integer.toString(count);
				availableseats.add(SSseats[i]);

			}
		}

	}

// Created two Sitting Seats and Set seat Preferences.

	public void TwoSittingSeats() {

		Map<Character, ArrayList<String>> seatList = new HashMap<Character, ArrayList<String>>();
		seatList.put('W', new ArrayList<String>());
		seatList.put('S', new ArrayList<String>());
		for (int i = 0; i < SSseats.length; i++) {
			count = i + 1;
			if (count % 4 == 0 || count % 4 == 1) {
				seatList.get('W').add(SSseats[i]);
			} else {
				seatList.get('S').add(SSseats[i]);

			}
		}

		System.out.println("All seats in a coach");
		System.out.println("\t-W-" + "\t\t-S-" + "\t\t-S-" + "\t\t-W-");
		for (int i = 0; i < SSseats.length; i++) {
			count = i + 1;
			System.out.print("\t " + SSseats[i] + "\t");
			if (count % 4 == 0) {
				System.out.println();
			}
		}
		System.out.println("window seats are :" + seatList.get('W') + "\n");
		System.out.println("Asile seats are :" + seatList.get('S') + "\n");

	}

// Runtime input to get seats from user

	public void getSeatsfromuser() {
		System.out.println("Please Enter The Seat Number : ");
		seatno = s.next();

		if (availableseats.contains(seatno)) {
			bookSeat(seatno);
		} else {
			System.out.println("1.Entered seat is already booked please select the available seats.");

			getSeatsfromuser();

		}
	}

//	Booking seats for users if seats is available. 
	public void bookSeat(String seatno) {

		if (bookedseats.contains(seatno)) {
			System.out.println("Entered seat is already booked please select the available seats.");

			getSeatsfromuser();

		} else {

			int Iseatno = Integer.parseInt(seatno);

			if (Iseatno > 0 && Iseatno < 21) {
				if (Iseatno % 4 == 0 || Iseatno % 4 == 1) {
					System.out.println("Booked window seat : " + seatno);
					bookedseats.add(seatno);
					availableseats.set((Iseatno - 1), "R");
					getbookedseats();
					getavailableseats();
					Tokengen();

				} else if (Iseatno % 4 == 2 || Iseatno % 4 == 3) {
					System.out.println("Booked Asile Seat : " + seatno);
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

// Getting booked Seats.
	public void getbookedseats() {
		count = bookedseats.size() - 1;
		System.out.println("Booked seat is : " + bookedseats.get(count));

	}

// Getting available Seats.
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

// Parameterized constructor to create the Ticket List.
	public BookSeats(String name, int age, char gen, String AS, String DS, String DOJ, String Seatno) {

		this.name = name;
		this.age = age;
		this.gen = gen;
		this.AS = AS;
		this.DS = DS;
		this.DOJ = DOJ;
		this.seatno = Seatno;

	}
//	Token Generation or Ticket Generation .

	void Tokengen() {
		String a = Character.toString(Reservation_info.ASN.charAt(0));
		String b = Character.toString(Reservation_info.DSN.charAt(0));
		String ID = a + b + seatno;

		System.out.println("-------------------------------------------");

		Ticketslist.put(ID, new BookSeats(Reservation_info.name, Reservation_info.age, Reservation_info.gen,
				Reservation_info.ASN, Reservation_info.DSN, Reservation_info.RD, seatno));
		System.out.println(" TICKET :  " + ID + " \t " + LocalDate.now());

		System.out.println(" Name : " + Ticketslist.get(ID).name + "\t Age : " + Ticketslist.get(ID).age
				+ "\t Gender : " + Ticketslist.get(ID).gen + "\n From : " + Ticketslist.get(ID).AS + "\t To : "
				+ Ticketslist.get(ID).DS + "\n DOJ: " + Ticketslist.get(ID).DOJ);
		System.out.println("-------------------------------------------");

	}

// Getting All Tickets Available .
	public void getAllTickets() {
		System.out.println("List Of All Tickets Which Are Reserved.");
		Set<String> key = Ticketslist.keySet();
		for (String Id : key) {
			System.out.println("Ticket :" + Id + ":\n" + Ticketslist.get(Id).seatno + "\t" + Ticketslist.get(Id).name
					+ "\t" + Ticketslist.get(Id).age + "\t" + Ticketslist.get(Id).AS + "\t" + Ticketslist.get(Id).DS
					+ "\t" + Ticketslist.get(Id).DOJ);
		}
	}

// Cancel Ticket and Remove Ticket/Token from List and also changes seats in available seats and booked seats

	public void cancelTicket() {
		try {
			String CancelTok;
			System.out.println("### Warning ### -->> You are About to Cancel The Ticket ");
			System.out.println("Please Enter your Token Number: ");
			CancelTok = s.next();
			String Cseat = Ticketslist.get(CancelTok).seatno;
			int Iseatno = Integer.parseInt(Cseat);

			availableseats.set((Iseatno - 1), Cseat);
			bookedseats.remove(Cseat);
			System.out.println("Booked seat list: ");
			for (int i = 0; i < bookedseats.size(); i++) {
				System.out.println(bookedseats.get(i));
			}
			System.out.println("Available seat list: ");
			System.out.println("\t-W-" + "\t\t-S-" + "\t\t-S-" + "\t\t-W-");
			for (int i = 0; i < availableseats.size(); i++) {
				System.out.println("\t " + availableseats.get(i) + "\t");
				if (count % 4 == 0) {
					System.out.println();
				}
			}

			Ticketslist.remove(CancelTok);

		} catch (NullPointerException e) {
			System.out.println("Ticket Not Available Please check your Ticket Number and try again.");
			Main_train m = new Main_train();
			m.doFunctionsFor();

		}
	}

//	Default Constructor to avoid errors when creating Instance .
	public BookSeats() {

	}

}