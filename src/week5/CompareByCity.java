package week5;

import java.util.Comparator;

public class CompareByCity implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		return o2.getCity().compareToIgnoreCase(o1.getCity());
	}
}
