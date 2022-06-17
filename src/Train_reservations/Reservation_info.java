package Train_reservations;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

public class Reservation_info {
	Scanner Scanner_obj = new Scanner(System.in);
	public static String passenger_Name;
	public static int passenger_Age;
	public static String passenger_Gender;
	public static Date passenger_dateOfJourney;
	public static String passenger_ArraivalStation, passenger_DestinationStation;
	public static String age_Check, gender_Check;
	public static String dateofJourney;

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
		} while (checkGenderFormate(passenger_Gender) == false);

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
			System.out.print("\n Enter the Date of journey in (DD/MM/YYYY) formate : ");
			dateofJourney = Scanner_obj.next();
			Train_info.user_DatePattern.setLenient(false);
		} while (checkDateFormat(dateofJourney) == false);
		try {
		passenger_dateOfJourney=Train_info.user_DatePattern.parse(dateofJourney);
		}catch(ParseException P) {
			System.out.println("### Given Date Not stored In Data ###");
		}

		System.out.println();
		train_info.check_AvailableTrains();

	}

//	Check Input Format is correct or not.
	private static boolean checkStringFormat(String Name) {
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

	private static boolean checkGenderFormate(String gender) {
		if (gender != null && !gender.contentEquals("M") && !gender.contentEquals("MALE") && !gender.contentEquals("F")
				&& !gender.contentEquals("FEMALE")) {
			System.out.println("*** Enter Gender in Following formate (M/Male)for Male , (F/Female)for Female.");
			return false;
		} else {
			return true;
		}
	}

	private static boolean checkDateFormat(String date) {
		String[] split = date.split("/");
		try {
			Date Ddate = Train_info.user_DatePattern.parse(date);
			Date NowDate = Train_info.user_DatePattern.parse(Train_info.user_DatePattern.format(new Date()));

			if ((Integer.parseInt(split[0]) <= 31 && Integer.parseInt(split[0]) > 0) && Integer.parseInt(split[1]) > 0
					&& Integer.parseInt(split[1]) <= 12) {

				if (Ddate.before(NowDate) || Ddate.equals(NowDate)) {
					System.out.println("***  You Entered Past date .");
					return false;
				} else {
					return true;
				}
			} else {
				System.out.println("*** Enter Date In Valid format With correct Day and Month (DD/MM/YYYY)");
				return false;
			}
		} catch (ParseException E) {
			System.out.println("*** Enter Date In Valid format With correct Day and Month (DD/MM/YYYY)");
			return false;
		}

	}
}
