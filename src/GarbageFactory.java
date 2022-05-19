import java.util.Date;

public class GarbageFactory {
//	public static void main(String[] args) {
//		Date d = getDate();
//		doComplicatedStuff();
//		System.out.println("d = " + d);
//	}

	public static void getDate() {
		Date d2 = new Date();
		System.out.println(d2);
		String now = d2.toString();
		
		System.out.println("");
		
		System.out.println(now);

	}
	public static void main(String[] args) {
		getDate();
	}
}