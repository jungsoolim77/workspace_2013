package chapter30;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static <E extends Comparable<E>> void parallelMergeSort(E[] list) {
	    RecursiveAction mainTask = new SortTask(list);
	    ForkJoinPool pool = new ForkJoinPool();
	    pool.invoke(mainTask);
	  }

	  private static class SortTask<E extends Comparable<E>> extends RecursiveAction {
	    private final int THRESHOLD = 500;
	    private E[] list;

	    SortTask(E[] list) {
	      this.list = list;
	    }

	    @Override
	    protected void compute() {
	      if (list.length < THRESHOLD)
	        java.util.Arrays.sort(list);
	      else {
	        // Obtain the first half
	        E[] firstHalf = (E[])(new Comparable[list.length / 2]);
	        System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

	        // Obtain the second half
	        int secondHalfLength = list.length - list.length / 2;
	        E[] secondHalf = (E[])new Comparable[secondHalfLength];
	        System.arraycopy(list, list.length / 2, 
	          secondHalf, 0, secondHalfLength);

	        // Recursively sort the two halves
	        invokeAll(new SortTask(firstHalf), 
	          new SortTask(secondHalf));

	        // Merge firstHalf with secondHalf into list
	        merge(firstHalf, secondHalf, list);
	      }
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
	  
	 
	  public static<E extends Comparable<E>> void parallelQuickSort(int[] list) {
		    RecursiveAction mainTask = new QSortTask(list, 0, list.length - 1);
		    ForkJoinPool pool = new ForkJoinPool();
		    pool.invoke(mainTask);
		  }

		  private static class QSortTask extends RecursiveAction {
		    private final int THRESHOLD = 500;
		    private int[] list;
		    private int first, last;
		    
		    QSortTask(int[] list, int first, int last) {
		      this.list = list;
		      this.first = first;
		      this.last = last;
		    }

		    @Override
		    protected void compute() {
		      if (list.length < THRESHOLD)
		        java.util.Arrays.sort(list);
		      else {
		        if (last > first) {
		          int pivotIndex = partition(list, first, last);
		  
		          // Recursively sort the two parts
		          invokeAll(new QSortTask(list, first, pivotIndex - 1), 
		            new QSortTask(list, pivotIndex + 1, last));
		        }
		      }
		    }
		    
		    protected static <E extends Comparable<E>> int partition(int[] list,
					int first, int last){
				int pivot = list[first];
				int low = first + 1;
				int high = last;
				
				while(high > low){
					while(low <= high && list[low]<=(pivot))
						low++;
					while (low <= high && list[high]>(pivot))
						high--;
					
					if(high > low){
						int temp = list[high];
						list[high] = list[low];
						list[low] = temp;
					}
				}
				
				while (high > first && list[high]>=(pivot))
					high--;
				
				
				if(pivot>(list[high])){
					list[first] = list[high];
					list[high] = pivot;
					return high;
				}
				else{
					return first;
				}
			}
		  }
		  
		  

}
