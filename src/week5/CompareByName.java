package week5;

import java.util.Comparator;

public class CompareByName implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o2.getName().compareToIgnoreCase(o1.getName());
	}

}
