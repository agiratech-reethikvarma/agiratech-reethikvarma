package Train_reservations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Train_info {

	public String trainName, trainArraivalStation, trainDestinationStation;
	public Date trainDate;
	static int count;
	int availableSeatsCount;
	String bookTrainNo;
	String coachName;

	public static SimpleDateFormat datePattern = new SimpleDateFormat("yyyy/MM/dd");
	public static SimpleDateFormat user_DatePattern = new SimpleDateFormat("dd/MM/yyyy");

	Scanner Scanner_Obj = new Scanner(System.in);
	Reservation_info res_infoObj = new Reservation_info();

	static Map<String, Train_info> all_Trains_List = new HashMap<String, Train_info>();
	Map<String, Train_info> available_Trains_List = new HashMap<String, Train_info>();

	static List<String> reserved_List = new ArrayList<String>();
	static List<String> seats_ListFormat = new ArrayList<String>();

	static List<String> S2seats_List1 = new ArrayList<String>();
	static List<String> S2seats_List2 = new ArrayList<String>();
	static List<String> S2seats_List3 = new ArrayList<String>();
	static List<String> S2seats_List4 = new ArrayList<String>();
	static List<String> S2seats_List5 = new ArrayList<String>();
	static List<String> S2seats_List6 = new ArrayList<String>();
	static List<String> S2seats_List7 = new ArrayList<String>();
	static List<String> S2seats_List8 = new ArrayList<String>();

	static Map<String, List<String>> all_S2_coach = new HashMap<String, List<String>>();

	static List<String> SLseats_List1 = new ArrayList<String>();
	static List<String> SLseats_List2 = new ArrayList<String>();
	static List<String> SLseats_List3 = new ArrayList<String>();
	static List<String> SLseats_List4 = new ArrayList<String>();
	static List<String> SLseats_List5 = new ArrayList<String>();
	static List<String> SLseats_List6 = new ArrayList<String>();
	static List<String> SLseats_List7 = new ArrayList<String>();
	static List<String> SLseats_List8 = new ArrayList<String>();

	static Map<String, List<String>> all_SL_coach = new HashMap<String, List<String>>();

	static Train_info Train_Info_obj = new Train_info();
	static Book_Seats Book_seats_obj = new Book_Seats();

//Adding Trains List And all_Seats_List
	public static void set_TrainsInformations() {

		for (int i = 0; i < 20; i++) {
			seats_ListFormat.add(Integer.toString(i + 1));
			reserved_List.add("R");
		}
		S2seats_List1.addAll(seats_ListFormat);
		S2seats_List2.addAll(seats_ListFormat);
		S2seats_List3.addAll(seats_ListFormat);
		S2seats_List4.addAll(seats_ListFormat);
		S2seats_List5.addAll(seats_ListFormat);
		S2seats_List6.addAll(seats_ListFormat);
		S2seats_List7.addAll(seats_ListFormat);
		S2seats_List8.addAll(seats_ListFormat);

		SLseats_List1.addAll(seats_ListFormat);
		SLseats_List2.addAll(seats_ListFormat);
		SLseats_List3.addAll(seats_ListFormat);
		SLseats_List4.addAll(seats_ListFormat);
		SLseats_List5.addAll(seats_ListFormat);
		SLseats_List6.addAll(seats_ListFormat);
		SLseats_List7.addAll(seats_ListFormat);
		SLseats_List8.addAll(seats_ListFormat);
		try {
			all_Trains_List.put("1",
					new Train_info("CHE<=>TRL", "CHENNAI", "THIRUVALLUR", datePattern.parse("2022/07/27"),
							all_S2_coach.put("1", S2seats_List1), all_SL_coach.put("1", SLseats_List1)));
			all_Trains_List.put("2",
					new Train_info("TRL<=>CHE", "THIRUVALLUR", "CHENNAI", datePattern.parse("2022/07/28"),
							all_S2_coach.put("2", S2seats_List2), all_SL_coach.put("2", SLseats_List2)));
			all_Trains_List.put("3", new Train_info("CHE<=>AVD", "CHENNAI", "AVADI", datePattern.parse("2022/07/28"),
					all_S2_coach.put("3", S2seats_List3), all_SL_coach.put("3", SLseats_List3)));
			all_Trains_List.put("4", new Train_info("CHE<=>AVD", "CHENNAI", "AVADI", datePattern.parse("2022/07/27"),
					all_S2_coach.put("4", S2seats_List4), all_SL_coach.put("4", SLseats_List4)));
			all_Trains_List.put("5",
					new Train_info("TRL<=>AVD", "THIRUVALLUR", "AVADI", datePattern.parse("2022/07/09"),
							all_S2_coach.put("5", S2seats_List5), all_SL_coach.put("5", SLseats_List5)));
			all_Trains_List.put("6",
					new Train_info("AVD<=>TRL", "AVADI", "THIRUVALLUR", datePattern.parse("2022/12/05"),
							all_S2_coach.put("6", S2seats_List6), all_SL_coach.put("6", SLseats_List6)));
			all_Trains_List.put("7", new Train_info("AVD<=>CHE", "AVADI", "CHENNAI", datePattern.parse("2022/07/06"),
					all_S2_coach.put("7", S2seats_List7), all_SL_coach.put("7", SLseats_List7)));
			all_Trains_List.put("8",
					new Train_info("CHE<=>TRL", "CHENNAI", "THIRUVALLUR", datePattern.parse("2022/05/02"),
							all_S2_coach.put("8", S2seats_List8), all_SL_coach.put("8", SLseats_List8)));
		} catch (ParseException e) {
			System.out.println("trains date not set.");
		}

	}

//Prints All Trains List.
	public void get_AllTrainsList() {
		System.out.println("*********   All Trains List    **********");

		System.out.println("| TrainNo \t |" + " TrainName \t |" + " Arraival \t |" + " Destination \t |" + " Date \t |"
				+ " 2Sitting \t | " + " SL Seats \t | \n"
				+ "|----------------------------------------------------------------------------------------------------------------|");
		all_Trains_List.keySet().stream()
				.forEach(x -> System.out.println("|\t " + x + " \t | " + all_Trains_List.get(x).trainName + " \t | "
						+ all_Trains_List.get(x).trainArraivalStation + " \t |"
						+ all_Trains_List.get(x).trainDestinationStation + " \t |"
						+ user_DatePattern.format(all_Trains_List.get(x).trainDate) + " \t |\t"
						+ checkAvailableSeatsCount(all_S2_coach.get(x)) + " \t | \t "
						+ checkAvailableSeatsCount(all_SL_coach.get(x)) + " \t | "));

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

// Print's 2 Sitting coach Seats Format 
	public void coach_2SFormat() {

		System.out.println("\n\t\t -- 2S Coach Seats Format --");
		System.out.println(" W -Window \n A-Asile");
		System.out.println("\t-W-" + "\t\t-A-" + "\t\t-A-" + "\t\t-W-");
		for (int i = 0; i < seats_ListFormat.size(); i++) {
			count = i + 1;
			System.out.print("\t " + count + "\t");
			if (count % 4 == 0) {
				System.out.println();
			}
		}

	}

//	Print's Sleeper Coach Seats Format
	public void coach_SLFormat() {
		System.out.println("\n\t\t -- SL Coach Seats Format --");
		System.out.println(" L-Lower \n M-Middle \n U-Upper\n U/L- Upper & Lower");
		System.out.println("\t-L-" + "\t\t-M-" + "\t\t-U-" + "\t\t-U/L-");
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
			Date Date_of_Journey, List<String> S2Seats, List<String> SLSeats) {

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
				&& (all_Trains_List.get(x).trainDate.equals(Reservation_info.passenger_dateOfJourney)
						|| all_Trains_List.get(x).trainDate.after(Reservation_info.passenger_dateOfJourney))
				&& !(all_S2_coach.get(x).equals(reserved_List)))
				.forEach(x -> available_Trains_List.put(x,
						new Train_info(all_Trains_List.get(x).trainName, all_Trains_List.get(x).trainArraivalStation,
								all_Trains_List.get(x).trainDestinationStation, all_Trains_List.get(x).trainDate,
								Train_info.all_S2_coach.get(x), Train_info.all_SL_coach.get(x))));

		if (available_Trains_List.isEmpty()) {
			System.out.println("*** Sorry No Trains Available for Given.");

		} else {
			Set<String> availableTrainsListKey = available_Trains_List.keySet();

			System.out.println("********* Your Available Trains List**********");

			System.out.println("| TrainNo \t |" + " TrainName \t |" + " Arraival \t |" + " Destination \t |"
					+ " Date \t |" + " 2Sitting \t | " + " SL Seats \t | \n"
					+ "|----------------------------------------------------------------------------------------------------------------|");

			for (String Key : availableTrainsListKey) {
				if (Train_info.all_S2_coach.get(Key).equals(reserved_List)
						&& Train_info.all_SL_coach.get(Key).equals(reserved_List)) {

			
				} else {
					System.out.println("|\t " + Key + " \t | " + all_Trains_List.get(Key).trainName + " \t | "
							+ all_Trains_List.get(Key).trainArraivalStation + " \t |"
							+ all_Trains_List.get(Key).trainDestinationStation + " \t |"
							+ user_DatePattern.format(all_Trains_List.get(Key).trainDate) + " \t |\t"
							+ checkAvailableSeatsCount(all_S2_coach.get(Key)) + " \t | \t "
							+ checkAvailableSeatsCount(all_SL_coach.get(Key)) + " \t | ");
				}
			}

			if (Main_train.choice.equals("3")) {
				get_TrainNoToBook();

			}
		}

	}

// Default constructor To Create Instance.
	public Train_info() {
		super();
	}

// Selecting Train No for Booking.
	public void get_TrainNoToBook() {
		if (!available_Trains_List.isEmpty()) {
			do {
				System.out.println("Enter the Train Number to select the Train...");
				bookTrainNo = Scanner_Obj.next();
			} while (Reservation_info.checkNumberFormat(bookTrainNo) == false);

			if (available_Trains_List.containsKey(bookTrainNo)) {

				get_CoachTypeToBook(bookTrainNo);

			} else {

				System.out.println("*** Entred Train number is not available in Train list.");
				get_TrainNoToBook();
			}

		} else {
			System.out.println("***  No Available Trains To Book.");
		}
	}

//	select Coach to Book
	public void get_CoachTypeToBook(String bookTrainNo) {
		do {
			System.out.println("Enter the Coach Type to Book Seat(S2 -TwoSitting / SL -Sleeper coach)...");
			coachName = Scanner_Obj.next().toUpperCase();
		} while (!(coachName.equals("S2") || coachName.equals("SL")));
		switch (coachName) {
		case "S2":
			Book_seats_obj.get_SeatPreferenceToBook(bookTrainNo, coachName);
			break;

		case "SL":
			Book_seats_obj.get_SeatPreferenceToBook(bookTrainNo, coachName);
			break;
		default:
			System.out.println("No Coach Available.");
			break;
		}

	}

}
