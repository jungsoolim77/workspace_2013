package chapter21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
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


public class SetTest extends Application {
	BorderPane bp = new BorderPane();
	int WIDTH = 400, HEIGHT = 200;
	TextField tf = new TextField();
	TextField keyField = new TextField();
	TextArea text = new TextArea(" ");
	Set<String> hashSet = new HashSet<>();
	Set<String> linkedHashSet = new LinkedHashSet<>();
	Set<String> treeSet = new TreeSet<>();
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
		primaryStage.setTitle("Set Test");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public void addElement(ActionEvent e){
		String[] s =  tf.getText().split("\\s");
		for(int i = 0; i< s.length; i++){
			hashSet.add(s[i]);
			linkedHashSet.add(s[i]);
			treeSet.add(s[i]);
		}
		//add them to the other lists
		
		//treeSet.addAll(hashSet);
		
		text.setText("");
		text.appendText("Hashset is " + hashSet.toString() + "\n");
		text.appendText("LinkedHashset is " + linkedHashSet.toString() + "\n");
		text.appendText("Treeset is " + treeSet.toString() + "\n");
	
	}
	public void deleteElement(ActionEvent e){
		
		hashSet.remove(keyField.getText());
		linkedHashSet.remove(keyField.getText());
		treeSet.remove(keyField.getText());
				
		text.setText("");
		text.appendText("Hashset is " + hashSet.toString() + "\n");
		text.appendText("LinkedHashset is " + linkedHashSet.toString() + "\n");
		text.appendText("Treeset is " + treeSet.toString() + "\n");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}