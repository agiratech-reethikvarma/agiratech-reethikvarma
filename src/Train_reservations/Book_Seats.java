package Train_reservations;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Book_Seats {
	static String bookTrainNo;
	static int count = 0;
	String seatno;
	String seatPreference;
	int seatno_int;

	static int ID = 0;

	int age;
	String coachName;
	String trainNumber;
	String name;
	String gender;
	String arraivalStation, destinationStation, trainName;
	Date dateofJourney;

	Scanner s = new Scanner(System.in);

	static HashMap<Integer, Book_Seats> tickets_List = new HashMap<Integer, Book_Seats>();
	static List<Book_Seats> waiting_List = Arrays.asList(new Book_Seats[10]);
	List<String> windowSeatsList = new ArrayList<String>();
	List<String> asileSeatsList = new ArrayList<String>();

	List<String> lowerSeatsList = new ArrayList<String>();
	List<String> middleSeatsList = new ArrayList<String>();
	List<String> upperSeatsList = new ArrayList<String>();

// Set's 2 Seat preferences .
	public void set2SeatPreferences() {

		for (int i = 0; i < Train_info.all_S2_coach.get(bookTrainNo).size(); i++) {

			if (!Train_info.all_S2_coach.get(bookTrainNo).get(i).equals("R")) {
				count = Integer.parseInt(Train_info.all_S2_coach.get(bookTrainNo).get(i));

				if (count % 4 == 0 || count % 4 == 1) {
					windowSeatsList.add(Train_info.all_S2_coach.get(bookTrainNo).get(i));
				} else {
					asileSeatsList.add(Train_info.all_S2_coach.get(bookTrainNo).get(i));
				}

			}

		}

		System.out.println("\n Window Seats List : " + windowSeatsList);
		System.out.println("\n Aswile Seats list : " + asileSeatsList);

	}

// set's Sleeper coach Seat Preferences.

	public void setSLseatPreferences() {
		for (int i = 0; i < Train_info.all_SL_coach.get(bookTrainNo).size(); i++) {
			if (!Train_info.all_SL_coach.get(bookTrainNo).get(i).equals("R")) {
				count = Integer.parseInt(Train_info.all_SL_coach.get(bookTrainNo).get(i));

				if (count % 4 == 1) {
					lowerSeatsList.add(Train_info.all_SL_coach.get(bookTrainNo).get(i));
				} else if (count % 4 == 2) {
					middleSeatsList.add(Train_info.all_SL_coach.get(bookTrainNo).get(i));
				} else if (count % 4 == 3) {
					upperSeatsList.add(Train_info.all_SL_coach.get(bookTrainNo).get(i));
				} else if ((count / 4) % 2 == 0) {
					lowerSeatsList.add(Train_info.all_SL_coach.get(bookTrainNo).get(i));
				} else if ((count / 4) % 2 == 1) {
					upperSeatsList.add(Train_info.all_SL_coach.get(bookTrainNo).get(i));
				}
			}

		}
		System.out.println("\n Lower berth : " + lowerSeatsList);
		System.out.println("\n Middle berth : " + middleSeatsList);
		System.out.println("\n Upper berth : " + upperSeatsList);
	}

// Runtime input to get seats from user

	public void get_SeatPreferenceToBook(String To_Book_TrainNo, String To_Book_Coach) {
		bookTrainNo = To_Book_TrainNo;
		coachName = To_Book_Coach;
		if (coachName.equals("S2")) {
			set2SeatPreferences();
			do {
				System.out.println(
						"Enter The Primary Seat Preferences to book seat \"Window seats - W\" , \"Asile Seats - A\" :");
				seatPreference = s.next().toUpperCase();

			} while (!(seatPreference.equals("W") || seatPreference.equals("A")));

			switch (seatPreference) {
			case "W":
				if (!windowSeatsList.isEmpty()) {
					System.out.println("$$  Booked Window seat $$");
					bookingSeat(windowSeatsList.get(0));

				} else if (!asileSeatsList.isEmpty()) {

					System.out.println("**No Window seat available booking asile **");
					bookingSeat(asileSeatsList.get(0));
				}

				break;
			case "A":
				if (!asileSeatsList.isEmpty()) {
					System.out.println("$$ Booked Asile seat $$");
					bookingSeat(asileSeatsList.get(0));
				} else if (!windowSeatsList.isEmpty()) {

					System.out.println("** NO Asile seats available Booking Window seat **");
					bookingSeat(windowSeatsList.get(0));
				}

				break;
			default:
				System.out.println("No Seats available");
				break;
			}

		} else if (coachName.equals("SL")) {

			setSLseatPreferences();
			do {
				System.out.println(
						"Enter The Primary Seat Berth to book seat \"Upper - U\" , \"Middle - M\"  ,\"Lower - L\":");
				seatPreference = s.next().toUpperCase();

			} while (!(seatPreference.equals("U") || seatPreference.equals("M") || seatPreference.equals("L")));
			switch (seatPreference) {
			case "U":
				if (!upperSeatsList.isEmpty()) {
					System.out.println("$$ Booked Upper berth seat $$");
					bookingSeat(upperSeatsList.get(0));
				} else if (!middleSeatsList.isEmpty()) {

					System.out.println("** Upper berth seats Not available Booking Middle berth seat **");
					bookingSeat(middleSeatsList.get(0));
				} else if (!lowerSeatsList.isEmpty()) {
					System.out.println("** Upper berth seats Not available Booking Lower berth seat **");
					bookingSeat(lowerSeatsList.get(0));
				}

				break;
			case "M":
				if (!middleSeatsList.isEmpty()) {
					System.out.println("$$ Booked Middle berth seat $$");

					bookingSeat(middleSeatsList.get(0));
				} else if (!lowerSeatsList.isEmpty()) {
					System.out.println("** Middle berth seats Not available Booking Lower berth seat **");
					bookingSeat(lowerSeatsList.get(0));
				} else if (!upperSeatsList.isEmpty()) {
					System.out.println("** Middle berth seats Not available Booking Upper berth seat **");
					bookingSeat(upperSeatsList.get(0));
				}
				break;
			case "L":

				if (!lowerSeatsList.isEmpty()) {
					System.out.println("$$ Booked Lower berth seat $$");
					bookingSeat(lowerSeatsList.get(0));

				} else if (!middleSeatsList.isEmpty()) {

					System.out.println("** Lower berth seats Not available Booking Middle berth seat **");
					bookingSeat(middleSeatsList.get(0));
				} else if (!upperSeatsList.isEmpty()) {
					System.out.println("** Lower berth seats Not available Booking Upper berth seat **");
					;
					bookingSeat(upperSeatsList.get(0));
				}
				break;

			default:
				System.out.println("No Seats available");
				break;
			}
			windowSeatsList.clear();
			asileSeatsList.clear();
			upperSeatsList.clear();
			middleSeatsList.clear();
			lowerSeatsList.clear();

		}

	}

//	Booking seats for users if seats is available. 
	public void bookingSeat(String seatno) {
		this.seatno = seatno;
		seatno_int = Integer.parseInt(seatno);
		if (coachName.equals("S2")) {
			Train_info.all_S2_coach.get(bookTrainNo).set(seatno_int - 1, "R");
		} else {
			Train_info.all_SL_coach.get(bookTrainNo).set(seatno_int - 1, "R");
		}
		System.out.println("Booked Seat No: " + seatno);

		ticket_Generate();

	}

// Parameterized constructor to create the Ticket List.
	public Book_Seats(String Name, int Age, String Gender, String TrainNumber, String Train_name,
			String ArraivalStation, String DestinationStation, Date DateofJourney, String Seatno, String CoachName,
			String SeatPreference) {

		this.name = Name;
		this.age = Age;
		this.gender = Gender;
		this.trainNumber = TrainNumber;
		this.trainName = Train_name;
		this.arraivalStation = ArraivalStation;
		this.destinationStation = DestinationStation;
		this.dateofJourney = DateofJourney;
		this.seatno = Seatno;
		this.coachName = CoachName;
		this.seatPreference = SeatPreference;

	}
//	Token Generation or Ticket Generation .

	void ticket_Generate() {
		ID = ID + 1;

		tickets_List.put(ID, new Book_Seats(Reservation_info.passenger_Name, Reservation_info.passenger_Age,
				Reservation_info.passenger_Gender, bookTrainNo, Train_info.all_Trains_List.get(bookTrainNo).trainName,
				Train_info.all_Trains_List.get(bookTrainNo).trainArraivalStation,
				Train_info.all_Trains_List.get(bookTrainNo).trainDestinationStation,
				Train_info.all_Trains_List.get(bookTrainNo).trainDate, seatno, coachName, seatPreference));

		System.out.println("------------------------------------------------------------");

		System.out.println(" TICKET :  " + ID + "\n TrainNumber : " + tickets_List.get(ID).trainNumber
				+ "\t Coach/Berth/SeatNo : " + tickets_List.get(ID).coachName + "/"
				+ tickets_List.get(ID).seatPreference + "/" + tickets_List.get(ID).seatno);
		System.out.println(
				" Name : " + tickets_List.get(ID).name + "\t Age : " + tickets_List.get(ID).age + "\t Gender : "
						+ tickets_List.get(ID).gender + "\n From : " + tickets_List.get(ID).arraivalStation + "\t To : "
						+ tickets_List.get(ID).destinationStation + "\t Train name : " + tickets_List.get(ID).trainName
						+ "\n DOJ : " + Train_info.user_DatePattern.format(tickets_List.get(ID).dateofJourney));
		System.out.println("-------------------------------------------------------------");
//		System.out.println("After booking seats list is : "+windowSeatsList);

	}

// Getting All Tickets Available .
	public void get_AllTickets() {
		System.out.println("******** List Of All Tickets *********\n ");
		Set<Integer> key = tickets_List.keySet();
		for (Integer Id : key) {
			System.out.println(" TICKET :  " + Id + "\n TrainNumber : " + tickets_List.get(Id).trainNumber
					+ "\t Coach/Berth/SeatNo : " + tickets_List.get(Id).coachName + "/"
					+ tickets_List.get(Id).seatPreference + "/" + tickets_List.get(Id).seatno);
			System.out.println(" Name : " + tickets_List.get(Id).name + "\t Age : " + tickets_List.get(Id).age
					+ "\t Gender : " + tickets_List.get(Id).gender + "\n From : " + tickets_List.get(Id).arraivalStation
					+ "\t To : " + tickets_List.get(Id).destinationStation + "\t Train name : "
					+ tickets_List.get(Id).trainName + "\n DOJ : "
					+ Train_info.user_DatePattern.format(tickets_List.get(Id).dateofJourney));
			System.out.println("-------------------------------------------------------------");
		}
	}

// Cancel Ticket and Remove Ticket/Token from List and also changes seats in available seats and booked seats

	public void cancel_Ticket() {

		String CancelTok;
		System.out.println("$$$ You are About to Cancel The Ticket $$$");

		do {
			System.out.println("Enter your Ticket Number : ");
			CancelTok = s.next();
			if (CancelTok != null || Reservation_info.checkNumberFormat(CancelTok)) {
				String Ctrain_no = tickets_List.get(Integer.parseInt(CancelTok)).trainNumber;
				String Cseat = tickets_List.get(Integer.parseInt(CancelTok)).seatno;
				String CCoach = tickets_List.get(Integer.parseInt(CancelTok)).coachName;
				int seatno_int = Integer.parseInt(Cseat);

				if (CCoach.equals("S2")) {
					Train_info.all_S2_coach.get(Ctrain_no).set((seatno_int - 1), Cseat);
					tickets_List.remove(Integer.parseInt(CancelTok));
				} else if (CCoach.equals("SL")) {
					Train_info.all_SL_coach.get(Ctrain_no).set((seatno_int - 1), Cseat);
					tickets_List.remove(Integer.parseInt(CancelTok));
				}
				System.out.println("*** Succesfully Cancelled Your Ticket...");
			}
		} while (Reservation_info.checkNumberFormat(CancelTok) == false);

	}

//	Default Constructor to avoid errors when creating Instance .
	public Book_Seats() {

	}

}