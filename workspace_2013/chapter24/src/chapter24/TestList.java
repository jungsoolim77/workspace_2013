package chapter24;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDoublyLinkedList<String> list = new MyDoublyLinkedList<>();
		list.add("Los Angeles");
		list.add("New York");
		list.add(1,"SFO");
		System.out.println(list.toString());

	}

}
