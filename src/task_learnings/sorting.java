package task_learnings;

import java.util.Comparator;

public class sorting implements Comparator<Employees>{

	@Override
	public int compare(Employees emp1, Employees emp2) {
	
		return emp1.name.compareTo(emp2.name);
	}


	
	
}

