package chapter22;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Prime extends Application {
	BorderPane bp = new BorderPane();
	int WIDTH = 400, HEIGHT = 200;
	TextField tf = new TextField();
	TextField keyField = new TextField();
	TextArea text = new TextArea(" ");
	Integer[] list = null;
	ArrayList<Integer> arrayList = new ArrayList<>();
	LinkedList<Integer> linkedList = new LinkedList<>();
	Button getPrime = new Button("Find primes");
	Integer gcd = 1;
	
	String[] methodNames = {"prime1", "prime2", "prime3", "prime4", "prime5"};
	
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
		
		vBox.getChildren().addAll(new Label("Please enter a number"),
							tf, getPrime);
		
	
		getPrime.setOnAction(this::findPrime);
		
		bp.setBottom(vBox);
		bp.setCenter(text);

		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("Find prime numbers");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

/*
 * Brute-force method
 */
	public void prime1(Integer n){
		int number = 2;
		
		while (number <= n){
			boolean isPrime = true;
			
			for (int i = 2; i < number; i++){
				if(number%i==0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) System.out.print(number + "  ");
			number++;
		}
		System.out.println();
		
	}
	
	/*
	 * improved O(squrt(n) * n)
	 */
	public void prime2(Integer n){
		int number = 2;
		
		while (number <= n){
			boolean isPrime = true;
			
			for (int i = 2; i <= (int) Math.sqrt(number); i++){
				if(number%i==0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) System.out.print(number + "  ");
			number++;
		}
		System.out.println();
	}
	
	/*
	 * improved method 2
	 */
	public void prime3(Integer n){
		int number = 2;
		int squareRoot = 1;
		
		while (number <= n){
			boolean isPrime = true;
			if(squareRoot * squareRoot <= number) squareRoot++;
			
			for (int i = 2; i < squareRoot; i++){
				if(number%i==0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) System.out.print(number + "  ");
			number++;
		}
		System.out.println();
	}
	/*
	 * using dynamic programming
	 * use previous result to determine prime
	 */
	public void prime4(Integer n){
		List<Integer> primes = new ArrayList<>();
		int number = 2;
		int squareRoot = 1;
		
		while (number <= n){
			boolean isPrime = true;
			if(squareRoot * squareRoot < number) squareRoot++;
			
			for (int i = 0; i < primes.size() && primes.get(i) <=squareRoot; i++){
				if(number%primes.get(i)==0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				System.out.print(number + "  ");
				primes.add(number);
			}
			number++;
		}
		System.out.println();
	}
	/*
	 * Sieve of Eratosthenes
	 * use an array 
	 */
	public void prime5(Integer n){
		boolean[] primes = new boolean[n+1]; 
		
//		initialize primes[i] array
		for (int i = 0; i < primes.length; i++){
			primes[i] = true;
		}
		
		for(int i = 2; i <= n; i++){
			if(primes[i]){
				for(int k = i; k <= n/i; k++ ){
					primes[i*k] = false;
				}
			}
		}
		
		for(int i = 2; i< primes.length; i++){
			if(primes[i]){
				System.out.print(i + "  ");
			}
		}
		System.out.println();
	}
	
	public long getTime(String func, int n ) throws Exception{
		Method method = this.getClass().getMethod(func, Integer.class);

		long startTime = System.currentTimeMillis();
		//do the work
		method.invoke(this, n);
		//return how long it took
		return System.currentTimeMillis() - startTime;
	}

	

	public void findPrime(ActionEvent e){
		int number = Integer.parseInt(tf.getText()) ;
		//long time = getTime("gcd1", x, y);
		text.setText("");
		try{
			//text.appendText("The prime numbers are  " + gcd + "\n");
			for (int i = 0; i < methodNames.length; i++){
				text.appendText("To find prime numbers using method " + i +", it takes  " + getTime(methodNames[i], number) + " milliseconds." + "\n");
			}
			
		} catch(Exception ex){
			ex.printStackTrace(System.out);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
