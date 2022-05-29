package Train_reservations;

import java.util.Scanner;

public class Main_train {
	static int choice;
	static boolean b = true;
	private Scanner s;

	BookSeats bs = new BookSeats();
	Reservation_info r = new Reservation_info();
	Train_info t = new Train_info();
	
//	Main method.

	public static void main(String[] args) {
		Main_train ms = new Main_train();
		System.out.println("WELCOME TO TRAIN TICKET RESERVATION COUNTER.");

		while (b) {
			ms.doFunctionsFor();
			if (choice == 5) {
				break;
			}
		}
	}
// Giving the Options to perform specific action on selection.
	public void doFunctionsFor() {
		System.out.println("----- MAIN MENU -----\n");
		System.out.println("1. Available Trains.");
		System.out.println("2. Reserve a Ticket.");
		System.out.println("3. View All Tickets.");
		System.out.println("4. Cancel The Ticket.");
		System.out.println("5. Exit\n");

		s = new Scanner(System.in);
		System.out.print("Select the option: ");
		choice = s.nextInt();

		switch (choice) {
		case 1:
			r.getAvailableTrains();
			break;
		case 2:
			r.getInfo();
			bs.TwoSittingSeats();
			bs.getSeatsfromuser();
			break;
		case 3:
			bs.getAllTickets();
			break;
		case 4:
			bs.cancelTicket();
			break;
		case 5:
			System.out.println("\tThank You Have a Nice Day.");
			System.out.println("\t#--#--#--#--#\t END\t#--#--#--#--#");
			b = false;
			break;
		default:
			System.out.println("Please select the correct option.");

		}

	}

}
