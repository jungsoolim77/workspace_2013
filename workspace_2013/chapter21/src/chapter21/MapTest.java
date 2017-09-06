package chapter21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class MapTest extends Application {
	
	BorderPane bp = new BorderPane();
	int WIDTH = 400, HEIGHT = 200;
	TextField tf = new TextField();
	TextField keyField = new TextField();
	TextArea text = new TextArea(" ");
	Map<String, Integer> hashMap = new HashMap<>();
	Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
	Map<String, Integer> treeMap = new TreeMap<>();
	Button delete = new Button("Delete");
	Button add = new Button("Add");
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VBox vBox = new VBox();
		
		vBox.getChildren().addAll(new Label("Please enter elements to add"),
							tf, new Label("Please enter item to delete"),keyField, add, delete);
		
		delete.setOnAction(this::deleteElement);
		add.setOnAction(this::addElement);
		bp.setBottom(vBox);
		bp.setCenter(text);
		text.setFont(Font.font(20));
		tf.setFont(Font.font(16));
		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("Map Test");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public void addElement(ActionEvent e){
		String[] s =  tf.getText().split("\\s");
		hashMap.clear();
		linkedHashMap.clear();
		treeMap.clear();
		for(int i = 0; i< s.length; i++){
			hashMap.put(s[i],  i);
			linkedHashMap.put(s[i],  i);
			treeMap.put(s[i],  i);
		}
		
		//linkedHashMap.putAll(hashMap);
		//treeMap.putAll(hashMap);
		text.setText("");
		text.appendText("HashMap is " + hashMap.toString() + "\n");
		text.appendText("LinkedHashMap is " + linkedHashMap.toString() + "\n");
		text.appendText("TreeMap is " + treeMap.toString() + "\n");
	
	}
	public void deleteElement(ActionEvent e){
				
		hashMap.remove(keyField.getText());
		linkedHashMap.remove(keyField.getText());
		treeMap.remove(keyField.getText());
				
		text.setText("");
		text.appendText("Hashset is " + hashMap.toString() + "\n");
		text.appendText("LinkedHashset is " + linkedHashMap.toString() + "\n");
		text.appendText("Treeset is " + treeMap.toString() + "\n");
	}
	
	
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}