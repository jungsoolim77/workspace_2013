package chapter19;

public class Search {

	public static <E extends Comparable<E>> int linearSearch(E[] list, E key){
		for(int i = 0; i < list.length; i++){
			if(list[i].compareTo(key)==0){
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
