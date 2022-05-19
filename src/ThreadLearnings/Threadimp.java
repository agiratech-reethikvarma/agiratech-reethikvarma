
package ThreadLearnings;

import java.util.Scanner;

public class Threadimp extends Thread {
	int total = 100, getb;

	int bal;

//public class Threadimp implements Runnable {
	public synchronized void run() {
		 
		try {

			while(total >0){
				System.out.println("Thread is now running.." + Thread.currentThread().getName());
				System.out.println("Total balence is :" + total);
				Scanner s = new Scanner(System.in);
				System.out.println("Enter the amount to be withdrawn: ");
				getb = s.nextInt();
				if (getb<=total) {
					accountact();
					
				} else {
					System.out.println("Insufficient balance...");
				}

			}

		} catch (Exception e) {
		}

	}

	public static void main(String[] args) throws InterruptedException, IllegalMonitorStateException, Exception {
		Threadimp th = new Threadimp();
		Thread t1 = new Thread(th);
		Thread t2 = new Thread(th);

//		th.start();

		t1.start();

		t2.start();

	}

	synchronized void accountact() {

		withdraw(getb);
	}

	void getBalance(int total) {
		total = total - getb;

	}

	void withdraw(int getb) {
		System.out.println(Thread.currentThread().getName() + " is withdrawing....");
		total -= getb;
		try {
			sleep(2000);
		} catch (InterruptedException ie) {
		}
		System.out.println("Balance after " + Thread.currentThread().getName() + "withdrawing total is : " + total);
		notify();
	}

}