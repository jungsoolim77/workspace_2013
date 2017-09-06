package chapter22;

public class Fibonacci {
	
	public static long fib(long n){
		if(n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fib(n-1) + fib(n-2);
	}

	public static long fib_dynamic(long n){
		long f0 = 0;
		long f1 = 1;
		long f2 = 1;
		
		if(n == 0)
			return f0;
		else if(n == 1)
			return f1;
		else if (n== 2)
			return f2;
		
		for(int i = 3; i <= n; i++){
			f0 = f1;
			f1 = f2;
			f2 = f0 + f1;
		}
		
		return f2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] input = {10, 20, 40};
		long[][] results = new long[2][3];
		
		for(int j =0; j < results[0].length; j++){
				long start = System.currentTimeMillis();
				long result = fib(input[j]);
				results[0][j] = System.currentTimeMillis() - start;
				
				long dStart = System.currentTimeMillis();
				long dResult = fib_dynamic(input[j]);
				results[1][j] = System.currentTimeMillis() - dStart;
		}
				
		/*
		long start = System.currentTimeMillis();
		long result = fib(40);
		long end = System.currentTimeMillis() - start;
		
		long dStart = System.currentTimeMillis();
		long dResult = fib_dynamic(40);
		long dEnd = System.currentTimeMillis() - dStart;
	
		
		System.out.println("recursive fibonacci method took " + end +
				"\n dynamic programming took " + dEnd);
				*/
		System.out.println(" Input size       Recursive Program        Dynamic Program");
		for(int i = 0; i < input.length; i++){
			System.out.println("  " + input[i] +"       "
					+ "          " + results[0][i]
					+ "                           " + results[1][i]);
		}
	}

}
