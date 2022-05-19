import java.util.ArrayList;

public class commonPrefix {

	public void longestCommonPrefix(String[] strs) {
	String a1,a2,a3;
		
	a1=strs[0];
//		a1=strs[0];
		for(int i=0;i<strs.length;i++) {
		System.out.println(strs[i]);
		
		}
		System.out.println(a1);

	}

	public static void main(String[] args) {
		commonPrefix c = new commonPrefix();
		String strs[] = { "car", "cat" };
		c.longestCommonPrefix(strs);

	}

}
