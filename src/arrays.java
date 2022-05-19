
public class arrays extends one  {
	int a;
	arrays(int a){
		super();
		System.out.println("value is :"+a);
		
	}
	
	arrays(){
		System.out.println("This is Arrays class constructor...");
		
	}

	public static void main(String[] args) {
		// Constructing Array ,Declaring array variable,Initializing array for Primitive
		// types.

		// Array Declaration.
//		int[] ary1;
//		ary1 = new int[3];
		// Array Construction.
//		ary1[0] = 1;
//		ary1[1] = 2;
//		ary1[2] = 3;
		// Initializing the array.
//		for (int i = 0; i < ary1.length; i++) {
//			System.out.println("Array Elements are: " + ary1[i]);
			
			
			arrays a=new arrays(5);
			System.out.println(a.getClass());
		

	}

}