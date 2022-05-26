
public class constructor {
//	overriding toString method.
	public static void hi(){
		String var="a";
		switch(var){
		case "a":var="1";System.out.println(var);break;
		case "b":var="2";System.out.println(var);break;
		case "c":var="3";System.out.println(var);break;
		
		}
	
	}
	
public static void main(String[] args) {
	constructor a=new constructor();

	System.out.println(a.toString("a"));
	
}

}