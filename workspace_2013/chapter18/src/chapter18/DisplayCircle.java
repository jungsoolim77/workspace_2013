package chapter18;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DisplayCircle extends Application {
	StackPane pane = new StackPane();
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		displayCircle(300);

		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Display Circle"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); 
	}
	
	public void displayCircle(int radius){
		if(radius*2 >20){
			Circle c = new Circle();
			c.setRadius(radius);
			c.setStroke(Color.AQUAMARINE);
			c.setStrokeWidth(1);
			c.setFill(Color.WHITE);
			pane.getChildren().add(c);
//	Recursive call		
			displayCircle(radius - 20);
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
