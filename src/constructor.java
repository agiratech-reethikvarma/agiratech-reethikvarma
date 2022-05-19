
public class constructor {
//	overriding toString method.
	public String toString(String var){
		switch(var){
		case "a":var="1";break;
		case "b":var="2";break;
		case "c":var="3";break;
		
		}
		return var;
	}
	
public static void main(String[] args) {
	constructor a=new constructor();

	System.out.println(a.toString("a"));
}

}