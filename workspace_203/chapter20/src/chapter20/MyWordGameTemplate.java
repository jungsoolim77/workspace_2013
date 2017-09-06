package chapter20;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MyWordGameTemplate extends Application {
	int WIDTH =500, HEIGHT = 600;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		GamePane gp = new GamePane();
		Scene scene = new Scene(gp, WIDTH, HEIGHT);
	    primaryStage.setTitle("Word Puzzle"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	    gp.requestFocus();

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

}

class GamePane extends Pane{
	int count = 0;
	String[] dictionary = {"apple", "orange",""};
	GamePane(){
	this.setOnKeyPressed( e -> {
        if (e.getCode() == KeyCode.ENTER ) {
//        	restart a game
        	init();

        } else if (e.getCode().isLetterKey()){
//          user entered a letter. please process the input
        	processInput(e.getText().charAt(0));
        	paint();
        }
       });
	}
	
	public void processInput(char ch){
//		Character c = ch.charAt(0);
		System.out.println(ch);
		
	}
	public void init(){
		count = 0;
		this.getChildren().clear();
	}
	public void paint(){
    	int x = 150, y = 100 + count*100, radius = 50;
    	this.getChildren().clear();
    	Circle circle = new Circle();
    	circle.setCenterY(y);
   	 	circle.setRadius(radius);
	   	circle.setStroke(Color.rgb(100, 250, 100));
	   	circle.setFill(Color.rgb(200, 10, 130));
	   	circle.centerXProperty().bind(this.widthProperty().divide(2));
	   	this.getChildren().add(circle);
	   	count++;
	}
}
