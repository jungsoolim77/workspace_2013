package chapter30;



import java.util.concurrent.*;

public class SyncDemo {
  private Integer sum = new Integer(0);

  public static void main(String[] args) {
	  SyncDemo test = new SyncDemo();
    System.out.println("What is sum ? " + test.sum);
  }

  public SyncDemo() {
    ExecutorService executor = Executors.newFixedThreadPool(1000);

    for (int i = 0; i < 1000; i++) {
      executor.execute(new SumTask());
    }

    executor.shutdown();

    while(!executor.isTerminated()) {
    }
  }

  class SumTask implements Runnable {
    public void run() {
    	int value = sum.intValue() + 1;
		sum = new Integer(value);
//  		try{
//  			int value = sum.intValue() + 1;
//	 			Thread.sleep(1);
//  			sum = new Integer(value);
//  		}catch(Exception ex){
//  			
//  		}
		
    }
  }
}

