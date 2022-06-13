package Leet_learnings;

import java.util.Arrays;

public class removeDuplicateArrayElements {
	int k;
	static int [] nums;
	
	public static void main(String[] args) {

		removeDuplicateArrayElements r = new removeDuplicateArrayElements();

		nums = new int[] {1,3,4,2,3,1,5};
		r.removeDuplicates(nums);
		System.out.println(Arrays.toString(nums));

	}

	public int removeDuplicates(int[] nums) {
		System.out.println(Arrays.toString(nums));

//		nums = IntStream.of(nums).distinct().sorted().toArray();
System.out.println(Arrays.toString(nums));
		k = nums.length;
		System.out.println(k);

		return k;
	}

}
