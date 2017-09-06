package chapter3;

import java.util.Calendar;
import java.util.Scanner;

public class Lab3 {
	static enum Month {January, February, March, April, May, June, July, August, September,
		October, November, December}; 
	
	public static void main(String[] args) {
		for(int i = 0 ; i < 12; i++){
//			System.out.println("The month is " + getMonth());
		}	
		
		int[] days = getDaysInMonth();
		System.out.println("The month is " + days[1] + " and the year is " + days[0] 
				+ " has " + days[2] + " days");
		
	}
	
	public static Month getMonth(){
		int number = (int) (Math.random() * 12);
		Month m = Month.January;
		if(number==0){return m.January;}
		else if (number == 1){return m.February;}
		else if (number == 2){return m.March;}
		else if (number == 3){return m.April;}
		else if (number == 4){return m.May;}
		else if (number == 5){return m.June;}
		else if (number == 6){return m.July;}
		else if (number == 7){return m.August;}
		else if (number == 8){return m.September;}
		else if (number == 9){return m.October;}
		else if (number == 10){return m.November;}
		else {return m.December;}
	}
	

	public static int[] getDaysInMonth(){
		int[] year_mon_day = new int[3];
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the month from 1 to 12");
		year_mon_day[1] = scanner.nextInt();
		System.out.println("Enter the year for YYYY");
		year_mon_day[0] = scanner.nextInt();
		
		boolean isLeap = false;
		
		if(((year_mon_day[0]%4==0) && 
				(year_mon_day[0]%100==0)) || (year_mon_day[0]%400==0)){
			isLeap = true;
		}
		
		if(year_mon_day[1]==2){
			if(isLeap)
				year_mon_day[2]	= 29;
			else
				year_mon_day[2]	= 28;
			
		}else if (year_mon_day[1] <= 7){
				if(year_mon_day[1] % 2 == 0)
					year_mon_day[2]	= 30;
				else
					year_mon_day[2]	= 31;
			
		}else{
			if(year_mon_day[1] % 2 == 0)
				year_mon_day[2]	= 31;
			else
				year_mon_day[2]	= 30;
			
		}
		return year_mon_day;
	}
	

}
