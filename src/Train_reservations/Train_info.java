package Train_reservations;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Train_info {
	Scanner Scanner_Obj = new Scanner(System.in);

	public String Train_Name, Train_ArraivalStation, Train_DestinationStation;
	public LocalDate Train_Date;
	static int count;
	int To_Book_TrainNo;

	static List<String> seats_List = new ArrayList<String>();

	static Train_info Train_Info_obj = new Train_info();
	static BookSeats Book_seats_obj = new BookSeats();

	Map<Integer, Train_info> available_Trains_List = new HashMap<Integer, Train_info>();
	static Map<Integer, List<String>> all_Seats_List = new TreeMap<Integer, List<String>>();
	static Map<Integer, Train_info> all_Trains_List = new HashMap<Integer, Train_info>();

//Adding Trains List And all_Seats_List
	public static void Set_Trains_Informations() {

		for (int i = 0; i < 4; i++) {
			count = i + 1;
			seats_List.add(Integer.toString(count));
		}

		all_Trains_List.put(1, new Train_info("CHE<=>TRL", "CHENNAI", "THIRUVALLUR", LocalDate.of(2022, 07, 01),
				all_Seats_List.put(1, seats_List)));
		all_Trains_List.put(2, new Train_info("TRL<=>CHE", "THIRUVALLUR", "CHENNAI", LocalDate.of(2022, 07, 26),
				all_Seats_List.put(2, seats_List)));
		all_Trains_List.put(3, new Train_info("CHE<=>AVD", "CHENNAI", "AVADI", LocalDate.of(2022, 07, 28),
				all_Seats_List.put(3, seats_List)));
		all_Trains_List.put(4, new Train_info("CHE<=>AVD", "CHENNAI", "AVADI", LocalDate.of(2022, 07, 27),
				all_Seats_List.put(4, seats_List)));
		all_Trains_List.put(5, new Train_info("TRL<=>AVD", "THIRUVALLUR", "AVADI", LocalDate.of(2022, 07, 29),
				all_Seats_List.put(5, seats_List)));
		all_Trains_List.put(6, new Train_info("AVD<=>TRL", "AVADI", "THIRUVALLUR", LocalDate.of(2022, 12, 05),
				all_Seats_List.put(6, seats_List)));
		all_Trains_List.put(7, new Train_info("AVD<=>CHE", "AVADI", "CHENNAI", LocalDate.of(2022, 07, 06),
				all_Seats_List.put(7, seats_List)));
		all_Trains_List.put(8, new Train_info("CHE<=>TRL", "CHENNAI", "THIRUVALLUR", LocalDate.of(2022, 05, 02),
				all_Seats_List.put(8, seats_List)));

	}

//	 Parameterized constructor to Create List of trains.
	public Train_info(String Train_Name, String Train_ArraivalStation, String Train_DestinationStation,
			LocalDate Date_of_Journey, List<String> all_Seats_List) {

		this.Train_Name = Train_Name;
		this.Train_ArraivalStation = Train_ArraivalStation;
		this.Train_DestinationStation = Train_DestinationStation;
		this.Train_Date = Date_of_Journey;
	}

// Search the source and Destination Place for The Given Input.
	public void Check_Available_Trains() {

		Set<Integer> Train_Key = all_Trains_List.keySet();

		if (LocalDate.now().isBefore(Reservation_info.Date_of_Journey)
				|| LocalDate.now().isEqual(Reservation_info.Date_of_Journey)) {

			for (Integer Key : Train_Key) {

				if (all_Trains_List.get(Key).Train_ArraivalStation.equals(Reservation_info.passenger_Arraival_Station)
						&& all_Trains_List.get(Key).Train_DestinationStation
								.equals(Reservation_info.passenger_Destination_Station)
						&& (all_Trains_List.get(Key).Train_Date.isEqual(Reservation_info.Date_of_Journey)
								|| all_Trains_List.get(Key).Train_Date.isAfter(Reservation_info.Date_of_Journey))) {

					available_Trains_List.put(Key,
							new Train_info(all_Trains_List.get(Key).Train_Name,
									all_Trains_List.get(Key).Train_ArraivalStation,
									all_Trains_List.get(Key).Train_DestinationStation,
									all_Trains_List.get(Key).Train_Date, Train_info.all_Seats_List.get(Key)));

				}

			}

		} else {
			System.out.println("You Entered past Date Please Enter Correct Date.");
			Reservation_info reservation_info = new Reservation_info();
			reservation_info.get_Trains_Info();
		}

		if (available_Trains_List.isEmpty()) {
			System.out.println("Sorry No All_Trains_List_ListAvailable for Given.");
		} else {
			System.out.println("********* Your Available Trains List**********");
			Set<Integer> Available_Train_Key = available_Trains_List.keySet();
			for (Integer Key : Available_Train_Key) {
				available_Trains_List.get(Key);
				System.out.println(Key + "\t" + available_Trains_List.get(Key).Train_Name + "\t"
						+ available_Trains_List.get(Key).Train_ArraivalStation + "\t"
						+ available_Trains_List.get(Key).Train_DestinationStation + "\t"
						+ available_Trains_List.get(Key).Train_Date + "\t" + Train_info.all_Seats_List.get(Key));

			}

		}
		if (Main_train.Choice == 2) {
			Book_Train();
		}

	}

// Default constructor To Create Instance.
	public Train_info() {
		super();
	}

	public void Book_Train() {
		if (!available_Trains_List.isEmpty()) {

			System.out.println("Please Enter the Train Number to select the Train...");
			To_Book_TrainNo = Scanner_Obj.nextInt();

			if (available_Trains_List.containsKey(To_Book_TrainNo)) {
				available_Trains_List.get(To_Book_TrainNo);
				available_Trains_List.get(To_Book_TrainNo);
				System.out.println(available_Trains_List.get(To_Book_TrainNo).Train_Name + "\t"
						+ available_Trains_List.get(To_Book_TrainNo).Train_ArraivalStation + "\t"
						+ available_Trains_List.get(To_Book_TrainNo).Train_DestinationStation + "\t"
						+ available_Trains_List.get(To_Book_TrainNo).Train_Date + "\t"
						+ Train_info.all_Seats_List.get(To_Book_TrainNo));
				Book_seats_obj.Get_SeatNo_To_Book(To_Book_TrainNo);
			} else {

				System.out.println("Entred Train number is not available in Train list.");
			}

		} else {
			System.out.println("No Available Trains To Book.");
		}
	}

}
