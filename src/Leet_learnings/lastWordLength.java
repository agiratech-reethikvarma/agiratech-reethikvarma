package Leet_learnings;

public class lastWordLength {
	public int lengthOfLastWord(String s) {
		
		String [] ars=null;
		int result;
        
        ars=s.split(" ");

result=(ars[ars.length-1].length());
		System.out.println(result);
return result;
	}

	
	
	public static void main(String[] args) {
		lastWordLength lw=new lastWordLength();
		lw.lengthOfLastWord("hello iam reethik");
	}
}
