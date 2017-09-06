package chapter20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class ListTest extends Application {
	int max = 3000000;
	BorderPane bp = new BorderPane();
	int WIDTH = 600, HEIGHT = 200;
	TextField tf = new TextField();
	TextField keyField = new TextField();
	TextArea text = new TextArea(" ");
	Integer[] list = null;
	ArrayList<Integer> arrayList = new ArrayList<>();
	LinkedList<Integer> linkedList = new LinkedList<>();
	
	Button delete = new Button("Delete");
	Button add = new Button("Add");
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VBox vBox = new VBox();
		HBox hBox = new HBox();
		hBox.getChildren().addAll(delete, add);
		hBox.setAlignment(Pos.CENTER);
		text.setFont(Font.font(20));
		
		vBox.getChildren().addAll(new Label("Please enter number between 1 to 2 million"),
							tf, hBox);
		
		for(int i = 0; i < max; i++){
			arrayList.add(i);
			linkedList.add(i);
			
		}
		//keyField.setOnAction(this::searchList);
		delete.setOnAction(this::deleteElement);
		add.setOnAction(this::addElement);
		bp.setBottom(vBox);
		bp.setCenter(text);

//		test();
		
		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("List Test");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public void deleteElement(ActionEvent e){
		int x = Integer.parseInt(tf.getText());
		text.setText("");
		text.appendText("To delete from array it takes  " + deleteArray(x) + " milliseconds." + "\n");
		text.appendText("To delete from linked list it takes  " + deleteLinkedList(x) + " milliseconds." + "\n");
	}
	
	public long deleteArray(int x){
		long start = System.currentTimeMillis();
		
		arrayList.remove(x);
		
		return System.currentTimeMillis() - start;
	}
	
	public long deleteLinkedList(int x){
		long start = System.currentTimeMillis();
		
		linkedList.remove(x);
		
		return System.currentTimeMillis() - start;
	}
	
	public void addElement(ActionEvent e){
		int x = Integer.parseInt(tf.getText());
		text.setText("");
		text.appendText("To add to array it takes  " + addArray(x) + " milliseconds." + "\n");
		text.appendText("To add to linked list it takes  " + addLinkedList(x) + " milliseconds." + "\n");
	}
	
	public long addArray(int x){
		long start = System.currentTimeMillis();
		
		arrayList.add(x, x);
						
		return System.currentTimeMillis() - start;
	}
	
	public long addLinkedList(int x){
		long start = System.currentTimeMillis();
		
		linkedList.add(x, x);
		
		return System.currentTimeMillis() - start;
	}
	
	public void test(){
		HashSet<String> hs = new HashSet<>();
		hs.add("red");
		hs.add("yellow");
		hs.add("green");
		hs.add("blue");
		hs.add("orange");
		hs.add("red");
		
		LinkedHashSet<String> lh = new LinkedHashSet<>();
		lh.add("red");
		lh.add("yellow");
		lh.add("green");
		lh.add("blue");
		lh.add("orange");
		
		TreeSet<String> ts = new TreeSet<>();
		ts.add("red");
		ts.add("yellow");
		ts.add("green");
		ts.add("blue");
		ts.add("orange");
		
		HashMap<String, String> hm = new HashMap<>();
		
		hm.put("one", "red");
		hm.put("two", "red");
		hm.put("three", "yellow");
		hm.put("four", "green");
		hm.put("five", "blue");
		hm.put("six", "orange");
		
		LinkedHashMap<String, String> lm = new LinkedHashMap<>();
		
		lm.put("one", "red");
		lm.put("two", "red");
		lm.put("three", "yellow");
		lm.put("four", "green");
		lm.put("five", "blue");
		lm.put("six", "orange");
		
		TreeMap<String, String> tm = new TreeMap<>();
		
		tm.put("one", "red");
		tm.put("two", "red");
		tm.put("three", "yellow");
		tm.put("four", "green");
		tm.put("five", "blue");
		tm.put("six", "orange");
		
		System.out.println("HashSet List is " + hs);
		System.out.println("LinkedHashSet List is " + lh);
		System.out.println("TreeSet List is " + ts + "\n");
		
		System.out.println("HashMap List is " + hm);
		System.out.println("LinkedHashMap List is " + lm);
		System.out.println("TreeMap List is " + tm);
	}
	
	
	
	public void test20_11(){
		List<String> list1 = Arrays.asList("red","yello","green");
		List<String> list2 = Arrays.asList("red","yello","blue");
		
//		list1.add(list2);
//		list1.remove(list2);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}