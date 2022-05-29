package Train_reservations;

import java.util.Scanner;

public class Reservation_info {
	Scanner sc = new Scanner(System.in);
	public static String name;
	public static int age;
	public static char gen;
	public static String ASN, DSN, RD;

	Scanner s = new Scanner(System.in);
	Train_info t = new Train_info();

//Getting information from passenger for reservation .
	public void getInfo() {
		System.out.println(" Enter Details of person ");
		System.out.print("\t Name : ");
		name = s.next();
		System.out.print("\t Age : ");
		age = s.nextInt();
		System.out.print("\t Gender :");
		gen = s.next().charAt(0);
		getAvailableTrains();
	}

// Get the details to check available Trains 
	public void getAvailableTrains() {
		System.out.print("\n Enter the Arrival Station name : ");
		ASN = s.next();
		ASN = ASN.toUpperCase();
		System.out.print("\n Enter the Destination name : ");
		DSN = s.next();
		DSN = DSN.toUpperCase();
		System.out.print("\n Enter the Date of journey in (YYYY-MM-DD) formate : ");
		RD = s.next();
		System.out.println();
		t.search();
	}

}
