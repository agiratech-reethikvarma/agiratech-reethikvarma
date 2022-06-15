package Train_reservations;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Reservation_info {
	Scanner Scanner_obj = new Scanner(System.in);
	public static String passenger_Name;
	public static int passenger_Age;
	public static String passenger_Gender;
	public static String passenger_ArraivalStation, passenger_DestinationStation;
	public static LocalDate passenger_DateofJourney;
	public static String age_Check, gender_Check;
	public static String dateofJourney_Check;

//Getting information from passenger for reservation .
	public void get_PassengerInfo() {
		System.out.println(" Enter Details of person ");

		do {
			System.out.print("\t Enter Name : ");
			passenger_Name = Scanner_obj.next();
		} while (checkStringFormat(passenger_Name) == false);

		do {

			System.out.print("\t Enter Age : ");
			age_Check = Scanner_obj.next();

		} while (checkNumberFormat(age_Check) == false);
		passenger_Age = Integer.parseInt(age_Check);

		do {
			System.out.print("\t Enter Gender : ");
			passenger_Gender = Scanner_obj.next().toUpperCase();
		} while (checkGenderFormate(passenger_Gender)==false);

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
	public boolean checkStringFormat(String Name) {
		if (Name != null && !Name.matches("^[a-zA-Z]*$")) {
			System.out.println("*** Enter Your Input in valid Alaphabet Format.");
			return false;
		} else {
			return true;
		}
	}

	public static boolean checkNumberFormat(String number) {
		if (number != null && !number.matches("[0-9]{2}") && !number.matches("[0-9]")) {

			System.out.println("*** Enter Input in correct valid number formate.");
			return false;
		} else {
			return true;
		}
	} 
	
	public boolean checkGenderFormate(String gender) {
		if (gender != null && !gender.contentEquals("M") && !gender.contentEquals("MALE")&& !gender.contentEquals("F")
				&& !gender.contentEquals("FEMALE")) {
			System.out.println("*** Enter Gender in Following formate (M/Male)for Male , (F/Female)for Female.");
			return false;
		}else {
			return true;
		}
	}

	public boolean checkDateFormat(String date) {
		try {
			LocalDate localDate = LocalDate.parse(date);
			if (!(LocalDate.now().isBefore(localDate) || LocalDate.now().isEqual(localDate))) {
				System.out.println("***  You Entered Past date Enter in Upcoming (YYYY-MM-DD) Format.");
				return false;
			} else {
				return true;
			}
		} catch (DateTimeParseException ex) {
			System.out.println("*** Enter date in Correct Valid Date In (YYYY-MM-DD) Format. ");
			return false;
		}

	}

}
