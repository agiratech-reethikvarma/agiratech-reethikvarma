package Train_reservations;

import java.util.Map;
import java.time.LocalDate;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class BookSeats {
	BookSeats(){
		
	}
	
	
	Scanner s = new Scanner(System.in);
	static int count = 0;
	static ArrayList<String> bookedseats = new ArrayList<String>();
	ArrayList<String> availableseats = new ArrayList<String>();

	int seatcount;// ****
	String seatno;
	static String[] SSseats = new String[20];
	

// Get seats from user and bookes the ticket
	static {
		BookSeats b=new BookSeats();
		for (int i = 0; i < SSseats.length; i++) {
			count = i + 1;
			SSseats[i]=Integer.toString(count);
			b.availableseats.add(SSseats[i]);
			}
	}
	public void bookSeat(String seatno) {

		if (bookedseats.contains(seatno)) {
			System.out.println("Entered seat is already booked please select the available seats.");

			getSeatsfromuser();
//			Main_train ms=new Main_train();
//			ms.doFunctionsFor();

		} else {
			
			int Iseatno=Integer.parseInt(seatno);

			if (Iseatno> 0 && Iseatno < 21) {
				if ( Iseatno% 4 == 0 || Iseatno % 4 == 1) {
					System.out.println("Booked window seat:" + seatno);
					bookedseats.add(seatno);
					availableseats.set((Iseatno-1), "R");
//					getbookedseats();

				} else if (Iseatno % 4 == 2 || Iseatno % 4 == 3) {
					System.out.println("Booked Asile Seat:" + seatno);
					bookedseats.add(seatno);
					availableseats.set((Iseatno - 1), "R");
//					getbookedseats();
				} else {
					System.out.println("There are no available seats.");
				}

			} else {
				System.out.println("Please enter the seat number correctly");
			}


		}

	}

// Checking book seat in arraylist
//	public void getbookedseats() {
////		count=bookedseats.size();
//		System.out.println("Booked seat is :");
//			count=bookedseats.size()-1;
//			System.out.print(bookedseats.get(count));
//
//	}

//Runtime input to get seats from user
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
			count=i+1;
			System.out.print("\t " + availableseats.get(i));
			if (count % 4 == 0) {
				System.out.println();
			}
		}

	}
//
//	public static void main(String[] args) {
//		BookSeats s = new BookSeats();
//		s.TwoSittingSeats();
//		s.getavailableseats();
////		s.getSeatsfromuser();

//	}

//	Creating Seats for 2Sitting and set Preferences.

	public void TwoSittingSeats() {

		Map<Character, ArrayList<String>> seatList = new HashMap<Character, ArrayList<String>>();
		seatList.put('W', new ArrayList<String>());
		seatList.put('S', new ArrayList<String>());
		for (int i = 0; i < SSseats.length; i++) {
			count = i + 1;
			if (count % 4 == 0 || count % 4 == 1) {
				SSseats[i] =Integer.toString(count);
				seatList.get('W').add(SSseats[i]);
//				availableseats.add(SSseats[i]);
			} else {
				SSseats[i] = Integer.toString(count);
				seatList.get('S').add(SSseats[i]);
//				availableseats.add(SSseats[i]);

			}
		}
	}
		static ArrayList<BookSeats> tokens=new ArrayList<BookSeats>();
		
//		System.out.println("All seats in a coach");
//		System.out.println("\t-W-" + "\t\t-S-" + "\t\t-S-" + "\t\t-W-");
//		for (int i = 0; i < SSseats.length; i++) {
//			count = i + 1;
//			System.out.print("\t " + count + "\t");
//			if (count % 4 == 0) {
//				System.out.println();
//			}
//		}
//		System.out.println("window seats are :" + seatList.get('W') + "\n");
//		System.out.println("Asile seats are :" + seatList.get('S') + "\n");

	int ID;
	int age;
	String name,gen;
	String AS,DS;
	LocalDate DOJ;
	public BookSeats(int ID,String name,int age,String gen ,String AS,String DS,LocalDate DOJ) {
		this.ID=ID;
		this.name=name;
		this.age=age;
		this.AS=AS;
		this.DS=DS;
		this.DOJ=DOJ;
		
		
		
		
		
	}
	int genlen;//******
	void Tokengen(int count) {
		Reservation_info r=new Reservation_info();
		
		for(int i=0;i<genlen;i++) {
			genlen=i+1;
//			tokens.add(new BookSeats(genlen,Reservation_info.name,Reservation_info.age,Reservation_info.gen,Reservation_info.ASN,Reservation_info.DSN,Reservation_info.RD));
//			convert the DOJ to LocalDate formate because it is in String formate.
			genlen=genlen;
		}
	}
	
	

}
