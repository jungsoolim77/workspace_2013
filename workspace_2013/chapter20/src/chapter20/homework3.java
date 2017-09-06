package chapter20;



import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class homework3 extends Application {

	
	Text txtHidden = new Text("Test");
	Text txtBadGuesses = new Text("Test 2");
	String targetWord;
	Circle circle = new Circle();
	ArrayList<String> hiddenWord = new ArrayList<>();
	ArrayList<String> badGuesses = new ArrayList<>();
	int guesses = 0;
	String[] words = { 
			"java",
			"programming",
			"lineage",
			"goldfish",
			"paper",
			"computer"
	};
	public static void main(String[] args) {
		
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		if(guesses == 0) {
			setupGame();
		}
		Pane pane = new Pane();
		pane.getChildren().clear();
		pane.getChildren().add(txtHidden);
		txtHidden.setLayoutX(10);
		txtHidden.setLayoutY(490);
		
		pane.getChildren().add(txtBadGuesses);
		txtBadGuesses.setLayoutX(10);
		txtBadGuesses.setLayoutY(510);
		
		pane.getChildren().add(circle);
		circle.setCenterX(150);
		circle.setCenterY(35 * (guesses + 1));
		circle.setRadius(25);
		circle.setStrokeWidth(1);
		circle.setFill(Color.PURPLE);
		
		stage.setHeight(600);
		stage.setWidth(400);
		txtHidden.setOnKeyPressed(e ->	
			{
				String current = e.getCode().toString();
				boolean goodAnswer = false;
				if(guesses >= 7) {
					
					if(e.getCode() == KeyCode.ENTER) {
						endGame();
					}
				}
				else {
					for(int k = 0; k < targetWord.length(); k++) {
						String letter = targetWord.substring(k, k + 1).toUpperCase();
						if(current.equals(letter) ){
							goodAnswer = true;
							hiddenWord.set(k, current);
						}
					}
					if(!goodAnswer) {
						if(badGuesses.size() == 0) {
							badGuesses.add(current);
						}
						boolean exists = false;
						for(int i = 0; i < badGuesses.size(); i++) {
							String letter = badGuesses.get(i);
							if(current.equals(letter)) {
								exists = true;
								break;
							}
							
						}
						if(!exists) {
	 						guesses++;
							circle.setCenterY(35 * (guesses + 1));
							badGuesses.add(current);
						}
					}
				}
				txtHidden.setText(hiddenWord.toString());
				boolean win = true;
				for(int n = 0; n < hiddenWord.size(); n++) {
					if(hiddenWord.get(n).equals("*")) {
						win = false;
						break;
					}
				}
				
				txtBadGuesses.setText("Guesses: " + guesses + " Letters Guessed: " + badGuesses.toString());
				if(win){
					txtBadGuesses.setText("You Win! Press Enter to play again.");
					guesses = 7;
				}
				else if(guesses >= 7) {
					txtBadGuesses.setText("Game Over. Press Enter to play again.");
				}
			}		
		);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		txtHidden.requestFocus();
	}
	
	public void setupGame() {
		Random random = new Random();
		int index = random.nextInt(words.length - 1);
		targetWord = words[index];
		for(int i = 0; i < targetWord.length(); i++) {
			hiddenWord.add("*");
		}
		txtHidden.setText(hiddenWord.toString());
		txtBadGuesses.setText("Guesses: " + guesses + " Letters Guessed: none");
	}
	
	public void endGame() {
		guesses = 0;
		hiddenWord.clear();
		badGuesses.clear();
		circle.setCenterY(35 * (guesses + 1));
		setupGame();
	}
}
