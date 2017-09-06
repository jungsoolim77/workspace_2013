package chapter20;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class ListTest extends Application {
	int max = 10000000;
	BorderPane bp = new BorderPane();
	int WIDTH = 400, HEIGHT = 200;
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
		
		vBox.getChildren().addAll(new Label("Please enter number between 1 to 10 million"),
							tf, delete, add);
		
		for(int i = 0; i < max; i++){
			arrayList.add(i);
			linkedList.add(i);
		}
		//keyField.setOnAction(this::searchList);
		delete.setOnAction(this::deleteElement);
		add.setOnAction(this::addElement);
		bp.setBottom(vBox);
		bp.setCenter(text);

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
		
		arrayList.add(x);
				
		return System.currentTimeMillis() - start;
	}
	
	public long addLinkedList(int x){
		long start = System.currentTimeMillis();
		
		linkedList.add(x);
		
		return System.currentTimeMillis() - start;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}