package chapter5;

import java.util.Scanner;

public class Lab5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

//checking palindrome 
//		System.out.println("Please enter a string.");
//		String s = input.nextLine();
//		int low=0;
//		int high = s.length() -1;
//		boolean isPalindrome = true;
//		
//		while(low<high && isPalindrome){
//			if(s.charAt(low) != s.charAt(high)){
//				isPalindrome = false;
////				break;
//			}
//			low++;
//			high--;
//		}
//		
//		if(isPalindrome){
//			System.out.println(s + " is a palindrome. ");
//		}else{
//			System.out.println(s + " is not a palindrome. ");
//		}
//		
		
//		Counting sum and average
//		System.out.println("Please enter integers. The input ends if the number is 0 ");
//		int sum = 0;
//		int counter = 0;
//		int num = input.nextInt();
//		
//		while(num!= 0){
//			sum += num;
//			counter++;
//			num = input.nextInt();
//		}
//		
//		do{
//			num = input.nextInt();
//			sum += num;
//			counter++;
//		}while(num != 0);
//		
//		System.out.println("The sum is " + sum + " and the average is " + sum/counter);
//		
				
//Display pattern
//		pattern A
//		
//		for(int i = 1; i < 7 ; i++){
//			for(int j=1; j <= i; j++){
//				System.out.print(j + " ");
//			}
//			System.out.println("");
//		}
//		System.out.println("");
		
////		pattern B
//		for(int i = 1; i < 7 ; i++){
//			for(int j = 1; j <= 7 - i; j++){
//				System.out.print(j + " ");
//			}
//			System.out.println();
//		}
		
//		pattern C
//		for(int i = 1; i < 7 ; i++){
//			for(int j=1; j < 7- i; j++){
//				System.out.print("  ");
//			}
//			for(int k = i; k>=1; k--){
//				System.out.print(k+" ");
//			}
//		System.out.println("");
//	}
//		pattern D
//		
//		for(int i = 1; i < 7 ; i++){
//			for(int j=1; j < i; j++){
//				System.out.print("  ");
//			}
//			for(int k = 1; k <= 7 - i; k++){
//				System.out.print(k+" ");
//			}
//		System.out.println("");
//	}

//		pattern E
//		
//		for(int i = 1; i < 7 ; i++){
//			for(int j=1; j < i; j++){
//				System.out.print("  ");
//			}
//			for(int k = 7-i; k >=1 ; k--){
//				System.out.print(k+" ");
//			}
//		System.out.println("");
//	}
		
//		pattern x
		for(int i = 1; i < 5 ; i *=2){
			for(int j= 5-i; j > 1; j /=2){
				System.out.print("  ");
			}
			for(int k = 1; k <= i ; k *=2){
				System.out.print(k+" ");
			}
			System.out.println(" ");
		}		
//convert binary number to decimal	
//		System.out.println("Please enter a binary number.");
//		int binNumber = input.nextInt();
//		int decimalNumber = 0;
//		int base = 2;
//		int counter = 0;
////
//		while (binNumber > 0){
//			int r = binNumber%10;
//			decimalNumber += r * Math.pow(base, counter++);
//			binNumber /= 10;
//		}
//		
//		System.out.println(decimalNumber);	
//		
	}

}
