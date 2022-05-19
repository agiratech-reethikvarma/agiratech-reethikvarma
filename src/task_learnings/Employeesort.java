package task_learnings;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Iterator;

class Employees1 {
	String name;
	Integer id, salary;

//	public Employees1() {
//		super();
//	}

	public Employees1(String name, int id, int salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	
	
}
public class Employeesort
{
	public static void main(String[] args) {


		ArrayList<Employees1> emplist = new ArrayList<Employees1>();

//		Employees1 emp = new Employees1();

		emplist.add(new Employees1("arun", 17, 11000));
		emplist.add(new Employees1("bharath", 22, 12000));
		emplist.add(new Employees1("ganesh", 51, 15000));
		emplist.add(new Employees1("chandru", 3, 13000));
		emplist.add(new Employees1("dinesh", 4, 14000));
		emplist.add(new Employees1("nandha", 10, 20000));
		emplist.add(new Employees1("jagan", 6, 16000));
		emplist.add(new Employees1("karthik",47, 17000));
		emplist.add(new Employees1("lokesh", 8, 18000));
		emplist.add(new Employees1("madan", 9, 19000));

		for (int i = 0; i < emplist.size(); i++) {
			System.out.println(emplist.get(i).name + "\t" + emplist.get(i).id + "\t" + emplist.get(i).salary);

		}

//		sorting The Employees1 with their id.
		Collections.sort(emplist, new Comparator<Employees1>() {
			public int compare(Employees1 emp1, Employees1 emp2) {
				return emp1.id.compareTo(emp2.id);
			}

		});
		System.out.println("sorted list is : \n \n ");
		for (int i = 0; i < emplist.size(); i++) {
			System.out.println(emplist.get(i).name + "\t" + emplist.get(i).id + "\t" + emplist.get(i).salary);
		}

	}

}
