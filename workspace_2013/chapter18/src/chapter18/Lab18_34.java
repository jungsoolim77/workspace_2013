package chapter18;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Lab18_34 extends Application {
	int SIZE = 8;
	int WIDTH = 400, HEIGHT = 200;
	ChessBoard cb = new ChessBoard(SIZE);
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Scene scene = new Scene(cb, WIDTH, HEIGHT);
		primaryStage.setTitle("Eight Queens");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}

class ChessBoard extends GridPane{
	int size;
	int gap = 5;
	GridPane gp = null; 
	int[][] cell;  
	ChessBoard(int size){
		this.size = size;
		gp = new GridPane();
		cell = new int[size][size];
	}
	
	public boolean isConflict(){
		return false;
	}
	
}
