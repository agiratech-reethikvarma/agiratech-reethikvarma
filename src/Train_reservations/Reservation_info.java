package Train_reservations;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Reservation_info {
	Scanner Scanner_obj = new Scanner(System.in);
	public static String passenger_Name;
	public static int passenger_Age;
	public static char passenger_Gender;
	public static String passenger_ArraivalStation, passenger_DestinationStation;
	public static LocalDate passenger_DateofJourney;
	public static String age_Check, gender_Check;
	public static String dateofJourney_Check;

//Getting information from passenger for reservation .
	public void get_PassengerInfo() {
		System.out.println(" Enter Details of person ");

		do {
			System.out.print("\t passenger_Name : ");
			passenger_Name = Scanner_obj.nextLine();
		} while (checkStringFormat(passenger_Name) == false);

		do {
			if (age_Check != null && !age_Check.matches("[0-9]{2}") && !age_Check.matches("[0-9]")) {

				System.out.println("*** Enter passenger_Age in correct valid number formate.");
			}
			System.out.print("\t passenger_Age : ");
			age_Check = Scanner_obj.next();

		} while (!age_Check.matches("[0-9]{2}") && !age_Check.matches("[0-9]"));
		passenger_Age = Integer.parseInt(age_Check);

		do {
			if (passenger_Gender != '\u0000' && Character.compare(passenger_Gender, 'M') != 0
					&& Character.compare(passenger_Gender, 'F') != 0) {
				System.out.println("*** Enter passenger_Gender in Following formate (Male,Female)/(M,F).");
			}
			System.out.print("\t passenger_Gender :");
			passenger_Gender = Scanner_obj.next().toUpperCase().charAt(0);
		} while (Character.compare(passenger_Gender, 'M') != 0 && Character.compare(passenger_Gender, 'F') != 0);

		get_TrainsInfo();
	}

// Get the details to check available Trains 
	public void get_TrainsInfo() {
		Train_info train_info = new Train_info();
		do {
			System.out.print("\n Enter the Arrival Station name : ");
			passenger_ArraivalStation = Scanner_obj.next();
		} while (checkStringFormat(passenger_ArraivalStation) == false);
		passenger_ArraivalStation = passenger_ArraivalStation.toUpperCase();

		do {
			System.out.print("\n Enter the Destination name : ");
			passenger_DestinationStation = Scanner_obj.next();
		} while (checkStringFormat(passenger_DestinationStation) == false);
		passenger_DestinationStation = passenger_DestinationStation.toUpperCase();

		do {
			System.out.print("\n Enter the Date of journey in (YYYY-MM-DD) formate : ");
			dateofJourney_Check = Scanner_obj.next();
		} while (checkDateFormat(dateofJourney_Check) == false);
		passenger_DateofJourney = LocalDate.parse(dateofJourney_Check);

		System.out.println();
		train_info.check_AvailableTrains();

	}

//	Check Input Format is correct or not.
	private boolean checkStringFormat(String Name) {
		if (Name != null && !Name.matches("^[a-zA-Z]*$")) {
			System.out.println("*** Enter Your Input in valid Alaphabet Format.");
			return false;
		} else {
			return true;
		}

	}

	private boolean checkDateFormat(String date) {
		try {
			LocalDate localDate = LocalDate.parse(date);
			if (!(LocalDate.now().isBefore(localDate) || LocalDate.now().isEqual(localDate))) {
				System.out.println("***  You Entered Past date Enter in Upcoming (YYYY-MM-DD) Format.");
				return false;
			} else {
				return true;
			}
		} catch (DateTimeParseException ex) {
			System.out.println("*** Enter date in Correct Valid (YYYY-MM-DD) Format. ");
			return false;
		}

	}

}
