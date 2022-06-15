package Train_reservations;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Train_info {

	Scanner Scanner_Obj = new Scanner(System.in);

	public String trainName, trainArraivalStation, trainDestinationStation;
	public LocalDate trainDate;
	static int count;
	int availableSeatsCount;
	String bookTrainNo;

//	static Map<String, ArrayList<String>> seats_List1=new HashMap<String,ArrayList<String>>();
	static List<String> seats_ListFormat = new ArrayList<String>();
	static List<String> seats_List1 = new ArrayList<String>();
	static List<String> seats_List2 = new ArrayList<String>();
	static List<String> seats_List3 = new ArrayList<String>();
	static List<String> seats_List4 = new ArrayList<String>();
	static List<String> seats_List5 = new ArrayList<String>();
	static List<String> seats_List6 = new ArrayList<String>();
	static List<String> seats_List7 = new ArrayList<String>();
	static List<String> seats_List8 = new ArrayList<String>();

	static List<String> reserved_seats_List = new ArrayList<String>();

	static Train_info Train_Info_obj = new Train_info();
	static Book_Seats Book_seats_obj = new Book_Seats();

	Map<String, Train_info> available_Trains_List = new HashMap<String, Train_info>();
	static Map<String, List<String>> all_Seats_List = new HashMap<String, List<String>>();
	static Map<String, Train_info> all_Trains_List = new HashMap<String, Train_info>();

//Adding Trains List And all_Seats_List
	public static void set_TrainsInformations() {

		for (int i = 0; i < 20; i++) {
			seats_ListFormat.add(Integer.toString(i + 1));
		}
		seats_List1.addAll(seats_ListFormat);
		seats_List2.addAll(seats_ListFormat);
		seats_List3.addAll(seats_ListFormat);
		seats_List4.addAll(seats_ListFormat);
		seats_List5.addAll(seats_ListFormat);
		seats_List6.addAll(seats_ListFormat);
		seats_List7.addAll(seats_ListFormat);
		seats_List8.addAll(seats_ListFormat);

		Collections.addAll(reserved_seats_List, "R", "R", "R", "R");

		all_Trains_List.put("1", new Train_info("CHE<=>TRL", "CHENNAI", "THIRUVALLUR", LocalDate.of(2022, 7, 1),
				all_Seats_List.put("1", seats_List1)));
		all_Trains_List.put("2", new Train_info("TRL<=>CHE", "THIRUVALLUR", "CHENNAI", LocalDate.of(2022, 7, 26),
				all_Seats_List.put("2", seats_List2)));
		all_Trains_List.put("3", new Train_info("CHE<=>AVD", "CHENNAI", "AVADI", LocalDate.of(2022, 7, 28),
				all_Seats_List.put("3", seats_List3)));
		all_Trains_List.put("4", new Train_info("CHE<=>AVD", "CHENNAI", "AVADI", LocalDate.of(2022, 7, 27),
				all_Seats_List.put("4", seats_List4)));
		all_Trains_List.put("5", new Train_info("TRL<=>AVD", "THIRUVALLUR", "AVADI", LocalDate.of(2022, 7, 9),
				all_Seats_List.put("5", seats_List5)));
		all_Trains_List.put("6", new Train_info("AVD<=>TRL", "AVADI", "THIRUVALLUR", LocalDate.of(2022, 12, 5),
				all_Seats_List.put("6", seats_List6)));
		all_Trains_List.put("7", new Train_info("AVD<=>CHE", "AVADI", "CHENNAI", LocalDate.of(2022, 7, 6),
				all_Seats_List.put("7", seats_List7)));
		all_Trains_List.put("8", new Train_info("CHE<=>TRL", "CHENNAI", "THIRUVALLUR", LocalDate.of(2022, 5, 2),
				all_Seats_List.put("8", seats_List8)));

	}

//Prints All Trains List.
	public void get_AllTrainsList() {
		System.out.println("*********   All Trains List    **********");

		System.out.println("| TrainNo \t |" + " TrainName \t |" + " Arraival \t |" + " Destination \t |" + " Date \t |"
				+ " Seats \t |\n"
				+ "|------------------------------------------------------------------------------------------------|");
		all_Trains_List.keySet().stream()
				.forEach(x -> System.out.println("|\t " + x + " \t | " + all_Trains_List.get(x).trainName + " \t | "
						+ all_Trains_List.get(x).trainArraivalStation + " \t |"
						+ all_Trains_List.get(x).trainDestinationStation + " \t |" + all_Trains_List.get(x).trainDate
						+ " \t |\t" + checkAvailableSeatsCount(all_Seats_List.get(x)) + " \t |"));

	}

//	Gives Available seats count By removing Reserved seats.
	private int checkAvailableSeatsCount(List<String> seatsList) {
		availableSeatsCount = seatsList.size();
		for (int i = 0; i < seatsList.size(); i++) {
			if (seatsList.get(i).equals("R")) {
				availableSeatsCount = availableSeatsCount - 1;
			}
		}
		return availableSeatsCount;
	}

// Prints 2 Sitting coach Seats Format 
	public void coach_2SFormat() {

		System.out.println("\n\t\t -- 2S Coach Seats Format --");
		System.out.println("\t-W-" + "\t\t-A-" + "\t\t-A-" + "\t\t-W-");
		for (int i = 0; i < seats_ListFormat.size(); i++) {
			count = i + 1;
			System.out.print("\t " + count + "\t");
			if (count % 4 == 0) {
				System.out.println();
			}
		}

	}

//	 Parameterized constructor to Create List of trains.
	public Train_info(String trainName, String trainArraivalStation, String trainDestinationStation,
			LocalDate Date_of_Journey, List<String> all_Seats_List) {

		this.trainName = trainName;
		this.trainArraivalStation = trainArraivalStation;
		this.trainDestinationStation = trainDestinationStation;
		this.trainDate = Date_of_Journey;
	}

// Search the source and Destination Place for The Given Input.
	public void check_AvailableTrains() {

		all_Trains_List.keySet().stream().filter(x -> all_Trains_List.get(x).trainArraivalStation
				.equals(Reservation_info.passenger_ArraivalStation)
				&& all_Trains_List.get(x).trainDestinationStation.equals(Reservation_info.passenger_DestinationStation)
				&& (all_Trains_List.get(x).trainDate.isEqual(Reservation_info.passenger_DateofJourney)
						|| all_Trains_List.get(x).trainDate.isAfter(Reservation_info.passenger_DateofJourney))
				&& !(all_Seats_List.get(x).equals(reserved_seats_List)))
				.forEach(x -> available_Trains_List.put(x,
						new Train_info(all_Trains_List.get(x).trainName, all_Trains_List.get(x).trainArraivalStation,
								all_Trains_List.get(x).trainDestinationStation, all_Trains_List.get(x).trainDate,
								Train_info.all_Seats_List.get(x))));

		if (available_Trains_List.isEmpty()) {
			System.out.println("*** Sorry No Trains Available for Given.");

		} else {

			System.out.println("********* Your Available Trains List**********");

			System.out.println("| TrainNo \t |" + " TrainName \t |" + " Arraival \t |" + " Destination \t |"
					+ " Date \t |" + " Seats \t |\n"
					+ "|------------------------------------------------------------------------------------------------|");
			Set<String> availableTrainsListKey = available_Trains_List.keySet();
			for (String Key : availableTrainsListKey) {

				System.out.println("| \t " + Key + " \t | " + available_Trains_List.get(Key).trainName + " \t | "
						+ available_Trains_List.get(Key).trainArraivalStation + " \t | "
						+ available_Trains_List.get(Key).trainDestinationStation + " \t | "
						+ available_Trains_List.get(Key).trainDate + " \t | \t "
						+ checkAvailableSeatsCount(all_Seats_List.get(Key)) + " \t |");

			}

			if (Main_train.choice.equals("3")) {
				book_Train();
				
			}
		}
	}

// Default constructor To Create Instance.
	public Train_info() {
		super();
	}

// Selecting Train No for Booking.
	public void book_Train() {
		if (!available_Trains_List.isEmpty()) {
			do {
				System.out.println("Enter the Train Number to select the Train...");
				bookTrainNo = Scanner_Obj.next();
			} while (Reservation_info.checkNumberFormat(bookTrainNo) == false);

			if (available_Trains_List.containsKey(bookTrainNo)) {
				available_Trains_List.get(bookTrainNo);
				available_Trains_List.get(bookTrainNo);

				Book_seats_obj.get_SeatNoToBook(bookTrainNo);
			} else {

				System.out.println("*** Entred Train number is not available in Train list.");
				book_Train();
			}

		} else {
			System.out.println("***  No Available Trains To Book.");
		}
	}

}
