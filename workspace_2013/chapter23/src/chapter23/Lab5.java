package chapter23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.stage.Stage;

public class Lab5 extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list1 = {7, 2, 4, 3, 5, 10, 6, 4, 20, 12};
		String[] list2 = {"c", "ab", "bd", "a", "cd", "dc", "a", "c"};
//		print(list1);

//		insertionSort(list1);
//		bubbleSort(list1);
//		quickSort(list1);
//		mergeSort(list1);
		
//		print(list1);
//		BucketSort<Integer> bs = new BucketSort<>();
//		bs.bucketSort(list1);
//		print(list1);
////		
//		print(list2);
//		BucketSort<String> bss = new BucketSort<>();
//		bss.bucketSort(list2);
//		print(list2);

//		Radix sort example
		Integer[] list = new Integer[100];
//		
		
	    for (int i = 0; i < list.length; i++)
	      list[i] = (int)(Math.random() * 1000);
	    print(list);
	    radixSort(list, 3);
	    print(list);
	   
	}
	public static <E> void print(E[] list){
		for(int i = 0; i < list.length; i++){
			System.out.print(list[i] + "  ");
			if((i + 1)%10 == 0)
		    	  System.out.println();
		}
		System.out.println();
	}
	public static <E extends Comparable<E>> void insertionSort(E[] list){
		for(int i=1; i<list.length; i++){
			E currentElement = list[i];
			int k;
			for(k = i -1; k>=0 && list[k].compareTo(currentElement)>0; k--){
				list[k+1] = list[k];
			}
			list[k+1] = currentElement;
		}
		

	}

	public static <E extends Comparable<E>> void bubbleSort(E[] list){
		boolean needNextPass = true;
		
		for(int k = 1; k <list.length && needNextPass; k++){
			needNextPass = false;
			for(int i =0; i < list.length - k; i++){
				if(list[i].compareTo(list[i+1])>0){
					E temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
				}
			}
		}
	}
	public static <E extends Comparable<E>> void quickSort(E[] list){
		quickSort(list, 0, list.length -1);
	}
	
	public static <E extends Comparable<E>> void quickSort(E[] list, 
			int first, int last){
		if(last>first){
			int pivotIndex = partition (list, first, last);
			quickSort(list, first, pivotIndex -1);
			quickSort(list, pivotIndex +1, last);
		}
	}
	
	public static <E extends Comparable<E>> int partition(E[] list,
			int first, int last){
		E pivot = list[first];
		int low = first + 1;
		int high = last;
		
		while(high > low){
			while(low <= high && list[low].compareTo(pivot) <= 0)
				low++;
			while (low <= high && list[high].compareTo(pivot) > 0)
				high--;
			
			if(high > low){
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		while (high > first && list[high].compareTo(pivot) >= 0)
			high--;
		
		
		if(pivot.compareTo(list[high]) > 0){
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else{
			return first;
		}
	}

	
	public static <E extends Comparable<E>> void mergeSort(E[] list){
		if(list.length > 1){
			int firstHalfSize = list.length/2;
			int secondHalfSize = list.length - firstHalfSize;
//			E[] firstHalf = (E[]) new Comparable[firstHalfSize];
//			E[] secondHalf = (E[]) new Comparable[secondHalfSize];
			Comparable[] firstHalf = new Comparable[firstHalfSize];
			Comparable[] secondHalf = new Comparable[secondHalfSize];
							
			System.arraycopy(list,0,firstHalf,0,firstHalfSize);
			System.arraycopy(list,firstHalfSize,secondHalf,0,secondHalfSize);
			mergeSort(firstHalf);
			mergeSort(secondHalf);
//			merge(firstHalf, secondHalf, list);
			merge((E[])firstHalf, (E[])secondHalf, list);
		}
	}
	
	public static<E extends Comparable <E>> 
		void merge(E[] list1, E[] list2, E[] list3){
		
int current1 = 0, current2 = 0, current3 = 0;
		
		while(current1<list1.length && current2 < list2.length){
			if(list1[current1].compareTo(list2[current2])<0){
				list3[current3++] = list1[current1++]; 
			}else{
				list3[current3++] = list2[current2++];
			}
		}
		
		while(current1<list1.length)
			list3[current3++] = list1[current1++];
		while(current2<list2.length)
			list3[current3++] = list2[current2++];
		
	}
	
	 public static void radixSort(Integer[] list, int numberOfDigits) {
		    ArrayList<Integer>[] buckets = new ArrayList[10];
		    for (int i = 0; i < buckets.length; i++) {
		      buckets[i] = new ArrayList<Integer>();
		    }

		    for (int position = 0; position <= numberOfDigits; position++) {
		      // Clear buckets
		      for (int i = 0; i < buckets.length; i++) {
		        buckets[i].clear();
		      }      
		      
		      // Distribute the elements from list to buckets
		      for (int i = 0; i < list.length; i++) {
		        int key = getKey(list[i], position);
		        buckets[key].add(list[i]);
		      }

		      // Now move the elements from the buckets back to list
		      int k = 0; // k is an index for list
		      for (int i = 0; i < buckets.length; i++) {
		        for (int j = 0; j < buckets[i].size(); j++)
		          list[k++] = buckets[i].get(j);
		      }
		    }
		  }

		  /** Return the digit at the specified position. 
		   * The last digit's position is 0. */
		  public static int getKey(int number, int position) {
		    int result = 1;
		    for (int i = 0; i < position; i++)
		      result *= 10;

		    return (number / result) % 10;
		  }
	
}

class BucketSort<E>{
		
	public void bucketSort(E[] list){
		
		TreeMap<E,Integer> bucket = new TreeMap<>();
		
//		distribute them into bucket
		for(int i = 0 ; i < list.length ; i++){
			if(!bucket.containsKey(list[i])){
				bucket.put(list[i], 1);
			}else{
				Integer count = bucket.get(list[i]);
				count++;
				bucket.put(list[i], count);
			}
			
		}
		
//		move them into list
		Set<E> keySet = bucket.keySet();
		int index = 0;
		for(E key: keySet){
			Integer count = bucket.get(key);
			for(int i = 0 ; i<count && (index < list.length) ; i++){
				list[index] = key;
				index++;
			}
			
		}
	}
	
}