package ThreadLearnings;
public class wrapperclass {
	public static void main(String args[]) {

		Integer a = new Integer(1);
		int i = a.intValue();
		int  j = a;

		System.out.println(a + " " + i + " " + j);
	}
}