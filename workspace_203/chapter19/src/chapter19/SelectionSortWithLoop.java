package chapter19;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class SelectionSortWithLoop extends Application {
	BorderPane bp = new BorderPane();
	int WIDTH = 400, HEIGHT = 200;
	TextField tf = new TextField();
	TextArea text = new TextArea(" ");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hBox = new HBox();
		
		hBox.getChildren().addAll(new Label("Please enter numbers to sort. "), tf);
		
		tf.setOnAction(this::sortList);
		bp.setBottom(hBox);
		bp.setCenter(text);

		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("Selection Sort with loop");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	/**
	 * recursive function
	 */
	public static void sort(Double[] list, int low, int high){
		if(low < high){
			int indexOfMin = low;
			Double min = list[low];
			for(int i = low + 1; i <=high; i++){
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
	/**
	 * non-recursive sort (Insertion sort)
	 */
	public static <E extends Comparable<E>> void sort(E[] list) {
		  for (int i = 0; i < list.length; i++) {
		      /** insert list[i] into a sorted sublist list[0..i-1] so that
		           list[0..i] is sorted. */
		      E currentElement = list[i];
		      int k;
		      for (k = i - 1; k >= 0 && list[k].compareTo(currentElement) > 0; k--) {
		        list[k + 1] = list[k];
		      }

		      // Insert the current element into list[k+1]
		      list[k + 1] = currentElement;
		    }
		 }
		
	
	/**
	 * non-recursive sort (Selection sort)
	 * @param list
	 */
	public static <E extends Comparable<E>> void sortSelection(E[] list) {
		  int index = 0;
		  E min = list[0];
		  for (int i = 0; i < list.length -1; i++) {
		      index = i;
		      min = list[i];
		      for (int k = i + 1; k < list.length; k++) {
		    	  if (list[k].compareTo(min) < 0){
		    		  index = k;
		    		  min = list[k];
		    	  }
		       }
		      list[index] = list[i];
		      list[i] = min;
		     }
		 }
	
	
	
	
	public void sortList(ActionEvent e) {
		text.setText("");
		String[] elements = tf.getText().split("\\s");
		//non-recursive generic sort
		//sort(elements);
		sortSelection(elements);
		//print out
		for (int j = 0; j < elements.length; j++){
			text.appendText(elements[j] + "  ");
		}
			
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}