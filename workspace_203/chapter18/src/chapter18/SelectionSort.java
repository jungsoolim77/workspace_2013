package chapter18;

import java.util.Random;
import java.util.StringTokenizer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class SelectionSort extends Application {
	BorderPane bp = new BorderPane();
	int WIDTH = 400, HEIGHT = 200;
	TextField tf = new TextField();
	TextArea text = new TextArea(" ");
	Double[] list = null;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hBox = new HBox();
		
		hBox.getChildren().addAll(new Label("Please enter numbers. "), tf);
		
		tf.setOnAction(this::sortList);
		bp.setBottom(hBox);
		bp.setCenter(text);

		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("Selection Sort");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	/*
	 * recursive function
	 */
	public static void sort(Double[] list, int low, int high){
		if(low < high){
			int indexOfMin = low;
			Double min = list[low];
			for(int i = low + 1; i <high; i++){
				if(list[i] < min){
					min = list[i];
					indexOfMin = i;
					}
			}
		
	        //swap the smallest in list	
			list[indexOfMin] = list[low];
			list[low] = min;
			//recursive call
			sort(list, low + 1, high);
		}
	}


	
	public void sortList(ActionEvent e) {
		text.setText("");
		String[] numbers = tf.getText().split("\\s");
				
		list = new Double[numbers.length];
		try {
			for(int i = 0; i < numbers.length; i++){
				list[i] = Double.parseDouble(numbers[i]);
			}
				
			
			//sort the list using recursion
			//sort(list, 0, list.length -1);
			
			//sort the list loop
			loopSort(list);
						
			//print out
			for (int j = 0; j < numbers.length; j++){
				text.appendText(list[j] + "  ");
			}
		} catch(Exception ex){
			
			text.appendText("Please enter numbers without leading space for the first number. ");
		}
	}
	
	public void loopSort(Double[] list){
		int index = 0;
		Double min = list[0];
		
		for(int i = 0; i < list.length - 1; i++){
			index = i;
			min = list[i];
			for (int j = i+1; j < list.length; j++){
				if (min > list[j]){
					min = list[j];
					index = j;
				}
			}
			//swap the value
			list[index] = list[i];
			list[i] = min;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}