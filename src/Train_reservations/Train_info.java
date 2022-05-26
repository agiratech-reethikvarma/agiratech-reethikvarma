package Train_reservations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Train_info {

// Train Information
	public int TNo;
	public String TName, TAS, TDS;
	public LocalDate DOJ;
	BookSeats b = new BookSeats();
//		private int seatAvailable;
//		static int Price;
//		private int Amount;
	LinkedList<Train_info> TrainsList = new LinkedList<Train_info>();

	public Train_info(int TNo, String TName, String TAS, String TDS, LocalDate DOJ) {

		this.TNo = TNo;
		this.TName = TName;
		this.TAS = TAS;
		this.TDS = TDS;
		this.DOJ = DOJ;
//		this.seatAvailable=seatAvailable;
//		this.Amount=Amount;

	}

	void dateCompare(String d1, String d2) {

	}

// Search the source and Destination Place
	public void search() {

		{

			TrainsList.add(new Train_info(1, "CHE<=>TRL", "CHENNAI", "THIRUVALLUR", LocalDate.of(2022, 11, 11)));
			TrainsList.add(new Train_info(2, "TRL<=>CHE", "THIRUVALLUR", "CHENNAI", LocalDate.of(2022, 11, 11)));
			TrainsList.add(new Train_info(3, "CHE<=>AVD", "CHENNAI", "AVADI", LocalDate.of(2022, 11, 11)));
			TrainsList.add(new Train_info(3, "CHE<=>AVD", "CHENNAI", "AVADI", LocalDate.of(2021, 11, 11)));

			String CheckASN = Reservation_info.ASN.toUpperCase();
			String CheckDSN = Reservation_info.DSN.toUpperCase();

			LocalDate CheckRD = LocalDate.parse(Reservation_info.RD);

			boolean before = LocalDate.now().isBefore(CheckRD);
			boolean equals = LocalDate.now().isEqual(CheckRD);
			boolean after = LocalDate.now().isAfter(CheckRD);
//		System.out.println(before+" |||||  "+equals);
			if (before || equals) {
				for (int i = 0; i < TrainsList.size(); i++) {
					if (TrainsList.get(i).TAS.equals(CheckASN) && TrainsList.get(i).TDS.equals(CheckDSN)
							&& TrainsList.get(i).DOJ.equals(CheckRD)) {
						System.out.println("*************Here your Available Trains*************");
						System.out.println(TrainsList.get(i).TAS + " <<==>> " + TrainsList.get(i).TDS + "   ||  "
								+ TrainsList.get(i).DOJ + "\n");

					}
				}
			}else {
				System.out.println("You Entered past Date Please Enter Correct Date.");
			}
		}
	}

	public Train_info() {
		super();
	}
}
