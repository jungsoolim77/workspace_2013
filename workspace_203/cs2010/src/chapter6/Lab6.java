package chapter6;

import java.util.Scanner;

public class Lab6 {
	int num1 = 10;
	
	public static void main(String[] args) {
		int num1, num2;
		
		Scanner input = new Scanner(System.in);
		
//		System.out.println("Please enter two numbers.");
//		
//		num1 = input.nextInt();
//		num2 = input.nextInt();
		num1 = 5; num2 = 9;
		int[] list;
		list = new int[2];
		list[0] = 5;
		list[1] = 9;
		System.out.println("Before swap num1 is = " + list[0] 
				+ " and num2 =" + list[1]);
		swap(list);
		System.out.println("After swap num1 is = " + list[0] 
				+ " and num2 =" + list[1]);

	}
	
	public static void swap(int num1, int num2){
		int temp = num1;
		num1 = num2;
		num2 = temp;
	}
	
	public static void swap(int[] list){
		int temp = list[0];
		list[0] = list[1];
		list[1] = temp;
	}
	
	public static int sumDigits(long n){
		int sum = 0;
		while(n>0){
			sum += n%10;
			n/=10;
		}
		return sum;
	}
	
	public static int reverse(int number){
		int result = 0;
		int numOfDigits = 0;
		int temp = number;
		while(temp>9){
			numOfDigits++;
			temp/=10;
		}

		while(number > 0){
			result += (number%10)*Math.pow(10, numOfDigits);
			numOfDigits--;
			number/=10;
		}
		
		return result;
	}
	
//	public static boolean isPalindrome(int number){
//		int temp = number;
//		int numOfDigits = 0;
//		while(temp>9){
//			numOfDigits++;
//			temp/=10;
//		}
//	
//	
//}
	
	public static int max(int num1, int num2){
		
		return num1>num2?num1:num2;
	}
	
	
	public static char getGrade(int score){
		
		if(score>= 90){
			return 'A';
		}else if(score >=80){
			return 'B';
		}else if(score >=70){
			return 'C';
		}else if(score >=60){
			return 'D';
		}else {
			return 'F';
		}
	}
	
	
	
	
	

}
