package Stream_learnings;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class sample {
	
	int no;
	String name;
	sample(int no, String name) {
		this.name = name;
		this.no = no;

	}

	public static void main(String[] args) {
		char[] Ch = new char[] { 'a', 'c', 'g', 'h', 'e' };
		int[] it = new int[] { 1, 3, 2, 4, 5, 8,10,12,14};
		String[] st = new String[] { "aa", "bb", "dd", "ee", "ff","ab","abc" };
//		List<Integer> val=new ArrayList<Integer>();
//		val.add(1);
//		val.add(3);
//		val.add(5);
//		Stream.of(val).forEach(y-> System.out.println(y));

//		Stream.of(1,"reethik",'c').forEach(x-> System.out.println(x));
//		li.forEach(t->System.out.println(t));

//	 List<char[]> chstream=Arrays.asList(Ch);
//	 List<int[]> intstream=Arrays.asList(it);
//	 List <String>sStream=Arrays.asList(st);
//		chstream.stream().forEach(x->System.out.println(x));

//		Stream.of(sStream).forEach(y-> System.out.println(y));
//		Stream.of(Ch).forEach(c -> System.out.println(c));
	int[] nums=	IntStream.of(it).filter(x->x%2==0).toArray();
	Stream.of().forEach(x-> System.out.println(x));
//		Stream.of(st).map(x->x.concat(" hello")).filter(x-> x.startsWith("b", 1)).forEach(d -> System.out.println(d));
//	 List Intlist=chstream.s
		
		
//		Stream.Builder<String> rr=Stream.builder();
//		rr.accept("aba");
//		rr.add("bcbafsds");
	
//		Stream<String> str=rr.build();
//		str.filter(x-> x.startsWith("b")).forEach(x-> System.out.println(x));
//		IntStream.of(it).map(x-> x+1).filter(x->x%2==0).collect(arg0, arg1, arg2);

	}

}
