package chapter18;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Palindrome extends Application {
	BorderPane bp = new BorderPane();
	int WIDTH = 400, HEIGHT = 200;
	TextField tf = new TextField();
	TextArea text = new TextArea(" ");
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hBox = new HBox();
		
		hBox.getChildren().addAll(new Label("Please palindrom string "), tf);
		
		tf.setOnAction(this::checkPalindrome);
		bp.setBottom(hBox);
		bp.setCenter(text);

		Scene scene = new Scene(bp, WIDTH, HEIGHT);
		primaryStage.setTitle("Palindrom");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	/*
	 * recursive function
	 */
	public static boolean isPalindrome(String s){
		if (s.length() <= 1){
			return true;
		}else if (s.charAt(0) != s.charAt(s.length()-1)){
			return false;
		}else{
			return isPalindrome(s.substring(1, s.length() - 1));
		}
	}
	
	public void checkPalindrome(ActionEvent e){
		text.setText("");
		
		if (isPalindrome(tf.getText()))
			text.appendText(tf.getText() + " is a palindrome.");
		else
			text.appendText(tf.getText() + "is not palindrome.");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}
