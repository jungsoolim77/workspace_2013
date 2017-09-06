package chapter19;

import java.util.ArrayList;
import java.util.Random;

public class GenericDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intList = {7,3,5,2,1,9,6};
		String[] stringList = {"Java", "is","fun", "!"};
		System.out.println("Before sort...");
		print(intList);
		print(stringList);
		System.out.println("After sort...");
		sort(intList);
		sort(stringList);
		print(intList);
		print(stringList);
		ArrayList<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(7);
		list.add(5);
		ArrayList<Integer> noDupList = removeDup(list);
		ArrayList<String> slist = new ArrayList<>();
		slist.add("Java");
		slist.add("is");
		slist.add("fun!");
		ArrayList<String> duplist = new ArrayList<>();
		
		duplist.addAll(slist);
		duplist.addAll(duplist);
		duplist.addAll(duplist);
		duplist.addAll(duplist);
		ArrayList<String> temp = removeDup(duplist);
		print(duplist);
		print(temp);
		
		
	
		
//		int[] tempList ={1,2,3};
//		print(intList);
//		print(stringList);
//		sort(intList);
//		sort(stringList);
//		print(intList);
//		print(stringList);

	}
	
	public static <E> void print(E[] list){
		for(int i = 0; i < list.length; i++){
			System.out.print(list[i] + "  ");
		}
		
		System.out.println();
	}
	

	public static <E> void print(ArrayList<E> list){
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i) + "  ");
		}
		
		System.out.println();
	}
	
	public static <E extends Comparable<E>> void sort(E[] list){
		E currentMin;
		int currentMinIndex;
		
		for(int i=0; i < list.length -1; i++){
			currentMin = list[i];
			currentMinIndex = i;
			
			for(int j=i +1; j < list.length; j++){
				if (currentMin.compareTo(list[j])>0){
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			if(currentMinIndex != i){
				list[currentMinIndex] = list[i];
				list[i] =currentMin;
			}
	}
}

	public static <E> ArrayList<E> removeDup(ArrayList<E> list){
//		implement the method
		ArrayList<E> temp = (ArrayList<E>) new ArrayList<Object>();

		for(int i =0; i < list.size(); i++){
			if(!temp.contains(list.get(i))){
				temp.add(list.get(i));
			}
		}

		return (ArrayList<E>)temp;
	}

	public static <E extends Comparable<E>> E max(E[] list){
		//implement the body
		E max = list[0];
		for(int i = 0; i < list.length; i++){
			if (list[i].compareTo(max)>0)
				max = list[i];
		}
		
		return max;
	}
	
	public static <E extends Comparable<E>> E max(E[][] list){
		//implement the body
		E max = list[0][0];
		for(int i=0; i <list.length; i++)
			for(int j =0 ; j < list[i].length; j++)
				if (max.compareTo(list[i][j])<0)
					max = list[i][j];
		return max;
	}

	public static <E> void shuffle(ArrayList<E> list){
		//implement the body
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i <list.size() *2; i++){
			int x = r.nextInt(list.size());
			int y = r.nextInt(list.size());
			
			E temp = list.get(x);
			list.set(x, list.get(y));
			list.set(y, temp);
		}
	}
	
	public static <E extends Comparable<E>> void sort(ArrayList<E> list){
		// use selection sort and implement the body of method
		E currentMin;
		int currentMinIndex;
		
		for(int i=0; i < list.size() -1; i++){
			currentMin = list.get(i);
			currentMinIndex = i;
			
			for(int j=i +1; j < list.size(); j++){
				if (currentMin.compareTo(list.get(j))>0){
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}
			if(currentMinIndex != i){
				list.set(currentMinIndex, list.get(i)); 
				list.set(i, currentMin); 
			}
	}
		
	}
	
	public static <E extends Comparable<E>> E max(ArrayList<E> list){
//		implement the body
		E max = list.get(0);
		for(int i = 0; i<list.size(); i++){
			if(max.compareTo(list.get(i)) <0)
				max = list.get(i);
		}
		return max;
	}
	public static <E extends Comparable<E>> int 
		binarySearch(E[] list, E key){
		int low = 0, high = list.length -1;
		int mid = (high + low)/2;
		
		while (low < high){
//			use compareTo Method
			int result = key.compareTo(list[mid]);
			if (result<0)	{
				high = mid -1;
			}
			else if (result == 0){
				return mid;
			}else{
				low = mid + 1;
			}
			mid = (low + high)/2;
		}
	
		return -1;

	}
	public static <E extends Comparable<E>> int
		linearSearch(E[] list, E key){
		//implement the body
		for(int i=0 ; i < list.length ; i++){
			if(list[i].equals(key))
//			if(list[i].compareTo(key)==0)
				return i;
		}
		return -1;
	}
}
