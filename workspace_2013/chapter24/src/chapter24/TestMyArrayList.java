package chapter24;

import java.util.Iterator;

public class TestMyArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyList<String> list = new MyArrayList<>();
		MyList<String>	linkedList = new MyLinkedList<>();
		
		
		list.add("Java");
		list.add("is");
		list.add("fun!");
		for(String s: list){
			System.out.println(s.toUpperCase());
		}
		
		linkedList.add("Java");
		linkedList.add("is");
		linkedList.add("fun!");
		linkedList.add(2, "really");
		linkedList.add(3, "really");
		
		Iterator<String> listIterator = linkedList.iterator();
		
		while(listIterator.hasNext()){
			System.out.println(listIterator.next());
		}
		
		
		Double[] s = {3.0, 4.0, 5.0, 6.0, 7.0};
		MyList<Double> list2 = new MyArrayList<>(s);
		Iterator<Double> list2Iterator = list2.iterator();
		while(list2Iterator.hasNext()){
			System.out.println(list2Iterator.next());
		}

	}

}
