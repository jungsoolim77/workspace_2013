package chapter26;

public class AVLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] list = {10, 5, 15, 20, 7, 3, 8};
		Integer[] list = {2, 1, 5, 23, 4, 6, 27};
		AVLTree<Integer> tree = new AVLTree<>(list);
		tree.AbreathFirstSearch();
//		tree.insert(25);
//		tree.printSize();
//		int k = 2;
		for(int k = 1; k < list.length; k++){
			System.out.println("The  " + k + "th smallest number is " + tree.find(k));
		}
		

	}

}
