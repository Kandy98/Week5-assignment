package week5;


public class MainRunner {

	public static void main(String[] args) {
		StudentService service = new StudentService();
		
		boolean more = true;
		while(more) {
			int t = 0;
			service.read();
			System.out.println("Want to enter more students: (1/0)");
			t = Scan.sc.nextInt();
			if(t==0)
				more = false;
		}
		
		
		for(Student stu:service.findAll()) {
			System.out.println(stu.toString());
		}
		
		//findById
		int gid;
		System.out.println("Enter id to search for: ");
		gid = Scan.sc.nextInt();
		Student stud = service.findById(gid);
		System.out.println(stud.toString());
		
		//findByCity
		String cit;
		System.out.println("Enter city to search for: ");
		cit = Scan.sc.next();
		for(Student stu:service.findByCity(cit)) {
			System.out.println(stu.toString());
		}
		
		//sortByName
		for(Student stu:service.sortByName()) {
			System.out.println(stu.toString());
		}
		
		//sortByCity
		for(Student stu:service.sortByCity()) {
			System.out.println(stu.toString());
		}
		
	}

}