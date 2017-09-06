package chapter18;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class BinarySearch extends Application {
	BorderPane bp = new BorderPane();
	int WIDTH = 400, HEIGHT = 200;
	TextField tf = new TextField();
	TextField keyField = new TextField();
	TextArea text = new TextArea(" ");
	Integer[] list = null;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VBox vBox = new VBox();
		
		vBox.getChildren().addAll(new Label("Please enter numbers in ascending sorted order. "),
							tf, new Label("Please enter a key. "), keyField);
				
		keyField.setOnAction(this::searchList);
		bp.setBottom(vBox);
		bp.setCenter(text);

		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("Binary Search");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	/*
	 * recursive function
	 */
	
	public int search(Integer[] list, int key, int low, int high){
		text.appendText("low index: [" + low + "] and high index [" + high +"] is searched." + "\n");
		
		if(low > high){
			return -1;
		}
		
		int mid = (low + high) /2;
		if (key < list[mid])
			return search(list, key, low, mid-1);
		else if (key == list[mid])
			return mid;
		else
			return search(list, key, mid + 1, high);
	}
	/*
	 * non-recursive function
	 */
	
	public int search(Integer[] list, int key){
		int low = 0, high = list.length - 1;
		int mid = (low + high)/2;
		
		while (low <= high){
			text.appendText("low value: "+ list[low] +
					" index [" + low + "] " + "and high value" + 
					list[high] + " from index [" + high +"]"
							+ " is searched." + "\n");
			if (key < list[mid]){
				high = mid -1;
			}
			else if (key == list[mid]){
				return mid;
			}else{
				low = mid + 1;
			}
			mid = (low + high)/2;
		}
	
		return -1;
	}
	
	public <E extends Comparable<E>>int genericsearch(E[] list, E key){
		int low = 0, high = list.length - 1;
		int mid = (low + high)/2;
		
		while (low <= high){
			text.appendText("low value: "+ list[low] +
					" index [" + low + "] " + "and high value" + 
					list[high] + " from index [" + high +"]"
							+ " is searched." + "\n");
			if (key.compareTo(list[mid]) <0){
				high = mid -1;
			}
			else if (key == list[mid]){
				return mid;
			}else{
				low = mid + 1;
			}
			mid = (low + high)/2;
		}
	
		return -1;
	}
	public void searchList(ActionEvent e) {
		text.setText("");
		String[] numbers = tf.getText().split("\\s");
		int key; 
		list = new Integer[numbers.length];
		try {
			for(int i = 0; i < numbers.length; i++){
				list[i] = Integer.parseInt(numbers[i]);
			}
			
			key = Integer.parseInt(keyField.getText());
			//sort the list
			//search(list, key, 0, list.length -1);
		
			//text.appendText("The index of key is "  + search(list, key, 0, list.length -1));
			text.appendText("The index of key is "  + search(list, key));
			
		} catch(Exception ex){
			
			text.appendText("Please enter numbers without leading space. ");
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}