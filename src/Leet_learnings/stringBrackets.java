package Leet_learnings;

public class stringBrackets {

	public String digitSum(String s, int k) {

		while (s.length() > k) {

			String temp = "";
			CharSequence a;
			String ns;
			for (int i = 0; i < s.length(); i += k) {
				int res=0;
				if ((i + k) <= s.length()) {
		
					ns = s.subSequence(i, i + k).toString();

					for (int j = 0; j < ns.length(); j++) {
						a = ns.subSequence(j, j + 1);
						
						res = res + (Integer.parseInt(a.toString()));

					}

					temp = temp + (Integer.toString(res));
				} else if ((i + k) > s.length()) {

				
					
					ns =s.subSequence(i, i +(s.length() % k) ).toString();
					for (int j = 0; j < ns.length(); j++) {
						a=ns.subSequence(j, j + 1);
						res = res + (Integer.parseInt(a.toString()));

					}
					temp= temp + (Integer.toString(res));

				}

			}
			s = temp;

		}

System.out.println("result is : "+s);
		return s;

	}

	public static void main(String[] args) {
		stringBrackets sb = new stringBrackets();
		sb.digitSum("123123", 3);

	}
}