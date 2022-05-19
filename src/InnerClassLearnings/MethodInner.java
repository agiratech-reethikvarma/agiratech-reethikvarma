package InnerClassLearnings;

//Method Local InnerClass Implementation...
public class MethodInner {
	

	public void imp() {
		
		class inner {
			void inSee() {
				System.out.println("Inner class statement.....");
			}
		}
		
		
		System.out.println("this is implement method from outer class...");
		inner i=new inner();
		
		i.inSee();

	}

	public static void main(String[] args) {

		MethodInner m=new MethodInner();
		m.imp();
	
	}

}