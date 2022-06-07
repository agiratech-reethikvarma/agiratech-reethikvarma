package Train_reservations;

import java.time.LocalDate;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Train_info extends BookSeats {
	Scanner Scanner_Obj = new Scanner(System.in);

	public String Train_Name, Train_ArraivalStation, Train_DestinationStation;
	public LocalDate Train_Date;
	static int count;
	static String[] SSseats = new String[4];

	static Train_info info = new Train_info();
	static BookSeats bookSeats = new BookSeats();

	static ArrayList<String> availableseats = new ArrayList<String>();
	static Map<Integer, Train_info> All_Trains = new HashMap<Integer, Train_info>();
	static Map<Integer, Train_info> AvailableTrain = new HashMap<Integer, Train_info>();
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
//		Set<Integer> key=Train_info.All_Trains.keySet();
//		for(Integer SeatKey:key) {
//			seatList.put(SeatKey, availableseats);
//		}
		All_Trains.put(1, new Train_info("CHE<=>TRL", "CHENNAI", "THIRUVALLUR", LocalDate.of(2022, 07, 01),availableseats ));
		All_Trains.put(2, new Train_info("TRL<=>CHE", "THIRUVALLUR", "CHENNAI", LocalDate.of(2022, 07, 26),availableseats ));
//		All_Trains.add(new Train_info(3, "CHE<=>AVD", "CHENNAI", "AVADI", LocalDate.of(2022, 05, 28)));
//		All_Trains.add(new Train_info(4, "CHE<=>AVD", "CHENNAI", "AVADI", LocalDate.of(2022, 05, 27)));
//		All_Trains.add(new Train_info(5, "TRL<=>AKM", "THIRUVALLUR", "ARAKONAM", LocalDate.of(2022, 05, 29)));
//		All_Trains.add(new Train_info(6, "CHE<=>AKM", "CHENNAI", "ARAKONAM", LocalDate.of(2022, 06, 05)));
//		All_Trains.add(new Train_info(7, "AVD<=>CHE", "AVADI", "CHENNAI", LocalDate.of(2022, 06, 06)));
		All_Trains.put(5, new Train_info("CHE<=>TRL", "CHENNAI", "THIRUVALLUR", LocalDate.of(2022, 07, 02),availableseats));
	}

//	 Parameterized constructor to Create List of trains.
	public Train_info(String Train_Name, String Train_ArraivalStation, String Train_DestinationStation,
			LocalDate Date_of_Journey, ArrayList<String>Seats) {

//		this.Train_Number = Train_Number;
		this.Train_Name = Train_Name;
		this.Train_ArraivalStation = Train_ArraivalStation;
		this.Train_DestinationStation = Train_DestinationStation;
		this.Train_Date = Date_of_Journey;
//		Train_info.SSseats = SSseats;
	}

// Search the source and Destination Place for The Given Input.
	public void Check_Available_Trains() {

		Set<Integer> Train_Key = All_Trains.keySet();

		if (LocalDate.now().isBefore(Reservation_info.Date_of_Journey)
				|| LocalDate.now().isEqual(Reservation_info.Date_of_Journey)) {

			for (Integer Key : Train_Key) {

				if (All_Trains.get(Key).Train_ArraivalStation.equals(Reservation_info.Arraival_Station)
						&& All_Trains.get(Key).Train_DestinationStation.equals(Reservation_info.Destination_Station)
						&& (All_Trains.get(Key).Train_Date.isEqual(Reservation_info.Date_of_Journey)
								|| All_Trains.get(Key).Train_Date.isAfter(Reservation_info.Date_of_Journey))) {

					All_Trains.get(Key);
					AvailableTrain.put(Key,
							new Train_info(All_Trains.get(Key).Train_Name, All_Trains.get(Key).Train_ArraivalStation,
									All_Trains.get(Key).Train_DestinationStation, All_Trains.get(Key).Train_Date,
									All_Trains.get(Key).availableseats));

				}

			}

		} else {
			System.out.println("You Entered past Date Please Enter Correct Date.");
			Reservation_info reservation_info = new Reservation_info();
			reservation_info.get_Trains_Info();
		}

		if (AvailableTrain.isEmpty()) {
			System.out.println("Sorry No All_Trains Available for Given.");
		} else {
			System.out.println("********* Your Available All_Trains **********");
			Set<Integer> Available_Train_Key = AvailableTrain.keySet();
			for (Integer Key : Available_Train_Key) {
				System.out.println(Key + "\t" + AvailableTrain.get(Key).Train_Name + "\t"
						+ AvailableTrain.get(Key).Train_ArraivalStation + "\t"
						+ AvailableTrain.get(Key).Train_DestinationStation + "\t" + AvailableTrain.get(Key).Train_Date);

			}

		}
		if(Main_train.Choice==2) {
			Book_Train();
		}

	}

// Default constructor To Create Instance.
	public Train_info() {
		super();
	}

	public void Book_Train() {
		if (!AvailableTrain.isEmpty()) {
			int To_Book_TrainNo;
			System.out.println("Please Enter the Train Number to select the Train...");
			To_Book_TrainNo = Scanner_Obj.nextInt();

			if (AvailableTrain.containsKey(To_Book_TrainNo)) {
				AvailableTrain.get(To_Book_TrainNo);
				System.out.println(AvailableTrain.get(To_Book_TrainNo).Train_Name + "\t"
						+ AvailableTrain.get(To_Book_TrainNo).Train_ArraivalStation + "\t"
						+ AvailableTrain.get(To_Book_TrainNo).Train_DestinationStation + "\t"
						+ AvailableTrain.get(To_Book_TrainNo).Train_Date + "\t" + Train_info.availableseats);

			} else {

				System.out.println("Entred Train number is not available in Train list.");
			}

		} else {
			System.out.println("No Available Trains To Book.");
		}
	}

}
