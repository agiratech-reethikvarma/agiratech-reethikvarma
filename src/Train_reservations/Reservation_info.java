package Train_reservations;

import java.util.Scanner;

import java.time.LocalDate;

public class Reservation_info {
	Scanner Scanner_obj = new Scanner(System.in);
	public static String passenger_Name;
	public static int passenger_Age;
	public static char passenger_Gender;
	public static String passenger_Arraival_Station, passenger_Destination_Station, passenger_Date_Of_Journey;
	public static LocalDate Date_of_Journey;
	public static String AGE_Check;

//Getting information from passenger for reservation .
	public void get_Passenger_Info() {
		System.out.println(" Enter Details of person ");

		do {
			if (passenger_Name != null && !passenger_Name.matches("^[a-zA-Z]*$")) {
				System.out.println("Enter your passenger_Name in Correct Formate");
			}
			System.out.print("\t passenger_Name : ");
			passenger_Name = Scanner_obj.nextLine();
		} while (!(passenger_Name.matches("^[a-zA-Z]*$")));

		do {
			if (AGE_Check != null && !AGE_Check.matches("[0-9]{2}") && !AGE_Check.matches("[0-9]")) {

				System.out.println("Enter your passenger_Age in correct formate.");
			}
			System.out.print("\t passenger_Age : ");
			AGE_Check = Scanner_obj.next();

		} while (!AGE_Check.matches("[0-9]{2}") && !AGE_Check.matches("[0-9]"));
		passenger_Age = Integer.parseInt(AGE_Check);

		System.out.print("\t passenger_Gender :");
		passenger_Gender = Scanner_obj.next().charAt(0);

		get_Trains_Info();
	}

// Get the details to check available Trains 
	public void get_Trains_Info() {
		Train_info train_info = new Train_info();
		System.out.print("\n Enter the Arrival Station name : ");
		passenger_Arraival_Station = Scanner_obj.next();
		passenger_Arraival_Station = passenger_Arraival_Station.toUpperCase();
		System.out.print("\n Enter the Destination name : ");
		passenger_Destination_Station = Scanner_obj.next();
		passenger_Destination_Station = passenger_Destination_Station.toUpperCase();
		System.out.print("\n Enter the Date of journey in (YYYY-MM-DD) formate : ");
		passenger_Date_Of_Journey = Scanner_obj.next();
		Date_of_Journey = LocalDate.parse(passenger_Date_Of_Journey);
		System.out.println();
		train_info.Check_Available_Trains();

	}

}
