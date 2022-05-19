package Leet_learnings;

public class bitLenOf1 {
	public void hammingWeight(int n) {
		
		int result = 0;
		
		

		System.out.println("value of n is : " + n);
		String num = String.valueOf(n);
		System.out.println(num);
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) == '1') {
				result = result + 1;
			}

		}
System.out.println(result);
	}

	public static void main(String[] args) {
		bitLenOf1 b = new bitLenOf1();
		b.hammingWeight(01010);

	}

}
