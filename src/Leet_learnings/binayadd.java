package Leet_learnings;

public class binayadd {
	public String addBinary(String a, String b) {
		long ia, ib, ival;

		try {
			if ((a.length() >= 1) && (b.length() <= 1000)) {
			}
		} catch (NumberFormatException n) {
		}
		if ((a.length() >= 1) && (b.length() <= 1000)) {
			ia = Long.parseLong(a, 2);
			System.out.println(ia);
			ib = Long.parseLong(b, 2);
			System.out.println(ib);
			ival = ia + ib;
			System.out.println(ival);
			System.out.println("Binary addition value of given number is : " + Long.toBinaryString(ival));
		} else {
			ival = 0;
		}

		return Long.toString(ival);

	}

	public static void main(String[] args) {

		binayadd b = new binayadd();
		b.addBinary("1010", "010");

	}
}
