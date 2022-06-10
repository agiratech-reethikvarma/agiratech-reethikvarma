package Train_reservations;

import java.util.Scanner;
import java.util.Set;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookSeats {
	static int bookTrainNo;
	static int count = 0;
	String seatno;
	int seatno_int;

	int age, trainNumber;
	String name;
	char gender;
	String arraivalStation, destinationStation, trainName;
	LocalDate dateofJourney;

	Scanner s = new Scanner(System.in);

	ArrayList<String> booked_Seats = new ArrayList<String>();
	List<String> available_Seats_Temp = new ArrayList<>();
	static HashMap<String, BookSeats> tickets_List = new HashMap<String, BookSeats>();

// Runtime input to get seats from user

	public void get_SeatNoToBook(int To_Book_TrainNo) {
		bookTrainNo = To_Book_TrainNo;

		do {
			if (seatno != null && !seatno.matches("[0-9]")) {

				System.out.println("*** Enter Seat Number in correct valid number formate.");
			}
			System.out.println("Enter The Seat Number : ");
			seatno = s.next();

		} while (!seatno.matches("[0-9]"));

		seatno_int = Integer.parseInt(seatno);

		available_Seats_Temp = new ArrayList<>(Train_info.all_Seats_List.get(bookTrainNo));

		if (seatno_int > 0 && seatno_int < 5) {

			if (available_Seats_Temp.contains(seatno)) {
				bookingSeat(seatno);
			} else {
				System.out.println("*** Entered seat is already booked please select the available seats.");
				available_Seats_Temp.stream().filter(x -> x != "R").forEach(x -> System.out.print("  " + x + " "));
				System.out.println();
				get_SeatNoToBook(bookTrainNo);
			}
		} else {
			System.out.println("*** Please Enter the Seat Number which are Available ");
			get_AvailableSeats();
			get_SeatNoToBook(bookTrainNo);
		}

	}

//	Booking seats for users if seats is available. 
	public void bookingSeat(String seatno) {

		if (seatno_int % 4 == 0 || seatno_int % 4 == 1) {
			System.out.println("Booked window seat : " + seatno);
			Train_info.all_Seats_List.get(bookTrainNo).set(seatno_int - 1, "R");
			ticket_Generate();

		} else if (seatno_int % 4 == 2 || seatno_int % 4 == 3) {
			System.out.println("Booked Asile Seat : " + seatno);
			Train_info.all_Seats_List.get(bookTrainNo).set(seatno_int - 1, "R");
			ticket_Generate();
		} else {
			System.out.println("There are no available seats.");
		}
	}

// Getting available all_Seats_List.
	public void get_AvailableSeats() {

		System.out.println("Available seats are : " + available_Seats_Temp);
	}

// Parameterized constructor to create the Ticket List.
	public BookSeats(String name, int age, char gender, int trainNumber, String Train_name, String arraivalStation,
			String destinationStation, LocalDate dateofJourney, String Seatno) {

		this.name = name;
		this.age = age;
		this.gender = gender;
		this.trainNumber = trainNumber;
		this.trainName = Train_name;
		this.arraivalStation = arraivalStation;
		this.destinationStation = destinationStation;
		this.dateofJourney = dateofJourney;
		this.seatno = Seatno;

	}
//	Token Generation or Ticket Generation .

	void ticket_Generate() {
		String a = Character.toString(Reservation_info.passenger_ArraivalStation.charAt(0));
		String b = Character.toString(Reservation_info.passenger_DestinationStation.charAt(0));
		String c = Integer.toString(bookTrainNo);
		String d = Train_info.all_Trains_List.get(bookTrainNo).trainDate.toString();
		String ID = c + a + b + seatno + d;

		System.out.println("-------------------------------------------");

		tickets_List.put(ID, new BookSeats(Reservation_info.passenger_Name, Reservation_info.passenger_Age,
				Reservation_info.passenger_Gender, bookTrainNo, Train_info.all_Trains_List.get(bookTrainNo).trainName,
				Train_info.all_Trains_List.get(bookTrainNo).trainArraivalStation,
				Train_info.all_Trains_List.get(bookTrainNo).trainDestinationStation,
				Train_info.all_Trains_List.get(bookTrainNo).trainDate, seatno));
		System.out.println(" TICKET :  " + ID + " \t " + LocalDate.now() + "\t trainNumber : " + bookTrainNo
				+ "\t SeatNo : " + seatno);

		System.out.println(" name : " + tickets_List.get(ID).name + "\t age : " + tickets_List.get(ID).age
				+ "\t gender : " + tickets_List.get(ID).gender + "\n From : " + tickets_List.get(ID).arraivalStation
				+ "\t To : " + tickets_List.get(ID).destinationStation + "\t Train name : "
				+ tickets_List.get(ID).trainName + "\n dateofJourney: " + tickets_List.get(ID).dateofJourney);
		System.out.println("-------------------------------------------");

	}

// Getting All Tickets Available .
	public void get_AllTickets() {
		System.out.println("******** List Of All Tickets *********");
		Set<String> key = tickets_List.keySet();
		for (String Id : key) {
			System.out.println(" TICKET :  " + Id + "\t trainNumber : " + tickets_List.get(Id).trainNumber
					+ "\t SeatNo : " + tickets_List.get(Id).seatno);
			System.out.println(" name : " + tickets_List.get(Id).name + "\t age : " + tickets_List.get(Id).age
					+ "\t gender : " + tickets_List.get(Id).gender + "\n From : " + tickets_List.get(Id).arraivalStation
					+ "\t To : " + tickets_List.get(Id).destinationStation + "\t Train name : "
					+ tickets_List.get(Id).trainName + "\n dateofJourney: " + tickets_List.get(Id).dateofJourney);
			System.out.println("-------------------------------------------");
		}
	}

// Cancel Ticket and Remove Ticket/Token from List and also changes seats in available seats and booked seats

	public void cancel_Ticket() {
		try {
			String CancelTok;
			System.out.println("$$$ You are About to Cancel The Ticket $$$");
			System.out.println("Enter your Ticket Number : ");
			CancelTok = s.next();
			int Ctrain_no = tickets_List.get(CancelTok).trainNumber;
			String Cseat = tickets_List.get(CancelTok).seatno;
			int seatno_int = Integer.parseInt(Cseat);

			Train_info.all_Seats_List.get(Ctrain_no).set((seatno_int - 1), Cseat);
			tickets_List.remove(CancelTok);
			System.out.println("*** Succesfully Cancelled Your Ticket...");

		} catch (NullPointerException e) {
			System.out.println("*** Ticket Not Available Please check your Ticket Number and try again.");
		

		}
		Main_train.DoFunctionsFor();
	}

//	Default Constructor to avoid errors when creating Instance .
	public BookSeats() {

	}

}