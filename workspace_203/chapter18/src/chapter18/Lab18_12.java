package chapter18;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Lab18_12 extends Application {
	BorderPane bp = new BorderPane();
	int WIDTH = 400, HEIGHT = 200;
	TextField tf = new TextField();
	TextArea text = new TextArea(" ");
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hBox = new HBox();
		
		hBox.getChildren().addAll(new Label("Please enter the text "), tf);
		
		tf.setOnAction(this::print);
		bp.setBottom(hBox);
		bp.setCenter(text);

		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("Reverse string");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public void print(ActionEvent e){
		text.setText("");
		reverseDisplay(tf.getText());
	}
	public void reverseDisplay(String value){
		
		reverseDiaplay(value, value.length()-1);
	}
	public void reverseDiaplay(String value, int high){
		text.appendText(" reverseDisplay (" + value + ", " + high + ")was called \n"); 
		/*
		if (high >= 1){
			text.appendText(value.substring(high, high + 1));
			reverseDiaplay(value, high - 1);
		}else
			text.appendText(value.substring(0,1));
			*/
		
		if (high == 0)
			text.appendText(value.substring(0,1));
		else{
			text.appendText(value.substring(high, high + 1));
			reverseDiaplay(value, high - 1);
		}
			
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}