package InnerClassLearnings;

//Anonymous class Implementation.

public class AnonymousInner {

	public static void main(String[] args) {
//creating instance for anonymous class inside our main class and implementing its methods.and override its method's body.
		anonymous a = new anonymous() {
			void dis() {
				System.out.println("calling Inner class method overrided dis()...");
			}
		};
		a.dis();// can call without main class instance.
	}

}



//any unknown anonymous class.
class anonymous {
	void dis() {
		System.out.println("Anonymous class method  display.....");
	}
}

////Anonymous inner class Implementation using interface Example.
//public class AnonymousInner implements InterfaceSample {
//	@Override
//	public void B() {
//
//		System.out.println("This is Inteface method using override and implementation....");
//	}
//
//	public static void main(String[] args) {
//		anonymousInner ai = new anonymousInner();
//		ai.B();
//
//	}
//}