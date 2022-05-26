package Train_reservations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;



public class Tickets {
static Tickets t=new Tickets();
// Train Information
	public int TNo;
	public String TName, TAS, TDS;
	public LocalDate DOJ;
	static int count = 0;
	static int seatcount;// ****
	static String seatno;
	static String[] SSseats = new String[20];


	static Scanner s = new Scanner(System.in);
	
	static ArrayList<String> bookedseats = new ArrayList<String>();
	static ArrayList<String> availableseats = new ArrayList<String>();
	static LinkedList<Tickets> TrainsList = new LinkedList<Tickets>();

	

// Get seats from user and bookes the ticket
	static {
		for (int i = 0; i < SSseats.length; i++) {
			count = i + 1;
			SSseats[i] = Integer.toString(count);
			availableseats.add(SSseats[i]);
		}
	}
	
	

	public Tickets(int TNo, String TName, String TAS, String TDS, LocalDate DOJ,int seatcount) {

		this.TNo = TNo;
		this.TName = TName;
		this.TAS = TAS;
		this.TDS = TDS;
		this.DOJ = DOJ;
		this.seatcount=seatcount;
//		this.Amount=Amount;

	}

// Search the source and Destination Place
	public void search() {

		

			TrainsList.add(new Tickets(1, "CHE<=>TRL", "CHENNAI", "THIRUVALLUR", LocalDate.of(2022, 11, 11),seatcount));
			TrainsList.add(new Tickets(2, "TRL<=>CHE", "THIRUVALLUR", "CHENNAI", LocalDate.of(2022, 11, 11),seatcount));
			TrainsList.add(new Tickets(3, "CHE<=>AVD", "CHENNAI", "AVADI", LocalDate.of(2022, 11, 11),seatcount));

			String CheckASN = Reservation_info.ASN.toUpperCase();
			String CheckDSN = Reservation_info.DSN.toUpperCase();
			LocalDate CheckRD = LocalDate.parse(Reservation_info.RD);
			for (int i = 0; i < TrainsList.size(); i++) {
				if (TrainsList.get(i).TAS.equals(CheckASN) && TrainsList.get(i).TDS.equals(CheckDSN)
						&& TrainsList.get(i).DOJ.equals(CheckRD)) {
					System.out.println("*************Here your Available Trains*************");
					System.out.println(TrainsList.get(i).TAS + " <<==>> " + TrainsList.get(i).TDS + "   ||  "
							+ TrainsList.get(i).DOJ + "\t"+TrainsList.get(i).seatcount+"\n");

				}
			}

	}

	public Tickets() {
		super();
	}

	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	public void bookSeat(String seatno) {

		if (bookedseats.contains(seatno)) {
			System.out.println("Entered seat is already booked please select the available seats.");

			getSeatsfromuser();

		} else {

			int Iseatno = Integer.parseInt(seatno);

			if (Iseatno > 0 && Iseatno < 21) {
				if (Iseatno % 4 == 0 || Iseatno % 4 == 1) {
					System.out.println("Booked window seat:" + seatno);
					bookedseats.add(seatno);
					availableseats.set((Iseatno - 1), "R");

				} else if (Iseatno % 4 == 2 || Iseatno % 4 == 3) {
					System.out.println("Booked Asile Seat:" + seatno);
					bookedseats.add(seatno);
					availableseats.set((Iseatno - 1), "R");

				} else {
					System.out.println("There are no available seats.");
				}

			} else {
				System.out.println("Please enter the seat number correctly");
			}

		}

	}

	public void getSeatsfromuser() {

		System.out.println("Enter the seat Number : ");
		seatno = s.nextLine();
		if (availableseats.contains(seatno)) {
			bookSeat(seatno);
		} else {
			System.out.println("Entered seat is already booked please select the available seats.");

			getSeatsfromuser();

		}
	}

	public void getavailableseats() {

		System.out.println("Available seats are :\n\t-W-\t-S-\t-S-\t-W-");
		for (int i = 0; i < availableseats.size(); i++) {
			count = i + 1;
			System.out.print("\t " + availableseats.get(i));
			if (count % 4 == 0) {
				System.out.println();
			}
		}

	}

	
//	Creating Seats for 2Sitting and set Preferences.

	public void TwoSittingSeats() {

		Map<Character, ArrayList<String>> seatList = new HashMap<Character, ArrayList<String>>();
		seatList.put('W', new ArrayList<String>());
		seatList.put('S', new ArrayList<String>());
		for (int i = 0; i < SSseats.length; i++) {
			count = i + 1;
			if (count % 4 == 0 || count % 4 == 1) {
				SSseats[i] = Integer.toString(count);
				seatList.get('W').add(SSseats[i]);

			} else {
				SSseats[i] = Integer.toString(count);
				seatList.get('S').add(SSseats[i]);

			}
		}
	}
public static void main(String[] args) {
	Reservation_info r=new Reservation_info();
	seatcount=availableseats.size()-bookedseats.size();
	System.out.println(seatcount);
	r.getAvailableTrains();
	
}
}