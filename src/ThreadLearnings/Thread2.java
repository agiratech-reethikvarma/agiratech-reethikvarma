package ThreadLearnings;

public class Thread2 extends Thread {
	public void run() {
		for(int i=0;i<=30;i++) {
		System.out.println("Thread is running ...." + currentThread().getName());
		try {
			System.out.println("state of Thread is : " +currentThread().getName()+"--"+ currentThread().getState());
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		System.out.println("state of Thread is after sleep: "+currentThread().getName()+"--"+ currentThread().getState());
		}
	}

	public static void main(String[] args) {
		
		Thread2 t=new Thread2();
		Thread2 t1=new Thread2();
		Thread2 t2=new Thread2();
	
		
		t.start();
		t1.start();
		t2.start();
	
		
		
//		System.out.println("state of thread :" + t.getState());
//		System.out.println("state of thread :" + t2.getState());

	}

}