
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class arrays {

	public static void main(String[] args) {

		List<String> seat1 = new ArrayList<String>();
		List<String> seat2 = new ArrayList<String>();
		List<String> seat3 = new ArrayList<String>();
		List<String> seat4 = new ArrayList<String>();
		List<String> seat5 = new ArrayList<String>();
		Collections.addAll(seat1, "1","2","3","4");
		Collections.addAll(seat2, "1","2","3","4");
		Collections.addAll(seat3, "1","2","3","4");
		Collections.addAll(seat4, "1","2","3","4");
		Collections.addAll(seat5, "1","2","3","4");
		Map<Integer, List<String>> S2seat1 = new HashMap<Integer, List<String>>();
		Map<Integer, List<String>> S2seat2= new HashMap<Integer, List<String>>();
		Map<Integer, List<String>> S2seat3= new HashMap<Integer, List<String>>();
		Map<Integer, List<String>> S2seat4= new HashMap<Integer, List<String>>();
		Map<Integer, List<String>> S2seat5= new HashMap<Integer, List<String>>();
		
		Map<Integer, HashMap<Integer, List<String>>> seats_List = new HashMap<Integer, HashMap<Integer, List<String>>>();

		S2seat1.put(1,seat1);
		S2seat2.put(1,seat2);
		S2seat3.put(1,seat3);
		S2seat4.put(1,seat4);
		S2seat5.put(1,seat5);

		System.out.println(S2seat1.get(1));
//		seat1.stream().filter(x->x!="1").forEach(System.out::print);
//	System.out.println(	Character.compare('O', 'M'));S
//		
//		Set<Integer>k=S2seat.keySet();
//		for (Integer ke:k) {
//		System.out.println(S2seat.get(k));
//		
//		}

	}
}
