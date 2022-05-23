package Train_reservations;

import java.util.Scanner;

public class Reservation_info {

	public String[] name;
	public int[] age;
	public char[] gen;
	public int PCount;
	public String ASN,DSN;

	Scanner s = new Scanner(System.in);

	public void getInfo() {

		System.out.print("\n\n Enter the number of Passengers : ");
		PCount = s.nextInt();
		name = new String[PCount];
		
		age=new int[PCount];
		gen=new char[PCount];
		
		getinfo();
		
		System.out.print("Enter the Arrival Station name : ");
		ASN=s.next();
		System.out.print("Enter the Destination name : ");
		DSN=s.next();
		for (int i = 0; i < PCount; i++) {
			System.out.println((i+1)+" Entered detatils are \n Name : " + name[i] + "\t Age:" + age[i] + "\t Gender : " + gen[i]+"\n Arraival Station : "+ASN+"\n Destination Station : "+DSN);
		}
	}

	public void getinfo() {
		
		for (int i = 0; i < PCount; i++) {
			System.out.print((i+1)+" Enter Your Name : ");
			name[i] = s.next();
			System.out.print(" Enter Your Age : ");
			age[i] = s.nextInt();
			System.out.print(" Enter Your Gender :");
			gen[i] = s.next().charAt(0);
		}
	}

	public static void main(String[] args) {
		Reservation_info r = new Reservation_info();
		System.out.println("--- Welcome to Train Ticket Reservation Counter  ---");
		r.getInfo();

	}

}
