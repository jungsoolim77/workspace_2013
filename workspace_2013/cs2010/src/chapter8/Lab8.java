package chapter8;

public class Lab8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] list = new int[3][3];

		int[][]	list_2 = new int[3][];
//		int[][]	list_3 = new int[][3];
		int[][][] list_4 = new int[3][][];
//		int[][][][] list_5 = new int[][][][];
		print(list);
		
	}
//	print two dimensional array
	public static void print(int[][] list){
		for(int i = 0; i < list.length; i++){
			for(int j = 0; j < list[i].length; j++){
				System.out.print(list[i][j] + "  ");
			}
			System.out.print("\n");
		}
	}
//	sum all elements
	public static int sum(int[][] list){
		int sum = 0;
		for(int i = 0; i < list.length; i++){
			for(int j = 0; j < list[i].length; j++){
				sum += list[i][j];
			}
		}
		return sum;
	}
	
//	sum elements by column
	public static int sumbyColumn(int[][] list, int col){
		int sum = 0;
		
		for(int i = 0; i < list.length; i++){
			if(col < list[i].length){
				sum += list[i][col];
			}
		}
		return sum;
	}
//	check if it is square matrix
	public static boolean isSquareMatrix(int[][] list){
		for(int i = 0; i < list.length; i++){
			if(list.length != list[i].length){
				return false;
			}
		}
		return true;
	}
	
//	add two square matrix
	public static int[][] add(int[][] A, int[][] B){
		int[][] C = new int[A.length][A[0].length];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A[i].length; j++){
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		return C;
	}

//	multiply two square matrix	
	public static int[][] multiply(int[][] A, int[][] B){
		int[][] C = new int[A.length][A[0].length];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < B[i].length; j++){
				for(int k = 0; k <C[0].length; k++)
				C[i][j] += A[i][k] * B[k][j];
			}
		}
		return C;
	}
}
