package chapter20;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class  MyGame2 extends Application {
  int WIDTH =500, HEIGHT = 600;
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {       
	  GamePane pane = new GamePane();
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, WIDTH, HEIGHT);
    primaryStage.setTitle("Word Puzzle"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    pane.requestFocus();
  }
  public static void main(String[] args) {
	    launch(args);
  }

  class GamePane extends Pane {
	  
	String[] words = { "write", "program", "that", "receive", "positive",
		        "excellent", "linger", "violin", "strange", "holiday", "twilight",
		        "school", "teacher", "tutor", "mother"};
		
	LinkedHashMap<Integer, String> hiddenWordMap = new LinkedHashMap<>();
	ArrayList<String> guessedWordList = new ArrayList<>();
	LinkedHashSet<String> missedLetterSet = new LinkedHashSet<>();
	
	double numberOfCorrectLettersGuessed = 0, numberOfMisses = 0;
	boolean isMissed = false;
	
	double Y = 100.0, padding = 50.0;
	double radius = 40;	
	
    public GamePane() {
 
      setNewHiddenWord();
      paint();
            
      this.setOnKeyPressed( e -> {
        if (e.getCode() == KeyCode.ENTER || numberOfMisses == 7) {
          setNewHiddenWord();
        } else if (e.getCode().isLetterKey()){
          processAGuessedLetter(e.getText().charAt(0) + "");
        }
        paint();
       });
    }

    void setNewHiddenWord() {
       //get hidden word
        int index = (int)(Math.random() * words.length);
    	//int index = 0;
        System.out.println(words[index]);
        
        for (int i = 0; i < words[index].length(); i++){
        	hiddenWordMap.put(i, words[index].charAt(i) + "");
        }
        //set missed list and guessed word
        missedLetterSet.clear();
        guessedWordList.clear();
        for (int i = 0; i < words[index].length(); i++){
             guessedWordList.add("*");
        }
        numberOfMisses = 0;
        isMissed = false;
        Y = 100;
    }
    
    void processAGuessedLetter(String letter) {
    	if(guessedWordList.contains(letter)){
    		System.out.println("Your letter " + letter + " has been entered already!");
    	}else if(missedLetterSet.contains(letter)){
    		System.out.println("You have entered this letter before " + letter);
    	}else if(hiddenWordMap.containsValue(letter)){
    		for(int i = 0; i < hiddenWordMap.size(); i++){
    			if(hiddenWordMap.get(i).equals(letter)){
    				guessedWordList.remove(i);
    				guessedWordList.add(i,letter);
    			}
    		}
    		
    		numberOfCorrectLettersGuessed++;
    	}else {
    		missedLetterSet.add(letter);
    		isMissed = true;
    		numberOfMisses++;
     	}
    	
    }
    
   
    
    public void paint(){
    	int x = 150, y = 500;
    	this.getChildren().clear();
    	Circle circle = new Circle();
    	circle.setCenterY(Y);
   	 	circle.setRadius(radius);
	   	circle.setStroke(Color.rgb(100, 100, 100));
	   	circle.setFill(Color.rgb(0, (int)(10 + numberOfMisses*30), (int)(0 + numberOfMisses*30)));
	   	circle.centerXProperty().bind(this.widthProperty().divide(2));
	   	this.getChildren().add(circle);
	   	
	   	Line line = new Line();
	   	PathTransition pt = new PathTransition();
	   	pt.setDuration(Duration.millis(400));
	   	pt.setNode(circle);
	
	   	line.startXProperty().bind(this.widthProperty().divide(2));
		line.endXProperty().bind(this.widthProperty().divide(2));
	   			  	
	   	if (!guessedWordList.contains("*")) {
	          // Display the guessed word
	          this.getChildren().add(new Text(x, y,  "The word is: " + guessedWordList.toString()));
	          this.getChildren().add(new Text(x, y+20,  "Good Job!"));
	          this.getChildren().add(new Text(x, y+40, "To continue the game, press ENTER"));
	    } else if (missedLetterSet.size() == 7){
	    	//missed 7 times
	    	this.getChildren().add(new Text(x, y,  "The word is: " + guessedWordList.toString()));
	    	this.getChildren().add(new Text(x, y + 20,  "You missed 7 times."));
	    	this.getChildren().add(new Text(x, y + 40, "Missed letters: " + missedLetterSet.toString()));
	        this.getChildren().add(new Text(x, y + 60, "To continue the game, press ENTER"));
	    } else 	{
	    	   // Display the guessed word
	    	this.getChildren().add(new Text(x, y, "Guess a word: " + guessedWordList.toString()));
	    	if(missedLetterSet.size()>0){
	    		this.getChildren().add(new Text(x, y +20, "Missed letters: " + missedLetterSet.toString()));
	    	}

	        if (isMissed){
	        	line.setStartY(Y);
	    	   	line.setEndY(Y+=padding);
	    	   	pt.setPath(line);
	            pt.play();
	        }
	        isMissed = false;
	      }
	   	
    }
    
  }
}
  
 
 

