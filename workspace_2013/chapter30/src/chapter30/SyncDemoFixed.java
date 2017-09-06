package chapter30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncDemoFixed {
	  static Counter counter = new Counter();

	  public static void main(String[] args) {
		  SyncDemoFixed test = new SyncDemoFixed();
		  Integer sum = counter.getSum();
	    System.out.println("What is sum ? " + sum);
	  }

	  public SyncDemoFixed() {
	    ExecutorService executor = Executors.newFixedThreadPool(1000);

	    for (int i = 0; i < 1000; i++) {
	      executor.execute(new SumTask());
	    }

	    executor.shutdown();

	    while(!executor.isTerminated()) {
	    }
	  }

	  static class SumTask implements Runnable {
	    public void run() {
	  		counter.incSum();
	    }
	  }
	  
	 static class Counter{
		  private static Lock lock = new ReentrantLock();
		  private int sum = 0;
		  
		  public int getSum(){
			  return sum;
		  }
		  
		  public void incSum(){
			  lock.lock();
			  try{
				  int temp = sum + 1;
				  Thread.sleep(5);
				  sum = temp;
			  }
			  catch(InterruptedException ex){
				  
			  }
			  finally{
				  lock.unlock();
			  }
		  }
	  }
	}