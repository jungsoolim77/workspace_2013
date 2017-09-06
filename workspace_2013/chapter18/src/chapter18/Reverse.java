package chapter18;

public class Reverse {
	public static void reverseDisplay(String s){
		if (s.length()>0){
			System.out.print(s.charAt(s.length()-1));
			reverseDisplay(s.substring(0,s.length()-1));
		}
	}
	
	public static void reverseDisplay2(String s){
		
		reverseDisplay2(s, s.length());	
	}
	
	public static void reverseDisplay2(String s, int n){
		if(n==1){
			System.out.print(s.charAt(0));
			return;
		}else{
			System.out.print(s.charAt(n-1));
			reverseDisplay2(s, n-1);
		}
	}
			
	public static void reverseDisplay(int n){	
		if(n > 0){
			System.out.print(n%10);
			reverseDisplay(n/10);
		}
	}
	public static double sumSerise(double n){
		if(n==0)
			return 0;
		else
			return (1/n) + sumSerise(n-1);
		
	}
	
	public static double sumSerise2(double n){
		if(n==0)
			return 0;
		else
			return (n/(2*n + 1)) + sumSerise2(n-1);
		
	}
	
	public static double sumSerise3(double n){
		if(n==0)
			return 0;
		else
			return (n/(n + 1)) + sumSerise3(n-1);
		
	}
	
	public static long sumDigits(long n){
		if(n==0)
			return 0;
		else
			return (n%10) + sumDigits(n/10);
				
	}
	
	
	public static int count2(String str, char a){
		return count2(str, a, 0);
	}

	public static int count2(String str, char a, int index){
		if(index == (str.length()) - 1){
			return 0;
		} else{
			if(str.charAt(index)==a){
				return 1 + count2(str, a, index +1);
			}else{
				return count2(str, a, index +1);
			}
		}
		
	}
	
	
	
	public static int count(String str, char a){
		if(str.length() == 0)
			return 0;
		else if (str.charAt(0)==a)
			return 1 + count(str.substring(1, str.length()), a);
		else
			return 0 + count(str.substring(1, str.length()), a);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		reverseDisplay("abc");
		System.out.println();
		reverseDisplay2("cba");
		System.out.println();
		reverseDisplay(12340);
		System.out.println();
		System.out.println("sum digits " + sumDigits(1230));
		System.out.println();
		System.out.println("count char  " + count("Welcome", 'e'));
		

	}

}
