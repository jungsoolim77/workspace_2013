package chapter22;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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

public class GCD extends Application {
	BorderPane bp = new BorderPane();
	int WIDTH = 400, HEIGHT = 200;
	TextField tf = new TextField();
	TextField keyField = new TextField();
	TextArea text = new TextArea(" ");
	Long[] list = null;
	ArrayList<Long> arrayList = new ArrayList<>();
	LinkedList<Long> linkedList = new LinkedList<>();
	Button getGCD = new Button("Compute GCD");
	Long gcd = 1l;
	
	String[] methodNames = {"gcd1", "gcd2", "gcd3", "gcd4", "gcd5"};
	
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
		
		vBox.getChildren().addAll(new Label("Please enter two intergers"),
							tf, getGCD);
		
	
		getGCD.setOnAction(this::computeGCD);
		
		bp.setBottom(vBox);
		bp.setCenter(text);

		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("Compute GCD");
		primaryStage.setScene(scene);
		primaryStage.show();

	}


	public void gcd1(Long m, Long n){
		long gcd = 1l;
	
		for(long k = 2; k <= m && k <= n; k++){
			if (m%k == 0 && n% k == 0){
				gcd = k;
			}
		}
		this.gcd = gcd;
	}
	
	public void gcd2(Long m, Long n){
		long gcd = 1l;
		for(long k = n; k >=1; k--){
			if (m%k == 0 && n% k == 0){
				gcd = k;
				break;
			}
		}
		this.gcd = gcd;
	}
	
	public void gcd3(Long m, Long n){
		long gcd = 1l;
		if(m%n == 0) this.gcd = gcd;
		for(long k = m/2; k >=1; k--){
			if (m%k == 0 && n%k == 0){
				gcd = k;
				break;
			}
		}
		this.gcd = gcd;
	}
	
	public void gcd4(Long m, Long n){
		long gcd = 1l;
		
		if(m%n == 0) this.gcd = gcd;
		
		for(long k = n/2; k >=1; k--){
			if (m%k == 0 && n%k == 0){
				gcd = k;
				break;
			}
		}
		this.gcd = gcd;
	}
	
	public void gcd5(Long m, Long n){
		
		this.gcd = GCDEuclid(m, n);
	}

	//Euclid GCD 
	public long GCDEuclid(Long m, Long n){
		if(m%n == 0)
			return n;
		else 
			return GCDEuclid(n, m%n);
	}
	
	
	
	public long getTime(String func, long m, long n ) throws Exception{
		Method method = this.getClass().getMethod(func, Long.class, Long.class);

		long startTime = System.currentTimeMillis();
		//do the work
		method.invoke(this, m, n);
		//return how long it took
		return System.currentTimeMillis() - startTime;
	}

	

	public void computeGCD(ActionEvent e){
		String[] numbers = tf.getText().split("\\s");
		long x = Long.parseLong(numbers[0]);
		long y = Long.parseLong(numbers[1]);
		//long time = getTime("gcd1", x, y);
		text.setText("");
		try{
			text.appendText("The GCD is  " + gcd + "\n");
			for (int i = 0; i < methodNames.length; i++){
				text.appendText("To compute GCD using method " + i +", it takes  " + getTime(methodNames[i], x, y) + " milliseconds." + "\n");
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
