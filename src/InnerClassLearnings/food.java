package InnerClassLearnings;


public class food {

	
	popcorn p=new popcorn() {
		void pop() {
			System.out.println("popcorn anonymous inner class..");
		}
		
	};
	public void popit() {
		p.pop();
	}
	public static void main(String[] args) {
		
		food f=new food() ;
//			
//				void pop() {
//					System.out.println("popcorn from food instance ...");
//				}
//		};
	
		f.p.pop();
		
		f.popit();

		
	}
}
class popcorn{
	void pop() {
		System.out.println("popcorn..");
	}
	
}