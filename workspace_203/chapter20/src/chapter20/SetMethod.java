package chapter20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SetMethod extends Application{
	int max = 2000;
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
		vBox.getChildren().addAll(new Label("Please enter elements for list 2"),
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
				
		Set<String> hSet1 = new HashSet<>();
		Set<String> lSet1 = new LinkedHashSet<>();
		Set<String> tSet1 = new TreeSet<>();
				
		Set<String> hSet2 = new HashSet<>();
		Set<String> lSet2 = new LinkedHashSet<>();
		Set<String> tSet2 = new TreeSet<>();
				
		
		String[] list1Elements = tf.getText().split("\\s");
		String[] list2Elements = keyField.getText().split("\\s");
		
		for(int i = 0; i < list1Elements.length; i ++){
			hSet1.add(list1Elements[i]);
			lSet1.add(list1Elements[i]);
			tSet1.add(list1Elements[i]);
		}
		
		for(int i = 0; i < list2Elements.length; i ++){
			hSet2.add(list2Elements[i]);
			lSet2.add(list2Elements[i]);
			tSet2.add(list2Elements[i]);
		}
		
		if(e.getSource().equals(addAll)){
			hSet1.addAll(hSet2);
		}else if (e.getSource().equals(contains)){
			hSet1.containsAll(hSet2);
		}else if (e.getSource().equals(removeAll)){
			hSet1.removeAll(hSet2);
		}else if (e.getSource().equals(clear)){
			hSet1.clear();
		}else if (e.getSource().equals(retainAll)){
			hSet1.retainAll(hSet2);
		}
				
		text.setText("");
		text.appendText("List 1 after allAll is   " + hSet1.toString() + "\n");
		text.appendText("List 2 after allAll is   " + hSet2.toString() + "\n");
		
	}
	
	public static <E extends Set> String print(E set){
		StringBuilder s = new StringBuilder();
		for(int i = 0 ; i < set.size(); i++){
			//s.append((String) set..get(i) + ",  ");
		}
		
		return s.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}