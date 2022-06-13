package Stream_learnings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//import java.util.Optional;
//import java.util.OptionalDouble;
//import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Employ {
	int id;
	String name;
	double salary;
	
	int inc=10;
//	Constructor.
	public Employ(int id,String name,double salary) {
		this.id=id;
		this.name=name;
		this.salary=salary;		
	}
	public void salinc() {
//		salary=salary+inc;
		System.out.println("heelo"+salary);
	}
//	 Main .
	public static void main(String[] args) {
		
		int [] a= new int[] {1,2,3};
		int [] b=new int[] {4,5,6};
		int [] c=new int[] {7,8,9};
		
		
		
		Employ[] em= {new Employ(1,"reethik",1000.0),new Employ(2,"aaa", 1000.10),
				new Employ(3, "cab", 1000.20),new Employ(4, "cab", 1000.20)};
		
		
		Stream.of(em).sorted((e1,e2)->Integer.compare(e2.id, e1.id)).forEach(Employ::salinc);
		
//	Stream.of(em).max((e1,e2)-> e1.id-e2.id).stream().forEach(x-> System.out.println(x.id));
		
//		double in=Stream.of(em).map(x-> x.salary).reduce(1.0,(x,y)->x+y);
//		System.out.println(in);
		
//		boolean s=Stream.of(em).map(x-> x.id).anyMatch(x-> x==2);
//System.out.println(s);
		
//	boolean a=Stream.of(em).mapToInt(x-> x.id).isParallel();
//		System.out.println(a);
	
//		String si=Stream.of(em).map(x-> x.name).collect(Collectors.joining(", "));
//		System.out.println(si);
		
//		Stream.of(em).findFirst().stream().forEach(x-> System.out.println(x.id));
		
//		Stream.of(em).map(x-> x.id).collect(Collectors.summarizingInt(mapper)));
	
	List <Integer > s=Stream.of(em).flatMap(x->Stream.of(x.id)).collect(Collectors.toList());
	System.out.println(s);

//Stream.of(em).map(x-> x.id).map().forEach(System.out:: print);
	
	
	
	}
	
}
