package Leet_learnings;


import java.util.TreeMap;

public class romantoInt {

	public static void rtn(String rom) {
		String res="";
		String[] val=new String[10];
		int len=rom.length();
		
		rom=rom.toUpperCase();
System.out.println("length:"+len);
		for (int i = len-1;i>0; i--) {
			
		switch(rom.charAt(i)) {
		case 'I':val[i]="1";break;
		case 'V':val[i]="5";break;
		case 'X':val[i]="10";break;
		case 'L':val[i]="50";break;
		case 'C':val[i]="100";break;
		case 'D':val[i]="500";break;
		case 'M':val[i]="1000";break;
			
		}
			
			
		System.out.println("values of :"+val[i]);
	int	n1= Integer.parseInt(val[i]) ;
//			int n2=Integer.parseInt(val[i-1]) ;
			System.out.println("integer values of num 1 and num 2 is : "+n1);
//			if (n1>=n2) {
//			res=val[i];
//			System.out.println(res);
//				
//			}
		}
			
	}

	public static void main(String[] args) {
		TreeMap<Character, Integer> list = new TreeMap<Character, Integer>();
		list.put('I', 1);
		list.put('V', 5);
		list.put('X', 10);
		list.put('L', 50);
		list.put('C', 100);
		list.put('D', 500);
		list.put('M', 1000);
		
System.out.println(list);
		
		rtn("vii");
		
		
		
		
		
		
		
		
	}

}
