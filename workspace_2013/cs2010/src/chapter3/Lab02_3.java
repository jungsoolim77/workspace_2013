package chapter3;

import java.util.Scanner;

public class Lab02_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a year");
		int year = input.nextInt();
		System.out.println("Enter a month");
		int month = input.nextInt();
		int days = 0;
//		test if it is a leap year
//		is divisible by 4
		boolean isLeapYear = (year%4 == 0);
//		is divisible by 4, but not by 100
		isLeapYear = isLeapYear && (year%100 != 0);
//		is divisible by 4, but not by 100 or divisible by 400
		isLeapYear = isLeapYear || (year%400 == 0);
		
		if(month>=1 && month <= 12){
			if(month==2){
				if(isLeapYear)
					days = 29;
				else
					days = 28;
			}else{
				if(month <= 7){
					if(month%2==0)
						days = 30;
					else
						days = 31;
				}else{
					if(month%2==0)
						days = 31;
					else
						days = 30;
				}
				
			}
			
			System.out.println("The year " + year + " month " 
					+ month + " has " + days + " days.");
		}else{
			
			System.out.println(month + " is invalid month.");
		}
		
		
		
		
		

	}

}
