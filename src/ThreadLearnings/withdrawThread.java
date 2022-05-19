package ThreadLearnings;

import java.util.Scanner;

public class withdrawThread extends Thread {

	int menu;
	int balance = 2000;
	int acno;

	public static void main(String[] args) {
		withdrawThread th = new withdrawThread();
		Thread t1 = new Thread(th);
		t1.setName("1. Reethik");
		withdrawThread th2 = new withdrawThread();
		Thread t2 = new Thread(th2);
		t2.setName("2. Varma");

		t1.start();

		t2.start();

	}

	public synchronized void run() {
		try{
			accountactions();
		}catch(Exception e) {}

	}

	synchronized void accountactions() {
		Scanner s = new Scanner(System.in);

		System.out.println("Please select any option given above:");
		System.out.println("1. Check Balance");
		System.out.println("2. Withdraw money");
		System.out.println("3. Exit");
		
		menu = s.nextInt();
		switch (menu) {
		case 1:
			checkbal();
			break;
		case 2:
			break;
		case 3:
			exit();
			break;
		}
		notify();

	}
	

	public void exit() {
		System.out.println("Transactions finished ...\n Thankyou");
		notify();
	}

	public void checkbal() {
		System.out.println("Your Balance is : " + balance);
		accountactions();
	}

}