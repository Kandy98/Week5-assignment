package week5;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentService {
	public static List<Student> students = new ArrayList<>();
	
	public List<Student> findAll() {
		return students;
	}
	
	public Student findById(int id) throws NoSuchElementException {
		for(Student student:students) {
			if(student.getId()==id) {
				return student;
			}
		}
		
		throw new NoSuchElementException();
	}
	
	public List<Student> findByCity(String city) {
		List<Student> stu = new ArrayList<>();
		for(Student student: students) {
			if(student.getCity() == city) {
				stu.add(student);
			}
		}
		
		return stu;
	}
	
	public List<Student> sortByName() {
		students.sort(new CompareByName());
		
		return students;
	}
	
	public List<Student> sortByCity() {
		students.sort(new CompareByCity());
		
		return students;
	}
	
	public void read() {
		int id;
		String name;
		String city;
		
		System.out.println("Enter id, name and city:");
		id = Scan.sc.nextInt();
		name = Scan.sc.next();
		city = Scan.sc.next();

		students.add(new Student(id, name, city));
	}
	
}
