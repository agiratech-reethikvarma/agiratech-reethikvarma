package Train_reservations;

import java.util.Scanner;
import java.util.Set;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookSeats {
	static int Book_Trainno;
	static int count = 0;
	String seatno;

	int Age, Train_no;
	String Name;
	char Gender;
	String Arraival_Station, Destination_Station, Train_Name;
	LocalDate Date_of_Journey;

	Scanner s = new Scanner(System.in);

	ArrayList<String> bookedseats = new ArrayList<String>();
	List<String> BO_availableseats = new ArrayList<>();
	static HashMap<String, BookSeats> Ticketslist = new HashMap<String, BookSeats>();

// Created two Sitting all_Seats_List and Set seat Preferences.

	/*
	 * public void TwoSittingSeats() {
	 * 
	 * Map<Character, ArrayList<String>> seatList = new HashMap<Character,
	 * ArrayList<String>>(); seatList.put('W', new ArrayList<String>());
	 * seatList.put('S', new ArrayList<String>()); for (int i = 0; i <
	 * Train_info.SSseats.length; i++) { count = i + 1; if (count % 4 == 0 || count
	 * % 4 == 1) { seatList.get('W').add(Train_info.SSseats[i]); } else {
	 * seatList.get('S').add(Train_info.SSseats[i]);
	 * 
	 * } }
	 * 
	 * System.out.println("All seats in a coach"); System.out.println("\t-W-" +
	 * "\t\t-S-" + "\t\t-S-" + "\t\t-W-"); for (int i = 0; i <
	 * Train_info.SSseats.length; i++) { count = i + 1; System.out.print("\t " +
	 * Train_info.SSseats[i] + "\t"); if (count % 4 == 0) { System.out.println(); }
	 * } System.out.println("window seats are :" + seatList.get('W') + "\n");
	 * System.out.println("Asile seats are :" + seatList.get('S') + "\n");
	 * 
	 * }
	 */

// Runtime input to get seats from user

	public void Get_SeatNo_To_Book(int To_Book_TrainNo) {
		Book_Trainno = To_Book_TrainNo;
		System.out.println("Please Enter The Seat Number : ");
		seatno = s.next();
		BO_availableseats = new ArrayList<>(Train_info.all_Seats_List.get(Book_Trainno));
		if (BO_availableseats.contains(seatno)) {
			Booking_Seat(seatno);
		} else {
			System.out.println(" Entered seat is already booked please select the available seats.");
			Get_SeatNo_To_Book(Book_Trainno);
		}
	}

//	Booking seats for users if seats is available. 
	public void Booking_Seat(String seatno) {

		if (bookedseats.contains(seatno)) {
			System.out.println("Entered seat is already booked please select the available seats.");

			Get_SeatNo_To_Book(Book_Trainno);

		} else {

			int Iseatno = Integer.parseInt(seatno);

			if (Iseatno > 0 && Iseatno < 5) {
				if (Iseatno % 4 == 0 || Iseatno % 4 == 1) {
					System.out.println("Booked window seat : " + seatno);
					bookedseats.add(seatno);
					BO_availableseats.set((Iseatno - 1), "R");
					Train_info.all_Seats_List.get(Book_Trainno).set(Iseatno - 1, "R");
					Get_Booked_Seats();
					Get_Available_Seats();
					Ticket_Generate();

				} else if (Iseatno % 4 == 2 || Iseatno % 4 == 3) {
					System.out.println("Booked Asile Seat : " + seatno);
					bookedseats.add(seatno);
					BO_availableseats.set((Iseatno - 1), "R");
					Train_info.all_Seats_List.get(Book_Trainno).set(Iseatno - 1, "R");
					Get_Booked_Seats();
					Get_Available_Seats();
					Ticket_Generate();
				} else {
					System.out.println("There are no available seats.");
				}
			} else {
				System.out.println("Please enter the seat number correctly");
			}

		}

	}

// Getting booked all_Seats_List.
	public void Get_Booked_Seats() {
		count = bookedseats.size() - 1;
		System.out.println("Booked seat is : " + bookedseats.get(count));

	}

// Getting available all_Seats_List.
	public void Get_Available_Seats() {

		System.out.println("Available seats are :\n\t-W-\t-S-\t-S-\t-W-");
		for (int i = 0; i < BO_availableseats.size(); i++) {
			count = i + 1;
			System.out.print("\t " + BO_availableseats.get(i));
			if (count % 4 == 0) {
				System.out.println();
			}
		}

	}

// Parameterized constructor to create the Ticket List.
	public BookSeats(String Name, int Age, char Gender, int Train_no, String Train_name, String Arraival_Station,
			String Destination_Station, LocalDate Date_of_Journey, String Seatno) {

		this.Name = Name;
		this.Age = Age;
		this.Gender = Gender;
		this.Train_no = Train_no;
		this.Train_Name = Train_name;
		this.Arraival_Station = Arraival_Station;
		this.Destination_Station = Destination_Station;
		this.Date_of_Journey = Date_of_Journey;
		this.seatno = Seatno;

	}
//	Token Generation or Ticket Generation .

	void Ticket_Generate() {
		String a = Character.toString(Reservation_info.passenger_Arraival_Station.charAt(0));
		String b = Character.toString(Reservation_info.passenger_Destination_Station.charAt(0));
		String c = Integer.toString(Book_Trainno);
		String ID = c + a + b + seatno;

		System.out.println("-------------------------------------------");

		Ticketslist.put(ID,
				new BookSeats(Reservation_info.passenger_Name, Reservation_info.passenger_Age,
						Reservation_info.passenger_Gender, Book_Trainno,
						Train_info.all_Trains_List.get(Book_Trainno).Train_Name,
						Train_info.all_Trains_List.get(Book_Trainno).Train_ArraivalStation,
						Train_info.all_Trains_List.get(Book_Trainno).Train_DestinationStation,
						Train_info.all_Trains_List.get(Book_Trainno).Train_Date, seatno));
		System.out.println(" TICKET :  " + ID + " \t " + LocalDate.now() + "\t Train_no : " + Book_Trainno);

		System.out.println(" Name : " + Ticketslist.get(ID).Name + "\t Age : " + Ticketslist.get(ID).Age
				+ "\t Gender : " + Ticketslist.get(ID).Gender + "\n From : " + Ticketslist.get(ID).Arraival_Station
				+ "\t To : " + Ticketslist.get(ID).Destination_Station + "\t Train name : "
				+ Ticketslist.get(ID).Train_Name + "\n Date_of_Journey: " + Ticketslist.get(ID).Date_of_Journey);
		System.out.println("-------------------------------------------");

	}

// Getting All Tickets Available .
	public void Get_All_Tickets() {
		System.out.println("List Of All Tickets Which Are Reserved.");
		Set<String> key = Ticketslist.keySet();
		for (String Id : key) {
			System.out.println("Ticket :" + Id + ":\n" + Ticketslist.get(Id).seatno + "\t" + Ticketslist.get(Id).Name
					+ "\t" + Ticketslist.get(Id).Age + "\t" + Ticketslist.get(Id).Arraival_Station + "\t"
					+ Ticketslist.get(Id).Destination_Station + "\t" + Ticketslist.get(Id).Date_of_Journey);
		}
	}

// Cancel Ticket and Remove Ticket/Token from List and also changes seats in available seats and booked seats

	public void Cancel_Ticket() {
		try {
			String CancelTok;
			System.out.println("### Warning ### -->> You are About to Cancel The Ticket ");
			System.out.println("Please Enter your Token Number: ");
			CancelTok = s.next();
			int Ctrain_no = Ticketslist.get(CancelTok).Train_no;
			String Cseat = Ticketslist.get(CancelTok).seatno;
			int Iseatno = Integer.parseInt(Cseat);

			Train_info.all_Seats_List.get(Ctrain_no).set((Iseatno - 1), Cseat);
			bookedseats.remove(Iseatno - 1);

			Ticketslist.remove(CancelTok);

		} catch (NullPointerException e) {
			System.out.println("Ticket Not Available Please check your Ticket Number and try again.");
			Main_train.DoFunctionsFor();

		}
	}

//	Default Constructor to avoid errors when creating Instance .
	public BookSeats() {

	}

}