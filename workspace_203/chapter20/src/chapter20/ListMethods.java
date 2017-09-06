package chapter20;

import java.util.ArrayList;
import java.util.LinkedList;
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

public class ListMethods extends Application{
	int max = 1000;
	BorderPane bp = new BorderPane();
	int WIDTH = 400, HEIGHT = 200;
	TextField tf = new TextField();
	TextField keyField = new TextField();
	TextArea text = new TextArea(" ");
	Integer[] list = null;
	
	Button addAll = new Button("Add all");
	Button removeAll = new Button("Remove All");
	Button retainAll = new Button("Retain All");
	Button contains = new Button("Contains");
	Button clear = new Button("clear");
	@Override
	
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VBox vBox = new VBox();
		HBox hBox = new HBox();
		
		hBox.getChildren().addAll(addAll, removeAll, retainAll, contains, clear);
		vBox.getChildren().addAll(new Label("Please enter elements for list 1"),
							tf, new Label("Elements for list 2"), keyField, hBox );
		
		//keyField.setOnAction(this::searchList);
		addAll.setOnAction(this::action);
		clear.setOnAction(this::action);
		removeAll.setOnAction(this::action);
		contains.setOnAction(this::action);
		retainAll.setOnAction(this::action);
		
		
		bp.setCenter(text);
		bp.setBottom(vBox);

		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("List Test");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public void action(ActionEvent e){
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		
		String[] list1Elements = tf.getText().split("\\s");
		String[] list2Elements = keyField.getText().split("\\s");
		
		for(int i = 0; i < list1Elements.length; i ++){
			list1.add(list1Elements[i]);
		}
		
		for(int i = 0; i < list2Elements.length; i ++){
			list2.add(list2Elements[i]);
		}
		
		if(e.getSource().equals(addAll)){
			list1.addAll(list2);
		}else if (e.getSource().equals(contains)){
			list1.containsAll(list2);
		}else if (e.getSource().equals(removeAll)){
			list1.removeAll(list2);
		}else if (e.getSource().equals(clear)){
			list1.clear();
		}else if (e.getSource().equals(retainAll)){
			list1.retainAll(list2);
		}
				
		text.setText("");
		text.appendText("List 1 after allAll is   " + print(list1)+ "\n");
		text.appendText("List 2 after allAll is   " + print(list2)+ "\n");
		
	}
	
	public static <E extends List> String print(E list){
		StringBuilder s = new StringBuilder();
		for(int i = 0 ; i < list.size(); i++){
			s.append((String) list.get(i));
			s.append(", ");
		}
		
		return s.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}