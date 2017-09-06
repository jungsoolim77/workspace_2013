//Patrick Flinner
//Project: Word Game
//Date: February 5, 2016


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Tester extends Application{
	public static void main(String[] args){
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Various objects for the application
		Game board=new Game();
		Pane picture=new Pane();
		BorderPane main=new BorderPane();
		Circle ball=new Circle(250,100,50,Color.WHITE);
		VBox controls=new VBox(10);
		TextField text=new TextField();
		Label guesses=new Label("Guess: ");
		String answer=board.GetAnswer();
		Label word=new Label("Answer: "+answer);
		
		//Sets some of the settings for the objects
		guesses.setFont(new Font("Arial",16));
		word.setFont(new Font("Arial",16));
		text.setMaxWidth(50);
		controls.setPadding(new Insets(10,10,10,10));
		picture.getChildren().add(ball);
		
		//When the enter button is used. The game takes the user input
		//And figures out if it is a correct guess
		text.setOnAction(e->{
			
			//Prevents an empty guess from being put in
			if(text.getText().length()!=0){
				
				//Gets the value of the input
				char guess=board.GetGuess(text.getText());
				text.clear();
				
				//Checks if the answer was guessed before
				if(board.CheckIfGuessed(guess)==false){
					
					//Checks if the guess is right
					boolean check=board.CheckGuess(guess);
					
					//If false then it adds to the guesses tab and changes the ball
					//At the end checks if the limit was reached
					if(check==false)
					{
						String wrong=board.GetWrong();
						guesses.setText("Guessed: "+wrong);
						picture.getChildren().clear();
						picture.getChildren().add(DrawHangMan(board,ball));	
						if(board.GameOver()){
							GameOver(primaryStage,board);
							
						}
					}
					else{
						String answerLam=board.GetAnswer();
						word.setText("Answer: "+answerLam);
						if(board.WinCondition())
						{
							GameWon(primaryStage);
						}
					}
					
				}
			}			
		});
		
		//Creates the control panel and puts it all together
		controls.getChildren().add(word);
		controls.getChildren().add(guesses);
		controls.getChildren().add(text);
		controls.setAlignment(Pos.BOTTOM_CENTER);
		
		//Sets up the main pane
		main.setBottom(controls);
		main.setCenter(picture);
		

		//Sets up the window and stage
		Scene scene=new Scene(main);
		primaryStage.setScene(scene);
		primaryStage.setHeight(500);
		primaryStage.setWidth(500);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Name the Country");
		primaryStage.show();

		
	}
	/*********A WINDOW POPS UP IF THE GAME IS EITHER WON OR LOST***********/
	@SuppressWarnings("static-access")
	public void GameWon(Stage primaryStage){
		//creates the objects for the new window
		Button close=new Button("Okay");
		Label label=new Label("Congratulations!! You found the word!!");
		Stage game=new Stage();
		BorderPane main=new BorderPane();
		
		//Sets it all up
		close.setAlignment(Pos.BOTTOM_CENTER);
		close.setPadding(new Insets(10,10,10,10));
		close.setDefaultButton(true);
		
		//Closes the window when close is acted upon
		//Restarts the program
		close.setOnAction(e->{
			game.close();
			try {
				start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		//Sets all the pieces up
		main.setCenter(label);
		main.setBottom(close);
		main.setAlignment(close, Pos.BOTTOM_CENTER);
		Scene scene=new Scene(main);
		
		//Sets up the stage and hides the main game window
		game.setScene(scene);
		game.setTitle("WINNER");
		game.setWidth(400);
		game.setHeight(200);
		primaryStage.close();
		game.show();
	}
	
	//Same as the above method, but for game over
	@SuppressWarnings("static-access")
	public void GameOver(Stage primaryStage,Game board){
		Button close=new Button("Okay");
		Label label=new Label("Game Over. You Did Not Guess The Word: "+board.GetWord());
		Stage gameOver=new Stage();
		BorderPane main=new BorderPane();
		close.setAlignment(Pos.BOTTOM_CENTER);
		close.setPadding(new Insets(10,10,10,10));
		close.setDefaultButton(true);
		close.setOnAction(e->{
			gameOver.close();
			try {
				start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		main.setCenter(label);
		main.setBottom(close);
		main.setAlignment(close, Pos.BOTTOM_CENTER);
		Scene scene=new Scene(main);
		
		gameOver.setScene(scene);
		gameOver.setTitle("GAME OVER");
		gameOver.setWidth(400);
		gameOver.setHeight(200);
		primaryStage.close();
		gameOver.show();
	}
	//Draws the ball bouncing
	//Was Changed from a hangman
	//Ball was much simpler to draw. Just changes color and moves down
	public Circle DrawHangMan(Game board,Circle head){
		int counter=board.GetCounter();
		
		if(counter==1){
			head.setCenterX(250);
			head.setCenterY(125);
			head.setFill(Color.RED);
		}
		else if(counter==2){
			head.setCenterX(250);
			head.setCenterY(150);
			head.setFill(Color.BLUE);
		}
		else if(counter==3){
			head.setCenterX(250);
			head.setCenterY(175);
			head.setFill(Color.GREEN);
		}
		else if(counter==4){
			head.setCenterX(250);
			head.setCenterY(200);
			head.setFill(Color.BLACK);
		}
		else if(counter==5){
			head.setCenterX(250);
			head.setCenterY(225);
			head.setFill(Color.PURPLE);
		}
		else if(counter==6){
			head.setCenterX(250);
			head.setCenterY(250);
			head.setFill(Color.YELLOW);
		}
		else if(counter==7){
			head.setCenterX(250);
			head.setCenterY(275);
			head.setFill(Color.ORANGE);
		}
		
		return head;
	}
}

