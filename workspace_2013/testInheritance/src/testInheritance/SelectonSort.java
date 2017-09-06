package testInheritance;

public class SelectonSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list = {7, 4, 2, 5, 1, 3, 6, 9, 8};
		String[]  slist = {"Java", "is", "fun", "!"};
		print(list);
		selectionSort(list);
		print(list);
		
		print(slist);
		selectionSort(slist);
		print(slist);

	}
	
	public static <E>void print(E[] list){
		for(int i=0; i< list.length; i++){
			System.out.print(list[i] + "  ");
		}
		System.out.println();
	}
	public static<E extends Comparable<E>> 
		void selectionSort(E[] list){
		E min;
		int minIndex;
		for(int i = 0; i< list.length -1; i++){
			min = list[i];
			minIndex = i;
			for(int j = i+1; j < list.length; j++){
				if(min.compareTo(list[j]) > 0 ){
					min = list[j];
					minIndex = j;
				}
			}
//			swap min with list[i]
			list[minIndex] = list[i];
			list[i] = min;
		}
	}

}
