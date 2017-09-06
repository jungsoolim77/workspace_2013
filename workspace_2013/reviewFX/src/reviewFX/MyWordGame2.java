package reviewFX;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyWordGame2 extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MyPane mp = new MyPane();
		Scene scene = new Scene(mp,400,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Please guess a word...");
		primaryStage.show();
		mp.requestFocus();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}
}

class MyPane extends Pane{
	String[] list = {"Java", "is", "fun"};
	LinkedHashSet<Character> missedLetters = new LinkedHashSet<>();
	LinkedHashMap<Integer, Character> hiddenWord = new LinkedHashMap<>();
	ArrayList<Character> placeHolder = new ArrayList<>();
	public MyPane(){
		restart();
		this.setOnKeyPressed(e->{
			this.getChildren().clear();
			if(e.getCode()==KeyCode.ENTER || (missedLetters.size() >= 7)){
				restart();
//			We need to restart the game
				
			}else if(e.getCode().isLetterKey()||
					(e.getCode()==KeyCode.EXCLAMATION_MARK)){
				processInput(e.getText().charAt(0));
//				We need to process input
				Text temp = new Text(100,100,
						"The letter you typed is " + e.getText());
				temp.setFont(Font.font(20));
				this.getChildren().add(temp);
				Circle c = new Circle();
				c.setFill(Color.GREEN);
				c.setRadius(30);
				c.setCenterX(50);
				c.setCenterY(150);
				this.getChildren().add(c);
			}
		});
	}
	
	public void restart(){
		int index = (int) (Math.random()*list.length);
		hiddenWord.clear();
		placeHolder.clear();
		missedLetters.clear();
		for(int i =0; i<list[index].length(); i++){
			hiddenWord.put(i, list[index].charAt(i));
			placeHolder.add('*');
		}
		
		System.out.print(list[index] + " " 
				+ hiddenWord.toString() + " " 
				+placeHolder.toString());
		
	}
	
	public void processInput(Character c){
		
	}
}
