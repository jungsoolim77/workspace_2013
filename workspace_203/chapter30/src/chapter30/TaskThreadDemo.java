package chapter30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Create tasks
		Runnable printA = new PrintChar('A', 100);
		Runnable printB = new PrintChar('B', 100);
		Runnable print100 = new PrintNum(100);
		
//		Create threads
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);
		
//		start tasks
		thread1.start();
		thread2.start();
		thread3.start();
		
//		ExecutorService executor = Executors.newFixedThreadPool(3);
////		ExecutorService executor = Executors.newCachedThreadPool();
//		executor.execute(new PrintChar('C',50));
//		executor.execute(new PrintChar('D',50));
//		executor.execute(new PrintNum(50));
//		executor.shutdown();
		
	}

}

class PrintChar implements Runnable{
	private char charToPrint;
	private int times;

	public PrintChar(char c, int times){
		charToPrint = c;
		this.times = times;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<times; i++){
			System.out.print(charToPrint+" ");
			
		}
		
	}
	
}

class PrintNum implements Runnable{

	private int lastNum;
	
	public PrintNum(int n){
		lastNum = n;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0; i<= lastNum; i++){
			System.out.print(i + "  ");
			
		}
	}
	
}
