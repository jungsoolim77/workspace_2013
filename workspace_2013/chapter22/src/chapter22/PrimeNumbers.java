package chapter22;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrimeNumbers extends Application {
	BorderPane bp = new BorderPane();
	TextField tf = new TextField();
	int WIDTH = 400, HEIGHT = 200;
	TextArea text = new TextArea(" ");
	Button GetPrime = new Button("Compute Primes");
	
	String[] methodNames = {"findPrime1", "findPrime2", "findPrime3"};
	Integer[] size = {10, 100, 1000, 10000, 100000, 1000000};
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hBox = new HBox();
		
		hBox.getChildren().addAll(new Label("Please press button to compute prime numbers.  "),
							 GetPrime );
		
	
		GetPrime.setOnAction(this::computePrime);
		
		bp.setTop(hBox);
		bp.setCenter(text);

		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("Compute GCD");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void findPrime1(Integer size){
		int number = 2;
		List<Integer> list = new ArrayList<>();
		
		while (number <= size){
			boolean isPrime = true;
			
			for(int divisor = 2; divisor <= (int) (Math.sqrt(number)); divisor++){
				if(number % divisor == 0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime){
				list.add(number);
			}
			number++;
				
		}
	}
	
	public void findPrime2(Integer size){
		int number = 2;
		int squareRoot = 1;
		List<Integer> list = new ArrayList<>();
		
		while (number <= size){
			boolean isPrime = true;
			
			if(squareRoot*squareRoot < number) squareRoot++;
			
			for(int k=0; k<list.size() && list.get(k) <= squareRoot; k++){
				if(number % list.get(k) == 0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime){
				list.add(number);
			}
			number++;
				
		}
	}
	
	
	public void findPrime3(Integer size){
	
		List<Integer> list = new ArrayList<>();
		
		boolean[] primes = new boolean[size + 1];
		
//		initialize primes[] to true
		for(int i=0; i< primes.length; i++)
			primes[i] = true;
		
		for (int k=2; k<= size/k; k++){
			if(primes[k]){
				for (int i = k; i<= size/k; i++){
					primes[k*i] = false;
				}
			}
		}
		
		for (int i = 2; i<primes.length; i++){
			if(primes[i])
				list.add(i);
				
		}
		
	}
	
	public long getTime(String func, int size) throws Exception{
		//measure running time of each method
		Method method = this.getClass().getMethod(func, Integer.class);

		long startTime = System.currentTimeMillis();
		//do the work
		method.invoke(this, size);
		//return how long it took
		return System.currentTimeMillis() - startTime;
	}
	
	public void computePrime(ActionEvent e){
		
		//long time = getTime("findPrime", size);
		text.setText("");
		try{
			text.appendText("Compute prime numbers using various algorithms. \n");
			text.appendText("Method name       input size           running time (milliseconds)\n");
			for(int k = 0; k < size.length; k++){
				for (int i = 0; i < methodNames.length; i++){
					
					text.appendText(methodNames[i]+" "+ String.format("%20d", size[k]) + " " + String.format("%40d", getTime(methodNames[i], size[k])) + "\n");
					
				}
				text.appendText("\n");
			}
			
			text.appendText("\n\n");
			
			for(int i = 0; i < methodNames.length; i++){
				for (int k = 0; k < size.length; k++){
					
					text.appendText(methodNames[i]+" "+ String.format("%20d", size[k]) + " " + String.format("%40d", getTime(methodNames[i], size[k])) + "\n");
					
				}
				text.appendText("\n");
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
