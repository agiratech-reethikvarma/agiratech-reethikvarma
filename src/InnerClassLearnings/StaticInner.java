package InnerClassLearnings;


//Static Inner Class Implementation
public class StaticInner {

	class inner {
		void call() {
			System.out.println("Method call of Static Inner class...");

		}
	}

	void outstatement() {
		System.out.println("Method call of outer class....");
	}

	public static void main(String[] args) {
		StaticInner s = new StaticInner();
		// creating instance for calling static inner class.
		StaticInner.inner i = s.new inner();
		i.call();
		s.outstatement();

	}

}


