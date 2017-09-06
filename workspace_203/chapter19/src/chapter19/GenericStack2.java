package chapter19;

public class GenericStack2<E> extends java.util.ArrayList<E> {
	
	public boolean isEmpty(){
		return super.isEmpty();
	}
	
	public int getSize(){
		return super.size();
	}

	public E peek(){
		return get(this.getSize() - 1);
	}
	
	public E pop(){
//		E o = get(getSize() - 1);
		return remove(getSize() -1);
	}
	public void push(E o){
		add(o);
//		return o;
	}
		
	public int search(Object o){
		return indexOf(o);
	}
	
	public String toString(){
		return "stack: " + super.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericStack2<String> gs1 = new GenericStack2<>();
		gs1.push("fun!");
		gs1.push("is");
		gs1.push("Java");
//		gs1.push(5);
				
		while (!gs1.isEmpty()){
		  	  System.out.print(gs1.pop() + " ");
		  }

//		testing compareTo()
//		Integer num1 = new Integer(5);
//		Integer num2 = new Integer(7);
//		
//		System.out.println(num1.compareTo(num2));
	}

}
