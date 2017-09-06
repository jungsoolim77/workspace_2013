package chapter18;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Object o = new Person();
		Object p = new Person();
		Object s = new Student();
		Object gs = new GraduateStudent();
		System.out.println(p.toString());
		System.out.println(s.toString());
//		String name = ((Person)o).getName();

//		String name = o.toString();
//		System.out.println(name);
//		String test = "Java is fun!";
		
//		reverseDisplay(123);
//		reverseDisplay("cba");
//		System.out.println("The count is " + count(test, 'a'));
//		
//		System.out.println("The digit sum is " + sumDigits(123));
	}
	public static int count(String str, char a){
		return count(str, a, 0);
	}

	public static void reverseDisplay(int value){
		if(value>0){
			System.out.print(value%10);
			reverseDisplay(value/10);
		}
	}
	
	public static void reverseDisplay(String value){
		 //implement body
		reverseDisplay(value, 0);

	}
	
	public static void reverseDisplay(String value, int index){
		 //implement body
		if(index== (value.length())){
			return;
		}
		else{
			System.out.print(value.charAt(index));
			reverseDisplay(value, index + 1);
		}

	}

	public static int sumDigits(int n){
		if(n==0)
			return 0;
		else
			return n%10 + sumDigits(n/10);
	}

	public static int count(String str, char a, int index){
		
		if(index == (str.length() -1)){
			return 0;
		}else{
			if(str.charAt(index) == a)
				return 1 + count(str, a, index +1);
			else
				return count(str, a, index +1);
		}
	}

}

class Person{
	int id;
	String name;
	Person(){
		System.out.println("This is a person");
	}
	
	Person(String name){
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "This is a Person Class toString method";
	}
	public String getName(){
		return name;
		
	}
	
	public int getID(){
		return id;
		
	}
	
}

class Student extends Person{
	
	public Student(){
		System.out.println("This is a Student");
	}
	@Override
	public String toString(){
		return "This is a Student Class toString method";
	}
}

class GraduateStudent extends Student{
	
	public GraduateStudent(){
		System.out.println("This is a Graduate Student");
	}
	@Override
	public String toString(){
		return "This is a Graduate Student Class toString method";
	}
}
