package ThreadLearnings;

public class ThreadDemo implements Runnable {
	
	public void run() {
		
		System.out.println("Thread is now running.."+ Thread.currentThread().getName());
		
	}

	public static void main(String[] args) {
		ThreadDemo th=new ThreadDemo();
		ThreadDemo th2=new ThreadDemo();
		Thread t1=new Thread(th);
		Thread t2=new Thread(th2);
		
		t1.start();
		t2.start();
	}

}