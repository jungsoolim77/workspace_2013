package reviewInheritance;

public class ReviewInheritance {

	public static void main(String[] args) {
		
//		Object p1 = new Person();
//		Object p2 = new Student();
		Object p3 = new GS();
//		Person p4 = new Student();
//		Student p5 = new GS();

		

	}

}

interface Info{
	String getName();
	int getID();
}
class Person implements Info{
	String name;
	int id;
	public Person(){
		this("Person",0);
		System.out.println("A Person...");
	}
	
	public Person(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	public void personMethod(){
		System.out.println("A special person...");
	}
	
	public String toString(){
		return "A person";
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Student extends Person{
	
	public Student(){
		this("Student",1);
		System.out.println("A Student...");
	}
	
	public Student(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	public void studentMethod(){
		System.out.println("A special Student...");
	}
	
	public String toString(){
		return "A student";
		
	}
}

class GS extends Student{
	public GS(){
		this("Graduate Student", 2);
		System.out.println("A Graduate Student...");
	}
	
	public GS(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	public void gsMethod(){
		System.out.println("A special Graduate Student...");
	}
	
	public String toString(){
		return "A graduate student";
		
	}
}
