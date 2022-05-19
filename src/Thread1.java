
public class Thread1 extends Thread {

	public void run() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			System.out.println("Error on sleep time for Thread");
		}
		
		
		
		switch ((Thread.currentThread().getName())) {
		case "car":
			System.out.println("Thread in car : ");
			Motion('c');
			WheelCount(4);
			Stop('c');
			break;
		case "bike":
			System.out.println("Thread bike : ");
			Motion('b');
			Stop('b');
			break;
		case "cycle":
			System.out.println("Thread cycle :");
			WheelCount(2);
			break;

		}
		

	}
synchronized void Motion(char a) {
	
}
	

	public synchronized void Stop(char s) {
		System.out.println("Stop the vehical now.");
	}

	public void WheelCount(int num) {
		System.out.println("wheels count is :" + num);
	}

//	catch(Exception o) {
//		System.out.println("helooooo..");
//	}

	public static void main(String[] args) throws InterruptedException  {
		Thread1 t = new Thread1();
		t.setName("MAin");
		Thread a = new Thread(t);
		a.setName("car");
		Thread t2 = new Thread(t);
		t2.setName("bike");
		Thread t3 = new Thread(t);
		t3.setName("cycle");

//		Thread t4 = new Thread(t);
//		Thread t5 = new Thread(t);
//		Thread t6 = new Thread(t);
//		Thread t7 = new Thread(t);
//		Thread t8 = new Thread(t);
		a.start();
		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();
//		t6.start();
//		t7.start();
//		t8.start();

//		Thread.yield();
//
		for (int i = 1; i <= 5; i++) {
			System.out.println("**");

			try {
				if (i == 2) {
					t3.start();
				}
			} catch (IllegalStateException e) {
				System.out.println("Interrupted time exception..");
			}
			
		}
	}

}