package chapter19;

import java.util.ArrayList;
import java.util.List;

public class GenericBoundExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Person<String> p = new Person<>();
//		Person<Integer> s = new Student<>(1234);
//		Person<Double> g = new GraduateStudent<>(1234.0);
		Person<Integer> i = new Instructor<>(777);
		
		
		List<? extends Person<String>> foo1 = new ArrayList<Person<String>>(); 
		((ArrayList<Student<String>>) foo1).add(new Student<String>());
//		((ArrayList<GraduateStudent<String>>) foo1).add(new GraduateStudent<String>());
//		((ArrayList<Instructor<String>>) foo1).add(new Instructor<String>());
//
//		List<? extends Student> foo2 = new ArrayList<Student>(); 
//		((ArrayList<Student>) foo2).add(new GraduateStudent<String>());
//		((ArrayList<GraduateStudent>) foo2).add(new GraduateStudent<String>());
//	
//		
//		List<? extends GraduateStudent> foo3 = new ArrayList<GraduateStudent>(); 
//
//		List<? extends Instructor> foo4 = new ArrayList<Instructor>();
//// 		
//		List<? super GraduateStudent> foo5 = new ArrayList<GraduateStudent>();  
//		
//		List<? super Student> foo6 = new ArrayList<Student>();   
//		
//		List<? super Person> foo7 = new ArrayList<Person>(); 
//		

	}
	
	public <E extends Comparable<E>> void doSomething(){
		System.out.println("do something...");
	}
	
	public static <T extends Comparable<? super T>> void doSomethingElse(){
		System.out.println("do something else...");
	}
	
	public static <T> void doSomethingOther(Student<? super T> student){
		System.out.println("do something other...");
	}
	
	public static <T> void doSomethingExtra(
			Student<? super T> student, GraduateStudent<? extends T> gs){
		System.out.println("do something extra...");
	}
}

class Person<E>{
	E id;
	
	public Person(){
		id = null;
		System.out.println("A person");
	}
	
	public Person(E id){
		this.id = id;
		System.out.println("A person with id " + id);
	}
	
	public E getID(){
		return id;
	}
	
	
	@Override
	public String toString(){
		return "A person";
	}
	
}
class Student<E> extends Person<E> {
	E id;
	public Student(){
		id = null;
		System.out.println("A Student");
	}
	
	public Student(E id){
		super(id);
		this.id = id;
		System.out.println("A Student with id " + id);
		
	}
	
	@Override
	public String toString(){
		return "A student";
	}
	
}

class GraduateStudent<E> extends Student<E> {
	E id;
	public GraduateStudent(){
		id = null;
		System.out.println("A Graduate Student");
	}
	
	public GraduateStudent(E id){
//		super(id);
		this.id = id;
		System.out.println("A Graduate Student with id " + id);
	}
	
	@Override
	public String toString(){
		return "A graduate student";
	}
	
}

class Instructor<E> extends GraduateStudent<E> {
	E id;
	public Instructor(){
		id = null;
		System.out.println("An instructor");
	}
	
	public Instructor(E id){
		super(id);
		this.id = id;
		System.out.println("An instructor with id " + id);
	}
	
	@Override
	public String toString(){
		return "An instructor";
	}
}

