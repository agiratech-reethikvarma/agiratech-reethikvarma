package Train_reservations;

import java.util.Scanner;

public class Main_train {

	static int Choice;
	static boolean CheckChoice = true;
	static Scanner scanner = new Scanner(System.in);

//	Main method.

	public static void main(String[] args) {
//		Main_train main_train = new Main_train();
		System.out.println("WELCOME TO TRAIN TICKET RESERVATION COUNTER.");

		Train_info.setTrains();

		while (CheckChoice) {
			DoFunctionsFor();
			if (Choice == 5) {
				break;
			}
		}
	}

// Giving the Options to perform specific action on selection.
	public static void DoFunctionsFor() {
		Reservation_info reservation_info = new Reservation_info();
		BookSeats bookseats = new BookSeats();
//		Train_info train_info = new Train_info();

		System.out.println("----- MAIN MENU -----\n");
		System.out.println("1. Available Trains.");
		System.out.println("2. Reserve a Ticket.");
		System.out.println("3. View All Tickets.");
		System.out.println("4. Cancel The Ticket.");
		System.out.println("5. Exit\n");

		System.out.print("Select the option: ");
		Choice = scanner.nextInt();

		switch (Choice) {
		case 1:
			reservation_info.get_Trains_Info();
//			bookseats.get_All_Seats_of_train();
			break;
		case 2:
				reservation_info.get_Passenger_Info();
//				bookseats.TwoSittingSeats();
//				bookseats.getSeatsfromuser();

			break;
		case 3:
			bookseats.getAllTickets();
			break;
		case 4:
			bookseats.cancelTicket();
			break;
		case 5:
			System.out.println("\tThank You Have a Nice Day.");
			System.out.println("\t#--#--#--#--#\t END\t#--#--#--#--#");
			CheckChoice = false;
			break;
		default:
			System.out.println("Please select the correct option.");

		}

	}

}
