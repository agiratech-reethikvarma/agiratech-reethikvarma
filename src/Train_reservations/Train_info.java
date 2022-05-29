package Train_reservations;

import java.time.LocalDate;
import java.util.ArrayList;

public class Train_info {

	public int TNo;
	public String TName, TAS, TDS;
	public LocalDate DOJ;
	BookSeats b = new BookSeats();

//	 Parameterized constructor to Create List of trains.
	public Train_info(int TNo, String TName, String TAS, String TDS, LocalDate DOJ) {

		this.TNo = TNo;
		this.TName = TName;
		this.TAS = TAS;
		this.TDS = TDS;
		this.DOJ = DOJ;
	}

// Search the source and Destination Place for The Given Input.
	public void search() {
		ArrayList<Train_info> Trains = new ArrayList<Train_info>();

		Trains.add(new Train_info(1, "CHE<=>TRL", "CHENNAI", "THIRUVALLUR", LocalDate.of(2022, 05, 25)));
		Trains.add(new Train_info(2, "TRL<=>CHE", "THIRUVALLUR", "CHENNAI", LocalDate.of(2022, 05, 26)));
		Trains.add(new Train_info(3, "CHE<=>AVD", "CHENNAI", "AVADI", LocalDate.of(2022, 05, 28)));
		Trains.add(new Train_info(4, "CHE<=>AVD", "CHENNAI", "AVADI", LocalDate.of(2022, 05, 27)));
		Trains.add(new Train_info(5, "TRL<=>AKM", "THIRUVALLUR", "ARAKONAM", LocalDate.of(2022, 05, 29)));
		Trains.add(new Train_info(6, "CHE<=>AKM", "CHENNAI", "ARAKONAM", LocalDate.of(2022, 06, 05)));
		Trains.add(new Train_info(7, "AVD<=>CHE", "AVADI", "CHENNAI", LocalDate.of(2022, 06, 06)));
		Trains.add(new Train_info(8, "CHE<=>TRL", "CHENNAI", "THIRUVALLUR", LocalDate.of(2022, 06, 03)));

		String CheckASN = Reservation_info.ASN.toUpperCase();
		String CheckDSN = Reservation_info.DSN.toUpperCase();
		ArrayList<String> AvailableTrain = new ArrayList<>();

		LocalDate CheckRD = LocalDate.parse(Reservation_info.RD);

		if (LocalDate.now().isBefore(CheckRD) || LocalDate.now().isEqual(CheckRD)) {

			for (int i = 0; i < Trains.size(); i++) {

				if (Trains.get(i).TAS.equals(CheckASN) && Trains.get(i).TDS.equals(CheckDSN)
						&& (Trains.get(i).DOJ.isEqual(CheckRD) || Trains.get(i).DOJ.isAfter(CheckRD))) {

					AvailableTrain.add((Trains.get(i).TNo + "\t" + Trains.get(i).TName + "\t" + Trains.get(i).TAS
							+ " <<==>> " + Trains.get(i).TDS + "   ||  " + Trains.get(i).DOJ).toString());

				}

			}

		} else {
			System.out.println("You Entered past Date Please Enter Correct Date.");
			Reservation_info R = new Reservation_info();
			R.getAvailableTrains();
		}

		if (AvailableTrain.isEmpty()) {
			System.out.println("Sorry No Trains Available for Given.");
		} else {
			System.out.println("********* Your Available Trains **********");
			for (int i = 0; i < AvailableTrain.size(); i++)
				System.out.println(AvailableTrain.get(i));
		}

	}

// Default constructor To Create Instance.
	public Train_info() {
		super();
	}
}
