package Train_reservations;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Train_info {
	Scanner Scanner_Obj = new Scanner(System.in);

	public String trainName, trainArraivalStation, trainDestinationStation;
	public LocalDate trainDate;
	static int count;
	int bookTrainNo;

	static List<String> seats_List1 = new ArrayList<String>();
	static List<String> seats_List2 = new ArrayList<String>();
	static List<String> seats_List3 = new ArrayList<String>();
	static List<String> seats_List4 = new ArrayList<String>();
	static List<String> seats_List5 = new ArrayList<String>();
	static List<String> seats_List6 = new ArrayList<String>();
	static List<String> seats_List7 = new ArrayList<String>();
	static List<String> seats_List8 = new ArrayList<String>();

	static Train_info Train_Info_obj = new Train_info();
	static BookSeats Book_seats_obj = new BookSeats();

	Map<Integer, Train_info> available_Trains_List = new HashMap<Integer, Train_info>();
	static Map<Integer, List<String>> all_Seats_List = new TreeMap<Integer, List<String>>();
	static Map<Integer, Train_info> all_Trains_List = new HashMap<Integer, Train_info>();

//Adding Trains List And all_Seats_List
	public static void set_TrainsInformations() {

		Collections.addAll(seats_List1, "1", "2", "3", "4");
		Collections.addAll(seats_List2, "1", "2", "3", "4");
		Collections.addAll(seats_List3, "1", "2", "3", "4");
		Collections.addAll(seats_List4, "1", "2", "3", "4");
		Collections.addAll(seats_List5, "1", "2", "3", "4");
		Collections.addAll(seats_List6, "1", "2", "3", "4");
		Collections.addAll(seats_List7, "1", "2", "3", "4");
		Collections.addAll(seats_List8, "1", "2", "3", "4");

		all_Trains_List.put(1, new Train_info("CHE<=>TRL", "CHENNAI", "THIRUVALLUR", LocalDate.of(2022, 07, 01),
				all_Seats_List.put(1, seats_List1)));
		all_Trains_List.put(2, new Train_info("TRL<=>CHE", "THIRUVALLUR", "CHENNAI", LocalDate.of(2022, 07, 26),
				all_Seats_List.put(2, seats_List2)));
		all_Trains_List.put(3, new Train_info("CHE<=>AVD", "CHENNAI", "AVADI", LocalDate.of(2022, 07, 28),
				all_Seats_List.put(3, seats_List3)));
		all_Trains_List.put(4, new Train_info("CHE<=>AVD", "CHENNAI", "AVADI", LocalDate.of(2022, 07, 27),
				all_Seats_List.put(4, seats_List4)));
		all_Trains_List.put(5, new Train_info("TRL<=>AVD", "THIRUVALLUR", "AVADI", LocalDate.of(2022, 07, 29),
				all_Seats_List.put(5, seats_List5)));
		all_Trains_List.put(6, new Train_info("AVD<=>TRL", "AVADI", "THIRUVALLUR", LocalDate.of(2022, 12, 05),
				all_Seats_List.put(6, seats_List6)));
		all_Trains_List.put(7, new Train_info("AVD<=>CHE", "AVADI", "CHENNAI", LocalDate.of(2022, 07, 06),
				all_Seats_List.put(7, seats_List7)));
		all_Trains_List.put(8, new Train_info("CHE<=>TRL", "CHENNAI", "THIRUVALLUR", LocalDate.of(2022, 05, 02),
				all_Seats_List.put(8, seats_List8)));
		

	}
	public void get_AllTrainsList() {
		System.out.println("*********   All Trains List    **********");

		System.out.println("|\t Key \t |" + " TrainName \t |" + " Arraival \t |" + " Destination \t |" + " Date \t |"
				+ " Seats \t |\n"
				+ "|------------------------------------------------------------------------------------------------|");
		all_Trains_List.keySet().stream()
				.forEach(x -> System.out.println("|\t " + x + " \t | " + all_Trains_List.get(x).trainName + " \t | "
						+ all_Trains_List.get(x).trainArraivalStation + " \t |"
						+ all_Trains_List.get(x).trainDestinationStation + " \t |" + all_Trains_List.get(x).trainDate
						+ " \t |" + Train_info.all_Seats_List.get(x) + " \t |"));
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
						|| all_Trains_List.get(x).trainDate.isAfter(Reservation_info.passenger_DateofJourney)))
				.forEach(x -> available_Trains_List.put(x,
						new Train_info(all_Trains_List.get(x).trainName, all_Trains_List.get(x).trainArraivalStation,
								all_Trains_List.get(x).trainDestinationStation, all_Trains_List.get(x).trainDate,
								Train_info.all_Seats_List.get(x))));

		if (available_Trains_List.isEmpty()) {
			System.out.println("*** Sorry No Trains Available for Given.");

		} else {
			System.out.println("********* Your Available Trains List**********");
			Set<Integer> availableTrainsListKey = available_Trains_List.keySet();
			for (Integer Key : availableTrainsListKey) {
				System.out.println(Key + "\t" + available_Trains_List.get(Key).trainName + "\t"
						+ available_Trains_List.get(Key).trainArraivalStation + "\t"
						+ available_Trains_List.get(Key).trainDestinationStation + "\t"
						+ available_Trains_List.get(Key).trainDate + "\t" + Train_info.all_Seats_List.get(Key));
				if (Main_train.choice == 3) {
					book_Train();
				}

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

			System.out.println("Enter the Train Number to select the Train...");
			bookTrainNo = Scanner_Obj.nextInt();

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
