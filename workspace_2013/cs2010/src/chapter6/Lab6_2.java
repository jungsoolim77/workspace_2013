package chapter6;

public class Lab6_2 {
	int num1 = 1, num2 = 2;
	
	public static void main(String[] args) {
		int num1 = 3, num2 = 4;	
		
		System.out.println("num1 = " + num1 + " num2 = " + num2);
//		test();
	}
	
	public void test(){
		int num1 = 5, num2 = 6;
		System.out.println("num1 = " + this.num1 + " num2 = " + this.num2);
		
		for(int i = 0; i < 5; i++){
			System.out.print(i + " ");
		}
//		System.out.print(i + " ");
	
}
	public static int max(int x, int y){
		return x>y? x:y;
	}
	
	public static int max(int x, double y){
		return x>y? (int) x: (int) y;
	}
	
	public static double max(double x, double y){
		return x>y?  x:  y;
	}
	
//	public static double max(int x, int y){
//		return x>y? x:y;
//	}

		
//		System.out.print(i + " ");
	
//	public static int increment(int x){
//		return ++x;
//	}
//	
//	public static void swap(int x, int y){
//		int temp = x;
//		x = y;
//		y = temp;
//		System.out.println(" x = "+ x + " y = " + y);
//}
//	
//	public static boolean isEven(int x){
//		if(x%2==0)
//			return true;
//		else
//			return false;
//	}
//
//	public static boolean isOdd(int x){
//		if(x%2!=0)
//			return true;
//		
//		return false;
//	}
//	
//
//	

	
//	public static int decrement(int x){
//		return --x;
//	}
	


}
