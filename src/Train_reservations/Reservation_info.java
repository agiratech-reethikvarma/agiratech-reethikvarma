package Train_reservations;

import java.util.Scanner;

public class Reservation_info {
	static Scanner sc = new Scanner(System.in);
	public static String name;
	public static int age;
	public static char gen;
//	public static int NoOfPassengers;
	public static String ASN, DSN, RD;

	Scanner s = new Scanner(System.in);
	Train_info t=new Train_info();

//Getting information from passenger for reservation .
	public void getInfo() {

//		System.out.print("\n Enter the number of Passengers :  ");
//		NoOfPassengers = s.nextInt();
//		name = new String[NoOfPassengers];

		System.out.println(" Enter Details of person ");
		System.out.print("\t Name : ");
		name = s.next();
		System.out.print("\t Age : ");
		age = s.nextInt();
		System.out.print("\t Gender :");
		gen = s.next().charAt(0);

		getAvailableTrains();
	
//		getReservationDetails();
	}
//Show the details Given by user for Conformation.
	public void getReservationDetails() {
		
			System.out.println("\n");
			System.out.println(" Entered details are \n Name : " + name+ "\t Age : " + age
					+ "\t Gender : " + gen+ "\n Arraival Station : " + ASN.toUpperCase()
					+ "\n Destination Station : " + DSN.toUpperCase() + "\n Date of Journey: " + RD);
		
	}

	public void getAvailableTrains() {
		System.out.print("\n Enter the Arrival Station name : ");
		ASN = s.next();
		ASN=ASN.toUpperCase();
		System.out.print("\n Enter the Destination name : ");
		DSN = s.next();
		DSN=DSN.toUpperCase();
		System.out.print("\n Enter the Date of journey in (YYYY-MM-DD) formate : ");
		RD = s.next();
		System.out.println();

t.search();
	}
	
	
//	public static void main(String[] args) {
//		Reservation_info r = new Reservation_info();
//		System.out.println("--- Welcome to Train Ticket Reservation Counter  ---");
//		r.getInfo();
//
//	}

}
