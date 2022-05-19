package Leet_learnings;

public class sample {
//	public void digitSum(String s, int k) {
//		String result;
//		System.out.println("STring is :" + s);
//		while (s.length() > k) {
//
//			CharSequence a, b;
//			String ns, ns1;
//			int r = s.length() % k;
//
//			CharSequence c, d;
//			String ens, ens1;
//
//			for (int i = 0; i < s.length(); i += k) {
//				String temp = "", temp2 = "";
//				int res = 0;
//				if ((i + k) <= s.length()) {
//					a = s.subSequence(i, i + k);
//
//					ns = a.toString();
//
//					for (int j = 0; j < ns.length(); j++) {
//						b = ns.subSequence(j, j + 1);
//						ns1 = b.toString();
//						res = res + (Integer.parseInt(ns1));
//
//					}
//
//					temp = temp + (Integer.toString(res));
//					System.out.println(temp);
//
//				} else if ((i + k) > s.length()) {
//
//					int res2 = 0;
//					c = s.subSequence(i, i + r);
//					ens = c.toString();
//					for (int j = 0; j < c.length(); j++) {
//						d = ens.subSequence(j, j + 1);
//						ens1 = d.toString();
//						res2 = res2 + (Integer.parseInt(ens1));
//
//					}
//					temp2 = temp + (Integer.toString(res2));
//					System.out.println(temp2);
//				}
//
//				s = temp2;
//
//			}
//
//		}
//		result = s;
//		System.out.println("Result is :" + result);
//
//	}

	public void removeElement(int[] nums, int val) {
		int j=0;
//		int[] num1=new int[nums.length];
		
		int len = 0;
		for (int i = 0; i < nums.length; i++) {

			System.out.println("before removing" + nums[i]);
			if (nums[i] != val) {
					nums[j]= nums[i];
				len = len + 1;
				j++;
			}

		}
		
		System.out.println("value is:" + len);
		
		for (int i = 0; i < len; i++) {
			System.out.println("new array nums are:" + nums[i]);
	
		}
		
		System.out.println("length of new array is:"+nums.length);
	}

	public static void main(String[] args) {
		sample sb = new sample();

		int[] nums = { 1, 1, 3, 4, 5, 1 };
		int val = 1;
		sb.removeElement(nums, val);

	}
}
