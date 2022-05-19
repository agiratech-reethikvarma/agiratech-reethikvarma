package task_learnings;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class Employees {
	String name;
	Integer id, salary;

	//		Constructor with Arguments to pass the Employee details.
	public Employees(String name, int id, int salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public static void main(String[] args) {

		ArrayList<Employees> emplist = new ArrayList<Employees>();

		emplist.add(new Employees("Arun",1, 11000));
		emplist.add(new Employees("Bharath",2, 12000));
		emplist.add(new Employees("Ganesh",3, 15000));
		emplist.add(new Employees("Lokesh",4, 18000));
		emplist.add(new Employees("Chandru",5, 13000));
		emplist.add(new Employees("Dinesh",6, 14000));
		emplist.add(new Employees("Madan",7, 19000));
		emplist.add(new Employees("Nandha",8, 20000));
		emplist.add(new Employees("Jagan",9, 16000));
		emplist.add(new Employees("Karthik",10, 17000));
		

//		Display Employees list.
		System.out.println("List of Employees ...");
		for (int i = 0; i < emplist.size(); i++) {
			System.out.println(emplist.get(i).name + "\t" + emplist.get(i).id + "\t" + emplist.get(i).salary);

		}

//		Sorting The employees with their name.
//		Using Implements method to override the compare method for sorting.
		System.out.println("\n\n *** Sorted Employee list by Names ***\n");
		Collections.sort(emplist, new sorting() {

		});

		for (int i = 0; i < emplist.size(); i++) {
			System.out.println(emplist.get(i).name + "\t" + emplist.get(i).id + "\t" + emplist.get(i).salary);

		}

//		sorting The employees with their id.
//		Using Anonymous inner class method to override the Compare method.
		Collections.sort(emplist, new Comparator<Employees>() {
			public int compare(Employees emp1, Employees emp2) {
				return emp1.id.compareTo(emp2.id);
			}
		});
		System.out.println("\n\n *** Sorted Employee list by Id ***\n");
		for (int i = 0; i < emplist.size(); i++) {
			System.out.println(emplist.get(i).name + "\t" + emplist.get(i).id + "\t" + emplist.get(i).salary);
		}

	}

}
