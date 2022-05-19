package CollectionsLearnings;

import java.util.*;

public class sample {
//	Lists stores elements in Not sorted way. but they are ordered by their Index.
	public static void main(String[] args) {
//		ArrayList Implementation.
		ArrayList<String> Al = new ArrayList<String>();

		Al.add("A");// --> Inserting elements .
		Al.add("C");
		Al.add(0, "D");// --> Inserting Elements by index.(index,value)
		Al.add("B");
		Al.add("A");// --> Duplicate Elements are allowed.
		System.out.println("ArrayList Elements are : " + Al);
		Al.remove(1);// -->Removing Elements.
		for (int i = 0; i < Al.size(); i++) {
			System.out.println(Al.get(i));
		}
//		LinkedList Implementation.
		LinkedList<Integer> Ll = new LinkedList<Integer>();
		Ll.add(5);// --> Inserting elements.
		Ll.add(3);
		Ll.add(0, 4);// --> Inserting Elements by index.(index,value)
		Ll.add(2);
		Ll.add(5);// --> Duplicate Elements are allowed.

		System.out.println("LinkedList Elements are : " + Ll);
		Ll.remove(1);// --> Removing Elements.

		Iterator<Integer> i = Ll.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

//		Vector Implementation.
		Vector<Character> V = new Vector<Character>();
		V.add('a');
		V.add('c');
		V.add(0, 'h');
		V.add('b');
		V.add('e');

		System.out.println("Vector Elements are : " + V);
		System.out.println("First Element in the vector list is : " + V.firstElement());
		System.out.println("Last Element in the vector list is : " + V.lastElement());
		System.out.println("Getting element by Index value : " + V.elementAt(0));

		V.remove(2);
		System.out.println("After removing Index 2 Elements are : " + V);

		V.set(2, 'z');
		System.out.println("After replacing element with index values are: " + V);

		System.out.println("Size of vector is :" + V.size());
		System.out.println("capacity of vector is :" + V.capacity());

		V.removeAllElements();
		System.out.println("After removing all elements :" + V);
		V.clear();
		System.out.println("After Clearing Elements : " + V);

	}

}
