package chapter20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyUniqueList extends Application {
	BorderPane bp = new BorderPane();
	int WIDTH = 400, HEIGHT = 200;
	TextField tf = new TextField();
	TextField keyField = new TextField();
	TextField allField = new TextField();
	TextArea text = new TextArea(" ");
	
	List<String> list = new ArrayList<String>();
	List<String> allList = new LinkedList<String>();
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VBox vbox = new VBox();
		vbox.getChildren().addAll(new Label("Please enter elements to make a set"), tf, 
				new Label("Please enter elements to display."), allField);
		bp.setCenter(text);
		bp.setBottom(vbox);
		tf.setOnAction(this::makeSet);
		allField.setOnAction(this::printList);
		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("Make a Set");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void printList(ActionEvent e){
		String[] s = allField.getText().split("\\s+");
		
		for(int i = 0; i < s.length; i++){
			allList.add(s[i]);
		}

		text.clear();
		
		text.setText(allList.toString());
		
		Iterator iterator = allList.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}
	public void makeSet(ActionEvent e){
		String[] s = tf.getText().split("\\s+");
		//sortSelection(s);
		
		for(int i = 0; i < s.length; i++){
			if (!list.contains(s[i]))
				list.add(s[i]);
		}
			
//		sortSelection(list);
		Collections.sort(list);
		text.clear();
				
		Iterator iterator = list.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		
		text.setText(list.toString());
		
	}
	
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
	
	public static <E extends Comparable<E>> void sortSelection(List<E> list) {
		  int index = 0;
		  E min = list.get(0);
		  for (int i = 0; i < list.size() -1; i++) {
		      index = i;
		      min = list.get(i);
		      for (int k = i + 1; k < list.size(); k++) {
		    	  if (list.get(k).compareTo(min) < 0){
		    		  index = k;
		    		  min = list.get(k);
		    	  }
		       }
		      
		      E temp = list.remove(i);
		      list.add(i, min);
		      list.remove(index);
		      list.add(index, temp);
	
		     }
		 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
