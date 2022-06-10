package Train_reservations;

import java.util.Scanner;

public class Main_train {

	static int choice;
	static boolean checkChoice = true;
	static Scanner scanner = new Scanner(System.in);

//	Main method.

	public static void main(String[] args) {
		System.out.println("WELCOME TO TRAIN TICKET RESERVATION COUNTER.");
		Train_info.set_TrainsInformations();
		while (checkChoice) {
			DoFunctionsFor();
			if (choice == 5) {
				break;
			}
		}
	}

// Giving the Options to perform specific action on selection.
	public static void DoFunctionsFor() {
		Reservation_info reservation_info = new Reservation_info();
		BookSeats bookseats = new BookSeats();
		Train_info train=new Train_info();
		System.out.println("----- MAIN MENU -----\n");
		System.out.println("1. Get All Trains List."+
						"\n2. Available Trains."+
						"\n3. Reserve a Ticket."+
						"\n4. View All Tickets."+
						"\n5. Cancel The Ticket."+
						"\n6. Exit\n");
		System.out.print("Select the option: ");
		choice = scanner.nextInt();

		if (choice == 4 || choice == 5 && BookSeats.tickets_List.isEmpty()) {
			System.out.println("*** No Available Tickects To Do This Action.");
		}

		switch (choice) {
		case 1:
			train.get_AllTrainsList();
			break;
		case 2:
			reservation_info.get_TrainsInfo();
			break;

		case 3:
			reservation_info.get_PassengerInfo();
			break;
		case 4:
			bookseats.get_AllTickets();
			break;
		case 5:
			bookseats.cancel_Ticket();
			break;
		case 6:
			System.out.println("\tThank You Have a Nice Day.");
			System.out.println("\t#--#--#--#--#\t END\t#--#--#--#--#");
			checkChoice = false;
			break;
		default:
			System.out.println("Please select the correct option.");

		}

	}

}
