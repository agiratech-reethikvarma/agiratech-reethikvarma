
public class one {
int b;
	one (int b){
		System.out.println("This is one class constructor value is : "+b);
	}
	one(){
		System.out.println("this is super one constructor....");
	}
	public static void main(String[] args) {
		
// Primitive data types 
		
		int i = 1; // A 32-bit integer (signed).
		byte b = 0123; // An 8-bit integer (signed).
		float f = 123.123f; // A 32-bit floating-point number (signed).
		double d = 123456789.0123456789; // A 64-bit floating-point number (signed).
		long l = 1234567890; // A 64-bit integer (signed).
		short s = 12345; // A 16-bit integer (signed).
		char c = 'a';// A single Unicode character (16-bit unsigned)
		boolean bo = true; // A value indicating true or false.

		String st = "abcdef..";// A set of Characters (String is an object of array )

	
		int num = 1; // Variable declaration.

		System.out.println((num++) + " Int =" + i);
		System.out.println((num++) + " Byte =" + b);
		System.out.println((num++) + " Float =" + f);
		System.out.println((num++) + " Double =" + d);	
		System.out.println((num++) + " Long =" + l);
		System.out.println((num++) + " Short =" + s);
		System.out.println((num++) + " Char =" + c);
		System.out.println((num++) + " Boolean =" + bo);
		System.out.println((num++) + " String =" + st);
		System.out.println("****************");
		
		
		char uni='\u0061'; // char can also be given unicode , ASCII values. 
		System.out.println("Printing unicode value:"+uni);

	}

}