package Train_reservations;

import java.util.Scanner;

import java.time.LocalDate;

public class Reservation_info {
	Scanner scanner = new Scanner(System.in);
	public static String Name;
	public static int Age;
	public static char Gender;
	public static String Arraival_Station, Destination_Station, UserDate;
	public static LocalDate Date_of_Journey;
	public static String AGE_Check;

//Getting information from passenger for reservation .
	public void get_Passenger_Info() {
		System.out.println(" Enter Details of person ");

		do {
			if (Name != null && !Name.matches("^[a-zA-Z]*$")) {
				System.out.println("ENter your Name in Correct Formate");
			}
			System.out.print("\t Name : ");
			Name = scanner.nextLine();
		} while (!(Name.matches("^[a-zA-Z]*$")));

		do {
			if (AGE_Check != null && !AGE_Check.matches("[0-9]{2}") && !AGE_Check.matches("[0-9]")) {

				System.out.println("Enter your Age in correct formate.");
			}
			System.out.print("\t Age : ");
			AGE_Check = scanner.next();

		} while (!AGE_Check.matches("[0-9]{2}") && !AGE_Check.matches("[0-9]"));
		Age = Integer.parseInt(AGE_Check);

		System.out.print("\t Gender :");
		Gender = scanner.next().charAt(0);

		get_Trains_Info();
	}

// Get the details to check available Trains 
	public void get_Trains_Info() {
		Train_info train_info = new Train_info();
		System.out.print("\n Enter the Arrival Station name : ");
		Arraival_Station = scanner.next();
		Arraival_Station = Arraival_Station.toUpperCase();
		System.out.print("\n Enter the Destination name : ");
		Destination_Station = scanner.next();
		Destination_Station = Destination_Station.toUpperCase();
		System.out.print("\n Enter the Date of journey in (YYYY-MM-DD) formate : ");
		UserDate = scanner.next();
		Date_of_Journey = LocalDate.parse(UserDate);
		System.out.println();
		train_info.Check_Available_Trains();

	}

}
