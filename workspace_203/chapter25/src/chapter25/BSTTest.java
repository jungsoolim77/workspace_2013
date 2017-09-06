package chapter25;

public class BSTTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] list = {10, 5, 15, 20, 7, 3, 8};
		BST<Integer> myBST = new BST<>(list);
//		myBST.breathFirstSearch();
		System.out.println(myBST.height());
		System.out.println(myBST.getNumberOfLeaves());

	}

}
